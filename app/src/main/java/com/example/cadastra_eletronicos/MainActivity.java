package com.example.cadastra_eletronicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    Button signup;
    EditText email, senha;
    Boolean verificaNomeSenha;
    DBHelper dbHelper;
    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        dbHelper = new DBHelper(this);
        DB = new DBHelper(this);


        // TELA LOGIN
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emails = email.getText().toString().trim();
                String Edtsenha = senha.getText().toString().trim();

                if (TextUtils.isEmpty(emails) || TextUtils.isEmpty(Edtsenha)) {
                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    final Context context = MainActivity.this;
                    Boolean checkuserpass = DB.verificaNomeSenha(context, emails, Edtsenha);
                    if (checkuserpass) {
                        Intent intent = new Intent(getApplicationContext(), produtos.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Login Incorreto", Toast.LENGTH_SHORT).show();
                    }
            }}
        });

        // TELA CRIAR CONTA
        signup = findViewById(R.id.btnsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent busca = new Intent(MainActivity.this, cadastraUser.class);
                startActivity(busca);
            }
        });
    }


}

//SET TEXT PRA INVERTER O EDTTEXT E USAR ISSO NO NOME USUARIO !!!