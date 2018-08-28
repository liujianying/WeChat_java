package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.bnr;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.protocal.c.zs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends c {
    private static int jkw = 7200;
    private String mac;
    private String ssid;

    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new zr();
        aVar.dIH = new zs();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
        aVar.dIF = 1726;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1726;
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        aOR();
        this.ssid = str;
        this.mac = str2;
        cr crVar = new cr();
        crVar.mac = str2;
        crVar.ssid = str;
        zr zrVar = (zr) this.diG.dID.dIL;
        zrVar.appId = str3;
        zrVar.jkW = str4;
        zrVar.jkX = str5;
        zrVar.jkY = str6;
        zrVar.bJT = str7;
        zrVar.sign = str8;
        zrVar.rFz = crVar;
    }

    protected final void b(int i, int i2, int i3, String str) {
        int i4;
        c cVar;
        c Cg = j.aOK().Cg(this.ssid);
        if (Cg == null) {
            Cg = new c();
            Cg.field_ssidmd5 = ac.ce(this.ssid);
            i4 = 1;
            cVar = Cg;
        } else {
            i4 = 0;
            cVar = Cg;
        }
        boolean b;
        if (i2 == 0 && i3 == 0) {
            zs zsVar = (zs) this.diG.dIE.dIL;
            cVar.field_ssid = this.ssid;
            cVar.field_showUrl = zsVar.qZl;
            bnr bnr = zsVar.qZm;
            if (bnr != null) {
                x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[]{bnr.slK, bnr.slL, bnr.slM});
                cVar.field_showWordCn = bnr.slL;
                cVar.field_showWordEn = bnr.slK;
                cVar.field_showWordTw = bnr.slM;
            } else {
                cVar.field_showWordCn = ad.getContext().getResources().getString(R.l.free_wifi_verified);
                cVar.field_showWordEn = ad.getContext().getResources().getString(R.l.free_wifi_verified);
                cVar.field_showWordTw = ad.getContext().getResources().getString(R.l.free_wifi_verified);
            }
            cVar.field_action = zsVar.qZk;
            cVar.field_verifyResult = 1;
            cVar.field_connectState = -1;
            if (zsVar.qZu <= 0) {
                zsVar.qZu = jkw;
            }
            cVar.field_expiredTime = bi.VE() + ((long) zsVar.qZu);
            cVar.field_mac = this.mac;
            if (i4 != 0) {
                b = j.aOK().b(cVar);
                x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
            } else {
                b = j.aOK().c(cVar, new String[0]);
                x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
            }
            j.aOK().Ch(this.ssid);
            return;
        }
        x.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
        if (i4 == 0) {
            b = j.aOK().a(cVar, new String[0]);
            x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(b)});
        }
    }

    public final ep aOY() {
        return ((zs) this.diG.dIE.dIL).jng;
    }
}
