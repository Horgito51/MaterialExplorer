package com.example.materialexplorer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.materialexplorer.ui.theme.MaterialExplorerTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // El tema envuelve a la aplicación para proveer colores dinámicos
            MaterialExplorerTheme {
                MainScreen()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    // Scaffold es la estructura base que organiza TopBar, FAB y Contenido
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Explorador Material You") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =
                    MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor =
                    MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Sin acción */ },
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Tarjeta que utiliza el esquema de color secundario
            Card(
                colors = CardDefaults.cardColors(
                    containerColor =
                    MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Superficie Secundaria",
                        style = MaterialTheme.typography.titleMedium,
                        color =
                        MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = "Este color se adapta automáticamente al fondo de pantalla del sistema.",
                                style = MaterialTheme.typography.bodyMedium,
                        color =
                        MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
            // Botón que utiliza el color primario
            Button(
                onClick = { /* Sin acción */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Botón Primario")
            }

            OutlinedButton(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
                border = androidx.compose.foundation.BorderStroke(1.dp,
                    MaterialTheme.colorScheme.outline)
            ) {
                Text("Botón de Contorno", color = MaterialTheme.colorScheme.outline)
            }


            // Texto informativo sobre el esquema actual
            Text(
                text = "Nota: Para ver el cambio, cambie el fondo de pantall (Wallpaper) en los ajustes del emulador.",
                        style = MaterialTheme.typography.labelSmall
            )
        }
    }
}
