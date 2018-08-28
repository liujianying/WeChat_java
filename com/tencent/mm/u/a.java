package com.tencent.mm.u;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.u.b.d;

public final class a {
    public static void a(d dVar, String str, a aVar) {
        if (bi.oW(str)) {
            aVar.fM("");
            return;
        }
        dVar.evaluateJavascript(str + String.format(";var ___result_return = function(){return %d;};___result_return();", new Object[]{Integer.valueOf(11111)}), new 1(aVar));
    }
}
