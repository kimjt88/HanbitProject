package com.hanbit.week.week161105.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hanbit.week.week161105.global.Member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */
// 디비와 많은 관련이 있는 DAO
// 서비스임플이 생성하는 DAO
// 보안에의해서 엑티비티에서 바로 사용하면 안된다.
public class MemberDAO extends SQLiteOpenHelper {


    public MemberDAO(Context context) {
        super(context, "hanbit.db", null, 1);
        this.getWritableDatabase();
        Log.d("DB 생성","====================== SUCCESS =================");
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ Member.MEMBER_TABLE+"\n" +
                "(\n" +
                Member.ID+" text primary key,\n" +
                Member.PW+" text,\n" +
                Member.NAME+" text,\n" +
                Member.EMAIL+" text,\n" +
                Member.PHONE+" text,\n" +
                Member.PHOTO+" text,\n" +
                Member.ADDR+" text\n" +
                ");");
        db.execSQL("INSERT INTO "+Member.MEMBER_TABLE+" ("+Member.ID+"," +
                " "+Member.PW+", "+Member.NAME+", "+Member.EMAIL+", "+Member.PHONE+", "+Member.PHOTO+", "+Member.ADDR+")\n" +
                "VALUES ('hong','1','jitea','test@test.test','010-1234-1234','default.jpg','서울');");

        Log.d("DB 생성","====================== SUCCESS =================");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(MemberDTO param){
        String sql = "";
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

    public int selectCount(){
        int count = 0 ;
        return count;
    }

    public MemberDTO selectOn(String id){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public ArrayList<MemberDTO> selectList(){
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        return list;
    }
    public MemberDTO login(MemberDTO param){
        Log.d("Login : ",param.getId());
        Log.d("Login : ",param.getPw());
        String sql = "select "+Member.PW+" from "+Member.MEMBER_TABLE+" where id = '"+param.getId()+"';";
        MemberDTO member = new MemberDTO();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            member.setPw(cursor.getString(0));
        }
        Log.d("PW",member.getPw());
        return member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }

}
