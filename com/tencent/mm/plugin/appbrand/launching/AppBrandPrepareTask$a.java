package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

final class AppBrandPrepareTask$a implements a<AppBrandPrepareTask$PrepareParams, AppBrandPrepareTask$PrepareResult> {
    private AppBrandPrepareTask$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        AppBrandPrepareTask$PrepareParams appBrandPrepareTask$PrepareParams = (AppBrandPrepareTask$PrepareParams) obj;
        String a = appBrandPrepareTask$PrepareParams.mAppId;
        int b = appBrandPrepareTask$PrepareParams.gfg;
        int c = appBrandPrepareTask$PrepareParams.eEZ;
        String d = appBrandPrepareTask$PrepareParams.gff;
        1 1 = new 1(this, cVar, appBrandPrepareTask$PrepareParams);
        d uk = d.uk(appBrandPrepareTask$PrepareParams.gfi);
        if (uk == null) {
            uk = new d(a, b, appBrandPrepareTask$PrepareParams.gfe, c, d, appBrandPrepareTask$PrepareParams.gfh, appBrandPrepareTask$PrepareParams.gfi, appBrandPrepareTask$PrepareParams.gfj, false, appBrandPrepareTask$PrepareParams.geV);
            2 2 = new 2(this, cVar, uk);
            if (g.Ek().dqL.drf) {
                2.vk();
            } else {
                x.i("MicroMsg.AppBrandPrepareTask", "prepareCall kernel startup not done yet, wait for it");
                g.Ek().a(2);
            }
        }
        uk.gfu = 1;
        if (uk.started && uk.gfv != null) {
            x.v("MicroMsg.AppBrand.AppLaunchPrepareProcess", "[applaunch] setResultCallback already done %s %d", new Object[]{uk.appId, Integer.valueOf(uk.fmv)});
            uk.a(uk.gfv);
        }
    }
}
