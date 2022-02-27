/*
 * Copyright (C) 2016 Fraunhofer Institut IOSB, Fraunhoferstr. 1, D 76131
 * Karlsruhe, Germany.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.fraunhofer.iosb.ilt.frostserver.query.expression.constant;

import de.fraunhofer.iosb.ilt.frostserver.util.TestHelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jab
 */
public class PointConstantTest {

    @Test
    public void testparseFromStringSpaces() {
        String text = "POINT                     (      30                                              10    )";
        PointConstant result = new PointConstant(text);
        assertEquals(TestHelper.getPoint(30, 10), result.getValue());
    }

    @Test
    public void testparseFromString2D() {
        String text = "POINT (30 10)";
        PointConstant result = new PointConstant(text);
        assertEquals(TestHelper.getPoint(30, 10), result.getValue());
    }

    @Test
    public void testparseFromString3D() {
        String text = "POINT (30 10 10)";
        PointConstant result = new PointConstant(text);
        assertEquals(TestHelper.getPoint(30, 10, 10), result.getValue());
    }

    @Test
    public void testparseFromStringWithWrongDimension1D() {
        assertThrows(IllegalArgumentException.class, () -> {
            String text = "POINT (10)";
            PointConstant pointConstant = new PointConstant(text);
        });
    }

    @Test
    public void testparseFromStringWithWrongDimension4D() {
        assertThrows(IllegalArgumentException.class, () -> {
            String text = "POINT (10 10 10 10)";
            PointConstant pointConstant = new PointConstant(text);
        });
    }

}
