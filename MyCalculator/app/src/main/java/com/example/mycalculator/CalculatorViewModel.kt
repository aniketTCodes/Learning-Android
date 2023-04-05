package com.example.mycalculator

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel:ViewModel() {




    var state by mutableStateOf(CalculatorState())

        private set

    fun onAction(action: CalculatorAction){
        when(action){

            is CalculatorAction.Number->enterNumber(action.number)
             CalculatorAction.Decimal->enterDecimal()
             CalculatorAction.Delete->deleteNumber()
             CalculatorAction.Calculate->calculate()
            is CalculatorAction.Operation->enterOperation(action.operation)
             CalculatorAction.Clear->clearstate()


        }
    }

    private fun clearstate() {
        state=state.copy(number1 = "", number2 = "", operation = null)
    }

    private fun enterOperation(operation: CalculatorOperation) {
            if(state.number2.isBlank())
            state=state.copy(operation = operation)
            else
                return
    }

    private fun calculate() {
        var number1=state.number1.toDoubleOrNull()
        var number2=state.number2.toDoubleOrNull()
        if(number1!=null&&number2!=null)
        when(state.operation){
            is CalculatorOperation.Add->number1+=number2
            is CalculatorOperation.Subtract->number1-=number2
            is CalculatorOperation.Multiply->number1*=number2
            is CalculatorOperation.Divide->number1/=number2
            else->return
        }
        state=state.copy(number1=number1.toString(), number2 ="", operation = null)
    }

    private fun deleteNumber() {
        if(state.operation==null)
            state=state.copy(number1 = state.number1.dropLast(1))
        else if(state.number2.isNotEmpty())
            state=state.copy(number2=state.number2.dropLast(1))
        else
            state=state.copy(operation = null)
    }

    private fun enterDecimal() {
        if(state.operation==null)
            state=state.copy(number1 = state.number1+".")

        else
            state=state.copy(number2=state.number2+".")
    }

    private fun enterNumber(number: Int) {

        if(state.operation==null){
            state=state.copy(number1 = state.number1+number)
        }else
            state=state.copy(number2 = state.number2+number)
    }

}