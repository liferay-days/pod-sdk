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
public interface Response<T extends Response> {

	/**
	 * Returns body content.
	 */
	public String body();

	/**
	 * Sets the body content. Body content can be set only once. Setting the
	 * body {@link #end() closes} the response.
	 */
	public void body(String body);

	/**
	 * Sets the body content and common {@link ContentType content-type}.
	 * Just a shortcut call.
	 */
	public default void body(String body, ContentType contentType) {
		header(contentType);
		body(body);
	}

	/**
	 * Returns the context that this response belongs to.
	 */
	public PodContext context();

	/**
	 * Closes the response. Shortcut for {@code body(null)}.
	 */
	public default void end() {
		body(null);
	}

	/**
	 * Sets the content type header.
	 */
	public default Response header(ContentType contentType) {
		header("Content-Type", contentType.contentType());
		return this;
	}

	/**
	 * Returns the first header value with the specified name
	 */
	public String header(String headerName);

	/**
	 * Sets the first header name with the specified value
	 */
	public Response header(String headerName, String headerValue);

	/**
	 * Returns headers.
	 */
	public Map<String, String> headers();

	/**
	 * Returns <code>true</code> if response is already committed.
	 */
	public boolean isCommitted();

	/**
	 * Sets the response status code and message.
	 */
	public Response status(int statusCode, String statusMessage);

	/**
	 * Returns status code.
	 */
	public int statusCode();

	/**
	 * Sets the status code.
	 */
	public T statusCode(int statusCode);

	/**
	 * Returns status message.
	 */
	public String statusMessage();

	/**
	 * Sets the status message.
	 */
	public T statusMessage(String statusMessage);

}