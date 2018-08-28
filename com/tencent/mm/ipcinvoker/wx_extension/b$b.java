package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.x;

final class b$b implements a<b, IPCRunCgiRespWrapper> {
    private b$b() {
    }

    public final /* synthetic */ void a(Object obj, final c cVar) {
        b bVar = (b) obj;
        if (bVar == null || bVar.dIE.dIL.getClass() == com.tencent.mm.bk.a.class) {
            x.e("MicroMsg.IPCRunCgi", "InvokeTask, mm received invalid rr %s", new Object[]{bVar});
            if (cVar != null) {
                cVar.at(IPCRunCgiRespWrapper.CF());
                return;
            }
            return;
        }
        v.a(bVar, new v.a() {
            public final int a(int i, int i2, String str, b bVar, l lVar) {
                if (cVar != null) {
                    IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
                    iPCRunCgiRespWrapper.errType = i;
                    iPCRunCgiRespWrapper.errCode = i2;
                    iPCRunCgiRespWrapper.Yy = str;
                    iPCRunCgiRespWrapper.diG = bVar;
                    cVar.at(iPCRunCgiRespWrapper);
                }
                return 0;
            }
        }, true);
    }
}
