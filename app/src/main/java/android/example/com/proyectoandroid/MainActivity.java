package android.example.com.proyectoandroid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    public List<Product> products = new ArrayList<>();
    public ArrayList<String> listaString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            //Recibir el objeto de la segunda activity
            Bundle objetoEnviado = getIntent().getExtras();
            Product producto;

            if(savedInstanceState!=null){
                if(products!=null){
                    listaString = savedInstanceState.getStringArrayList("listaObjetos");
                    this.convertirListAProducts();
                    RVAdapter adapter = new RVAdapter(products);
                    rv.setAdapter(adapter);
                }
            }

            else{
                //RelativeLayout vRelative = findViewById(R.id.relativeLayout0);
                if(objetoEnviado!=null){
                    producto=(Product) objetoEnviado.getSerializable("product");
                    RecyclerView rv = findViewById(R.id.rv);
                    LinearLayoutManager llm = new LinearLayoutManager(this);
                    rv.setLayoutManager(llm);
                    products.add(producto);
                    objetoEnviado=null;
                    Toast.makeText(getApplicationContext(), String.valueOf(products.size()), Toast.LENGTH_SHORT).show();
                    RVAdapter adapter = new RVAdapter(products);
                    rv.setAdapter(adapter);
                }
                else{
                    this.carroVacio();
                }
            }
        }
        catch (NumberFormatException e){
            Log.d("hola",e.getMessage());
        }

    }
    

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.convertirListAString();
        outState.putStringArrayList("listaObjetos",listaString);
        // Save the state of the TextView
    }


    /**Muestra mensaje que indica que el carrito de compra se encuentra actualmente vacío
     *
     */
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
        Bundle bundle = new Bundle();
        this.onSaveInstanceState(bundle);
        Intent intent = new Intent(this, ListProduct.class);
        startActivity(intent);
    }

    public void convertirListAString(){
        int tamano = products.size();
        int tamanoArreglo=tamano*tamano;
        int i = 0;
        listaString.clear();
        while(i<tamanoArreglo){
            listaString.add(String.valueOf(products.get(i).getId()));
            listaString.add(products.get(i).getDescription());
            listaString.add(products.get(i).getPrice());
            i++;
        }
    }

    public void convertirListAProducts(){
        int tamano = listaString.size();
        int numberProduct=tamano/tamano;
        int i=0;
        while(i<tamano){
            products.add(new Product(Integer.parseInt(listaString.get(i)),listaString.get(i+1),listaString.get(i+2)));
            i=i+numberProduct;
        }

    }

    public void imprimirLista(ArrayList<String> lista){
        for(int i=0;i<lista.size();i++){
            Log.d("Elemento lista "+i+":", ""+ lista.get(i) +"");
        }
    }

}
