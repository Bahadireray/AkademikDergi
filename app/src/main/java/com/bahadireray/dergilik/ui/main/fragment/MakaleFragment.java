package com.bahadireray.dergilik.ui.main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bahadireray.dergilik.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MakaleFragment extends Fragment {


    public MakaleFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_makale, container, false);
    }
    public class Pdf{
        private String Title;
        private String Category;
        private String Deacription;
        private int Thumbnail;


        public Pdf(String title, String category, String deacription, int thumbnail) {
            Title = title;
            Category = category;
            Deacription = deacription;
            Thumbnail = thumbnail;
        }

        public String getTitle() {
            return Title;
        }

        public String getCategory() {
            return Category;
        }

        public String getDeacription() {
            return Deacription;
        }

        public int getThumbnail() {
            return Thumbnail;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public void setCategory(String category) {
            Category = category;
        }

        public void setDeacription(String deacription) {
            Deacription = deacription;
        }

        public void setThumbnail(int thumbnail) {
            Thumbnail = thumbnail;
        }

        public Pdf() {

        }
    }

}
