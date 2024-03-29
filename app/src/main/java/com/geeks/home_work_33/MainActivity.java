package com.geeks.home_work_33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etSubject, etContent, etToEmail;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnSend);
        etSubject = findViewById(R.id.subject);
        etContent = findViewById(R.id.content);
        etToEmail = findViewById(R.id.to_email);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject, content, to_email;
                subject = etSubject.getText().toString();
                content = etContent.getText().toString();
                to_email = etToEmail.getText().toString();
                if (subject.equals("") && content.equals("") && to_email.equals("")){
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else {
                    sendEmail(subject, content, to_email);
                }
            }
        });
    }
    public void sendEmail(String subject, String content,String to_email){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to_email});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, content);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose email client"));
    }
}