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

import java.util.List;

/**
 * SocketIO emitter.
 */
public interface SocketEventEmitter {

	/**
	 * Listen on the given `event` with listener `fn`.
	 */
	SocketEventEmitter on(String event, SocketListener fn);

	default SocketEventEmitter addEventListener(
		String event, SocketListener fn) {

		return this.on(event, fn);
	}

	/**
	 * Adds an `event` listener that will be invoked a single
	 * time then automatically removed.
	 */
	SocketEventEmitter once(String event, SocketListener fn);

	/**
	 * Remove all registered listeners.
	 */
	SocketEventEmitter off();

	/**
	 * Aliases of off().
	 */
	default SocketEventEmitter removeListener() {
		return this.off();
	}

	default SocketEventEmitter removeAllListeners() {
		return this.off();
	}

	default SocketEventEmitter removeEventListener() {
		return this.off();
	}

	/**
	 * Remove the given callback for `event`.
	 */
	SocketEventEmitter off(String event);

	/**
	 * Aliases of off(event).
	 */
	default SocketEventEmitter removeListener(String event) {
		return this.off(event);
	}

	default SocketEventEmitter removeAllListeners(String event) {
		return this.off(event);
	}

	default SocketEventEmitter removeEventListener(String event) {
		return this.off(event);
	}

	/**
	 * Remove the given callback for `event`.
	 */
	SocketEventEmitter off(String event, SocketListener fn);

	/**
	 * Aliases of off(event, fn).
	 */
	default SocketEventEmitter removeListener(
		String event, SocketListener fn) {

		return this.off(event, fn);
	}

	default SocketEventEmitter removeAllListeners(
		String event, SocketListener fn) {

		return this.off(event, fn);
	}

	default SocketEventEmitter removeEventListener(
		String event, SocketListener fn) {

		return this.off(event, fn);
	}

	/**
	 * Emits `event` with the given args.
	 */
	SocketEventEmitter emit(String event, Object... args);

	/**
	 * Returns an array of listeners for `event`.
	 */
	List<SocketListener> listeners(String event);

	/**
	 * Checks if this emitter has `event` handlers.
	 */
	boolean hasListeners(String event);

}