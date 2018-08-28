package com.tencent.mm.plugin.music.cache;

import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private byte[] buffer = new byte[81920];
    public int fi = 0;
    public com.tencent.mm.plugin.music.c.a.a lxo;
    public c lxp;
    public f lxq;
    public int lxr = -1;
    public int lxs = 0;
    public int tH = -1;

    public a(com.tencent.mm.plugin.music.c.a.a aVar) {
        this.lxo = aVar;
    }

    public final synchronized boolean tr(int i) {
        boolean z;
        z = this.tH <= i && i <= this.tH + 81920;
        return z;
    }

    public final synchronized boolean ts(int i) {
        boolean z;
        z = this.tH <= i && i <= this.tH + this.fi;
        return z;
    }

    public final synchronized boolean bhI() {
        boolean z = false;
        synchronized (this) {
            if (this.tH < 0 || this.fi <= 0) {
                x.e("MicroMsg.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", new Object[]{Integer.valueOf(this.tH), Integer.valueOf(this.fi)});
            } else {
                int[] iArr;
                Object obj = new byte[this.fi];
                System.arraycopy(this.buffer, 0, obj, 0, this.fi);
                this.lxq.c(obj, (long) this.tH, this.fi);
                c cVar = this.lxp;
                int i = this.tH;
                int i2 = this.fi;
                if (i < 0 || i2 < 0 || ((long) i) > cVar.eyz || ((long) (i + i2)) > cVar.eyz) {
                    x.i("MicroMsg.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(cVar.eyz)});
                    x.e("MicroMsg.IndexBitMgr", "getWriteBuffRange invalid parameter!");
                    iArr = null;
                } else {
                    int[] iArr2 = new int[]{-1, -1};
                    int i3 = i + i2;
                    int index = cVar.getIndex(i);
                    int index2 = cVar.getIndex(i3);
                    for (i2 = index; i2 <= index2; i2++) {
                        int i4 = (i2 + 1) * 8192;
                        if (i2 * 8192 >= i && i4 <= i3) {
                            if (iArr2[0] == -1) {
                                iArr2[0] = i2;
                            }
                            if (iArr2[0] > i2) {
                                iArr2[0] = i2;
                            }
                            if (iArr2[1] == -1) {
                                iArr2[1] = i2;
                            }
                            if (iArr2[1] < i2) {
                                iArr2[1] = i2;
                            }
                        }
                    }
                    if (iArr2[0] == -1 && iArr2[1] == -1 && ((long) i3) == cVar.eyz) {
                        x.i("MicroMsg.IndexBitMgr", "write to file end!");
                        iArr2[0] = index;
                        iArr2[1] = index2;
                    }
                    iArr = iArr2;
                }
                if (iArr == null) {
                    x.e("MicroMsg.FileBytesCacheMgr", "flushBufferAll, range is null");
                } else if (iArr[0] == -1 || iArr[1] == -1) {
                    x.d("MicroMsg.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                } else {
                    int i5;
                    for (i5 = iArr[0]; i5 <= iArr[1]; i5++) {
                        this.lxp.tw(i5);
                    }
                    i5 = iArr[0];
                    if (i5 > 0) {
                        if (!this.lxp.tv(i5 - 1) && this.lxr + this.lxs == this.tH && this.fi > 0 && this.lxs >= 8192) {
                            x.i("MicroMsg.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", new Object[]{Integer.valueOf(i5)});
                            z = true;
                        }
                    }
                    if (z) {
                        this.lxp.tw(iArr[0] - 1);
                    }
                    this.lxp.bhK();
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized void tt(int i) {
        this.lxr = this.tH;
        this.lxs = this.fi;
        this.tH = i;
        this.fi = 0;
    }

    public final synchronized void p(byte[] bArr, int i, int i2) {
        int i3 = i - this.tH;
        this.fi = i3 + i2;
        System.arraycopy(bArr, 0, this.buffer, i3, i2);
    }
}
