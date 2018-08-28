package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.plugin.freewifi.d.e;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class b$1 implements Runnable {
    final /* synthetic */ int jlL;

    b$1(int i) {
        this.jlL = i;
    }

    public final void run() {
        if (b.yT()) {
            if (this.jlL == 0) {
                long currentTimeMillis = System.currentTimeMillis() - i$a.jhY.oX("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
                x.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : " + currentTimeMillis);
                if (currentTimeMillis < 0 || currentTimeMillis > 86400000) {
                    i$a.jhY.C("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
                } else {
                    x.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
                    return;
                }
            }
            b.aZ(false);
            f aOM = j.aOM();
            m.a("FreeWifiLog", f.jlO, aOM, "MicroMsg.FreeWifi.FreeWifiLogStorage");
            LinkedList aPo = aOM.aPo();
            String str = "ServerReportSimpleLog:" + b.M(aPo);
            m.BV(str);
            x.i("MicroMsg.FreeWifi.FreeWifiServerReporter", str);
            if (aPo.size() > 0) {
                new e(aPo).b(new 1(this));
            } else {
                b.aZ(true);
            }
        }
    }
}
