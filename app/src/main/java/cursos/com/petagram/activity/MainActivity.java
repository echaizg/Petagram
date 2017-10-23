package cursos.com.petagram.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import cursos.com.petagram.R;
import cursos.com.petagram.adapter.PageAdapter;
import cursos.com.petagram.fragment.InfoMascotaFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        generarToolbar();
        setupViewPager();



    }

    private void generarToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setLogo(R.drawable.pata);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.mFavorito:
                Intent intent = new Intent(MainActivity.this, FavoritoActivity.class);
                startActivity(intent);
                break;
            case R.id.mAbout:
                Intent about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about);
                break;
            case R.id.mContact:
                Intent contact = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(contact);
                break;
            case R.id.mConfigurarCuenta:
                Intent configurar = new Intent(MainActivity.this,ConfigurarCuentaActivity.class);
                startActivity(configurar);
                break;

        }
        return true;
    }




    private List<Fragment> agregarFragments() {
        List<Fragment> fragments = new ArrayList<>();
        //fragments.add(new MascotasFragment());
        fragments.add(new InfoMascotaFragment());
        fragments.add(new InfoMascotaFragment());

        return fragments;
    }

    private void setupViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.cas_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.perro_tab);


    }
}
