package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.a.c.a.c;
import java.util.ArrayList;
import java.util.List;

class g$1 implements c {
    final /* synthetic */ String bAd;
    final /* synthetic */ List frL;
    final /* synthetic */ View qIx;
    final /* synthetic */ ArrayList qIy;

    g$1(View view, ArrayList arrayList, String str, List list) {
        this.qIx = view;
        this.qIy = arrayList;
        this.bAd = str;
        this.frL = list;
    }

    public final void cdN() {
        bi.hideVKB(this.qIx);
        if (this.qIy.size() == 0 && !bi.oW(this.bAd)) {
            g.a(this.qIy, this.frL);
        }
    }
}
