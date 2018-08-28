package com.tencent.mm.plugin.secinforeport;

import android.os.HandlerThread;
import com.tencent.mm.a.h;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.normsg.a;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.u;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class PluginSecInfoReport extends f implements b {
    private static HandlerThread mOk = null;
    private static ag mOl = null;

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(d.class);
        dependsOn(c.class);
        dependsOn(a.class);
    }

    public void configure(g gVar) {
        com.tencent.mm.plugin.secinforeport.a.d.a(c.mOo);
        com.tencent.mm.plugin.secinforeport.a.a.a(a.mOi);
    }

    public void execute(g gVar) {
        if (mOk == null) {
            try {
                HandlerThread Xs = e.Xs("SIRWorker");
                mOk = Xs;
                Xs.start();
                mOl = new ag(mOk.getLooper());
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.PSIR", th, "[tomys] unexpected exception.", new Object[0]);
            }
        }
        com.tencent.mm.sdk.b.a.sFg.a(new 1(this));
        com.tencent.mm.sdk.b.a.sFg.a(new 2(this));
        ((b) com.tencent.mm.kernel.g.n(b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a() {
            public final void a(i.f fVar, i.g gVar, boolean z) {
                PluginSecInfoReport.this.reportSecurityInfoAsync(z ? 0 : 540999680);
            }

            public final void a(u.b bVar, String str, int i, String str2, String str3, int i2) {
                PluginSecInfoReport.this.reportSecurityInfoAsync(540999681);
            }
        });
    }

    private void reportSecurityInfoAsync(final int i) {
        if (mOl == null) {
            x.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
        } else {
            mOl.post(new Runnable() {
                public final void run() {
                    try {
                        if (com.tencent.mm.plugin.secinforeport.a.d.mOw.H(1, 86400000)) {
                            boolean z;
                            int i = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("DisableRiskScanSdkProb", 0);
                            int i2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("DisableInstalledPkgInfoReportProb", 0);
                            com.tencent.mm.kernel.g.Eg();
                            int aM = h.aM(com.tencent.mm.kernel.a.Df(), 101);
                            i = (i <= 0 || aM < 0 || aM > i) ? 0 : 1;
                            if (i2 <= 0 || aM < 0 || aM > i2) {
                                i2 = 0;
                            } else {
                                i2 = 1;
                            }
                            com.tencent.mm.plugin.secinforeport.a.d dVar = com.tencent.mm.plugin.secinforeport.a.d.mOw;
                            int i3 = i;
                            if (i == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            dVar.a(i3, z, i2 == 0, true);
                        }
                        if (com.tencent.mm.plugin.secinforeport.a.d.mOw.H(2, 86400000)) {
                            com.tencent.mm.plugin.secinforeport.a.d.mOw.bto();
                        }
                    } catch (Throwable th) {
                        x.printErrStackTrace("MicroMsg.PSIR", th, "unexpected exception was thrown.", new Object[0]);
                    }
                }
            });
        }
    }
}
