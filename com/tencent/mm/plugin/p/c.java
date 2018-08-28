package com.tencent.mm.plugin.p;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c implements b, com.tencent.mm.kernel.b.c {
    private static c kny;

    private c() {
    }

    public static synchronized c aWC() {
        c cVar;
        synchronized (c.class) {
            if (kny == null) {
                kny = new c();
            }
            cVar = kny;
        }
        return cVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"image/", "image2/", "sfs", "bizmsg/"});
        return linkedList;
    }

    public static String Gb() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("image/").toString();
    }

    public static String Gc() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("image2/").toString();
    }

    public static String aWD() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("sfs").toString();
    }

    public static String aWE() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("bizmsg/").toString();
    }
}
