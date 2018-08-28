package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public final class ax extends BaseAdapter implements x {
    private static HashMap<Long, a> oeh = new HashMap();
    private boolean dpK = false;
    av oef;
    public aw oeg;

    public final /* bridge */ /* synthetic */ Vending bCc() {
        return this.oeg;
    }

    public ax(MMActivity mMActivity, ListView listView, b bVar, j jVar, String str) {
        this.oef = new av(mMActivity, listView, bVar, jVar, this);
        this.oef.nTx = true;
        this.oeg = new aw();
        aw awVar = this.oeg;
        av avVar = this.oef;
        awVar.mContext = mMActivity;
        awVar.odV = avVar;
        awVar.ocI = str;
        g.Ek();
        awVar.dDg = ((i) g.l(i.class)).FR();
        aw awVar2 = this.oeg;
        a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[]{Integer.valueOf(10)});
        awVar2.uQb = 10;
        this.oeg.addVendingDataChangedCallback(new 1(this));
    }

    public final void kS() {
        if (!this.dpK) {
            this.dpK = true;
            this.oeg.notifyVendingDataChangeSynchronize();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.oef.h(i, view);
    }

    public final int getViewTypeCount() {
        return 14;
    }

    public final int getItemViewType(int i) {
        return this.oef.getItemViewType(i);
    }

    public final void bCb() {
        this.oeg.notifyVendingDataChange();
    }

    /* renamed from: xi */
    public final n getItem(int i) {
        ay ayVar = (ay) this.oeg.get(i);
        if (ayVar == null) {
            return null;
        }
        return ayVar.nhc;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getCount() {
        return this.oeg.mCount;
    }

    public static void D(n nVar) {
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (!oeh.containsKey(Long.valueOf(j))) {
                a aVar = new a();
                if (nVar.bAJ() != null && nVar.bAJ().sqc != null && nVar.bAJ().sqc.ruz == 1 && nVar.bAJ().sqc.ruA != null && nVar.bAJ().sqc.ruA.size() > 0) {
                    aVar.dzO = nVar.bAJ().sqc.ruA.size();
                    aVar.oej = new HashSet();
                    aVar.oek = new HashSet();
                    aVar.oel = new HashSet();
                    aVar.oem = new HashSet();
                    aVar.id = nVar.bAJ().ksA;
                    aVar.oer = nVar.bAJ().csE;
                    try {
                        boy n = aj.n(nVar);
                        aVar.oep = n.smJ;
                        aVar.oeq = n.smM;
                    } catch (Exception e) {
                        aVar.oep = 0;
                        aVar.oeq = 0;
                    }
                    try {
                        g.Ek();
                        aVar.juJ = ((i) g.l(i.class)).bcY().GT(nVar.field_userName);
                        long currentTimeMillis = System.currentTimeMillis();
                        g.Ek();
                        aVar.oeo = (currentTimeMillis - ((i) g.l(i.class)).bcY().GZ(nVar.field_userName)) / 1000;
                    } catch (Exception e2) {
                        aVar.juJ = 0;
                        aVar.oeo = 0;
                    }
                    oeh.put(Long.valueOf(j), aVar);
                }
            }
        }
    }

    public static void b(n nVar, int i) {
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (oeh.containsKey(Long.valueOf(j))) {
                a aVar = (a) oeh.get(Long.valueOf(j));
                if (aVar.oen == 0) {
                    aVar.oen = i + 1;
                }
                if (aVar.oej == null) {
                    aVar.oej = new HashSet();
                }
                aVar.oej.add(Integer.valueOf(i + 1));
            }
        }
    }

    public static void c(n nVar, int i) {
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (oeh.containsKey(Long.valueOf(j))) {
                a aVar = (a) oeh.get(Long.valueOf(j));
                if (aVar.oek == null) {
                    aVar.oek = new HashSet();
                }
                if (!aVar.oek.contains(Integer.valueOf(i + 1))) {
                    aVar.oek.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void d(n nVar, int i) {
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (oeh.containsKey(Long.valueOf(j))) {
                a aVar = (a) oeh.get(Long.valueOf(j));
                if (aVar.oel == null) {
                    aVar.oel = new HashSet();
                }
                if (!aVar.oel.contains(Integer.valueOf(i + 1))) {
                    aVar.oel.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void e(n nVar, int i) {
        if (nVar != null) {
            long j = nVar.field_snsId;
            if (oeh.containsKey(Long.valueOf(j))) {
                a aVar = (a) oeh.get(Long.valueOf(j));
                if (aVar.oem == null) {
                    aVar.oem = new HashSet();
                }
                if (!aVar.oem.contains(Integer.valueOf(i + 1))) {
                    aVar.oem.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void bEm() {
        for (Entry value : oeh.entrySet()) {
            String str;
            String str2;
            String str3;
            a aVar = (a) value.getValue();
            aVar.networkType = com.tencent.mm.plugin.sns.data.i.bxa();
            x.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[]{Integer.valueOf(aVar.dzO), Integer.valueOf(aVar.oej.size()), Integer.valueOf(aVar.oen), Integer.valueOf(aVar.networkType), aVar.id});
            String str4 = "";
            Iterator it = aVar.oek.iterator();
            while (true) {
                str = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = str + ((Integer) it.next()) + "|";
            }
            if (str.length() >= 2) {
                str = str.substring(0, str.length() - 1);
            }
            str4 = "";
            Iterator it2 = aVar.oel.iterator();
            while (true) {
                str2 = str4;
                if (!it2.hasNext()) {
                    break;
                }
                str4 = str2 + ((Integer) it2.next()) + "|";
            }
            if (str2.length() >= 2) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            str4 = "";
            Iterator it3 = aVar.oem.iterator();
            while (true) {
                str3 = str4;
                if (!it3.hasNext()) {
                    break;
                }
                str4 = str3 + ((Integer) it3.next()) + "|";
            }
            if (str3.length() >= 2) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            h.mEJ.h(11599, new Object[]{Integer.valueOf(aVar.dzO), Integer.valueOf(aVar.oej.size()), Integer.valueOf(aVar.oen), Integer.valueOf(aVar.networkType), Integer.valueOf(0), aVar.id, Long.valueOf(aVar.oeo), Integer.valueOf(aVar.juJ), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aVar.oep), Integer.valueOf(aVar.oeq), Integer.valueOf(0), str, str2, str3, Integer.valueOf(0), "", Integer.valueOf(aVar.oer)});
        }
        oeh.clear();
    }
}
