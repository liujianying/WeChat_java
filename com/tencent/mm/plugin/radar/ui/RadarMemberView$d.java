package com.tencent.mm.plugin.radar.ui;

import android.os.Message;
import android.view.View;
import b.c.b.e;
import com.tencent.mm.plugin.radar.ui.RadarMemberView.a;
import com.tencent.mm.plugin.radar.ui.RadarMemberView.b;
import com.tencent.mm.sdk.platformtools.ag;

public final class RadarMemberView$d extends ag {
    final /* synthetic */ RadarMemberView mlg;

    RadarMemberView$d(RadarMemberView radarMemberView) {
        this.mlg = radarMemberView;
    }

    public final void handleMessage(Message message) {
        e.i(message, "msg");
        int i = message.what;
        a aVar = RadarMemberView.mlf;
        if (i == RadarMemberView.bpz()) {
            RadarMemberView radarMemberView = this.mlg;
            this.mlg.getMember();
            RadarMemberView.a(radarMemberView, this.mlg.getState());
            return;
        }
        i = message.what;
        aVar = RadarMemberView.mlf;
        if (i == RadarMemberView.bpA()) {
            this.mlg.setVisibility(4);
            RadarMemberView.j(this.mlg);
            View k = RadarMemberView.k(this.mlg);
            if (k != null) {
                k.setVisibility(0);
            }
            b a = RadarMemberView.a(this.mlg);
            if (a != null) {
                a.b(this.mlg.getMember(), this.mlg.getState());
            }
        }
    }
}
