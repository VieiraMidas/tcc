package br.com.etecia.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btnConfig, btnSair, btnBatePapo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfig = findViewById(R.id.btnbolinhas);
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pagina_Perfil_Activity.class);
                startActivity(intent);
            }
        });

        btnSair = findViewById(R.id.btnsaida);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login_activity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Volte sempre!",Toast.LENGTH_SHORT).show();
            }
        });
        btnBatePapo = findViewById(R.id.btnchat);
        btnBatePapo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chat_Activity.class);
                startActivity(intent);
            }
        });
    }
}
