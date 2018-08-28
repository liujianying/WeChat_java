package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a;
import com.tencent.mm.plugin.appbrand.launching.d.b;
import com.tencent.mm.plugin.appbrand.launching.f.1;

class AppBrandPrepareTask$a$1 implements b {
    final /* synthetic */ c geY;
    final /* synthetic */ PrepareParams geZ;
    final /* synthetic */ a gfa;

    AppBrandPrepareTask$a$1(a aVar, c cVar, PrepareParams prepareParams) {
        this.gfa = aVar;
        this.geY = cVar;
        this.geZ = prepareParams;
    }

    public final void akC() {
        if (this.geY != null) {
            PrepareResult prepareResult = new PrepareResult();
            PrepareResult.a(prepareResult, 1);
            this.geY.at(prepareResult);
        }
    }

    public final void onDownloadProgress(int i) {
        if (this.geY != null) {
            PrepareResult prepareResult = new PrepareResult();
            PrepareResult.b(prepareResult, i);
            PrepareResult.a(prepareResult, 4);
            this.geY.at(prepareResult);
        }
    }

    public final void a(AppBrandSysConfig appBrandSysConfig, AppBrandLaunchErrorAction appBrandLaunchErrorAction) {
        if (this.geY != null) {
            if (appBrandSysConfig != null) {
                g.Eg();
                appBrandSysConfig.uin = com.tencent.mm.kernel.a.Df();
            }
            if (appBrandSysConfig != null) {
                appBrandSysConfig.frp = com.tencent.mm.plugin.appbrand.game.cgipkg.a.sN(appBrandSysConfig.appId);
            }
            PrepareResult prepareResult = new PrepareResult();
            PrepareResult.a(prepareResult, 2);
            PrepareResult.a(prepareResult, appBrandSysConfig);
            PrepareResult.a(prepareResult, appBrandLaunchErrorAction);
            this.geY.at(prepareResult);
            if (appBrandSysConfig != null) {
                1 1 = new 1(this);
                if (!PrepareParams.e(this.geZ)) {
                    com.tencent.mm.by.g.cDZ().i(new 1(new f(appBrandSysConfig.bGy, PrepareParams.c(this.geZ), 1)));
                    return;
                }
                return;
            }
            r.sf(q.rY(PrepareParams.a(this.geZ)));
        }
    }
}
