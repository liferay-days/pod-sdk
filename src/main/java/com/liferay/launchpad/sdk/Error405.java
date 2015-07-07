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
 * Error 405 errors
 */
public class Error405 {

	public static final String[][] VALS = {
		{	//0
			"httpMethodNotAllowed",
			"The HTTP method associated with the request is not supported."
		}
	};

	Error405(String message) {
		if (message == null) {
			message = "Method Not Allowed";
		}

		this.errorData = new ErrorData(405, message);
	}

	/**
	 * Shortcut for {@link #httpMethodNotAllowed()}.
	 */
	public void end(Response response) {
		errorData.end(response);
	}

	public Error405 httpMethodNotAllowed() {
		return error(0);
	}

	public Error405 error(String reason, String message) {
		errorData.add(reason, message);
		return this;
	}

	private Error405 error(int index) {
		errorData.add(VALS[index]);
		return this;
	}

	private final ErrorData errorData;

}