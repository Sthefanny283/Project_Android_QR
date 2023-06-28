package com.cursoklotin.intento.managers
import android.content.Context
import android.content.SharedPreferences
import com.cursoklotin.intento.UserData
import android.util.Log

class UserManager private constructor(context: Context) {
    companion object {
        private const val PREF_NAME = "user_manager"
        private const val KEY_USER_ID = "user_id"

        private var instance: UserManager? = null

        fun getInstance(context: Context): UserManager {
            if (instance == null) {
                instance = UserManager(context.applicationContext)
            }
            return instance as UserManager
        }
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var userId: Int
        get() = sharedPreferences.getInt(KEY_USER_ID, -1)
        set(value) {
            sharedPreferences.edit().putInt(KEY_USER_ID, value).apply()
        }

    var userData: UserData?
        get() {
            val id = sharedPreferences.getInt("id", -1)
            val nombres = sharedPreferences.getString("nombres", "") ?: ""
            val correo = sharedPreferences.getString("correo", "") ?: ""
            val contrasena = sharedPreferences.getString("contrasena", "") ?: ""
            val sexo = sharedPreferences.getString("sexo", "") ?: ""
            val telefono = sharedPreferences.getString("telefono", "") ?: ""
            val numeroCuenta = sharedPreferences.getString("numeroCuenta", "") ?: ""
            val banco = sharedPreferences.getString("banco", "") ?: ""
            val dni = sharedPreferences.getString("dni", "") ?: ""
            val fechaNacimiento = sharedPreferences.getString("fechaNacimiento", "") ?: ""
            val jefe = sharedPreferences.getString("jefe", "") ?: ""
            val direccion = sharedPreferences.getString("direccion", "") ?: ""
            val distrito = sharedPreferences.getString("distrito", "") ?: ""
            val condicion = sharedPreferences.getString("condicion", "") ?: ""
            val cargo = sharedPreferences.getString("cargo", "") ?: ""
            val rol = sharedPreferences.getString("rol", "") ?: ""
            val fechaCreacion = sharedPreferences.getString("fechaCreacion", "") ?: ""
            val ultimaActualizacion = sharedPreferences.getString("ultimaActualizacion", "") ?: ""
            val estadoCuenta = sharedPreferences.getString("estadoCuenta", "") ?: ""
            val imagenPerfil = sharedPreferences.getString("imagenPerfil", "") ?: ""

            return if (id != -1) {
                UserData(
                    id,
                    nombres,
                    correo,
                    contrasena,
                    sexo,
                    telefono,
                    numeroCuenta,
                    banco,
                    dni,
                    fechaNacimiento,
                    jefe,
                    direccion,
                    distrito,
                    condicion,
                    cargo,
                    rol,
                    fechaCreacion,
                    ultimaActualizacion,
                    estadoCuenta,
                    imagenPerfil
                )
            } else {
                null
            }
        }
        set(value) {
            if (value != null) {
                sharedPreferences.edit().apply {
                    putInt("id", value.id)
                    putString("nombres", value.nombres)
                    putString("correo", value.correo)
                    putString("contrasena", value.contrasena)
                    putString("sexo", value.sexo)
                    putString("telefono", value.telefono)
                    putString("numeroCuenta", value.numeroCuenta)
                    putString("banco", value.banco)
                    putString("dni", value.dni)
                    putString("fechaNacimiento", value.fechaNacimiento)
                    putString("jefe", value.jefe)
                    putString("direccion", value.direccion)
                    putString("distrito", value.distrito)
                    putString("condicion", value.condicion)
                    putString("cargo", value.cargo)
                    putString("rol", value.rol)
                    putString("fechaCreacion", value.fechaCreacion)
                    putString("ultimaActualizacion", value.ultimaActualizacion)
                    putString("estadoCuenta", value.estadoCuenta)
                    putString("imagenPerfil", value.imagenPerfil)
                    apply()
                }
            } else {
                sharedPreferences.edit().clear().apply()
            }
        }

    fun isLoggedIn(): Boolean = userId != -1

    fun updateUserData(nuevoCorreo: String, nuevoTelefono: String) {
        val userData = userData ?: return

        // Actualizar los campos de correo y teléfono
        userData.correo = nuevoCorreo
        userData.telefono = nuevoTelefono

        // Guardar los nuevos datos de usuario en el estado global
        this.userData = userData
    }

    fun resetUserData() {
        sharedPreferences.edit().clear().apply()
    }

}
