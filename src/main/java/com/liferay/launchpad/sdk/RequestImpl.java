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

import java.net.MalformedURLException;
import java.net.URL;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 */
public class RequestImpl implements Request {

	/**
	 * @see Request#baseUrl()
	 */
	public String baseUrl() {
		return url().substring(0, url().indexOf(path()));
	}

	/**
	 * @see Request#body()
	 */
	public String body() {
		return body;
	}

	/**
	 * @see Request#body(String)
	 */
	public Request body(String body) {
		this.body = body;
		return this;
	}

	/**
	 * @see Request#context()
	 */
	public PodContext context() {
		throw new NotImplementedException();
	}

	/**
	 * @see Request#fileUploads()
	 */
	public FileUpload[] fileUploads() {
		throw new NotImplementedException();
	}

	/**
	 * @see Request#header(String, String)
	 */
	public Request header(String name, String value) {
		headers.set(name, value);
		return this;
	}

	/**
	 * @see Request#headers()
	 */
	public PodMultiMap headers() {
		return headers;
	}

	/**
	 * @see Request#method()
	 */
	public String method() {
		return method;
	}

	/**
	 * @see Request#method(String)
	 */
	public Request method(String method) {
		this.method = method;
		return this;
	}

	/**
	 * @see Request#param(String, String)
	 */
	public Request param(String name, String value) {
		params.set(name, value);
		return this;
	}

	/**
	 * @see Request#params()
	 */
	public PodMultiMap params() {
		return params;
	}

	@Override
	public String path() {
		try {
			return new URL(url()).getPath();
		}
		catch (MalformedURLException e) {
			return "";
		}
	}

	/**
	 * @see Request#url()
	 */
	public String url() {
		return url;
	}

	/**
	 * @see Request#url(String)
	 */
	public Request url(String path) {
		this.url = path;
		return this;
	}

	protected String body;
	protected PodMultiMap headers = new PodMultiMapImpl();
	protected String method;
	protected PodMultiMap params = new PodMultiMapImpl();
	protected String url;

}