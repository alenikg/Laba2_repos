 
package builderForOrk;

import model.Ork;


/**
 *
 * @author elenagoncarova
 */
public class OrkBuilder {
    private String name;
    private String weapon;
    private String armor;
    private String banner;

    private int strength;
    private int agility;
    private int intelligence;
    private int health;
    
    private String role;
    private String tribe; 
    
    public OrkBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public OrkBuilder setWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }

    public OrkBuilder setArmor(String armor) {
        this.armor = armor;
        return this;
    }

    public OrkBuilder setBanner(String banner) {
        this.banner = banner;
        return this;
    }
    
    public OrkBuilder setAttributes(int strength, int agility, int intelligence, int health) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = health;
        return this;
    }
    
    public OrkBuilder setRole(String role) {
        this.role = role;
        return this;
    }

    public OrkBuilder setTribe(String tribe) {
        this.tribe = tribe;
        return this;
    }

    public Ork buildOrkWithParameters() {
        return new Ork(name, weapon, armor, banner, strength, agility, intelligence, health, role, tribe);
    }
}
