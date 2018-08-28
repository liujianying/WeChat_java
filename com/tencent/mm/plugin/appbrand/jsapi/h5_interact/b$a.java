package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCVoid;

final class b$a implements a<SendDataToH5FromMiniProgramEvent, IPCVoid> {
    private b$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = (SendDataToH5FromMiniProgramEvent) obj;
        if (sendDataToH5FromMiniProgramEvent != null) {
            com.tencent.mm.sdk.b.a.sFg.m(sendDataToH5FromMiniProgramEvent);
        }
    }
}
