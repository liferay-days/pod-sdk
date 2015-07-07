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

import java.util.LinkedList;
abstract class ErrorData<T> {

	/**
	 * Creates body string.
	 */
	public String errorBody() {
		StringBuilder errorBody = new StringBuilder();

		errorBody.append("{\n\t\"code\": ");
		errorBody.append(statusCode);
		errorBody.append(",\n");
		errorBody.append("\t\"message\": \"");
		errorBody.append(encodeString(statusMessage));
		errorBody.append("\"");

		if (!subErrors.isEmpty()) {
			errorBody.append(",\n");
			errorBody.append("\t\"errors\": [\n");

			for (int i = 0; i < subErrors.size(); i++) {
				String[] subError = subErrors.get(i);

				if (i != 0) {
					errorBody.append(",\n");
				}

				errorBody.append("\t\t{\n");
				errorBody.append("\t\t\t\"reason\": \"");
				errorBody.append(encodeString(subError[0]));
				errorBody.append("\",\n");
				errorBody.append("\t\t\t\"message\": \"");
				errorBody.append(encodeString(subError[1]));
				errorBody.append("\"\n");
				errorBody.append("\t\t}");
			}

			errorBody.append("\n\t]\n");
		}
		else {
			errorBody.append("\n");
		}

		errorBody.append("}");

		return errorBody.toString();
	}

	/**
	 * Returns status code.
	 */
	public int statusCode() {
		return statusCode;
	}

	/**
	 * Returns status message.
	 */
	public String statusMessage() {
		return statusMessage;
	}

	/**
	 * Encodes input to JSON-safe string.
	 */
	private String encodeString(String value) {
		StringBuilder sb = new StringBuilder();

		int len = value.length();

		for (int i = 0; i < len; i++) {
			char c = value.charAt(i);

			switch (c) {
				case '"':
					sb.append("\\\"");
					break;
				case '\\':
					sb.append("\\\\");
					break;
				case '/':
					sb.append("\\/");
					break;
				case '\b':
					sb.append("\\b");
					break;
				case '\f':
					sb.append("\\f");
					break;
				case '\n':
					sb.append("\\n");
					break;
				case '\r':
					sb.append("\\r");
					break;
				case '\t':
					sb.append("\\t");
					break;
				default:
					sb.append(c);
			}
		}

		return sb.toString();
	}

	ErrorData() {}

	/**
	 * Ends the error response.
	 */
	abstract void end(T targetCounsumer);

	/**
	 * Adds error reason and a message.
	 */
	void add(String reason, String message) {
		subErrors.add(new String[] {reason, message});
	}

	/**
	 * Adds error reason and a message.
	 */
	void add(String... subError) {
		if (subError.length != 2) {
			throw new IllegalArgumentException();
		}

		subErrors.add(subError);
	}

	void set(
		int statusCode, String statusMessage, String defaultMessage) {

		this.statusCode = statusCode;

		if (statusMessage == null) {
			statusMessage = defaultMessage;
		}

		this.statusMessage = statusMessage;
	}

	private int statusCode;
	private String statusMessage;
	private final LinkedList<String[]> subErrors = new LinkedList<>();

}