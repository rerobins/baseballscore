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

import org.meerkatlabs.baseballscore.models.enums.AtBatResult;
import org.meerkatlabs.baseballscore.models.interfaces.IInPlayDescription;

/**
 * In play description that wraps the end of an at bat.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class AtBatResultInPlayWrapper implements IInPlayDescription {

    /**
     * The result that is being wrapped.
     */
    final AtBatResult result;

    /**
     * Constructor.
     *
     * @param result result to be wrapped.
     */
    public AtBatResultInPlayWrapper(final AtBatResult result) {
        if (result == null) {
            throw new IllegalArgumentException("Cannot pass in a null result.");
        }
        this.result = result;
    }

    @Override
    public boolean isOut() {
        return result.isOut();
    }

    @Override
    public boolean advanceLineup() {
        return result.advanceLineup();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtBatResultInPlayWrapper that = (AtBatResultInPlayWrapper) o;

        if (result != that.result) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return result.hashCode();
    }

    @Override
    public String toString() {
        return "Wrapped: [" + result + "]";
    }
}
