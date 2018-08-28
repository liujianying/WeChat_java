package com.tencent.mm.plugin.account.model;

import android.content.SharedPreferences;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class i$3 extends c<bc> {
    final /* synthetic */ i eOi;

    i$3(i iVar) {
        this.eOi = iVar;
        this.sFo = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
        int i = sharedPreferences.getInt("new_launch_image_sub_type", 0);
        if (bcVar.bIB.bIC == 43 && i > 0 && i == bcVar.bIB.bID) {
            String str = bcVar.bIB.filePath;
            h.mEJ.a(723, 6, 1, false);
            sharedPreferences.edit().putInt("new_launch_image_res_version", bcVar.bIB.bIE).commit();
            x.i("MicroMsg.SubCoreAccountSync", "filePath: %s", new Object[]{str});
            i.pG(str);
        }
        return false;
    }
}
