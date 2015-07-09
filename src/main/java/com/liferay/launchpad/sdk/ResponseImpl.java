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
 */
public class ResponseImpl implements Response {

	public ResponseImpl(RequestImpl request) {
		this.request = request;
		request.response(this);
	}

	@Override
	public String body() {
		return body;
	}

	@Override
	public Object bodyObject() {
		return bodyObject;
	}

	@Override
	public void body(String body) {
		this.body = body;
	}

	@Override
	public PodContext context() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Response header(String name, String value) {
		headers.set(name, value);
		return this;
	}

	@Override
	public PodMultiMap headers() {
		return headers;
	}

	@Override
	public Response headers(PodMultiMap headers) {
		this.headers = headers;
		return this;
	}

	@Override
	public boolean isCommitted() {
		return (body != null);
	}

	@Override
	public Request request() {
		return request;
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

	void bodyObject(Object bodyObject) {
		this.bodyObject = bodyObject;
	}

	protected String body = null;
	protected Object bodyObject = null;
	protected PodMultiMap headers = new PodMultiMapImpl();
	protected Request request;
	protected int statusCode;
	protected String statusMessage;

}