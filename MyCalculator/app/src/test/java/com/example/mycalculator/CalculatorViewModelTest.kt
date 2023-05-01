package com.example.mycalculator

import org.junit.Assert.*
import org.junit.Test

class CalculatorViewModelTest{
   private var classUnderTest=CalculatorViewModel()

    @Test
    fun `validate addition`(){
        classUnderTest.onAction(CalculatorAction.Number(12))
        classUnderTest.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
        classUnderTest.onAction(CalculatorAction.Number(12))
        classUnderTest.onAction(CalculatorAction.Calculate)
        assertEquals("24.0",classUnderTest.state.number1)
    }
}