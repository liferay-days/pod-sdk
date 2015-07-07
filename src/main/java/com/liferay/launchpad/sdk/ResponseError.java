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

/**
 * Main class for building response errors.
 */
public class ResponseError {

	/**
	 * Creates error 400 response.
	 */
	public static Error400 badRequest() {
		return new Error400(null);
	}

	/**
	 * Creates error 400 response.
	 */
	public static Error400 badRequest(String message) {
		return new Error400(message);
	}

	/**
	 * Creates error 403 response.
	 */
	public static Error403 forbidden() {
		return new Error403(null);
	}

	/**
	 * Creates error 403 response.
	 */
	public static Error403 forbidden(String message) {
		return new Error403(message);
	}

	/**
	 * Creates error 500 response.
	 */
	public static Error500 internalError() {
		return new Error500(null);
	}

	/**
	 * Creates error 500 response.
	 */
	public static Error500 internalError(String message) {
		return new Error500(message);
	}

	/**
	 * Creates error 405 response.
	 */
	public static Error405 methodNotAllowed() {
		return new Error405(null);
	}

	/**
	 * Creates error 405 response.
	 */
	public static Error405 methodNotAllowed(String message) {
		return new Error405(message);
	}

	/**
	 * Creates error 404 response.
	 */
	public static Error404 notFound() {
		return new Error404(null);
	}

	/**
	 * Creates error 404 response.
	 */
	public static Error404 notFound(String message) {
		return new Error404(message);
	}

}