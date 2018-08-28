package com.tencent.mm.memory;

import java.util.Arrays;

public final class g extends a<byte[]> {
    public static final g dva = new g();

    protected final /* bridge */ /* synthetic */ long aR(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    protected final /* synthetic */ Comparable aS(Object obj) {
        byte[] bArr = (byte[]) obj;
        return (bArr == null || bArr.length <= 0) ? Integer.valueOf(0) : Integer.valueOf(bArr.length);
    }

    protected final /* bridge */ /* synthetic */ Comparable b(Comparable comparable) {
        return (Integer) comparable;
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new f(((Integer) comparable).intValue());
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return new byte[((Integer) comparable).intValue()];
    }

    private g() {
    }

    /* renamed from: F */
    public final synchronized void aQ(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        super.aQ(bArr);
    }

    protected final long Fk() {
        return 5242880;
    }

    protected final long Fl() {
        return 1048576;
    }
}
