package com.tencent.mm.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ClearCacheUI.3;

class ClearCacheUI$3$1 implements Runnable {
    final /* synthetic */ 3 thr;

    ClearCacheUI$3$1(3 3) {
        this.thr = 3;
    }

    public final void run() {
        Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.clear_cache_finish), 0).show();
    }
}
