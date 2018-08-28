package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.plugin.appbrand.game.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class t {
    public static void i(g gVar) {
        if (gVar == null) {
            x.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
        } else if (gVar.dti) {
            j(gVar);
        } else {
            x.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", new Object[]{gVar.mAppId});
        }
    }

    static void j(g gVar) {
        if (ah.isMainThread()) {
            e.post(new 1(gVar), String.format("performRestart$%s", new Object[]{gVar.mAppId}));
            return;
        }
        Bitmap bitmap;
        if (gVar.aaq()) {
            MBCanvasContentHolder ahj = a.fDd.ahj();
            bitmap = ahj == null ? null : ahj.content;
        } else {
            bitmap = (Bitmap) new 3(gVar).a(new ag(Looper.getMainLooper()));
        }
        ah.A(new 2(gVar, bitmap));
    }
}
