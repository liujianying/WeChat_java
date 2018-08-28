package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.jsapi.h.f;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.Buffer;
import java.nio.ByteBuffer;

class a$a extends ag {
    final /* synthetic */ a lki;

    public a$a(a aVar, Looper looper) {
        this.lki = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            byte[] bArr = (byte[]) message.obj;
            boolean z = message.arg1 == 1;
            long j = (long) message.arg2;
            if (a.c(this.lki) != null) {
                if (a.d(this.lki) == null) {
                    a.a(this.lki, c.beI());
                }
                if (a.e(this.lki) != null) {
                    if (a.f(this.lki) == null) {
                        if (a.g(this.lki) == 90 || a.g(this.lki) == f.CTRL_INDEX) {
                            a.a(this.lki, c.b(a.e(this.lki), (float) (360 - a.g(this.lki))));
                        } else if (a.g(this.lki) == 180) {
                            a.a(this.lki, c.b(a.e(this.lki), 180.0f));
                        }
                        a.a(this.lki, Bitmap.createScaledBitmap(a.e(this.lki), a.d(this.lki).x, a.d(this.lki).y, true));
                        Buffer allocateDirect = ByteBuffer.allocateDirect(a.e(this.lki).getRowBytes() * a.e(this.lki).getHeight());
                        allocateDirect.position(0);
                        a.e(this.lki).copyPixelsToBuffer(allocateDirect);
                        allocateDirect.position(0);
                        a.a(this.lki, new byte[allocateDirect.remaining()]);
                        allocateDirect.get(a.f(this.lki));
                    }
                    SightVideoJNI.blendYuvFrame(bArr, a.f(this.lki), a.d(this.lki).x, a.d(this.lki).y);
                }
                d c = a.c(this.lki);
                int i = a.d(this.lki).x;
                int i2 = a.d(this.lki).y;
                if (z || bArr == null) {
                    c.b(c.lkt, true, j);
                } else {
                    z = (i == c.kGn && i2 == c.kGo) ? false : true;
                    x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c.kGn), Integer.valueOf(c.kGo), Long.valueOf(j)});
                    if (c.lkt == null) {
                        c.lkt = new byte[(((c.kGn * c.kGo) * 3) >> 1)];
                    }
                    if (c.lhv != 19 || z) {
                        MP4MuxerJNI.yuv420pTo420XXAndScale(bArr, c.lkt, c.lku, i, i2, c.kGn, c.kGo);
                    } else {
                        System.arraycopy(bArr, 0, c.lkt, 0, bArr.length);
                    }
                    c.lks++;
                    c.b(c.lkt, false, j);
                }
                j.lin.F(bArr);
            }
        }
    }
}
