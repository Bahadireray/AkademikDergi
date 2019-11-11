package com.bahadireray.dergilik.ui.main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bahadireray.dergilik.AppConfig;
import com.bahadireray.dergilik.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditorFragment extends Fragment {


    public EditorFragment() {
        // Required empty public constructor
    }


    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_editor, container, false);
        // Inflate the layout for this fragment
        getData();
        return view;
    }

    private void getData() {

        //GET İŞLEMİ

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(AppConfig.URL, new Response.Listener<JSONArray>() {//URL Yİ BELİRTİYORSUN
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        //GELEN VERİLERİ BURADA ALIYORSUN

                    } catch (JSONException e) {
                        e.printStackTrace();
                        //HATA VARSA BURASI
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);
    }

}
