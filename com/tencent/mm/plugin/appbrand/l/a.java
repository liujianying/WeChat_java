package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class a extends InputStream {
    public final ByteBuffer gqu;
    private int gqv;

    public a(ByteBuffer byteBuffer) {
        this.gqu = byteBuffer;
    }

    public final int available() {
        return this.gqu.remaining();
    }

    public final int read() {
        return this.gqu.hasRemaining() ? this.gqu.get() & b.CTRL_BYTE : -1;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (!this.gqu.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.gqu.remaining());
        this.gqu.get(bArr, i, min);
        return min;
    }

    public final void close() {
        super.close();
        j(this.gqu);
    }

    public final synchronized void mark(int i) {
        this.gqv = this.gqu.position();
    }

    public final synchronized void seek(int i) {
        this.gqu.position(i);
    }

    public final synchronized void reset() {
        this.gqu.position(this.gqv);
    }

    public final boolean markSupported() {
        return true;
    }

    public static void j(ByteBuffer byteBuffer) {
        if (byteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
            try {
                Method declaredMethod = byteBuffer.getClass().getDeclaredMethod("free", new Class[0]);
                boolean isAccessible = declaredMethod.isAccessible();
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(byteBuffer, new Object[0]);
                declaredMethod.setAccessible(isAccessible);
            } catch (Exception e) {
                x.d("MicroMsg.ByteBufferBackedInputStream", "free ByteBuffer, exp = %s", new Object[]{e});
            }
        }
        System.gc();
    }
}
