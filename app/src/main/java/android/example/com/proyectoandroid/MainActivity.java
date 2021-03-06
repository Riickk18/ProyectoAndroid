package android.example.com.proyectoandroid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    RelativeLayout container;
    public List<Product> products = new ArrayList<>();
    public ArrayList<String> buy = new ArrayList<>();
    FloatingActionButton bBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            this.carroVacio();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putStringArrayList("listaObjetos",listaString);
    }


    /**Muestra mensaje que indica que el carrito de compra se encuentra actualmente vacío
     *
     */
    public void carroVacio(){
        bBuy = (FloatingActionButton) findViewById(R.id.comprar);
        bBuy.hide();
        container = new RelativeLayout(getApplicationContext());
        container.setLayoutParams(new RelativeLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        container.setGravity(Gravity.CENTER);
        ImageView imagen = new ImageView(getApplicationContext());
        TextView texto = new TextView(getApplicationContext());
        texto.setText("Tu carrito se encuentra actualmente vacío");
        texto.setTextColor(Color.GRAY);
        texto.setTextSize(15);
        imagen.setImageResource(R.drawable.carro);
        imagen.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int ancho = 250;
        int alto = 250;
        LinearLayout.LayoutParams parametro = new LinearLayout.LayoutParams(ancho, alto, Gravity.CENTER);
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
     * @param view
     */
    public void bAgregarArticulo(View view) {
        Intent intent = new Intent(this, ListProduct.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            container.setVisibility(View.INVISIBLE);
            bBuy = (FloatingActionButton) findViewById(R.id.comprar);
            bBuy.show();
            Bundle objetoEnviado = data.getExtras();
            Product producto = (Product) objetoEnviado.getSerializable("product");
            RecyclerView rv = findViewById(R.id.rv);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            if(products.size()<10){//valido que el carrito solo tenga 10 artículos
                products.add(producto);//anado el producto recibido a la lista
                RVAdapter adapter = new RVAdapter(products);
                rv.setAdapter(adapter);//crea la interfaz del carro con la lista productos
                int montoC=0;
                for(int i=0;i<products.size();i++){//calculo el monto total de la compra
                    montoC=montoC+Integer.parseInt(products.get(i).getPrice());
                }
                TextView precioCompra = findViewById(R.id.costoCompra);
                precioCompra.setText("Total purchase: "+String.valueOf(montoC)+"$");
                buy.clear();
                buy.add(0, String.valueOf(montoC));
                buy.add(1, String.valueOf(products.size()));
            }
            else{
                Toast.makeText(getApplicationContext(), "You can only order a maximum of 10 articles", Toast.LENGTH_LONG).show();
            }
        }
        else if(resultCode == Activity.RESULT_FIRST_USER) {
            products.clear();
            carroVacio();
            TextView precioCompra = findViewById(R.id.costoCompra);
            precioCompra.setText("");
            Product producto = new Product(0,"","");        //borrar lista de la compra anterior
            products.add(producto);
            RecyclerView rv = findViewById(R.id.rv);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            RVAdapter adapter = new RVAdapter(products);
            rv.setAdapter(adapter);
            products.clear();
        }
        else{

        }
    }

    /**
     * Meetodo que llama a la actividad para la compra de los productos
     * @param view
     */
    public void buyPhone(View view) {
        Intent intent = new Intent(this, BuyProduct.class);
        intent.putExtra("dato", buy);
        startActivityForResult(intent,1);
    }
}
