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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;
import java.util.Map;

/**
 * Execution context.
 */
public interface PodContext {

	/**
	 * Returns user configuration or <code>null</code> if no configuration is
	 * specified.
	 */
	Map<String, Object> configuration();

	/**
	 * Returns context name.
	 */
	String name();

	/**
	 * Returns {@link PodRuntime runtime} instance if one is specified.
	 */
	PodRuntime runtime();

	/**
	 * Loads Java resource from context classloader.
	 */
	InputStream openJavaResource(String name) throws IOException;

	/**
	 * Returns assets file from <code>assets</code> folder.
	 */
	File assetsFile(String fileName);

	/**
	 * Returns assets files from <code>assets</code> folder that matches
	 * provided <i>wildcard</i> glob patterns.
	 */
	List<File> assetsFiles(String... glob);

	/**
	 * Returns single file from <code>web</code> folder. Returns
	 * <code>null</code> if file does not exist.
	 */
	File webFile(String fileName);

	/**
	 * Returns static files from <code>web</code> folder that matches provided
	 * <i>wildcard</i> glob patterns.
	 */
	List<File> webFiles(String... glob);

}