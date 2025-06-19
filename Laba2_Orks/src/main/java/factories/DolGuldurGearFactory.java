
package factories;

/**
 *
 * @author elenagoncarova
 */
public class DolGuldurGearFactory implements OrkGearFactory {
    public String createWeapon() {
        return "Копья";
    }
    public String createArmor() {
        return "Кольчуги";
    }
    public String createBanner() {
        return "Знамя с черепом";
    }
}
