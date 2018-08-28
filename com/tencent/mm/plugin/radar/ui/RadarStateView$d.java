package com.tencent.mm.plugin.radar.ui;

import android.os.Message;
import b.c.b.e;
import com.tencent.mm.sdk.platformtools.ag;

public final class RadarStateView$d extends ag {
    final /* synthetic */ RadarStateView mlN;

    RadarStateView$d(RadarStateView radarStateView) {
        this.mlN = radarStateView;
    }

    public final void handleMessage(Message message) {
        e.i((Object) message, "msg");
        RadarStateView.a(this.mlN);
        this.mlN.bpF();
    }
}
