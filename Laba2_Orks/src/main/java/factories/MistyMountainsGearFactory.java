
package factories;

/**
 *
 * @author elenagoncarova
 */
public class MistyMountainsGearFactory implements OrkGearFactory {
    public String createWeapon() {
        return "Топоры";
    }
    public String createArmor() {
        return "Кожаная броня";
    }
    public String createBanner() {
        return "Знамя с луной";
    }    
}
