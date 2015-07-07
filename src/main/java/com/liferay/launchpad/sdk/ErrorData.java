package com.liferay.launchpad.sdk;

import java.util.LinkedList;
class ErrorData {

	ErrorData(int statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	private final int statusCode;
	private final String statusMessage;
	private final LinkedList<String[]> subErrors = new LinkedList<>();

	/**
	 * Adds error reason and a message.
	 */
	public void add(String reason, String message) {
		subErrors.add(new String[] {reason, message});
	}

	/**
	 * Adds error reason and a message.
	 */
	public void add(String... subError) {
		if (subError.length != 2) {
			throw new IllegalArgumentException();
		}

		subErrors.add(subError);
	}

	/**
	 * Ends the error response.
	 */
	public void end(Response response) {
		response.status(statusCode, statusMessage);

		String errorBody = errorBody();

		response
			.contentType(ContentType.JSON)
			.body(errorBody);
	}

	/**
	 * Creates body string.
	 */
	private String errorBody() {
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
}