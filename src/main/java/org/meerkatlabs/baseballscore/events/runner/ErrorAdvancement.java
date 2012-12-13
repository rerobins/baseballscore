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

package org.meerkatlabs.baseballscore.events.runner;

import org.meerkatlabs.baseballscore.interfaces.IRunnerEvent;
import org.meerkatlabs.baseballscore.models.PlayerError;

/**
 * Created with IntelliJ IDEA.
 * User: rerobins
 * Date: 12/12/12
 * Time: 5:35 PM
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class ErrorAdvancement implements IRunnerEvent {

    PlayerError error;

    public ErrorAdvancement(final PlayerError error) {
        this.error = error;
    }

    public PlayerError getError() {
        return error;
    }
}
