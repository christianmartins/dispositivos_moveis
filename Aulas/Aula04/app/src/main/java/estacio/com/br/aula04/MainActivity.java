package estacio.com.br.aula04;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CheckBox.OnCheckedChangeListener{

    private CheckBox ckbCi;
    private CheckBox ckbFu;
    private CheckBox ckbGa;
    private CheckBox ckbIn;
    private CheckBox ckbLi;
    private CheckBox ckbTe;
    private CheckBox ckbSel;
    private TextView txtSel;
    private Button btnEx;
    private Button btnDes;
    private int cont;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ckbCi = findViewById(R.id.ckbCinema);
        ckbFu = findViewById(R.id.ckbFutebol);
        ckbGa = findViewById(R.id.ckbGastronomia);
        ckbIn = findViewById(R.id.ckbInformatica);
        ckbTe = findViewById(R.id.ckbTeatro);
        ckbLi = findViewById(R.id.ckbLiteratura);
        txtSel = findViewById(R.id.txtTotalSelecionados);
        btnEx = findViewById(R.id.btnExibir);
        btnDes = findViewById(R.id.btnDesmarcar);

        ckbCi.setOnCheckedChangeListener(this);
        ckbFu.setOnCheckedChangeListener(this);
        ckbGa.setOnCheckedChangeListener(this);
        ckbIn.setOnCheckedChangeListener(this);
        ckbLi.setOnCheckedChangeListener(this);
        ckbTe.setOnCheckedChangeListener(this);

        btnEx.setOnClickListener(this);
        btnDes.setOnClickListener(this);
        cont = 0;
        exibirSelecionados();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnExibir:
                String txt = "Temas Selecionados\n\n";
                txt += ckbCi.isChecked()?"Cinema\n" : "";
                txt += ckbFu.isChecked()?"Futebol\n" : "";
                txt += ckbGa.isChecked()?"Gastronomia\n" : "";
                txt += ckbIn.isChecked()?"Informatica\n" : "";
                txt += ckbLi.isChecked()?"Literatura\n" : "";
                txt += ckbTe.isChecked()?"Teatro\n" : "";

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage(txt);
                dlg.show();
                break;
            case R.id.btnDesmarcar:
                ckbCi.setChecked(false);
                ckbFu.setChecked(false);
                ckbGa.setChecked(false);
                ckbIn.setChecked(false);
                ckbLi.setChecked(false);
                ckbTe.setChecked(false);
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        if(isChecked == true){
            cont++;
        }
        else{
            cont--;
        }
        exibirSelecionados();
    }

    public void exibirSelecionados(){
        String txt = "Total de textos selecionados";
        txtSel.setText(String.format("%s= %d", txt, cont));
    }
}
