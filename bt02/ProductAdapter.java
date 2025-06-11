package com.example.bt02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mContext;
    private List<Product> productList;
    private TextView messageTextView;
    private OnAddToCartClickListener addToCartClickListener;
    private OnItemClickListener itemClickListener;

    public interface OnAddToCartClickListener {
        void onAddToCartClick(Product product);
    }

    public interface OnItemClickListener {
        void onItemClick(Product product);
    }

    public ProductAdapter(Context context, List<Product> productList, TextView messageTextView) {
        this.mContext = context;
        this.productList = productList;
        this.messageTextView = messageTextView;
    }

    public void setOnAddToCartClickListener(OnAddToCartClickListener listener) {
        this.addToCartClickListener = listener;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentProduct = productList.get(position);

        holder.imageView.setImageResource(currentProduct.getImageResource());
        holder.productName.setText(currentProduct.getName());
        holder.productQuantity.setText("Số Lượng: " + currentProduct.getQuantity());
        holder.productPrice.setText("Giá: " + currentProduct.getPrice());

        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addToCartClickListener != null) {
                    addToCartClickListener.onAddToCartClick(currentProduct);
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(currentProduct);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView productName;
        TextView productQuantity;
        TextView productPrice;
        Button btnAddToCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewRecycle);
            productName = itemView.findViewById(R.id.viewRecycleProductName);
            productQuantity = itemView.findViewById(R.id.viewRecycleProductQuantity);
            productPrice = itemView.findViewById(R.id.viewRecycleProductPrice);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }

    public void addProduct(Product product) {
        productList.add(product);
        notifyDataSetChanged();
        showMessage("Đã thêm sản phẩm: " + product.getName());
    }

    public void editProduct(int position, Product product) {
        productList.set(position, product);
        notifyItemChanged(position);
        showMessage("Đã chỉnh sửa sản phẩm: " + product.getName());
    }

    public void deleteProduct(int position) {
        Product deletedProduct = productList.remove(position);
        notifyItemRemoved(position);
        showMessage("Đã xóa sản phẩm: " + deletedProduct.getName());
    }

    private void showMessage(String message) {
        messageTextView.setText(message);
    }

    public void updateProduct(int position, int newQuantity, double newPrice) {
        Product product = productList.get(position);
        product.setQuantity(newQuantity);
        product.setPrice(newPrice);
        notifyItemChanged(position);
    }
}
