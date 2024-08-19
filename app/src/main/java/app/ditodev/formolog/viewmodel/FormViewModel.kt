package app.ditodev.formolog.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {
    private val _name = mutableStateOf("")
    val name: State<String> = _name

    fun onFormNameChange(nameForm: String) {
        _name.value = nameForm
    }
}