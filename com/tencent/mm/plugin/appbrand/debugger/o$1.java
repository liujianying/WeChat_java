package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.k.j;
import com.tencent.mm.plugin.appbrand.s.a.a;
import com.tencent.mm.plugin.appbrand.s.d.d;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.plugin.appbrand.s.f.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

class o$1 extends a {
    private d ftF = null;
    final /* synthetic */ j.a ftG;
    final /* synthetic */ o ftH;

    o$1(o oVar, URI uri, com.tencent.mm.plugin.appbrand.s.b.a aVar, Map map, j.a aVar2) {
        this.ftH = oVar;
        this.ftG = aVar2;
        super(uri, aVar, map, 60000);
    }

    public final void b(h hVar) {
        x.d("MicroMsg.RemoteDebugSocket", "onSocketOpen");
        this.ftG.a(hVar);
    }

    public final void sq(String str) {
        this.ftH.ftD.vW(str);
        x.d("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", str);
        this.ftG.sm(str);
    }

    public final void F(int i, String str) {
        x.i("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", str, Integer.valueOf(i));
        if (i == -1 || i == -2 || i == -3) {
            if (ao.isConnected(ad.getContext())) {
                this.ftG.sl(str);
            } else {
                this.ftG.sl("network is down");
                i = 1006;
            }
            this.ftG.C(i, str);
            return;
        }
        this.ftG.C(i, str);
    }

    public final void c(Exception exception) {
        x.e("MicroMsg.RemoteDebugSocket", "onSocketError, ex: " + exception.toString());
    }

    public final void g(ByteBuffer byteBuffer) {
        this.ftG.f(byteBuffer);
    }

    public final void a(d dVar) {
        if (dVar.aoN() != d.a.gDI && !dVar.aoL()) {
            this.ftF = dVar;
        } else if (dVar.aoN() == d.a.gDI && this.ftF != null) {
            if (this.ftF.aoK().position() > 10485760) {
                x.e("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
                this.ftF = null;
                return;
            }
            try {
                this.ftF.e(dVar);
            } catch (Exception e) {
                x.e("MicroMsg.RemoteDebugSocket", e.getMessage());
            }
            if (dVar.aoL()) {
                if (this.ftF.aoN() == d.a.gDK) {
                    g(this.ftF.aoK());
                } else if (this.ftF.aoN() == d.a.gDJ) {
                    try {
                        sq(bi.oV(b.w(this.ftF.aoK())));
                    } catch (Exception e2) {
                        x.e("MicroMsg.RemoteDebugSocket", e2.getMessage());
                    }
                }
                this.ftF = null;
            }
        }
    }
}
