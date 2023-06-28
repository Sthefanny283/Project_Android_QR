package com.cursoklotin.intento.bd.insertion
import com.cursoklotin.intento.QRData
import com.cursoklotin.intento.UserData
import com.cursoklotin.intento.RegistroAsistenciaData


import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase


class DataInsertionHelper(private val db: SQLiteDatabase) {
    fun insertDefaultData() {
        insertUserData()
        insertRegistroAsistenciaData()
        insertQRData()
    }

    private fun insertUserData() {
        val userData = arrayOf(
            UserData(
                id = -1,
                "John Doeaaaaaa",
                "jore@",
                "123",
                "Masculino",
                "987612588",
                "894144444441111122233",
                "BCP",
                "76057972",
                "1990-01-01",
                "Jefe A",
                "Dirección A",
                "Distrito A",
                "Condición A",
                "Empleado A ",
                "1",
                "Fecha Creación",
                "Ultima Actualización",
                "Activo-Inactivo",
                "www.firebase.com/storage/imagen.jpg"
                    ),
            UserData(
                id = -1,
                "Jane Smith",
                "jane@",
                "123",
                "Femenino",
                "987612588",
                "894144444441111122233",
                "BCP",
                "76057972",
                "1990-01-01",
                "Jefe A",
                "Dirección A",
                "Distrito A",
                "Condición A",
                "Empleado A ",
                "2",
                "Fecha Creación",
                "Ultima Actualización",
                "Activo-Inactivo",
                "www.firebase.com/storage/imagen.jpg"
                    )
            // Agrega más datos de ejemplo aquí según tus necesidades
        )

        val values = ContentValues()

        for (data in userData) {
            values.put("nombres", data.nombres)
            values.put("correo", data.correo)
            values.put("contrasena", data.contrasena)
            values.put("telefono", data.telefono)
            values.put("sexo", data.sexo)
            values.put("numeroCuenta", data.numeroCuenta)
            values.put("banco", data.banco)
            values.put("dni", data.dni)
            values.put("fechaNacimiento", data.fechaNacimiento)
            values.put("jefe", data.jefe)
            values.put("direccion", data.direccion)
            values.put("distrito", data.distrito)
            values.put("condicion", data.condicion)
            values.put("cargo", data.cargo)
            values.put("rol", data.rol)
            values.put("fechaCreacion", data.fechaCreacion)
            values.put("ultimaActualizacion", data.ultimaActualizacion)
            values.put("estadoCuenta", data.estadoCuenta)
            values.put("imagenPerfil", data.imagenPerfil)

            db.insert("User", null, values)
            values.clear()
        }
    }

    private fun insertRegistroAsistenciaData() {
        val defaultData = arrayOf(
            RegistroAsistenciaData(
                1,
                "2023-05-29",
                "08:00:00",
                "17:00:00",
                0.1f,
                1,
                1
            ),
            RegistroAsistenciaData(
                2,
                "2023-05-30",
                "09:00:00",
                "18:00:00",
                1.5f,
                2,
                2
            )
            // Agrega más datos de ejemplo aquí según tus necesidades
        )

        val values = ContentValues()

        for (data in defaultData) {
            values.put("id", data.id)
            values.put("fecha", data.fecha)
            values.put("hora_entrada", data.hora_entrada)
            values.put("hora_salida", data.hora_salida)
            values.put("llegada_tarde", data.llegada_tarde)
            values.put("empleado_id", data.empleado_id)
            values.put("codigo_id", data.codigo_id)

            db.insert("RegistrarAsistencia", null, values)
            values.clear()
        }
    }

    private fun insertQRData() {
        val qrData = arrayOf(
            QRData(1, "codigo1", "Descripción 1", 0),
            QRData(2, "codigo2", "Descripción 2", 0)
            // Agrega más datos de ejemplo aquí según tus necesidades
        )

        for (data in qrData) {
            val values = ContentValues().apply {
                put("id", data.id)
                put("codigo", data.codigo)
                put("descripcion", data.descripcion)
                put("is_used", data.isUsed)
            }
            db.insert("QR", null, values)
        }
    }

}
