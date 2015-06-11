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

import java.util.Map;

/**
 * HTTP response.
 */
public interface Response {

	/**
	 * Returns the context that this response belongs to.
	 */
	PodContext context();

	/**
	 * Returns body content.
	 */
	String body();

	/**
	 * Returns status code.
	 */
	int statusCode();

	/**
	 * Returns headers.
	 */
	Map<String, String> headers();

	/**
	 * Returns the first header value with the specified name
	 */
	String header(String headerName);

	/**
	 * Sets the first header name with the specified value
	 */
	Response header(String headerName, String headerValue);

	/**
	 * Sets the content type header.
	 */
	default Response header(ContentType contentType) {
		header("Content-Type", contentType.contentType());
		return this;
	}

	/**
	 * Returns <code>true</code> if response is already committed.
	 */
	boolean isCommitted();

	/**
	 * Returns status message.
	 */
	String statusMessage();

	/**
	 * Sets the body content. Body content can be set only once. Setting the
	 * body {@link #end() closes} the response.
	 */
	void body(String body);

	/**
	 * Sets the body content and common {@link ContentType content-type}.
	 * Just a shortcut call.
	 */
	default void body(String body, ContentType contentType) {
		header(contentType);
		body(body);
	}

	/**
	 * Closes the response. Shortcut for {@code body(null)}.
	 */
	default void end() {
		body(null);
	}

	/**
	 * Sets the response status code and message.
	 */
	Response status(int statusCode, String statusMessage);

}