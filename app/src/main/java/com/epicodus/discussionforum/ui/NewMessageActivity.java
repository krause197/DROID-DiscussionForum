package com.epicodus.discussionforum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.discussionforum.Constants;
import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Message;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        mSaveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if (view == mSaveButton) {
            String userTitle = mTitle.getText().toString();
            String userContent = mContent.getText().toString();
            String userAuthor = mAuthor.getText().toString();
            mMessage = new Message(userTitle, userContent, userAuthor);
            DatabaseReference messageRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_MESSAGES);
            messageRef.push().setValue(mMessage);
            Toast.makeText(NewMessageActivity.this, "saved", Toast.LENGTH_SHORT).show();

            Log.d("log", "Message: " + mMessage);
        }
    }
}
