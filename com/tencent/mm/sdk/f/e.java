package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e implements a {
    private static e sLa;
    static int[] sLb = new int[]{19, 16, 13, 10, 0, -2, -4, -5, -6, -8};
    static long sLd = 0;
    static long sLe = 0;
    private static b sLf;
    private static a sLg;
    private static b sLh;
    private boolean bGv = false;
    volatile boolean bPd = false;
    Object lock = new Object();
    private f sKS = new f(this.sKT + 2, TimeUnit.SECONDS, this.sKU, this);
    private int sKT = cjx();
    private PriorityBlockingQueue<Runnable> sKU = new PriorityBlockingQueue(33);
    private LinkedList<g> sKV = new LinkedList();
    private ArrayList<g> sKW = new ArrayList();
    private HashMap<g, Thread> sKX = new HashMap();
    private ArrayList<c> sKY = new ArrayList();
    private c sKZ;

    public interface b {
    }

    class a implements c {
        private final Runnable r;

        public a(Runnable runnable) {
            this.r = runnable;
        }

        public final void B(Runnable runnable) {
            if (runnable.equals(this.r)) {
                synchronized (this.r) {
                    this.r.notifyAll();
                    e.c(this);
                }
            }
        }
    }

    class c extends ag {
        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    removeMessages(message.what);
                    if (e.this.bPd) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (e.sLd > 0 && Math.abs(e.sLe - currentTimeMillis) > e.sLd) {
                            x.i("MicroMsg.ThreadPool", "|MMThreadPool thread pool is auto wakeup");
                            e eVar = e.this;
                            synchronized (eVar.lock) {
                                eVar.bPd = false;
                                e.sLe = 0;
                                e.sLd = 0;
                            }
                        }
                        sendEmptyMessageDelayed(1, 1000);
                        return;
                    }
                    e.a(e.this);
                    return;
                default:
                    return;
            }
        }
    }

    public static e cjw() {
        if (sLa == null) {
            synchronized (e.class) {
                if (sLa == null) {
                    sLa = new e();
                }
            }
        }
        return sLa;
    }

    private e() {
        HandlerThread Xs = Xs("THREAD_POOL_HANDLER");
        Xs.start();
        this.sKZ = new c(Xs.getLooper());
    }

    private static int cjx() {
        int availableProcessors = (Runtime.getRuntime().availableProcessors() * 4) + 2;
        if (availableProcessors > 32) {
            return 32;
        }
        return availableProcessors;
    }

    public final void beforeExecute(Thread thread, Runnable runnable) {
        int i = 10;
        synchronized (this.lock) {
            Iterator it = this.sKW.iterator();
            if (it != null) {
                Object obj;
                g gVar = (g) runnable;
                int i2 = gVar.priority;
                if (i2 <= 0) {
                    i = 1;
                } else if (i2 <= 10) {
                    i = i2;
                }
                thread.setPriority(i);
                thread.setName(gVar.jGC);
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    this.sKX.put(gVar, thread);
                    ArrayList arrayList = new ArrayList(this.sKY);
                    if (!this.bGv) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                    }
                    this.bGv = true;
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        it3.next();
                        Runnable runnable2 = gVar.sHb;
                    }
                }
            }
        }
    }

    public final void R(Runnable runnable) {
        synchronized (this.lock) {
            g gVar = (g) runnable;
            Iterator it = this.sKX.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Iterator it2 = new ArrayList(this.sKY).iterator();
                    while (it2.hasNext()) {
                        ((c) it2.next()).B(gVar.sHb);
                    }
                }
            }
            int activeCount = this.sKS.getActiveCount();
            int size = this.sKS.getQueue().size();
            int corePoolSize = this.sKS.getCorePoolSize();
            if (activeCount == 1 && size == 0) {
                if (corePoolSize > 0) {
                    this.sKT = cjx();
                    this.sKS.setCorePoolSize(0);
                    this.sKS.setMaximumPoolSize(this.sKT + 2);
                }
                Iterator it3 = new ArrayList(this.sKY).iterator();
                while (it3.hasNext()) {
                    it3.next();
                }
                this.bGv = false;
            }
        }
    }

    public static void a(c cVar) {
        cjw().b(cVar);
    }

    private void b(c cVar) {
        synchronized (this.lock) {
            if (!this.sKY.contains(cVar)) {
                this.sKY.add(cVar);
            }
        }
    }

    public static void c(c cVar) {
        e cjw = cjw();
        synchronized (cjw.lock) {
            cjw.sKY.remove(cVar);
        }
    }

    public static void post(Runnable runnable, String str) {
        cjw().c(runnable, str, 5);
    }

    public static void b(Runnable runnable, String str, int i) {
        cjw().c(runnable, str, i);
    }

    private void c(Runnable runnable, String str, int i) {
        synchronized (this.lock) {
            g gVar = new g(runnable, str, i, true, sLh);
            this.sKV.add(gVar);
            this.sKW.add(gVar);
            this.sKZ.sendEmptyMessage(1);
            lk(false);
        }
    }

    public static void a(Runnable runnable, String str) {
        e cjw = cjw();
        synchronized (cjw.lock) {
            Object gVar = new g(runnable, str, Integer.MAX_VALUE, true, sLh);
            cjw.sKW.add(gVar);
            cjw.sKS.execute(gVar);
            if (cjw.sKS.getActiveCount() < cjw.sKT || cjw.sKT >= cjx() * 2) {
                cjw.cjy();
            } else {
                cjw.sKT++;
                cjw.sKS.setCorePoolSize(cjw.sKT);
                cjw.sKS.setMaximumPoolSize(cjw.sKT);
                x.i("MicroMsg.ThreadPool", "|MMThreadPool postAtFront expand core pool size=" + cjw.sKT);
            }
            Iterator it = new ArrayList(cjw.sKY).iterator();
            while (it.hasNext()) {
                it.next();
                Runnable runnable2 = gVar.sHb;
            }
            cjw.lk(false);
        }
    }

    public static void S(Runnable runnable) {
        e cjw = cjw();
        synchronized (cjw.lock) {
            Thread T = cjw.T(runnable);
            if (T != null) {
                T.interrupt();
            } else {
                cjw.Z(runnable);
            }
        }
    }

    private Thread T(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        synchronized (this.lock) {
            Iterator it = this.sKX.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    obj = (g) it.next();
                    if (obj != null && obj.sHb.equals(runnable)) {
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Thread thread = (Thread) this.sKX.get(obj);
                    return thread;
                }
            }
            return null;
        }
    }

    public static void U(Runnable runnable) {
        cjw().V(runnable);
    }

    private void V(Runnable runnable) {
        Assert.assertNotNull("join arg runnable is null!", runnable);
        Object obj = null;
        synchronized (this.lock) {
            if (Y(runnable)) {
                obj = new a(runnable);
                b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (this.sKY.contains(obj)) {
                    runnable.wait();
                } else {
                    x.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static void W(Runnable runnable) {
        int i = 1;
        e cjw = cjw();
        Assert.assertNotNull("join arg runnable is null!", runnable);
        if (5000 < 0) {
            throw new IllegalArgumentException();
        }
        int i2;
        if (5000 >= 9223372036854L) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (5000 != 0) {
            i = 0;
        }
        if ((i | i2) != 0) {
            cjw.V(runnable);
            return;
        }
        Object obj = null;
        synchronized (cjw.lock) {
            if (cjw.Y(runnable)) {
                obj = new a(runnable);
                cjw().b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (cjw.sKY.contains(obj)) {
                    runnable.wait(5000, 0);
                } else {
                    x.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static boolean X(Runnable runnable) {
        return cjw().Y(runnable);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Y(java.lang.Runnable r6) {
        /*
        r5 = this;
        r2 = 1;
        r1 = 0;
        if (r6 != 0) goto L_0x0006;
    L_0x0004:
        r0 = r1;
    L_0x0005:
        return r0;
    L_0x0006:
        r3 = r5.lock;
        monitor-enter(r3);
        r0 = r5.sKW;	 Catch:{ all -> 0x0052 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0052 }
        if (r4 == 0) goto L_0x002a;
    L_0x0011:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x002a;
    L_0x0017:
        r0 = r4.next();	 Catch:{ all -> 0x0052 }
        r0 = (com.tencent.mm.sdk.f.g) r0;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0011;
    L_0x001f:
        r0 = r0.sHb;	 Catch:{ all -> 0x0052 }
        r0 = r0.equals(r6);	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0011;
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r2;
        goto L_0x0005;
    L_0x002a:
        r0 = r5.sKX;	 Catch:{ all -> 0x0052 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0052 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0052 }
        if (r4 == 0) goto L_0x004f;
    L_0x0036:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x004f;
    L_0x003c:
        r0 = r4.next();	 Catch:{ all -> 0x0052 }
        r0 = (com.tencent.mm.sdk.f.g) r0;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0036;
    L_0x0044:
        r0 = r0.sHb;	 Catch:{ all -> 0x0052 }
        r0 = r0.equals(r6);	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0036;
    L_0x004c:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r2;
        goto L_0x0005;
    L_0x004f:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r1;
        goto L_0x0005;
    L_0x0052:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.f.e.Y(java.lang.Runnable):boolean");
    }

    public static boolean remove(Runnable runnable) {
        return cjw().Z(runnable);
    }

    private boolean Z(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        synchronized (this.lock) {
            Iterator it = this.sKW.iterator();
            if (it != null) {
                Runnable runnable2;
                while (it.hasNext()) {
                    runnable2 = (g) it.next();
                    if (runnable2 != null && runnable2.sHb.equals(runnable)) {
                        it.remove();
                        break;
                    }
                }
                runnable2 = null;
                if (runnable2 != null) {
                    this.sKS.remove(runnable2);
                    return true;
                }
            }
            return false;
        }
    }

    private void cjy() {
        if (this.sKS.getCorePoolSize() < this.sKT) {
            this.sKS.setCorePoolSize(this.sKT);
            this.sKS.setMaximumPoolSize(this.sKT);
        }
    }

    public static void cjz() {
        cjw().lk(true);
    }

    private void lk(boolean z) {
        if (z) {
            synchronized (this.lock) {
                x.i("MicroMsg.ThreadPool", "------------------------------------------");
                Iterator it = this.sKV.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        x.i("MicroMsg.ThreadPool", "|MMThreadPool adding task{" + ((g) it.next()) + "}");
                    }
                }
                x.i("MicroMsg.ThreadPool", "-----------");
                it = this.sKW.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        x.i("MicroMsg.ThreadPool", "|MMThreadPool waiting task{" + ((g) it.next()) + "}");
                    }
                }
                x.i("MicroMsg.ThreadPool", "-----------");
                it = this.sKX.keySet().iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        x.i("MicroMsg.ThreadPool", "|MMThreadPool running task{" + ((g) it.next()) + "}");
                    }
                }
                x.i("MicroMsg.ThreadPool", "-----------");
                x.i("MicroMsg.ThreadPool", "|MMThreadPool poolSize=" + this.sKS.getPoolSize() + "|activeCount=" + this.sKS.getActiveCount() + "|corePoolSize=" + this.sKS.getPoolSize() + "|largestPoolSize=" + this.sKS.getLargestPoolSize() + "|maximuPoolSize=" + this.sKS.getMaximumPoolSize());
                x.i("MicroMsg.ThreadPool", "------------------------------------------");
            }
        }
    }

    private static b cjA() {
        if (sLf == null) {
            sLf = new b(sLh);
        }
        return sLf;
    }

    public static Thread b(Runnable runnable, String str) {
        return cjA().a(runnable, str, 5);
    }

    public static Thread d(Runnable runnable, String str, int i) {
        return cjA().a(runnable, str, i);
    }

    private static a cjB() {
        if (sLg == null) {
            sLg = new a(sLh);
        }
        return sLg;
    }

    public static HandlerThread Xs(String str) {
        cjB();
        return a.cY(str, 0);
    }

    public static HandlerThread cZ(String str, int i) {
        cjB();
        return a.cY(str, i);
    }
}
