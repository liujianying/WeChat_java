package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ac.z;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.g;

class BrandServiceSortView$4 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ int hW;
    final /* synthetic */ BrandServiceSortView hqt;
    final /* synthetic */ Context val$context;

    BrandServiceSortView$4(BrandServiceSortView brandServiceSortView, String str, Context context, int i) {
        this.hqt = brandServiceSortView;
        this.dhF = str;
        this.val$context = context;
        this.hW = i;
    }

    public final void run() {
        ((g) com.tencent.mm.kernel.g.l(g.class)).a(z.MY().kA(this.dhF), (Activity) this.val$context, ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(this.dhF), false, new 1(this));
    }
}
