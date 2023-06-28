package com.cursoklotin.intento.bd.services

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.Cursor
import com.cursoklotin.intento.UserData
import android.util.Log



class AuthQueryHelper(private val db: SQLiteDatabase) {
    fun login(email: String, password: String): Int {
        val projection = arrayOf("id")
        val selection = "correo = ? AND contrasena = ?"
        val selectionArgs = arrayOf(email, password)

        val cursor: Cursor = db.query("User", projection, selection, selectionArgs, null, null, null)

        val userId: Int

        userId = if (cursor.moveToFirst()) {
            val userId = cursor.getInt(cursor.getColumnIndex("id"))
            Log.d("AuthQueryHelper", "UserID: $userId") // Agregar mensaje de depuración
            userId
        } else {
            -1
        }
        cursor.close()
        return userId
    }
}
//    fun register(adminId: Int, userData: UserData): Boolean {
//        val adminUser = getUserById(adminId)
//        if (adminUser != null && adminUser.isAdmin) {
//            val db = readableDatabase
//            val contentValues = ContentValues().apply {
//                put("correo", userData.email)
//                put("contrasena", userData.password)
//                put("id", userData.id)
//                put("nombres", userData.nombres)
//                put("correo", userData.correo)
//                put("contrasena", userData.contrasena)
//                put("telefono", userData.telefono)
//                put("numero_cuenta", userData.numero_cuenta)
//                put("banco", userData.banco)
//                put("dni", userData.dni)
//                put("fecha_nacimiento", userData.fecha_nacimiento)
//                put("jefe", userData.jefe)
//                put("direccion", userData.direccion)
//                put("distrito", userData.distrito)
//                put("condicion", userData.condicion)
//                put("cargo_id", userData.cargo_id)
//            }
//
//            val result = db.insert("User", null, contentValues)
//            db.close()
//
//            return result != -1L
//        }
//
//        return false
//    }






