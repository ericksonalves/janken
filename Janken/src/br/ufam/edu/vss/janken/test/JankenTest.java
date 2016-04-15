package br.ufam.edu.vss.janken.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufam.edu.vss.janken.controller.Controller;
import br.ufam.edu.vss.janken.model.Result;
import br.ufam.edu.vss.janken.model.Rule;
import br.ufam.edu.vss.janken.model.Shape;
import br.ufam.edu.vss.janken.view.ResultPanel;

public class JankenTest {

	@Test
	public void getResultTest() {
		Controller tester = new Controller();
		tester.init();
		
		Rule rulePaperRock = new Rule(Shape.PAPER,Shape.ROCK);
		Rule rulePaperPaper  = new Rule (Shape.PAPER,Shape.PAPER);
		Rule rulePaperScissors =  new Rule (Shape.PAPER,Shape.SCISSORS);
		
		Rule ruleRockPaper = new Rule (Shape.ROCK,Shape.PAPER);
		Rule ruleRockRock =  new Rule (Shape.ROCK,Shape.ROCK);
		Rule ruleRockScissors =  new Rule (Shape.ROCK,Shape.SCISSORS);
		
		Rule ruleScissorsPaper = new Rule (Shape.SCISSORS,Shape.PAPER);
		Rule ruleScissorsScissors = new Rule (Shape.SCISSORS,Shape.SCISSORS);
		Rule ruleScissorsRock =  new Rule (Shape.SCISSORS,Shape.ROCK);
		
		assertEquals (true, Result.BEATS == tester.getResult(rulePaperRock));
		assertEquals (true, Result.TIE == tester.getResult(rulePaperPaper));
		assertEquals (true, Result.IS_BEATEN_BY == tester.getResult(rulePaperScissors));
		
		assertEquals(true, Result.IS_BEATEN_BY == tester.getResult(ruleRockPaper));
		assertEquals(true, Result.TIE == tester.getResult(ruleRockRock));
		assertEquals(true, Result.BEATS ==  tester.getResult(ruleRockScissors));
		
		assertEquals(true, Result.BEATS  == tester.getResult(ruleScissorsPaper));
		assertEquals(true, Result.TIE == tester.getResult(ruleScissorsScissors));
		assertEquals(true, Result.IS_BEATEN_BY == tester.getResult(ruleScissorsRock));
		
		
		//fail("Not yet implemented");
	}

}
