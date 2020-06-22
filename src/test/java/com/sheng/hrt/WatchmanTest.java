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
        @Override
        protected void succeeded(org.junit.runner.Description description) {
            watchedLog+= description + "\n";
            System.out.println("ww");
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, org.junit.runner.Description description) {
            watchedLog+= description + " " + "success!\n";
            super.failed(e, description);
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