package com.m3.memcached.facade.impl;

import com.m3.memcached.facade.Configuration;
import com.m3.memcached.facade.bean.SampleBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class XmemcachedClientImplTest {

    ClientImpl memcached = new XmemcachedClientImpl();
    Configuration config = null;

    List<InetSocketAddress> addresses = null;

    @Before
    public void setUp() throws Exception {
        if (config == null) {
            config = Configuration.loadConfigFromProperties();
        }
        memcached.initialize(config.getAddresses());
        addresses = config.getAddresses();
    }

    @After
    public void tearDown() throws Exception {
        memcached.shutdown();
    }

    @Test
    public void type() throws Exception {
        assertThat(XmemcachedClientImpl.class, notNullValue());
    }

    @Test
    public void instantiation() throws Exception {
        XmemcachedClientImpl target = new XmemcachedClientImpl();
        assertThat(target, notNullValue());
    }

    @Test
    public void initialize_A$List() throws Exception {
        memcached.initialize(addresses);
    }

    @Test
    public void initialize_A$List$String() throws Exception {
        String namespace = null;
        memcached.initialize(addresses, namespace);
    }

    @Test
    public void getNamespace_A$() throws Exception {
        String actual = memcached.getNamespace();
        String expected = "default";
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void setNamespace_A$String() throws Exception {
        String namespace = null;
        memcached.setNamespace(namespace);
    }

    @Test
    public void set_A$String$int$Object() throws Exception {
        String key = "something";
        int secondsToExpire = 0;
        SampleBean value = new SampleBean();
        memcached.set(key, secondsToExpire, value);
    }

    @Test
    public void get_A$String() throws Exception {
        String key = "something";
        int secondsToExpire = 1;
        SampleBean value = new SampleBean();
        value.name = "var";
        memcached.set(key, secondsToExpire, value);
        SampleBean actual = memcached.get(key);
        if (actual == null) {
            fail("No memcached servers!");
        }
        assertThat(actual.name, is(equalTo(value.name)));
    }

    @Test
    public void setAndEnsure_A$String$int$Object() throws Exception {
        String key = "something";
        int secondsToExpire = 0;
        SampleBean value = new SampleBean();
        memcached.setAndEnsure(key, secondsToExpire, value);
    }

    @Test
    public void isInitialized_A$() throws Exception {
        boolean actual = memcached.isInitialized();
        boolean expected = true;
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void isInitialized_A$_NotYet() throws Exception {
        boolean actual = new XmemcachedClientImpl().isInitialized();
        boolean expected = false;
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void initialize_A$List$String$long() throws Exception {
        List<InetSocketAddress> addresses = Arrays.asList(new InetSocketAddress("127.0.0.1", 11211));
        String namespace = null;
        long maxWaitMillis = 10L;
        memcached.initialize(addresses, namespace, maxWaitMillis);
    }

    @Test
    public void delete_A$String() throws Exception {
        String key = "XmemcachedClientImpl_delete_A$String";
        memcached.set(key, 10, "foo");
        assertThat(memcached.get(key).toString(), is(equalTo("foo")));
        memcached.delete(key);
        assertThat(memcached.get(key), is(nullValue()));
    }

    @Test(expected = IllegalStateException.class)
    public void shutdown_A$_NotInitialized() throws Exception {
        XmemcachedClientImpl impl = new XmemcachedClientImpl();
        impl.shutdown();
    }

    @Test
    public void shutdown_A$() throws Exception {
        memcached.shutdown();
    }

}
