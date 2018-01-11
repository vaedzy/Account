package com.account.bean;

import java.util.concurrent.locks.ReentrantLock;

public class SysnKeyLock extends ReentrantLock {
    private static final long serialVersionUID = 1478211960393710925L;
    long key;

    public SysnKeyLock(long key) {
        this.key = key;
    }

    public long getKey() {
        return this.key;
    }

    public void setKey(long key) {
        this.key = key;
    }
}
