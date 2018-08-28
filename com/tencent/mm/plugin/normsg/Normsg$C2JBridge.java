package com.tencent.mm.plugin.normsg;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Base64;
import com.tencent.mm.lib.riskscanner.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;

@Keep
final class Normsg$C2JBridge {
    private Normsg$C2JBridge() {
    }

    @Keep
    private static String c1() {
        String str = "";
        Bundle bC = a.bC(ad.getContext());
        if (bC == null || bC.getInt("errCode", -100) != 0) {
            return str;
        }
        byte[] byteArray = bC.getByteArray("reqBufferBase64");
        if (byteArray != null) {
            return Base64.encodeToString(byteArray, 2);
        }
        return str;
    }

    @Keep
    private static long c2() {
        return com.tencent.mm.plugin.normsg.b.a.bjF().bjG();
    }

    @Keep
    private static void c3(int i, String str) {
        h.mEJ.k(i, str);
    }

    @Keep
    private static void c4(int i, int i2, int i3) {
        h.mEJ.e((long) i, (long) i2, (long) i3);
    }

    @Keep
    private static void c5(int i, int i2, int i3, int i4) {
        h.mEJ.e(i, i2, i3, i4, false);
    }
}
