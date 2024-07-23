package com.kitri.myspringboard2.mapper;

import com.kitri.myspringboard2.domain.Board;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@MybatisTest
@SpringBootTest
//@Sql(scripts = {"/schema.sql", "/data.sql"})
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testFindAll() {
        List<Board> boards = boardMapper.findAll();
        assertNotNull(boards);
        assertFalse(boards.isEmpty());
    }

    @Test
    public void testFindById() {
        Board board = new Board();
        board.setTitle("New Title");
        board.setContent("New Content");
        board.setUsername("user1");

        boardMapper.insert(board);
        assertNotNull(board.getId());

        Board board2 = boardMapper.findById(board.getId());
        assertNotNull(board2);
        assertEquals(board2.getId(), board.getId());
    }

    @Test
    public void testInsert() {
        Board board = new Board();
        board.setTitle("New Title");
        board.setContent("New Content");
        board.setUsername("user1");

        boardMapper.insert(board);
        assertNotNull(board.getId());

        Board insertedBoard = boardMapper.findById(board.getId());
        assertEquals("New Title", insertedBoard.getTitle());
    }

    @Test
    public void testUpdate() {
        Board board = new Board();
        board.setTitle("New Title");
        board.setContent("New Content");
        board.setUsername("user1");

        boardMapper.insert(board);

        Board board2 = boardMapper.findById(board.getId());
        board2.setTitle("Updated Title");

        boardMapper.update(board2);

        Board updatedBoard = boardMapper.findById(board2.getId());
        assertEquals("Updated Title", updatedBoard.getTitle());
    }

    @Test
    public void testDelete() {
        Board board = new Board();
        board.setTitle("New Title");
        board.setContent("New Content");
        board.setUsername("user1");

        boardMapper.insert(board);
        boardMapper.delete(board.getId());

        Board board2 = boardMapper.findById(board.getId());
        assertNull(board2);
    }
}
