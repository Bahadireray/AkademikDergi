package com.bahadireray.dergilik.ui.main.fragment;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bahadireray.dergilik.FilePath;
import com.bahadireray.dergilik.R;

import java.util.ArrayList;

import mabbas007.tagsedittext.TagsEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class MakaleYayinlaFragment extends Fragment {


    public MakaleYayinlaFragment() {
        // Required empty public constructor
    }
    private TagsEditText mTagsEditText;
    private EditText txtMakaleAdi,txtMakaleOzet,txtYazarAdi;
    private Button btnYazarEkle,btnMakaleYayinla;
    private LinearLayout llDosyaSec,llYazarList;


    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_makale_yayinla, container, false);
        init();
        btnTiklama();
        return  view;
    }

    ArrayList<String> tagsList=new ArrayList<>();
    private void init() {

        mTagsEditText = (TagsEditText) view.findViewById(R.id.tagsEditText);
        mTagsEditText.setTagsWithSpacesEnabled(true);
        mTagsEditText.setAdapter(new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line,tagsList));
        mTagsEditText.setThreshold(1);




        txtMakaleAdi=(EditText)  view.findViewById(R.id.makaleAdi);
        txtMakaleOzet=(EditText)  view.findViewById(R.id.makaleOzet);
        txtYazarAdi=(EditText)  view.findViewById(R.id.yazarAdi);


        btnYazarEkle=(Button)  view.findViewById(R.id.btnYazarEkle);
        btnMakaleYayinla=(Button)  view.findViewById(R.id.makaleYayinla);

        llDosyaSec=(LinearLayout)  view.findViewById(R.id.dosyaSec);
        llYazarList=(LinearLayout)  view.findViewById(R.id.yazarlarListesi);

    }


    private void btnTiklama() {

        llDosyaSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    showFileChooser();


            }
        });


        btnMakaleYayinla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



    private static final int PICK_FILE_REQUEST = 1;
    private String selectedFilePath;
    private void showFileChooser() {
        Intent intent = new Intent();
        //sets the select file to all types of files
        intent.setType("*/*");
        //allows to select data and return it
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //starts new activity to select file and return data
        startActivityForResult(Intent.createChooser(intent,"Choose File to Upload.."),PICK_FILE_REQUEST);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == PICK_FILE_REQUEST){
                if(data == null){
                    //no data present
                    return;
                }


                Uri selectedFileUri = data.getData();


                try {
                    selectedFilePath = FilePath.getPath(getContext(),selectedFileUri);
                }catch (Exception e) {
                    Toast.makeText(getContext(),"hata",Toast.LENGTH_SHORT).show();
                }

                if(selectedFilePath != null && !selectedFilePath.equals("")){
                    txtMakaleAdi.setText(selectedFilePath);
                }else{

                }
            }
        }
    }


}
