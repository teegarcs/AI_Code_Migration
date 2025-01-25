package com.teegarcs.legacysample

class MainViewModel : BaseViewModel<MainState, MainSE, MainIntent>() {

    override fun buildInitialState(): MainState = MainState()

    override fun processIntent(intent: MainIntent) {
        when (intent) {
            MainIntent.Decrement -> updateState { copy(count = count - 1) }
            MainIntent.Increment -> updateState { copy(count = count + 1) }
        }
    }

}