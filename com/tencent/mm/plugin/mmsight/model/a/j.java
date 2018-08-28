package com.tencent.mm.plugin.mmsight.model.a;

import android.app.ActivityManager;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class j extends a<byte[]> {
    private static int iNj = 0;
    public static final j lin = new j();

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

    protected final /* synthetic */ Object d(Comparable comparable) {
        return new byte[((Integer) comparable).intValue()];
    }

    private j() {
    }

    /* renamed from: F */
    public final synchronized void aQ(byte[] bArr) {
        super.aQ(bArr);
    }

    /* renamed from: i */
    public final synchronized byte[] c(Integer num) {
        byte[] bArr;
        bArr = (byte[]) super.c(num);
        if (bArr == null) {
            bArr = new byte[num.intValue()];
        }
        return bArr;
    }

    protected final long Fk() {
        if (iNj <= 0) {
            iNj = ((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (iNj >= 512) {
            return 41943040;
        }
        return 20971520;
    }

    protected final long Fl() {
        return 10485760;
    }

    public final void Fm() {
        super.Fm();
    }
}
