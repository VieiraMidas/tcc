package br.com.etecia.tcc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "DBQrbot.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tbUsuarios(cpf text primary key, nome text, sobrenome text, email text, senha text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tbUsuarios");
    }

    public boolean insert(String nome, String sobrenome, String cpf, String email, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cV = new ContentValues();
        cV.put("nome", nome);
        cV.put("sobrenome", sobrenome);
        cV.put("cpf", cpf);
        cV.put("email", email);
        cV.put("senha", senha);

        long inserido = db.insert("tbUsuarios", null, cV);

        if (inserido == 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarCPF(String cpf) {
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from tbUsuarios where cpf=?", new String[]{cpf});
        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checarEmailSenha(String email, String senha) {
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from tbUsuarios where email=? and senha=?", new String[]{email,senha});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
