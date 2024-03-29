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

package com.liferay.launchpad.sdk.io;

/**
 * SocketIO socket.
 */
public interface Socket extends SocketEventEmitter {

	/**
	 * Sets broadcast flag to true.
	 */
	public Socket broadcast();

	/**
	 * Returns the value stored with the specified key.
	 */
	public Object get(String key);

	/**
	 * Stores the value with the specified key.
	 */
	public void set(String key, Object value);

}