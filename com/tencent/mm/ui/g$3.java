package com.tencent.mm.ui;

import android.content.Context;
import com.tencent.mm.ui.widget.a.e.b;

class g$3 implements b {
    final /* synthetic */ int eeg;
    final /* synthetic */ String tif;
    final /* synthetic */ Context val$context;

    g$3(Context context, String str, int i) {
        this.val$context = context;
        this.tif = str;
        this.eeg = i;
    }

    public final void b(boolean z, String str) {
        g.p(this.val$context, this.tif, this.eeg);
    }
}
