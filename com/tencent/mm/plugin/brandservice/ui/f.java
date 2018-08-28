package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.protocal.c.ju;
import java.util.Iterator;
import java.util.List;

public final class f extends c {
    List<bfp> hpR = null;
    private SparseArray<a> hpS = new SparseArray();
    private int hpT;

    public f(Context context) {
        super(context);
        setReporter(new 1(this));
    }

    public final void d(String str, List<ju> list) {
        super.d(str, list);
        this.hpT = super.getCount();
    }

    public final void a(ju juVar, boolean z) {
        super.a(juVar, z);
        if (this.hpT == 0) {
            this.hpT = super.getCount();
        }
    }

    public final int getCount() {
        int count = super.getCount();
        if (count != 0 || this.hpR == null) {
            return count;
        }
        Iterator it = this.hpR.iterator();
        while (true) {
            int i = count;
            if (!it.hasNext()) {
                return i;
            }
            bfp bfp = (bfp) it.next();
            if (!(bfp == null || bfp.sgP == null)) {
                i += bfp.sgP.size();
            }
            count = i;
        }
    }

    public final void auT() {
        super.auT();
    }

    /* renamed from: nx */
    public final com.tencent.mm.ui.base.sortview.a getItem(int i) {
        int count = super.getCount();
        if (count != 0) {
            return super.nx(i);
        }
        a aVar = (a) this.hpS.get(i);
        if (aVar != null || this.hpR.size() <= 0) {
            return aVar;
        }
        String bhz;
        Object obj;
        for (bfp bfp : this.hpR) {
            if (count == i) {
                bhz = bfp.sgN == null ? null : bfp.sgN.toString();
                obj = (bju) bfp.sgP.get(0);
            } else if (i < bfp.sgP.size() + count) {
                bju obj2 = (bju) bfp.sgP.get(i - count);
                bhz = null;
                break;
            } else {
                count = bfp.sgP.size() + count;
            }
        }
        bhz = null;
        obj2 = null;
        b bVar = new b(obj2, bhz);
        bVar.ny(i);
        bVar.setPosition(i);
        this.hpS.put(i, bVar);
        return bVar;
    }

    protected final Object[] nv(int i) {
        c.a ns = ns(i);
        ju nt = nt(i);
        if (ns == null) {
            return super.nv(i);
        }
        Object[] objArr = new Object[4];
        objArr[0] = this;
        objArr[1] = ns.hoB;
        objArr[2] = Integer.valueOf(i < this.hpT ? 39 : 56);
        objArr[3] = nt != null ? nt.rlo : "";
        return objArr;
    }
}
