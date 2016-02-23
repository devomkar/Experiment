package com.ironoid.experiment;

import android.app.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AlertDialog;


import com.koushikdutta.ion.Ion;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private final static int RESULT_SELECT_IMAGE = 100;
    private static final String TAG = "GalleryUtil";

    public SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    private HandleXML obj;



    Animation slide,slide2,slide3,slide4,slide5,slidefab,rotate;



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
        setContentView(R.layout.activity_home);


        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String themeName = pref.getString("theme_select", "Blue");
        Boolean pic = pref.getBoolean("pic_bg",true);
        RelativeLayout rel = (RelativeLayout)findViewById(R.id.rel);
        if(pic)
        {
            rel.setBackgroundResource(R.drawable.home_bg);
        }
        LinearLayout h = (LinearLayout) findViewById(R.id.header);
        if (themeName.equals("Blue")) {
            h.setBackgroundColor(getResources().getColor(R.color.blue));
        }else if (themeName.equals("Green")) {
            h.setBackgroundColor(getResources().getColor(R.color.green));
        } else if (themeName.equals("Red")) {
            h.setBackgroundColor(getResources().getColor(R.color.red));
        } else if (themeName.equals("Orange")) {
            h.setBackgroundColor(getResources().getColor(R.color.orange));
        } else if (themeName.equals("Pink")) {
            h.setBackgroundColor(getResources().getColor(R.color.pink));
        }else if (themeName.equals("Purple")) {
            h.setBackgroundColor(getResources().getColor(R.color.purple));
        }else if (themeName.equals("Voilet")) {
            h.setBackgroundColor(getResources().getColor(R.color.voilet));
        }else if (themeName.equals("Yellow")) {
            h.setBackgroundColor(getResources().getColor(R.color.yellow));
        }else if (themeName.equals("Cyan")) {
            h.setBackgroundColor(getResources().getColor(R.color.cyan));
        }else if (themeName.equals("Teal")) {
            h.setBackgroundColor(getResources().getColor(R.color.teal));
        }else if (themeName.equals("Indigo")) {
            h.setBackgroundColor(getResources().getColor(R.color.indigo));
        }



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        slide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide);
        slide2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide2);
        slide3 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide3);
        slide4 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide4);
        slide5 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide5);
        slidefab = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slidefab);
        rotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);

      final String picturePath = PreferenceManager.getDefaultSharedPreferences(this).getString("picturePath", "");
        if(!picturePath.equals(""))
        {
            CircleImageView imageView = (CircleImageView) findViewById(R.id.profile);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
        final String pp = picturePath;
        Button fcnactivity = (Button) findViewById(R.id.button);
        fcnactivity.startAnimation(slide);
        fcnactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fcn = new Intent(HomeActivity.this, FCNActivity.class);
                startActivity(fcn);
                finish();
            }
        });

        Button cgactivity = (Button) findViewById(R.id.button2);
        cgactivity.startAnimation(slide2);
        cgactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cg = new Intent(HomeActivity.this, CGActivity.class);
                startActivity(cg);
                finish();
            }
        });

        Button paiactivity = (Button) findViewById(R.id.button3);
        paiactivity.startAnimation(slide3);
        paiactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pai = new Intent(HomeActivity.this, PAIActivity.class);
                startActivity(pai);
                finish();
            }
        });

        Button m3activity = (Button) findViewById(R.id.button4);
        m3activity.startAnimation(slide4);
        m3activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m3 = new Intent(HomeActivity.this, M3Activity.class);
                startActivity(m3);
                finish();
            }
        });

        Button dsflactivity = (Button) findViewById(R.id.button5);
        dsflactivity.startAnimation(slide5);
        dsflactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dsfl = new Intent(HomeActivity.this, DSFLActivity.class);
                startActivity(dsfl);
                finish();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.startAnimation(slidefab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Uri> uris = new ArrayList<Uri>();
                Intent sendIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                sendIntent.setType("application/vnd.android.package-archive");
                uris.add(Uri.fromFile(new File(getApplicationInfo().publicSourceDir)));
                sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                startActivity(Intent.createChooser(sendIntent, null));

                Snackbar.make(view, "Share Knowledge", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
        if (firstrun){
            final Dialog d = new Dialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
            d.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
            d.setContentView(R.layout.aboutapp_dialog);
            d.setCancelable(false);
            Button b = (Button)d.findViewById(R.id.nxtbtn);
            d.onBackPressed();
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { d.dismiss();
                    final Dialog d1 = new Dialog(HomeActivity.this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                    d1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    d1.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                    d1.setCancelable(false);
                    d1.setContentView(R.layout.aboutapp_dialog1);
                    Button b1 = (Button) d1.findViewById(R.id.nxtbtn1);
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {d1.dismiss();
                            final Dialog d2 = new Dialog(HomeActivity.this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                            d2.setCancelable(false);
                            d2.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            d2.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                            d2.setContentView(R.layout.aboutapp_dialog2);
                            Button b2 = (Button) d2.findViewById(R.id.nxtbtn2);
                            b2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {d2.dismiss();
                                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                    drawer.openDrawer(GravityCompat.START);
                                    final Dialog dialog = new Dialog(HomeActivity.this);
                                    dialog.setCancelable(false);
                                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                    dialog.setContentView(R.layout.firstrun_dialog);
                                    Button gotit = (Button) dialog.findViewById(R.id.gotit);
                                    gotit.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                            drawer.closeDrawer(GravityCompat.START);
                                            dialog.dismiss();
                                            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                                                    .edit()
                                                    .putBoolean("firstrun", false)
                                                    .commit();
                                        }

                                    });
                                    final Window window = dialog.getWindow();
                                    window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                                    window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                    dialog.show();

                                }
                            });
                            final Window w = d.getWindow();
                            w.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
                            w.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                            d2.show();
                        }
                    });
                    final Window w = d.getWindow();
                    w.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
                    w.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                    d1.show();
                }
            });
            final Window w = d.getWindow();
            w.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
            w.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            d.show();

