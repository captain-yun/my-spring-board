package com.kitri.myspringboard2.mapper;

import com.kitri.myspringboard2.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM board")
    List<Board> findAll();

    @Select("SELECT * FROM board WHERE id = #{id}")
    Board findById(long id);

    @Insert("INSERT INTO board(title, content, username) VALUES (#{title}, #{content}, #{username})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Board board);

    @Update("UPDATE board SET title=#{title}, content=#{content}, username=#{username} WHERE id=#{id}")
    void update(Board board);

    @Delete("DELETE FROM board WHERE id = #{id}")
    void delete(long id);

}
