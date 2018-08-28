package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.sdk.platformtools.ad;

public final class b {
    public static void a(com.tencent.mm.ab.b bVar, final a aVar) {
        if (ad.cic()) {
            v.a(bVar, new a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ab.b bVar, l lVar) {
                    if (aVar != null) {
                        aVar.a(i, i2, str, bVar);
                    }
                    return 0;
                }
            }, true);
        } else {
            XIPCInvoker.a("com.tencent.mm", bVar, b.class, new 2(aVar));
        }
    }
}
