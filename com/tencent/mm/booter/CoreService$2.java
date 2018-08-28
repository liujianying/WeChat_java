package com.tencent.mm.booter;

import com.tencent.mm.g.a.nm;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class CoreService$2 extends c<nm> {
    final /* synthetic */ CoreService cWM;

    CoreService$2(CoreService coreService) {
        this.cWM = coreService;
        this.sFo = nm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = ((nm) bVar).bYy.bYz;
        if (bi.oW(str)) {
            return false;
        }
        f.mDy.a(12900, str, true, false);
        return true;
    }
}
