package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ji {
    private ExecutorService a;
    private ExecutorService b;
    private jg c;
    private jh d;

    public void a(jg jgVar) {
        this.c = jgVar;
    }

    public void a(jh jhVar) {
        this.d = jhVar;
    }

    public void a() {
        a(null);
    }

    public void a(Runnable runnable) {
        this.c = null;
        if (this.a != null) {
            this.a.shutdown();
            this.a = null;
        }
        if (this.b != null) {
            this.b.shutdown();
            this.b = null;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(String str) {
        if (this.c != null) {
            if (this.a == null) {
                this.a = Executors.newFixedThreadPool(5);
            }
            try {
                this.a.execute(new 1(this, str));
            } catch (IllegalMonitorStateException e) {
            }
        }
    }

    private void b(String str) {
        try {
            byte[] a = this.c.a(str);
            if (a != null && a.length == 0) {
                a = null;
            }
            a(str, a);
        } catch (Exception e) {
            a(str, null);
        }
    }

    private void a(String str, byte[] bArr) {
        if (this.d != null) {
            if (this.b == null) {
                this.b = Executors.newSingleThreadExecutor();
            }
            this.b.execute(new 2(this, bArr, str));
        }
    }
}
