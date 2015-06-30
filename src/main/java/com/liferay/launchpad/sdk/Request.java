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
 * HTTP request.
 */
public interface Request<T extends Request> {

	/**
	 * Returns the base URL corresponding to the the HTTP request.
	 */
	public String baseUrl();

	/**
	 * Returns the body content.
	 */
	public String body();

	/**
	 * Sets the body content.
	 */
	public T body(String body);

	/**
	 * Returns the context that this request belongs to.
	 */
	public PodContext context();

	/**
	 * Returns array of uploaded files. Returns <code>null</code> if nothing
	 * was uploaded.
	 */
	public FileUpload[] fileUploads();

	/**
	 * Sets header value.
	 */
	public T header(String name, String value);

	/**
	 * Returns headers.
	 */
	public PodMultiMap headers();

	/**
	 * Returns HTTP method, in uppercase.
	 */
	public String method();

	/**
	 * Sets method.
	 */
	public T method(String method);

	/**
	 * Sets parameter value.
	 */
	public T param(String name, String value);

	/**
	 * Returns request parameters.
	 */
	public PodMultiMap params();

	/**
	 * Returns action path of the URI. Returned path does not contain the query
	 * part. Returns <code>"/"</code> for the root.
	 */
	public String path();

	/**
	 * Returns associated response of this request.
	 */
	public Response response();

	/**
	 * Returns the absolute URL corresponding to the the HTTP request.
	 */
	public String url();

	/**
	 * Sets url value.
	 */
	public T url(String path);

}