package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;

final class b$a implements i<IPCVoid, IPCString> {
    private b$a() {
    }

    public final /* synthetic */ Object av(Object obj) {
        String str = g.Ei().dqp + "address";
        return e.cn(str) ? new IPCString(str) : new IPCString("");
    }
}
