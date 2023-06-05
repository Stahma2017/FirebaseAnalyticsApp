package com.example.firebaseanalyticsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import com.example.firebaseanalyticsapp.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val firebaseAnalytics = Firebase.analytics

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.action.setOnClickListener {
            val die1 = Random.nextInt(0, 5) + 1
            val die2 = Random.nextInt(0, 5) + 1
            val sum = die1 + die2

            Log.d(
                "TEST18", """
                sum = $sum,
                doubles = ${die1 == die2}
            """.trimIndent()
            )
            firebaseAnalytics.logEvent(
                "roll",
                bundleOf(
                    "sum" to sum.toLong(),
                    "doubles" to (die1 == die2).toString()
                )
            )
        }
    }

}