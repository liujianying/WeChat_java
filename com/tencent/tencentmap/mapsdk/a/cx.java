package com.tencent.tencentmap.mapsdk.a;

import java.io.Serializable;

public abstract class cx implements Serializable {
    public abstract void a(cv cvVar);

    public abstract void a(cw cwVar);

    public final byte[] a() {
        cw cwVar = new cw();
        a(cwVar);
        return cwVar.b();
    }
}
