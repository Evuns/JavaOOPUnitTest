import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {


    private static final int AXE_ATTACK_POINT = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void BuildObjectsNeeded() {
        this.axe = new Axe(AXE_ATTACK_POINT, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
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
    public void deadDummyCanShowXP(){
        axe.attack(dummy);
        Assert.assertEquals(10,dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantShowXP(){
        dummy.giveExperience();
    }
}
