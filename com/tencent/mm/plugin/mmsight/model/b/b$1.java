package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.b.c.a;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.Buffer;
import java.nio.ByteBuffer;

class b$1 implements a {
    final /* synthetic */ b lkk;

    b$1(b bVar) {
        this.lkk = bVar;
    }

    public final void a(byte[] bArr, boolean z, long j) {
        if (b.a(this.lkk) == null) {
            b.a(this.lkk, c.beI());
        }
        if (b.b(this.lkk) != null) {
            if (b.c(this.lkk) == null) {
                if (b.d(this.lkk) == 90 || b.d(this.lkk) == 270) {
                    b.a(this.lkk, c.b(b.b(this.lkk), (float) (360 - b.d(this.lkk))));
                } else if (b.d(this.lkk) == 180) {
                    b.a(this.lkk, c.b(b.b(this.lkk), 180.0f));
                }
                b.a(this.lkk, Bitmap.createScaledBitmap(b.b(this.lkk), b.a(this.lkk).x, b.a(this.lkk).y, true));
                Buffer allocateDirect = ByteBuffer.allocateDirect(b.b(this.lkk).getRowBytes() * b.b(this.lkk).getHeight());
                allocateDirect.position(0);
                b.b(this.lkk).copyPixelsToBuffer(allocateDirect);
                allocateDirect.position(0);
                b.a(this.lkk, new byte[allocateDirect.remaining()]);
                allocateDirect.get(b.c(this.lkk));
            }
            SightVideoJNI.blendYuvFrame(bArr, b.c(this.lkk), b.a(this.lkk).x, b.a(this.lkk).y);
        }
        if (b.e(this.lkk) != null) {
            e e = b.e(this.lkk);
            int i = b.a(this.lkk).x;
            int i2 = b.a(this.lkk).y;
            if (bArr != null) {
                boolean z2 = (i == e.kGn && i2 == e.kGo) ? false : true;
                x.d("MicroMsg.MMSightRemuxX264Encoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(e.kGn), Integer.valueOf(e.kGo), Long.valueOf(j)});
                MP4MuxerJNI.writeYuvDataForSegment(bArr, i, i2, e.kGn, e.kGo, 2, e.fau, e.fav);
                e.frameCount++;
            }
        }
        j.lin.aQ(bArr);
        if (z && b.e(this.lkk) != null) {
            e e2 = b.e(this.lkk);
            if (e2.lkv != null) {
                e2.lkv.lkx = true;
            }
        }
    }
}
