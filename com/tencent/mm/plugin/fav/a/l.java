package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.protocal.c.wv;
import com.tencent.mm.protocal.c.ww;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class l {
    public HashMap<String, WeakReference<a>> dRX = new HashMap();
    public wx iWd = new wx();
    private HashSet<Integer> iWe = new HashSet();
    private boolean iWf = true;
    private List<wv> iWg = new LinkedList();

    public l() {
        try {
            this.iWd.aG(bi.WP((String) g.Ei().DT().get(225283, "")));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            x.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[]{e.getMessage()});
            this.iWd = new wx();
        }
        x.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[]{this.iWd.rBV});
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.dRX.put(aVar.toString(), new WeakReference(aVar));
        }
    }

    private void eM(boolean z) {
        for (WeakReference weakReference : this.dRX.values()) {
            if (!(weakReference == null || weakReference.get() == null)) {
                if (z) {
                    ((a) weakReference.get()).aLo();
                } else {
                    ((a) weakReference.get()).aLp();
                }
            }
        }
    }

    private void save() {
        byte[] toByteArray;
        try {
            toByteArray = this.iWd.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            x.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[]{e.getMessage()});
            toByteArray = null;
        }
        g.Em().H(new Runnable() {
            public final void run() {
                g.Ei().DT().set(225283, bi.bE(toByteArray));
            }

            public final String toString() {
                return super.toString() + "|save";
            }
        });
        this.iWf = true;
    }

    public final List<wv> pK(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        if (this.iWf) {
            x.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
            this.iWg.clear();
            Iterator it = this.iWd.rBV.iterator();
            while (it.hasNext()) {
                this.iWg.addAll(((ww) it.next()).rBU);
            }
            this.iWf = false;
        }
        x.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[]{Integer.valueOf(this.iWg.size())});
        return this.iWg;
    }

    public final int aLn() {
        int i = 0;
        Iterator it = this.iWd.rBV.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((ww) it.next()).rBU.size() + i2;
        }
    }

    public final void Bm(String str) {
        if (!bi.oW(str)) {
            if (this.iWe.contains(Integer.valueOf(str.hashCode()))) {
                x.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[]{str});
                return;
            }
            this.iWe.add(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                x.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[]{str});
                ah.A(new 2(this, str));
                return;
            }
            x.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[]{str});
            Bn(str);
        }
    }

    final void Bn(String str) {
        int i;
        ww wwVar;
        ww wwVar2;
        wv wvVar;
        int i2 = 0;
        String oI = h.oI(str.toLowerCase());
        if (oI == null || oI.length() <= 0) {
            i = 35;
        } else {
            i = oI.charAt(0);
        }
        Iterator it = this.iWd.rBV.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            wwVar = (ww) it.next();
            if (wwVar.rBT == i) {
                break;
            } else if (wwVar.rBT > i) {
                wwVar = new ww();
                wwVar.rBT = i;
                this.iWd.rBV.add(i3, wwVar);
                break;
            } else {
                i3++;
            }
        }
        wwVar = null;
        if (wwVar == null) {
            wwVar = new ww();
            wwVar.rBT = i;
            this.iWd.rBV.add(wwVar);
            wwVar2 = wwVar;
        } else {
            wwVar2 = wwVar;
        }
        Iterator it2 = wwVar2.rBU.iterator();
        while (it2.hasNext()) {
            int compareTo;
            wvVar = (wv) it2.next();
            i3 = wvVar.rBS.compareTo(oI);
            if (i3 == 0) {
                compareTo = wvVar.qdu.compareTo(str);
            } else {
                compareTo = i3;
            }
            if (compareTo != 0) {
                if (compareTo > 0) {
                    wvVar = new wv();
                    wvVar.qdu = str;
                    wvVar.rBS = oI;
                    wwVar2.rBU.add(i2, wvVar);
                    save();
                    eM(true);
                    return;
                }
                i2++;
            } else {
                return;
            }
        }
        wvVar = new wv();
        wvVar.qdu = str;
        wvVar.rBS = oI;
        wwVar2.rBU.add(wvVar);
        eM(true);
        save();
    }

    public final void v(g gVar) {
        if (gVar != null) {
            for (String removeTag : gVar.field_tagProto.rBX) {
                removeTag(removeTag);
            }
        }
    }

    public final void f(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            x.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[]{set});
            for (String removeTag : set) {
                removeTag(removeTag);
            }
        }
    }

    private void removeTag(final String str) {
        if (!bi.oW(str)) {
            this.iWe.remove(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                x.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[]{str});
                ah.A(new Runnable() {
                    public final void run() {
                        l.this.Bo(str);
                    }
                });
                return;
            }
            x.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[]{str});
            Bo(str);
        }
    }

    final void Bo(String str) {
        char c;
        ww wwVar;
        String oI = h.oI(str.toLowerCase());
        if (oI == null || oI.length() <= 0) {
            c = '#';
        } else {
            c = oI.charAt(0);
        }
        Iterator it = this.iWd.rBV.iterator();
        int i = 0;
        while (it.hasNext()) {
            ww wwVar2 = (ww) it.next();
            if (wwVar2.rBT == c) {
                wwVar = wwVar2;
                break;
            } else if (wwVar2.rBT <= c) {
                i++;
            } else {
                return;
            }
        }
        wwVar = null;
        if (wwVar != null) {
            Iterator it2 = wwVar.rBU.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                wv wvVar = (wv) it2.next();
                int compareTo = wvVar.rBS.compareTo(oI);
                if (compareTo == 0) {
                    compareTo = wvVar.qdu.compareTo(str);
                }
                if (compareTo == 0) {
                    if (!((ae) g.n(ae.class)).getFavSearchStorage().Bt(wvVar.qdu)) {
                        wwVar.rBU.remove(i2);
                        if (wwVar.rBU.isEmpty()) {
                            this.iWd.rBV.remove(i);
                        }
                        eM(false);
                        save();
                        return;
                    }
                    return;
                } else if (compareTo <= 0) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
