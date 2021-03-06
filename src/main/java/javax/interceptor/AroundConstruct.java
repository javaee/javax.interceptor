/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013-2018 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
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

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p>Designates an interceptor method that receives a callback when
 * the target class constructor is invoked.
 * </p>
 * <p>The method to which the <tt>AroundConstruct</tt> annotation is applied must have one of the 
 * following signatures.
 * </p>
 * 
 * <pre>
 * void &#060;METHOD&#062;(InvocationContext ctx) 
 *
 * Object &#060;METHOD&#062;(InvocationContext ctx) 
 * </pre>
 * 
 * <p>The method must not be declared as abstract, final, or static.</p>
 *
 * <p>An <tt>AroundConstruct</tt> interceptor method may be only declared in 
 * an interceptor class or superclass of an interceptor class.</p>
 *
 * <p>An interceptor class must not declare more than one <tt>AroundConstruct</tt> 
 * method.</p>
 * 
 * <p> The target instance is created and its constructor injection is 
 * performed, if applicable,  when the last interceptor method in the 
 * <tt>AroundConstruct</tt> interceptor chain invokes the 
 * {@link javax.interceptor.InvocationContext#proceed()} method.
 *
 * <p>An <tt>AroundConstruct</tt> interceptor method should exercise caution 
 * accessing the instance whose constructor it interposes on.</p>
 *
 * <p><tt>AroundConstruct</tt> methods may throw any exceptions that are 
 * allowed by the throws clause of the constructor on which they are 
 * interposing.</p>
 *
 * @since Interceptors 1.2 
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AroundConstruct {
}
