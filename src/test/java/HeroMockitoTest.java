import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroMockitoTest {

    @Test
    public void attackGainsExperienceIfTargetIsDead(){
        Weapon mockWeapon = Mockito.mock(Weapon.class);
        Target mockTarget = Mockito.mock(Target.class);

        Mockito.when(mockTarget.isDead()).thenReturn(true);
        Mockito.when(mockTarget.giveExperience()).thenReturn(constants.TARGET_EXPERIENCE);

        Hero hero = new Hero(constants.HERO_NAME,mockWeapon);
        hero.attack(mockTarget);
        Assert.assertEquals("Wrong experience", constants.TARGET_EXPERIENCE,
                hero.getExperience());
    }
}
