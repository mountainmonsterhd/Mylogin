package android.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        //setContentView(R.layout.layout_login);
        //setContentView(R.layout.activity_main);
    }
    public boolean email_is_right(String e){
        for(int i = 0;i<e.length();i++){
            if(e.charAt(i)=='@'){
                return true;
            }
        }
        return false;
    }
    public void registerbt(View view){
        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        if(name.getText().toString().isEmpty()||email.getText().toString().isEmpty()||password.getText().toString().isEmpty()){
            Toast toastCenter = Toast.makeText(Register.this, "Name, Email and Password can not be empty!", Toast.LENGTH_SHORT);
            toastCenter.setGravity(Gravity.CENTER, 0, 0);
            toastCenter.show();
        }
        else{
            String e = email.getText().toString();
            String n = name.getText().toString();
            String p = password.getText().toString();
            if (email_is_right(e)){
                Intent i = new Intent(Register.this, MainActivity.class);
                i.putExtra("name",n);
                i.putExtra("flag",1);
                i.putExtra("email",e);
                i.putExtra("password",p);
                startActivity(i);
                finish();
            }
        }
    }
    public void backToLogin(View view){
        Intent i = new Intent(Register.this, MainActivity.class);
        i.putExtra("flag",0);
        startActivity(i);
        finish();
    }
}