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

import java.util.Map;

/**
 * Server session.
 */
public interface PodSession {

	/**
	 * Returns the unique ID of the session.
	 */
	String id();

	/**
	 * Put some data in a session.
	 */
	PodSession put(String key, Object value);

	/**
	 * Get some data from the session.
	 */
	<T> T get(String key);

	/**
	 * Removes some data from the session.
	 */
	<T> T remove(String key);

	/**
	 * Returns the session data as {@link java.util.Map}.
	 */
	Map<String, Object> data();

	/**
	 * Returns the time the session was last accessed.
	 */
	long lastAccessed();

	/**
	 * Mark the session to be destroyed.
	 */
	void destroy();

	/**
	 * Return true is the session was marked to be destroyed.
	 */
	boolean isDestroyed();

	/**
	 * Return the amount of time in ms until the session will expire if not accessed.
	 */
	long timeout();

	/**
	 * Mark the session as being accessed.
	 */
	void setAccessed();

}