package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.e.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class e$1 implements e {
    final /* synthetic */ by hel;
    final /* synthetic */ e jjM;

    e$1(e eVar, by byVar) {
        this.jjM = eVar;
        this.hel = byVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "desc=net request [NetSceneCheckIfCallUp] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (m.cC(i, i2)) {
            long j = ((d) lVar).aOZ().rsk;
            if (j == 0) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "It cannot get time from server.");
                return;
            }
            e eVar = this.jjM;
            by byVar = this.hel;
            oa aOZ = ((d) lVar).aOZ();
            if (byVar == null || byVar.rcl == null) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                return;
            }
            String a = ab.a(byVar.rcl);
            x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[]{Long.valueOf(byVar.rcq), a});
            if (m.isEmpty(a)) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                return;
            }
            a BW = a.BW(a);
            if (BW == null) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                return;
            }
            Matcher matcher;
            com.tencent.mm.plugin.freewifi.f.a aVar = new com.tencent.mm.plugin.freewifi.f.a();
            aVar.jlq = BW.jjv;
            aVar.jls = BW.jjw;
            aVar.jlr = BW.bssid;
            aVar.jlw = BW.ssid;
            aVar.jlA = BW.jjy;
            aVar.jlu = BW.jju;
            aVar.jlt = BW.jjx;
            String BU = m.BU("MicroMsg.FreeWifi.FreeWifiMessageService");
            aVar.bIR = BU;
            aVar.jlv = BU.equals(BW.jju) ? 0 : 1;
            String BS = m.BS("MicroMsg.FreeWifi.FreeWifiMessageService");
            aVar.jlx = BS;
            aVar.jly = BS.equals(BW.ssid) ? 0 : 1;
            aVar.jlz = j;
            aVar.jlA = BW.jjy;
            int i3 = j > BW.jjy ? 1 : 0;
            aVar.jlB = i3 == 1 ? 1 : 0;
            aVar.jlF = aOZ.rsb;
            aVar.jlG = BS;
            boolean equals = BS.equals(aOZ.rsb);
            aVar.jlH = equals ? 1 : 0;
            aVar.jlC = 1;
            aVar.jlD = aOZ.rsj;
            CharSequence charSequence = BW.jjx;
            if (!m.isEmpty(charSequence)) {
                matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                if (matcher.find()) {
                    aVar.jlE = matcher.group(2);
                }
            }
            e.a(aVar);
            if (!equals) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "ssid has changed ! svr back ssid is not equal client ssid. ");
                return;
            } else if (i3 != 0) {
                x.e("MicroMsg.FreeWifi.FreeWifiMessageService", "Msg time expired. return.");
                return;
            } else if (aOZ.rsj == 0 && !m.isEmpty(charSequence)) {
                matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                if (matcher.find()) {
                    Object group = matcher.group(1);
                    try {
                        a = URLDecoder.decode(group, "utf8");
                        BU = matcher.group(2);
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_ap_key", a);
                        intent.putExtra("free_wifi_source", 5);
                        intent.putExtra("free_wifi_threeone_startup_type", 3);
                        intent.putExtra("free_wifi_schema_ticket", BU);
                        intent.putExtra("free_wifi_sessionkey", BU);
                        if (!eVar.jjL.equals(BU)) {
                            eVar.jjL = BU;
                            b.aPg();
                            b.J(intent);
                            return;
                        }
                        return;
                    } catch (UnsupportedEncodingException e) {
                        x.i("MicroMsg.FreeWifi.FreeWifiMessageService", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", new Object[]{"", Integer.valueOf(0), charSequence, group, e.getMessage()});
                        return;
                    }
                }
                return;
            } else {
                return;
            }
        }
        com.tencent.mm.plugin.freewifi.f.a aVar2 = new com.tencent.mm.plugin.freewifi.f.a();
        aVar2.jlp = i2;
        aVar2.jlo = i;
        e.a(aVar2);
    }
}
