package com.tencent.mm.plugin.card.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.protocal.c.abr;
import com.tencent.mm.protocal.c.abs;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.protocal.c.ma;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ad extends l implements k {
    private final b diG;
    private e diJ;
    public boolean hxk = false;

    public ad(double d, double d2, int i) {
        a aVar = new a();
        aVar.dIG = new abr();
        aVar.dIH = new abs();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardslayout";
        aVar.dIF = 984;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        abr abr = (abr) this.diG.dID.dIL;
        abr.latitude = d;
        abr.longitude = d2;
        abr.scene = i;
        abr.rGo = (String) g.Ei().DT().get(aa.a.sPR, null);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardsLayout", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        abs abs = (abs) this.diG.dIE.dIL;
        x.v("MicroMsg.NetSceneGetCardsLayout", "json:" + abs.hwU);
        if (i2 == 0 && i3 == 0) {
            boolean z;
            g.Ei().DT().a(aa.a.sPR, abs.rGo);
            String str2 = abs.hwU;
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = (String) g.Ei().DT().get(aa.a.sPQ, null);
            if (!bi.oW(str3)) {
                str2 = str3;
            }
            abv xU = j.xU(str2);
            am.axi().diF.fV("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 , label_wording='' where stickyIndex>0");
            if (xU == null) {
                x.w("MicroMsg.CardStickyHelper", "[doUpdateStickyInfoLogic] resp null");
                z = false;
            } else {
                int i4;
                z = false;
                if (xU.rGr != null) {
                    ma maVar = xU.rGr;
                    Map hashMap = new HashMap();
                    hashMap.put("expiring_list", Integer.valueOf(2));
                    hashMap.put("member_card_list", Integer.valueOf(2));
                    hashMap.put("nearby_list", Integer.valueOf(3));
                    hashMap.put("first_list", Integer.valueOf(5));
                    if (xU.rGu == 100) {
                        hashMap.put("expiring_list", Integer.valueOf(4));
                    } else if (xU.rGu == i$l.AppCompatTheme_checkboxStyle) {
                        hashMap.put("member_card_list", Integer.valueOf(4));
                    } else if (xU.rGu == i$l.AppCompatTheme_buttonStyleSmall) {
                        hashMap.put("nearby_list", Integer.valueOf(4));
                    }
                    long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
                    if (xU.rGr.rqj == null || xU.rGr.rqj.rqi == null || xU.rGr.rqj.rqi.size() <= 0) {
                        i4 = 0;
                    } else {
                        z = true;
                        j.b(xU.rGr.rqj.rqi, (((Integer) hashMap.get("expiring_list")).intValue() * 100000) + 3);
                        i4 = xU.rGr.rqj.rqi.size() + 0;
                    }
                    if (!(xU.rGr.rqk == null || xU.rGr.rqk.rqi == null || xU.rGr.rqk.rqi.size() <= 0)) {
                        z = true;
                        j.b(xU.rGr.rqk.rqi, (((Integer) hashMap.get("member_card_list")).intValue() * 100000) + 2);
                        i4 += xU.rGr.rqk.rqi.size();
                    }
                    if (!(xU.rGr.rql == null || xU.rGr.rql.rqi == null || xU.rGr.rql.rqi.size() <= 0)) {
                        z = true;
                        j.b(xU.rGr.rql.rqi, (((Integer) hashMap.get("nearby_list")).intValue() * 100000) + 1);
                        i4 += xU.rGr.rql.rqi.size();
                    }
                    if (!(xU.rGr.rqm == null || xU.rGr.rqm.rqi == null || xU.rGr.rqm.rqi.size() <= 0)) {
                        z = true;
                        i4 += xU.rGr.rqm.rqi.size();
                        j.c(xU.rGr.rqm.rqi, 0);
                    }
                    if (!(xU.rGr.rqn == null || xU.rGr.rqn.rqi == null || xU.rGr.rqn.rqi.size() <= 0)) {
                        z = true;
                        int intValue = (((Integer) hashMap.get("first_list")).intValue() * 100000) + 4;
                        j.b(xU.rGr.rqn.rqi, intValue);
                        j.c(xU.rGr.rqn.rqi, intValue);
                        i4 += xU.rGr.rqn.rqi.size();
                    }
                    g.Ei().dqq.gp(dO);
                } else {
                    i4 = 0;
                }
                am.axn().putValue("key_get_card_layout_resp", xU);
                g.Ei().DT().a(aa.a.sPZ, str2);
                if (i4 > 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(36);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(37);
                    iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(38);
                    iDKey3.SetValue((long) i4);
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(40);
                    iDKey4.SetValue((long) (((int) (currentTimeMillis2 - currentTimeMillis)) / i4));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    h.mEJ.b(arrayList, true);
                }
            }
            this.hxk = z;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 984;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
