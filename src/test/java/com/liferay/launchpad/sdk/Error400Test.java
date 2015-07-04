package com.liferay.launchpad.sdk;

import jodd.json.JsonParser;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Error400Test {

	@Test
	public void testBadRequest() {
		Response response = createResponse();

		ResponseError.badRequest().end(response);

		Map<String, Object> body = deserializeBody(response);

		assertEquals(1, body.size());
		assertEquals(Integer.valueOf(400), body.get("code"));
	}

	@Test
	public void testBadRequest_badContent() {
		Response response = createResponse();

		ResponseError.badRequest().badContent().end(response);

		Map<String, Object> body = deserializeBody(response);

		assertEquals(2, body.size());
		assertEquals(Integer.valueOf(400), body.get("code"));

		List<Map> errors = (List) body.get("errors");
		assertEquals(1, errors.size());
		assertEquals("badContent", errors.get(0).get("reason"));
	}

	@Test
	public void testBadRequest_badContent_keyExpired() {
		Response response = createResponse();

		ResponseError.badRequest().badContent().keyExpired().end(response);

		Map<String, Object> body = deserializeBody(response);

		assertEquals(2, body.size());
		assertEquals(Integer.valueOf(400), body.get("code"));

		List<Map> errors = (List) body.get("errors");
		assertEquals(2, errors.size());
		assertEquals("badContent", errors.get(0).get("reason"));
		assertEquals("keyExpired", errors.get(1).get("reason"));
	}

	private static Map<String, Object> deserializeBody(Response response) {
		String body = response.body();

		return new JsonParser().parse(body);
	}

	private static Response createResponse() {
		Request request = new RequestImpl("http://localhost:8080/");

		Response response = new ResponseImpl(request);

		return response;
	}
}