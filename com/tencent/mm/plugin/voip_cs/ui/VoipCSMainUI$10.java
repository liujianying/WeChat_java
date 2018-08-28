package com.tencent.mm.plugin.voip_cs.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class VoipCSMainUI$10 extends a {
    final /* synthetic */ VoipCSMainUI oYm;

    VoipCSMainUI$10(VoipCSMainUI voipCSMainUI) {
        this.oYm = voipCSMainUI;
    }

    public final void ev(int i) {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from " + i);
        if (b.bMw().oXs != 2) {
            return;
        }
        if (i == 4 || i == 6) {
            d bMw = b.bMw();
            v2protocal v2protocal = b.bMv().kqx;
            if (bMw.oKh == 0) {
                bMw.oKh = v2protocal.oOj;
            }
            int netType = com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext());
            if (netType != bMw.oKh) {
                x.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + bMw.oKh + " to " + netType);
                try {
                    byte[] bArr = new byte[4];
                    bArr[0] = (byte) netType;
                    int appCmd = v2protocal.setAppCmd(ao.CTRL_BYTE, bArr, 4);
                    if (appCmd < 0) {
                        x.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + v2protocal.kpw + ", roomkey=" + v2protocal.kpp + "]");
                    }
                    bxi bxi = new bxi();
                    bxi.stM = 3;
                    bxi.stN = new com.tencent.mm.bk.b(bArr, 0, 1);
                    v2protocal.SendRUDP(bxi.toByteArray(), bxi.toByteArray().length);
                } catch (Exception e) {
                    x.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
                }
                bMw.oKh = netType;
            }
            bMw = b.bMw();
            x.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + b.bMv().kqx.oOl + "roomkey:" + b.bMv().kqx.kpp);
            au.DF().a(g.CTRL_INDEX, bMw);
            v2protocal v2protocal2 = b.bMv().kqx;
            au.DF().a(new com.tencent.mm.plugin.voip_cs.b.c.d(v2protocal2.oOl, v2protocal2.kpp), 0);
        }
    }
}
