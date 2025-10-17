package com.example.calculosalario;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class CalculadoraActivity extends AppCompatActivity {

    EditText etNomeFunc, etSalarioBruto, etFilhos;
    RadioGroup rgSexo;
    Button btnCalcular, btnNovo;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        etNomeFunc = findViewById(R.id.etNomeFunc);
        etSalarioBruto = findViewById(R.id.etSalarioBruto);
        etFilhos = findViewById(R.id.etFilhos);
        rgSexo = findViewById(R.id.rgSexo);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        btnNovo = findViewById(R.id.btnNovo);

        btnCalcular.setOnClickListener(v -> calcularSalario());
        btnNovo.setOnClickListener(v -> limparCampos());
    }

    private void calcularSalario() {
        String nome = etNomeFunc.getText().toString();
        String salarioStr = etSalarioBruto.getText().toString();
        String filhosStr = etFilhos.getText().toString();

        if (nome.isEmpty() || salarioStr.isEmpty() || filhosStr.isEmpty() || rgSexo.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        double salarioBruto = Double.parseDouble(salarioStr);
        int filhos = Integer.parseInt(filhosStr);

        double inss = 0;
        if (salarioBruto <= 1212) inss = salarioBruto * 0.075;
        else if (salarioBruto <= 2427.35) inss = salarioBruto * 0.09;
        else if (salarioBruto <= 3641.03) inss = salarioBruto * 0.12;
        else if (salarioBruto <= 7087.22) inss = salarioBruto * 0.14;

        double ir = 0;
        if (salarioBruto <= 1903.98) ir = 0;
        else if (salarioBruto <= 2826.65) ir = salarioBruto * 0.075;
        else if (salarioBruto <= 3751.05) ir = salarioBruto * 0.15;
        else if (salarioBruto <= 4664.68) ir = salarioBruto * 0.225;
        else ir = salarioBruto * 0.275;

        double salarioFamilia = (salarioBruto <= 1212) ? (56.47 * filhos) : 0;
        double salarioLiquido = salarioBruto - inss - ir + salarioFamilia;

        RadioButton rb = findViewById(rgSexo.getCheckedRadioButtonId());
        String tratamento = rb.getText().toString().equals("Masculino") ? "Sr. " : "Sra. ";

        String resultado = tratamento + nome + "\n\n" +
                "Salário Bruto: R$ " + String.format("%.2f", salarioBruto) + "\n" +
                "Desconto INSS: R$ " + String.format("%.2f", inss) + "\n" +
                "Desconto IR: R$ " + String.format("%.2f", ir) + "\n" +
                "Salário Família: R$ " + String.format("%.2f", salarioFamilia) + "\n\n" +
                "Salário Líquido: R$ " + String.format("%.2f", salarioLiquido);

        tvResultado.setText(resultado);
    }

    private void limparCampos() {
        etNomeFunc.setText("");
        etSalarioBruto.setText("");
        etFilhos.setText("");
        rgSexo.clearCheck();
        tvResultado.setText("");
    }
}
