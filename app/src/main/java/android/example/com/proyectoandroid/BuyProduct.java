package android.example.com.proyectoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class BuyProduct extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);
        ArrayList<String> lista = (ArrayList<String>) getIntent().getSerializableExtra("dato");
        mostrarFactura(lista);
    }
    
    public void mostrarFactura( ArrayList<String> lista){
        TextView total=findViewById(R.id.total);
        TextView precio=findViewById(R.id.precio);
        total.setText(lista.get(1));
        precio.setText(lista.get(0));

    }

    public void finishShop(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
