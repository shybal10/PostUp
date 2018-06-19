package com.example.mawaqaamobile.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FavouritesFragment favouritesFragment;
    AboutAppFragment aboutAppFragment;
    MessageFragment messageFragment;
    ContactFragment contactFragment;
    AdvancedSearchFragment advancedSearchFragment;
    CategoriesFragment categoriesFragment;
    ForgetPasswordFragment forgetPasswordFragment;
    UserRegistrationFragment userRegistrationFragment;
    MyProfileFragment myProfileFragment;
    SellYourItemFragment sellYourItemFragment;
    BuyPackagesFragment buyPackagesFragment;
    AdsListingFragment adsListingFragment;
    MyAdsFragment myAdsFragment;
    NotificationFragment notificationFragment;
    DetailsFragment detailsFragment;
    Fragment selectedFragment;
    ImageButton homeButton, categoryButton, favouritesButton, sellAdButton, profleButton,advancedSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setScrimColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
/*        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_title);*/
        Drawable dr = getResources().getDrawable(R.drawable.menu);
        Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
        // Scale it to 50 x 50
        Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 40, 40, true));
        // Set your new, scaled drawable "d"
        getSupportActionBar().setHomeAsUpIndicator(d);
        loadFragments();

        homeButton = findViewById(R.id.home_button);
        categoryButton = findViewById(R.id.category_button);
        sellAdButton = findViewById(R.id.post_add_button);
        profleButton = findViewById(R.id.profile_button);
        favouritesButton = findViewById(R.id.fav_button);
        advancedSearchButton = (ImageButton) findViewById(R.id.advanced_search);

        String data = getIntent().getExtras().getString("showPage");
        if (data.equals("forgotpassword")) {
            getFragmentManager().beginTransaction().add(R.id.fragment_continer, forgetPasswordFragment).commit();
        } else if (data.equals("register")) {
            getFragmentManager().beginTransaction().add(R.id.fragment_continer, userRegistrationFragment).commit();
        } else if (data.equals("main")) {
            getFragmentManager().beginTransaction().add(R.id.fragment_continer, adsListingFragment).commit();
            changeButtonColour(R.id.home_button);
        }

        advancedSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_continer, advancedSearchFragment).commit();

            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonColour(R.id.home_button);
                getFragmentManager().beginTransaction().replace(R.id.fragment_continer, adsListingFragment).commit();
            }
        });

        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonColour(R.id.category_button);
                getFragmentManager().beginTransaction().replace(R.id.fragment_continer, categoriesFragment).commit();
            }
        });

        profleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonColour(R.id.profile_button);
                getFragmentManager().beginTransaction().replace(R.id.fragment_continer, myProfileFragment).commit();

            }
        });

        favouritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonColour(R.id.fav_button);
                getFragmentManager().beginTransaction().replace(R.id.fragment_continer, favouritesFragment).commit();
            }
        });
        sellAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonColour(R.id.post_add_button);
                getFragmentManager().beginTransaction().replace(R.id.fragment_continer, sellYourItemFragment).commit();

            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
       // Read your drawable from somewhere
        Drawable dr = getResources().getDrawable(R.drawable.email);
        Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
        // Scale it to 50 x 50
        Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 50, 50, true));
        // Set your new, scaled drawable "d"
        menu.getItem(0).setIcon(d); //choose the item number you want to set
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment myFragment;
        if (id == R.id.about_app_id) {
            selectedFragment = aboutAppFragment;
        } else if (id == R.id.notifications_id) {
            selectedFragment = notificationFragment;
        } else if (id == R.id.change_country_id) {
            startActivity(new Intent(MainActivity.this,SplashActivity.class));

        } else if (id == R.id.purchase_package_id) {
            selectedFragment = buyPackagesFragment;
        } else if (id == R.id.fav_ads_id){
            selectedFragment = favouritesFragment;
            changeButtonColour(R.id.fav_button);

        } else if (id == R.id.my_ads_id) {
            selectedFragment = myAdsFragment;
        } else if (id == R.id.my_messages_id) {
            selectedFragment = messageFragment;
        } else if (id == R.id.contact_us_id) {
            selectedFragment = contactFragment;
        }

        if (selectedFragment != null) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_continer, selectedFragment).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeButtonColour(int id) {
        if (id == R.id.home_button) {
            homeButton.setImageDrawable(getResources().getDrawable(R.drawable.menuoneover));
            sellAdButton.setImageDrawable(getResources().getDrawable(R.drawable.menuthree));
            profleButton.setImageDrawable(getResources().getDrawable(R.drawable.menufive));
            favouritesButton.setImageDrawable(getResources().getDrawable(R.drawable.menufour));
            categoryButton.setImageDrawable(getResources().getDrawable(R.drawable.menutwo));
        } else if (id == R.id.post_add_button) {
            homeButton.setImageDrawable(getResources().getDrawable(R.drawable.menuone));
            sellAdButton.setImageDrawable(getResources().getDrawable(R.drawable.menuthreeover));
            profleButton.setImageDrawable(getResources().getDrawable(R.drawable.menufive));
            favouritesButton.setImageDrawable(getResources().getDrawable(R.drawable.menufour));
            categoryButton.setImageDrawable(getResources().getDrawable(R.drawable.menutwo));
        } else if (id == R.id.profile_button) {
            homeButton.setImageDrawable(getResources().getDrawable(R.drawable.menuone));
            sellAdButton.setImageDrawable(getResources().getDrawable(R.drawable.menuthree));
            profleButton.setImageDrawable(getResources().getDrawable(R.drawable.menufiveover));
            favouritesButton.setImageDrawable(getResources().getDrawable(R.drawable.menufour));
            categoryButton.setImageDrawable(getResources().getDrawable(R.drawable.menutwo));
        } else if (id == R.id.fav_button) {
            homeButton.setImageDrawable(getResources().getDrawable(R.drawable.menuone));
            sellAdButton.setImageDrawable(getResources().getDrawable(R.drawable.menuthree));
            profleButton.setImageDrawable(getResources().getDrawable(R.drawable.menufive));
            favouritesButton.setImageDrawable(getResources().getDrawable(R.drawable.menufourover));
            categoryButton.setImageDrawable(getResources().getDrawable(R.drawable.menutwo));
        } else if (id == R.id.category_button) {
            homeButton.setImageDrawable(getResources().getDrawable(R.drawable.menuone));
            sellAdButton.setImageDrawable(getResources().getDrawable(R.drawable.menuthree));
            profleButton.setImageDrawable(getResources().getDrawable(R.drawable.menufive));
            favouritesButton.setImageDrawable(getResources().getDrawable(R.drawable.menufour));
            categoryButton.setImageDrawable(getResources().getDrawable(R.drawable.menutwoover));
        }
    }
    private void resetButton() {
        homeButton.setImageDrawable(getResources().getDrawable(R.drawable.menuone));
        sellAdButton.setImageDrawable(getResources().getDrawable(R.drawable.menuthree));
        profleButton.setImageDrawable(getResources().getDrawable(R.drawable.menufive));
        favouritesButton.setImageDrawable(getResources().getDrawable(R.drawable.menufour));
        categoryButton.setImageDrawable(getResources().getDrawable(R.drawable.menutwo));
    }
    private Bitmap resizeBitmapImageFn(
            Bitmap bmpSource, int maxResolution) {
        int iWidth = bmpSource.getWidth();
        int iHeight = bmpSource.getHeight();
        int newWidth = iWidth;
        int newHeight = iHeight;
        float rate = 0.0f;
        if (iWidth > iHeight) {
            if (maxResolution < iWidth) {
                rate = maxResolution / (float) iWidth;
                newHeight = (int) (iHeight * rate);
                newWidth = maxResolution;
            }
        } else {
            if (maxResolution < iHeight) {
                rate = maxResolution / (float) iHeight;
                newWidth = (int) (iWidth * rate);
                newHeight = maxResolution;
            }
        }
        return Bitmap.createScaledBitmap(
                bmpSource, newWidth, newHeight, true);
    }
    private void loadFragments() {
        sellYourItemFragment = new SellYourItemFragment();
        aboutAppFragment = new AboutAppFragment();
        contactFragment = new ContactFragment();
        categoriesFragment = new CategoriesFragment();
        forgetPasswordFragment = new ForgetPasswordFragment();
        userRegistrationFragment = new UserRegistrationFragment();
        myProfileFragment = new MyProfileFragment();
        advancedSearchFragment = new AdvancedSearchFragment();
        buyPackagesFragment = new BuyPackagesFragment();
        messageFragment = new MessageFragment();
        adsListingFragment = new AdsListingFragment();
        myAdsFragment = new MyAdsFragment();
        notificationFragment = new NotificationFragment();
        detailsFragment = new DetailsFragment();
        favouritesFragment = new FavouritesFragment();
    }
}
