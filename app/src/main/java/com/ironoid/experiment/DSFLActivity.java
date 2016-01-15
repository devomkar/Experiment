package com.ironoid.experiment;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;
import android.widget.TextView;

import com.ironoid.experiment.DSFLFragments.OneFragment;
import com.ironoid.experiment.DSFLFragments.ThreeFragment;
import com.ironoid.experiment.DSFLFragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;




public class DSFLActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref2 = PreferenceManager
                .getDefaultSharedPreferences(this);
        String basetheme = pref2.getString("base_theme", "Light");
        if (basetheme.equals("Dark")) {
            SharedPreferences pref = PreferenceManager
                    .getDefaultSharedPreferences(this);
            String themeName = pref.getString("theme_select", "Blue");
            if (themeName.equals("Blue")) {
                setTheme(R.style.MyMaterialTheme2);
            } else if (themeName.equals("Green")) {
                setTheme(R.style.Green2);
            } else if (themeName.equals("Red")) {
                setTheme(R.style.Red2);
            } else if (themeName.equals("Orange")) {
                setTheme(R.style.Orange2);
            } else if (themeName.equals("Pink")) {
                setTheme(R.style.Pink2);
            } else if (themeName.equals("Purple")) {
                setTheme(R.style.Purple2);
            } else if (themeName.equals("Voilet")) {
                setTheme(R.style.Voilet2);
            } else if (themeName.equals("Yellow")) {
                setTheme(R.style.Yellow2);
            } else if (themeName.equals("Cyan")) {
                setTheme(R.style.Cyan2);
            } else if (themeName.equals("Teal")) {
                setTheme(R.style.Teal2);
            } else if (themeName.equals("Indigo")) {
                setTheme(R.style.Indigo2);
            }
        } else if(basetheme.equals("Light"))
        {
            SharedPreferences pref = PreferenceManager
                    .getDefaultSharedPreferences(this);
            String themeName = pref.getString("theme_select", "Blue");
            if (themeName.equals("Blue")) {
                setTheme(R.style.MyMaterialTheme);
            } else if (themeName.equals("Green")) {
                setTheme(R.style.Green);
            } else if (themeName.equals("Red")) {
                setTheme(R.style.Red);
            } else if (themeName.equals("Orange")) {
                setTheme(R.style.Orange);
            } else if (themeName.equals("Pink")) {
                setTheme(R.style.Pink);
            } else if (themeName.equals("Purple")) {
                setTheme(R.style.Purple);
            } else if (themeName.equals("Voilet")) {
                setTheme(R.style.Voilet);
            } else if (themeName.equals("Yellow")) {
                setTheme(R.style.Yellow);
            } else if (themeName.equals("Cyan")) {
                setTheme(R.style.Cyan);
            } else if (themeName.equals("Teal")) {
                setTheme(R.style.Teal);
            } else if (themeName.equals("Indigo")) {
                setTheme(R.style.Indigo);
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        Boolean pic = pref.getBoolean("pic_bg", true);
        CoordinatorLayout cl = (CoordinatorLayout)findViewById(R.id.cl);
        if(pic) {
            cl.setBackgroundResource(R.drawable.home_bg);
        }
            toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "M.C.Q");
        adapter.addFragment(new TwoFragment(), "F.A.Q");
        adapter.addFragment(new ThreeFragment(), "Question Papers");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        Intent home = new Intent(DSFLActivity.this ,HomeActivity.class);
        startActivity(home);
        finish();

    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public void toast(View v)
    {
        final Dialog d = new Dialog(this, android.support.v7.appcompat.R.style.Theme_AppCompat_NoActionBar);
        d.setContentView(R.layout.q_a);
        d.setCancelable(false);
        TextView q = (TextView)d.findViewById(R.id.ques);
        TextView a = (TextView)d.findViewById(R.id.ans);
        ImageView c = (ImageView)d.findViewById(R.id.close_q_a);
        a.setText(R.string.a);
        q.setText("What is gnvsdkjv,ms?");
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
    }
}