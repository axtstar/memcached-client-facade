/*
 * Copyright 2011 - 2012 M3, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.m3.memcached.facade.adaptor;

import com.m3.memcached.facade.impl.ClientImpl;
import com.m3.memcached.facade.impl.SpymemcachedClientImpl;

public class SpymemcachedAdaptor implements MemcachedClientAdaptor {

    @Override
    public Class<? extends ClientImpl> getClientImplClass() {
        return SpymemcachedClientImpl.class;
    }

}