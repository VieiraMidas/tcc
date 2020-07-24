package br.com.etecia.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar_Activity extends AppCompatActivity {

    DatabaseHelper db;
    EditText txtNome, txtSobrenome, txtCPF, txtEmail, txtSenha, txtConfirmaSenha;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_layout);

        db = new DatabaseHelper(this);

        txtNome = findViewById(R.id.txtnome);
        txtSobrenome = findViewById(R.id.txtsobrenome);
        txtCPF = findViewById(R.id.txtcpf);
        txtEmail = findViewById(R.id.txtemail);
        txtSenha = findViewById(R.id.txtsenha);
        txtConfirmaSenha = findViewById(R.id.txtsenhaconfirmar);

        btnCadastrar = findViewById(R.id.btncadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome, sobrenome, cpf, email, senha, confirmaSenha;

                nome = txtNome.getText().toString();
                sobrenome = txtSobrenome.getText().toString();
                cpf = txtCPF.getText().toString();
                email = txtEmail.getText().toString();
                senha = txtSenha.getText().toString();
                confirmaSenha = txtConfirmaSenha.getText().toString();

                if (nome.equals("") || sobrenome.equals("") || cpf.equals("") || email.equals("") || senha.equals("")){
                    Toast.makeText(getApplicationContext(),"Favor inserir valores!",Toast.LENGTH_SHORT).show();
                } else {
                    if (senha.equals(confirmaSenha)){
                        Boolean checarCPF = db.validarCPF(cpf);
                        if (checarCPF == true){
                            Boolean inserir = db.insert(nome, sobrenome,cpf,email,senha);
                            if (inserir==true){
                                Intent intent = new Intent(getApplicationContext(), Login_activity.class);
                                startActivity(intent);

                                Toast.makeText(getApplicationContext(), "Cadastro feito com sucesso",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(),"CPF já em uso, por favor, digitar outro!",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Senha não confere!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
