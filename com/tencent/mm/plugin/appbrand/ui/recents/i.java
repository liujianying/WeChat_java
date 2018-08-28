package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.q.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

final class i extends ArrayList<k> {
    private final ArrayList<k> gAx = new ArrayList(10);
    private final ArrayList<k> gAy = new ArrayList(HardCoderJNI.sHCDBDELAY_WRITE);

    i() {
    }

    static i e(ArrayList<k> arrayList, ArrayList<k> arrayList2) {
        i iVar = new i();
        e.d(iVar.gAx, arrayList);
        e.d(iVar.gAy, arrayList2);
        return iVar;
    }

    final synchronized ArrayList<k> aom() {
        return this.gAx;
    }

    final synchronized ArrayList<k> aon() {
        return this.gAy;
    }

    public final boolean addAll(Collection<? extends k> collection) {
        boolean z = false;
        if (i.class.isInstance(collection)) {
            synchronized (this) {
                i iVar = (i) collection;
                this.gAx.addAll(iVar.gAx);
                this.gAy.addAll(iVar.gAy);
                z = true;
            }
        } else {
            Assert.assertTrue("collection type mismatch!!", false);
        }
        return z;
    }

    /* renamed from: aoo */
    public final synchronized i clone() {
        i iVar;
        iVar = new i();
        iVar.gAx.addAll(this.gAx);
        iVar.gAy.addAll(this.gAy);
        return iVar;
    }

    public final synchronized int size() {
        return this.gAx.size() + this.gAy.size();
    }

    private synchronized k lK(int i) {
        k kVar;
        if (i < this.gAx.size()) {
            kVar = (k) this.gAx.get(i);
        } else {
            kVar = (k) this.gAy.get(i - this.gAx.size());
        }
        return kVar;
    }

    /* renamed from: lL */
    public final synchronized k remove(int i) {
        k kVar;
        if (i < this.gAx.size()) {
            kVar = (k) this.gAx.remove(i);
        } else {
            kVar = (k) this.gAy.remove(i - this.gAx.size());
        }
        return kVar;
    }

    public final synchronized void clear() {
        this.gAx.clear();
        this.gAy.clear();
    }

    public final Iterator<k> iterator() {
        Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
        return new 1(this);
    }
}
