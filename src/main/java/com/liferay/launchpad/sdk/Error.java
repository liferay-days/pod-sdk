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
 * Main class for building errors.
 */
public class Error {

	/**
	 * Creates error 400 response.
	 */
	public static Error400 badRequest() {
		return new Error400(new ErrorResponse(400));
	}

	/**
	 * Creates error 403 response.
	 */
	public static Error403 forbidden() {
		return new Error403(new ErrorResponse(403));
	}

	/**
	 * Creates error 404 response.
	 */
	public static Error404 notFound() {
		return new Error404(new ErrorResponse(404));
	}

	/**
	 * Creates error 405 response.
	 */
	public static Error405 methodNotAllowed() {
		return new Error405(new ErrorResponse(405));
	}

	static class ErrorResponse {
		public ErrorResponse(int statusCode) {
			this.statusCode = statusCode;
		}

		private final int statusCode;
		String reason;
		String message;

		/**
		 * Ends the error response.
		 */
		public void end(Response response) {
			response.status(statusCode, null);

			StringBuilder errorBody = new StringBuilder();

			errorBody.append("{\n\tcode: ").append(statusCode).append(",\n");
			errorBody.append("{\n\terror: {\n");
			errorBody.append("\t\treason: \"");
			errorBody.append(encodeString(reason));
			errorBody.append("\",");
			errorBody.append("\t\tmessage: \"");
			errorBody.append(encodeString(message));
			errorBody.append("\"");
			errorBody.append("\t}\n");
			errorBody.append("}");

			response.body(errorBody.toString());
		}

		/**
		 * Encode input to JSON-safe string.
		 */
		private String encodeString(String input) {
			return input;
		}
	}

}