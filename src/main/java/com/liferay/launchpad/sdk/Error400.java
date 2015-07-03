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
class Error400 {

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
		{	// 5
			"keyInvalid",
			"The API key provided in the request is invalid, which means the" +
				" API server is unable to make the request."
		},
		{	// 6
			"parseError", "The API server cannot parse the request body."
		},
		{	// 7
			"required",
			"The API request is missing required information. The required" +
				" information could be a parameter or resource property."
		}
	};

	public Error400(Error.ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	/**
	 * Shortcut for {@link #badRequest()}.
	 */
	public void end(Response response) {
		badRequest().end(response);
	}

	public Error.ErrorResponse badRequest() {
		return error(0);
	}

	public Error.ErrorResponse badContent() {
		return error(1);
	}

	public Error.ErrorResponse corsRequestOrigin() {
		return error(2);
	}

	public Error.ErrorResponse invalidDocumentValue() {
		return error(3);
	}

	public Error.ErrorResponse keyExpired() {
		return error(4);
	}

	public Error.ErrorResponse keyInvalid() {
		return error(5);
	}

	public Error.ErrorResponse parseError() {
		return error(6);
	}

	public Error.ErrorResponse required() {
		return error(7);
	}

	private Error.ErrorResponse error(int index) {
		errorResponse.reason = VALS[index][0];
		errorResponse.message = VALS[index][1];
		return errorResponse;
	}

	private final Error.ErrorResponse errorResponse;
}