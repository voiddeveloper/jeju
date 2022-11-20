package com.voiddevloper.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.voiddevloper.myapplication.databinding.ItemCafesBinding;

import java.util.ArrayList;

public class CafesAdapter extends RecyclerView.Adapter<CafesAdapter.ViewHolder> {
    private ItemCafesBinding binding;
    private ArrayList<CafeItem> dataList = new ArrayList<>();
    // ViewHolder 생성하는 함수, 최소 생성 횟수만큼만 호출됨 (계속 호출 안됨)
    // 리스너 객체 참조를 저장하는 변수
    private OnItemClickListener onItemClickListener = null;

    @NonNull
    @Override
    public CafesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemCafesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    // 만들어진 ViewHolder에 데이터를 바인딩하는 함수
    @Override
    public void onBindViewHolder(CafesAdapter.ViewHolder holder, int position) {
        holder.bindItem(dataList.get(position), position);
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener ;
    }

    public void addItem(ArrayList<CafeItem> cafeItems){
        dataList.addAll(cafeItems);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemCafesBinding itemBinding;

        public ViewHolder(ItemCafesBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            itemView.setOnClickListener(v -> {
                int pos = getBindingAdapterPosition() ;
                if (pos != RecyclerView.NO_POSITION) {
                    onItemClickListener.onItemClick(v, pos);
                }
            });

        }

        void bindItem(CafeItem cafeItem, int position) {
            itemBinding.ivCafe.setImageResource(cafeItem.cafeImgSrc);
            itemBinding.tvCafeName.setText(cafeItem.cafeName);
            itemBinding.tvCafeHeart.setText(cafeItem.heartCount);
            itemBinding.tvCafeStar.setText(cafeItem.starCount);
            itemBinding.tvLocationName.setText(cafeItem.locationName);
            itemBinding.tvDescription.setText(cafeItem.locationDescription);
        }
    }
}
