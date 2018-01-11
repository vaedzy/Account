package com.account.common.utils;

import com.account.bean.SysnKeyLock;

public class ResourceLock {
    static SysnLockPool rtLockPool = new SysnLockPool();

    public ResourceLock() {
    }

    public static SysnKeyLock accquireWrite(long resourceID) {
        SysnKeyLock lock = rtLockPool.getLock(resourceID);
        lock.lock();
        return lock;
    }

    public static void releaseWrite(long resourceID) {
        SysnKeyLock lock = rtLockPool.getLock(resourceID);
        lock.unlock();
        rtLockPool.releaseLock(lock);
    }

}
