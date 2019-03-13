package android.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean firstin;
    int flag;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_register);
        setContentView(R.layout.layout_login);
        sp = MainActivity.this.getPreferences(0);
        editor = sp.edit();
        firstin = sp.getBoolean("firstin",true);
        int a = 0;
        if(!firstin) {
            Intent i = getIntent();
            flag = i.getIntExtra("flag", 0);
            switch (flag) {
                case 0:
                    break;
                case 1: {
                    String n = i.getStringExtra("name");
                    String e = i.getStringExtra("email");
                    String p = i.getStringExtra("password");
                    editor.putString("name", i.getStringExtra("name"));
                    editor.putString("email", i.getStringExtra("email"));
                    editor.putString("password", i.getStringExtra("password"));
                    editor.commit();
                }
                break;
                case 2: {
                    editor.putBoolean("logstate", i.getBooleanExtra("logstate", false));
                    editor.commit();
                }
            }
        }
        //setContentView(R.layout.activity_main);
    }

    public void btLogin(View view){

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        String e = email.getText().toString();
        String p = password.getText().toString();
        if(e.isEmpty()||p.isEmpty()){
            Toast toastCenter = Toast.makeText(MainActivity.this, "Email and Password can not be empty!", Toast.LENGTH_SHORT);
            toastCenter.setGravity(Gravity.CENTER, 0, 0);
            toastCenter.show();
        }
        else{
            String spe = sp.getString("email","none");
            String spp = sp.getString("password","none");
            if(!e.equals(spe)||!p.equals(spp)){
                Toast toastCenter = Toast.makeText(MainActivity.this, "Email or Password is wrong!", Toast.LENGTH_SHORT);
                toastCenter.setGravity(Gravity.CENTER, 0, 0);
                toastCenter.show();
            }
            else{
                progressDialog = new ProgressDialog(this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Logging in ...");
                if (!progressDialog.isShowing())
                    progressDialog.show();
                startActivity(new Intent(this, SuccessLogin.class));
                finish();
                editor.putBoolean("logstate",true);
                editor.putBoolean("firstin",false);
                editor.commit();
            }

        }

    }

    public void btRegister(View view){
        editor.putBoolean("firstin",false);
        editor.commit();
        startActivity(new Intent(this, Register.class));
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
