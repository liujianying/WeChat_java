package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.ac;
import com.tencent.mm.protocal.c.ad;
import com.tencent.mm.protocal.c.bnr;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends c {
    private static int jkw = 7200;
    public String mac;
    private String ssid;

    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new ac();
        aVar.dIH = new ad();
        aVar.uri = "/cgi-bin/mmo2o-bin/apcheck";
        aVar.dIF = 1744;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1744;
    }

    public b(String str, String str2, int i, int i2) {
        aOR();
        this.ssid = str2;
        this.mac = str;
        LinkedList linkedList = new LinkedList();
        cr crVar = new cr();
        crVar.ssid = str2;
        crVar.mac = str;
        crVar.rcO = i;
        linkedList.add(crVar);
        ac acVar = (ac) this.diG.dID.dIL;
        acVar.qZv = com.tencent.mm.plugin.freewifi.h.b.aNY().aNS();
        acVar.qZd = linkedList;
        acVar.qZw = m.aOi();
        acVar.qZx = i2;
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[]{str, str2, Integer.valueOf(i)});
    }

    protected final void b(int i, int i2, int i3, String str) {
        ad adVar;
        int i4;
        boolean z;
        c cVar;
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (!(this.diG == null || this.diG.dIE.dIL == null)) {
            com.tencent.mm.plugin.freewifi.h.b.aNY().a((ad) this.diG.dIE.dIL);
            if (m.cC(i2, i3) || m.cD(i2, i3)) {
                adVar = (ad) this.diG.dIE.dIL;
                i4 = adVar.qZA;
                z = adVar.qZz;
                if (!(i4 == 0 || i4 == i.a.aNZ().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
                    i.a.aNZ().bo("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", i4);
                }
                if (z) {
                    i.a.aNZ().C("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
                }
            }
        }
        c Cg = j.aOK().Cg(this.ssid);
        if (Cg == null) {
            Cg = new c();
            Cg.field_ssidmd5 = com.tencent.mm.sdk.platformtools.ac.ce(this.ssid);
            i4 = 1;
            cVar = Cg;
        } else {
            i4 = 0;
            cVar = Cg;
        }
        if (i2 == 0 && i3 == 0) {
            adVar = (ad) this.diG.dIE.dIL;
            cVar.field_ssid = this.ssid;
            cVar.field_showUrl = adVar.qZl;
            bnr bnr = adVar.qZm;
            if (bnr != null) {
                x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{bnr.slK, bnr.slL, bnr.slM});
                cVar.field_showWordCn = bnr.slL;
                cVar.field_showWordEn = bnr.slK;
                cVar.field_showWordTw = bnr.slM;
            } else {
                cVar.field_showWordCn = com.tencent.mm.sdk.platformtools.ad.getContext().getResources().getString(R.l.free_wifi_verified);
                cVar.field_showWordEn = com.tencent.mm.sdk.platformtools.ad.getContext().getResources().getString(R.l.free_wifi_verified);
                cVar.field_showWordTw = com.tencent.mm.sdk.platformtools.ad.getContext().getResources().getString(R.l.free_wifi_verified);
            }
            cVar.field_action = adVar.qZk;
            cVar.field_verifyResult = 1;
            cVar.field_connectState = -1;
            if (adVar.qZu <= 0) {
                adVar.qZu = jkw;
            }
            cVar.field_expiredTime = bi.VE() + ((long) adVar.qZu);
            cVar.field_mac = this.mac;
            if (i4 != 0) {
                z = j.aOK().b(cVar);
                x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(z)});
            } else {
                z = j.aOK().c(cVar, new String[0]);
                x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(z)});
            }
            j.aOK().Ch(this.ssid);
            return;
        }
        x.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
        if (i4 == 0) {
            z = j.aOK().a(cVar, new String[0]);
            x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(z)});
        }
    }
}
