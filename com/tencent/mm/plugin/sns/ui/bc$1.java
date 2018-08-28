package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;

class bc$1 implements OnDismissListener {
    bc$1() {
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        g.Ek();
        int a = bi.a((Integer) g.Ei().DT().get(68385, null), 0) + 1;
        g.Ek();
        g.Ei().DT().set(68385, Integer.valueOf(a));
    }
}
