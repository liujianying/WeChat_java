package com.tencent.mm.memory;

import com.tencent.mm.sdk.b;
import com.tencent.mm.sdk.f.e;
import java.nio.ByteBuffer;

public final class h extends b<ByteBuffer> {
    public static h dvb = new h();

    static /* synthetic */ void a(h hVar, Object obj) {
        if (hVar.tM != null && hVar.tN < hVar.tM.length) {
            hVar.tM[hVar.tN] = obj;
            hVar.tN++;
        }
    }

    static {
        e.post(new 1(), "DecodeTempStorage_preload");
    }

    private h() {
    }
}
