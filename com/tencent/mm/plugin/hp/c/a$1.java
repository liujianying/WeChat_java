package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.oo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ oo kmU;
    final /* synthetic */ a kmV;

    a$1(a aVar, oo ooVar) {
        this.kmV = aVar;
        this.kmU = ooVar;
    }

    public final void a(boolean z, b bVar) {
        if (!z || bVar == null) {
            Context context = ad.getContext();
            context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", this.kmV.kmP).apply();
            g.at(ad.getContext(), "");
            return;
        }
        this.kmV.kmT = bVar;
        this.kmU.rsQ = this.kmV.kmT.knj;
        x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[]{this.kmV.kmT.knj, this.kmV.kmQ});
        h.mEJ.a(614, 71, 1, false);
    }
}
