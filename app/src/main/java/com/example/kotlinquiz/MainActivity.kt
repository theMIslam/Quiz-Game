package com.example.kotlinquiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var questionsLists: List<QuestionsList>

    private var currentQuestionPosition = 0
    private var selectedOptionByUser = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBank()
        binding.option1.setOnClickListener {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.option1.text.toString()
                binding.option1.setBackgroundColor(Color.RED)
                binding.option1.setTextColor(Color.WHITE)

                revealAnswer()
                questionsLists[currentQuestionPosition].userSelectedAnswer = selectedOptionByUser
            }
        }

        binding.option2.setOnClickListener {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.option2.text.toString()
                binding.option2.setBackgroundColor(Color.RED)
                binding.option2.setTextColor(Color.WHITE)

                revealAnswer()
                questionsLists[currentQuestionPosition].userSelectedAnswer = selectedOptionByUser
            }
        }
        binding.option3.setOnClickListener {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.option3.text.toString()
                binding.option3.setBackgroundColor(Color.RED)
                binding.option3.setTextColor(Color.WHITE)

                revealAnswer()
                questionsLists[currentQuestionPosition].userSelectedAnswer = selectedOptionByUser
            }
        }

        binding.option4.setOnClickListener {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.option4.text.toString()
                binding.option4.setBackgroundColor(Color.RED)
                binding.option4.setTextColor(Color.WHITE)

                revealAnswer()
                questionsLists[currentQuestionPosition].userSelectedAnswer = selectedOptionByUser
            }
        }
        binding.nextBtn.setOnClickListener {
            if (selectedOptionByUser.isEmpty()) {
                Toast.makeText(this, "Please select", Toast.LENGTH_SHORT).show()
            } else {
                changeNextQuestions()
            }
        }
    }
    fun getCorrectAnswer(): Int {
        var correctAnswers = 0

        for (i in 0 until questionsLists.size) {
            val getUserSelectedAnswer = questionsLists[i].userSelectedAnswer
            val getAnswer = questionsLists[i].answer

            if (getUserSelectedAnswer == getAnswer) {
                correctAnswers++
            }
        }
        return correctAnswers
    }
    private fun getInCorrectAnswer(): Int {
        var correctInAnswers = 0

        for (i in 0 until questionsLists.size) {
            val getUserSelectedAnswer = questionsLists[i].userSelectedAnswer
            val getAnswer = questionsLists[i].answer

            if (getUserSelectedAnswer != getAnswer) {
                correctInAnswers++
            }
        }
        return correctInAnswers
    }
    private fun initBank() {
        val questionsBank = QuestionsBank()
        questionsLists = questionsBank.getQuestions()
        binding.questions.text = "${currentQuestionPosition + 1}/${questionsLists.size}"
        binding.question.text = questionsLists[0].question
        binding.option1.text = questionsLists[0].option1
        binding.option2.text = questionsLists[0].option2
        binding.option3.text = questionsLists[0].option3
        binding.option4.text = questionsLists[0].option4
    }
    private fun getMove() {
        val intent = Intent(this@MainActivity, QuizResultActivity::class.java)
        intent.putExtra("correct", getCorrectAnswer())
        intent.putExtra("incorrect", getInCorrectAnswer())
        startActivity(intent)
        finish()
    }
    private fun revealAnswer() {
        val getAnswer = questionsLists[currentQuestionPosition].answer
        if (binding.option1.text.toString() == getAnswer) {
            binding.option1.setBackgroundColor(Color.GREEN)
            binding.option1.setTextColor(Color.WHITE)
        } else if (binding.option2.text.toString() == getAnswer) {
            binding.option2.setBackgroundColor(Color.GREEN)
            binding.option2.setTextColor(Color.WHITE)
        } else if (binding.option3.text.toString() == getAnswer) {
            binding.option3.setBackgroundColor(Color.GREEN)
            binding.option3.setTextColor(Color.WHITE)
        } else if (binding.option4.text.toString() == getAnswer) {
            binding.option4.setBackgroundColor(Color.GREEN)
            binding.option4.setTextColor(Color.WHITE)
        }
    }
    private fun changeNextQuestions() {
        currentQuestionPosition++
        if ((currentQuestionPosition + 1) == questionsLists.size) {
            binding.nextBtn.text = "Done"
        }
        if (currentQuestionPosition < questionsLists.size) {
            selectedOptionByUser = ""
            binding.option1.setBackgroundResource(R.drawable.round_back_white_stroke)
            binding.option1.setTextColor(Color.parseColor("#1F6BB8"))

            binding.option2.setBackgroundResource(R.drawable.round_back_white_stroke)
            binding.option2.setTextColor(Color.parseColor("#1F6BB8"))

            binding.option3.setBackgroundResource(R.drawable.round_back_white_stroke)
            binding.option3.setTextColor(Color.parseColor("#1F6BB8"))

            binding.option4.setBackgroundResource(R.drawable.round_back_white_stroke)
            binding.option4.setTextColor(Color.parseColor("#1F6BB8"))

            binding.questions.text = "${(currentQuestionPosition + 1)}/${questionsLists.size}"
            binding.question.text = questionsLists[currentQuestionPosition].question
            binding.option1.text = questionsLists[currentQuestionPosition].option1
            binding.option2.text = questionsLists[currentQuestionPosition].option2
            binding.option3.text = questionsLists[currentQuestionPosition].option3
            binding.option4.text = questionsLists[currentQuestionPosition].option4
        } else {
            getMove()
        }
    }


}