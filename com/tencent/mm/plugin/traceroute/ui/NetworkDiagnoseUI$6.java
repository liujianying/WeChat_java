package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.model.q;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.traceroute.b.a$e;
import com.tencent.mm.plugin.traceroute.b.a.b;
import com.tencent.mm.plugin.traceroute.b.a.d;
import com.tencent.mm.plugin.traceroute.b.a.j;
import com.tencent.mm.plugin.traceroute.b.c;
import com.tencent.mm.sdk.platformtools.x;

class NetworkDiagnoseUI$6 implements a {
    final /* synthetic */ NetworkDiagnoseUI oEe;

    NetworkDiagnoseUI$6(NetworkDiagnoseUI networkDiagnoseUI) {
        this.oEe = networkDiagnoseUI;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            NetworkDiagnoseUI.a(this.oEe, new com.tencent.mm.plugin.traceroute.b.a(q.GF()));
            NetworkDiagnoseUI.d(this.oEe).b(eVar.getIPsString(true), true);
            NetworkDiagnoseUI.d(this.oEe).b(eVar.getIPsString(false), false);
            NetworkDiagnoseUI.d(this.oEe).oDk = new d() {
                public final void Zq() {
                    NetworkDiagnoseUI.i(NetworkDiagnoseUI$6.this.oEe).sendEmptyMessageDelayed(2, 500);
                }
            };
            NetworkDiagnoseUI.d(this.oEe).oDj = new a$e() {
                public final void bIP() {
                    NetworkDiagnoseUI.i(NetworkDiagnoseUI$6.this.oEe).sendEmptyMessageDelayed(1, 500);
                }
            };
            NetworkDiagnoseUI.d(this.oEe).oDm = new b() {
                public final void bIN() {
                    NetworkDiagnoseUI.i(NetworkDiagnoseUI$6.this.oEe).sendEmptyMessage(3);
                }
            };
            NetworkDiagnoseUI.d(this.oEe).oDl = new 4(this);
            com.tencent.mm.plugin.traceroute.b.a d = NetworkDiagnoseUI.d(this.oEe);
            if (d.oDi == null || d.oDi.size() == 0) {
                x.e("MicroMsg.MMTraceRoute", "no iplist");
            } else {
                if (com.tencent.mm.plugin.traceroute.b.a.oDe == null) {
                    com.tencent.mm.plugin.traceroute.b.a.oDe = new c();
                }
                com.tencent.mm.sdk.f.e.post(new j(d, (byte) 0), "MMTraceRoute_start");
            }
            NetworkDiagnoseUI.j(this.oEe).J(1200, 1200);
        }
    }
}
