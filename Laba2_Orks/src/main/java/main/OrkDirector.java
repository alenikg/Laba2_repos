
package main;

import com.github.javafaker.Faker;
import factories.OrkBuilderFactory;
import java.util.Locale;

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
    
}
