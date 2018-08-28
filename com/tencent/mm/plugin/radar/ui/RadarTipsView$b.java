package com.tencent.mm.plugin.radar.ui;

import android.os.Message;
import b.c.b.e;
import com.tencent.mm.sdk.platformtools.ag;

public final class RadarTipsView$b extends ag {
    final /* synthetic */ RadarTipsView mmp;

    RadarTipsView$b(RadarTipsView radarTipsView) {
        this.mmp = radarTipsView;
    }

    public final void handleMessage(Message message) {
        e.i((Object) message, "msg");
        this.mmp.setVisibility(8);
    }
}
