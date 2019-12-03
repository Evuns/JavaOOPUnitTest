import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTests {

    private static final int AXE_ATTACK_POINT = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void buildNeededObjects(){
        this.axe = new Axe(AXE_ATTACK_POINT,AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
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
