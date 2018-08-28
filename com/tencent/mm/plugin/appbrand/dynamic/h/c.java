package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.x;

public class c implements a<Bundle, Bundle> {
    public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
        BaseIPCService fG = h.Ct().fG(e.Cs());
        if (fG != null) {
            x.i("MicroMsg.IPCInvokeTask_KillAllProcess", "killSelf process(%s)", new Object[]{r0});
            fG.bp(true);
        }
    }
}
