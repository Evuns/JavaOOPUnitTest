import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {


    private Axe axe;
    private Dummy dummy;

    @Before
    public void BuildObjectsNeeded() {
        this.axe = new Axe(constants.WEAPON_ATTACK_POINT, constants.WEAPON_DURABILITY);
        this.dummy = new Dummy(constants.TARGET_HEALTH, constants.TARGET_EXPERIENCE);
    }

    @Test
    public void checkIfDummyLosesHealthWhenAttacked() {
        axe.attack(dummy);
        Assert.assertEquals(0, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void throwExceptionIfTheAttackedDummyIsDead() {
        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void deadDummyCanShowXP() {
        axe.attack(dummy);
        Assert.assertEquals(10, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantShowXP() {
        dummy.giveExperience();
    }
}
