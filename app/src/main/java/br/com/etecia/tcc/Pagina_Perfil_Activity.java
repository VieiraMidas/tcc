package br.com.etecia.tcc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Pagina_Perfil_Activity extends AppCompatActivity {

    List<Produto> listaProdutos;
    ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pagina__perfil);

        btnHome = findViewById(R.id.btnhomeperfil);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        listaProdutos = new ArrayList<>();

        listaProdutos.add(new Produto("Geladeira Coca Cola", R.drawable.logococacola));
        listaProdutos.add(new Produto("Caixa de som Bluetooth JBL", R.drawable.logojbl));
        listaProdutos.add(new Produto("Ventilador 6 Hélices Arno", R.drawable.arno));
        listaProdutos.add(new Produto("Controle SmartTV Samsung", R.drawable.logosamsung));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, listaProdutos);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }
}
