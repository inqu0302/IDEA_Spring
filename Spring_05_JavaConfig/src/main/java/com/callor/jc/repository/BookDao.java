package com.callor.jc.repository;

import com.callor.jc.model.BookVO;
import com.callor.jc.repository.sql.BookSQL;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookDao {

    @Select("SELECT * FROM tbl_members")
    public List<BookVO> selectAll();

//    @Insert(BookSQL.book_insert_sql)
    @InsertProvider(type=BookSQL.class, method="book_insert")
    public int insert(BookVO bookVO);


    // @Update() : 문자열로 만든 SQL 을 실행할때
    // sql 클래스를 사용했을경우에는 Provider 로 실행
    @UpdateProvider(type=BookSQL.class, method="book_update_sql")
    public int update(BookVO bookVO);

    @Delete("DELET FROM tbl_members WHERE username = #{isbn}")
    public int delete(String isbn);
}
