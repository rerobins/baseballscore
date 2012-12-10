package org.meerkatlabs.baseballscore.models;

import junit.framework.TestCase;
import org.meerkatlabs.baseballscore.models.enums.Base;

/**
 * Test case for the field object.
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class FieldTestCase extends TestCase {

    public void testAdvanceAllBases() {
        Field gameField = new Field();

        Player lousyPitcher = new Player(1, "Lousy");
        Player thirdBaseRunner = new Player(3, "Third");
        Player secondBaseRunner = new Player(2, "Second");
        Player firstBaseRunner = new Player(1, "First");
        Player batter = new Player(0, "Batter");

        AtBat thirdBase = new AtBat(lousyPitcher, thirdBaseRunner);
        AtBat secondBase = new AtBat(lousyPitcher, secondBaseRunner);
        AtBat firstBase = new AtBat(lousyPitcher, firstBaseRunner);
        AtBat newRunner = new AtBat(lousyPitcher, batter);

        gameField.baseRunners[Base.THIRD_BASE.ordinal()] = thirdBase;
        gameField.baseRunners[Base.SECOND_BASE.ordinal()] = secondBase;
        gameField.baseRunners[Base.FIRST_BASE.ordinal()] = firstBase;

        gameField.advanceRunners(Base.FIRST_BASE, newRunner);

        assertSame("Check third runner on home",
                thirdBase, gameField.baseRunners[Base.HOME_PLATE.ordinal()]);
        assertSame("Check second runner on third",
                secondBase, gameField.baseRunners[Base.THIRD_BASE.ordinal()]);
        assertSame("Check first runner on second",
                firstBase, gameField.baseRunners[Base.SECOND_BASE.ordinal()]);
        assertSame("Check new runner on first",
                newRunner, gameField.baseRunners[Base.FIRST_BASE.ordinal()]);



    }

}
