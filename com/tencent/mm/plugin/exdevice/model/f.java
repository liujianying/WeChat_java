package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.a.g;
import com.tencent.mm.aa.c;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f {

    /* renamed from: com.tencent.mm.plugin.exdevice.model.f$1 */
    static class AnonymousClass1 implements a {
        final /* synthetic */ Runnable bzs;
        final /* synthetic */ long hWz;

        public AnonymousClass1(long j, Runnable runnable) {
            this.hWz = j;
            this.bzs = runnable;
        }

        public final void x(String str, boolean z) {
            if (z) {
                x.v("MicroMsg.exdevice.ExdeviceLogic", "getContact suc; cost=" + (bi.VF() - this.hWz) + " ms");
                c.J(str, 3);
                if (this.bzs != null) {
                    this.bzs.run();
                    return;
                }
                return;
            }
            x.w("MicroMsg.exdevice.ExdeviceLogic", "getContact failed");
        }
    }

    public static boolean ae(Context context, String str) {
        if (bi.oW(str)) {
            x.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public static void a(b bVar, alx alx, aly aly) {
        if (aly != null) {
            bVar.field_connProto = aly.rOw;
            bVar.field_connStrategy = aly.rOx;
            bVar.field_closeStrategy = aly.rOy;
            bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.Az(com.tencent.mm.plugin.exdevice.j.b.AA(aly.rgL));
            bVar.field_authKey = aly.reA;
            bVar.field_brandName = aly.rOv;
            bVar.du(aly.eJM);
            bVar.aw(aly.cCW);
            bVar.ek(aly.rOE);
            bVar.ej(aly.rOD);
            bVar.ei(aly.rOC);
            bVar.fe(aly.rOF);
            bVar.setIconUrl(aly.jPG);
            bVar.ff(aly.cCV);
            bVar.eh(aly.jOU);
            bVar.el(aly.cCX);
            bVar.em(aly.cCY);
            bVar.en(aly.cCZ);
            bVar.eo(aly.cDa);
        }
        if (alx != null) {
            bVar.field_deviceID = alx.hbO;
            bVar.field_deviceType = alx.reT;
            bVar.field_md5Str = g.u(new String(alx.reT + alx.hbO).getBytes());
            if (bi.oW(bVar.field_brandName)) {
                bVar.field_brandName = alx.reT;
            }
        }
    }

    public static boolean b(b bVar) {
        return bVar != null && (bVar.cCW & 1) == 1;
    }
}
