package com.tencent.mm.plugin.radar.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.widget.a.c;

final class RadarMemberView$m implements OnClickListener {
    final /* synthetic */ RadarMemberView mlg;

    RadarMemberView$m(RadarMemberView radarMemberView) {
        this.mlg = radarMemberView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (RadarMemberView.g(this.mlg) != null) {
            c g = RadarMemberView.g(this.mlg);
            if (g != null) {
                g.dismiss();
            }
            RadarMemberView.h(this.mlg);
        }
        RadarMemberView.i(this.mlg);
    }
}
