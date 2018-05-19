package android.example.com.proyectoandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ListProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
    }

    /**Metod que muestra un mensaje de tipo Toast
     * @param message
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**Metodo que muestra un toast del articulo seleccionado
     * Crea un intent y un bundle que almacena el producto
     * y devuelve un valor a la MainActivity
     * @param message
     * @param product
     */
    public void showPhoneOrder(String message, Product product) {

        displayToast(message);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();                   //Se crea el  bundle que guardara el objeto product
        bundle.putSerializable("product", product);     //Se asigna una clave y el objeto a enviar
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showBluVivoXl3PlusOrder(View view) {
        Product product = new Product(R.drawable.blu_vivo_xl3_plus, view.getContentDescription().toString(),"139");
        showPhoneOrder(getString(R.string.order_blu_vivo_xl3_plus), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showBqAquaris(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.bq_aquaris_x5, view.getContentDescription().toString(),"150");
        showPhoneOrder(getString(R.string.order_bq_aquaris_x5), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showEssential(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.essential_phone, view.getContentDescription().toString(),"489");
        showPhoneOrder(getString(R.string.order_essential_phone), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showGoogle(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.google_pixel_2, view.getContentDescription().toString(),"539");
        showPhoneOrder(getString(R.string.order_google_pixel_2), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showHonor(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.honor_7x, view.getContentDescription().toString(),"199");
        showPhoneOrder(getString(R.string.order_HONOR_7), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showHuaweiMate10(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.huawei_mate_10_pro, view.getContentDescription().toString(),"649");
        showPhoneOrder(getString(R.string.order_huawei_mate_10_pro), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showHuaweiP20(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.huawei_p20_pro, view.getContentDescription().toString(),"959");
        showPhoneOrder(getString(R.string.order_huawei_p20_pro), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showIphone8(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.iphone_8, view.getContentDescription().toString(),"801");
        showPhoneOrder(getString(R.string.order_iphone_8), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showIphoneX(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.iphone_x, view.getContentDescription().toString(),"1139");
        showPhoneOrder(getString(R.string.order_iphone_x), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showLgG7Thinq(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.lg_g7_thinq, view.getContentDescription().toString(),"600");
        showPhoneOrder(getString(R.string.order_lg_g7_thinq), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showLgG7Thinq2(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.lg_g7_thinq_2, view.getContentDescription().toString(),"750");
        showPhoneOrder(getString(R.string.order_lg_g7_thinq2), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showMate10Porsche(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.mate_10_porsche_design, view.getContentDescription().toString(),"1225");
        showPhoneOrder(getString(R.string.order_mate_10_porsche_design), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showMotorola(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.motorola_moto_g5, view.getContentDescription().toString(),"165");
        showPhoneOrder(getString(R.string.order_motorola_moto_g5), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showNokia8(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.nokia8_sirocco, view.getContentDescription().toString(),"600");
        showPhoneOrder(getString(R.string.order_nokia8_sirocco), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showNokia7(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.nokia_7, view.getContentDescription().toString(),"400");
        showPhoneOrder(getString(R.string.order_nokia_7), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showOneplus(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.oneplus_5t, view.getContentDescription().toString(),"637");
        showPhoneOrder(getString(R.string.order_oneplus_5t), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showRazer(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.razer_phone_black, view.getContentDescription().toString(),"649");
        showPhoneOrder(getString(R.string.order_razer_phone_black), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showA8(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.samsung_a8_2018, view.getContentDescription().toString(),"519");
        showPhoneOrder(getString(R.string.order_samsung_a8_2018), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showS9(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.samsung_galaxy_s9_plus, view.getContentDescription().toString(),"801");
        showPhoneOrder(getString(R.string.order_samsung_galaxy_s9_plus), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showMix(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.xiaomi_mi_mix, view.getContentDescription().toString(),"169");
        showPhoneOrder(getString(R.string.order_xiaomi_mi_mix), product);
    }

    /**Muestra un mensaje Toast del producto seleccionado
     * y crea un objeto de tipo producto
     * @param view
     */
    public void showMix2(View view) {
        //Creacion del objeto product
        Product product = new Product(R.drawable.xiaomi_mi_mix_2, view.getContentDescription().toString(),"448");
        showPhoneOrder(getString(R.string.order_xiaomi_mi_mix_2), product);
    }
}