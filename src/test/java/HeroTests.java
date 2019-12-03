import org.junit.Assert;
import org.junit.Test;

public class HeroTests {

    @Test
    public void attackGainsExperienceIfTargetIsDead(){
        Target fakeTarget = new Target() {
            @Override
            public void takeAttack(int attackPoints) {
            }

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public int giveExperience() {
                return constants.TARGET_EXPERIENCE;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return constants.WEAPON_ATTACK_POINT;
            }

            @Override
            public int getDurabilityPoints() {
                return constants.WEAPON_DURABILITY;
            }
        };

        Hero hero = new Hero(constants.HERO_NAME,fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals("Wrong experience",constants.TARGET_EXPERIENCE, hero.getExperience());

    }
}
