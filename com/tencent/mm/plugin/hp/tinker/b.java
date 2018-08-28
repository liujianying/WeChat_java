package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mm.app.p;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public final class b extends a {
    private final int kmZ;

    public b(Context context) {
        super(context);
        this.kmZ = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "application maxMemory:" + this.kmZ, new Object[0]);
    }

    public final int dp(String str, String str2) {
        boolean z = false;
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", new Object[]{str, Long.valueOf(SharePatchFileUtil.ai(new File(str)))});
        int dp = super.dp(str, str2);
        if (dp == 0) {
            dp = this.kmZ < 45 ? -23 : !c.aWA() ? -21 : 0;
        }
        if (dp == 0) {
            com.tencent.tinker.lib.e.a.hL(this.context);
            if (dp == 0) {
                Properties ao = ShareTinkerInternals.ao(r3);
                if (ao == null) {
                    dp = -24;
                } else {
                    String property = ao.getProperty("patch.basepack.client.ver");
                    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:" + property, new Object[0]);
                    if (property == null || !property.equalsIgnoreCase(com.tencent.mm.loader.stub.a.CLIENT_VERSION)) {
                        dp = -25;
                    }
                }
            }
        }
        if (dp == 0 && ShareTinkerInternals.cHe() && p.a(new Throwable().getStackTrace())) {
            dp = -26;
        }
        if (dp == 0) {
            z = true;
        }
        com.tencent.mm.plugin.hp.b.b.fK(z);
        return dp;
    }
}
