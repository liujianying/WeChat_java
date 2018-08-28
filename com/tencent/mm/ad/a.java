package com.tencent.mm.ad;

import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    private static int dNX = 0;
    private static int dNY = 0;

    public static String a(a aVar) {
        if (aVar == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(bi.oV(aVar.dOh));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bi.oV(aVar.dOf));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bi.oV(aVar.dOc));
        return stringBuilder.toString();
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!q.gQ(aVar.bSS)) {
            stringBuilder.append(aVar.dNZ);
            stringBuilder.append(": ");
        }
        String str = bi.oW(aVar.dOh) ? bi.oW(aVar.dOf) ? aVar.dOc : aVar.dOf : aVar.dOh;
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
