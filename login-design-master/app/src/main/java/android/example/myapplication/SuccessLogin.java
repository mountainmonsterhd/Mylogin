package android.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SuccessLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_register);
        //setContentView(R.layout.layout_login);
        setContentView(R.layout.activity_main);
    }

    public void logoutbt(View view){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("logstate",false);
        i.putExtra("flag",2);
        startActivity(i);
        finish();
    }
}
