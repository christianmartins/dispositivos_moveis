package estacio.com.br.aula03;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.view.MenuItem;


public class CalculoIMCActivity extends Activity implements View.OnClickListener{

    private EditText edtPeso;
    private EditText edtAltura;
    private EditText edtResultado;
    private Button btnCalcular;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        edtPeso =  findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        edtResultado = findViewById(R.id.edtResutado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso = Double.parseDouble(edtPeso.getText().toString());
                double altura = Double.parseDouble(edtAltura.getText().toString());
                double resultado = (peso / Math.pow(altura, 2));
                edtResultado.setText(String.format("%.2f", resultado));
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPeso.setText("");
                edtAltura.setText("");
                edtResultado.setText("");
                edtPeso.requestFocus();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id ==  R.id.btnCalcular){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
/*
        if(v.getId() ==  R.id.btnCalcular){
            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double resultado = (peso / Math.pow(altura, 2));
            edtResultado.setText(String.format("%.2f", resultado));
        }
        else if(v.getId() ==  R.id.btnLimpar){
            edtPeso.setText("");
            edtAltura.setText("");
            edtResultado.setText("");
            edtPeso.requestFocus();
        }
*/
    }


}
