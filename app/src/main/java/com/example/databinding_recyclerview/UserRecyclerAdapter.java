package com.example.databinding_recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.databinding_recyclerview.databinding.ProductRowBinding;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {

    private static final String TAG = "UserRecyclerAdapter";
    
    List<User> userList;

    public UserRecyclerAdapter(List<User> userList) {
        this.userList = userList;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //        View view = layoutInflater.inflate(R.layout.product_row, parent, false);
        //        return new UserViewHolder(view);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ProductRowBinding productRowBinding = ProductRowBinding.inflate(layoutInflater, parent, false);

        return new UserViewHolder(productRowBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
//        User user = userList.get(position);
//        holder.bind(user);

        final User user = userList.get(position);
        holder.productRowBinding.setUser(user);
        holder.productRowBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        //        ImageView imageView;
//        TextView nameTextView;
//        TextView ageTextView;
//        Button activeButton;
//
//        public UserViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imageView = itemView.findViewById(R.id.imageView);
//            nameTextView = itemView.findViewById(R.id.nameTextView);
//            ageTextView = itemView.findViewById(R.id.ageTextView);
//            activeButton = itemView.findViewById(R.id.activeButton);
//        }
//
//        public void bind(@NonNull User user) {
//            nameTextView.setText(user.getName());
//            ageTextView.setText(String.valueOf(user.getAge()));
//            activeButton.setEnabled(user.isActive());
//            activeButton.setText(user.isActive() ? "Active" : "Not Active");
//            Glide.with(imageView)
//                    .load(user.getImageUrl())
//                    .into(imageView);
//        }


        ProductRowBinding productRowBinding;

        public UserViewHolder(@NonNull ProductRowBinding productRowBinding) {
            super(productRowBinding.getRoot());
            this.productRowBinding = productRowBinding;

            productRowBinding.activeButtonId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClicked: "+ userList.get(getAdapterPosition()));
                }
            });
        }

    }


}
