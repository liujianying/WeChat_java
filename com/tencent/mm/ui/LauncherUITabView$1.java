package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class LauncherUITabView$1 implements OnClickListener {
    private final long oco = 300;
    final /* synthetic */ LauncherUITabView tlq;

    LauncherUITabView$1(LauncherUITabView launcherUITabView) {
        this.tlq = launcherUITabView;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (LauncherUITabView.a(this.tlq) == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUITabView.b(this.tlq) <= 300) {
            x.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
            LauncherUITabView.c(this.tlq).removeMessages(0);
            a.sFg.m(new jh());
            LauncherUITabView.a(this.tlq, System.currentTimeMillis());
            LauncherUITabView.a(this.tlq, intValue);
            return;
        }
        if (LauncherUITabView.d(this.tlq) != null) {
            if (intValue == 0 && LauncherUITabView.a(this.tlq) == 0) {
                LauncherUITabView.c(this.tlq).sendEmptyMessageDelayed(0, 300);
            } else {
                LauncherUITabView.a(this.tlq, System.currentTimeMillis());
                LauncherUITabView.a(this.tlq, intValue);
                LauncherUITabView.d(this.tlq).oV(intValue);
                return;
            }
        }
        LauncherUITabView.a(this.tlq, System.currentTimeMillis());
        LauncherUITabView.a(this.tlq, intValue);
        x.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[]{(Integer) view.getTag()});
    }
}
