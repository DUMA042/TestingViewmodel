package com.example.coviewlive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coviewlive.UIpack.ViewModelpack.firstViewmodel
import com.example.coviewlive.ui.theme.CoViewLiveTheme

class MainActivity : ComponentActivity() {
    val myviewmodel by viewModels<firstViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoViewLiveTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting(myviewmodel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewmodelLink:firstViewmodel) {
    val checkword:String by viewmodelLink.word.observeAsState("")

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        
        Text(text = checkword)
        Button(
            onClick = { viewmodelLink.setNewString("Works")/* ... */ },
            // Uses ButtonDefaults.ContentPadding by default
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            Text(text = "Change String!")
        }
    }

}

@Preview(showBackground = true,widthDp = 250,heightDp = 500)
@Composable
fun DefaultPreview() {
    CoViewLiveTheme {
        Greeting(viewModel())
    }
}