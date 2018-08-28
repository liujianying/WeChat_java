package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g implements d {
    private int aeg = -1;
    private ByteBuffer agG = afB;
    private int ahe = -1;
    int[] ahf;
    private boolean ahg;
    private int[] ahh;
    private boolean ahi;
    private ByteBuffer buffer = afB;

    public final boolean r(int i, int i2, int i3) {
        boolean z = !Arrays.equals(this.ahf, this.ahh);
        this.ahh = this.ahf;
        if (this.ahh == null) {
            this.ahg = false;
            return z;
        } else if (i3 != 2) {
            throw new a(i, i2, i3);
        } else if (!z && this.ahe == i && this.aeg == i2) {
            return false;
        } else {
            this.ahe = i;
            this.aeg = i2;
            if (i2 != this.ahh.length) {
                z = true;
            } else {
                z = false;
            }
            this.ahg = z;
            int i4 = 0;
            while (i4 < this.ahh.length) {
                int i5 = this.ahh[i4];
                if (i5 >= i2) {
                    throw new a(i, i2, i3);
                }
                this.ahg = (i5 != i4 ? 1 : 0) | this.ahg;
                i4++;
            }
            return true;
        }
    }

    public final boolean isActive() {
        return this.ahg;
    }

    public final int iY() {
        return this.ahh == null ? this.aeg : this.ahh.length;
    }

    public final int iZ() {
        return 2;
    }

    public final void c(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.aeg * 2)) * this.ahh.length) * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        while (position < limit) {
            for (int i : this.ahh) {
                this.buffer.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.aeg * 2;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.agG = this.buffer;
    }

    public final void ja() {
        this.ahi = true;
    }

    public final ByteBuffer jb() {
        ByteBuffer byteBuffer = this.agG;
        this.agG = afB;
        return byteBuffer;
    }

    public final boolean iT() {
        return this.ahi && this.agG == afB;
    }

    public final void flush() {
        this.agG = afB;
        this.ahi = false;
    }

    public final void reset() {
        flush();
        this.buffer = afB;
        this.aeg = -1;
        this.ahe = -1;
        this.ahh = null;
        this.ahg = false;
    }
}
