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

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 */
public class ResponseTest {

	RequestImpl request;
	ResponseImpl response;

	@Before
	public void setUp() {
		request = new RequestImpl();
		response = new ResponseImpl(request);
	}

	@Test
	public void testBody() {
		response.body("foo");
		Assert.assertEquals("foo", response.body());
	}

	@Test
	public void testHeaders() {
		response.header("header", "1");
		Assert.assertEquals("1", response.headers().get("header"));
	}

	@Test
	public void testHeaders_setFromMap() {
		PodMultiMap map = new PodMultiMapImpl();
		response.headers(map);
		Assert.assertEquals(map, response.headers());
	}

	@Test
	public void testIsCommitted() {
		Assert.assertEquals(false, response.isCommitted());
		response.body("foo");
		Assert.assertEquals(true, response.isCommitted());
	}

	@Test(expected = NotImplementedException.class)
	public void testPodContext_throwsNotImplemented() {
		response.context();
	}

	@Test
	public void testRequest() {
		Assert.assertEquals(request, response.request());
	}

	@Test
	public void testStatusCode() {
		response.statusCode(200);
		Assert.assertEquals(200, response.statusCode());
	}

	@Test
	public void testStatusMessage() {
		response.statusMessage("OK");
		Assert.assertEquals("OK", response.statusMessage());
	}

}