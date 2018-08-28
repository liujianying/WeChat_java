package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.al.a;

class b$1 implements a {
    b$1() {
    }

    public final boolean vD() {
        BaseIPCService fG = h.Ct().fG("com.tencent.mm:support");
        if (fG != null) {
            fG.bp(false);
        }
        return false;
    }
}
