package com.kitri.myspringboard2.mapper;

import com.kitri.myspringboard2.domain.Board;
import com.kitri.myspringboard2.domain.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM comment WHERE board_id = #{boardId}")
    List<Comment> findCommentsByBoardId(long boardId);

    @Insert("INSERT INTO comment (content, username, board_id, created_at) VALUES (#{content}, #{username}, #{boardId}, NOW())")
    void insert(Comment comment);

    @Update("UPDATE comment SET content=#{content} WHERE id=#{id}")
    void update(Comment comment);

    @Delete("DELETE FROM comment WHERE id = #{id}")
    void delete(long id);

}
