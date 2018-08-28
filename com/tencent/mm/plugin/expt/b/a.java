package com.tencent.mm.plugin.expt.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.a.f;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.es;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.c.b;
import com.tencent.mm.plugin.expt.c.d;
import com.tencent.mm.plugin.expt.ui.ExptDebugUI;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a implements c, com.tencent.mm.plugin.expt.a.a {
    private static a iHP;
    private int dHP = 0;
    private int djl = 0;
    public d iHQ;
    public com.tencent.mm.plugin.expt.c.c iHR;
    private f<Integer, com.tencent.mm.plugin.expt.c.a> iHS = new f(20);
    private f<String, Integer> iHT = new f(20);
    private int iHU = 0;
    private com.tencent.mm.sdk.b.c iHV = new 1(this);
    private m iHW = new 2(this);
    private e iHX = new 3(this);

    static /* synthetic */ void c(a aVar) {
        if (!g.Eg().Dx()) {
            x.w("MicroMsg.ExptService", "account is not ready, don't get expt config");
        } else if (ad.cic()) {
            if (aVar.dHP <= 0) {
                aVar.dHP = ((Integer) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sZW, Integer.valueOf(0))).intValue();
            }
            if (aVar.djl <= 0) {
                aVar.djl = ((Integer) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sZV, Integer.valueOf(86400))).intValue();
                if (aVar.djl <= 3600) {
                    x.w("MicroMsg.ExptService", "interval is less than 1 hour, something warn here!!!");
                    aVar.djl = 3600;
                }
            }
            if (bi.bG((long) aVar.dHP) >= ((long) aVar.djl)) {
                aIw();
            }
        } else {
            x.w("MicroMsg.ExptService", "it is not mm process, why you call update expt?");
        }
    }

    static /* synthetic */ void d(a aVar) {
        aVar.djl = 0;
        aVar.dHP = 0;
    }

    final synchronized void aIt() {
        this.iHS.clear();
        this.iHT.clear();
    }

    public static a aIu() {
        if (iHP == null) {
            iHP = new a();
        }
        return iHP;
    }

    private a() {
    }

    public final void q(Context context, Intent intent) {
        intent.setClass(context, ExptDebugUI.class);
        context.startActivity(intent);
    }

    public final boolean a(com.tencent.mm.plugin.expt.a.a.a aVar, boolean z) {
        String a = a(aVar, "");
        if (bi.oW(a)) {
            return z;
        }
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        if (bi.getInt(a, i) != 0) {
            return true;
        }
        return false;
    }

    public final int a(com.tencent.mm.plugin.expt.a.a.a aVar) {
        String a = a(aVar, "");
        if (bi.oW(a)) {
            return 10;
        }
        return bi.getInt(a, 10);
    }

    private String a(com.tencent.mm.plugin.expt.a.a.a aVar, String str) {
        if (aVar == null) {
            return str;
        }
        int intValue;
        long VG = bi.VG();
        String name = aVar.name();
        Integer num = (Integer) this.iHT.get(name);
        if (num != null) {
            intValue = num.intValue();
        } else {
            int AD = this.iHR.AD(name);
            if (AD > 0) {
                this.iHT.put(name, Integer.valueOf(AD));
            }
            intValue = AD;
        }
        com.tencent.mm.g.b.a.m mVar = new com.tencent.mm.g.b.a.m();
        HashMap a = a(intValue, true, mVar);
        if (a == null || a.size() <= 0) {
            return str;
        }
        String str2 = (String) a.get(name);
        if (!bi.oW(str2)) {
            mVar.ciE = name;
            mVar.ciF = str2;
            mVar.RD();
        }
        x.i("MicroMsg.ExptService", "API Got Expt result[%s] exptId[%d] key[%s %s] defStr[%s] cost[%d]", new Object[]{str2, Integer.valueOf(intValue), aVar, name, str, Long.valueOf(bi.bI(VG))});
        if (bi.oW(str2)) {
            return str;
        }
        return str2;
    }

    public final com.tencent.mm.plugin.expt.c.a pn(int i) {
        com.tencent.mm.plugin.expt.c.a aVar = (com.tencent.mm.plugin.expt.c.a) this.iHS.get(Integer.valueOf(i));
        if (aVar == null) {
            aVar = this.iHQ.pp(i);
            if (aVar != null) {
                this.iHS.put(Integer.valueOf(i), aVar);
            }
        }
        return aVar;
    }

    public final HashMap<String, String> a(int i, boolean z, com.tencent.mm.g.b.a.m mVar) {
        if (this.iHQ == null) {
            x.e("MicroMsg.ExptService", "Expt service is not init here! exptId[%d]", new Object[]{Integer.valueOf(i)});
            return null;
        }
        long VG = bi.VG();
        HashMap<String, String> hashMap = null;
        Object obj = null;
        com.tencent.mm.plugin.expt.c.a pn = pn(i);
        if (pn == null || bi.oW(pn.field_exptContent)) {
            x.w("MicroMsg.ExptService", "expt item is null or expt content is null.");
        } else {
            String obj2;
            String str = pn.field_exptContent;
            if (z) {
                boolean z2 = false;
                if (pn.field_exptSeq < 0) {
                    z2 = false;
                } else {
                    long VE = bi.VE();
                    if (VE >= pn.field_startTime && (pn.field_endTime <= 0 || VE <= pn.field_endTime)) {
                        z2 = true;
                    }
                }
                x.d("MicroMsg.ExptItem", "expt item is ready[%b] [%s]", new Object[]{Boolean.valueOf(z2), pn.toString()});
                if (!z2) {
                    x.w("MicroMsg.ExptService", "expt time is invalid time[%d %d] seq[%d]", new Object[]{Long.valueOf(pn.field_startTime), Long.valueOf(pn.field_endTime), Integer.valueOf(pn.field_exptSeq)});
                    obj2 = str;
                }
            }
            hashMap = pn.aIF();
            if (mVar != null) {
                mVar.ciA = (long) pn.field_exptId;
                mVar.ciB = (long) pn.field_groupId;
                mVar.ciC = (long) pn.field_exptSeq;
                mVar.ap(pn.field_startTime).aq(pn.field_endTime);
            }
            obj2 = str;
        }
        String str2 = "MicroMsg.ExptService";
        String str3 = "get expt [%d] map[%s] expt[%s] cost[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = hashMap != null ? hashMap : Integer.valueOf(0);
        objArr[2] = obj2;
        objArr[3] = Long.valueOf(bi.bI(VG));
        x.i(str2, str3, objArr);
        return hashMap;
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        x.i("MicroMsg.ExptService", "onAccountInitialized, %d", new Object[]{Integer.valueOf(hashCode())});
        x.v("MicroMsg.ExptService", "add listener ");
        if (ad.cic()) {
            com.tencent.mm.sdk.b.a.sFg.a(this.iHV);
            g.DF().a(2738, this.iHX);
            ((o) g.n(o.class)).getSysCmdMsgExtension().a("expt", this.iHW);
        }
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.ExptService", "onAccountRelease");
        aIt();
        com.tencent.mm.sdk.b.a.sFg.c(this.iHV);
        g.DF().b(2738, this.iHX);
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("expt", this.iHW);
    }

    public final void AB(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.ExptService", "receive expt xml but content is null");
            return;
        }
        boolean z;
        com.tencent.mm.plugin.expt.c.a aVar = new com.tencent.mm.plugin.expt.c.a();
        if (aVar.AC(str)) {
            List arrayList;
            if (aVar.field_exptSeq < 0) {
                h.mEJ.a(863, 3, 1, false);
                arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(aVar.field_exptId));
                z = aV(arrayList) > 0;
            } else {
                h.mEJ.a(863, 4, 1, false);
                arrayList = new ArrayList();
                arrayList.add(aVar);
                z = aU(arrayList) > 0;
            }
            aIv();
        } else {
            z = false;
        }
        x.i("MicroMsg.ExptService", "received expt xml dbFlag[%b] [%s] ", new Object[]{Boolean.valueOf(z), str});
    }

    protected static void aIv() {
        com.tencent.mm.sdk.b.a.sFg.m(new es());
    }

    public final int aU(List<com.tencent.mm.plugin.expt.c.a> list) {
        if (list.size() <= 0) {
            return 0;
        }
        int aW;
        int aX;
        int i;
        List<com.tencent.mm.plugin.expt.c.a> aZ = this.iHQ.aZ(list);
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        if (aZ != null) {
            int size = aZ.size();
            for (com.tencent.mm.plugin.expt.c.a aVar : aZ) {
                this.iHS.put(Integer.valueOf(aVar.field_exptId), aVar);
                HashMap aIF = aVar.aIF();
                if (aIF != null) {
                    for (String str : aIF.keySet()) {
                        b AE = this.iHR.AE(str);
                        if (AE == null) {
                            AE = new b();
                            AE.field_exptId = aVar.field_exptId;
                            AE.field_exptKey = str;
                            linkedList2.add(AE);
                        } else if (AE.field_exptId != aVar.field_exptId) {
                            linkedList.add(AE);
                        }
                        b bVar = AE;
                        this.iHT.put(bVar.field_exptKey, Integer.valueOf(bVar.field_exptId));
                    }
                }
            }
            aW = this.iHR.aW(linkedList2);
            aX = this.iHR.aX(linkedList);
            i = size;
        } else {
            aX = 0;
            aW = 0;
            i = 0;
        }
        x.i("MicroMsg.ExptService", "replace ExptIds args[%d] db[%d] exptMap insert[list:%d  db:%d], update[list:%d db:%d]", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(i), Integer.valueOf(linkedList2.size()), Integer.valueOf(aW), Integer.valueOf(linkedList.size()), Integer.valueOf(aX)});
        return i;
    }

    public final int aV(List<Integer> list) {
        int aV = this.iHQ.aV(list);
        int aY = this.iHR.aY(list);
        x.i("MicroMsg.ExptService", "delete expt ids deleteCount[%d] deleteMapCount[%d]", new Object[]{Integer.valueOf(aV), Integer.valueOf(aY)});
        aIt();
        return aV;
    }

    public static void aIw() {
        g.DF().a(new b(), 0);
    }
}
