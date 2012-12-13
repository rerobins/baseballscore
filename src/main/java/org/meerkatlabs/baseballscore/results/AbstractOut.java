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

package org.meerkatlabs.baseballscore.results;

import org.meerkatlabs.baseballscore.interfaces.IOut;

/**
 * Created with IntelliJ IDEA.
 * User: rerobins
 * Date: 12/12/12
 * Time: 5:01 PM
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public abstract class AbstractOut implements IOut {

    /**
     * The out number.
     */
    int outNumber;

    @Override
    public int getOutNumber() {
        return outNumber;
    }

    @Override
    public void setOutNumber(final int outNumber) {

        assert (outNumber < 4);
        assert (outNumber > 0);

        this.outNumber = outNumber;
    }
}
