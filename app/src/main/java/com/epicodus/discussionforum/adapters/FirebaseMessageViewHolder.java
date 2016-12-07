package com.epicodus.discussionforum.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Message;

/**
 * Created by Guest on 12/6/16.
 */
public class FirebaseMessageViewHolder extends RecyclerView.ViewHolder {
    View mView;
    Context mContext;

    public FirebaseMessageViewHolder (View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
//        itemView.setOnClickListener(this);
    }

    public void bindMessage (Message message) {
        TextView titleTextView = (TextView) mView.findViewById(R.id.titleTextView);
        TextView contentTextView = (TextView) mView.findViewById(R.id.contentTextView);
        TextView authorTextView = (TextView) mView.findViewById(R.id.authorTextView);

        titleTextView.setText(message.getTitle());
        contentTextView.setText(message.getContent());
        authorTextView.setText(message.getAuthor());
    }


}
