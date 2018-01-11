package com.account.common.utils;

import com.account.bean.SysnKeyLock;
import org.apache.commons.collections.map.LRUMap;

import java.util.Hashtable;

public class SysnLockPool {
    private static final int poolSize = 10000;
    private Hashtable<Long, SysnKeyLock> core = new Hashtable();
    private LRUMap cache = new LRUMap(10000);

    public SysnLockPool() {
    }

    public synchronized SysnKeyLock getLock(long resourceID) {
        SysnKeyLock lock = (SysnKeyLock)this.core.get(resourceID);
        if(lock == null) {
            lock = (SysnKeyLock)this.cache.get(resourceID);
            if(lock == null) {
                lock = new SysnKeyLock(resourceID);
            } else {
                this.cache.remove(resourceID);
            }

            this.core.put(resourceID, lock);
        }

        return lock;
    }

    public synchronized void releaseLock(SysnKeyLock lock) {
        this.core.remove(lock.getKey());
        this.cache.put(lock.getKey(), lock);
    }

}
