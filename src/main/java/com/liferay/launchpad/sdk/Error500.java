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
 * Error 500 errors
 */
class Error500 {

	public static final String[][] VALS = {
		{	//0
			"internalError", "The request failed due to an internal error."
		}
	};

	Error500(Error.ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public Error.ErrorResponse internalError() {
		return error(0);
	}

	private Error.ErrorResponse error(int index) {
		errorResponse.reason = VALS[index][0];
		errorResponse.message = VALS[index][1];
		return errorResponse;
	}

	private final Error.ErrorResponse errorResponse;

}