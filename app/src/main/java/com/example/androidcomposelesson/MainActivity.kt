package com.example.androidcomposelesson

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomposelesson.ui.theme.AndroidComposeLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeLessonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                    Column (Modifier.padding(vertical = 16.dp)){
                        Text(text = "Hello Arwy")
//                        Text(text = "Hello Expansio")
                        val listItem = listOf("A","B","C","D","E","F")

                       val artists =  Artist("Arwy","Syah",25)
                        ArtistCard(artists);
                        val context = LocalContext.current
                        Button {
                            Toast.makeText(context, "Start a new Journey", Toast.LENGTH_LONG)
                                .show()
                        }
                        Card(listItem)


                    }
                }
            }
        }
    }
}



@Composable
fun TextShadow (text:String){
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = text,
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue,
                offset = offset,
                blurRadius = 3f
            )
        )
    )
}

@Composable
fun Box (item:String){
    Row(modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp).fillMaxHeight(22f).background(
        Color.Red

    ).height(40.dp).width(60.dp).border(width = 1.dp,color=Color.Blue)) {
        Text(text=item, modifier = Modifier.fillMaxSize(), fontSize = 20.sp, textAlign = TextAlign.Center)

    }
    TextShadow("AB")
}

@Composable
fun Card (listData : List<String>){
    LazyColumn(Modifier.fillMaxWidth(5f).fillMaxHeight()){
        items(listData){ message->
            Box(message)
        }
    }

}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")



}

@Composable
fun Button(onClick: () -> Unit) {

    Column (      // imageview to center of the screen.

    ) {




        Button(onClick=onClick) {
            Text(text = "Button")
        }

    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComposeLessonTheme {
        Greeting("Android")
    }
}
@Composable
fun ArtistCard(
 artist:Artist
) {
    val padding = 16.dp
    Column {
        Text(text = artist.lastName)
        Text(text = artist.firstName)
    }
}




