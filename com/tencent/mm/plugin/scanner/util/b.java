package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;

public abstract class b {
    protected static int mMH = 0;
    protected int bJr;
    protected int bJs;
    protected a mME = null;
    protected byte[] mMF = null;
    public String mMG;
    public boolean[] mMI = null;
    protected byte[] mjh = null;

    public abstract boolean a(byte[] bArr, Point point, Rect rect);

    public abstract void bsU();

    public abstract void ll();

    public b(a aVar) {
        this.mME = aVar;
    }

    public final void a(byte[] bArr, Point point, int i, Rect rect) {
        x.d("MicroMsg.scanner.BaseDecoder", "decode task reach");
        final byte[] bArr2 = bArr;
        final int i2 = i;
        final Point point2 = point;
        final Rect rect2 = rect;
        e.b(new Runnable() {
            public final void run() {
                byte[] bArr = bArr2;
                if (270 == i2) {
                    byte[] bArr2 = new byte[bArr2.length];
                    QbarNative.a(bArr2, bArr2, point2.x, point2.y);
                    bArr = new byte[bArr2.length];
                    QbarNative.a(bArr, bArr2, point2.y, point2.x);
                    QbarNative.nativeRelease();
                }
                x.d("MicroMsg.scanner.BaseDecoder", "asyncDecode() resolution:%s, coverage:%s", new Object[]{point2.toString(), rect2.toString()});
                if (bArr == null || !b.this.a(bArr, point2, rect2)) {
                    ah.A(new Runnable() {
                        public final void run() {
                            if (b.this.mME != null) {
                                x.d("MicroMsg.scanner.BaseDecoder", "failed in asyncDecode() resolution:%s, coverage:%s", new Object[]{point2.toString(), rect2.toString()});
                                b.this.mME.bsf();
                            }
                        }
                    });
                } else {
                    ah.A(new 1(this));
                }
            }
        }, "scan_decode", 10);
    }
}
