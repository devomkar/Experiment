package com.ironoid.experiment.FCNDatabaase;



import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ironoid.experiment.Question;

public class Unit1 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "fcnunit1";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd";
    private SQLiteDatabase delddbase;
    public Unit1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        delddbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC +" TEXT, "+KEY_OPTD+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {		Question q1=new Question("1.A digital signal has 8 levels. How many bits are needed per level?",
                "2 bits","3 bits", "4 bits", "8 bits", "3 bits");
        this.addQuestion(q1);
		
        Question q2=new Question("2.As frequency increases, the period _________."
                , "Increases", "Decreases", "Double", "Remains same", "Decreases");
        this.addQuestion(q2);
		
        Question q3=new Question("3._________ signal repeats a pattern over and over again."
                , "Non-periodic", "Periodic", "Digital", "Non-periodic & Periodic", "");
        this.addQuestion(q3);
        
		Question q4=new Question("4.The __________ is time it takes to complete once."
                , "moduli", "frequency", "amplitude", "period", "period");
        this.addQuestion(q4);
        
		Question q5=new Question("5.The process of converting analog signals into digital signals so they can be processed by a receiving computer is referred to as ________."
                , "Modulation", "Demodulation", "Synchronizing", "De-Synchronizing", "Demodulation");
        this.addQuestion(q5);
        
		Question q6=new Question("6.The period of a signal is 100 ms. What is its frequency in kHz?"
                , "100 kHz", "10^-2 kHz", "10^-3 kHz", "10^-4 kHz", "10^-2 kHz");
        this.addQuestion(q6);
        
		Question q7=new Question("7.Given two sine waves A and B, if the frequency of A is twice that of B, then the period of B is ______ that of A."
                ,"one-half", "twice", "the same as", "indeterminate", "twice");
        this.addQuestion(q7);
        
		Question q8=new Question("8.A periodic signal has a bandwidth of 25 Hz. The lowest frequency is 20 Hz. What is the highest frequency?"
                , "5 Hz", "25 Hz", "20 Hz", "45 Hz", "45 Hz");
        this.addQuestion(q8);
        
		Question q9=new Question("9.Frequency is the rate of change with respect to time. This means that ________."
                , "change in a short span of time means high frequency", "period and frequency are proportional to each other ", "period and frequency are inverses of each other", "Both 1 & 3", "Both 1 & 3");
        this.addQuestion(q9);
        
		Question q10=new Question("10.The data rate is sometimes called the _________ rate."
                , "baud", "bit", "signal", "None of these", "bit");
        this.addQuestion(q10);
        
		Question q11=new Question("11.If composite signal contains frequencies between 2000 to 6000, then what is its bandwidth?"
                , "4000", "2000", "3000", "5000", "4000");
        this.addQuestion(q11);
        
		Question q12=new Question("12.Instead of referring to digital signals as having a period and frequency when measuring a signal’s bandwidth, one should refer to __________."
                , "byte rate & byte interval", "None of them", "bit rate & bit interval", "range and force", "bit rate & bit interval");
        this.addQuestion(q12);
        
		Question q13=new Question("13.A signal with constant amplitude of 10 volts has a frequency of ___________."
                , "0", "1", "10", "100", "0");
        this.addQuestion(q13);
        
		Question q14=new Question("14._______ is a type of transmission impairment in which the signal loses strength due to the resistance of the transmission medium"
                , "Distortion", "Decibel", "Noise", "Attenuation", "Attenuation");
        this.addQuestion(q14);
        
		Question q15=new Question("15.Following of which is not causes of impairment"
                ,"Distortion", "Error", "Noise", "Attenuation", "Error");
        this.addQuestion(q15);
        
		Question q16=new Question("16.________ means a loss of energy"
                , "Distortion", "Error", "Noise", "Attenuation", "Attenuation");
        this.addQuestion(q16);
        
		Question q17=new Question("17.In order to reduce interference, the signal should be __________."
                , "amplified", "multiplied", "demodulated", "modulated", "");
        this.addQuestion(q17);
        
		Question q18=new Question("18.For noiseless channel with a bandwidth of 3000 Hz transmitting a signal with two signal levels, what is the maximum bit rate? "
                , "1500 bps", "3000 bps", "6000 bps", "12000 bps", "6000 bps");
        this.addQuestion(q18);
        
		Question q19=new Question("19.Shannon capacity is used to determine the theoretical highest data rate for a _________ channel."
                , "Noiseless", "Noisy", "Noiseless & Noisy", "None of these", "Noisy");
        this.addQuestion(q19);
        
		Question q20=new Question("20.The signal at the input of an amplifier has a SNR of 30 dB. If the amplifier has a noise figure of 3 dB, the SNR at the output of the amplifier will be_________."
                , "3 dB", "27 dB", "30 dB", "33 dB", "27 dB");
        this.addQuestion(q20);
        
		Question q21=new Question("21.The equivalent power expressed in dBm for 1 W is __________. "
                , "0 dBm", "3 dBm", "10 dBm", "30 dBm", "3 dBm");
        this.addQuestion(q21);
        
		Question q22=new Question("22.The time taken for a signal to propagate from one node to another is called ___________."
                , "Propagation Delay", "Transmission time", "Node Delay", "Switching Time", "Propagation Delay");
        this.addQuestion(q22);
        
		Question q23=new Question("23.A network with bandwidth of 10 Mbps can pass only an average of 12000 frames per minute witheach frame carrying an average of 10000 bits. What is the throughput of this network?"
                , "2 Mbps", "5 Mbps", "10 Mbps", "None of these", "2 Mbps");
        this.addQuestion(q23);
        
		Question q24=new Question("24.The network with Throughput T and Delay D has a total ______ bits in transit at a time."
                , "D + T", "D - T", "D * T", "D / T", "D * T");
        this.addQuestion(q24);
        
		Question q25=new Question("25.Frequency of a failure and network recovery time after a failure is measure of the ___________ of a network"
                , "Performance", "Reliability", "Security", "Feasibility", "Performance");
        this.addQuestion(q25);
        
		Question q26=new Question("26.Before data can be transmitted, they must be transformed to ___________."
                , "Periodic signals", "Aperiodic signals", "Electromagnetic Signals", "low frequency waves", "Electromagnetic Signals");
        this.addQuestion(q26);
        
		Question q27=new Question("27.The term analog data refers to information that is ___________; digital data refers to information that has ________ states. "
                , "", "", "", "", "");
        this.addQuestion(q27);
        
		Question q28=new Question("28."
                , "", "", "", "", "");
        this.addQuestion(q28);
        
		Question q29=new Question("29."
                , "", "", "", "", "");
        this.addQuestion(q29);
        
		Question q30=new Question("30."
                , "", "", "", "", "");
        this.addQuestion(q30);
        
		Question q31=new Question("31."
                , "", "", "", "", "");
        this.addQuestion(q31);
        
		Question q32=new Question("32."
                , "", "", "", "", "");
        this.addQuestion(q32);
        
		Question q33=new Question("33."
                , "", "", "", "", "");
        this.addQuestion(q33);
        
		Question q34=new Question("34."
                , "", "", "", "", "");
        this.addQuestion(q34);
        
		Question q35=new Question("35."
                , "", "", "", "", "");
        this.addQuestion(q35);
        
		Question q36=new Question("36."
                , "", "", "", "", "");
        this.addQuestion(q36);
        
		Question q37=new Question("37."
                , "", "", "", "", "");
        this.addQuestion(q37);
        
		Question q38=new Question("38."
                , "", "", "", "", "");
        this.addQuestion(q38);
        
		Question q39=new Question("39."
                , "", "", "", "", "");
        this.addQuestion(q39);
        
		Question q40=new Question("40."
                , "", "", "", "", "");
        this.addQuestion(q40);
        
		Question q41=new Question("41."
                , "", "", "", "", "");
        this.addQuestion(q41);
        
		Question q42=new Question("42."
                , "", "", "", "", "");
        this.addQuestion(q42);
        
		Question q43=new Question("43."
                , "", "", "", "", "");
        this.addQuestion(q43);
        
		Question q44=new Question("44."
                , "", "", "", "", "");
        this.addQuestion(q44);
        
		Question q45=new Question("45."
                , "", "", "", "", "");
        this.addQuestion(q45);

        Question q46=new Question("46."
                , "", "", "", "", "");
        this.addQuestion(q46);

        Question q47=new Question("47."
                , "", "", "", "", "");
        this.addQuestion(q47);

        Question q48=new Question("48."
                , "", "", "", "", "");
        this.addQuestion(q48);

        Question q49=new Question("49."
                , "", "", "", "", "");
        this.addQuestion(q49);

        Question q50=new Question("50."
                , "", "", "", "", "");
        this.addQuestion(q50);
       
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        delddbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        delddbase=this.getReadableDatabase();
        Cursor cursor = delddbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();

        return row;
    }
}
