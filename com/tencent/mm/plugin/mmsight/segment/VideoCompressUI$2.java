package com.tencent.mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Point;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class VideoCompressUI$2 implements Runnable {
    final /* synthetic */ VideoCompressUI lmY;

    VideoCompressUI$2(VideoCompressUI videoCompressUI) {
        this.lmY = videoCompressUI;
    }

    public final void run() {
        try {
            VideoCompressUI.a(this.lmY, VideoCompressUI.c(this.lmY));
            Intent intent = new Intent();
            Point r = VideoCompressUI.r(VideoCompressUI.d(this.lmY).videoWidth, VideoCompressUI.d(this.lmY).videoHeight, VideoCompressUI.a(this.lmY).width, VideoCompressUI.a(this.lmY).height);
            if (VideoCompressUI.b(this.lmY, VideoCompressUI.a(this.lmY)) || r != null) {
                Point point;
                if (r == null) {
                    point = new Point(VideoCompressUI.d(this.lmY).videoWidth, VideoCompressUI.d(this.lmY).videoHeight);
                } else {
                    point = r;
                }
                String bfb = VideoCompressUI.bfb();
                x.i("VideoCompressUI", "need remux, inputVideoSize: [%s %s], out: %s, videoPath: %s, tmpPath: %s", new Object[]{Integer.valueOf(VideoCompressUI.d(this.lmY).videoWidth), Integer.valueOf(VideoCompressUI.d(this.lmY).videoHeight), point, VideoCompressUI.c(this.lmY), bfb});
                SightVideoJNI.remuxing(VideoCompressUI.c(this.lmY), bfb, point.x, point.y, VideoCompressUI.a(this.lmY).videoBitrate, VideoCompressUI.a(this.lmY).dQI, 8, VideoCompressUI.a(this.lmY).dQH, 25.0f, (float) VideoCompressUI.a(this.lmY).fps, null, 0, false);
                intent.putExtra("K_SEGMENTVIDEOPATH", bfb);
                intent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(this.lmY, bfb, null));
            } else {
                x.i("VideoCompressUI", "no need remux, directly set result");
                intent.putExtra("K_SEGMENTVIDEOPATH", VideoCompressUI.c(this.lmY));
                intent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(this.lmY, VideoCompressUI.c(this.lmY), VideoCompressUI.e(this.lmY)));
            }
            this.lmY.setResult(-1, intent);
        } catch (Throwable e) {
            x.printErrStackTrace("VideoCompressUI", e, "video compress failed e [%s]", new Object[]{e.getMessage()});
        } finally {
            this.lmY.finish();
            ah.A(new Runnable() {
                public final void run() {
                    if (VideoCompressUI.f(VideoCompressUI$2.this.lmY) != null) {
                        VideoCompressUI.f(VideoCompressUI$2.this.lmY).dismiss();
                    }
                }
            });
        }
    }
}
