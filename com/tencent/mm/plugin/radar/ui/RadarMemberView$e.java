package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.radar.ui.RadarMemberView.b;
import com.tencent.mm.protocal.c.beq;

final class RadarMemberView$e implements OnClickListener {
    final /* synthetic */ RadarMemberView mlg;
    final /* synthetic */ beq mlh;

    RadarMemberView$e(RadarMemberView radarMemberView, beq beq) {
        this.mlg = radarMemberView;
        this.mlh = beq;
    }

    public final void onClick(View view) {
        if (this.mlg.getState() != null && RadarMemberView.a(this.mlg) != null) {
            b a = RadarMemberView.a(this.mlg);
            if (a != null) {
                a.a(this.mlh, this.mlg.getState());
            }
            this.mlg.dismiss();
        }
    }
}
