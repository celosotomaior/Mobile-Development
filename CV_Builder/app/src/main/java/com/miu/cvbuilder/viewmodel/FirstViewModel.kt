package com.miu.cvbuilder.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FirstViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val mainViewModelJob = Job()

    override val coroutineContext = Dispatchers.Main + mainViewModelJob

    private val TAG: String = this::class.java.simpleName

    /*
    Cached list of resume with a private setter
    so that it can only be read from other classes,
    but not modified.
     */
    val resumesList: LiveData<List<Resume>>
    /*
    The main view model extends AndroidViewModel,
    so it gets an instance of application in its constructor.
    We use this to initialize the repository,
    which in turn initializes the database.
     */
    private var repository: LocalRepository = LocalRepository(getApplication())

    init {
        resumesList = repository.getAllResume()
    }

    fun deleteResume(resume: Resume) = launch {
        repository.deleteResume(resume)
    }

    fun getResumeForId(resumeId: Long): Resume = repository.getSingleResumeForId(resumeId)

    fun getEducationForResume(resumeId: Long): List<Education> = repository.getAllEducationForResumeOnce(resumeId)

    fun getExperienceForResume(resumeId: Long): List<Experience> = repository.getAllExperienceForResumeOnce(resumeId)

    fun getProjectForResume(resumeId: Long): List<Project> = repository.getAllProjectsForResumeOnce(resumeId)

