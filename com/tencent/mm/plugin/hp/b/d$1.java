package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.e.d;

class d$1 extends c<aw> {
    final /* synthetic */ d kmE;

    d$1(d dVar) {
        this.kmE = dVar;
        this.sFo = aw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        aw awVar = (aw) bVar;
        if (this.kmE.kmz) {
            Context context = ad.getContext();
            String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_after_install", "");
            d dVar = a.hL(context).vsD;
            String str = dVar == null ? "" : dVar.vsI;
            x.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isAfterInstallDialogHaveShow currentVersion :%s tinkerVersion:%s", new Object[]{string, str});
            boolean z = bi.oW(string) || bi.oW(str) || !(bi.oW(string) || bi.oW(str) || !string.equalsIgnoreCase(str));
            if (!z) {
                str = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_msg_key", "");
                awVar.bIp.bIq = true;
                awVar.bIp.bIr = str;
                if (!bi.oW(str)) {
                    a.rk(2);
                }
                context = ad.getContext();
                Object string2 = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_version_key", "");
                if (!TextUtils.isEmpty(string2)) {
                    context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_after_install", string2).apply();
                }
            }
            this.kmE.kmz = false;
        }
        return false;
    }
}
