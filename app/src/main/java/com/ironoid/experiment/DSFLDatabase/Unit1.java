package com.ironoid.experiment.DSFLDatabase;


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
    private static final String DATABASE_NAME = "dsflunit1";
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
    {
        Question q1=new Question("________is a linear structure in which items can be added or removed at one end ?",
                "Queue","Stack", "Recursion", "Linear List", "Stack");
        this.addQuestion(q1);

        Question q2=new Question("Which of the following is NOT the name used for stack?"
                , "FIFO", "LIFO", "Piles", "Push Down List", "FIFO");
        this.addQuestion(q2);

        Question q3=new Question("Stack data structure is?"
                , "LIFO", "LILO", "FIFO", "None", "LIFO");
        this.addQuestion(q3);

        Question q4=new Question("The process of inserting an element in the stack is called as?"
                , "Pop", "Create", "Evaluation", "Push", "Push");
        this.addQuestion(q4);

        Question q5=new Question("The process of removing element from stack is called as ?"
                , "Postfix expression", "Pop", "Push", "Create", "Pop");
        this.addQuestion(q5);

        Question q6=new Question("If user tries to remove element from empty stack then it is called as ?"
                , "Garbage Collection", "Underflow of stack", "Overflow of stack", "Empty Collection", "Underflow of stack");
        this.addQuestion(q6);

        Question q7=new Question("If User tries to put one element in the stack if stack is already full then stack becomes_____?"
                ,"User flow", "Underflow", "Crash", "Overflow", "Overflow");
        this.addQuestion(q7);

        Question q8=new Question("Stacks may be represented in the computer usually by means of one-way list or a ?"
                , "Linear Array", "Queue", "Recursion", "Linear List", "Linear Array");
        this.addQuestion(q8);

        Question q9=new Question("User Performs following operation on a stack of size 5\n\n Push(1);\n Pop();\n Push(2);\n Push(3);\n Pop();\n Push(4);\n Pop();\n Pop();\n Push(5);\n\nAt the end no of elements present in the stack is?"
                , "1", "2", "3", "4", "1");
        this.addQuestion(q9);

        Question q10=new Question("Consider stack is implemented using array.\n\n #define MAX 10\n struct Stack\n {\n int arr[MAX]\n int top\n };\n\nWhat will be initial value which top is initialized?"
                , "-1", "Garbage", "0", "1", "-1");
        this.addQuestion(q10);

        Question q11=new Question("With the ______ notation the operator symbol is placed between two operands."
                , "Infix", "Postfix", "Polish", "Exponential", "Infix");
        this.addQuestion(q11);

        Question q12=new Question("In lined representation of a stack, the ______ fields of the nodes holds the element of the stack."
                , "Link", "Info", "Pointer", "Node", "Info");
        this.addQuestion(q12);

        Question q13=new Question("An algorithm which calls itself directly or indirectly is called as ?"
                , "Sub Algorithm", "Polish notation", "Travel Algorithm", "Recursion", "Recursion");
        this.addQuestion(q13);

        Question q14=new Question("Consider that you areusing a stack for determining whether a sequence of parentheses is balanced. What is the maximum number of parentheses that will appear on the stack at any one time when algorithm analyzes \n\n (()(())(())) "
                , "1", "2", "3", "4", "3");
        this.addQuestion(q14);

        Question q15=new Question("Consider stack is implemented using array.\n\n #define MAX 10 \n struct stack \n { \n int arr[MAX] \n int top\n };\n\nIn this implementation of stack maximum value of top which cannot cause overflow will be_____"
                , "9", "10", "11", "None", "9");
        this.addQuestion(q15);

        Question q16=new Question("Suppose we have an array implementation of the stack, with ten items in the stack stored at data[0] through data[9]. The size is 42. Where does the push method place the data entry in array?"
                , "data[0]", "data[9]", "data[10]", "data[1]", "data[10]");
        this.addQuestion(q16);

        Question q17=new Question("______ notation refers to the notation in which the notation symbol is placed before its two operands."
                , "Postfix", "Prefix", "Polish", "Exponential", "Prefix");
        this.addQuestion(q17);

        Question q18=new Question("The term push and pop is related to the ?"
                , "stacks", "array", "lists", "map", "stacks");
        this.addQuestion(q18);

        Question q19=new Question("Pushdown list means_____"
                , "Queue", "Linked List", "Stack", "All of the above", "Stack");
        this.addQuestion(q19);

        Question q20=new Question("What is the time required to inserting an element in a stack with Linked implementation is _______"
                , "O(1)", "O(log n)", "O(n log n)", "O(n)", "O(1)");
        this.addQuestion(q20);

        Question q21=new Question("Which of the following is the feature of the stack?"
                , "It cannot reuse memory", "All elements are different type of data memory", "Any element can be accessed from it directly", "All operations are at the one end", "All operations are at the one end");
        this.addQuestion(q21);

        Question q22=new Question("What is the postfix representation of the following expression\n\n    (12-a)*(b+9)/(d*4)"
                , "b * d 9 + a 12 - * /", "/ 12 a - b 9 + d 4 *", "12 a - b 9 + * d 4 */", "12 - a * b + 9 / d * 4", "12 a - b 9 + * d 4 */");
        this.addQuestion(q22);

        Question q23=new Question("The data structure required to eveluate the postfix equation is"
                , "Array", "Queue", "Linked List", "Stack", "Stack");
        this.addQuestion(q23);

        Question q24=new Question("What is the postfix expression of the following expression\n    -A/B*C$DE"
                , "ABCDE$*/-", "A-BCDE$*/-", "ABC$ED*/-", "A-BCDE$*/", "ABCDE$*/-");
        this.addQuestion(q24);

        Question q25=new Question("The postfix form of A*B+C/D is"
                , "*AB+C/D", "AB*CD/+", "A*BC+/D", "ABCD+/*", "AB*CD/+");
        this.addQuestion(q25);

        Question q26=new Question("Which of the following types of expression does not require precedence rule when eveluated ?"
                , "Full Parenthesized infix expression", "Prefix expression", "Partially Parenthesized infix expression", "More than one of these", "More than one of these");
        this.addQuestion(q26);

        Question q27=new Question("What will be postfix expression for the following infix expression\n\n   A+B*C^D "
                , "ABCD^*+", "ABCD+*^", "ABCD*+^", "ABC+D*^", "ABCD^*+");
        this.addQuestion(q27);

        Question q28=new Question("Expression in which operator is written after the operand is called as________"
                , "Infix", "Postfix", "Prefix", "Hybrid Expression", "Postfix");
        this.addQuestion(q28);

        Question q29=new Question("In Computer Generally _______ Expressions are preferred. "
                ,"Infix", "Postfix", "Prefix", "Hybrid Expression", "Prefix");
        this.addQuestion(q29);

        Question q30=new Question("If the sequence of Operations :-\n\n push(1)\n push(2)\n pop()\n push(1)\n push(2)\n pop()\n pop()\n pop()\n push(2)\n pop()\n\nare performed on a stack , the sequence of popped out values are? "
                , "2 2 1 1 2", "2 2 1 2 2", "2 1 2 2 1", "2 1 2 2 2", "2 2 1 1 2");
        this.addQuestion(q30);

        Question q31=new Question("Stack cannot be used to"
                , "Allocating resources and scheduling", "Implementing of recursion", "Reverse String", "Evaluation of expression in postfix form", "Allocating resources and scheduling");
        this.addQuestion(q31);

        Question q32=new Question("Expression 1*2^34^5*6"
                , "32^30", "162^30", "173458", "49152", "49152");
        this.addQuestion(q32);

        Question q33=new Question("List of data in which element can be inserted and removed from same end is called as _______"
                , "List", "Stack", "Array", "Queue", "Stack");
        this.addQuestion(q33);

        Question q34=new Question("Adding elements to stack means ______."
                , "Placing element at rear end", "Placing Element at front end", "Placing Element at the top", "None of These", "Placing Element at the top");
        this.addQuestion(q34);

        Question q35=new Question("Stack can be implemented using ______ and _______."
                , "Queue and Graphs", "Array and Graphs", "Trees and Linked List", "Array and Linked List", "Array and Linked List");
        this.addQuestion(q35);

        Question q36=new Question("Postfix form of A+(B*C) is"
                , "ABC+*", "AB*C+", "AB+C*", "ABC*+", "AB+C*");
        this.addQuestion(q36);

        Question q37=new Question("What is the result of the following operation \n top(push(S,X))"
                , "X", "null", "S", "none of these", "X");
        this.addQuestion(q37);

        Question q38=new Question("A recursive function consists of how many parts?"
                , "1", "2", "3", "4", "2");
        this.addQuestion(q38);

        Question q39=new Question("Consider the following recursion function \n\n int result(int n)\n {\n   if(n==1)\n      return 2;\n    else\n         return 2*result(n-1);\n} "
                , "64", "32", "16", "8", "32");
        this.addQuestion(q39);

        Question q40=new Question("Stacks and Queues are _______."
                , "Primitive data structures", "Non Primitive data structures", "Non Linear data structures", "data types", "Non Primitive data structures");
        this.addQuestion(q40);

        Question q41=new Question("The pop operation is an error in case of "
                , "full stack", "empty stack", "empty queue", "full queue", "empty stack");
        this.addQuestion(q41);

        Question q42=new Question("The push operation triggers an error message on "
                , "full stack", "empty stack", "empty queue", "full queue", "full stack");
        this.addQuestion(q42);

        Question q43=new Question("To delete from stack we carry out _______ operation."
                , "Dequeue", "Remove", "Pop", "Push", "Pop");
        this.addQuestion(q43);

        Question q44=new Question("________  on stack is accessible."
                , "the top item", "the root", "the bottom item", "the high value item", "the top item");
        this.addQuestion(q44);

        Question q45=new Question("Stack can be full in _______ implementation."
                , "Tree", "Linked List", "Array", "None of these", "Array");
        this.addQuestion(q45);

        Question q46=new Question("A Reverse postfix way of writing arithmetic expression is"
                , "Recursive", "Big-O notation", "Quadratic", "Reverse Polish notation", "Reverse Polish notation");
        this.addQuestion(q46);

        Question q47=new Question("To implement recursion the data structure used is_______"
                , "Stack", "Queue", "Priority Queue", "Tree", "Stack");
        this.addQuestion(q47);

        Question q48=new Question("To evaluate an expression in reverse polish notation we use _____ for each operator encountered."
                , "one push", "two push", "one pop", "two pops", "two pops");
        this.addQuestion(q48);

        Question q49=new Question("Consider following function\n\n void foo(int n)\n {\n  if(n>0)\n {\n   foo(n-1);\n   printf(%d,n);\n   foo(n-1);\n  }\n }"
                , "3 2 1 1 2 1 1", "1 2 1 3 1 2 1", "1 1 2 1 2 1 3", "None of these", "1 2 1 3 1 2 1");
        this.addQuestion(q49);

        Question q50=new Question("Stack is used when _____ is needed"
                , "FIFO", "FILO", "LIFO", "both 2 & 3", "both 2 & 3");
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
