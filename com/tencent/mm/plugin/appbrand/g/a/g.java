package com.tencent.mm.plugin.appbrand.g.a;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g implements a {
    private final AtomicInteger get = new AtomicInteger(0);
    private final HashMap<Integer, ByteBuffer> geu = new HashMap();

    public final int aky() {
        Integer valueOf = Integer.valueOf(this.get.addAndGet(1));
        this.geu.put(valueOf, null);
        return valueOf.intValue();
    }

    public final ByteBuffer jA(int i) {
        if (!this.geu.containsKey(Integer.valueOf(i))) {
            return null;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.geu.get(Integer.valueOf(i));
        this.geu.remove(Integer.valueOf(i));
        return byteBuffer;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        if (byteBuffer != null && byteBuffer.isDirect() && this.geu.containsKey(Integer.valueOf(i))) {
            this.geu.put(Integer.valueOf(i), byteBuffer);
        }
    }
}
