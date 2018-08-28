package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static volatile a fxq;
    public Map<String, List<IPCDynamicPageView>> fxr = new ConcurrentHashMap();
    public Map<String, a> fxs = new ConcurrentHashMap();

    private a() {
    }

    public static a afs() {
        if (fxq == null) {
            synchronized (a.class) {
                if (fxq == null) {
                    fxq = new a();
                }
            }
        }
        return fxq;
    }

    public final IPCDynamicPageView sH(String str) {
        if (str == null) {
            return null;
        }
        for (Entry entry : this.fxr.entrySet()) {
            if (entry.getValue() != null) {
                for (IPCDynamicPageView iPCDynamicPageView : (List) entry.getValue()) {
                    if (iPCDynamicPageView.getExtId() != null && iPCDynamicPageView.getExtId().equals(str)) {
                        return iPCDynamicPageView;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public final boolean b(String str, IPCDynamicPageView iPCDynamicPageView) {
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            return false;
        }
        List list = (List) this.fxr.get(str);
        if (list == null) {
            return false;
        }
        boolean remove;
        synchronized (list) {
            remove = list.remove(iPCDynamicPageView);
        }
        if (list.isEmpty()) {
            this.fxr.remove(str);
        }
        return remove;
    }

    public final boolean c(String str, IPCDynamicPageView iPCDynamicPageView) {
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            return false;
        }
        List list;
        List list2 = (List) this.fxr.get(str);
        if (list2 == null) {
            LinkedList linkedList = new LinkedList();
            this.fxr.put(str, linkedList);
            list = linkedList;
        } else {
            list = list2;
        }
        if (list.contains(iPCDynamicPageView)) {
            synchronized (list) {
                list.remove(iPCDynamicPageView);
                list.add(iPCDynamicPageView);
            }
            return true;
        }
        boolean add = list.add(iPCDynamicPageView);
        if (list.size() > 4) {
            synchronized (list) {
                if (list.size() > 4) {
                    IPCDynamicPageView am = am(list);
                    if (am != null) {
                        a aVar = (a) this.fxs.get(str);
                        if (aVar != null) {
                            aVar.a(str, am);
                        }
                    }
                }
            }
        }
        return add;
    }

    private static IPCDynamicPageView am(List<IPCDynamicPageView> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            if (((IPCDynamicPageView) list.get(i2)).isPaused()) {
                return (IPCDynamicPageView) list.remove(i2);
            }
            i = i2 + 1;
        }
    }
}
