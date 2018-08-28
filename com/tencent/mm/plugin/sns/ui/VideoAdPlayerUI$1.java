package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class VideoAdPlayerUI$1 implements a {
    final /* synthetic */ VideoAdPlayerUI oiz;

    VideoAdPlayerUI$1(VideoAdPlayerUI videoAdPlayerUI) {
        this.oiz = videoAdPlayerUI;
    }

    public final void hM(boolean z) {
        if (z) {
            VideoAdPlayerUI.a(this.oiz).njs.nkt = this.oiz.getResources().getConfiguration().orientation == 2 ? 2 : 1;
            VideoAdPlayerUI.a(this.oiz).njs.nku = bi.VG();
            VideoAdPlayerUI.a(this.oiz).njs.nks = 2;
            VideoAdPlayerUI.a(this.oiz).njs.nkq = 0;
        }
        if (!VideoAdPlayerUI.b(this.oiz) && ((int) VideoAdPlayerUI.c(this.oiz).getLastProgresstime()) == 0) {
            com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.a(this.oiz).njs;
            aVar.nko++;
        }
        VideoAdPlayerUI.a(this.oiz).njs.nku = bi.VG();
        VideoAdPlayerUI.d(this.oiz).a(VideoAdPlayerUI.c(this.oiz));
        if (VideoAdPlayerUI.e(this.oiz) != 0) {
            i iVar = new i(13227, "1,1,0," + VideoAdPlayerUI.f(this.oiz) + "," + VideoAdPlayerUI.g(this.oiz) + "," + bi.VE() + "," + VideoAdPlayerUI.h(this.oiz) + "," + VideoAdPlayerUI.i(this.oiz), (int) bi.VE());
            g.Ek();
            g.Eh().dpP.a(iVar, 0);
        }
        VideoAdPlayerUI.a(this.oiz, true);
    }

    public final void bvZ() {
        VideoAdPlayerUI.d(this.oiz).bv(false);
        com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.a(this.oiz).njs;
        aVar.nkq += (int) bi.bI(VideoAdPlayerUI.a(this.oiz).njs.nku);
        VideoAdPlayerUI.a(this.oiz, false);
    }

    public final void bwa() {
        x.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
        com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.a(this.oiz).njs;
        aVar.nkp++;
        VideoAdPlayerUI.a(this.oiz, false);
        if (VideoAdPlayerUI.e(this.oiz) != 0) {
            i iVar = new i(13227, "1,2," + VideoAdPlayerUI.i(this.oiz) + "," + VideoAdPlayerUI.f(this.oiz) + "," + VideoAdPlayerUI.g(this.oiz) + "," + bi.VE() + "," + VideoAdPlayerUI.h(this.oiz) + "," + VideoAdPlayerUI.i(this.oiz), (int) bi.VE());
            g.Ek();
            g.Eh().dpP.a(iVar, 0);
        }
    }

    public final void bwb() {
        x.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
        VideoAdPlayerUI.a(this.oiz, false);
        VideoAdPlayerUI.c(this.oiz).bvW();
    }

    public final void wf(int i) {
        if (VideoAdPlayerUI.i(this.oiz) == 0) {
            VideoAdPlayerUI.a(this.oiz, i);
            VideoAdPlayerUI.j(this.oiz).oig = i;
        }
    }
}
