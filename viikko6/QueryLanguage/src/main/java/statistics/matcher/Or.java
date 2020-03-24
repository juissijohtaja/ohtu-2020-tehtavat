/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author juhakoivu
 */
public class Or implements Matcher  {
    private Matcher[] matchers;

    public Or(Matcher... queryMatchers) {
        this.matchers = queryMatchers;
    }
    
    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                return true;
            }
        }

        return false;
    }
    
}
