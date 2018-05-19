package android.example.com.proyectoandroid;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    List<Product> productos;

    RVAdapter(List<Product> persons){//constructor que recibe la lista de productos
        this.productos = persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {//asigna los valores al cardview producto a producto
        personViewHolder.price.setText(productos.get(i).getPrice()+" $");
        personViewHolder.descrip.setText(productos.get(i).getDescription());
        personViewHolder.image.setImageResource(productos.get(i).getId());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public int getItemCount() {//cuenta cuantos productos tiene la lista
        return productos.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView price;
        TextView descrip;
        ImageView image;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardview);
            price = (TextView)itemView.findViewById(R.id.price);
            descrip = (TextView)itemView.findViewById(R.id.desc);
            image = (ImageView)itemView.findViewById(R.id.img);
        }
    }

}
