package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$7 implements Runnable {
    final /* synthetic */ VideoSegmentUI lnn;

    VideoSegmentUI$7(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    public final void run() {
        boolean z = true;
        String str = null;
        try {
            VideoSegmentUI.d(this.lnn).stop();
            int e = VideoSegmentUI.e(this.lnn);
            long VG = bi.VG();
            VideoSegmentUI.i(this.lnn).a(VideoSegmentUI.f(this.lnn), VideoSegmentUI.g(this.lnn), VideoSegmentUI.h(this.lnn));
            if (VideoSegmentUI.i(this.lnn).x((long) (VideoSegmentUI.j(this.lnn).beM() * ((float) e)), (long) (((float) e) * VideoSegmentUI.j(this.lnn).beN())) < 0) {
                x.i("MicroMsg.VideoSegmentUI", "clip failed! %s", new Object[]{Integer.valueOf(VideoSegmentUI.i(this.lnn).x((long) (VideoSegmentUI.j(this.lnn).beM() * ((float) e)), (long) (((float) e) * VideoSegmentUI.j(this.lnn).beN())))});
                ah.A(new 1(this));
                return;
            }
            Bitmap mZ = d.mZ(VideoSegmentUI.g(this.lnn));
            if (mZ != null) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (d.a(mZ.getWidth(), mZ.getHeight(), VideoSegmentUI.h(this.lnn).dQS, pInt, pInt2)) {
                    mZ = Bitmap.createScaledBitmap(mZ, pInt.value, pInt2.value, true);
                }
                x.i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", new Object[]{Integer.valueOf(mZ.getWidth()), Integer.valueOf(mZ.getHeight())});
                c.a(mZ, 80, CompressFormat.JPEG, VideoSegmentUI.l(this.lnn), true);
                x.i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", new Object[]{Long.valueOf(bi.bI(VG))});
            } else {
                x.e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
            }
            ah.A(new 2(this, z, str));
        } catch (Throwable e2) {
            Throwable th = e2;
            str = th.getMessage();
            x.printErrStackTrace("MicroMsg.VideoSegmentUI", th, "UnexpectedException when clip : [%s]", new Object[]{th.getMessage()});
            z = false;
        }
    }
}
