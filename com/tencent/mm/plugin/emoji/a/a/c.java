package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c implements Cloneable, Iterable<f> {
    HashMap<String, ao> ieu;
    protected HashMap<String, ao> iev;
    public boolean iew;
    protected ArrayList<f> mItemList;

    public void clear() {
        if (this.mItemList != null) {
            this.mItemList.clear();
            this.mItemList = null;
        }
        if (this.ieu != null) {
            this.ieu.clear();
            this.ieu = null;
        }
        if (this.iev != null) {
            this.iev.clear();
            this.iev = null;
        }
    }

    public c(f fVar) {
        this(fVar == null ? null : fVar.ihq);
    }

    public c() {
        this.ieu = new HashMap();
        this.iev = new HashMap();
        this.iew = q.GR();
    }

    public c(List<f> list) {
        this();
        if (list != null) {
            this.mItemList = new ArrayList();
            this.mItemList.addAll(list);
        }
    }

    public final int size() {
        return this.mItemList == null ? 0 : this.mItemList.size();
    }

    public final f oJ(int i) {
        if (this.mItemList == null || this.mItemList.size() <= i || i < 0 || this.mItemList == null) {
            return null;
        }
        return (f) this.mItemList.get(i);
    }

    public final f za(String str) {
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                ts tsVar = fVar.iez;
                if (tsVar != null && tsVar.rem != null && tsVar.rem.equals(str)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    /* renamed from: aDE */
    public final c clone() {
        try {
            c cVar = (c) super.clone();
            try {
                if (this.mItemList == null) {
                    return cVar;
                }
                cVar.mItemList = (ArrayList) this.mItemList.clone();
                return cVar;
            } catch (CloneNotSupportedException e) {
                return cVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public void notifyDataSetChanged() {
        if (this.mItemList != null) {
            this.iev = i.aEA().igy.cnk();
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                ts tsVar = fVar.iez;
                if (tsVar != null) {
                    if (a.d(tsVar)) {
                        fVar.setStatus(a.aFS() ? 7 : 3);
                    } else {
                        String str = tsVar.rem;
                        fVar.a(this.iew, ze(str), zc(str));
                    }
                }
            }
            aDF();
        }
    }

    public final void zb(String str) {
        f za = za(str);
        if (za != null) {
            za.setStatus(-1);
            za.a(this.iew, ze(str), zc(str));
        }
    }

    public final boolean zc(String str) {
        return this.iev == null ? false : this.iev.containsKey(str);
    }

    public final ao zd(String str) {
        ao ze = ze(str);
        if (ze != null) {
            return ze;
        }
        ze = new ao(str);
        this.ieu.put(str, ze);
        return ze;
    }

    public final ao ze(String str) {
        return (ao) this.ieu.get(str);
    }

    public Iterator<f> iterator() {
        return new a(this, (byte) 0);
    }

    public void aDF() {
        if (this.mItemList != null && i.aEC().iho != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                ts tsVar = fVar.iez;
                if (tsVar != null) {
                    Integer num = (Integer) i.aEC().iho.get(tsVar.rem);
                    int intValue = num == null ? -1 : num.intValue();
                    if (intValue >= 0) {
                        fVar.setStatus(6);
                        fVar.pF = intValue;
                    }
                    if (intValue < 0 && fVar.mStatus == 6) {
                        fVar.setStatus(3);
                    }
                }
            }
        }
    }
}
