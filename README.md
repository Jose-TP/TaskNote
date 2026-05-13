# TaskNote 📝

Una app sencilla de tareas hecha en Android con Kotlin.
La hice principalmente para practicar el uso de **Room Database** y tener algo que mostrar en mi portafolio.

## ¿Qué hace?

- Ver una lista de tareas pendientes
- Agregar nuevas tareas con título y descripción
- Marcar tareas como completadas (con checkbox)
- Eliminar tareas que ya no necesitas

Basicamente es un TODO list pero funcional y con persistencia de datos local.

## ¿Por qué la hice?

Quería aprender a usar Room porque en muchos trabajos lo piden y la verdad no lo había usado bien.
Tambien quería practicar el patrón MVVM con ViewModel y LiveData, que es lo que más se usa 
en proyectos Android reales.

No es la app más compleja del mundo, pero me sirvió para entender como funciona la base de datos
local en Android y como conectar todo con la UI.

## Tecnologías usadas

- **Kotlin** - lenguaje principal
- **Room Database** - para guardar las tareas localmente
- **ViewModel + LiveData** - para manejar los datos en la UI
- **Jetpack Compose** - para la interfaz con Material Design 3
- **Corrutinas** - para las operaciones de base de datos (viewModelScope)
- **Gradle Version Catalog** - para manejar las dependencias

## Qué aprendí

- Como configurar Room con Entity, DAO y Database (el singleton me costó un poco al principio)
- Que las operaciones de base de datos NO se pueden hacer en el hilo principal, por eso use corrutinas
- A usar LiveData con `observeAsState` para que Compose se actualice automaticamente cuando cambian los datos
- Que el ViewModel sobrevive a los cambios de configuración y eso esta muy bueno para no perder datos

## Screenshots

> Proximamente 📸

## Notas

Esa app es solo de prueba o demostrativa, no tiene otros fines o usos que no sea didactico.
