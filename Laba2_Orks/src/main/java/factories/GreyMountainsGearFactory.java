
package factories;

/**
 *
 * @author elenagoncarova
 */
public class GreyMountainsGearFactory implements OrkGearFactory {
        public String createWeapon() {
        return "Шпаги";
    }
    public String createArmor() {
        return "Брезентовая броня";
    }
    public String createBanner() {
        return "Знамя с волком";
    }
}
