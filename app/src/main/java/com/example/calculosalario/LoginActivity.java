package com.example.calculosalario;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etEmailLogin, etSenhaLogin;
    Button btnEntrar, btnIrCadastro;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmailLogin = findViewById(R.id.etEmailLogin);
        etSenhaLogin = findViewById(R.id.etSenhaLogin);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnIrCadastro = findViewById(R.id.btnIrCadastro);
        prefs = getSharedPreferences("usuarios", MODE_PRIVATE);

        btnEntrar.setOnClickListener(v -> {
            String email = etEmailLogin.getText().toString();
            String senha = etSenhaLogin.getText().toString();

            String senhaSalva = prefs.getString(email, null);

            if (senhaSalva != null && senhaSalva.equals(senha)) {
                Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, CalculadoraActivity.class));
            } else {
                Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
            }
        });

        btnIrCadastro.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });
    }
}
