package br.com.etecia.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {

    EditText txtEmail, txtSenha;
    Button btnEntrar;
    TextView txtCadastrar;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        txtEmail = findViewById(R.id.txtemaillogin);
        txtSenha = findViewById(R.id.txtsenhalogin);

        btnEntrar = findViewById(R.id.btnentrar);

        db = new DatabaseHelper(this);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, senha;

                email = txtEmail.getText().toString();
                senha = txtSenha.getText().toString();

                Boolean checarEmailSenha = db.checarEmailSenha(email, senha);

                Boolean validado = true;
                if (txtEmail.getText().length() == 0) {
                    txtEmail.setError("Campo Email Obrigatório");
                    txtEmail.requestFocus();
                    validado = false;
                }
                if (txtSenha.getText().length() == 0) {
                    txtSenha.setError("Campo Senha Obrigatório");
                    txtSenha.requestFocus();
                    validado = false;
                }
                if (validado==true) {
                    if (checarEmailSenha == true) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "Logado com êxito", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Acesso Negado!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        txtCadastrar = findViewById(R.id.txtCadastrar);

        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cadastrar_Activity.class);
                startActivity(intent);
            }
        });
    }
}
