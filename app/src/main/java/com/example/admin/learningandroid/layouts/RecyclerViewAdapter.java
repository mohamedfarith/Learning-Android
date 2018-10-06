package com.example.admin.learningandroid.layouts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.learningandroid.R;

import static com.example.admin.learningandroid.Constants.LIST;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String[] mStr;
    private Context mContext;

    public RecyclerViewAdapter(String[] mStr, Context mContext) {
        this.mStr = mStr;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder) holder).txtRecyclerView.setText(mStr[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Intent intent;
                for (int i = holder.getAdapterPosition(); i < position + 1; i++) {
                    intent = new Intent(mContext, RecyclerViewList.class);
                    intent.putExtra(LIST, mStr[i]);
                    mContext.startActivity(intent);
                }
               /* switch(holder.getAdapterPosition()){
                    case 0:
                        intent=new Intent(mContext,RecyclerViewList.class);
                        intent.putExtra("DataTransferBetweenFragments",mStr[position]);
                        mContext.startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(mContext,RecyclerViewList.class);
                        intent.putExtra("DataTransferBetweenFragments",mStr[position]);
                        mContext.startActivity(intent);
                        break;

                }*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return mStr.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            txtRecyclerView = itemView.findViewById(R.id.txt_recycler_view_list);

        }


    }
}
