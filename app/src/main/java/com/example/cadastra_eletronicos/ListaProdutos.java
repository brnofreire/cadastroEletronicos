package com.example.cadastra_eletronicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListaProdutos extends AppCompatActivity {
    List<produto> lproduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);

        ListView lvprodutos= findViewById(R.id.listinha);
        produtoDAO produtoDAO =  new produtoDAO(this);
        lproduto = produtoDAO.listar();

        ArrayAdapter<produto> adapter = new ArrayAdapter<produto>(this, android.R.layout.simple_list_item_1, lproduto);

        lvprodutos.setAdapter(adapter);

    }
}