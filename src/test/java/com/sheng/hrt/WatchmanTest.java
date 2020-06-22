package com.sheng.hrt;


import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestWatcher;
import org.springframework.context.annotation.Description;

import static org.junit.Assert.fail;

public  class WatchmanTest {
    private static String watchedLog;

    @Rule
    public TestWatcher watchman= new TestWatcher() {
        protected void failed(Description d) {
            watchedLog+= d + "\n";
        }

        protected void succeeded(Description d) {
            watchedLog+= d + " " + "success!\n";
        }
    };

    @Test
    public void fails() {
        fail();
    }

    @Test
    public void succeeds() {
    }
}