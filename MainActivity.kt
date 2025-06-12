package com.example.examen_womensecret

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examen_womensecret.ui.theme.Examen_womensecretTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Theme {
                Scaffold(
                    topBar = { Superior() }
                ) { paddingValues ->
                    Column(
                        modifier = Modifier.fillMaxSize().padding(paddingValues)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Cabecera()
                        fotos1()
                        fotos2()
                        texto1()
                        Email()
                        radio()
                        Mischeckbox()
                        Buton()
                        Label()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun Superior() {
    TopAppBar(
        title = { Text(" Faris Amine. Women´secret") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar",
                    tint = Color.Black
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Mail,
                    contentDescription = "Email o gmail",
                    tint = Color.Black
                )
            }

        }
    )


}
@Composable
fun Cabecera() {
    Row(
        modifier = Modifier.fillMaxWidth().height(65.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagen_1_arriba),
            contentDescription = "Foto cabecera",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}


@Composable
fun fotos1() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagen_2izquierda),
            contentDescription = "foto1",
            modifier = Modifier.weight(1f).height(60.dp),
            contentScale = ContentScale.Crop
        )
        Image(

            painter = painterResource(id = R.drawable.imagen_3_derecha),
            contentDescription = "foto2",
            modifier = Modifier.weight(1f).height(57.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun fotos2() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagen_4_izquierda),
            contentDescription = "foto 3",
            modifier = Modifier.weight(1f)
                .height(57.dp),

            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.imagen_5derechya),
            contentDescription = "foto4",

            modifier = Modifier.weight(1f).height(60.dp),
            contentScale = ContentScale.Crop

        )
    }
}




@Composable
fun texto1() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 14.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Consigue un 10% en tu proxima compra",
            fontSize = 14.sp
            //font
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email() {
    Row {
        var email by remember { mutableStateOf("") }
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Black, shape = MaterialTheme.shapes.small),
            placeholder = { Text("Introduce aquí tu email") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
        )
    }
}

@Composable
fun TextField(value: Any, onValueChange: () -> Unit, modifier: Any, placeholder: () -> Unit, keyboardOptions: Any, singleLine: Boolean, colors: Any) {

}

@Composable
fun radio() {
    var opcionElegida by remember { mutableStateOf("") }
    val opciones = listOf("Hombre", "Mujer")

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Selecciona tu genero por favor:",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        opciones.forEach { opcion ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = opcionElegida == opcion,
                    onClick = { opcionElegida = opcion },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue,
                    )
                )
                Text(
                    text = opcion,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}


@Composable
fun Mischeckbox(){
    val opciones = remember {
        mutableStateListOf(
            Midataclass("Leer y aceptar las políticas de usuario", false),
            Midataclass("Deseo recibir información por emaill", false),
            Midataclass("acepto todas las cookies", false)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        opciones.forEach { opcion ->
            FilaCheckbox(opcion)
        }
    }
}

@Composable
fun FilaCheckbox(opcion: Midataclass) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = opcion.isCheckedState.value,
            onCheckedChange = {
                opcion.isCheckedState.value = it
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF3B5998),
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = opcion.title, fontSize = 14.sp, color = Color.Black)
    }
}

@Preview
@Composable
fun Buton() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        enabled = false,

        colors = ButtonDefaults.buttonColors(
            disabledContentColor = Color.Gray,
        )
    ) {
        Text("RECIBIR MI DESCUENTO",
            color = Color.Black,
            fontSize = 13.sp,)
    }
}


/*
@Composable
fun Buton() {
    Column {
        Button(
 */

@Composable
fun Label() {
    Row(

        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier.weight(1f))
        Text(
            text = "Puedes cancelar la sucripcion cuando quieras",
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color.Black,
            style = androidx.compose.ui.text.TextStyle(textDecoration = TextDecoration.Underline)
        )
        Divider(modifier = Modifier.weight(1f))
    }
}




  /*
    fun Superior(){
        //crear una funcoin composabel superior() y para cada uno de los componentes que la integran
        //una tollbar con un unico icono y tiutuo
        //las imagenes

        //en resumen una tabla ocn la imgaen 1 arriba ocupadno dos cuadros otras dos abajo la mitad y otras dos abajo la mitad osea tabla de 3 filas por 2 columnas

        //imagenens en esos cuadros,

    }




    fun Inferior(){
        //crearas una funcoin compoabel inferior y para cada uno de los componentes que la intefran
        // el mail debe ocupar una sola linea de teclado adaptado
        //usa spacer entre elementso y padiin los contnendedores
        //el bton se habilirata si el mail es corrrecto


    }
   */











}



