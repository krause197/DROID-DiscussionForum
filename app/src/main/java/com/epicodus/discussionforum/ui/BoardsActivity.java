package com.epicodus.discussionforum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.discussionforum.Constants;
import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.adapters.FirebaseMessageViewHolder;
import com.epicodus.discussionforum.models.Message;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BoardsActivity extends AppCompatActivity {
    private DatabaseReference mMessageReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_boards);
        ButterKnife.bind(this);

        mMessageReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_MESSAGES);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Message, FirebaseMessageViewHolder>
                (Message.class, R.layout.message_list_item, FirebaseMessageViewHolder.class,
                    mMessageReference) {
            @Override
            protected void populateViewHolder(FirebaseMessageViewHolder viewHolder,
                                              Message model, int position) {
                viewHolder.bindMessage(model);

            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
