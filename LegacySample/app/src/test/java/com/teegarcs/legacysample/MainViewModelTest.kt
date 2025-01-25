package com.teegarcs.legacysample

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun TestIncrement() {
        viewModel.processIntent(MainIntent.Increment)
        assertEquals(1, viewModel.currentState.count)
    }

    @Test
    fun TestDecrement() {
        viewModel.processIntent(MainIntent.Decrement)
        assertEquals(-1, viewModel.currentState.count)
    }

    @Test
    fun TestInitialState() {
        assertEquals(0, viewModel.currentState.count)
    }
}