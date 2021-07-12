package cl.rom.proy_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void turismo(View view){
        Intent turismo = new Intent(this, turismo.class);
        startActivity(turismo);
    }
    public void QS(View view){
        Intent qs = new Intent(this, QuienesSomos.class);
        startActivity(qs);
    }

    public void Salir(View view){
        System.exit(0);
    }

}