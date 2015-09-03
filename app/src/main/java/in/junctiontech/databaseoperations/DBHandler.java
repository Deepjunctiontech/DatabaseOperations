package in.junctiontech.databaseoperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deep on 8/21/2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    public static final String tableNameEmployee = "employee";
    public static final String fieldEmployeeName = "name";
    public static final String fieldEmployeeEmail = "email";
    public static final String fieldEmployeeMobile = "mobile";
    public static final String fieldEmployeeDOB = "dob";
    public static final String fieldTypeText = "text";
    public static final String fieldTypeDate = "date";
    public static final String createTable = "create table";




    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String s = createTable+" "
                    +tableNameEmployee+" "
                    +" ( "
                    +fieldEmployeeName+" "+fieldTypeText+" , "
                    +fieldEmployeeEmail+" "+fieldTypeText+" , "
                    +fieldEmployeeMobile+" "+fieldTypeText+" , "
                    +fieldEmployeeDOB+" "+fieldTypeDate
                    +" ) "
                ;
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String[] getEmployee(){
        SQLiteDatabase db = super.getReadableDatabase();
        Cursor empData = db.rawQuery("Select * from " + tableNameEmployee, null);
        String str[] = new String[3];

        for (int i = 0; empData.moveToNext(); i++ ) {

            str[0] = empData.getString(empData.getColumnIndex(fieldEmployeeName));
            str[1] = empData.getString(empData.getColumnIndex(fieldEmployeeEmail));
            str[2] = empData.getString(empData.getColumnIndex(fieldEmployeeMobile));
        }
        db.close();
        return str;
    }

    public void setEmployee(String[] s ){

        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(fieldEmployeeName, s[0]);
        cv.put(fieldEmployeeEmail, s[1]);
        cv.put(fieldEmployeeMobile, s[2]);

        db.insert(tableNameEmployee,null,cv);
//        cv.put(fieldEmployeeDOB, dob);
        db.close();
    }
}
