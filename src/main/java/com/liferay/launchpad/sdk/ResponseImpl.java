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

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 */
public class ResponseImpl implements Response {

	public ResponseImpl(Request request) {
		this.request = request;
	}

	@Override
	public String body() {
		return body;
	}

	@Override
	public void body(String body) {
		this.body = body;
	}

	@Override
	public PodContext context() {
		throw new NotImplementedException();
	}

	@Override
	public String header(String headerName) {
		return null;
	}

	/**
	 * @see Response#header(String, String)
	 */
	public Response header(String name, String value) {
		headers.set(name, value);
		return this;
	}

	@Override
	public PodMultiMap headers() {
		return headers;
	}

	@Override
	public boolean isCommitted() {
		return false;
	}

	@Override
	public Request request() {
		return request;
	}

	@Override
	public Response status(int statusCode, String statusMessage) {
		statusCode(statusCode);
		statusMessage(statusMessage);
		return this;
	}

	@Override
	public int statusCode() {
		return statusCode;
	}

	@Override
	public Response statusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	@Override
	public String statusMessage() {
		return statusMessage;
	}

	@Override
	public Response statusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
		return this;
	}

	protected String body;
	protected PodMultiMap headers = new PodMultiMapImpl();
	protected Request request;
	protected int statusCode;
	protected String statusMessage;

}