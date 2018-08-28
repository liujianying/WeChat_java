package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ak {
    private static ak e = new ak();
    private aj a = new aj();
    private ConcurrentHashMap<aq, aj> b = new ConcurrentHashMap();
    private ConcurrentHashMap<aq, ConcurrentLinkedQueue<li>> c = new ConcurrentHashMap();
    private CopyOnWriteArrayList<Integer> d = new CopyOnWriteArrayList();

    public static ak a() {
        return e;
    }

    private ak() {
        this.d.addAll(aj.a);
    }

    public aj a(aq aqVar) {
        aj ajVar = (aj) this.b.get(aqVar);
        if (ajVar != null) {
            return ajVar;
        }
        ajVar = new aj();
        this.b.putIfAbsent(aqVar, ajVar);
        return ajVar;
    }

    public aj b(aq aqVar) {
        aj ajVar = (aj) this.b.get(aqVar);
        if (ajVar == null) {
            return a(aqVar);
        }
        return ajVar;
    }

    public void c(aq aqVar) {
        for (Entry value : b(aqVar).a().entrySet()) {
            ((an) value.getValue()).a(this.d);
        }
    }

    public void a(aq aqVar, String str, String str2, am amVar) {
        if (amVar.a(8)) {
            li liVar = amVar.m;
            if (liVar != null) {
                liVar.f = str;
                liVar.b = str2;
                this.c.putIfAbsent(aqVar, new ConcurrentLinkedQueue());
                if (((ConcurrentLinkedQueue) this.c.get(aqVar)).size() > BaseReportManager.MAX_READ_COUNT) {
                    ax.b("can not add sample for" + aqVar.taf_proxyName() + ", queue size>1000");
                } else {
                    ((ConcurrentLinkedQueue) this.c.get(aqVar)).add(liVar);
                }
            }
        }
    }
}
