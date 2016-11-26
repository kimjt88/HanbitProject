package com.hanbit.week.week161105.movie;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-26.
 */

public interface MovieService {

    //SELECT
    public void add(MovieDTO param);
    public int count();
    public MovieDTO findOne(String key);
    public ArrayList<MovieDTO> findBy(MovieDTO param);
    public ArrayList <MovieDTO> list();
    //UPDATE
    public void update(MovieDTO param);
    //DELETE
    public void delete(String key);

}
