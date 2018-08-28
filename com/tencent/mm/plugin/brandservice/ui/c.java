package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c extends b {
    protected int fdx;
    protected b hoA;
    protected String hoo;
    protected int hoq;
    private List<a> hot = new ArrayList();
    private int hou;
    private boolean hov;
    protected boolean how;
    protected boolean hox;
    int hoy;
    protected long[] hoz;

    public c(Context context) {
        super(context);
        t(true, true);
        this.hov = true;
        e(1);
    }

    public void d(String str, List<ju> list) {
        this.hot.clear();
        this.tDD.clear();
        ah.A(this.tDE);
        this.hou = 0;
        this.hoo = str;
        if (list != null) {
            this.hoy = (int) (System.currentTimeMillis() / 1000);
            for (int i = 0; i < list.size(); i++) {
                ju juVar = (ju) list.get(i);
                if (!(juVar == null || juVar.jQF == null || juVar.jQF.size() <= 0)) {
                    a a = a(juVar);
                    this.hou += a(a);
                    this.hot.add(a);
                    x.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[]{Long.valueOf(a.bHu), Integer.valueOf(a.count), Integer.valueOf(this.hou)});
                }
            }
            auS();
        }
        ah.A(this.tDE);
    }

    private a a(ju juVar) {
        a aVar = new a();
        aVar.hoF = new LinkedList();
        aVar.hoF.add(juVar);
        aVar.bHu = juVar.rll;
        aVar.count = juVar.jQF.size();
        aVar.dYU = juVar.rlm;
        aVar.hoC = new LinkedList();
        aVar.hoC.addAll(juVar.jQF);
        aVar.hoB = juVar.rln;
        aVar.hoD = this.hox;
        boolean z = this.how && aVar.dYU != 0;
        aVar.hoE = z;
        return aVar;
    }

    public void a(ju juVar, boolean z) {
        if ((this.hov && juVar == null) || juVar.jQF == null) {
            x.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
            return;
        }
        if (isEmpty()) {
            this.hoy = (int) (System.currentTimeMillis() / 1000);
        }
        a ca = ca(juVar.rll);
        if (ca != null) {
            if (ca.hoC == null) {
                ca.hoC = new LinkedList();
            }
            ca.hoC.addAll(juVar.jQF);
            if (ca.hoF == null) {
                ca.hoF = new LinkedList();
            }
            ca.hoF.add(juVar);
            ca.count += juVar.jQF.size();
            this.hou += juVar.jQF.size();
        } else if (z) {
            this.hot.add(a(juVar));
            auS();
        } else {
            x.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[]{Long.valueOf(juVar.rll)});
            return;
        }
        ah.A(this.tDE);
    }

    final a ca(long j) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.hot.size()) {
                i = -1;
                break;
            } else if (((a) this.hot.get(i)).bHu == j) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i >= 0) {
            return (a) this.hot.get(i);
        }
        return null;
    }

    protected final a ns(int i) {
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i3 >= this.hot.size()) {
                    break;
                }
                a aVar = (a) this.hot.get(i3);
                if (i < i4 + a(aVar)) {
                    return aVar;
                }
                i2 = i3 + 1;
            }
        }
        return null;
    }

    protected final ju nt(int i) {
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.hot.size()) {
                a aVar = (a) this.hot.get(i3);
                int a = a(aVar);
                i4 += a;
                if (i < i4) {
                    i4 = (aVar.hoD ? 1 : 0) + (i4 - a);
                    while (i2 < aVar.hoF.size()) {
                        ju juVar = (ju) aVar.hoF.get(i2);
                        i4 += juVar.jQF.size();
                        if (i < i4) {
                            return juVar;
                        }
                        i2++;
                    }
                } else {
                    i3++;
                }
            }
        }
        return null;
    }

    private static int a(a aVar) {
        int i = 1;
        if (aVar == null) {
            return 0;
        }
        int i2 = (aVar.hoD ? 1 : 0) + aVar.count;
        if (!aVar.hoE) {
            i = 0;
        }
        return i2 + i;
    }

    private synchronized void auS() {
        boolean z = true;
        synchronized (this) {
            int i;
            a aVar;
            Map hashMap = new HashMap();
            for (i = 0; i < this.hot.size(); i++) {
                aVar = (a) this.hot.get(i);
                if (aVar != null) {
                    hashMap.put(Long.valueOf(aVar.bHu), aVar);
                }
            }
            this.hot.clear();
            this.hou = 0;
            for (long valueOf : this.hoz) {
                aVar = (a) hashMap.get(Long.valueOf(valueOf));
                if (aVar != null) {
                    this.hot.add(aVar);
                    this.hou = a(aVar) + this.hou;
                }
            }
            if (this.hot.size() > 0) {
                aVar = (a) this.hot.get(this.hot.size() - 1);
                if (aVar.hoE == this.hov) {
                    this.hou = (aVar.hoE ? -1 : 1) + this.hou;
                    if (this.hov) {
                        z = false;
                    }
                    aVar.hoE = z;
                }
            }
            hashMap.clear();
        }
    }

    public final void t(boolean z, boolean z2) {
        this.hox = z;
        this.how = z2;
    }

    public final void setScene(int i) {
        this.fdx = i;
    }

    public final void setAddContactScene(int i) {
        this.hoq = i;
    }

    public final void e(long... jArr) {
        if (jArr != null && jArr.length > 0) {
            this.hoz = jArr;
        }
    }

    public int getCount() {
        return this.hou;
    }

    public void auT() {
        d(null, null);
        this.hoy = 0;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    protected final a nu(int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.hot.size(); i4++) {
            a aVar = (a) this.hot.get(i4);
            int a = a(aVar);
            i3 += a;
            if (aVar.hoD && i == i3 - a) {
                ju juVar = aVar.hoF.size() == 0 ? null : (ju) aVar.hoF.get(0);
                if (juVar != null) {
                    return new d(juVar.bHD);
                }
            } else if (aVar.hoE && i == i3 - 1) {
                return new e(aVar.bHu, aVar.count, this.hoo);
            } else {
                if (i < i3) {
                    i4 = (i - i3) + aVar.count;
                    if (aVar.hoE) {
                        i2 = 1;
                    }
                    i2 += i4;
                    jz jzVar = (jz) aVar.hoC.get(i2);
                    long j = aVar.bHu;
                    b bVar = this.hoA;
                    if (jzVar == null) {
                        x.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
                        return null;
                    }
                    a aVar2;
                    if (j == 1) {
                        x.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
                        aVar2 = new a(jzVar);
                    } else {
                        aVar2 = j == 4 ? new g(jzVar) : j == 1073741824 ? new g(jzVar) : new g(jzVar);
                    }
                    if (!(aVar2 instanceof com.tencent.mm.plugin.brandservice.ui.base.a)) {
                        return aVar2;
                    }
                    com.tencent.mm.plugin.brandservice.ui.base.a aVar3 = (com.tencent.mm.plugin.brandservice.ui.base.a) aVar2;
                    aVar3.ny(i2);
                    aVar3.setPosition(i);
                    aVar3.setReporter(bVar);
                    return aVar2;
                }
            }
        }
        return new g(null);
    }

    protected Object[] nv(int i) {
        Object obj;
        a ns = ns(i);
        ju nt = nt(i);
        if (nt != null) {
            obj = nt.rlo;
        } else {
            String obj2 = "";
        }
        if (ns == null) {
            return null;
        }
        return new Object[]{this, ns.hoB, Integer.valueOf(this.hoq), obj2};
    }

    public final void setReporter(b bVar) {
        this.hoA = bVar;
    }
}
