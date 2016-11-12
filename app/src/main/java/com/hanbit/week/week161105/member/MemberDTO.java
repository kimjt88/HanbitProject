package com.hanbit.week.week161105.member;

/**
 * Created by 1027 on 2016-11-12.
 */

// 프로퍼티 설정값
// 모델링 작업
public class MemberDTO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private String photo;
    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "아이디='" + id + '\'' +
                ", 비밀번호='" + pw + '\'' +
                ", 이름='" + name + '\'' +
                ", 이메일='" + email + '\'' +
                ", 전화번호='" + phone + '\'' +
                ", 이미지='" + photo + '\'' +
                ", 주소='" + addr + '\'' +
                '}';
    }
}
