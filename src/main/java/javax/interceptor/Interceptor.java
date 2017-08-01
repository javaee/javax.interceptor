/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.interceptor;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <p>Specifies that a class is an interceptor.</p>
 * 
 * <pre>
 * &#064;Validated &#064;Interceptor
 * public class ValidationInterceptor { ... }
 * </pre>
 * 
 * <p>Use of this annotation is required when declaring an interceptor
 * using interceptor binding annotations.
 * It is ignored during the processing of classes bound using the {@link
 * javax.interceptor.Interceptors Interceptors} annotation (or when
 * the EJB deployment descriptor is used to associate the interceptor
 * with the target class).</p>
 * 
 * @see javax.interceptor.Interceptors
 *
 * @since Interceptors 1.1
 */
@Retention(RUNTIME)
@Target(TYPE)
@Documented
public @interface Interceptor {
    /**
     * <p>Priorities that define the order in which interceptors are
     * invoked.  These values are intended to be used with the
     * {@link javax.annotation.Priority Priority} annotation for
     * interceptors that are defined by means of interceptor binding.
     *
     * <p>Interceptors with smaller priority values are called first. 
     * If more than one interceptor has the same priority, the relative 
     * order of those interceptors is undefined.</p>
     *
     * <ul> 
     * <li>Interceptors defined by platform specifications that
     * are to be executed at the beginning of the interceptor chain
     * should have priority values in the range <a
     * href="#PLATFORM_BEFORE">PLATFORM_BEFORE</a> up until <a
     * href="#LIBRARY_BEFORE">LIBRARY_BEFORE</a>.</li>
     *
     * <li>Interceptors defined by extension libraries that are
     * intended to be executed earlier in the interceptor chain, but
     * after any interceptors in the range up until <a
     * href="#LIBRARY_BEFORE">LIBRARY_BEFORE</a> should have priority
     * values in the range <a
     * href="#LIBRARY_BEFORE">LIBRARY_BEFORE</a> up until <a
     * href="#APPLICATION">APPLICATION</a>.</li>
     * 
     * <li>Interceptors defined by applications should have priority values 
     * in the range  <a href="#APPLICATION">APPLICATION</a> up until
     * <a href="#LIBRARY_AFTER">LIBRARY_AFTER</a>.</li>  
     *
     * <li>Interceptors defined by extension libraries that are
     * intended to be executed later in the interceptor chain
     * should have priority values in the range <a
     * href="#LIBRARY_AFTER">LIBRARY_AFTER</a> up until <a
     * href="#PLATFORM_AFTER">PLATFORM_AFTER</a>.</li>
     *
     * <li>Interceptors defined by platform specifications that are
     * intended to be executed at the end of the interceptor chain
     * should have priority values at <a
     * href="#PLATFORM_AFTER">PLATFORM_AFTER</a> or higher.</li>
     * </ul>
     *
     * <p>An interceptor that must be invoked before or
     * after another defined interceptor can choose any appropriate
     * value.</p>
     *
     *
     * <p>For example, an extension library might define an interceptor
     * like this:</p>
     *
     * <pre>
     * &#064;Priority(Interceptor.Priority.LIBRARY_BEFORE+10)
     * &#064;Validated &#064;Interceptor
     * public class ValidationInterceptor { ... }
     * </pre>
     *
     * The {@link javax.annotation.Priority Priority} annotation is
     * ignored when computing the invocation order of interceptors
     * bound to a target using the {@link javax.interceptor.Interceptors
     * Interceptors} annotation.
     *
     * @see javax.annotation.Priority
     * @since Interceptors 1.2
     */
    public static class Priority {
	private Priority() { }	// don't allow instances

	/**
	 * Start of range for early interceptors defined by
	 * platform specifications.
	 */
	public static final int PLATFORM_BEFORE = 0;

	/**
	 * Start of range for early interceptors defined by
	 * extension libraries.
	 */
	public static final int LIBRARY_BEFORE = 1000;

	/**
	 * Start of range for interceptors defined by
	 * applications.
	 */
	public static final int APPLICATION = 2000;

	/**
	 * Start of range for late interceptors defined by
	 * extension libraries.
	 */
	public static final int LIBRARY_AFTER = 3000;

	/**
	 * Start of range for late interceptors defined by
	 * platform specifications.
	 */
	public static final int PLATFORM_AFTER = 4000;
    }
}
