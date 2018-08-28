package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.protocal.MMProtocalJni;

public class LoadProtocolJNITask extends a {
    public void execute(g gVar) {
        k.b("MMProtocalJni", getClass().getClassLoader());
        retryOnce(new 1(this));
        retryOnce(new Runnable() {
            public void run() {
                MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
            }
        });
        retryOnce(new Runnable() {
            public void run() {
                MMProtocalJni.setIsLite(false);
            }
        });
    }

    private void retryOnce(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            runnable.run();
        }
    }

    public String name() {
        return "boot-load-MMProtocalJni-library";
    }
}
