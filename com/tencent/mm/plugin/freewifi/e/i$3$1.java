package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.e.i.3;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.x;

class i$3$1 implements e {
    final /* synthetic */ 3 jld;

    i$3$1(3 3) {
        this.jld = 3;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.E(this.jld.jlb.intent), Integer.valueOf(m.F(this.jld.jlb.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
        a aOa = k.aOa();
        aOa.ssid = this.jld.jlb.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol33");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol33");
        aOa.bIQ = this.jld.jlb.bIQ;
        aOa.jid = m.E(this.jld.jlb.intent);
        aOa.jie = m.G(this.jld.jlb.intent);
        aOa.jif = b.jiu.jiQ;
        aOa.jig = b.jiu.name;
        aOa.bVU = m.H(this.jld.jlb.intent);
        aOa.result = i2;
        aOa.hKX = str;
        aOa.aOc().aOb();
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        FreeWifiFrontPageUI.a aVar;
        if (i == 0 && i2 == 0) {
            ep aOY = ((f) lVar).aOY();
            if (aOY != null) {
                x.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{aOY.rbW, aOY.hcS, aOY.hbL, Integer.valueOf(aOY.rfa), aOY.rfb, aOY.eJK, aOY.rfc});
                FreeWifiFrontPageUI freeWifiFrontPageUI2 = this.jld.jlb.jkG;
                d dVar2 = d.jnk;
                FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                bVar.jng = aOY;
                freeWifiFrontPageUI2.a(dVar2, bVar);
                return;
            }
            freeWifiFrontPageUI = this.jld.jlb.jkG;
            dVar = d.jnj;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.jmI = m.a(this.jld.jlb.jkI, b.jiu, 20);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else if (i2 == -30032) {
            Intent intent = new Intent();
            intent.putExtra("free_wifi_error_ui_error_msg", this.jld.jlb.jkG.getString(R.l.free_wifi_errmsg_33_invalid_sign_warnning));
            intent.setClass(this.jld.jlb.jkG, FreeWifiErrorUI.class);
            this.jld.jlb.jkG.finish();
            this.jld.jlb.jkG.startActivity(intent);
        } else {
            freeWifiFrontPageUI = this.jld.jlb.jkG;
            dVar = d.jnj;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.glH = R.l.free_wifi_connect_fail_tips;
            aVar.jmI = m.a(this.jld.jlb.jkI, b.jiu, i2);
            freeWifiFrontPageUI.a(dVar, aVar);
        }
    }
}
