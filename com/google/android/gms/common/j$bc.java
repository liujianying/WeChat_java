package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class j$bc extends j$a {
    private static final WeakReference<byte[]> aQr = new WeakReference(null);
    private WeakReference<byte[]> aQq = aQr;

    j$bc(byte[] bArr) {
        super(bArr);
    }

    final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.aQq.get();
            if (bArr == null) {
                bArr = pL();
                this.aQq = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] pL();
}
