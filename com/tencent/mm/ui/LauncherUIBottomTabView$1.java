package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class LauncherUIBottomTabView$1 implements OnClickListener {
    private final long oco = 300;
    final /* synthetic */ LauncherUIBottomTabView tlb;

    LauncherUIBottomTabView$1(LauncherUIBottomTabView launcherUIBottomTabView) {
        this.tlb = launcherUIBottomTabView;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (LauncherUIBottomTabView.a(this.tlb) == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUIBottomTabView.b(this.tlb) <= 300) {
            x.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
            LauncherUIBottomTabView.c(this.tlb).removeMessages(0);
            a.sFg.m(new jh());
            LauncherUIBottomTabView.a(this.tlb, System.currentTimeMillis());
            LauncherUIBottomTabView.a(this.tlb, intValue);
            return;
        }
        if (LauncherUIBottomTabView.d(this.tlb) != null) {
            if (intValue == 0 && LauncherUIBottomTabView.a(this.tlb) == 0) {
                x.v("MicroMsg.LauncherUITabView", "do double click check");
                LauncherUIBottomTabView.c(this.tlb).sendEmptyMessageDelayed(0, 300);
            } else {
                x.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
                LauncherUIBottomTabView.a(this.tlb, System.currentTimeMillis());
                LauncherUIBottomTabView.a(this.tlb, intValue);
                LauncherUIBottomTabView.d(this.tlb).oV(intValue);
                return;
            }
        }
        LauncherUIBottomTabView.a(this.tlb, System.currentTimeMillis());
        LauncherUIBottomTabView.a(this.tlb, intValue);
        x.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[]{(Integer) view.getTag()});
    }
}
