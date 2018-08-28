package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.1;
import com.tencent.mm.sdk.platformtools.x;

class VideoPlayView$1$1 implements Runnable {
    final /* synthetic */ int gcp;
    final /* synthetic */ int ner;
    final /* synthetic */ 1 nes;

    VideoPlayView$1$1(1 1, int i, int i2) {
        this.nes = 1;
        this.gcp = i;
        this.ner = i2;
    }

    public final void run() {
        x.i("MicroMsg.VideoPlayView", "play time " + this.gcp + " video time " + this.ner);
        if (this.ner > 0) {
            VideoPlayView.b(this.nes.neq, this.ner);
            if (VideoPlayView.c(this.nes.neq) != null && VideoPlayView.h(this.nes.neq)) {
                VideoPlayView.i(this.nes.neq);
            }
            VideoPlayView.f(this.nes.neq).wf(this.ner);
        }
        if (VideoPlayView.c(this.nes.neq) != null) {
            if (VideoPlayView.c(this.nes.neq).getVideoTotalTime() != this.ner) {
                VideoPlayView.c(this.nes.neq).setVideoTotalTime(this.ner);
            }
            VideoPlayView.c(this.nes.neq).seek(this.gcp);
            VideoPlayView.c(this.nes.neq).setIsPlay(true);
        }
        if (VideoPlayView.j(this.nes.neq).getVisibility() == 0) {
            VideoPlayView.j(this.nes.neq).setVisibility(8);
        }
        VideoPlayView.a(this.nes.neq, (double) this.gcp);
    }
}
