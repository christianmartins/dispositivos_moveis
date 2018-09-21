package estacio.com.br.aula05;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rdgAlter;
    private Button btnOK;
    private final String CORRETA = "E";
    private AlertDialog.Builder dlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgAlter = findViewById(R.id.rdgAlter);
        btnOK = findViewById(R.id.btnOK);
        dlg = new AlertDialog.Builder(MainActivity.this);

        rdgAlter.setOnCheckedChangeListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = rdgAlter.getCheckedRadioButtonId() == R.id.rdbE? "Parabens, Alternativa correta!": "Você não acertou, tente novamente";
                dlg.setTitle(R.string.app_name);
                dlg.setMessage(txt);
                dlg.setPositiveButton("OK", null);
                dlg.show();
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton rdb = findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(this, rdb.getText(), Toast.LENGTH_SHORT).show();
    }
}
