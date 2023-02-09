package com.example.kotlinquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinquiz.databinding.ActivityQuizResultBinding

class QuizResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getCorrectAnswers = intent.getIntExtra("correct", 0)
        val getInCorrectAnswers = intent.getIntExtra("incorrect", 0)

        binding.correctAnswer.text = "Correct answers - $getCorrectAnswers"
        binding.inCorrectAnswer.text = "Incorrect answers - $getInCorrectAnswers"

        binding.startAgain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}