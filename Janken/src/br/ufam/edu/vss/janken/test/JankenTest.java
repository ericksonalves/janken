package br.ufam.edu.vss.janken.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufam.edu.vss.janken.controller.Controller;
import br.ufam.edu.vss.janken.model.Result;
import br.ufam.edu.vss.janken.model.Rule;
import br.ufam.edu.vss.janken.model.Shape;

public class JankenTest {

    private Controller controller;

    @Before
    public void setUp() {
        controller = new Controller();
        controller.init();
    }

    @Test
    public void testResultNullRule() {
        Rule rule = null;
        assertEquals(Result.UNKNOWN, controller.getResult(rule));
    }

    @Test
    public void testResultPaperAndPaper() {
        Rule rule = new Rule(Shape.PAPER, Shape.PAPER);
        assertEquals(Result.TIE, controller.getResult(rule));
    }

    @Test
    public void testResultPaperAndRock() {
        Rule rule = new Rule(Shape.PAPER, Shape.ROCK);
        assertEquals(Result.BEATS, controller.getResult(rule));
    }

    @Test
    public void testResultPaperAndScissors() {
        Rule rule = new Rule(Shape.PAPER, Shape.SCISSORS);
        assertEquals(Result.IS_BEATEN_BY, controller.getResult(rule));
    }

    @Test
    public void testResultRockAndPaper() {
        Rule rule = new Rule(Shape.ROCK, Shape.PAPER);
        assertEquals(Result.IS_BEATEN_BY, controller.getResult(rule));
    }

    @Test
    public void testResultRockAndRock() {
        Rule rule = new Rule(Shape.ROCK, Shape.ROCK);
        assertEquals(Result.TIE, controller.getResult(rule));
    }

    @Test
    public void testResultRockAndScissors() {
        Rule rule = new Rule(Shape.ROCK, Shape.SCISSORS);
        assertEquals(Result.BEATS, controller.getResult(rule));
    }

    @Test
    public void testResultScissorsAndPaper() {
        Rule rule = new Rule(Shape.SCISSORS, Shape.PAPER);
        assertEquals(Result.BEATS, controller.getResult(rule));
    }

    @Test
    public void testResultScissorsAndRock() {
        Rule rule = new Rule(Shape.SCISSORS, Shape.ROCK);
        assertEquals(Result.IS_BEATEN_BY, controller.getResult(rule));
    }

    @Test
    public void testResultScissorsAndScissors() {
        Rule rule = new Rule(Shape.SCISSORS, Shape.SCISSORS);
        assertEquals(Result.TIE, controller.getResult(rule));
    }

    @After
    public void tearDown() {
        controller = null;
    }

}
