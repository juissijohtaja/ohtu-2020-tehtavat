/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import java.util.ArrayDeque;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author juhakoivu
 */
public class QueryBuilder {
    private ArrayDeque<Matcher> matchers;

    public QueryBuilder() {
        matchers = new ArrayDeque<>();
    }

    public Matcher build() {
        if (this.matchers.isEmpty()) {
            return new All();
        }
        return new And(this.matchers.toArray(new Matcher[0]));
    }
    
    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher...queryMatchers) {
        this.matchers.add(new Or(queryMatchers));
        return this;
    }
    
    
}
