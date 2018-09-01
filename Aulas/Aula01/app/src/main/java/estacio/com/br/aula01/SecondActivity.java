package estacio.com.br.aula01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button btnPrimeiraTela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        btnPrimeiraTela = (Button) findViewById(R.id.btnVoltar);
        btnPrimeiraTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IrPrimeiraTela();
            }
        });


    }

    void IrPrimeiraTela(){
        Intent intent = new Intent();
        intent.setClass(SecondActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
