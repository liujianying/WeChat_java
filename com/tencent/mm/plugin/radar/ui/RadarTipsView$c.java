package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.radar.ui.RadarTipsView.a;
import com.tencent.mm.sdk.platformtools.x;

final class RadarTipsView$c implements OnClickListener {
    final /* synthetic */ RadarTipsView mmp;

    RadarTipsView$c(RadarTipsView radarTipsView) {
        this.mmp = radarTipsView;
    }

    public final void onClick(View view) {
        a aVar = RadarTipsView.mmo;
        x.d(RadarTipsView.access$getTAG$cp(), "noviceEducationTips onclick");
        this.mmp.bpI();
    }
}
