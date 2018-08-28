package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import b.i;
import com.tencent.mm.plugin.radar.b.e$e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.c;
import java.util.LinkedList;

final class RadarViewController$f implements OnClickListener {
    final /* synthetic */ RadarViewController mmN;

    RadarViewController$f(RadarViewController radarViewController) {
        this.mmN = radarViewController;
    }

    public final void onClick(View view) {
        if (this.mmN.getRadarStatus() == e$e.SEARCHING || this.mmN.getRadarStatus() == e$e.SEARCH_RETRUN) {
            Context context = this.mmN.getContext();
            if (context == null) {
                throw new i("null cannot be cast to non-null type android.app.Activity");
            }
            ((Activity) context).finish();
            return;
        }
        RadarViewController radarViewController = this.mmN;
        c d = RadarViewController.d(this.mmN);
        LinkedList linkedList = new LinkedList();
        int length = ((Object[]) d.mmP).length;
        for (int i = 0; i < length; i++) {
            Object obj = d.mmP[i];
            if (obj != null) {
                linkedList.add(obj);
            }
        }
        if (RadarViewController.a(radarViewController, linkedList)) {
            RadarViewController.f(this.mmN).bpO();
            RadarViewController.f(this.mmN).setVisibility(0);
            RadarViewController.c(this.mmN).bps();
            RadarViewController.a(this.mmN, e$e.SEARCH_RETRUN);
        } else {
            RadarViewController.a(this.mmN, e$e.SEARCHING);
        }
        RadarViewController.d(this.mmN).bpx();
    }
}
