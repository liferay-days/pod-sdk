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
public class Error405<T> {

	public static final String[][] VALS = {
		{	//0
			"httpMethodNotAllowed",
			"The HTTP method associated with the request is not supported."
		}
	};

	public Error405(ErrorData<T> errorData, String message) {
		this.errorData = errorData;
		this.errorData.set(405, message, "Method Not Allowed");
	}

	public void end(T response) {
		errorData.end(response);
	}

	public Error405<T> httpMethodNotAllowed() {
		return error(0);
	}

	public Error405<T> error(String reason, String message) {
		errorData.add(reason, message);
		return this;
	}

	private Error405<T> error(int index) {
		errorData.add(VALS[index]);
		return this;
	}

	private final ErrorData<T> errorData;

}