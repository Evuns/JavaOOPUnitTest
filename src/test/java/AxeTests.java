import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTests {

    private Axe axe;
    private Dummy dummy;

    @Before
    public void buildNeededObjects(){
        this.axe = new Axe(constants.WEAPON_ATTACK_POINT, constants.WEAPON_DURABILITY);
        this.dummy = new Dummy(constants.TARGET_HEALTH, constants.TARGET_EXPERIENCE);
    }

    @Test
    public void whenWeaponAttackLosesDurability(){
        axe.attack(dummy);
        Assert.assertEquals(0,axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack(){
        axe.attack(dummy);
        axe.attack(dummy);
    }

}
