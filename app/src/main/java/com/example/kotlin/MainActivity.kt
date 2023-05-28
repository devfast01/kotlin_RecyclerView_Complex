package com.example.kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.RVOneAdapter.OnItemsClickListener


class MainActivity : AppCompatActivity() {
    // reference for the Main-List RecyclerView
    private var RVOne: RecyclerView? = null

    // reference for the Sub-List RecyclerView
    private var RVTwo: RecyclerView? = null

    // Main-list item titles will be stored here
    private var tutorialList: ArrayList<RVOneModel>? = null

    // Sub-list item titles will be stored here
    private var tutorialSubList: ArrayList<RVTwoModel>? = null

    // reference for the RVOneAdapter class
    private var rvOneAdapter: RVOneAdapter? = null

    // reference for the RVTwoAdapter class
    private var rvTwoAdapter: RVTwoAdapter? = null

    // TextView to show the title of the clicked Main-List item
    private var algorithmTitleText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Linked up with its respective id used in the activity_main.xml
        RVOne = findViewById(R.id.recyclerViewOne)
        RVTwo = findViewById(R.id.recyclerViewTwo)
        algorithmTitleText = findViewById(R.id.algorithmTitleText)

        // Setting the Main-List RecyclerView horizontally
        RVOne?.run {
    layoutManager = LinearLayoutManager(
        applicationContext,
        LinearLayoutManager.HORIZONTAL,
        false
    )
}
        tutorialList = ArrayList()

        // Static data are stored one by one in the tutorialList arrayList
        tutorialList!!.add(RVOneModel("Algorithms", 1))
        tutorialList!!.add(RVOneModel("Data Structures", 2))
        tutorialList!!.add(RVOneModel("Languages", 3))
        tutorialList!!.add(RVOneModel("Interview Corner", 4))
        tutorialList!!.add(RVOneModel("GATE", 5))
        tutorialList!!.add(RVOneModel("ISRO CS", 6))
        tutorialList!!.add(RVOneModel("UGC NET CS", 7))
        tutorialList!!.add(RVOneModel("CS Subjects", 8))
        tutorialList!!.add(RVOneModel("Web Technologies", 9))

        // The app will show Algorithms Sub-List every time the activity starts
        algorithmTitleText!!.setText("Algorithms")
        setRVTwoList(1)
        rvOneAdapter = RVOneAdapter(tutorialList!!)
        RVOne.run { this!!.adapter = rvOneAdapter }

