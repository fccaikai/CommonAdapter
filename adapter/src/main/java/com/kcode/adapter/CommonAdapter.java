package com.kcode.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caik on 2016/11/30.
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private int resource;
    private List<T> data;

    /**
     * Constructor
     * @param resource  layout resource id
     */
    public CommonAdapter(int resource) {
        this(null, resource);
    }

    /**
     * Constructor
     * @param data      data resource
     * @param resource  layout resource id
     */
    public CommonAdapter(List<T> data, int resource) {
        this.data = data;
        this.resource = resource;
    }

    /**
     * init Adapter data resource
     * @param data  data resource
     */
    public void init(List<T> data) {
        if (data == null) {
            throw new NullPointerException("data can not be null");
        }
        this.data = data;
        notifyDataSetChanged();
    }

    /**
     * clear data
     */
    public void clear() {
        createDataIfNotExits();
        data.clear();
        notifyDataSetChanged();
    }

    /**
     * add list
     * @param data
     */
    public void addItems(List<T> data) {
        createDataIfNotExits();
        this.data.addAll(data);
        notifyDataSetChanged();

    }

    /**
     * add a item
     * @param t item content
     */
    public void addItem(T t) {
        createDataIfNotExits();
        data.add(t);
        notifyDataSetChanged();
    }

    public T getItemAtPosition(int position) {
        return data.get(position);
    }

    /**
     * add a item on first position
     * @param t item content
     */
    public void addItem2First(T t) {
        createDataIfNotExits();
        data.add(0,t);
        notifyDataSetChanged();
    }

    /**
     * notify item by position
     * @param t         item content    {@link CommonAdapter#data}
     * @param position  recyclerView list position
     */
    public void notifyItemAtPosition(T t,int position) {
        createDataIfNotExits();

        if (data.size() < position) {
            throw new RuntimeException("data length is " + data.size()
                    + ", notify position is " + position);
        }
        data.set(position, t);
        notifyItemChanged(position);
    }

    /**
     * new an ArrayList if data is null
     */
    private void createDataIfNotExits() {
        if (data == null) {
            data = new ArrayList<>();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    protected int getItemLayout(int viewType){
        return resource;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(getItemLayout(viewType), parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        setupViewHolder(holder, position,data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(holder.getAdapterPosition());
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClick(holder.getAdapterPosition());
                    return true;
                }

                return false;
            }
        });
    }

    protected abstract void setupViewHolder(RecyclerViewHolder holder, int position, T item);

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void addOnItemClickListener(OnItemClickListener listener){
        onItemClickListener = listener;
    }

    public void addOnItemLongClickListener(OnItemLongClickListener listener){
        onItemLongClickListener = listener;
    }

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public interface OnItemClickListener<T>{
        void onItemClick(int position);
    }

    public interface OnItemLongClickListener<T>{
        void onItemLongClick(int position);
    }
}
