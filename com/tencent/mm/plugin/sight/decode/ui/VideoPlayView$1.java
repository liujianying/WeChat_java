package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.ui.tools.f$a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class VideoPlayView$1 implements f$a {
    final /* synthetic */ VideoPlayView neq;

    VideoPlayView$1(VideoPlayView videoPlayView) {
        this.neq = videoPlayView;
    }

    public final void iy() {
        x.d("MicroMsg.VideoPlayView", g.Ab() + " onPrepared");
        VideoPlayView.a(this.neq, true);
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        VideoPlayView.a(this.neq).stop();
    }

    public final void wd() {
        x.d("MicroMsg.VideoPlayView", "on completion " + bi.cjd().toString());
        if (VideoPlayView.b(this.neq)) {
            VideoPlayView.c(this.neq).setIsPlay(false);
            VideoPlayView.a(this.neq, (int) VideoPlayView.g(this.neq));
            VideoPlayView.d(this.neq);
            if (VideoPlayView.f(this.neq) != null) {
                VideoPlayView.f(this.neq).bwb();
                return;
            }
            return;
        }
        VideoPlayView.a(this.neq, 0.0d);
        this.neq.x(0.0d);
        VideoPlayView.c(this.neq).setIsPlay(false);
        VideoPlayView.a(this.neq, 0);
        VideoPlayView.d(this.neq);
        if (System.currentTimeMillis() - VideoPlayView.e(this.neq) < 2000) {
            x.i("MicroMsg.VideoPlayView", "Too short onCompletion");
            return;
        }
        VideoPlayView.a(this.neq, System.currentTimeMillis());
        if (VideoPlayView.f(this.neq) != null) {
            VideoPlayView.f(this.neq).bwa();
        }
    }

    public final int ck(int i, int i2) {
        ah.A(new 1(this, i, i2));
        return 0;
    }

    public final void cl(int i, int i2) {
        VideoPlayView.c(this.neq, i);
        VideoPlayView.d(this.neq, i2);
        if (VideoPlayView.k(this.neq)) {
            VideoPlayView.l(this.neq).post(new 2(this));
        }
    }
}
