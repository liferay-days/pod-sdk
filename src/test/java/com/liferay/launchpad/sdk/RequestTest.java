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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 */
public class RequestTest {

	RequestImpl request;

	@Before
	public void setUp() {
		request = new RequestImpl();
	}

	@Test
	public void testBody() {
		request.body("foo");
		Assert.assertEquals("foo", request.body());
	}

	@Test
	public void testFileUploads() {
		FileUpload[] fileUploads = new FileUpload[] {};
		request.fileUploads(fileUploads);
		Assert.assertArrayEquals(fileUploads, request.fileUploads());
	}

	@Test
	public void testHeaders() {
		request.header("header", "1");
		Assert.assertEquals("1", request.headers().get("header"));
	}

	@Test
	public void testHeaders_setFromMap() {
		PodMultiMap map = new PodMultiMapImpl();
		request.headers(map);
		Assert.assertEquals(map, request.headers());
	}

	@Test
	public void testMethod() {
		request.method("post");
		Assert.assertEquals("post", request.method());
	}

	@Test
	public void testParams() {
		request.url("http://localhost:8080/path/sub?param1=1");
		request.param("param2", "2");
		Assert.assertEquals(null, request.params().get("param1"));
		Assert.assertEquals("2", request.params().get("param2"));
	}

	@Test
	public void testParams_setFromMap() {
		PodMultiMap map = new PodMultiMapImpl();
		request.params(map);
		Assert.assertEquals(map, request.params());
	}

	@Test
	public void testResponse() {
		Response response = new ResponseImpl(request);
		request.response(response);
		Assert.assertEquals(response, request.response());
	}

	@Test
	public void testUrl() {
		request.url("http://localhost:8080/path/sub?query=1");
		Assert.assertEquals(
			"http://localhost:8080/path/sub?query=1", request.url());
	}

	@Test
	public void testUrlBaseUrl() {
		request.url("http://localhost:8080/path/sub?query=1");
		Assert.assertEquals("http://localhost:8080", request.baseUrl());
	}

	@Test
	public void testUrlPath() {
		request.url("http://localhost:8080/path/sub?query=1");
		Assert.assertEquals("/path/sub", request.path());
	}

	@Test
	public void testUrlQuery() {
		request.url("http://localhost:8080/path/sub?query=1&other=2");
		Assert.assertEquals("query=1&other=2", request.query());
	}

}