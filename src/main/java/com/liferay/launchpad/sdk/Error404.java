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
 * Error 404 errors.
 */
public class Error404 {

	public static final String[][] VALS = {
		{	//0
			"notFound",
			"The requested operation failed because a resource associated" +
				" with the request could not be found."
		},
		{	// 1
			"unsupportedProtocol",
			"The protocol used in the request is not supported."
		}
	};

	Error404() {
		this.errorResponse = new ResponseError.ErrorResponse(404);
	}

	/**
	 * Shortcut for {@link #notFound()}.
	 */
	public void end(Response response) {
		notFound().end(response);
	}

	public Error404 notFound() {
		return error(0);
	}

	public Error404 unsupportedProtocol() {
		return error(1);
	}

	private Error404 error(int index) {
		errorResponse.add(VALS[index]);
		return this;
	}

	private final ResponseError.ErrorResponse errorResponse;
}