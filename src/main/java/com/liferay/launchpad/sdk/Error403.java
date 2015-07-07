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

public class Error403<T> {

	public static final String[][] VALS = {
		{	//0
			"forbidden",
			"The requested operation is forbidden and cannot be completed."
		},
		{	//1
			"limitExceeded",
			"The request cannot be completed due to access or rate limitations."
		},
		{	// 2
			"quotaExceeded",
			"The requested operation requires more resources than the quota" +
				" allows."
		},
		{	// 3
			"rateLimitExceeded",
			"Too many requests have been sent within a given time span."
		},
		{	// 4
			"responseTooLarge", "The requested resource is too large to return."
		},
		{	// 5
			"unknownAuth",
			"The API server does not recognize the authorization scheme used" +
				" for the request."
		}
	};

	Error403(ErrorData<T> errorData, String message) {
		this.errorData = errorData;
		this.errorData.set(403, message, "Forbidden");
	}

	public void end(T response) {
		errorData.end(response);
	}

	public Error403<T> forbidden() {
		return error(0);
	}

	public Error403<T> limitExceeded() {
		return error(1);
	}

	public Error403<T> quotaExceeded() {
		return error(2);
	}

	public Error403<T> rateLimitExceeded() {
		return error(3);
	}

	public Error403<T> responseTooLarge() {
		return error(4);
	}

	public Error403<T> unknownAuth() {
		return error(5);
	}

	public Error403<T> error(String reason, String message) {
		errorData.add(reason, message);
		return this;
	}

	private Error403<T> error(int index) {
		errorData.add(VALS[index]);
		return this;
	}

	private final ErrorData<T> errorData;
}