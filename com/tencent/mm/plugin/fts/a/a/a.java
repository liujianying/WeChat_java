package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a implements Comparable<a> {
    public boolean fE = false;
    public long jrn = 0;
    public long jro = 0;
    public List<a> jrp;
    public Object jrq;
    public int mPriority = Integer.MAX_VALUE;

    public abstract boolean execute();

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.mPriority - ((a) obj).mPriority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public boolean isCancelled() {
        return this.fE;
    }

    public int getId() {
        return -1;
    }

    public final void CA(String str) {
        if (this.jrp == null) {
            this.jrp = new ArrayList();
        }
        a aVar = new a(this);
        aVar.jrr = str;
        aVar.timestamp = System.currentTimeMillis();
        this.jrp.add(aVar);
    }

    public String getName() {
        return "";
    }

    public String afC() {
        return "";
    }
}
