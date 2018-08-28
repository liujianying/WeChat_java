package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.b;
import com.tencent.mm.plugin.topstory.ui.video.l.a;
import com.tencent.mm.sdk.platformtools.x;

class l$3 implements e {
    final /* synthetic */ l oAz;

    l$3(l lVar) {
        this.oAz = lVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        boolean z = true;
        x.i("MicroMsg.TopStory.TopStoryVideoStreamAdapter", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), lVar});
        if (lVar.equals(this.oAz.oAw)) {
            g.DF().b(1943, this.oAz.dKj);
            this.oAz.oAu = false;
            this.oAz.oAw = null;
            b bVar = (b) lVar;
            if (i == 0 && i2 == 0) {
                a aVar = new a(this.oAz, (byte) 0);
                a.a(aVar, bVar.bHD().rjK);
                if (bVar.ozl.offset != 0) {
                    z = false;
                }
                a.a(aVar, z);
                com.tencent.mm.sdk.f.e.post(aVar, "TopStory.DecodeRecommendResultTask");
                return;
            }
            x.e("MicroMsg.TopStory.TopStoryVideoStreamAdapter", "fetch page failed!, response json: %s", new Object[]{bVar.bHD().rjK});
            com.tencent.mm.plugin.websearch.api.a.a.kB(2);
            this.oAz.aK(-1, str);
        }
    }
}
