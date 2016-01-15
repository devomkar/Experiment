package com.ironoid.experiment.FCNFragments;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ironoid.experiment.R;
import com.ironoid.experiment.TouchImageView;
import com.koushikdutta.ion.Ion;


public class ThreeFragment extends Fragment{

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_three, container, false);


        Button button2 = (Button)view.findViewById(R.id.jun15);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog d =new Dialog(getActivity());
                d.setContentView(R.layout.qp_page2_dialog);
                d.setTitle("Choose Page to View");
                d.show();
                Button p1 = (Button)d.findViewById(R.id.page1);
                Button p2 = (Button)d.findViewById(R.id.page2);

                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/fcn_may15_1.png");
                        d1.show();
                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/fcn_may15_2.png");
                        d1.show();
                    }
                });

            }
        });

        Button button3 = (Button)view.findViewById(R.id.dec14);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog d =new Dialog(getActivity());
                d.setContentView(R.layout.qp_page3_dialog);
                d.setTitle("Choose Page to View");
                d.show();
                Button p1 = (Button)d.findViewById(R.id.page1);
                Button p2 = (Button)d.findViewById(R.id.page2);
                Button p3 = (Button)d.findViewById(R.id.page3);
                Button p4 = (Button)d.findViewById(R.id.page4);

                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/fcn_dec14_1.png");
                        d1.show();
                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/fcn_dec14_2.png");
                        d1.show();
                    }
                });
                p3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/fcn_dec14_3.png");
                        d1.show();
                    }
                });

            }
        });

        Button button4 = (Button)view.findViewById(R.id.jun14);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog d =new Dialog(getActivity());
                d.setContentView(R.layout.qp_page3_dialog);
                d.setTitle("Choose Page to View");
                d.show();
                Button p1 = (Button)d.findViewById(R.id.page1);
                Button p2 = (Button)d.findViewById(R.id.page2);
                Button p3 = (Button)d.findViewById(R.id.page3);
                Button p4 = (Button)d.findViewById(R.id.page4);

                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/fcn_may14_1.png");
                        d1.show();
                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/fcn_may14_2.png");
                        d1.show();
                    }
                });
                p3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/fcn_may14_3.png");
                        d1.show();
                    }
                });

            }
        });

        Button button5 = (Button)view.findViewById(R.id.dec13);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog d =new Dialog(getActivity());
                d.setContentView(R.layout.qp_page4_dialog);
                d.setTitle("Choose Page to View");
                d.show();
                Button p1 = (Button)d.findViewById(R.id.page1);
                Button p2 = (Button)d.findViewById(R.id.page2);
                Button p3 = (Button)d.findViewById(R.id.page3);
                Button p4 = (Button)d.findViewById(R.id.page4);

                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/database.png");
                        d1.show();
                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/database.png");
                        d1.show();
                    }
                });
                p3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/database.png");
                        d1.show();
                    }
                });
                p4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/database.png");
                        d1.show();
                    }
                });
            }
        });


        Button button6 = (Button)view.findViewById(R.id.jun13);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog d =new Dialog(getActivity());
                d.setContentView(R.layout.qp_page4_dialog);
                d.setTitle("Choose Page to View");
                d.show();
                Button p1 = (Button)d.findViewById(R.id.page1);
                Button p2 = (Button)d.findViewById(R.id.page2);
                Button p3 = (Button)d.findViewById(R.id.page3);
                Button p4 = (Button)d.findViewById(R.id.page4);

                p1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/database.png");
                        d1.show();
                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/database.png");
                        d1.show();
                    }
                });
                p3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/database.png");
                        d1.show();
                    }
                });
                p4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog d1 = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        d1.setTitle("Page 1");
                        d1.setContentView(R.layout.zoom_dialog);
                        TouchImageView i1 = (TouchImageView)d1.findViewById(R.id.imgpaper);
                        Ion.with(i1)
                                .placeholder(R.drawable.loading)
                                .error(R.drawable.load_error)
                                .load("https://raw.githubusercontent.com/omkar1997/F.A.Q/master/app/src/main/res/papers/database.png");
                        d1.show();
                    }
                });
            }
        });



        return view;
    }

}