package com.ironoid.experiment.DSFLFragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ironoid.experiment.DSFLDatabase.Unit1;
import com.ironoid.experiment.DSFLDatabase.Unit2;
import com.ironoid.experiment.DSFLDatabase.Unit3;
import com.ironoid.experiment.DSFLDatabase.Unit4;
import com.ironoid.experiment.HomeActivity;
import com.ironoid.experiment.Question;
import com.ironoid.experiment.R;

import java.util.List;


public class OneFragment extends Fragment {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    int totalq = 6;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    Animation slide,slide2,slide3,slide4,slide5,slidefab;

    public OneFragment() {
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
        final View view = inflater.inflate(R.layout.fragment_one, container, false);

        slide = AnimationUtils.loadAnimation(getContext(), R.anim.slide);
        slide2 = AnimationUtils.loadAnimation(getContext(),R.anim.slide2);
        slide3 = AnimationUtils.loadAnimation(getContext(),R.anim.slide3);
        slide4 = AnimationUtils.loadAnimation(getContext(),R.anim.slide4);
        slide5 = AnimationUtils.loadAnimation(getContext(),R.anim.slide5);
        slidefab = AnimationUtils.loadAnimation(getContext(),R.anim.slidefab);

        Button b1 = (Button) view.findViewById(R.id.unit1);

        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(getView(),"This is stacks",Snackbar.LENGTH_LONG).show();
                return false;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalq = 50;
                final Dialog d = new Dialog(getActivity(), android.R.style.Theme_Material_NoActionBar);
                d.setContentView(R.layout.mcq_dialog);
                d.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                d.setCancelable(false);
                d.show();
                Unit1 db = new Unit1(getActivity());
                quesList = db.getAllQuestions();
                currentQ = quesList.get(qid);
                TextView mcq_heading = (TextView) d.findViewById(R.id.mcq_heading);
                mcq_heading.setText("Unit I");
                ImageView back = (ImageView) d.findViewById(R.id.mcq_back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder close = new AlertDialog.Builder(getActivity());

                        close.setTitle("Exit Test?");
                        close.setMessage("Do you really want to exit the Test?");
                        close.setPositiveButton("Yes", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        d.dismiss();
                                        qid = 0;
                                        score = 0;
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
                });
                txtQuestion = (TextView) d.findViewById(R.id.question);
                rda = (RadioButton) d.findViewById(R.id.radio0);
                rdb = (RadioButton) d.findViewById(R.id.radio1);
                rdc = (RadioButton) d.findViewById(R.id.radio2);
                rdd = (RadioButton) d.findViewById(R.id.radio3);
                butNext = (Button) d.findViewById(R.id.nxt);
                setQuestionView();
                butNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {anim();
                        final RadioGroup grp = (RadioGroup) d.findViewById(R.id.radioGroup1);
                        final RadioButton answer = (RadioButton) d.findViewById(grp.getCheckedRadioButtonId());

                        Log.d("youRans", currentQ.getANSWER() + " " + answer.getText());


                        if (currentQ.getANSWER().equals(answer.getText())) {
                            final Snackbar snackbar = Snackbar
                                    .make(v, "Awesome Right Answer", Snackbar.LENGTH_LONG);
                            snackbar.setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            });
                            snackbar.show();
                            score++;
                            Log.d("score", "Your score" + score);
                        } else {
                            final Snackbar snackbar = Snackbar
                                    .make(v, "Wrong...The Right Answer is " + currentQ.getANSWER(), Snackbar.LENGTH_INDEFINITE);
                            snackbar.setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            });
                            snackbar.show();

                        }

                        if (qid < totalq) {

                            currentQ = quesList.get(qid);
                            setQuestionView();
                        } else {
                            d.cancel();
                            d.dismiss();
                            final Dialog d2 = new Dialog(getActivity(), android.R.style.Theme_Material_NoActionBar);
                            d2.setContentView(R.layout.mcq_result_dialog);
                            d2.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                            d2.setCancelable(false);
                            TextView t = (TextView) d2.findViewById(R.id.score);
                            TextView t2 = (TextView) d2.findViewById(R.id.quote);
                            RatingBar ratingBar = (RatingBar) d2.findViewById(R.id.ratingBar);
                            ImageView back = (ImageView) d2.findViewById(R.id.mcq_result_back);
                            ImageView home = (ImageView) d2.findViewById(R.id.mcq_result_home);
                            ImageView share = (ImageView) d2.findViewById(R.id.mcq_result_share);
                            t.setText("Your Score is " + score + " out of " + qid + ". ");
                            if (score <= 10) {
                                t2.setText("You Need to Study Hard");
                                ratingBar.setRating(1);
                            } else if (score <= 20) {
                                t2.setText("You Can Do Better");
                                ratingBar.setRating(2);
                            } else if (score <= 30) {
                                t2.setText("Good...You are going good");
                                ratingBar.setRating(3);
                            } else if (score <= 40) {
                                t2.setText("You Beat 75% of users");
                                ratingBar.setRating(4);
                            } else if (score <= 50) {
                                t2.setText("You are Awesome.You beat 90% of the users");
                                ratingBar.setRating(5);
                            }
                            qid = 0;
                            score = 0;
                            back.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    d2.dismiss();
                                    qid = 0;
                                    score = 0;
                                }
                            });
                            home.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    d2.dismiss();
                                    Intent i = new Intent(getActivity(), HomeActivity.class);
                                    startActivity(i);
                                    getActivity().finish();
                                }
                            });
                            share.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String share_body = "Hey , I just Scored " + score + " out of " + qid + " in this wonderful app Experiment\n" +
                                            "You can study MCQ's and Frequently Asked Questions asked in Online Exam and Viva and Old Question Papers using your Phone.\n" +
                                            "Just Download the App From Here www.ironoid.blogspot.com";
                                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                    sharingIntent.setType("text/plain");
                                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Experiment:Where You Learn");
                                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, share_body);
                                    startActivity(Intent.createChooser(sharingIntent, "Share using"));
                                }
                            });
                            d2.show();
                        }
                    }


                });
            }
        });

        Button b2 = (Button) view.findViewById(R.id.unit2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new Dialog(getActivity(), android.R.style.Theme_Material_NoActionBar);
                d.setContentView(R.layout.mcq_dialog);
                d.setCancelable(false);
                d.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                d.show();
                Unit2 db = new Unit2(getActivity());
                quesList = db.getAllQuestions();
                currentQ = quesList.get(qid);
                TextView mcq_heading = (TextView) d.findViewById(R.id.mcq_heading);
                mcq_heading.setText("Unit II");
                ImageView back = (ImageView) d.findViewById(R.id.mcq_back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder close = new AlertDialog.Builder(getActivity());

                        close.setTitle("Exit Test?");
                        close.setMessage("Do you really want to exit the Test?");
                        close.setPositiveButton("Yes", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        d.dismiss();
                                        qid = 0;
                                        score = 0;
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
                });
                txtQuestion = (TextView) d.findViewById(R.id.question);
                rda = (RadioButton) d.findViewById(R.id.radio0);
                rdb = (RadioButton) d.findViewById(R.id.radio1);
                rdc = (RadioButton) d.findViewById(R.id.radio2);
                rdd = (RadioButton) d.findViewById(R.id.radio3);
                butNext = (Button) d.findViewById(R.id.nxt);
                setQuestionView();
                butNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {anim();
                        final RadioGroup grp = (RadioGroup) d.findViewById(R.id.radioGroup1);
                        final RadioButton answer = (RadioButton) d.findViewById(grp.getCheckedRadioButtonId());

                        Log.d("youRans", currentQ.getANSWER() + " " + answer.getText());


                        if (currentQ.getANSWER().equals(answer.getText())) {
                            final Snackbar snackbar = Snackbar
                                    .make(v, "Awesome Right Answer", Snackbar.LENGTH_LONG);
                            snackbar.setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            });
                            snackbar.show();
                            score++;
                            Log.d("score", "Your score" + score);
                        } else {
                            final Snackbar snackbar = Snackbar
                                    .make(v, "Wrong...The Right Answer is " + currentQ.getANSWER(), Snackbar.LENGTH_INDEFINITE);
                            snackbar.setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            });
                            snackbar.show();

                        }

                        if (qid < totalq) {

                            currentQ = quesList.get(qid);
                            setQuestionView();
                        } else {
                            d.cancel();
                            d.dismiss();
                            final Dialog d2 = new Dialog(getActivity(), android.R.style.Theme_Material_NoActionBar);
                            d2.setContentView(R.layout.mcq_result_dialog);
                            d2.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                            d2.setCancelable(false);
                            TextView t = (TextView) d2.findViewById(R.id.score);
                            TextView t2 = (TextView) d2.findViewById(R.id.quote);
                            RatingBar ratingBar = (RatingBar) d2.findViewById(R.id.ratingBar);
                            ImageView back = (ImageView) d2.findViewById(R.id.mcq_result_back);
                            ImageView home = (ImageView) d2.findViewById(R.id.mcq_result_home);
                            ImageView share = (ImageView) d2.findViewById(R.id.mcq_result_share);
                            t.setText("Your Score is " + score + " out of " + qid + ". ");
                            if (score <= 10) {
                                t2.setText("You Need to Study Hard");
                                ratingBar.setRating(1);
                            } else if (score <= 20) {
                                t2.setText("You Can Do Better");
                                ratingBar.setRating(2);
                            } else if (score <= 30) {
                                t2.setText("Good...You are going good");
                                ratingBar.setRating(3);
                            } else if (score <= 40) {
                                t2.setText("You Beat 75% of users");
                                ratingBar.setRating(4);
                            } else if (score <= 50) {
                                t2.setText("You are Awesome.You beat 90% of the users");
                                ratingBar.setRating(5);
                            }
                            qid = 0;
                            score = 0;
                            back.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    d2.dismiss();
                                    qid = 0;
                                    score = 0;
                                }
                            });
                            home.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(getActivity(), HomeActivity.class);
                                    startActivity(i);
                                    getActivity().finish();
                                }
                            });
                            share.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String share_body = "Hey , I just Scored " + score + " out of " + qid + " in this wonderful app Experiment\n" +
                                            "You can study MCQ's and Frequently Asked Questions asked in Online Exam and Viva and Old Question Papers using your Phone.\n" +
                                            "Just Download the App From Here www.ironoid.blogspot.com";
                                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                    sharingIntent.setType("text/plain");
                                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Experiment:Where You Learn");
                                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, share_body);
                                    startActivity(Intent.createChooser(sharingIntent, "Share using"));
                                }
                            });
                            d2.show();
                        }
                    }


                });
            }
        });


        Button b3 = (Button) view.findViewById(R.id.unit3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new Dialog(getActivity(), android.R.style.Theme_Material_NoActionBar);
                d.setContentView(R.layout.mcq_dialog);
                d.setCancelable(false);
                d.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                d.show();
                Unit3 db = new Unit3(getActivity());
                quesList = db.getAllQuestions();
                currentQ = quesList.get(qid);
                TextView mcq_heading = (TextView) d.findViewById(R.id.mcq_heading);
                mcq_heading.setText("Unit III");
                ImageView back = (ImageView) d.findViewById(R.id.mcq_back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder close = new AlertDialog.Builder(getActivity());

                        close.setTitle("Exit Test?");
                        close.setMessage("Do you really want to exit the Test?");
                        close.setPositiveButton("Yes", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        d.dismiss();
                                        qid = 0;
                                        score = 0;
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
                });
                txtQuestion = (TextView) d.findViewById(R.id.question);
                rda = (RadioButton) d.findViewById(R.id.radio0);
                rdb = (RadioButton) d.findViewById(R.id.radio1);
                rdc = (RadioButton) d.findViewById(R.id.radio2);
                rdd = (RadioButton) d.findViewById(R.id.radio3);
                butNext = (Button) d.findViewById(R.id.nxt);
                setQuestionView();
                butNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {anim();
                        final RadioGroup grp = (RadioGroup) d.findViewById(R.id.radioGroup1);
                        final RadioButton answer = (RadioButton) d.findViewById(grp.getCheckedRadioButtonId());

                        Log.d("youRans", currentQ.getANSWER() + " " + answer.getText());


                        if (currentQ.getANSWER().equals(answer.getText())) {
                            final Snackbar snackbar = Snackbar
                                    .make(v, "Awesome Right Answer", Snackbar.LENGTH_LONG);
                            snackbar.setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            });
                            snackbar.show();
                            score++;
                            Log.d("score", "Your score" + score);
                        } else {
                            final Snackbar snackbar = Snackbar
                                    .make(v, "Wrong...The Right Answer is " + currentQ.getANSWER(), Snackbar.LENGTH_INDEFINITE);
                            snackbar.setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            });
                            snackbar.show();

                        }

                        if (qid < totalq) {

                            currentQ = quesList.get(qid);
                            setQuestionView();
                        } else {
                            d.cancel();
                            d.dismiss();
                            final Dialog d2 = new Dialog(getActivity(), android.R.style.Theme_Material_NoActionBar);
                            d2.setContentView(R.layout.mcq_result_dialog);
                            d2.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                            d2.setCancelable(false);
                            TextView t = (TextView) d2.findViewById(R.id.score);
                            TextView t2 = (TextView) d2.findViewById(R.id.quote);
                            RatingBar ratingBar = (RatingBar) d2.findViewById(R.id.ratingBar);
                            ImageView back = (ImageView) d2.findViewById(R.id.mcq_result_back);
                            ImageView home = (ImageView) d2.findViewById(R.id.mcq_result_home);
                            ImageView share = (ImageView) d2.findViewById(R.id.mcq_result_share);
                            t.setText("Your Score is " + score + " out of " + qid + ". ");
                            if (score <= 10) {
                                t2.setText("You Need to Study Hard");
                                ratingBar.setRating(1);
                            } else if (score <= 20) {
                                t2.setText("You Can Do Better");
                                ratingBar.setRating(2);
                            } else if (score <= 30) {
                                t2.setText("Good...You are going good");
                                ratingBar.setRating(3);
                            } else if (score <= 40) {
                                t2.setText("You Beat 75% of users");
                                ratingBar.setRating(4);
                            } else if (score <= 50) {
                                t2.setText("You are Awesome.You beat 90% of the users");
                                ratingBar.setRating(5);
                            }
                            qid = 0;
                            score = 0;
                            back.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    d2.dismiss();
                                    qid = 0;
                                    score = 0;
                                }
                            });
                            home.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(getActivity(), HomeActivity.class);
                                    startActivity(i);
                                    getActivity().finish();
                                }
                            });
                            share.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String share_body = "Hey , I just Scored " + score + " out of " + qid + " in this wonderful app Experiment\n" +
                                            "You can study MCQ's and Frequently Asked Questions asked in Online Exam and Viva and Old Question Papers using your Phone.\n" +
                                            "Just Download the App From Here www.ironoid.blogspot.com";
                                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                    sharingIntent.setType("text/plain");
                                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Experiment:Where You Learn");
                                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, share_body);
                                    startActivity(Intent.createChooser(sharingIntent, "Share using"));
                                }
                            });
                            d2.show();
                        }
                    }


                });
            }
        });


        Button b4 = (Button) view.findViewById(R.id.unit4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new Dialog(getActivity(), android.R.style.Theme_Material_NoActionBar);
                d.setContentView(R.layout.mcq_dialog);
                d.setCancelable(false);
                d.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                d.show();
                Unit4 db = new Unit4(getActivity());
                quesList = db.getAllQuestions();
                currentQ = quesList.get(qid);
                TextView mcq_heading = (TextView) d.findViewById(R.id.mcq_heading);
                mcq_heading.setText("Unit IV");
                ImageView back = (ImageView) d.findViewById(R.id.mcq_back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder close = new AlertDialog.Builder(getActivity());

                        close.setTitle("Exit Test?");
                        close.setMessage("Do you really want to exit the Test?");
                        close.setPositiveButton("Yes", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        d.dismiss();
                                        qid = 0;
                                        score = 0;
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
                });
                txtQuestion = (TextView) d.findViewById(R.id.question);
                rda = (RadioButton) d.findViewById(R.id.radio0);
                rdb = (RadioButton) d.findViewById(R.id.radio1);
                rdc = (RadioButton) d.findViewById(R.id.radio2);
                rdd = (RadioButton) d.findViewById(R.id.radio3);
                butNext = (Button) d.findViewById(R.id.nxt);
                setQuestionView();
                butNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {anim();
                        final RadioGroup grp = (RadioGroup) d.findViewById(R.id.radioGroup1);
                        final RadioButton answer = (RadioButton) d.findViewById(grp.getCheckedRadioButtonId());

                        Log.d("youRans", currentQ.getANSWER() + " " + answer.getText());


                        if (currentQ.getANSWER().equals(answer.getText())) {
                            final Snackbar snackbar = Snackbar
                                    .make(v, "Awesome Right Answer", Snackbar.LENGTH_LONG);
                            snackbar.setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            });
                            snackbar.show();
                            score++;
                            Log.d("score", "Your score" + score);
                        } else {
                            final Snackbar snackbar = Snackbar
                                    .make(v, "Wrong...The Right Answer is " + currentQ.getANSWER(), Snackbar.LENGTH_INDEFINITE);
                            snackbar.setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            });
                            snackbar.show();

                        }

                        if (qid < totalq) {

                            currentQ = quesList.get(qid);
                            setQuestionView();
                        } else {
                            d.cancel();
                            d.dismiss();
                            final Dialog d2 = new Dialog(getActivity(), android.R.style.Theme_Material_NoActionBar);
                            d2.setContentView(R.layout.mcq_result_dialog);
                            d2.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationslide;
                            d2.setCancelable(false);
                            TextView t = (TextView) d2.findViewById(R.id.score);
                            TextView t2 = (TextView) d2.findViewById(R.id.quote);
                            RatingBar ratingBar = (RatingBar) d2.findViewById(R.id.ratingBar);
                            ImageView back = (ImageView) d2.findViewById(R.id.mcq_result_back);
                            ImageView home = (ImageView) d2.findViewById(R.id.mcq_result_home);
                            ImageView share = (ImageView) d2.findViewById(R.id.mcq_result_share);
                            t.setText("Your Score is " + score + " out of " + qid + ". ");
                            if (score <= 10) {
                                t2.setText("You Need to Study Hard");
                                ratingBar.setRating(1);
                            } else if (score <= 20) {
                                t2.setText("You Can Do Better");
                                ratingBar.setRating(2);
                            } else if (score <= 30) {
                                t2.setText("Good...You are going good");
                                ratingBar.setRating(3);
                            } else if (score <= 40) {
                                t2.setText("You Beat 75% of users");
                                ratingBar.setRating(4);
                            } else if (score <= 50) {
                                t2.setText("You are Awesome.You beat 90% of the users");
                                ratingBar.setRating(5);
                            }
                            qid = 0;
                            score = 0;
                            back.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    d2.dismiss();
                                    qid = 0;
                                    score = 0;
                                }
                            });
                            home.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(getActivity(), HomeActivity.class);
                                    startActivity(i);
                                    getActivity().finish();
                                }
                            });
                            share.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String share_body = "Hey , I just Scored " + score + " out of " + qid + " in this wonderful app Experiment\n" +
                                            "You can study MCQ's and Frequently Asked Questions asked in Online Exam and Viva and Old Question Papers using your Phone.\n" +
                                            "Just Download the App From Here www.ironoid.blogspot.com";
                                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                    sharingIntent.setType("text/plain");
                                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Experiment:Where You Learn");
                                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, share_body);
                                    startActivity(Intent.createChooser(sharingIntent, "Share using"));
                                }
                            });
                            d2.show();
                        }
                    }


                });
            }
        });

        return view;
    }
    public void anim()
    {
        txtQuestion.startAnimation(slidefab);
        rda.startAnimation(slide);
        rdb.startAnimation(slide2);
        rdc.startAnimation(slide3);
        rdd.startAnimation(slide4);

    }


    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());
        qid++;
    }
}