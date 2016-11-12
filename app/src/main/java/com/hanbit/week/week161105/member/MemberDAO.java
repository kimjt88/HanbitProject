package com.hanbit.week.week161105.member;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */
// 디비와 많은 관련이 있는 DAO
// 서비스임플이 생성하는 DAO
// 보안에의해서 엑티비티에서 바로 사용하면 안된다.
public class MemberDAO {

    public MemberDAO(Context context) {

    }

    public void insert(MemberDTO param){

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
        MemberDTO member = new MemberDTO();
        return member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }

}
