package br.ufam.edu.vss.janken.controller;

import java.util.HashMap;
import java.util.Map;

import br.ufam.edu.vss.janken.model.Result;
import br.ufam.edu.vss.janken.model.Rule;
import br.ufam.edu.vss.janken.model.Shape;

public class Controller {

    private Map<Rule, Result> rules;

    private static Controller instance = new Controller();

    public Controller() {
        rules = new HashMap<Rule, Result>();
    }

    public synchronized static Controller getInstance() {
        return instance;
    }

    public void init() {
        addRule(new Rule(Shape.PAPER, Shape.ROCK), Result.BEATS, true);
        addRule(new Rule(Shape.ROCK, Shape.SCISSORS), Result.BEATS, true);
        addRule(new Rule(Shape.SCISSORS, Shape.PAPER), Result.BEATS, true);
        addRule(new Rule(Shape.PAPER, Shape.PAPER), Result.TIE, false);
        addRule(new Rule(Shape.ROCK, Shape.ROCK), Result.TIE, false);
        addRule(new Rule(Shape.SCISSORS, Shape.SCISSORS), Result.TIE, false);
    }

    public void addRule(Rule rule, Result result, boolean addOpposite) {
        Rule oppositeRule = getOppositeRule(rule);
        Result oppositeResult = getOppositeResult(result);
        rules.put(rule, result);
        rules.put(oppositeRule, oppositeResult);
    }

    public Result getResult(Rule rule) {
        if (rules.containsKey(rule)) {
            return rules.get(rule);
        } else {
            return Result.UNKNOWN;
        }
    }

    private Rule getOppositeRule(Rule rule) {
        return new Rule(rule.getSecond(), rule.getFirst());
    }

    public Result getOppositeResult(Result result) {
        return result == Result.BEATS ? Result.IS_BEATEN_BY
                : result == Result.IS_BEATEN_BY ? Result.BEATS : result == Result.TIE ? Result.TIE : Result.UNKNOWN;
    }

}
