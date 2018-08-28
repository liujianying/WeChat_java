package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements e {
    final /* synthetic */ b jmu;
    final /* synthetic */ String jmv;
    final /* synthetic */ String jmw;
    final /* synthetic */ String jmx;
    final /* synthetic */ String jmy;

    b$2(b bVar, String str, String str2, String str3, String str4) {
        this.jmu = bVar;
        this.jmv = str;
        this.jmw = str2;
        this.jmx = str3;
        this.jmy = str4;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.E(this.jmu.intent), Integer.valueOf(m.F(this.jmu.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
        a aOa;
        if (i == 0 && i2 == 0) {
            aOa = k.aOa();
            aOa.bIQ = this.jmu.bIQ;
            aOa.jid = m.E(this.jmu.intent);
            aOa.jif = b.jiA.jiQ;
            aOa.jig = b.jiA.name;
            aOa.bVU = this.jmu.bVU;
            aOa.result = i2;
            aOa.hKX = str;
            aOa.aOc().b(this.jmu.intent, false).aOb();
            i iVar = (i) lVar;
            String aPc = iVar.aPc();
            if (m.isEmpty(aPc)) {
                x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", new Object[]{m.E(this.jmu.intent), Integer.valueOf(m.F(this.jmu.intent))});
                this.jmu.Ci(this.jmu.activity.getString(R.l.free_wifi_errmsg_retry));
                aOa = k.aOa();
                aOa.bIQ = this.jmu.bIQ;
                aOa.jid = m.E(this.jmu.intent);
                aOa.jif = b.jiB.jiQ;
                aOa.jig = b.jiB.name;
                aOa.bVU = this.jmu.bVU;
                aOa.jie = m.G(this.jmu.intent);
                aOa.result = -1;
                aOa.hKX = "31 auth url is empty.";
                aOa.aOc().b(this.jmu.intent, true).aOb();
                return;
            }
            String BR = m.BR(iVar.aPd());
            String BR2 = m.BR(this.jmv);
            String BR3 = m.BR(this.jmw);
            StringBuilder stringBuilder = new StringBuilder(aPc);
            if (aPc.indexOf("?") != -1) {
                stringBuilder.append("&extend=").append(BR);
            } else {
                stringBuilder.append("?extend=").append(BR);
            }
            stringBuilder.append("&openId=").append(BR2).append("&tid=").append(BR3).append("&timestamp=").append(m.BR(this.jmx)).append("&sign=").append(m.BR(this.jmy));
            x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", new Object[]{m.E(this.jmu.intent), Integer.valueOf(m.F(this.jmu.intent)), stringBuilder.toString()});
            this.jmu.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", stringBuilder.toString());
            this.jmu.intent.setClass(this.jmu.activity, FreeWifiFrontPageUI.class);
            this.jmu.activity.startActivity(this.jmu.intent);
            this.jmu.activity.finish();
            this.jmu.activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
            aOa = k.aOa();
            aOa.bIQ = this.jmu.bIQ;
            aOa.jid = m.E(this.jmu.intent);
            aOa.jif = b.jiB.jiQ;
            aOa.jig = b.jiB.name;
            aOa.bVU = this.jmu.bVU;
            aOa.jie = m.G(this.jmu.intent);
            aOa.result = 0;
            aOa.hKX = "";
            aOa.aOc().b(this.jmu.intent, true).aOb();
            return;
        }
        aOa = k.aOa();
        aOa.bIQ = this.jmu.bIQ;
        aOa.jid = m.E(this.jmu.intent);
        aOa.jif = b.jiA.jiQ;
        aOa.jig = b.jiA.name;
        aOa.bVU = this.jmu.bVU;
        aOa.jie = m.G(this.jmu.intent);
        aOa.result = i2;
        aOa.hKX = str;
        aOa.aOc().b(this.jmu.intent, true).aOb();
        if (m.cD(i, i2) && !m.isEmpty(str)) {
            this.jmu.Ci(str + "(" + m.a(m.G(this.jmu.intent), b.jiA, i2) + ")");
        } else if (m.isEmpty(str)) {
            this.jmu.Ci(this.jmu.activity.getString(R.l.free_wifi_errmsg_retry));
        } else {
            this.jmu.Ci(str);
        }
    }
}
