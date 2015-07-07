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
 * Error 400 errors.
 */
public class Error400 {

	public static final String[][] VALS = {
		{	//0
			"badRequest", "The API request is invalid or improperly formed."
		},
		{	// 1
			"badContent",
			"The content type of the request data or the content type of a" +
				" part of a multipart request is not supported."
		},
		{	// 2
			"corsRequestOrigin", "The CORS request is from an unknown origin."
		},
		{	// 3
			"invalidQuery",
			"The request is invalid. Check the API documentation to determine" +
				" what parameters are supported for the request and to see if" +
				" the request contains an invalid combination of parameters" +
				" or an invalid parameter value."
		},
		{	// 4
			"invalidDocumentValue",
			"The request failed because it contained an invalid parameter or" +
				" parameter value for the document. Review the API" +
				" documentation to determine which parameters are valid for" +
				" your request."
		},
		{	// 5
			"keyExpired",
			"The API key provided in the request expired, which means the API" +
				"server is unable to make the request."
		},
		{	// 6
			"keyInvalid",
			"The API key provided in the request is invalid, which means the" +
				" API server is unable to make the request."
		},
		{	// 7
			"parseError", "The API server cannot parse the request body."
		},
		{	// 8
			"required",
			"The API request is missing required information. The required" +
				" information could be a parameter or resource property."
		}
	};

	Error400(String message) {
		if (message == null) {
			message = "Bad Request";
		}

		this.errorData = new ErrorData(400, message);
	}

	public void end(Response response) {
		errorData.end(response);
	}

	public Error400 badRequest() {
		return error(0);
	}

	public Error400 badContent() {
		return error(1);
	}

	public Error400 corsRequestOrigin() {
		return error(2);
	}

	public Error400 invalidQuery() {
		return error(3);
	}

	public Error400 invalidDocumentValue() {
		return error(4);
	}

	public Error400 keyExpired() {
		return error(5);
	}

	public Error400 keyInvalid() {
		return error(6);
	}

	public Error400 parseError() {
		return error(7);
	}

	public Error400 required() {
		return error(8);
	}

	public Error400 error(String reason, String message) {
		errorData.add(reason, message);
		return this;
	}

	private Error400 error(int index) {
		errorData.add(VALS[index]);
		return this;
	}

	private final ErrorData errorData;
}