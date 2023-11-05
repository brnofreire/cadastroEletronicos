package com.example.cadastra_eletronicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastraUser extends AppCompatActivity {


    EditText nome, email, senha, resenha;
    //Button signup, signin;
    Button cadastrar, acessar;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_user);

        nome = (EditText) findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);
        resenha = (EditText) findViewById(R.id.resenha);
        cadastrar = (Button) findViewById(R.id.button4);
        DB = new DBHelper(this);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = nome.getText().toString();
                String emails = email.getText().toString();
                String pass = senha.getText().toString();
                String repass = resenha.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(cadastraUser.this, "Por favor, digite os dados!", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.verificaNome(emails);
                        if(checkuser==false){
                            Boolean insert = DB.cadastra(user,emails, pass);
                            if(insert==true){
                                Toast.makeText(cadastraUser.this, "Dados armazenados com sucesso!",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(cadastraUser.this, "Falha durante a operação de registro!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(cadastraUser.this, "Usuário existente! Favor Logar",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(cadastraUser.this, "Senhas são diferentes!", Toast.LENGTH_SHORT).show();
                    }
                } }
        });
    }
}