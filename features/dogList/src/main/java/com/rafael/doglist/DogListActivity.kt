package com.rafael.doglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET


data class Dog(
    val id: String,
    val url: String,
)
internal interface DogsGateway {

    @GET("v1/images/search")
    suspend fun getImages(): List<Dog>
}

val testModule = DI.Module(name = "test"){
    bind<DogsGateway>() with singleton{
        val retrofit: Retrofit = instance()
        retrofit.create(DogsGateway::class.java)
    }
}

class DogListActivity : ComponentActivity(), DIAware {

    override val di by closestDI()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize().clickable { lifecycleScope.launch(Dispatchers.IO) {
                    try {
                        val gateway by instance<DogsGateway>()
                        val x =  gateway.getImages()
                        println("resposta: " + x.first().url)
                    }  catch (e: Exception){
                        println("error calling api: " + e.message)
                    }
                } },
                color = MaterialTheme.colorScheme.background
            ) {
                Greeting("Android dog list activity")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    DoggoTheme {
//        Greeting("Android")
//    }
//}