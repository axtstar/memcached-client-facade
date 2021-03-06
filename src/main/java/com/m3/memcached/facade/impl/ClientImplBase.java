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
package com.m3.memcached.facade.impl;

import com.m3.memcached.facade.MemcachedClient;

/**
 * Basic implementation for {@link ClientImpl}
 */
public abstract class ClientImplBase implements ClientImpl {

    /**
     * Key namespace
     */
    protected String namespace = MemcachedClient.DEFAULT_NAMESPACE;

    /**
     * Max milliseconds to wait memcached
     */
    protected long maxWaitMillis = 100L;

    /**
     * Returns key with namespace
     *
     * @param key raw key
     * @return key with namespace
     */
    protected String getKeyWithNamespace(String key) {
        return (this.namespace + "::" + key).replaceAll("\\s", "_");
    }

    @Override
    public String getNamespace() {
        return namespace;
    }

    @Override
    public void setNamespace(String namespace) {
        if (namespace == null) {
            this.namespace = "default";
        } else {
            this.namespace = namespace;
        }
    }


    @Override
    public long getMaxWaitMillis() {
        return this.maxWaitMillis;
    }

    @Override
    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }
}
