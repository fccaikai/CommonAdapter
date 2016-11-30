package com.kcode.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by caik on 2016/11/30.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public final View itemView;
    private SparseArray<View> views;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        views = new SparseArray<>();
    }

    private <T extends View> T findViewById(int id) {
        return (T) itemView.findViewById(id);
    }

    public View getView(int id) {
        View view = views.get(id);
        if (view == null) {
            view = findViewById(id);
            views.put(id,view);
        }

        return view;
    }

}
