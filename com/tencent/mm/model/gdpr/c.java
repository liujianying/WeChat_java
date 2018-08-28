package com.tencent.mm.model.gdpr;

import android.content.Context;
import com.tencent.mm.by.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.protocal.c.adu;
import com.tencent.mm.protocal.c.adv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

public final class c {
    public static boolean Jm() {
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", IPCVoid.dnk, a.class);
        return iPCBoolean != null && iPCBoolean.value;
    }

    public static void a(Context context, final a aVar, final String str, final b bVar) {
        if (context == null) {
            context = ad.getContext();
        }
        if (!Jm()) {
            bVar.hj(0);
        } else if (bi.oW(str)) {
            bVar.hj(1);
        } else {
            g.cDZ().h(new a<Boolean, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    if (aVar.dEf == 0) {
                        return Boolean.valueOf(true);
                    }
                    b cBL = com.tencent.mm.vending.g.g.cBL();
                    adu adu = new adu();
                    adu.bPS = str;
                    adu.scene = aVar.dEf;
                    com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
                    aVar.dIF = 2575;
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getgdrpauth";
                    aVar.dIG = adu;
                    aVar.dIH = new adv();
                    com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.KT(), new 1(this, cBL));
                    return null;
                }
            }).g(new 1(bVar, context, aVar, str));
        }
    }
}
