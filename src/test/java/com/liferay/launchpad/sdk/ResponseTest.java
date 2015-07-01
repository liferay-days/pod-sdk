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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 */
public class ResponseTest {

	@Test
	public void testBody() {
		Request request = new RequestImpl("Http://localhost:8080");
		Response response = new ResponseImpl(request);
		response.body("foo");
		assertEquals("foo", response.body());
	}

	@Test
	public void testHeaders() {
		Request request = new RequestImpl("Http://localhost:8080");
		Response response = new ResponseImpl(request);
		response.header("header", "1");
		assertEquals("1", response.headers().get("header"));
	}

	@Test
	public void testHeaders_setFromMap() {
		Request request = new RequestImpl("Http://localhost:8080");
		Response response = new ResponseImpl(request);
		PodMultiMap map = new PodMultiMapImpl();
		response.headers(map);
		assertEquals(map, response.headers());
	}

	@Test
	public void testIsCommitted() {
		Request request = new RequestImpl("Http://localhost:8080");
		Response response = new ResponseImpl(request);

		assertFalse(response.isCommitted());
		response.body("foo");
		assertTrue(response.isCommitted());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testPodContext_throwsNotImplemented() {
		Request request = new RequestImpl("Http://localhost:8080");
		Response response = new ResponseImpl(request);

		response.context();
	}

	@Test
	public void testRequest() {
		Request request = new RequestImpl("Http://localhost:8080");
		Response response = new ResponseImpl(request);
		assertEquals(request, response.request());
	}

	@Test
	public void testStatusCode() {
		Request request = new RequestImpl("Http://localhost:8080");
		Response response = new ResponseImpl(request);
		response.statusCode(200);
		assertEquals(200, response.statusCode());
	}

	@Test
	public void testStatusMessage() {
		Request request = new RequestImpl("Http://localhost:8080");
		Response response = new ResponseImpl(request);
		response.statusMessage("OK");
		assertEquals("OK", response.statusMessage());
	}

}