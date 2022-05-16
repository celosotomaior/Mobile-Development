package com.miu.cvbuilder.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.miu.cvbuilder.R
import com.miu.cvbuilder.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }

    private val mainActivityJob = Job()
    override val coroutineContext = Dispatchers.Main + mainActivityJob

    private val TAG = this::class.java.simpleName
    private lateinit var mainViewModel: MainViewModel
    private lateinit var resumeAdapter: ResumeAdapter
    private lateinit var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager
    private lateinit var resumesRecyclerView: androidx.recyclerview.widget.RecyclerView
    private lateinit var webView: WebView


    companion object {
        const val EXTRA_RESUME_ID: String = "resumeId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(mainActivityToolbar)
        collapsingToolbarLayout.title = resources.getString(R.string.app_name)

        mainViewModel = ViewModelProviders
            .of(this)
            .get(MainViewModel::class.java)

        resumesRecyclerView = findViewById(R.id.resumesListRecyclerView)
        webView = WebView(this)

        setupRecyclerView()

        mainViewModel.resumesList
            .observe(this, Observer {
                resumeAdapter.updateResumesList(it ?: emptyList())
                toggleNoResumesLayout(it?.size ?: 0)
            })

        addResumeFab.setOnClickListener {
            val newResumeId: Long = -1
            val intent = Intent(this, CreateResumeActivity::class.java)
            intent.putExtra(EXTRA_RESUME_ID, newResumeId)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        val span = SpannableString("About")
        span.setSpan(ForegroundColorSpan(Color.BLACK), 0, span.length, 0)
        menu?.getItem(0)?.title = span
        return true
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            R.id.about -> {
                startActivity(Intent(this, AboutUsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun toggleNoResumesLayout(size: Int) {
        if (size > 0) {
            resumesListRecyclerView.visible()
            noResumesView.invisible()
        } else {
            resumesListRecyclerView.invisible()
            noResumesView.visible()
            mainActivityAppbarLayout.setExpanded(true, true)
        }
    }

    private fun setupRecyclerView() {
        resumeAdapter = ResumeAdapter { resumeId: Long ->
            val intent = Intent(this, CreateResumeActivity::class.java)
            intent.putExtra(EXTRA_RESUME_ID, resumeId)
            startActivity(intent)
        }
        linearLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        val dividerItemDecoration = androidx.recyclerview.widget.DividerItemDecoration(resumesRecyclerView.context, linearLayoutManager.orientation)
        this.getDrawable(R.drawable.list_divider)?.let { dividerItemDecoration.setDrawable(it) }
        resumesRecyclerView.apply {
            adapter = resumeAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(dividerItemDecoration)
        }
        val itemTouchHelper = ItemTouchHelper(object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewholder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewholder.adapterPosition
                val id: Long = resumeAdapter.getResumeAtPosition(position).id
                if (direction == ItemTouchHelper.LEFT) {
                    AlertDialog.Builder(ContextThemeWrapper(this@MainActivity, R.style.Theme_Material3_Dark))
                        .setMessage("Are you sure you want to delete this resume?")
                        .setPositiveButton("Yes") { _, _ ->
                            mainViewModel.deleteResume(resumeAdapter.getResumeAtPosition(position))
                        }
                        .setNegativeButton("No") { dialog, _ ->
                            resumeAdapter.notifyItemChanged(position)
                            dialog.dismiss()
                        }
                        .create()
                        .show()
                } else {
                    launch {
                        lateinit var resume: Resume
                        lateinit var educationList: List<Education>
                        lateinit var experienceList: List<Experience>
                        lateinit var projectList: List<Project>
                        lateinit var html: String

                        withContext(AppDispatchers.diskDispatcher) {
                            resume = mainViewModel.getResumeForId(id)
                            educationList = mainViewModel.getEducationForResume(id)
                            experienceList = mainViewModel.getExperienceForResume(id)
                            projectList = mainViewModel.getProjectForResume(id)
                        }
                        withContext(AppDispatchers.computationDispatcher) {
                            html = buildHtml(resume, educationList, experienceList, projectList)
                        }

                        webView = WebView(this@MainActivity)
                        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null)
                        webView.createPrintJob(this@MainActivity)
                        resumeAdapter.notifyItemChanged(position)
                    }
                }
            }
        })
        itemTouchHelper.attachToRecyclerView(resumesRecyclerView)
    }
}