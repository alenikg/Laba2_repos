
package factories;

import builderForOrk.OrkBuilder;

/**
 *
 * @author elenagoncarova
 */
public class DolGuldurBuilderFactory implements OrkBuilderFactory {
    private OrkGearFactory gearFactory;
    
    public DolGuldurBuilderFactory(OrkGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }
        
    @Override
    public OrkBuilder createOrkBuilder() {
        return new OrkBuilder()
                .setTribe("Дол Гулдур")
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