        // Setting up the events that will occur on each Main-List item click
        rvOneAdapter!!.setWhenClickListener(object : OnItemsClickListener {
            override fun onItemClick(rvOneModel: RVOneModel?) {
                algorithmTitleText!!.text = rvOneModel!!.name
                setRVTwoList(rvOneModel!!.num)
            }
        })
    }

    private fun setRVTwoList(num: Int) {

        // Setting the Sub-List RecyclerView vertically
        RVTwo!!.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        // Previous tutorialSubList will be deleted and new memory will be allocated
        tutorialSubList = ArrayList()

        // Static data are stored one by one in the tutorialSubList arrayList for each Main-List items
        if (num == 1) {
            tutorialSubList!!.add(RVTwoModel("Searching Algorithms"))
            tutorialSubList!!.add(RVTwoModel("Sorting Algorithms"))
            tutorialSubList!!.add(RVTwoModel("Graph Algorithms"))
            tutorialSubList!!.add(RVTwoModel("Pattern Algorithms"))
            tutorialSubList!!.add(RVTwoModel("Geometric Algorithms"))
            tutorialSubList!!.add(RVTwoModel("Mathematical"))
            tutorialSubList!!.add(RVTwoModel("Randomized Algorithms"))
            tutorialSubList!!.add(RVTwoModel("Greedy Algorithms"))
            tutorialSubList!!.add(RVTwoModel("Dynamic Programming"))
            tutorialSubList!!.add(RVTwoModel("Divide and Conquer"))
            tutorialSubList!!.add(RVTwoModel("Backtracking"))
            tutorialSubList!!.add(RVTwoModel("Branch and Bound"))
            tutorialSubList!!.add(RVTwoModel("All Algorithms"))
        } else if (num == 2) {
            tutorialSubList!!.add(RVTwoModel("Arrays"))
            tutorialSubList!!.add(RVTwoModel("Linked List"))
            tutorialSubList!!.add(RVTwoModel("Stack"))
            tutorialSubList!!.add(RVTwoModel("Queue"))
            tutorialSubList!!.add(RVTwoModel("Binary Tree"))
            tutorialSubList!!.add(RVTwoModel("Binary Search Tree"))
            tutorialSubList!!.add(RVTwoModel("Heap"))
            tutorialSubList!!.add(RVTwoModel("Hashing"))
            tutorialSubList!!.add(RVTwoModel("Graph"))
            tutorialSubList!!.add(RVTwoModel("Advanced Data Structure"))
            tutorialSubList!!.add(RVTwoModel("Matrix"))
            tutorialSubList!!.add(RVTwoModel("Strings"))
            tutorialSubList!!.add(RVTwoModel("All Data Structures"))
        } else if (num == 3) {
            tutorialSubList!!.add(RVTwoModel("C"))
            tutorialSubList!!.add(RVTwoModel("C++"))
            tutorialSubList!!.add(RVTwoModel("Java"))
            tutorialSubList!!.add(RVTwoModel("Python"))
            tutorialSubList!!.add(RVTwoModel("C#"))
            tutorialSubList!!.add(RVTwoModel("Javascript"))
            tutorialSubList!!.add(RVTwoModel("JQuery"))
            tutorialSubList!!.add(RVTwoModel("SQL"))
            tutorialSubList!!.add(RVTwoModel("PHP"))
            tutorialSubList!!.add(RVTwoModel("Scala"))
            tutorialSubList!!.add(RVTwoModel("Perl"))
            tutorialSubList!!.add(RVTwoModel("GO Language"))
            tutorialSubList!!.add(RVTwoModel("HTML"))
            tutorialSubList!!.add(RVTwoModel("CSS"))
            tutorialSubList!!.add(RVTwoModel("Kotlin"))
        } else if (num == 4) {
            tutorialSubList!!.add(RVTwoModel("Company Preparation"))
            tutorialSubList!!.add(RVTwoModel("Top Topics"))
            tutorialSubList!!.add(RVTwoModel("Practice Company Questions"))
            tutorialSubList!!.add(RVTwoModel("Interview Experiences"))
            tutorialSubList!!.add(RVTwoModel("Experienced Interviews"))
            tutorialSubList!!.add(RVTwoModel("Internship Interviews"))
            tutorialSubList!!.add(RVTwoModel("Competitive Programming"))
            tutorialSubList!!.add(RVTwoModel("Design Patterns"))
            tutorialSubList!!.add(RVTwoModel("Multiple Choice Quizzes"))
        } else if (num == 5) {
            tutorialSubList!!.add(RVTwoModel("GATE CS Notes 2021"))
            tutorialSubList!!.add(RVTwoModel("Last Minute Notes"))
            tutorialSubList!!.add(RVTwoModel("GATE CS Solved Papers"))
            tutorialSubList!!.add(RVTwoModel("GATE CS Original Papers and Official Keys"))
            tutorialSubList!!.add(RVTwoModel("GATE 2021 Dates"))
            tutorialSubList!!.add(RVTwoModel("GATE CS 2021 Syllabus"))
            tutorialSubList!!.add(RVTwoModel("Important Topics for GATE CS"))
            tutorialSubList!!.add(RVTwoModel("Sudo GATE 2021"))
        } else if (num == 6) {
            tutorialSubList!!.add(RVTwoModel("ISRO CS Solved Papers"))
            tutorialSubList!!.add(RVTwoModel("ISRO CS Original Papers and Official Keys"))
            tutorialSubList!!.add(RVTwoModel("ISRO CS Syllabus for Scientist/Engineer Exam"))
        } else if (num == 7) {
            tutorialSubList!!.add(RVTwoModel("UGC NET CS Notes Paper II"))
            tutorialSubList!!.add(RVTwoModel("UGC NET CS Notes Paper III"))
            tutorialSubList!!.add(RVTwoModel("UGC NET CS Solved Papers"))
        } else if (num == 8) {
            tutorialSubList!!.add(RVTwoModel("Mathematics"))
            tutorialSubList!!.add(RVTwoModel("Operating System"))
            tutorialSubList!!.add(RVTwoModel("DBMS"))
            tutorialSubList!!.add(RVTwoModel("Computer Networks"))
            tutorialSubList!!.add(RVTwoModel("Computer Organization and Architecture"))
            tutorialSubList!!.add(RVTwoModel("Theory of Computation"))
            tutorialSubList!!.add(RVTwoModel("Compiler Design"))
            tutorialSubList!!.add(RVTwoModel("Digital Logic"))
            tutorialSubList!!.add(RVTwoModel("Software Engineering"))
        } else if (num == 9) {
            tutorialSubList!!.add(RVTwoModel("HTML"))
            tutorialSubList!!.add(RVTwoModel("CSS"))
            tutorialSubList!!.add(RVTwoModel("Javascript"))
            tutorialSubList!!.add(RVTwoModel("jQuery"))
            tutorialSubList!!.add(RVTwoModel("PHP"))
        }
        rvTwoAdapter = RVTwoAdapter(tutorialSubList!!)
        RVTwo!!.adapter = rvTwoAdapter
    }
}


// Setting the Main-List RecyclerView horizontally
//RVOne?.run {
//    layoutManager = LinearLayoutManager(
//        applicationContext,
//        LinearLayoutManager.HORIZONTAL,
//        false
//    )
//}

//RVOne.run { this!!.adapter = rvOneAdapter }
