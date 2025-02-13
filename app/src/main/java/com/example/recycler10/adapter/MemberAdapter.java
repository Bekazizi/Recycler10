package com.example.recycler10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler10.R;
import com.example.recycler10.model.Member;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Member>members;

    public MemberAdapter(Context context, ArrayList<Member>members){
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return Member.HEADER;
        }
        if (position == members.size()-1){
            return Member.FOOTER;
        }
        return members.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Member.HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memver_list_header, parent, false);
            return new memberViewHolderHeader(view);
        }
        if (viewType == Member.FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memver_list_footer, parent, false);
            return new memberViewHolderFooter(view);
        }
        if (viewType == Member.TYPE_MEMBER_ONE){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memver_list_one,parent,false);
            return new memberViewHolderOne(view);
        }
        if (viewType == Member.TYPE_MEMBER_TWO){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memver_list_two,parent,false);
            return new memberViewHolderTwo(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memver_list,parent,false);
        return new memberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof memberViewHolderOne){
            TextView first_name = ((memberViewHolderOne) holder).first_name;
            TextView full_name = ((memberViewHolderOne) holder).full_name;

            first_name.setText(member.getFirst_name());
            full_name.setText(member.getFull_name());
        }
        if (holder instanceof memberViewHolderTwo){
            TextView first_name = ((memberViewHolderTwo) holder).first_name;
            TextView full_name = ((memberViewHolderTwo) holder).full_name;

            first_name.setText(member.getFirst_name());
            full_name.setText(member.getFull_name());
        }
        if (holder instanceof memberViewHolder){
            TextView first_name = ((memberViewHolder) holder).first_name;
            TextView full_name = ((memberViewHolder) holder).full_name;

            first_name.setText(member.getFirst_name());
            full_name.setText(member.getFull_name());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class memberViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView first_name;
        TextView full_name;

        public memberViewHolder(@NonNull View itemView) {

            super(itemView);
            this.view = itemView;

            first_name = view.findViewById(R.id.first_name);
            full_name = view.findViewById(R.id.full_name);
        }
    }
    public class memberViewHolderOne extends RecyclerView.ViewHolder{
        View view;
        TextView first_name;
        TextView full_name;

        public memberViewHolderOne(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            first_name = view.findViewById(R.id.first_name);
            full_name = view.findViewById(R.id.full_name);
        }
    }
    public class memberViewHolderTwo extends RecyclerView.ViewHolder{
        View view;
        TextView first_name;
        TextView full_name;

        public memberViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            first_name = view.findViewById(R.id.first_name);
            full_name = view.findViewById(R.id.full_name);
        }
    }
    public class memberViewHolderHeader extends RecyclerView.ViewHolder{
        View view;
        TextView header;

        public memberViewHolderHeader(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            header = view.findViewById(R.id.header);
        }
    }
    public class memberViewHolderFooter extends RecyclerView.ViewHolder{
        View view;
        TextView footer;

        public memberViewHolderFooter(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            footer = view.findViewById(R.id.footer);
        }
    }

}
