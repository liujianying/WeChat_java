package com.google.android.exoplayer2.b;

import java.nio.ByteBuffer;

public class e extends a {
    public final b aif = new b();
    public ByteBuffer aig;
    public long aih;
    public final int aii;

    public e(int i) {
        this.aii = i;
    }

    public final void ch(int i) {
        if (this.aig == null) {
            this.aig = ci(i);
            return;
        }
        int capacity = this.aig.capacity();
        int position = this.aig.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer ci = ci(i2);
            if (position > 0) {
                this.aig.position(0);
                this.aig.limit(position);
                ci.put(this.aig);
            }
            this.aig = ci;
        }
    }

    public final boolean jD() {
        return cg(1073741824);
    }

    public final void jE() {
        this.aig.flip();
    }

    public final void clear() {
        super.clear();
        if (this.aig != null) {
            this.aig.clear();
        }
    }

    private ByteBuffer ci(int i) {
        if (this.aii == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.aii == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.aig == null ? 0 : this.aig.capacity()) + " < " + i + ")");
    }
}
