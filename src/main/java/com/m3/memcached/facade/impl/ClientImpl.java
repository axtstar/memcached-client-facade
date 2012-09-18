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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * Concrete client implementation
 */
public interface ClientImpl {

    /**
     * Is initialized
     *
     * @return true when already initialized
     */
    boolean isInitialized();

    /**
     * Initializes this instance with default namespace
     *
     * @param addresses memcached server addresses
     * @throws IOException something wrong
     */
    void initialize(List<InetSocketAddress> addresses) throws IOException;

    /**
     * Initializes this instance
     *
     * @param addresses memcached server addresses
     * @param namespace namespace
     * @throws IOException something wrong
     */
    void initialize(List<InetSocketAddress> addresses, String namespace) throws IOException;

    /**
     * Initializes this instance
     *
     * @param addresses memcached server addresses
     * @param namespace namespace
     * @param maxWaitMillis max wait millis
     * @throws IOException something wrong
     */
    void initialize(List<InetSocketAddress> addresses, String namespace, long maxWaitMillis) throws IOException;

    String getNamespace();

    void setNamespace(String namespace);

    long getMaxWaitMillis();

    void setMaxWaitMillis(long maxWaitMillis);

    <T> void set(String key, int secondsToExpire, T value) throws IOException;

    <T> void setAndEnsure(String key, int secondsToExpire, T value) throws IOException;

    <T> T get(String key) throws IOException;

    void delete(String key) throws IOException;

}
