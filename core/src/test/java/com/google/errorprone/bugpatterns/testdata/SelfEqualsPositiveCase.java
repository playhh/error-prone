/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.bugpatterns;

/**
 * @author eaftan@google.com (Eddie Aftandilian)
 */
public class SelfEqualsPositiveCase {

  public boolean test1() {
    Object obj = new Object();
    // BUG: Diagnostic contains: An object is tested for equality to itself
    return obj.equals(obj);
  }

  private Object obj = new Object();
  public boolean test2() {
    // BUG: Diagnostic contains: An object is tested for equality to itself
    return obj.equals(this.obj);
  }

  public boolean test3() {
    // BUG: Diagnostic contains: An object is tested for equality to itself
    return this.obj.equals(obj);
  }

  public boolean test4() {
    // BUG: Diagnostic contains: An object is tested for equality to itself
    return this.obj.equals(this.obj);
  }

  public boolean test5() {
    // BUG: Diagnostic contains: An object is tested for equality to itself
    return equals(this);
  }
}
