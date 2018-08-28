package com.tencent.mm.plugin.appbrand.game;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.magicbrush.handler.c;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.game.c.i;
import com.tencent.mm.plugin.appbrand.game.e.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements c {
    final /* synthetic */ b fzP;

    b$1(b bVar) {
        this.fzP = bVar;
    }

    public final byte[] bQ(String str) {
        return this.fzP.fdO == null ? null : ao.e(this.fzP.fdO, str);
    }

    public final String s(String str, String str2) {
        return AppBrandLocalMediaObjectManager.genMediaFilePath(str, str2);
    }

    public final void t(String str, String str2) {
        if (this.fzP.fdO != null) {
            if (!(this.fzP.fzJ || this.fzP.fdO.fcu.frm.fih == 0)) {
                x.w("MicroMsg.GameRenderer", "v8_exception mFirstFrameRendered");
                this.fzP.fzJ = true;
                this.fzP.fzI.agj();
            }
            x.e("MicroMsg.GameRenderer", "v8_exception message = [%s], stackTrace = [%s]", new Object[]{str, str2});
            this.fzP.fdO.fcy.j("onError", "{'message':'" + g.tc(str) + "', 'stack': '" + g.tc(str2) + "'}", 0);
        }
    }

    public final void onScreenCanvasContextTypeSet(boolean z) {
        i iVar = i.fCa;
        x.i("MicroMsg.WAGamePerfManager", "setGameMainCanvasType() called with: is2D = [" + z + "]");
        iVar.fCg = Boolean.valueOf(z);
    }

    public final void onShaderCompileError(String str) {
        x.e("MicroMsg.GameRenderer", "hy: onShaderCompileError: %s", new Object[]{str});
        h.mEJ.e(808, 0, 1);
        h.mEJ.h(15134, new Object[]{Build.MANUFACTURER, Build.MODEL, VERSION.INCREMENTAL, str});
    }
}
