package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.R;

class WXBizEntryActivity$2 implements Runnable {
    final /* synthetic */ WXBizEntryActivity hdL;

    WXBizEntryActivity$2(WXBizEntryActivity wXBizEntryActivity) {
        this.hdL = wXBizEntryActivity;
    }

    public final void run() {
        this.hdL.findViewById(R.h.mm_progress_layout).setVisibility(8);
    }
}
