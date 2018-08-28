package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b {
    AtomicBoolean fOO = new AtomicBoolean(false);
    a fOP;
    ah fOQ = new ah("MicroMsg.appbrand.ScanDecoder");

    abstract boolean b(byte[] bArr, int i, int i2, int i3);

    abstract void init();

    abstract void release();

    public b(a aVar) {
        this.fOP = aVar;
    }
}
