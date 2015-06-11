/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.liferay.launchpad.sdk;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Multi-map for headers.
 */
public interface PodMultiMap extends Iterable<Map.Entry<String, String>> {

	/**
	 * Returns the value of with the specified name.  If there are
	 * more than one values for the specified name, the first value is returned.
	 * Returns {@code null} if header value does not exist.
	 *
	 */
	String get(String name);

	/**
	 * Returns the values with the specified name.
	 *
	 * @param name The name to search
	 * @return A immutable {@link java.util.List} of values which will be empty
	 * if no values are found
	 */
	List<String> getAll(String name);

	/**
	 * Returns all entries in the multi-map.
	 *
	 * @return A immutable {@link java.util.List} of the name-value entries, which will be
	 * empty if no pairs are found
	 */
	List<Map.Entry<String, String>> entries();

	/**
	 * Checks to see if there is a value with the specified name.
	 *
	 * @param name The name to search for
	 * @return true if at least one entry is found
	 */
	boolean contains(String name);

	/**
	 * Return true if empty.
	 */
	boolean isEmpty();

	/**
	 * Gets a immutable {@link java.util.Set} of all names
	 *
	 * @return A {@link java.util.Set} of all names
	 */
	Set<String> names();

	/**
	 * Adds a new value with the specified name and value.
	 *
	 * @param name The name
	 * @param value The value being added
	 * @return a reference to this, so the API can be used fluently
	 */
	PodMultiMap add(String name, String value);

	/**
	 * Adds a new values under the specified name.
	 *
	 * @param name The name being set
	 * @param values The values
	 * @return a reference to this, so the API can be used fluently
	 */
	PodMultiMap add(String name, Iterable<String> values);

	/**
	 * Sets a value under the specified name.
	 * <p>
	 * If there is an existing header with the same name, it is removed.
	 *
	 * @param name The name
	 * @param value The value
	 * @return a reference to this, so the API can be used fluently
	 */
	PodMultiMap set(String name, String value);

	/**
	 * Sets values for the specified name.
	 *
	 * @param name The name of the headers being set
	 * @param values The values of the headers being set
	 * @return a reference to this, so the API can be used fluently
	 */
	PodMultiMap set(String name, Iterable<String> values);

	/**
	 * Removes the value with the given name
	 *
	 * @param name The name  of the value to remove
	 * @return a reference to this, so the API can be used fluently
	 */
	PodMultiMap remove(String name);

	/**
	 * Removes all
	 *
	 * @return a reference to this, so the API can be used fluently
	 */
	PodMultiMap clear();

	/**
	 * Return the number of keys.
	 */
	int size();

}