package com.tencent.f;

import com.tencent.f.b.c;
import java.util.HashMap;

class f$a {
    private final Object mLock = new Object();
    private final HashMap<String, Object> vwG = new HashMap();
    final /* synthetic */ f vwH;

    f$a(f fVar) {
        this.vwH = fVar;
    }

    final void gt(String str, String str2) {
        String str3 = str + str2;
        synchronized (this.mLock) {
            while (this.vwG.get(str3) != null) {
                try {
                    this.mLock.wait();
                } catch (InterruptedException e) {
                    throw new c("install fail,lock interrupted!");
                }
            }
            this.vwG.put(str3, str2);
        }
    }

    final void gu(String str, String str2) {
        String str3 = str + str2;
        synchronized (this.mLock) {
            this.vwG.remove(str3);
            this.mLock.notifyAll();
        }
    }
}
