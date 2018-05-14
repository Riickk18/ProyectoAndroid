package android.example.com.proyectoandroid;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout vRelative = findViewById(R.id.relativeLayout0);
        if(savedInstanceState==null){
            vRelative.setVisibility(View.GONE);
            this.carroVacio();
        }
    }







    public void carroVacio(){
        RelativeLayout container = new RelativeLayout(getApplicationContext());
        container.setLayoutParams(new RelativeLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        container.setGravity(Gravity.CENTER);
        ImageView imagen = new ImageView(getApplicationContext());
        TextView texto = new TextView(getApplicationContext());
        texto.setText("Tu carrito se encuentra actualmente vacío");
        texto.setTextColor(Color.GRAY);
        texto.setTextSize(15);
        imagen.setImageResource(R.drawable.carro);
        int ancho = 150;
        int alto = 150;
        LinearLayout.LayoutParams parametro = new LinearLayout.LayoutParams(ancho, alto);
        imagen.setLayoutParams(parametro);
        container.addView(imagen);
        container.addView(texto);
        FrameLayout.LayoutParams parametro2 = new FrameLayout.LayoutParams(550, 1500, Gravity.CENTER);
        addContentView(container, parametro2);
    }


    /**
     * Método que recibe un View, al recibir este view genera un intent
     * el cuál recibe el contexto de la view y la clase ListProduct como parámetros
     * finalmente llama a la activity ListProduct con el intent generado
     */
    public void bAgregarArticulo(View view) {
        Intent intent = new Intent(this, ListProduct.class);
        startActivity(intent);
    }

}
