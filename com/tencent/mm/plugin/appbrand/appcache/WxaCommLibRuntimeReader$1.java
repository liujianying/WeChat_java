package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;

class WxaCommLibRuntimeReader$1 implements Callable<Object> {
    WxaCommLibRuntimeReader$1() {
    }

    public final Object call() {
        try {
            return XIPCInvoker.a("com.tencent.mm", IPCVoid.dnk, b.class);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", e, "load() ipc read lib", new Object[0]);
            return e;
        }
    }
}
