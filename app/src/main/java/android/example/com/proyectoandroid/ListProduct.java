package android.example.com.proyectoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ListProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /** * Displays a toast message for the phone order
     * and starts the MainActivity activity.
     * @param message Message to display.
     */
    public void showPhoneOrder(String message, Product product) {

        displayToast(message);
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", product);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * Shows a message that image was clicked.
     */
    public void showBluVivoXl3PlusOrder(View view) {
        Product product = new Product("blu_vivo_xl3_plus", view.getContentDescription().toString(),"139 $");
        showPhoneOrder(getString(R.string.order_blu_vivo_xl3_plus), product);
    }
}
