package com.bahadireray.dergilik.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bahadireray.dergilik.R;
import com.bahadireray.dergilik.component.CustomViewPager;
import com.bahadireray.dergilik.component.ViewPagerAdapter;
import com.bahadireray.dergilik.ui.main.fragment.DergiFragment;
import com.bahadireray.dergilik.ui.main.fragment.EditorFragment;
import com.bahadireray.dergilik.ui.main.fragment.HakemFragment;
import com.bahadireray.dergilik.ui.main.fragment.MakaleFragment;
import com.bahadireray.dergilik.ui.main.fragment.MakaleYayinlaFragment;
import com.bahadireray.dergilik.ui.main.fragment.ProfileFragment;
import com.bahadireray.dergilik.ui.main.fragment.YazarFragment;
import com.bahadireray.dergilik.ui.main.fragment.anasayfa.AnaSayfaFragment;
import com.bahadireray.dergilik.ui.yetkilendirme.GirisYapActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView txtKullaniciAdi, txtKullaniciMail;
    private CustomViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private NavigationView navigationView;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onStart() {
        girisKontrol();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setupViewPager();


    }

    private void girisKontrol() {
        sharedPreferences = this.getSharedPreferences("girisKontrol", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("kullaniciMail", null); //mail
        if (username != null) { //mail
            navigationView.getMenu().findItem(R.id.nav_giris_yap).setVisible(false);

            navigationView.getMenu().findItem(R.id.nav_dergi).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_profil).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_makale).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_makale_yayinla).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_yazar).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_hakem).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_editor).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_cikis_yap).setVisible(true);

            txtKullaniciMail.setVisibility(View.VISIBLE);
            txtKullaniciMail.setText(username); //mail
            txtKullaniciAdi.setVisibility(View.VISIBLE);



        }
    }

    private void setupViewPager() {

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        AnaSayfaFragment anaSayfaFragment = new AnaSayfaFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        YazarFragment yazarFragment = new YazarFragment();
        MakaleFragment makaleFragment = new MakaleFragment();
        MakaleYayinlaFragment makaleYayinlaFragment = new MakaleYayinlaFragment();
        HakemFragment hakemFragment = new HakemFragment();
        EditorFragment editorFragment = new EditorFragment();
        DergiFragment dergiFragment = new DergiFragment();


        viewPagerAdapter.addFragment(anaSayfaFragment);
        viewPagerAdapter.addFragment(profileFragment);
        viewPagerAdapter.addFragment(dergiFragment);
        viewPagerAdapter.addFragment(makaleFragment);
        viewPagerAdapter.addFragment(makaleYayinlaFragment);
        viewPagerAdapter.addFragment(hakemFragment);
        viewPagerAdapter.addFragment(yazarFragment);
        viewPagerAdapter.addFragment(editorFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = (CustomViewPager) findViewById(R.id.viewPager);
        viewPager.setPagingEnabled(false);

        View headerView = navigationView.getHeaderView(0);
        txtKullaniciAdi = (TextView) headerView.findViewById(R.id.txtNavKullaniciAdi);
        txtKullaniciMail = (TextView) headerView.findViewById(R.id.txtNavKullaniciMail);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_ana_sayfa: {
                viewPager.setCurrentItem(0,false);
                break;
            }
            case R.id.nav_profil: {
                viewPager.setCurrentItem(1,false);
                break;
            }
            case R.id.nav_dergi: {
                viewPager.setCurrentItem(2,false);
                break;
            }
            case R.id.nav_makale: {
                viewPager.setCurrentItem(3,false);
                break;
            }
            case R.id.nav_makale_yayinla: {
                viewPager.setCurrentItem(4,false);
                break;
            }

            case R.id.nav_hakem: {
                viewPager.setCurrentItem(5,false);
                break;
            }
            case R.id.nav_yazar: {
                viewPager.setCurrentItem(6,false);
                break;
            }
            case R.id.nav_editor: {
                viewPager.setCurrentItem(7,false);
                break;
            }
            case R.id.nav_giris_yap: {
                startActivity(new Intent(MainActivity.this, GirisYapActivity.class));
                break;
            }
            case R.id.nav_cikis_yap: {
                viewPager.setCurrentItem(0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("kullaniciMail", null);
                editor.commit();
                navigationView.getMenu().findItem(R.id.nav_giris_yap).setVisible(true);

                navigationView.getMenu().findItem(R.id.nav_dergi).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_profil).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_makale).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_makale_yayinla).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_yazar).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_hakem).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_editor).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_cikis_yap).setVisible(false);
                txtKullaniciMail.setVisibility(View.INVISIBLE);
                txtKullaniciAdi.setVisibility(View.INVISIBLE);

                break;
            }

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
