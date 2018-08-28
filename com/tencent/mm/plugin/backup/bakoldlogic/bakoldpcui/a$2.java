package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements OnClickListener {
    final /* synthetic */ a haA;

    a$2(a aVar) {
        this.haA = aVar;
    }

    public final void onClick(View view) {
        a.a(this.haA, a.asN().asO().gZU);
        if (2 == a.b(this.haA) || 3 == a.b(this.haA) || 5 == a.b(this.haA) || 6 == a.b(this.haA)) {
            x.d(a.ath(), "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(a.asN().asO().gZU), Integer.valueOf(a.c(this.haA))});
            a.d(this.haA);
        } else if (4 == a.b(this.haA)) {
            x.d(a.ath(), "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(a.asN().asO().gZU), Integer.valueOf(a.c(this.haA))});
            a.e(this.haA);
        }
    }
}
