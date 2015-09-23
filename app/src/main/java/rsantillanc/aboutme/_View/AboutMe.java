package rsantillanc.aboutme._View;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import rsantillanc.aboutme.R;
import rsantillanc.aboutme._View.Fragment.HomeFragment;


public class AboutMe extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Views
    private Toolbar mToolbar;
    private NavigationView mNavView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        initViews();
        setUps();
    }


    /**
     * This method initialize all views objects
     */
    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        mNavView = (NavigationView)findViewById(R.id.navigation_view);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
    }


    /**
     * This method implemented necessaries setups
     */
    private void setUps() {
        setUpActionBar();
        setUpNavigationView();
        setUpDrawerLayout();
    }

    private void setUpDrawerLayout() {
//        mDrawerToggle = new ActionBarDrawerToggle(this,)
    }

    private void setUpNavigationView() {
        mNavView.setNavigationItemSelectedListener(this);
    }



    private void setUpActionBar() {
        mToolbar.setTitle(getString(R.string.main_title_my_name));
        mToolbar.setSubtitle(getString(R.string.main_subtitle_my_job));

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_nav_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //------------------- CallBacks --------------------

    /*NavigationView*/
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        boolean isTransaction = false;
        Fragment ui = null;

        switch (menuItem.getItemId()){
            case R.id.main_menu_title_proyect:
                ui = new HomeFragment();
                isTransaction = true;
                break;
            case R.id.main_menu_title_curriculum:
                showToast("Curriculum!");
                break;
            case R.id.sub_menu_settings:
                showToast("Settings!");
                break;
            default:
                showToast("Others!");
                break;
        }

        if (isTransaction){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragments_content,ui);
            transaction.commit();

            //Active row
            menuItem.setChecked(true);

            //close menu list
            mDrawerLayout.closeDrawers();
        }

        return true;
    }

    /**
     * Esta debe estar en una clase generica
     */
    private void showToast(CharSequence message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
