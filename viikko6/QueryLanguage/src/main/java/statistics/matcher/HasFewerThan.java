
package statistics.matcher;
import statistics.Player;


public class HasFewerThan extends HasAtLeast {

	public HasFewerThan(int value, String category) {
		super(value, category);
	}

    @Override
    public boolean matches(Player p) {
    	return !super.matches(p);
    }
}
