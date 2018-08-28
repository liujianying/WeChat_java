package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class FlipView$6 extends c<kh> {
    final /* synthetic */ FlipView nNe;

    FlipView$6(FlipView flipView) {
        this.nNe = flipView;
        this.sFo = kh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kh khVar = (kh) bVar;
        if (FlipView.i(this.nNe)) {
            if (khVar != null && (khVar instanceof kh)) {
                x.i("MicroMsg.FlipView", "notify Event: %d", new Object[]{Integer.valueOf(khVar.bUG.bUE)});
                if (khVar.bUG.activity == ((Activity) FlipView.e(this.nNe)) && khVar.bUG.bHL.equals(FlipView.f(this.nNe))) {
                    switch (khVar.bUG.bUE) {
                        case 3:
                            ((Activity) FlipView.e(this.nNe)).finish();
                            break;
                    }
                }
                x.e("MicroMsg.FlipView", "not the same");
            } else {
                x.e("MicroMsg.FlipView", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
        } else {
            x.i("MicroMsg.FlipView", "no need to scan image");
        }
        return false;
    }
}
