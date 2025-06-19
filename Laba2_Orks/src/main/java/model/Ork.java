
package model;

/**
 *
 * @author elenagoncarova
 */
public class Ork {
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
    
    public Ork(String name, String weapon, String armor, String banner,
            int strength, int agility, int intelligence, int health, String role, String tribe) {
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = health;
        this.role = role;
        this.tribe = tribe;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getArmor() {
        return armor;
    }

    public String getBanner() {
        return banner;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public String getRole() {
        return role;
    }

    public String getTribe() {
        return tribe;
    }

    @Override
    public String toString() {
        return name;
    }
}
