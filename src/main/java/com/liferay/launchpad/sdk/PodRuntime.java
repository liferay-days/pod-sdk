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
 * Runtime interface is a singleton in a pods realm. It may be injected into
 * the pod action via constructor.
 */
public interface PodRuntime {

	/**
	 * Called when pod is deployed, loaded and started.
	 */
	void start(PodContext context);

	/**
	 * Called when pod is about to be stopped and undeployed.
	 */
	void stop(PodContext context);

}