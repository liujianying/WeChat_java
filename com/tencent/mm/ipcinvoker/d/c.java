package com.tencent.mm.ipcinvoker.d;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static volatile c dmV;
    Map<String, List<e>> dmW = new ConcurrentHashMap();

    public static c Cy() {
        if (dmV == null) {
            synchronized (c.class) {
                if (dmV == null) {
                    dmV = new c();
                }
            }
        }
        return dmV;
    }

    private c() {
    }

    public final boolean c(String str, Bundle bundle) {
        if (str == null || str.length() == 0) {
            return false;
        }
        List list = (List) this.dmW.get(str);
        if (list == null || list.isEmpty()) {
            return true;
        }
        synchronized (list) {
            List<e> arrayList = new ArrayList(list);
        }
        for (e at : arrayList) {
            at.at(bundle);
        }
        return true;
    }

    public final boolean a(String str, e eVar) {
        if (str == null || str.length() == 0) {
            return false;
        }
        List list = (List) this.dmW.get(str);
        if (list == null) {
            list = new LinkedList();
            this.dmW.put(str, list);
        }
        if (list.contains(eVar)) {
            return false;
        }
        boolean add;
        synchronized (list) {
            add = list.add(eVar);
        }
        return add;
    }

    public final boolean b(String str, e eVar) {
        if (str == null || str.length() == 0) {
            return false;
        }
        List list = (List) this.dmW.get(str);
        if (list == null) {
            return false;
        }
        boolean remove;
        synchronized (list) {
            remove = list.remove(eVar);
        }
        if (list.isEmpty()) {
            this.dmW.remove(str);
        }
        return remove;
    }
}
