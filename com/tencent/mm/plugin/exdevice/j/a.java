package com.tencent.mm.plugin.exdevice.j;

import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a {
    private final int iHH = 1024;
    private ByteBuffer iHI;
    private ByteBuffer iHJ;

    public a(int i) {
        boolean z;
        boolean z2 = true;
        x.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = " + i);
        Assert.assertTrue(i >= 0);
        this.iHJ = ByteBuffer.allocate(i);
        this.iHI = this.iHJ.asReadOnlyBuffer();
        if (this.iHJ != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.iHI == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
    }

    public final int getSize() {
        x.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.iHJ.position());
        return this.iHJ.position();
    }

    public final short readShort() {
        if (getSize() <= 1) {
            throw new IOException("There is only one byte in array");
        }
        short s = this.iHI.getShort();
        x.d("MicroMsg.exdevice.AutoBuffer", "getShort = " + s);
        return s;
    }

    public final void M(byte[] bArr, int i) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr.length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (bArr.length >= i + 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.iHI.remaining() < i) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        x.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0 byteCount = " + i);
        this.iHI.get(bArr, 0, i);
    }

    public final void N(byte[] bArr, int i) {
        boolean z = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0 byteCount = " + i);
        if (i > this.iHJ.remaining()) {
            x.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
            x.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.iHJ.capacity());
            ByteBuffer allocate = ByteBuffer.allocate((this.iHJ.capacity() + i) + 1024);
            int position = this.iHI.position();
            allocate.put(this.iHJ.array());
            allocate.put(bArr, 0, i);
            this.iHJ = allocate;
            this.iHI = allocate.asReadOnlyBuffer();
            this.iHI.position(position);
            return;
        }
        this.iHJ.put(bArr, 0, i);
    }
}
