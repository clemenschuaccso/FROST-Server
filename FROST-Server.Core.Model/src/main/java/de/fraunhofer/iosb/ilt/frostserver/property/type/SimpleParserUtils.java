/*
 * Copyright (C) 2021 Fraunhofer Institut IOSB, Fraunhoferstr. 1, D 76131
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
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package de.fraunhofer.iosb.ilt.frostserver.property.type;

import java.util.UUID;

/**
 *
 * @author hylke
 */
public class SimpleParserUtils {

    private SimpleParserUtils() {
        // Not for public instantiation.
    }

    public static final TypeSimple.Parser PARSER_LONG = Long::parseLong;
    public static final TypeSimple.Parser PARSER_UUID = input -> {
        if (input.startsWith("'")) {
            return UUID.fromString(input.substring(1, input.length() - 1));
        }
        return UUID.fromString(input);
    };
    public static final TypeSimple.Parser PARSER_STRING = input -> {
        if (input.startsWith("'")) {
            String idString = input.substring(1, input.length() - 1);
            return idString.replace("''", "'");
        }
        return input;
    };
}
