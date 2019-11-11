package com.bahadireray.dergilik.ui.yetkilendirme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bahadireray.dergilik.AppConfig;
import com.bahadireray.dergilik.R;
import com.bahadireray.dergilik.ui.main.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GirisYapActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtMail, txtSifre;
    private Button btnGirisYap, btnKayitOl;

    private SharedPreferences sharedPref;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_yap);

        sharedPreferences = this.getSharedPreferences("girisKontrol", Context.MODE_PRIVATE);


        loginCheck();
        init();

    }

    private void loginCheck() {
        sharedPref = this.getSharedPreferences("isLoginCheck", Context.MODE_PRIVATE);
        String id = sharedPref.getString("userId", null);

        if (id != null) {
            startActivity(new Intent(GirisYapActivity.this, MainActivity.class));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("txtMail", id);
            editor.commit();

            finish();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGirisYap: {
                String username = txtMail.getText().toString();
                String password = txtSifre.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    checkLogin(username, password);
                    // SharedPreferences.Editor editor = sharedPreferences.edit();
                    // editor.putString("txtMail", username);
                    // editor.commit();


                } else {
                    Toast.makeText(getApplicationContext(), "Kullanıcı adi ve Şifre boş olamaz", Toast.LENGTH_LONG).show();
                }
                break;
            }
            case R.id.btnKayitOl: {
                startActivity(new Intent(GirisYapActivity.this, KayitOlActivity.class));
                break;
            }
        }
    }

    String message;

    private void checkLogin(final String email, final String password) {
        StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jObj = null;
                try {
                    jObj = new JSONObject(response);

                    String status = jObj.getString("status");
                    message = jObj.getString("message");

                    if (status.equals("success")) {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("userId", jObj.getJSONObject("data").getJSONObject("user").getString("id"));

                        editor.commit(); //Kayıt

                        //   startActivity(new Intent(GirisYapActivity.this, MainActivity.class));
                        //    SharedPreferences.Editor editor1=sharedPreferences.edit();
                        //  editor.putString("txtMail",email);
                        // editor.commit();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Bağlantı Hatası", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("email", email);
                parameters.put("password", password);
                return parameters;
            }
        };

        RequestQueue rQueue = Volley.newRequestQueue(GirisYapActivity.this);
        rQueue.add(request);
    }


    //   btnKayitOl.setOnClickListener(new View.OnClickListener() {
    //      @Override
    //    public void onClick(View v) {
    //      startActivity(new Intent(GirisYapActivity.this,KayitOlActivity.class));
    //}
    //});


    private void init() {
        txtMail = (EditText) findViewById(R.id.txtGirisYapMail);
        txtSifre = (EditText) findViewById(R.id.txtGirisYapSifre);

        btnGirisYap = (Button) findViewById(R.id.btnGirisYap);
        btnKayitOl = (Button) findViewById(R.id.btnKayitOl);

        btnGirisYap.setOnClickListener(this);
        btnKayitOl.setOnClickListener(this);
    }

}
