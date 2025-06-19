
package main;

import com.github.javafaker.Faker;
import factories.OrkBuilderFactory;
import java.util.Locale;
import model.Ork;

/**
 *
 * @author elenagoncarova
 */
public class OrkDirector {
    private OrkBuilderFactory builderFactory;
    private Faker faker = new Faker(new Locale("ru-RU"));
    
    public OrkDirector(OrkBuilderFactory factory) {
        this.builderFactory = factory;
    }
    
    private String generateName() {
        return faker.lordOfTheRings().character();
    }
    
        public Ork createBasicOrk(String name) { 
        String resultName = name == null || name.isEmpty() ? generateName() : name;
        return builderFactory.createOrkBuilder()
                .setName(resultName)
                .setRole("Базовый")
                .buildOrkWithParameters();
    }

    public Ork createLeaderOrk(String name) {
        String resultName = name == null || name.isEmpty() ? generateName() : name;
        Boolean withBanner = true;
        return builderFactory.createOrkBuilder(withBanner)
                .setName(resultName)
                .setRole("Командир")
                .buildOrkWithParameters();
    }

    public Ork createScoutOrk(String name) { 
        String resultName = name == null || name.isEmpty() ? generateName() : name;
        return builderFactory.createOrkBuilder()
                .setName(resultName)
                .setRole("Разведчик")
                .setWeapon("Лук")
                .buildOrkWithParameters();
    }
    
}
