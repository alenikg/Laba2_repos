
package factories;

import builderForOrk.OrkBuilder;

/**
 *
 * @author elenagoncarova
 */
public class MistyMountainsBuilderFactory implements OrkBuilderFactory {
    private OrkGearFactory gearFactory;

    public MistyMountainsBuilderFactory(OrkGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }
    
    @Override
    public OrkBuilder createOrkBuilder() {
        return new OrkBuilder()
                .setTribe("Мглистые Горы")
                .setAttributes(50, 50, 20, 130)
                .setWeapon(gearFactory.createWeapon())
                .setArmor(gearFactory.createArmor());    
    }

    @Override
    public OrkBuilder createOrkBuilder(Boolean withBanner) {
        return createOrkBuilder()
                .setBanner(gearFactory.createBanner());    
    }
}
