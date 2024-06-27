package com.deshacode.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.deshacode.myapplication.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var lastNumber : Double =0.0
    var currentOperation : Operation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        allCallBack()

    }

    private fun allCallBack(){
        binding.btn1.setOnClickListener {
            onClickNumber(binding.btn1)
        }
        binding.btn2.setOnClickListener {
            onClickNumber(binding.btn2)
        }
        binding.btn3.setOnClickListener {
            onClickNumber(binding.btn3)
        }
        binding.btn4.setOnClickListener {
            onClickNumber(binding.btn4)
        }
        binding.btn5.setOnClickListener {
            onClickNumber(binding.btn5)
        }
        binding.btn6.setOnClickListener {
            onClickNumber(binding.btn6)
        }
        binding.btn7.setOnClickListener {
            onClickNumber(binding.btn7)
        }
        binding.btn8.setOnClickListener {
            onClickNumber(binding.btn8)
        }
        binding.btn9.setOnClickListener {
            onClickNumber(binding.btn9)
        }
        binding.btn0.setOnClickListener {
            onClickNumber(binding.btn0)
        }
        binding.btnDot.setOnClickListener {
            onClickNumber(binding.btnDot)
        }
        binding.btnC.setOnClickListener {
            clearText()
        }
        binding.btnDiv.setOnClickListener {
            preparingOperation(Operation.Div)
        }
        binding.btnMin.setOnClickListener {
            preparingOperation(Operation.Min)
        }
        binding.btnMul.setOnClickListener {
            preparingOperation(Operation.Mul)
        }
        binding.btnPlus.setOnClickListener {
            preparingOperation(Operation.Plus)
        }
        binding.btnMod.setOnClickListener {
            preparingOperation(Operation.Mod)
        }
        binding.btnGzr.setOnClickListener {
            preparingOperation(Operation.Gaz)
        }
        binding.btnEqu.setOnClickListener {
           var result= doOperation()
            binding.textResult.text = result.toString()
        }



    }
    private fun doOperation() : Double{
        val secondNumber = binding.textResult.text.toString().toDouble()
        return when(currentOperation){
            Operation.Div -> lastNumber/secondNumber
            Operation.Min-> lastNumber-secondNumber
            Operation.Mod->lastNumber%secondNumber
            Operation.Mul->lastNumber*secondNumber
            Operation.Plus->lastNumber+secondNumber
            Operation.Gaz->lastNumber.pow(secondNumber)
            null->0.0
        }
    }
    private fun clearText(){
        binding.textResult.text = ""
    }
    private fun preparingOperation(operation : Operation){
        lastNumber = binding.textResult.text.toString().toDouble()
        clearText()
        currentOperation = operation
    }
    private fun onClickNumber(v: View){
        val newDigit = (v as Button).text.toString()
        val oldDigits = binding.textResult.text.toString()
        val  newTextNumber = oldDigits+newDigit
        binding.textResult.text =newTextNumber

    }
}