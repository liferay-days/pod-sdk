# Error Messages

This document identifies some of the error codes and messages that Launchpad APIs return.

This page lists errors by their HTTP status codes as defined in [RFC 2616](http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10).

The sample JSON response below demonstrates how an error is communicated:

```javascript
{
  "code": 400,
  "message" : "Default or user-defined description",
  "errors": [
    {
      "reason": "parseError",
      "message": "The API server cannot parse the request body."
    },
    {
      "reason": "badContent",
      "message": "The content type of the request data or the content type of a part of a multipart request is not supported."
    }
  ]
}
```

## 400 Bad Request

The request could not be understood by the server due to malformed syntax.

Error code           | Description
------------         | -------------
badRequest           | The API request is invalid or improperly formed.
badContent           | The content type of the request data or the content type of a part of a multipart request is not supported.
invalidQuery         | The request is invalid. Check the API documentation to determine what parameters are supported for the request and to see if the request contains an invalid combination of parameters or an invalid parameter value.
invalidDocumentValue | The request failed because it contained an invalid parameter or parameter value for the document. Review the API documentation to determine which parameters are valid for your request.
keyExpired           | The API key provided in the request expired, which means the API server is unable to make the request.
keyInvalid           | The API key provided in the request is invalid, which means the API server is unable to make the request.
parseError           | The API server cannot parse the request body.
required             | The API request is missing required information. The required information could be a parameter or resource property.

## 403 Forbidden

The server understood the request, but is refusing to fulfill it. It SHOULD describe the reason for the refusal as error code.

Error code           | Description
------------         | -------------
forbidden            | The requested operation is forbidden and cannot be completed.
limitExceeded        | The request cannot be completed due to access or rate limitations.
quotaExceeded        | The requested operation requires more resources than the quota allows.
rateLimitExceeded    | Too many requests have been sent within a given time span.
responseTooLarge     | The requested resource is too large to return.
unknownAuth          | The API server does not recognize the authorization scheme used for the request.
corsRequestOrigin    | The CORS request is from an unknown origin.

## 404 Not Found

The server has not found anything matching the Request-URI. This status code is commonly used when the server does not wish to reveal exactly why the request has been refused, or when no other response is applicable.

Error code           | Description
------------         | -------------
notFound             | The requested operation failed because a resource associated with the request could not be found.
unsupportedProtocol  | The protocol used in the request is not supported. 

## 405 Method Not Allowed

The HTTP method associated with the request is not supported.

Error code           | Description
------------         | -------------
httpMethodNotAllowed | The HTTP method associated with the request is not supported.

## 500 Internal Server Error

The server encountered an unexpected condition which prevented it from fulfilling the request.

Error code           | Description
------------         | -------------
internalError        | The request failed due to an internal error.
