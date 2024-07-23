package com.kitri.myspringboard2.service;

import com.kitri.myspringboard2.domain.Board;
import com.kitri.myspringboard2.domain.Comment;
import com.kitri.myspringboard2.mapper.BoardMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Transactional
class BoardServiceTest {

    @Mock
    private BoardMapper boardMapper;

    @Mock
    private UserService userService;

    @Mock
    private CommentService commentService;

    @InjectMocks
    private BoardService boardService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Board> mockBoards = Arrays.asList(
                Board.createBoard("Title1", "Content1", "user1"),
                Board.createBoard("Title2", "Content2", "user2")
        );

        when(boardMapper.findAll()).thenReturn(mockBoards);

        List<Board> boards = boardService.findAll();
        assertNotNull(boards);
        assertEquals(2, boards.size());
    }

    @Test
    void testFindById() {
        Board mockBoard = Board.createBoard("Title1", "Content1", "user1");
        List<Comment> mockComments = Arrays.asList(
                Comment.createComment("Comment1", "user1", mockBoard.getId()),
                Comment.createComment("Comment2", "user1", mockBoard.getId())
        );

        when(boardMapper.findById(mockBoard.getId())).thenReturn(mockBoard);
        when(commentService.findCommentsByBoardId(mockBoard.getId())).thenReturn(mockComments);

        Board board = boardService.findById(mockBoard.getId());
        assertNotNull(board);
        assertEquals(mockBoard.getId(), board.getId());
        assertEquals(2, board.getComments().size());
    }

    @Test
    void testInsert() {
        Board newBoard = new Board();
        newBoard.setTitle("New Title");
        newBoard.setContent("New Content");
        newBoard.setUsername("user1");

        boardService.insert(newBoard);

        verify(boardMapper, times(1)).insert(newBoard);
    }

//    @Test
//    void testUpdate() {
//        Board updatedBoard = new Board(1L, "Updated Title", "Updated Content", "user1");
//
//        boardService.update(updatedBoard);
//
//        verify(boardMapper, times(1)).update(updatedBoard);
//    }
//
//    @Test
//    void testDelete() {
//        boardService.delete(1L);
//
//        verify(boardMapper, times(1)).delete(1L);
//    }
}
