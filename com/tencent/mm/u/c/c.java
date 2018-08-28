package com.tencent.mm.u.c;

import android.content.Context;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.b;
import com.tencent.mm.u.d.a;

public final class c {
    public a doL;
    private a doM;
    public d doN;
    public b doO;

    public c(Context context, e eVar, a aVar, b bVar) {
        this.doL = new a(context, eVar);
        this.doM = aVar;
        this.doO = bVar;
    }

    public final String b(String str, String str2, int i) {
        try {
            b bVar = bi.oW(str) ? null : (b) this.doN.doT.get(str);
            if (bVar == null) {
                return this.doO.fN(str);
            }
            return this.doO.a(this.doL, this.doM, bVar, str2, new 1(this, i));
        } catch (Throwable e) {
            x.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", new Object[]{str, Log.getStackTraceString(e)});
            throw e;
        }
    }
}
