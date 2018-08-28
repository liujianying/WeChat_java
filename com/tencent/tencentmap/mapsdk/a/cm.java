package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class cm extends cx implements Cloneable {
    private static Map<Integer, byte[]> b;
    public Map<Integer, byte[]> a = null;

    public final void a(cw cwVar) {
        cwVar.a(this.a, 0);
    }

    public final void a(cv cvVar) {
        if (b == null) {
            b = new HashMap();
            Integer valueOf = Integer.valueOf(0);
            byte[] bArr = new byte[1];
            bArr[0] = (byte) 0;
            b.put(valueOf, bArr);
        }
        this.a = (Map) cvVar.a(b, 0, true);
    }
}
