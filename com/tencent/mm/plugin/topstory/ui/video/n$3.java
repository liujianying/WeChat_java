package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.sdk.platformtools.x;

class n$3 implements b {
    final /* synthetic */ n oBM;

    n$3(n nVar) {
        this.oBM = nVar;
    }

    public final void ajO() {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "onSeekPre");
        n.f(this.oBM).bTv();
    }

    public final void kV(int i) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "onSeekTo %d", new Object[]{Integer.valueOf(i)});
        this.oBM.seekTo(i);
        n.f(this.oBM).bTw();
        a.kB(22);
    }
}
