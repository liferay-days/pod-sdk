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

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

/**
 */
public class RequestTest {

	@Test
	public void testBody() {
		Request request = new RequestImpl("http://127.0.0.1");
		request.body("foo");
		assertEquals("foo", request.body());
	}

	@Test
	public void testFileUploads() {
		RequestImpl request = new RequestImpl("http://127.0.0.1");
		FileUpload[] fileUploads = new FileUpload[] {};
		request.fileUploads(fileUploads);
		Assert.assertArrayEquals(fileUploads, request.fileUploads());
	}

	@Test
	public void testHeaders() {
		Request request = new RequestImpl("http://127.0.0.1");
		request.header("header", "1");
		assertEquals("1", request.headers().get("header"));
	}

	@Test
	public void testHeaders_setFromMap() {
		Request request = new RequestImpl("http://127.0.0.1");
		PodMultiMap map = new PodMultiMapImpl();
		request.headers(map);
		assertEquals(map, request.headers());
	}

	@Test
	public void testMethod() {
		Request request = new RequestImpl("http://127.0.0.1");
		request.method("post");
		assertEquals("post", request.method());
	}

	@Test
	public void testParams() {
		Request request = new RequestImpl(
			"http://localhost:8080/path/sub?param1=1");
		request.param("param2", "2");
		assertEquals(null, request.params().get("param1"));
		assertEquals("2", request.params().get("param2"));
	}

	@Test
	public void testParams_setFromMap() {
		Request request = new RequestImpl("http://127.0.0.1");
		PodMultiMap map = new PodMultiMapImpl();
		request.params(map);
		assertEquals(map, request.params());
	}

	@Test
	public void testResponse() {
		RequestImpl request = new RequestImpl("http://127.0.0.1");
		Response response = new ResponseImpl(request);
		assertEquals(response, request.response());
	}

	@Test
	public void testUrl() {
		Request request = new RequestImpl(
			"http://localhost:8080/path/sub?query=1");
		assertEquals("http://localhost:8080/path/sub?query=1", request.url());
	}

	@Test
	public void testUrlBaseUrl() {
		Request request = new RequestImpl(
			"http://localhost:8080/path/sub?query=1");
		assertEquals("http://localhost:8080", request.baseUrl());
	}

	@Test
	public void testUrlPath() {
		Request request = new RequestImpl(
			"http://localhost:8080/path/sub?query=1");
		assertEquals("/path/sub", request.path());
	}

	@Test
	public void testUrlQuery() {
		Request request = new RequestImpl(
			"http://localhost:8080/path/sub?query=1&other=2");
		assertEquals("query=1&other=2", request.query());
	}

}