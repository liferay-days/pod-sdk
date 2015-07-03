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
class Error404 {

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

	Error404(Error.ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public Error.ErrorResponse notFound() {
		return error(0);
	}

	public Error.ErrorResponse unsupportedProtocol() {
		return error(1);
	}

	private Error.ErrorResponse error(int index) {
		errorResponse.reason = VALS[index][0];
		errorResponse.message = VALS[index][1];
		return errorResponse;
	}

	private final Error.ErrorResponse errorResponse;
}