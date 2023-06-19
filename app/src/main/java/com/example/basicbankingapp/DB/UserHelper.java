package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Supriya Kashyap', 'supriya@gmail.com','5679','8097641238', 34000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5647,'Arunima Ambastha', 'aruni@gmail.com','8765','8995641238', 89000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2345,'Jeet Kumar', 'jeet@gmail.com','9765','7595645896', 6000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8904,'Ujjwal Kumar', 'ujji@gmail.com','1345','9995640038', 6700)");
        db.execSQL("insert into " + TABLE_NAME + " values(9867,'Anurag Das', 'das@gmail.com','7654','9095648962', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9870,'Anushka tiwari', 'tiwari123@gmail.com','8754','8855640238', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2345,'Rahul Raj', 'raj01@gmail.com','6543','8895640215', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(6543,'Manas Parashar', 'parasar@gmail.com','2678','9985021539', 3000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9854,'Shambhavi Singh', 'bhavi923@gmail.com','4578','9309565238', 80500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2341,'Shanvi Kashyap', 'kashyap@gmail.com','2134','8292591201', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7652,'Samarth Singh', 'sidd@gmail.com','8976','9015641200', 2300)");
        db.execSQL("insert into " + TABLE_NAME + " values(8765,'Shivani Kumari', 'shivani999@gmail.com','9867','9995641999', 78000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1024,'Muskan Kumari', 'muskan@gmail.com','1123','9119541001', 3900)");
        db.execSQL("insert into " + TABLE_NAME + " values(6754,'Nikhil Prajapati', 'nik45@gmail.com','7890','6254642205', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7234,'Mohit Raj', 'mohit@gmail.com','2345','6893641266', 9810)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
