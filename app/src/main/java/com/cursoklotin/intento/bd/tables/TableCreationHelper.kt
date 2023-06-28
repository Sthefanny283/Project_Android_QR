package com.cursoklotin.intento.bd.tables

import android.database.sqlite.SQLiteDatabase


class TableCreationHelper(private val db: SQLiteDatabase) {
    fun createTables() {
        createUserTable()
        createRegistrarAsistenciaTable()
        createQRTable()
    }

    private fun createUserTable() {
        val query = """
            CREATE TABLE IF NOT EXISTS User (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombres TEXT,
                correo TEXT,
                contrasena TEXT,
                sexo TEXT,
                telefono TEXT,
                numeroCuenta TEXT,
                banco TEXT,
                dni TEXT,
                fechaNacimiento TEXT,
                jefe TEXT,
                direccion TEXT,
                distrito TEXT,
                condicion TEXT,
                cargo TEXT,
                rol INTEGER,
                fechaCreacion TEXT,
                ultimaActualizacion TEXT,
                estadoCuenta TEXT,
                imagenPerfil TEXT
     
            )
        """.trimIndent()

        db.execSQL(query)
    }

    private fun createRegistrarAsistenciaTable() {
        val query = """
            CREATE TABLE IF NOT EXISTS RegistrarAsistencia (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                fecha DATE,
                hora_entrada TIME,
                hora_salida TIME,
                llegada_tarde FLOAT,
                empleado_id INT,
                codigo_id INT,
                FOREIGN KEY (empleado_id) REFERENCES User(id),
                FOREIGN KEY (codigo_id) REFERENCES QR(id)
            )
        """.trimIndent()

        db.execSQL(query)
    }

    private fun createQRTable() {
        val query = """
            CREATE TABLE IF NOT EXISTS QR (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                codigo TEXT,
                descripcion TEXT,
                is_used INT DEFAULT 0
            )
        """.trimIndent()

        db.execSQL(query)
    }

}

