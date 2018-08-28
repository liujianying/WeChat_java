package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l implements d {
    private int aeg = -1;
    float aex = 1.0f;
    private ByteBuffer agG = afB;
    private k ahP;
    private ShortBuffer ahQ = this.buffer.asShortBuffer();
    long ahR;
    long ahS;
    private int ahe = -1;
    private boolean ahi;
    private ByteBuffer buffer = afB;
    float pitch = 1.0f;

    public final boolean r(int i, int i2, int i3) {
        if (i3 != 2) {
            throw new a(i, i2, i3);
        } else if (this.ahe == i && this.aeg == i2) {
            return false;
        } else {
            this.ahe = i;
            this.aeg = i2;
            return true;
        }
    }

    public final boolean isActive() {
        return Math.abs(this.aex - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f;
    }

    public final int iY() {
        return this.aeg;
    }

    public final int iZ() {
        return 2;
    }

    public final void c(ByteBuffer byteBuffer) {
        int remaining;
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining2 = byteBuffer.remaining();
            this.ahR += (long) remaining2;
            k kVar = this.ahP;
            remaining = asShortBuffer.remaining() / kVar.ahu;
            int i = (kVar.ahu * remaining) * 2;
            kVar.ce(remaining);
            asShortBuffer.get(kVar.ahA, kVar.ahH * kVar.ahu, i / 2);
            kVar.ahH += remaining;
            kVar.jw();
            byteBuffer.position(byteBuffer.position() + remaining2);
        }
        int i2 = (this.ahP.ahI * this.aeg) * 2;
        if (i2 > 0) {
            if (this.buffer.capacity() < i2) {
                this.buffer = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
                this.ahQ = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.ahQ.clear();
            }
            k kVar2 = this.ahP;
            ShortBuffer shortBuffer = this.ahQ;
            remaining = Math.min(shortBuffer.remaining() / kVar2.ahu, kVar2.ahI);
            shortBuffer.put(kVar2.ahC, 0, kVar2.ahu * remaining);
            kVar2.ahI -= remaining;
            System.arraycopy(kVar2.ahC, remaining * kVar2.ahu, kVar2.ahC, 0, kVar2.ahu * kVar2.ahI);
            this.ahS += (long) i2;
            this.buffer.limit(i2);
            this.agG = this.buffer;
        }
    }

    public final void ja() {
        k kVar = this.ahP;
        int i = kVar.ahH;
        int i2 = kVar.ahI + ((int) ((((((float) i) / (kVar.aex / kVar.pitch)) + ((float) kVar.ahJ)) / kVar.pitch) + 0.5f));
        kVar.ce((kVar.ahx * 2) + i);
        for (int i3 = 0; i3 < (kVar.ahx * 2) * kVar.ahu; i3++) {
            kVar.ahA[(kVar.ahu * i) + i3] = (short) 0;
        }
        kVar.ahH += kVar.ahx * 2;
        kVar.jw();
        if (kVar.ahI > i2) {
            kVar.ahI = i2;
        }
        kVar.ahH = 0;
        kVar.ahK = 0;
        kVar.ahJ = 0;
        this.ahi = true;
    }

    public final ByteBuffer jb() {
        ByteBuffer byteBuffer = this.agG;
        this.agG = afB;
        return byteBuffer;
    }

    public final boolean iT() {
        return this.ahi && (this.ahP == null || this.ahP.ahI == 0);
    }

    public final void flush() {
        this.ahP = new k(this.ahe, this.aeg);
        this.ahP.aex = this.aex;
        this.ahP.pitch = this.pitch;
        this.agG = afB;
        this.ahR = 0;
        this.ahS = 0;
        this.ahi = false;
    }

    public final void reset() {
        this.ahP = null;
        this.buffer = afB;
        this.ahQ = this.buffer.asShortBuffer();
        this.agG = afB;
        this.aeg = -1;
        this.ahe = -1;
        this.ahR = 0;
        this.ahS = 0;
        this.ahi = false;
    }
}
