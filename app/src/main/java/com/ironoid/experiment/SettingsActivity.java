package com.ironoid.experiment;


import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.ironoid.experiment.R;

public class SettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
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

        addPreferencesFromResource(R.xml.settings);

        Preference help = findPreference("help");
        Preference donate = findPreference("donate");
        Preference myfb = findPreference("myfb");
        Preference myinsta = findPreference("myinsta");
        Preference myxda = findPreference("myxda");
        Preference mywa = findPreference("mywa");
        Preference update = findPreference("update");
        Preference theme = findPreference("theme_select");
        Preference btheme = findPreference("base_theme");



        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String themeName = pref.getString("theme_select", "Blue");

        btheme.setSummary(basetheme);
        theme.setSummary(themeName);

        theme.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                recreate();
                return true;
            }
        });

        btheme.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                recreate();
                return true;
            }
        });


        update.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference arg0) {

                AlertDialog.Builder close = new AlertDialog.Builder(SettingsActivity.this);

                close.setTitle("UPDATE");
                close.setMessage("Check if Update available ?");
                close.setPositiveButton("Yes", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Uri uri = Uri.parse("https://www.ironoid.blogspot.in/?m=1");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            }
                        });
                ;
                close.setNegativeButton("No", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                ;
                AlertDialog alertDialog = close.create();
                alertDialog.show();

                return false;
            }
        });
        help.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                Uri uri = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "Google is always there for u...be smart", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        donate.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {

                Uri uri = Uri.parse("https://www.paypal.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "I Will be always Thankfull for this donation", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        myxda.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                Uri uri = Uri.parse("https://forum.xda-developers.com/member.php?u=5999431");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "Check out My XDA Profile!!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });


        myfb.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                Uri uri = Uri.parse("https://www.facebook.com/omkar.shinde.5496");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "Check Out My Facebook!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });


        myinsta.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                Uri uri = Uri.parse("https://www.instagram.com/omkarshinde7");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "Check Out My Instagram!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });


        mywa.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {

                Toast.makeText(SettingsActivity.this, "Add +917276899986 to Contacts to Chat With ME!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    public void onBackPressed() {
    Intent home = new Intent(SettingsActivity.this,HomeActivity.class);
    startActivity(home);
        finish();
    }

}