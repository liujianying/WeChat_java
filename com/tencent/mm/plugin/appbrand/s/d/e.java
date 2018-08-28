package com.tencent.mm.plugin.appbrand.s.d;

import com.tencent.mm.plugin.appbrand.s.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e implements c {
    protected static byte[] gDP = new byte[0];
    protected boolean gDQ;
    protected d$a gDR;
    private ByteBuffer gDS;
    protected boolean gDT;

    public e(d$a d_a) {
        this.gDR = d_a;
        this.gDS = ByteBuffer.wrap(gDP);
    }

    public e(d dVar) {
        this.gDQ = dVar.aoL();
        this.gDR = dVar.aoN();
        this.gDS = dVar.aoK();
        this.gDT = dVar.aoM();
    }

    public final boolean aoL() {
        return this.gDQ;
    }

    public final d$a aoN() {
        return this.gDR;
    }

    public final boolean aoM() {
        return this.gDT;
    }

    public ByteBuffer aoK() {
        return this.gDS;
    }

    public final void dg(boolean z) {
        this.gDQ = z;
    }

    public final void a(d$a d_a) {
        this.gDR = d_a;
    }

    public void v(ByteBuffer byteBuffer) {
        this.gDS = byteBuffer;
    }

    public final void dh(boolean z) {
        this.gDT = z;
    }

    public final void e(d dVar) {
        ByteBuffer aoK = dVar.aoK();
        if (this.gDS == null) {
            this.gDS = ByteBuffer.allocate(aoK.remaining());
            aoK.mark();
            this.gDS.put(aoK);
            aoK.reset();
        } else {
            aoK.mark();
            this.gDS.position(this.gDS.limit());
            this.gDS.limit(this.gDS.capacity());
            if (aoK.remaining() > this.gDS.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(aoK.remaining() + this.gDS.capacity());
                this.gDS.flip();
                allocate.put(this.gDS);
                allocate.put(aoK);
                this.gDS = allocate;
            } else {
                this.gDS.put(aoK);
            }
            this.gDS.rewind();
            aoK.reset();
        }
        this.gDQ = dVar.aoL();
    }

    public String toString() {
        return "Framedata{ optcode:" + this.gDR + ", fin:" + this.gDQ + ", payloadlength:[pos:" + this.gDS.position() + ", len:" + this.gDS.remaining() + "], payload:" + Arrays.toString(b.wc(new String(this.gDS.array()))) + "}";
    }
}
