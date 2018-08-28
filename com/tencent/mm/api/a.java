package com.tencent.mm.api;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public static String cy(String str) {
        if (bi.oW(str)) {
            str = "tempConv";
        }
        StringBuilder stringBuilder = new StringBuilder(c.Gc());
        stringBuilder.append(g.u(str.getBytes())).append("/");
        stringBuilder.append("conv/");
        return stringBuilder.toString();
    }
}
