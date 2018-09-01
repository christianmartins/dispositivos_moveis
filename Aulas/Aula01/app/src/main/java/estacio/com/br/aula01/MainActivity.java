package estacio.com.br.aula01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSecondTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecondTela = (Button) findViewById(R.id.btnSecond);
        btnSecondTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IrSegundaTela();
            }
        });

    }

    void IrSegundaTela(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();
    }
}
