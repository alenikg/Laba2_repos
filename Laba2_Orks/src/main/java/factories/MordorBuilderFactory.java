
package factories;

import builderForOrk.OrkBuilder;

/**
 *
 * @author elenagoncarova
 */
public class MordorBuilderFactory implements OrkBuilderFactory {
    private OrkGearFactory gearFactory;
    
    public MordorBuilderFactory(OrkGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }

    @Override
    public OrkBuilder createOrkBuilder() {
        return new OrkBuilder()
                .setTribe("Мордор")
                .setAttributes(70, 30, 20, 100)
                .setWeapon(gearFactory.createWeapon())
                .setArmor(gearFactory.createArmor());  
    }

    @Override
    public OrkBuilder createOrkBuilder(Boolean withBanner) {
       return createOrkBuilder()
               .setBanner(gearFactory.createBanner());
    }
}
