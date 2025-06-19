
package factories;

/**
 *
 * @author elenagoncarova
 */
public class MordorGearFactory implements OrkGearFactory {
    public String createWeapon() {
        return "Тяжелый меч";
    }
    public String createArmor() {
        return "Стальная броня";
    }
    public String createBanner() {
        return "Знамя с Красным Оком";
    }
}
