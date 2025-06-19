/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
}
