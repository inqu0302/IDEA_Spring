package com.callor.jc.repository;

import org.apache.ibatis.annotations.Select;

public interface DDL_Dao {

    // 명령문이기 때문에 $ 로 취급해주어야 한다
    @Select("${create_table}")
    public void create_table(String create_table);

}
