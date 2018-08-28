package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements OnClickListener {
    final /* synthetic */ g nDr;

    g$1(g gVar) {
        this.nDr = gVar;
    }

    public final void onClick(View view) {
        g gVar = this.nDr;
        gVar.nDh++;
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 1);
        intent.putExtra("kwebmap_slat", this.nDr.nDo.nAl.kCw);
        intent.putExtra("kwebmap_lng", this.nDr.nDo.nAl.kCx);
        intent.putExtra("kwebmap_scale", this.nDr.nDo.nAl.bSz);
        intent.putExtra("kPoiName", this.nDr.nDo.nAl.bWB);
        intent.putExtra("Kwebmap_locaion", this.nDr.nDo.nAl.kCz);
        x.i("AdLandingBorderedComp", "locatint to slat " + this.nDr.nDo.nAl.kCw + ", slong " + this.nDr.nDo.nAl.kCx + ", " + this.nDr.nDo.nAl.bWB);
        d.b(this.nDr.context, "location", ".ui.RedirectUI", intent, 2);
    }
}
