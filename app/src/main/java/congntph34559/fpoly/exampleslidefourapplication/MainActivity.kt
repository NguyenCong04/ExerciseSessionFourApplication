package congntph34559.fpoly.exampleslidefourapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import congntph34559.fpoly.exampleslidefourapplication.ui.theme.ExampleSlideFourApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleSlideFourApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HomeScreen()
                }
            }
        }
    }
}


@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        ExampleOne("Nguyễn Tất Công")
        Spacer(modifier = Modifier.height(10.dp))
        ExampleTwo()
        Spacer(modifier = Modifier.height(10.dp))
        ExampleThree()
    }


}


@Composable
fun ExampleOne(name: String) {

    Text(
        text = "Hello, $name",
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        color = Color.DarkGray
    )

}

@Composable
fun ExampleTwo() {

    val text = remember {
        mutableStateOf("Nguyễn Tất Công - PH34559")
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text.value,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.DarkGray
        )
        Button(
            onClick = {
                if (text.value == "Say Anahi !!!") text.value = "Nguyễn Tất Công - PH34559"
                else text.value = "Say Anahi !!!"
            },
            shape = RoundedCornerShape(size = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
            )
        ) {
            Text(text = "Say hi nè !", fontFamily = FontFamily.Serif)
        }
    }


}

@Composable
fun ExampleThree() {
//    var count = remember {
//        mutableIntStateOf(0)
//    }
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You have click the button $count times",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.DarkGray
        )
        Button(
            onClick = {
                count++
            },
            shape = RoundedCornerShape(size = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
            )
        ) {
            Text(text = "Click me", fontFamily = FontFamily.Serif)
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ExampleSlideFourApplicationTheme {
        HomeScreen()
    }
}