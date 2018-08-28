package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g {
    private static Map<String, d> uRG = new ConcurrentHashMap();
    private static Map<Looper, d> uRH = new HashMap();
    private static boolean uRI = false;

    static {
        cBN();
    }

    public static void a(String str, d dVar) {
        Assert.assertNotNull("Scheduler type is null", str);
        String toUpperCase = str.toUpperCase();
        if (uRG.containsKey(toUpperCase)) {
            IllegalStateException illegalStateException = new IllegalStateException("Fatal error! Duplicate scheduler type " + str.toUpperCase());
        }
        uRG.put(toUpperCase, dVar);
        if (dVar instanceof h) {
            synchronized (g.class) {
                uRH.put(((h) dVar).mLooper, dVar);
            }
        }
    }

    public static void abF(String str) {
        uRG.remove(str.toUpperCase());
    }

    public static d abG(String str) {
        Assert.assertNotNull("Scheduler type is null", str);
        d dVar = (d) uRG.get(str.toUpperCase());
        Assert.assertNotNull("Scheduler type not found: " + str.toUpperCase(), dVar);
        return dVar;
    }

    public static synchronized d cBM() {
        d cVar;
        synchronized (g.class) {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                a.w("Vending.SchedulerProvider", "This is not a handler thread! %s", Thread.currentThread());
                cVar = new c();
            } else {
                cVar = (d) uRH.get(myLooper);
                if (cVar == null) {
                    cVar = new h(myLooper, myLooper.toString());
                    uRH.put(myLooper, cVar);
                }
            }
        }
        return cVar;
    }

    static synchronized void cBN() {
        synchronized (g.class) {
            if (!uRI) {
                a.i("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
                uRI = true;
                a("Vending.UI", d.uRC);
                a("Vending.LOGIC", d.uRD);
                a("Vending.HEAVY_WORK", d.uRE);
            }
        }
    }
}
