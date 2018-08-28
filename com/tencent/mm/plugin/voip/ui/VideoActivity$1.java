package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.g.a.ja;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class VideoActivity$1 extends c<ja> {
    final /* synthetic */ VideoActivity oQn;

    VideoActivity$1(VideoActivity videoActivity) {
        this.oQn = videoActivity;
        this.sFo = ja.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ja) bVar) instanceof ja) {
            x.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent thread name[%s]", new Object[]{Thread.currentThread().getName()});
            ah.A(new 1(this));
        }
        return false;
    }
}
