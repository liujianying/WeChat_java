package com.tencent.mm.plugin.facedetect.model;

import android.app.ActivityManager;
import com.tencent.mm.memory.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a<byte[]> {
    public static final c iNi = new c();
    private static int iNj = 0;

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

    public static void cx(int i, int i2) {
        x.i("MicroMsg.FaceByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(5)});
        long VG = bi.VG();
        for (int i3 = 0; i3 < 5; i3++) {
            iNi.aQ(new byte[(((i * i2) * 3) / 2)]);
        }
        x.i("MicroMsg.FaceByteArrayPool", "preloadCameraData used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
    }

    private c() {
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
            x.v("MicroMsg.FaceByteArrayPool", "hy: getExactSize no data");
            bArr = new byte[num.intValue()];
        } else {
            x.v("MicroMsg.FaceByteArrayPool", "hy: got exactSize data");
        }
        return bArr;
    }

    protected final long Fk() {
        if (iNj <= 0) {
            iNj = ((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass();
        }
        if (iNj >= WXMediaMessage.TITLE_LENGTH_LIMIT) {
            return 20971520;
        }
        return 10485760;
    }

    protected final long Fl() {
        return 20971520;
    }

    public final void Fm() {
        super.Fm();
    }
}
