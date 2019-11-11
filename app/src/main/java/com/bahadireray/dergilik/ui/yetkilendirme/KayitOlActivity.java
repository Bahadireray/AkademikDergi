package com.bahadireray.dergilik.ui.yetkilendirme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bahadireray.dergilik.R;
import com.bahadireray.dergilik.model.Users;

public class KayitOlActivity extends AppCompatActivity {


    private EditText txtAd, txtSoyad, txtEposta, txtSifre, txtSifreTekrar, txtUniversite;
    private Spinner spnBasvuruTuru;
    private Button btnGirisYap, btnKayitOl;

    private String valAd, valSoyad, valEposta, valSifre, valSifreTekrar, valUniversite, valBasvuruTuru;

    private Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);


        init();
        btnTiklama();
    }

    private void btnTiklama() {
        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valAd = txtAd.getText().toString();
                valSoyad = txtSoyad.getText().toString();
                valEposta = txtEposta.getText().toString();
                valSifre = txtSifre.getText().toString();
                valSifreTekrar = txtSifreTekrar.getText().toString();
                valUniversite = txtUniversite.getText().toString();
                valBasvuruTuru = spnBasvuruTuru.getSelectedItem().toString();

                if (inputTypeControl(valAd, valSoyad, valEposta, valSifre, valSifreTekrar, valUniversite)) {
                    Toast.makeText(getApplicationContext(), "Giriş Yapınız", Toast.LENGTH_SHORT).show();
                    users = new Users(valAd, valSoyad, valEposta, valSifre, valUniversite, valBasvuruTuru);

                }


            }
        });
    }

    private boolean inputTypeControl(String valAd, String valSoyad, String valEposta, String valSifre, String valSifreTekrar, String valUniversite) {

        if (!valSifre.equals(valSifreTekrar)) {
            txtSifreTekrar.setError("Şifreler Farklı");
            return false;
        }


        return true;


    }


    private void init() {

        txtAd = (EditText) findViewById(R.id.txtKayitOlAd);
        txtSoyad = (EditText) findViewById(R.id.txtKayitOlSoyad);
        txtEposta = (EditText) findViewById(R.id.txtKayitOlEposta);
        txtSifre = (EditText) findViewById(R.id.txtKayitOlSifre);
        txtSifreTekrar = (EditText) findViewById(R.id.txtKayitOlSifreTekrar);
        txtUniversite = (EditText) findViewById(R.id.txtKayitOlUniversite);

        spnBasvuruTuru = (Spinner) findViewById(R.id.spnKayitOlKullaniciTuru);

        btnGirisYap = (Button) findViewById(R.id.btnGirisYap);
        btnKayitOl = (Button) findViewById(R.id.btnKayitOl);
    }

}
