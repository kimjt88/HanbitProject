package com.hanbit.week.week161105.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static com.hanbit.week.week161105.global.Member.ADDR;
import static com.hanbit.week.week161105.global.Member.EMAIL;
import static com.hanbit.week.week161105.global.Member.ID;
import static com.hanbit.week.week161105.global.Member.MEMBER_TABLE;
import static com.hanbit.week.week161105.global.Member.NAME;
import static com.hanbit.week.week161105.global.Member.PHONE;
import static com.hanbit.week.week161105.global.Member.PHOTO;
import static com.hanbit.week.week161105.global.Member.PW;

/**
 * Created by 1027 on 2016-11-12.
 */
// 디비와 많은 관련이 있는 DAO
// 서비스임플이 생성하는 DAO
// 보안에의해서 엑티비티에서 바로 사용하면 안된다.
public class MemberDAO extends SQLiteOpenHelper {


    public MemberDAO(Context context) {
        super(context, "hanbit3.db", null, 1);
        this.getWritableDatabase();
        Log.d("DB 생성","====================== SUCCESS =================");
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ MEMBER_TABLE+"\n" +
                "(\n" +
                ID+" text primary key,\n" +
                PW+" text,\n" +
                NAME+" text,\n" +
                EMAIL+" text,\n" +
                PHONE+" text,\n" +
                PHOTO+" text,\n" +
                ADDR+" text\n" +
                ");");
        db.execSQL("INSERT INTO "+ MEMBER_TABLE+" ("+ ID+"," +
                " "+ PW+", "+ NAME+", "+ EMAIL+", "+ PHONE+", "+ PHOTO+", "+ ADDR+")\n" +
                "VALUES ('hong','1','jitea','test@test.test','010-1234-1234','default.jpg','서울');");

        db.execSQL("INSERT INTO "+ MEMBER_TABLE+" ("+ ID+"," +
                " "+ PW+", "+ NAME+", "+ EMAIL+", "+ PHONE+", "+ PHOTO+", "+ ADDR+")\n" +
                "VALUES ('test1','2','test1','test@test.test','010-4122-7234','default.jpg','대구');");

        db.execSQL("INSERT INTO "+ MEMBER_TABLE+" ("+ ID+"," +
                " "+ PW+", "+ NAME+", "+ EMAIL+", "+ PHONE+", "+ PHOTO+", "+ ADDR+")\n" +
                "VALUES ('test2','3','test2','test@test.test','010-1768-8234','default.jpg','부산');");

        db.execSQL("INSERT INTO "+ MEMBER_TABLE+" ("+ ID+"," +
                " "+ PW+", "+ NAME+", "+ EMAIL+", "+ PHONE+", "+ PHOTO+", "+ ADDR+")\n" +
                "VALUES ('test3','4','test3','test@test.test','010-1521-4234','default.jpg','광주');");

        db.execSQL("INSERT INTO "+ MEMBER_TABLE+" ("+ ID+"," +
                " "+ PW+", "+ NAME+", "+ EMAIL+", "+ PHONE+", "+ PHOTO+", "+ ADDR+")\n" +
                "VALUES ('test4','5','test4','test@test.test','010-1342-1654','default.jpg','미국');");

        db.execSQL("INSERT INTO "+ MEMBER_TABLE+" ("+ ID+"," +
                " "+ PW+", "+ NAME+", "+ EMAIL+", "+ PHONE+", "+ PHOTO+", "+ ADDR+")\n" +
                "VALUES ('test5','6','test5','test@test.test','010-1765-1234','default.jpg','중국');");
        Log.d("DB 생성","====================== SUCCESS =================");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(MemberDTO param){
        String sql = "INSERT INTO member ";
        //내장 디비
        // SQLiteOpenHelper 상속받는다.
        Log.d("DAO : ID ",param.getId());
        Log.d("DAO : PW ",param.getPw());
        Log.d("DAO : NAME ",param.getName());
        Log.d("DAO : PHONE ",param.getPhone());
        Log.d("DAO : ADDR ",param.getAddr());
        Log.d("DAO : EMAIL ",param.getEmail());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }



    public MemberDTO selectOn(String id){

        String sql = "select "+String.format("%s,%s,%s,%s,%s,%s",ID,NAME,EMAIL,PHONE,PHOTO,ADDR)+" " +
                "from "+ MEMBER_TABLE+" where id = '"+id+"';";
        MemberDTO member = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

//        if(cursor != null){
//            Log.d("DAO LIST IS","EXIST");
//            cursor.moveToFirst();
//        }
        if(cursor.moveToNext()){
            member = new MemberDTO();
            member.setId(cursor.getString(0));
            member.setName(cursor.getString(1));
            member.setEmail(cursor.getString(2));
            member.setPhone(cursor.getString(3));
            member.setPhoto(cursor.getString(4));
            member.setAddr(cursor.getString(5));
        }else{
            member = null;
        }



        return member;
    }
    public ArrayList<MemberDTO> selectList(){
        String sql = "SELECT "+String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,PHONE,PHOTO,ADDR)+" " +
                "FROM member;";
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor != null){
            Log.d("DAO LIST IS","EXIST");
            cursor.moveToFirst();
        }
        do{
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setPhoto(cursor.getString(5));
            temp.setAddr(cursor.getString(6));
            list.add(temp);
        }while (cursor.moveToNext());

        return list;
    }
    public MemberDTO login(MemberDTO param){
        Log.d("Login : ",param.getId());
        Log.d("Login : ",param.getPw());
        String sql = "select "+ PW+" from "+ MEMBER_TABLE+" where id = '"+param.getId()+"';";
        MemberDTO member = new MemberDTO();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            member.setPw(cursor.getString(0));
        }
        Log.d("PW",member.getPw());
        return member;
    }
    public void update(MemberDTO member){

        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE member SET" +
                " "+PW+" = '"+member.getPw()+"'," +
                " "+EMAIL+" = '"+member.getEmail()+"', " +
                " "+PHONE+" = '"+member.getPhone()+"', " +
                " "+ADDR+" = '"+member.getAddr()+"' WHERE" +
                " "+ID+" = '"+member.getId()+"';");
    }
    public void delete(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("DELETE FROM member where "+ID+" = '"+id+"'");
    }

}
