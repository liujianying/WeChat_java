package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class aj {
    public static final List<Integer> a;
    private ConcurrentHashMap<lb, an> b = new ConcurrentHashMap();

    static {
        List arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(Integer.valueOf(5));
        a.add(Integer.valueOf(10));
        a.add(Integer.valueOf(50));
        a.add(Integer.valueOf(100));
        a.add(Integer.valueOf(200));
        a.add(Integer.valueOf(500));
        a.add(Integer.valueOf(BaseReportManager.MAX_READ_COUNT));
        a.add(Integer.valueOf(2000));
        a.add(Integer.valueOf(3000));
    }

    public an a(lb lbVar) {
        an anVar = (an) this.b.get(lbVar);
        if (anVar != null) {
            return anVar;
        }
        anVar = new an(a);
        this.b.putIfAbsent(lbVar, anVar);
        return anVar;
    }

    public void a(lb lbVar, int i) {
        a(lbVar).a((long) i, 2);
    }

    public void a(lb lbVar, long j, int i) {
        if (i == 0) {
            a(lbVar).a(j, 0);
        } else if (i == 1) {
            a(lbVar).a(j, 1);
        } else if (i == 2) {
            a(lbVar).a(j, 2);
        }
    }

    public ConcurrentHashMap<lb, an> a() {
        return this.b;
    }
}
