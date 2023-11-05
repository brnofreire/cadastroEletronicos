package com.example.cadastra_eletronicos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Banco.db";
    public DBHelper(Context context) {
        super(context, DBNAME , null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table usuario(nomeUsuario TEXT, email TEXT primary key, senha TEXT)");
        MyDB.execSQL("create Table produtos(codigo INT primary key, descricao TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists usuario");
    }
    public Boolean cadastra(String nomeUsuario, String email, String senha){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("nomeUsuario", nomeUsuario);
        contentValues.put("email", email);
        contentValues.put("senha", senha);
        long result = MyDB.insert("usuario", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean verificaNome(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from usuario where email = ?", new String[]
                {email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean verificaNomeSenha(Context context, String email, String senha) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM usuario WHERE email = ? AND senha = ?", new String[] { email, senha });
        if (cursor.getCount() > 0) {
            // Login bem-sucedido, obtenha o nome do usuário e armazene-o nas preferências compartilhadas
            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String nomeUsuario = cursor.getString(cursor.getColumnIndex("nomeUsuario"));
                SharedPreferences preferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nomeUsuario", nomeUsuario);
                editor.apply();
            }
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }
}
















