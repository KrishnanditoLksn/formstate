package app.ditodev.formolog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.ditodev.formolog.ui.components.FormTextfield
import app.ditodev.formolog.ui.theme.FormologTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormologTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var staten by rememberSaveable {
        mutableStateOf("")
    }
//    val vmForm = FormViewModel()
//    val namestate by vmForm.nameState("")
//    val name = vmForm.onFormNameChange("").obse
    ContentLogin(name = staten, modifier = modifier, onValueChange = {
        staten = it
    })
}

@Composable
fun ContentLogin(name: String, modifier: Modifier, onValueChange: (String) -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (name.isNotEmpty()) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
        FormTextfield(
            value = name,
            onValueChange = onValueChange
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FormFlowPreview() {
    FormologTheme {
        LoginScreen()
    }
}