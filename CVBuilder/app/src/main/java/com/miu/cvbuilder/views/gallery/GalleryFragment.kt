package com.miu.cvbuilder.views.gallery

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.miu.cvbuilder.R
import com.miu.cvbuilder.views.aboutme.fragments.*

@Suppress("DEPRECATION")
class GalleryFragment : Fragment() {

    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction
    lateinit var thisContext: FragmentActivity
    lateinit var btnMain: Button
    lateinit var btnAboutMe: Button
    lateinit var btnExperience: Button
    lateinit var btnHobbies: Button
    lateinit var btnContact: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        fmanager = thisContext.supportFragmentManager
        btnMain = root.findViewById(R.id.btnMain) as Button
//        btnAboutMe = root.findViewById(R.id.aboutMe) as Button
        btnExperience = root.findViewById(R.id.btnExperience) as Button
//        btnHobbies = root.findViewById(R.id.btnExperience) as Button
//        btnContact = root.findViewById(R.id.btnExperience) as Button

        btnMain.setOnClickListener {
            main()
        }

//        btnAboutMe.setOnClickListener {
//            education()
//        }
//
        btnExperience.setOnClickListener {
            experience()
        }
//
//        btnHobbies.setOnClickListener {
//            hobbies()
//        }

//        btnContact.setOnClickListener {
//            contact()
//        }

        main()
        return root
    }

    override fun onAttach(activity: Activity) {
        thisContext = activity as FragmentActivity
        super.onAttach(activity)
    }

    private fun main() {
        tx = fmanager.beginTransaction()
        tx.replace(R.id.frame1, IntroFragment())
        tx.commit()
    }

//    private fun education() {
//        tx = fmanager.beginTransaction()
//        tx.replace(R.id.frame1, EducationFragment())
//        tx.commit()
//    }

    private fun experience() {
        tx = fmanager.beginTransaction()
        tx.replace(R.id.frame1, ExperienceFragment())
        tx.commit()
    }
//
//    private fun hobbies() {
//        tx = fmanager.beginTransaction()
//        tx.replace(R.id.frame1, HobbyFragment())
//        tx.commit()
//    }

    private fun contact() {
        tx = fmanager.beginTransaction()
        tx.replace(R.id.frame1, ContactFragment())
        tx.commit()
    }
}