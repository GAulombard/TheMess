package com.hodor.pattern.builder;

public class Heroe {

    private String name;
    private int age;
    private String gender;
    private String weapon;
    private String armor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public static class Builder {
        private String name;
        private int age;
        private String gender;
        private String weapon;
        private String armor;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder armor(String armor) {
            this.armor = armor;
            return this;
        }

        public Builder weapon(String weapon) {
            this.weapon = weapon;
            return this;
        }

        public Heroe build() {
            Heroe heroe = new Heroe();
            heroe.name = this.name;
            heroe.age = this.age;
            heroe.gender = this.gender;
            heroe.armor = this.armor;
            heroe.weapon = this.weapon;
            return heroe;
        }

    }

    @Override
    public String toString() {
        return "Heroe [name=" + name + ", age=" + age + ", gender=" + gender+", armor=" + armor +", weapon= "+weapon+ "]";
    }
}
