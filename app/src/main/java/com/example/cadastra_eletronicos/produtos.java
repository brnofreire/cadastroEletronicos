package com.example.cadastra_eletronicos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class produtos extends AppCompatActivity {

    private TextView txtWelcome;
    private TextView btnCadpro;
    private Button btnListagemProdutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        txtWelcome = findViewById(R.id.txtWelcome);
        btnCadpro = findViewById(R.id.btnCadastroProduto);
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String nomeUsuario = preferences.getString("nomeUsuario", "Nome do Usuário");
        TextView txtNomeUsuario = findViewById(R.id.txtWelcome);
        txtNomeUsuario.setText(nomeUsuario);
        btnCadpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intencao = new Intent(produtos.this, cadastraProd.class);
                startActivity(intencao);
            }
        });


        btnListagemProdutos = findViewById(R.id.btnListagemProdutos);

        // Obtém o nome de usuário logado (pode ser obtido de uma variável de autenticação, por exemplo)
        //String nomeUsuario = "Usuário Logado";

        // Exibe o nome do usuário na TextView de boas-vindas
        //txtWelcome.setText("Bem-vindo, " + nomeUsuario + "!");






            btnListagemProdutos.setOnClickListener(v -> {
                // Chamar a tela de listagem de produtos
                Intent intent3 = new Intent(produtos.this, ListaProdutos.class);
                startActivity(intent3);
            });
        }


    }



