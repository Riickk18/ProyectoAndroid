package android.example.com.proyectoandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BuyProduct extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);
        ArrayList<String> lista = (ArrayList<String>) getIntent().getSerializableExtra("dato");
        mostrarFactura(lista);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    /** Metodo que muestra los contennidos del ArrayList del intent
     *@param lista
     */
    public void mostrarFactura( ArrayList<String> lista){
        TextView total=findViewById(R.id.total);
        TextView precio=findViewById(R.id.precio);
        total.setText(lista.get(1));
        precio.setText(lista.get(0)+"$");

    }

    /**Metodo que retorna a MainActivity y muestra un toast con el total de la compra y orden
     * @param view
     */
    public void finishShop(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        setResult(Activity.RESULT_FIRST_USER, intent);
        TextView total=findViewById(R.id.total);
        TextView precio=findViewById(R.id.precio);
        String price= (String) precio.getText();
        String tota = (String) total.getText();
        Toast.makeText(getApplicationContext(), "You have successfully purchased "+tota+" items for "+price+"", Toast.LENGTH_LONG).show();
        finish();
    }
}
