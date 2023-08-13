package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.icu.text.CompactDecimalFormat.CompactStyle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.math.log

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var SelectedOption:Int= 0
    var currentposition = 1
    private var QuestionList :ArrayList<question> ? = null
private  var name:String? = null
    private var num_of_correct:Int = 0


    var progressbar:ProgressBar?=null
    var progress:TextView?=null
    var Image:ImageView?=null
    var questions:TextView?=null
    var BtnStart:Button ?= null
    var option1:TextView?=null
    var option2:TextView?=null
    var option3:TextView?=null
    var option4:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        name = intent.getStringExtra("user_name")

        progressbar = findViewById(R.id.ProgressBar)
        progress = findViewById(R.id.Progress)
        Image = findViewById(R.id.flag)
        questions = findViewById(R.id.question)

        BtnStart = findViewById(R.id.submit)

        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)

        QuestionList = constants.getQuestions()
        setQuestion()

        option1?.setOnClickListener (this)
        option2?.setOnClickListener (this)
        option3?.setOnClickListener (this)
        option4?.setOnClickListener ( this )
        BtnStart?.setOnClickListener ( this )


    }

    private fun setQuestion() {
        setOption()  // reset the background color
        var quest: question = QuestionList!![currentposition - 1]
        questions?.text = quest.question
        progressbar?.progress = currentposition
        progress?.text = "${currentposition} / ${progressbar?.max}"
        Image?.setImageResource(quest.image)
        option1?.text = quest.option1
        option2?.text = quest.option2
        option3?.text = quest.option3
        option4?.text = quest.option4

        if (currentposition == QuestionList?.size){
            BtnStart?.text= "FINISH"
        }else{
            BtnStart?.text = "SUBMIT"
        }
    }



    override fun onClick(v: View?) {
        when(v?.id){

            R.id.option1->{
                option1?.let {
                    SecectedOption(it,1)
                }
            }

            R.id.option2->{
                option2?.let {
                    SecectedOption(it,2)
                }
            }

            R.id.option3->{
                option3?.let {
                    SecectedOption(it,3)
                }
            }

            R.id.option4->{
                option4?.let {
                    SecectedOption(it,4)
                }
            }
            R.id.submit->{
                 if (SelectedOption == 0){  // initially selectedoption is 0 , means -> no option is selected{1,2,3,4} and submit button is clicked
                     currentposition++  // increment the next question
                     when {
                         currentposition<=QuestionList!!.size ->{
                             setQuestion()
                         }
                         else ->  {
                             val intent = Intent(this,ResultActivity::class.java)
                             intent.putExtra("user_name",name)
                             intent.putExtra("crt_opt",num_of_correct)
                              startActivity(intent)
                             finish()
                         }
                     }
                 }
                else{
                    val question = QuestionList?.get(currentposition-1)
                     if (question!!.correctOption != SelectedOption){
                           correctView(R.drawable.wrong,SelectedOption)
                       }
                     else{
                         num_of_correct++
                     }

                           correctView(R.drawable.correct,question.correctOption)



                     if (currentposition == QuestionList!!.size){
                         BtnStart?.text = "FINISH"
                     }
                     else{
                         BtnStart?.text = "NEXT"
                     }
                     SelectedOption = 0
                }
            }


        }
    }

    private fun SecectedOption(tv:TextView,selectNum:Int){
        setOption()
        val question = QuestionList?.get(currentposition-1)
        SelectedOption = selectNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selectedborder)


    }

    private fun setOption(){
        val option = ArrayList<TextView>()
        option1?.let {
            option.add(0,it)
        }
        option2?.let {
            option.add(1,it)
        }
        option3?.let {
            option.add(2,it)
        }
        option4?.let {
            option.add(3,it)
        }

        for (opt in option){
            opt.setTextColor(Color.parseColor("#7A8089"))
            opt.typeface = Typeface.DEFAULT
            opt.background = ContextCompat.getDrawable(this,R.drawable.border)

        }

    }

    private fun correctView( drawable:Int, answer:Int ){

        when(answer){
           1->{
               option1?.background = ContextCompat.getDrawable(this,drawable)
           }

            2->{
                option2?.background = ContextCompat.getDrawable(this,drawable)
            }
            3->{
                option3?.background = ContextCompat.getDrawable(this,drawable)
            }
            4->{
                option4?.background = ContextCompat.getDrawable(this,drawable)
            }
        }
    }
}