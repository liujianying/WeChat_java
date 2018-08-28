package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.engine.JsEngine;
import com.tencent.magicbrush.engine.b;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.g.f;
import java.nio.ByteBuffer;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public enum j implements d, f {
    ;
    
    volatile f fAg;
    final AtomicInteger fAh;
    final TreeMap<Integer, a> fAi;

    private j(String str) {
        this.fAh = new AtomicInteger(0);
        this.fAi = new TreeMap();
    }

    public final a kl(int i) {
        return (a) this.fAi.get(Integer.valueOf(i));
    }

    public final a agg() {
        return this.fAg;
    }

    public final a agh() {
        int addAndGet = this.fAh.addAndGet(1);
        f fVar = new f(false, new b(this.fAg.fzY.tb()), addAndGet);
        this.fAi.put(Integer.valueOf(addAndGet), fVar);
        return fVar;
    }

    public final void km(int i) {
        a aVar = (a) this.fAi.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.destroy();
        }
        this.fAi.remove(Integer.valueOf(i));
    }

    public final int getNativeBufferId() {
        f fVar = this.fAg;
        return JsEngine.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        f fVar = this.fAg;
        if (byteBuffer == null) {
            c.f.d("JsVmContext", "JsVmContext setNativeBuffer failed. byteBuffer == null", new Object[0]);
            return;
        }
        if (!byteBuffer.isDirect()) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
            byteBuffer.rewind();
            allocateDirect.put(byteBuffer);
            byteBuffer = allocateDirect;
        }
        JsEngine.setNativeBuffer(i, byteBuffer);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        return this.fAg.fzY.getNativeBuffer(i);
    }

    public final boolean agi() {
        return true;
    }
}
