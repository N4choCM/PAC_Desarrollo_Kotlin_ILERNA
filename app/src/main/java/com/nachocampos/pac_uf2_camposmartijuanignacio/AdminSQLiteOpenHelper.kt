package com.nachocampos.pac_uf2_camposmartijuanignacio

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

class AdminSQLiteOpenHelper(context: Context, name: String, factory: CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {

    /**
     * Al instanciarse esta clase, se crea la tabla "plantas".
     */
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table plantas(id_planta int primary key, nombre text, precio real)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}