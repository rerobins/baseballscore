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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meerkatlabs.baseballscore.models;

import java.util.Comparator;

/**
 *
 * @author Robert Robinson
 */
public class Player implements Comparable<Player> {
    
    public enum Bats {
        UNKNOWN,
        RIGHT,
        LEFT,
        SWITCH;
    }
    
    public enum Throws {
        UNKNOWN,
        RIGHT,
        LEFT;
    }
    
    String name;

    IPosition preferredPosition;
    
    int uniformNumber;
    
    Bats battingHand = Bats.RIGHT;
    
    Throws throwingHand = Throws.RIGHT;

    public Player(int uniformNumber, String name) {
        this(uniformNumber, name, null);
    }

    public Player(int uniformNumber, String name, IPosition preferredPosition) {
        this.uniformNumber = uniformNumber;
        this.name = name;
        this.preferredPosition = preferredPosition;
    }

    public IPosition getPreferredPosition() {
        return preferredPosition;
    }

    public void setPreferredPosition(IPosition preferredPosition) {
        this.preferredPosition = preferredPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bats getBattingHand() {
        return battingHand;
    }

    public void setBattingHand(Bats battingHand) {
        this.battingHand = battingHand;
    }

    public Throws getThrowingHand() {
        return throwingHand;
    }

    public void setThrowingHand(Throws throwingHand) {
        this.throwingHand = throwingHand;
    }

    public int getUniformNumber() {
        return uniformNumber;
    }

    public void setUniformNumber(int uniformNumber) {
        this.uniformNumber = uniformNumber;
    }

    @Override
    public int compareTo(Player o) {
        return uniformNumber - o.getUniformNumber();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.uniformNumber != other.uniformNumber) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.uniformNumber;
        return hash;
    }
    
    public static class NameComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
        
    }
    
}
