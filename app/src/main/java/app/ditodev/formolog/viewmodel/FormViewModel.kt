package app.ditodev.formolog.viewmodel

import androidx.lifecycle.ViewModel
import app.ditodev.formolog.data.FormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormViewModel : ViewModel() {
    private val _name = MutableStateFlow(FormUiState())
    var nameState: StateFlow<FormUiState> = _name.asStateFlow()
        private set

    fun onFormNameChange(nameForm: String) {
        _name.value = _name.value.copy(name = nameForm)
    }
}