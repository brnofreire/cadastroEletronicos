package com.example.cadastra_eletronicos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class cadastraProd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void minserir(View view){
        EditText etNome =  findViewById(R.id.nomeProduto);
        EditText etquantidade = findViewById(R.id.qntProduto);
        EditText estquantidade=  findViewById(R.id.nome);
        produto produto = new produto(etNome.getText().toString(), Integer.parseInt(etquantidade.getText().toString()),Integer.parseInt(estquantidade.getText().toString()));

        produtoDAO produtoDAO = new produtoDAO(this);
        long id = produtoDAO.inserir(produto);

        Toast.makeText(this, "Produto salvo, " + id, Toast.LENGTH_LONG).show();
    }

    public  void  mListar(View view){

        Intent ListaProdutos = new Intent(this , ListaProdutos.class);
        startActivity(ListaProdutos);

    }
}