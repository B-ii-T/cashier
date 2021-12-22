package com.bit.cashier;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import com.bit.cashier.MainActivity.*;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder> {
    private ArrayList<Unit> units;
    public UnitAdapter(ArrayList<Unit> units){
        this.units = units;
    }

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View unit_item= layoutInflater.inflate(R.layout.unit_item, parent, false);
        return new UnitViewHolder(unit_item);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitViewHolder holder, int position) {
        String name  = units.get(position).getName();
        int counter = units.get(position).getCount();
        holder.unit_text.setText(name);
        holder.count_txt.setText(String.valueOf(counter));
    }

    @Override
    public int getItemCount() {
        return units.size();
    }

    public class UnitViewHolder extends RecyclerView.ViewHolder{
        public TextView unit_text, count_txt;
        public Button plus, minus;
        public UnitViewHolder(@NonNull View itemView) {
            super(itemView);
            unit_text = itemView.findViewById(R.id.unit_txt);
            count_txt = itemView.findViewById(R.id.counter);
            plus = itemView.findViewById(R.id.plus);
            minus = itemView.findViewById(R.id.minus);
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int c = Integer.parseInt(count_txt.getText().toString());
                    c += 1;
                    count_txt.setText(String.valueOf(c));
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int c = Integer.parseInt(count_txt.getText().toString());
                    if (c >= 1){c -= 1;}
                    else if (c < 1 && c >0){c -= 1;}
                    count_txt.setText(String.valueOf(c));
                }
            });
        }
    }

}
