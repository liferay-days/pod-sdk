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

/**
 * {@link Request} implementation.
 */
public class RequestImpl implements Request {

	public RequestImpl(String url) {
		this.url(url);
	}

	@Override
	public String baseUrl() {
		return baseUrl;
	}

	@Override
	public String body() {
		return body;
	}

	@Override
	public Request body(String body) {
		this.body = body;
		return this;
	}

	@Override
	public PodContext context() {
		throw new UnsupportedOperationException();
	}

	@Override
	public FileUpload[] fileUploads() {
		return fileUploads;
	}

	/**
	 * Sets the file uploads.
	 */
	Request fileUploads(FileUpload... fileUploads) {
		this.fileUploads = fileUploads;
		return this;
	}

	@Override
	public Request header(String name, String value) {
		headers.set(name, value);
		return this;
	}

	@Override
	public PodMultiMap headers() {
		return headers;
	}

	@Override
	public Request headers(PodMultiMap headers) {
		this.headers = headers;
		return this;
	}

	@Override
	public String method() {
		return method;
	}

	@Override
	public Request method(String method) {
		this.method = method;
		return this;
	}

	@Override
	public Request param(String name, String value) {
		params.set(name, value);
		return this;
	}

	@Override
	public PodMultiMap params() {
		return params;
	}

	@Override
	public Request params(PodMultiMap params) {
		this.params = params;
		return this;
	}

	@Override
	public String path() {
		return path;
	}

	@Override
	public String query() {
		return query;
	}

	@Override
	public Response response() {
		return response;
	}

	/**
	 * Sets the response.
	 */
	Request response(Response response) {
		this.response = response;
		return this;
	}

	@Override
	public String url() {
		return url;
	}

	private void url(String url) {
		if (url.startsWith("/")) {
			url = "http://localhost:8080" + url;
		}

		this.url = url;

		try {
			URL urlParsed = new URL(url);

			baseUrl =
				urlParsed.getProtocol() + "://" + urlParsed.getHost() + ":" +
					urlParsed.getPort();

			path = urlParsed.getPath();

			query = urlParsed.getQuery();
		}
		catch (MalformedURLException e) {
			throw new PodException("Invalid URL: " + url, e);
		}
	}

	protected String baseUrl;
	protected String body;
	protected FileUpload[] fileUploads;
	protected PodMultiMap headers = new PodMultiMapImpl();
	protected String method;
	protected PodMultiMap params = new PodMultiMapImpl();
	protected String path;
	protected String query;
	protected Response response;
	protected String url;

}