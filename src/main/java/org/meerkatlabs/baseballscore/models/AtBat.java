/*
 * This file is part of BaseballScore.
 *
 * BaseballScore is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BaseballScore is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with BaseballScore.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.meerkatlabs.baseballscore.models;

import org.meerkatlabs.baseballscore.interfaces.IBatterResult;
import org.meerkatlabs.baseballscore.models.enums.AtBatResult;
import org.meerkatlabs.baseballscore.models.enums.InPlay;
import org.meerkatlabs.baseballscore.models.interfaces.IInPlayDescription;
import org.meerkatlabs.baseballscore.results.None;
import org.meerkatlabs.baseballscore.results.batter.StrikeOut;
import org.meerkatlabs.baseballscore.results.batter.Walk;

/**
 * An at bat represents a attempt by the batter to place the ball into play.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class AtBat {

    /**
     * Pitcher.
     */
    Player pitcher;

    /**
     * Batter.
     */
    final Player batter;

    /**
     * How did it go down...
     */
    AtBatResult result;

    /**
     * Current Strike count.
     */
    int strikes;

    /**
     * Current balls.
     */
    int balls;

    /**
     * Current fouls.
     */
    int fouls;

    /**
     * How did the at bat get the ball into play.  Can be null.
     */
    IInPlayDescription inPlay;

    /**
     * Constructor.
     *
     * @param pitcher the pitcher for this at bat.
     * @param batter  the batter for this at bat.
     */
    public AtBat(final Player pitcher, final Player batter) {
        this.pitcher = pitcher;
        this.batter = batter;
    }

    /**
     * Return the pitcher for this at bat
     *
     * @return pitcher.
     */
    public Player getPitcher() {
        return pitcher;
    }

    /**
     * Return the batter for this at bat.
     *
     * @return the player that is batting.
     */
    public Player getBatter() {
        return batter;
    }

    /**
     * Result accessor.
     *
     * @return result.
     */
    public AtBatResult getResult() {
        return result;
    }

    /**
     * Strikes accessor.
     *
     * @return strike count.
     */
    public int getStrikes() {
        return strikes;
    }

    /**
     * Balls accessor.
     *
     * @return balls.
     */
    public int getBalls() {
        return balls;
    }

    /**
     * Fouls accessor.
     *
     * @return foul count.
     */
    public int getFouls() {
        return fouls;
    }

    /**
     * Result mutator.
     *
     * @param result result of this at bat.
     */
    public void setResult(final AtBatResult result) {
        this.result = result;
    }

    /**
     * InPlay accessor.
     *
     * @return in play description.
     */
    public IInPlayDescription getInPlay() {
        return inPlay;
    }

    /**
     * InPlay mutator.
     *
     * @param inPlay value.
     */
    public void setInPlay(final IInPlayDescription inPlay) {
        this.inPlay = inPlay;
    }

    /**
     * Throw a strike and return the result.
     *
     * @return the result from throwing a strike.
     */
    public IBatterResult throwStrike() {
        strikes++;
        if (strikes == 3) {
            return new StrikeOut(pitcher);
        }

        return new None();
    }

    /**
     * Throw a ball and return the result.
     *
     * @return the result from throwing a ball.
     */
    public IBatterResult throwBall() {
        balls++;
        if (balls == 4) {
            return new Walk(pitcher);
        }

        return new None();
    }

    /**
     * Throw a pitch that was hit, but ended up foul.
     *
     * @return the result of throwing the foul hit ball.
     */
    public IBatterResult hitFoul() {
        fouls++;

        if (strikes < 2) {
            strikes++;
        }

        return new None();
    }
}
