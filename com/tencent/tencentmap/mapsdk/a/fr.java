package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class fr {
    public static int a = -1;
    public static int b = -1;
    private static int c = 20000;
    private static ThreadPoolExecutor d;

    static class a implements ThreadFactory {
        private static final AtomicInteger a = new AtomicInteger(1);
        private final ThreadGroup b;
        private final AtomicInteger c = new AtomicInteger(1);
        private final String d;

        a(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.d = str + "-" + a.getAndIncrement() + "-thread-";
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static class c {
        private Lock a;
        private fq b;

        private c() {
            this.a = new ReentrantLock();
            this.b = null;
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final fq a() {
            return this.b;
        }

        public final void a(fq fqVar) {
            if (fqVar != null) {
                this.a.lock();
                try {
                    if (this.b == null) {
                        this.b = fqVar;
                    } else {
                        fqVar.b();
                    }
                    this.a.unlock();
                } catch (Throwable th) {
                    this.a.unlock();
                }
            }
        }
    }

    public static fq a(String str, int i) {
        if (str == null) {
            return null;
        }
        try {
            return "".equals(str) ? null : b(str, i);
        } catch (Exception e) {
            return null;
        }
    }

    public static fq a(ArrayList arrayList, int i) {
        if (arrayList == null) {
            return null;
        }
        try {
            return arrayList.size() <= 0 ? null : a(arrayList, "", i);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.tencentmap.mapsdk.a.fq a(java.util.ArrayList r12, java.lang.String r13, int r14) {
        /*
        r10 = new java.util.concurrent.CountDownLatch;
        r0 = 1;
        r10.<init>(r0);
        r11 = new com.tencent.tencentmap.mapsdk.a.fr$c;
        r0 = 0;
        r11.<init>(r0);
        r9 = new com.tencent.tencentmap.mapsdk.a.fq;
        r9.<init>();
        r0 = d;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        if (r0 != 0) goto L_0x0030;
    L_0x0015:
        r1 = new java.util.concurrent.ThreadPoolExecutor;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r2 = 3;
        r3 = 5;
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r7 = new java.util.concurrent.LinkedBlockingQueue;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r0 = 5;
        r7.<init>(r0);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r8 = new com.tencent.tencentmap.mapsdk.a.fr$a;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r0 = "HalleyAccess";
        r8.<init>(r0);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r1.<init>(r2, r3, r4, r6, r7, r8);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        d = r1;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
    L_0x0030:
        r0 = a(r12, r13);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r1 = r0.iterator();	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
    L_0x0038:
        r0 = r1.hasNext();	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        if (r0 == 0) goto L_0x0058;
    L_0x003e:
        r0 = r1.next();	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r0 = (com.tencent.tencentmap.mapsdk.a.fq) r0;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r2 = new com.tencent.tencentmap.mapsdk.a.fr$b;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r2.<init>(r10, r11, r0);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r0 = d;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r0.execute(r2);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        goto L_0x0038;
    L_0x004f:
        r0 = move-exception;
        r0 = "ThreadPool is full";
        r9.b(r0);
        r0 = r9;
    L_0x0057:
        return r0;
    L_0x0058:
        if (r14 < 0) goto L_0x005e;
    L_0x005a:
        r0 = c;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        if (r14 <= r0) goto L_0x0060;
    L_0x005e:
        r14 = c;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
    L_0x0060:
        r0 = (long) r14;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r0 = r10.await(r0, r2);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        if (r0 != 0) goto L_0x0071;
    L_0x0069:
        r0 = "latch wait too long";
        r9.b(r0);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        r0 = r9;
        goto L_0x0057;
    L_0x0071:
        r0 = r11.a();	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0076, Throwable -> 0x007f }
        goto L_0x0057;
    L_0x0076:
        r0 = move-exception;
        r0 = "countDownLatch InterruptedException";
        r9.b(r0);
        r0 = r9;
        goto L_0x0057;
    L_0x007f:
        r0 = move-exception;
        r0 = "Parallel connect failed";
        r9.b(r0);
        r0 = r9;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.fr.a(java.util.ArrayList, java.lang.String, int):com.tencent.tencentmap.mapsdk.a.fq");
    }

    private static List a(ArrayList arrayList, String str) {
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ep epVar = (ep) it.next();
            fq fqVar = new fq();
            fqVar.a(epVar);
            arrayList2.add(fqVar);
        }
        if (!TextUtils.isEmpty(str)) {
            fq fqVar2 = new fq();
            fqVar2.a(str);
            arrayList2.add(fqVar2);
        }
        return arrayList2;
    }

    public static void a() {
        if (d != null) {
            d.shutdownNow();
            d = null;
        }
    }

    private static fq b(String str, int i) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c cVar = new c();
        fq fqVar = new fq();
        fqVar.a(str);
        el.a().a(new b(countDownLatch, cVar, fqVar));
        try {
            if (countDownLatch.await((long) i, TimeUnit.MILLISECONDS)) {
                return cVar.a();
            }
            fqVar.b("latch wait too long");
            return fqVar;
        } catch (InterruptedException e) {
            return fqVar;
        }
    }
}
