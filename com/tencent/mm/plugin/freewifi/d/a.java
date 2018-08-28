package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.aa;
import com.tencent.mm.protocal.c.ab;
import com.tencent.mm.protocal.c.bdp;
import com.tencent.mm.protocal.c.bnr;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a extends c {
    private static int jkw = 7200;
    private int bNI;
    private String mac;
    private String ssid;

    protected final void aOR() {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new aa();
        aVar.dIH = new ab();
        aVar.uri = "/cgi-bin/micromsg-bin/apauth";
        aVar.dIF = 640;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 640;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        aOR();
        this.ssid = str2;
        this.mac = str3;
        aa aaVar = (aa) this.diG.dID.dIL;
        String decode = URLDecoder.decode(str5);
        aaVar.qZc = 0;
        aaVar.URL = str;
        aaVar.SSID = str2;
        aaVar.qYZ = str4;
        aaVar.qZa = decode;
        aaVar.qZb = str6;
        aaVar.qZe = i;
        aaVar.qZf = str7;
        LinkedList linkedList = new LinkedList();
        cr crVar = new cr();
        crVar.ssid = str2;
        crVar.mac = str3;
        linkedList.add(crVar);
        aaVar.qZd = linkedList;
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[]{str, str2, str4, str3, str5, decode, str6});
    }

    public a(String str, String str2, String str3, int i, int i2, String str4) {
        aOR();
        this.ssid = str3;
        this.mac = str2;
        this.bNI = 1;
        LinkedList linkedList = new LinkedList();
        cr crVar = new cr();
        crVar.ssid = str3;
        crVar.mac = str2;
        crVar.rcO = i;
        linkedList.add(crVar);
        aa aaVar = (aa) this.diG.dID.dIL;
        aaVar.qZc = 1;
        aaVar.qZd = linkedList;
        aaVar.URL = str;
        aaVar.qZe = i2;
        aaVar.qZf = str4;
        aaVar.qZh = m.BU("MicroMsg.FreeWifi.NetSceneAPAuth");
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[]{Integer.valueOf(1), str2, str3, Integer.valueOf(i)});
    }

    public a(String str, int i, String str2) {
        aOR();
        this.bNI = 4;
        aa aaVar = (aa) this.diG.dID.dIL;
        aaVar.qZc = 4;
        aaVar.URL = str;
        aaVar.qZe = i;
        aaVar.qZf = str2;
        aaVar.qZg = m.aOg();
        aaVar.qZd = new LinkedList();
        cr crVar = new cr();
        crVar.ssid = m.BS("MicroMsg.FreeWifi.NetSceneAPAuth");
        crVar.mac = m.BT("MicroMsg.FreeWifi.NetSceneAPAuth");
        aaVar.qZd.add(crVar);
        aaVar.qZh = m.BU("MicroMsg.FreeWifi.NetSceneAPAuth");
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[]{Integer.valueOf(aaVar.qZg), crVar.ssid, crVar.mac});
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[]{Integer.valueOf(4), str});
    }

    protected final void b(int i, int i2, int i3, String str) {
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.bNI)});
        c Cg;
        Object obj;
        Object obj2;
        ab abVar;
        bnr bnr;
        switch (this.bNI) {
            case 0:
                if (i2 == 0 && i3 == 0) {
                    Cg = j.aOK().Cg(this.ssid);
                    String str2 = "MicroMsg.FreeWifi.NetSceneAPAuth";
                    String str3 = "get freewifi by ssid :%s, is wifi info = null ? %b";
                    Object[] objArr = new Object[2];
                    objArr[0] = this.ssid;
                    objArr[1] = Boolean.valueOf(Cg == null);
                    x.i(str2, str3, objArr);
                    obj = null;
                    if (Cg == null) {
                        obj = 1;
                        Cg = new c();
                        Cg.field_ssidmd5 = ac.ce(this.ssid);
                    }
                    obj2 = obj;
                    Cg.field_wifiType = 1;
                    abVar = (ab) this.diG.dIE.dIL;
                    bnr = abVar.qZm;
                    if (bnr != null) {
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{bnr.slK, bnr.slL, bnr.slM});
                        Cg.field_showWordCn = bnr.slL;
                        Cg.field_showWordEn = bnr.slK;
                        Cg.field_showWordTw = bnr.slM;
                    } else {
                        Cg.field_showWordCn = ad.getContext().getResources().getString(R.l.free_wifi_verified);
                        Cg.field_showWordEn = ad.getContext().getResources().getString(R.l.free_wifi_verified);
                        Cg.field_showWordTw = ad.getContext().getResources().getString(R.l.free_wifi_verified);
                    }
                    Cg.field_action = abVar.qZk;
                    Cg.field_verifyResult = 1;
                    Cg.field_connectState = -1;
                    if (abVar.qZu <= 0) {
                        abVar.qZu = jkw;
                    }
                    Cg.field_expiredTime = bi.VE() + ((long) abVar.qZu);
                    Cg.field_showUrl = abVar.qZl;
                    Cg.field_action = abVar.qZk;
                    Cg.field_ssid = this.ssid;
                    Cg.field_mac = this.mac;
                    Cg.field_wifiType = 1;
                    boolean b;
                    if (obj2 != null) {
                        b = j.aOK().b(Cg);
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Boolean.valueOf(b), Integer.valueOf(abVar.qZj), Integer.valueOf(abVar.qZk), abVar.qZl});
                        return;
                    }
                    b = j.aOK().c(Cg, new String[0]);
                    x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Boolean.valueOf(b), Integer.valueOf(abVar.qZj), Integer.valueOf(abVar.qZk), abVar.qZl});
                    return;
                }
                return;
            case 1:
                Cg = j.aOK().Cg(this.ssid);
                obj = null;
                if (Cg == null) {
                    obj = 1;
                    Cg = new c();
                    Cg.field_ssidmd5 = ac.ce(this.ssid);
                }
                obj2 = obj;
                boolean b2;
                if (i2 == 0 && i3 == 0) {
                    abVar = (ab) this.diG.dIE.dIL;
                    Cg.field_ssid = this.ssid;
                    Cg.field_showUrl = abVar.qZl;
                    bnr = abVar.qZm;
                    x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Integer.valueOf(abVar.qZj), Integer.valueOf(abVar.qZk), abVar.qZl});
                    if (bnr != null) {
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{bnr.slK, bnr.slL, bnr.slM});
                        Cg.field_showWordCn = bnr.slL;
                        Cg.field_showWordEn = bnr.slK;
                        Cg.field_showWordTw = bnr.slM;
                    } else {
                        Cg.field_showWordCn = ad.getContext().getResources().getString(R.l.free_wifi_verified);
                        Cg.field_showWordEn = ad.getContext().getResources().getString(R.l.free_wifi_verified);
                        Cg.field_showWordTw = ad.getContext().getResources().getString(R.l.free_wifi_verified);
                    }
                    Cg.field_action = abVar.qZk;
                    Cg.field_verifyResult = 1;
                    Cg.field_connectState = -1;
                    if (abVar.qZu <= 0) {
                        abVar.qZu = jkw;
                    }
                    Cg.field_expiredTime = bi.VE() + ((long) abVar.qZu);
                    Cg.field_mac = this.mac;
                    if (obj2 != null) {
                        b2 = j.aOK().b(Cg);
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b2)});
                    } else {
                        b2 = j.aOK().c(Cg, new String[0]);
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b2)});
                    }
                    j.aOK().Ch(this.ssid);
                    return;
                }
                x.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
                if (obj2 == null) {
                    b2 = j.aOK().a(Cg, new String[0]);
                    x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(b2)});
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final String aOS() {
        ab abVar = (ab) this.diG.dIE.dIL;
        if (abVar != null) {
            return abVar.qZi;
        }
        return null;
    }

    public final bdp aOT() {
        ab abVar = (ab) this.diG.dIE.dIL;
        if (abVar != null) {
            return abVar.qZp;
        }
        return null;
    }

    public final boolean aOU() {
        ab abVar = (ab) this.diG.dIE.dIL;
        if (abVar == null || abVar.qZq == null) {
            return false;
        }
        if (abVar.qZq.qZg == 1) {
            return true;
        }
        return false;
    }

    public final xq aOV() {
        ab abVar = (ab) this.diG.dIE.dIL;
        if (abVar != null) {
            return abVar.qZq;
        }
        return null;
    }

    public final String aOW() {
        ab abVar = (ab) this.diG.dIE.dIL;
        if (abVar != null) {
            return abVar.qZs;
        }
        return null;
    }

    public final String aOX() {
        ab abVar = (ab) this.diG.dIE.dIL;
        if (abVar != null) {
            return abVar.qZt;
        }
        return null;
    }

    public final ep aOY() {
        ab abVar = (ab) this.diG.dIE.dIL;
        if (abVar != null) {
            return abVar.qZr;
        }
        return null;
    }
}
