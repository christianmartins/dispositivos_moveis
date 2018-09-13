package estacio.com.br.aula03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    private static final String CATEGORIA = "Script";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



    }

    protected void onStart() {
        super.onStart();
        Log.i(CATEGORIA,  getClassName() +".onStart();");
    }

    protected void onRestart(){
        super.onRestart();
        Log.i(CATEGORIA,  getClassName() +".onRestart();");
    }

    protected void onResume(){
        super.onResume();
        Log.i(CATEGORIA,  getClassName() +".onResume();");
    }

    protected void onPause(){
        super.onPause();
        Log.i(CATEGORIA,  getClassName() +".onPause();");
    }

    protected void onStop(){
        super.onStop();
        Log.i(CATEGORIA,  getClassName() +".onStop();");
    }

    private String getClassName(){
        String aux = getClass().getName();
        return (aux.substring(aux.lastIndexOf(".") + 1));
    }

    public void voltar(View view){
        finish();
    }

}
