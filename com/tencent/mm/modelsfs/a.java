package com.tencent.mm.modelsfs;

import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static boolean eet = false;
    private long eeu = 0;
    private String eev;
    private long eew = 0;
    private long mNativePtr = 0;

    public a(long j) {
        this.eev = String.valueOf(j);
        init();
    }

    public a(String str) {
        this.eev = str;
        init();
    }

    private void init() {
        x.i("MicroMsg.EncEngine", "init  key  enckey " + this.eev + "  hashcode " + hashCode());
        this.mNativePtr = MMIMAGEENCJNI.open(this.eev);
        try {
            x.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
        } catch (Exception e) {
            x.e("MicroMsg.EncEngine", "exception " + e.getMessage());
        }
    }

    public final void reset() {
        x.i("MicroMsg.EncEngine", "reset " + bi.cjd());
        free();
        if (this.eew == 0) {
            init();
            this.eeu = 0;
            return;
        }
        init();
        MMIMAGEENCJNI.seek(this.mNativePtr, this.eew, 1);
        this.eeu = this.eew;
    }

    public final long QF() {
        this.eew = this.eeu;
        return this.eew;
    }

    public final int y(byte[] bArr, int i) {
        if (this.mNativePtr == 0) {
            x.i("MicroMsg.EncEngine", "transFor " + bi.cjd().toString());
        }
        if (eet) {
            x.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + bArr.length);
        }
        if (eet && this.eeu < 64) {
            x.d("MicroMsg.EncEngine", "dump before _offset " + this.eeu + "  length:" + i + " " + bi.bB(bArr) + " hashcode " + hashCode());
        }
        MMIMAGEENCJNI.transFor(this.mNativePtr, bArr, this.eeu, (long) i);
        if (eet && this.eeu < 64) {
            x.d("MicroMsg.EncEngine", "dump after _offset " + this.eeu + "  length:" + i + " " + bi.bB(bArr) + " hashcode " + hashCode());
        }
        this.eeu += (long) i;
        return i;
    }

    public final void seek(long j) {
        this.eeu = j;
        MMIMAGEENCJNI.seek(this.mNativePtr, j, 1);
    }

    public final void free() {
        x.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
        MMIMAGEENCJNI.free(this.mNativePtr);
        this.mNativePtr = 0;
    }
}
