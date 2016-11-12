package com.hanbit.week.week161105.member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public interface MemberService {
    public void join(MemberDTO param);   //C
    public int count();
    public MemberDTO detail(String id);
    public ArrayList<MemberDTO> list();
    public boolean login(MemberDTO param);
    public void update(MemberDTO param);
    public void delete(MemberDTO param);
}
