package com.epicodus.discussionforum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Message;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewMessageActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.titleEditText) EditText mTitle;
    @Bind(R.id.contentEditText) EditText mContent;
    @Bind(R.id.authorEditTextText) EditText mAuthor;
    @Bind(R.id.saveButton) Button mSaveButton;
    private Message mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        ButterKnife.bind(this);

        mMessage = new Message(mTitle.getText().toString(), mContent.getText().toString(), mAuthor.getText().toString());
        Log.d("log", mMessage.toString());
        mSaveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if (view == mSaveButton) {
            Log.d("log", "Title: " + mTitle.getText().toString());
            Log.d("log", "Content: " + mContent.getText().toString());
            Log.d("log", "Author: " + mAuthor.getText().toString());
            Log.d("log", "Message: " + mMessage);
        }
    }
}
