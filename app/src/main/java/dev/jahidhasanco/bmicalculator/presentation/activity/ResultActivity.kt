package dev.jahidhasanco.bmicalculator.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import dev.jahidhasanco.bmicalculator.R
import dev.jahidhasanco.bmicalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    val _binding get() = binding

    var weight : Double = 0.0
    var height : Double = 0.0
    var result : Double = 0.0
    var gender : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_result)

        weight = intent.getDoubleExtra("Weight",50.0)
        height = intent.getDoubleExtra("Height",1.0)
        gender = intent.getIntExtra("Gender",0)

        bmiCal()
        animationView()
        _binding.reloadBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }

    private fun animationView() {

        _binding.apply {

            deskImage.translationY = 100f
            resultText.translationY = 40f
            bmiText.translationY = 50f
            bmiTextNormal.translationY = 50f
            deleteBtn.translationY = 70f
            reloadCardView.translationY = 70f
            shareBtn.translationY = 70f

            deskImage.alpha = 0f
            resultText.alpha = 0f
            bmiText.alpha = 0f
            bmiTextNormal.alpha = 0f
            deleteBtn.alpha = 0f
            reloadCardView.alpha = 0f
            shareBtn.alpha = 0f

            deskImage.setPadding(100)

            deskImage.animate().translationY(0f).alpha(1f).setDuration(500).setStartDelay(300).start()
            deskImage.setPadding(0)
            resultText.animate().translationY(0f).alpha(1f).setDuration(500).setStartDelay(500).start()
            bmiText.animate().translationY(0f).alpha(1f).setDuration(500).setStartDelay(450).start()
            bmiTextNormal.animate().translationY(0f).alpha(.3f).setDuration(500).setStartDelay(500).start()
            deleteBtn.animate().translationY(0f).alpha(.3f).setDuration(500).setStartDelay(600).start()
            reloadCardView.animate().translationY(0f).alpha(1f).setDuration(500).setStartDelay(750).start()
            shareBtn.animate().translationY(0f).alpha(.3f).setDuration(500).setStartDelay(900).start()


        }
    }

    fun bmiCal(){
        if(height>0 && weight>0){
            if(gender==0){
                bmiCalMale()
            }
            else if(gender == 1){
                bmiCalFemale()
            }
            showResult()
        }

    }

    private fun showResult() {

        val solution = String.format("%.1f", result)

        _binding.apply {
            resultText.text = solution
            bmiText.text = "BMI = $solution kg/m2"
        }

        // update the status text as per the bmi conditions
//        if (BMI < 18.5) {
//            status.text = "Under Weight"
//        } else if (BMI >= 18.5 && BMI < 24.9) {
//            status.text = "Healthy"
//        } else if (BMI >= 24.9 && BMI < 30) {
//            status.text = "Overweight"
//        } else if (BMI >= 30) {
//            status.text = "Suffering from Obesity"
//        }

    }

    fun bmiCalMale(){
        result = ((weight/(height*height))*10000)
    }
    fun bmiCalFemale(){
        result = ((weight/(height*height))*10000)
    }

}