/*
	Wire One, 400
*/


        }


        final TextView name1 = (TextView) findViewById(R.id.name1);
        final TextView mail = (TextView) findViewById(R.id.mail);

        final ImageView profile = (ImageView) findViewById(R.id.profile);
        final Context context = this;
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               profile();
            }

        });


        SharedPreferences o = getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
        String nm = o.getString(Name, "");
        String em = o.getString(Email,"");
        if(nm.equals(""))
        {  name1.setText("Your Profile");
            mail.setText("Click on Icon to edit profile");}
        else {
            name1.setText(nm);
            mail.setText(em);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case RESULT_SELECT_IMAGE:

                if (resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
                    try{
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA };
                        Cursor cursor = getContentResolver().query(selectedImage,
                                filePathColumn, null, null, null);
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        String picturePath = cursor.getString(columnIndex);
                        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("picturePath", picturePath).commit();
                        cursor.close();

                        //return Image Path to the Main Activity
                        Intent returnFromGalleryIntent = new Intent();
                        returnFromGalleryIntent.putExtra("picturePath", picturePath);
                        setResult(RESULT_OK, returnFromGalleryIntent);
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        // Log.d(TAG, String.valueOf(bitmap));

                        CircleImageView imageView = (CircleImageView) findViewById(R.id.profile);
                        imageView.setImageBitmap(bitmap);

                        profile();


                    }catch(Exception e){
                        e.printStackTrace();
                        Intent returnFromGalleryIntent = new Intent();
                        setResult(RESULT_CANCELED, returnFromGalleryIntent);

                    }
                }else{
                    Log.i(TAG, "RESULT_CANCELED");
                    Intent returnFromGalleryIntent = new Intent();
                    setResult(RESULT_CANCELED, returnFromGalleryIntent);
                    profile();

                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder close = new AlertDialog.Builder(this);

            close.setTitle("Really Exit ?");
            close.setMessage("Do you really want to exit the app ?");
            close.setPositiveButton("Yes", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
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
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
     if (id == R.id.exit) {
            AlertDialog.Builder close = new AlertDialog.Builder(this);

            close.setTitle("Really Exit ?");
            close.setMessage("Do you really want to exit the app ?");
            close.setPositiveButton("Yes", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
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

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if(id == R.id.best_scores)
        {
            bestscore();
        }
        else  if (id == R.id.about_app) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            alertDialogBuilder.setTitle("Getting Started");
            alertDialogBuilder.setMessage("This app is Devloped for students of SE Engg to study while using their smartphone." +
                    "\n\nThis app will help you to improve your knowledge." +
                    "\n\nBe serious about STUDIES." +
                    "\n\nThank You " +
                    "\nOmkar Shinde");

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else if (id == R.id.share) {
            String shareBody = "Hey , have a look at this wonderfull app Experiment.\nYou can Revise Your MCQ's and " +
                    "Frequently Asked Questions asked in Online Exam and Theory Exam Using your Phone." +
                    "\nYou can also see old Question Papers of Previous Years." +
                    "\nJust Download the App From Here www.ironoid.blogspot.in";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "FAQ App:");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share Using"));

        } else if (id == R.id.action_settings) {
            Intent i = new Intent(HomeActivity.this, SettingsActivity.class);
            startActivity(i);
            finish();
            return true;

        } else if (id == R.id.update) {
            final Dialog d = new Dialog(HomeActivity.this);
            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
            d.setContentView(R.layout.update_dialog);
            Button yes =(Button)d.findViewById(R.id.vvv);
            Button no =(Button)d.findViewById(R.id.no);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    update();
                    d.dismiss();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    d.dismiss();
                }
            });
            d.show();


        } else if (id == R.id.devloper) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            Toast.makeText(HomeActivity.this, "Be What You Are...;-)", Toast.LENGTH_LONG).show();
            alertDialogBuilder.setIcon(R.drawable.omkar);
            alertDialogBuilder.setTitle("Omkar Shinde");
            alertDialogBuilder.setItems(R.array.array_value, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    public void profile()
    {   final TextView name1 = (TextView) findViewById(R.id.name1);
        final TextView mail = (TextView) findViewById(R.id.mail);
        final ImageView profile = (ImageView) findViewById(R.id.profile);
        final String pp = PreferenceManager.getDefaultSharedPreferences(this).getString("picturePath", "");
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog, null);
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationfade;
        TextView head = (TextView) dialog.findViewById(R.id.head);
        final CircleImageView pic = (CircleImageView) dialog.findViewById(R.id.pro);
        if(!pp.equals("")){pic.setImageBitmap(BitmapFactory.decodeFile(pp));}
        final TextView info = (TextView) dialog.findViewById(R.id.info);
        final EditText name = (EditText) dialog.findViewById(R.id.name);
        final EditText email = (EditText) dialog.findViewById(R.id.email);
        Button reset = (Button)dialog.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(HomeActivity.this).edit().putString("picturePath", "").commit();
                pic.setImageResource(R.drawable.profile);
                profile.setImageResource(R.drawable.profile);
            }
        });
        Button dialogButton = (Button) dialog.findViewById(R.id.ok);
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_SELECT_IMAGE);
                info.setText("The Picture will be updated after restart");
                dialog.dismiss();
            }
        });
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String e = email.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Email, e);
                editor.commit();
                if (!n.equals("")) {
                    name1.setText(n);
                    mail.setText(e);
                }
                dialog.dismiss();


                recreate();


            }

        });
        name.setText(sharedpreferences.getString(Name, ""));
        email.setText(sharedpreferences.getString(Email, ""));
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    }


    public void bestscore()
    {
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);

        final Dialog d = new Dialog(this, android.R.style.Theme_Light_NoTitleBar);
        d.setContentView(R.layout.high_scores);
        d.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
        ImageView back = (ImageView)d.findViewById(R.id.back_highscore);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        ListView lv = (ListView)d.findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"Unit I - " + p.getInt("fcn_unit1_best_score", 0), "Unit II - " + p.getInt("fcn_unit2_best_score", 0), "Unit III - " + p.getInt("fcn_unit3_best_score", 0), "Unit IV - " + p.getInt("fcn_unit4_best_score", 0)}));
        ListView lv2 = (ListView)d.findViewById(R.id.listView2);
        lv2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"Unit I - " + p.getInt("cg_unit1_best_score", 0), "Unit II - " + p.getInt("cg_unit2_best_score", 0), "Unit III - " + p.getInt("cg_unit3_best_score", 0), "Unit IV - " + p.getInt("cg_unit4_best_score", 0)}));
        ListView lv3 = (ListView)d.findViewById(R.id.listView3);
        lv3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"Unit I - " + p.getInt("pai_unit1_best_score", 0), "Unit II - " + p.getInt("pai_unit2_best_score", 0), "Unit III - " + p.getInt("pai_unit3_best_score", 0), "Unit IV - " + p.getInt("pai_unit4_best_score", 0)}));
        ListView lv4 = (ListView)d.findViewById(R.id.listView4);
        lv4.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"Unit I - " + p.getInt("m3_unit1_best_score", 0), "Unit II - " + p.getInt("m3_unit2_best_score", 0), "Unit III - " + p.getInt("m3_unit3_best_score", 0), "Unit IV - " + p.getInt("m3_unit4_best_score", 0)}));
        ListView lv5 = (ListView)d.findViewById(R.id.listView5);
        lv5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[] {"Unit I - "+p.getInt("dsf_unit1_best_score",0), "Unit II - "+p.getInt("dsf_unit2_best_score",0), "Unit III - "+p.getInt("dsf_unit3_best_score",0),"Unit IV - "+p.getInt("dsf_unit4_best_score",0)}));

        d.show();
    }

public void update(){

            String url = "https://raw.githubusercontent.com/omkar1997/Experiment/master/update.xml";

            obj = new HandleXML(url);
            obj.fetchXML();
            while(obj.parsingComplete);
            String y = obj.getUpdate();
            String cl = obj.getChangelog();
            String rd = obj.getRel_date();

            if(y.equals("bta1"))
            {
                Toast.makeText(HomeActivity.this, "No Update Available", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(HomeActivity.this, " Update Available", Toast.LENGTH_LONG).show();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

                alertDialogBuilder.setTitle("Update Available");
                alertDialogBuilder.setMessage("Current Version:- 1.0\n\nVersion Available:-" + y + "\n\nChangelog:-" + cl + "\n\nRelease Date:-" + rd);
                alertDialogBuilder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri = Uri.parse("https://raw.githubusercontent.com/omkar1997/Experiment/master/Experiment.apk");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


                            }


}

}
