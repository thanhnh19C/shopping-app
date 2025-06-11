package com.example.bt02;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewHolder extends RecyclerView.ViewHolder {
    // Assuming these are the correct field types, update if needed
    public TextView productName;
    public TextView quantity;
    public TextView price;

    public TextView pricenew;
    public Button btnAddToCart;
    ImageView addToCartImage;

    private List<Product> productList; // Add this field

    public ViewHolder(View itemView, ProductAdapter.OnAddToCartClickListener addToCartClickListener, List<Product> productList) {
        super(itemView);
        addToCartImage = itemView.findViewById(R.id.imageViewRecycle);
        productName = itemView.findViewById(R.id.viewRecycleProductName);
        quantity = itemView.findViewById(R.id.viewRecycleProductQuantity);
        price = itemView.findViewById(R.id.viewRecycleProductPrice);

        btnAddToCart = itemView.findViewById(R.id.btnAddToCart);

        this.productList = productList; // Initialize the productList

        // Set a click listener for addToCartImage
        addToCartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && addToCartClickListener != null) {
                    Product product = productList.get(position);
                    addToCartClickListener.onAddToCartClick(product);
                }
            }
        });
    }
}
