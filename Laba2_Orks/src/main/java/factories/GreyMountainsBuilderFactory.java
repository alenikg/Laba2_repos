
package factories;

import builderForOrk.OrkBuilder;

/**
 *
 * @author elenagoncarova
 */
public class GreyMountainsBuilderFactory implements OrkBuilderFactory {
    private OrkGearFactory gearFactory;

    public GreyMountainsBuilderFactory(OrkGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }
    
    @Override
    public OrkBuilder createOrkBuilder() {
        return new OrkBuilder()
                .setTribe("Серые Горы")
                .setAttributes(40, 70, 50, 180)
                .setWeapon(gearFactory.createWeapon())
                .setArmor(gearFactory.createArmor());    
    }

    @Override
    public OrkBuilder createOrkBuilder(Boolean withBanner) {
        return createOrkBuilder()
                .setBanner(gearFactory.createBanner());    
    }
}
