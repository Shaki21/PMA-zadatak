package com.ante.zadatak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    FirebaseDatabase db;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        this.db = FirebaseDatabase.getInstance("https://zadatak-projekt-default-rtdb.europe-west1.firebasedatabase.app/");

        //Polja za unos podataka
        EditText emailTxt = findViewById(R.id.reg_email);
        EditText passwordTxt = findViewById(R.id.reg_lozinka);
        EditText passwordCnf = findViewById(R.id.reg_loz2);
        Button submitBtn = findViewById(R.id.reg_btn);
        DatabaseReference usersDbRef = this.db.getReference("users");



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(emailTxt.getText().toString(), passwordTxt.getText().toString())
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this, "Uspješno registriran!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    Toast.makeText(RegisterActivity.this, task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT ).show();
                                }
                            }
                        });
            }

        });
    }
}
