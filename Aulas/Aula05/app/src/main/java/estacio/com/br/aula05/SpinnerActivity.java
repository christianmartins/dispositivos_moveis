package estacio.com.br.aula05;

import android.app.AlertDialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Spinner spnNomes;
    private Spinner spnCidades;
    private Button btnCadastrar;
    private List<String> listaCidades;
    private String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spnNomes = findViewById(R.id.spnNomes);
        spnCidades = findViewById(R.id.spnCidades);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        spnNomes.setOnItemSelectedListener(this);
        spnCidades.setOnItemSelectedListener(this);
        btnCadastrar.setOnClickListener(this);

        carregarListaNomes();
        
        carregarListaCidades();
        
    }

    private void carregarListaNomes() {
        ArrayAdapter adp = ArrayAdapter.createFromResource(this, R.array.lista_nome, android.R.layout.simple_spinner_item);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNomes.setAdapter(adp);
    }

    private void carregarListaCidades() {
        listaCidades = new ArrayList<String>();
        listaCidades.add("Americana");
        listaCidades.add("Araraquara");
        listaCidades.add("Batatais");
        listaCidades.add("Campinas");
        listaCidades.add("Limeiras");
        listaCidades.add("Riberão Preto");
        listaCidades.add("São Paulo");

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCidades);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCidades.setAdapter(adp);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnCadastrar){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Aula05");

            dlg.setMessage("Nome: "+ spnNomes.getSelectedItem().toString() +"\nCidade: "+ spnCidades.getSelectedItem().toString());
            dlg.setPositiveButton("OK", null);
            dlg.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
