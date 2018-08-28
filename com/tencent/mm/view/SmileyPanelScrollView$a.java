package com.tencent.mm.view;

import android.os.SystemClock;
import com.tencent.mm.plugin.report.service.h;

public class SmileyPanelScrollView$a implements Runnable {
    long mStartTime;
    long uTm;
    final /* synthetic */ SmileyPanelScrollView uTn;

    public SmileyPanelScrollView$a(SmileyPanelScrollView smileyPanelScrollView) {
        this.uTn = smileyPanelScrollView;
    }

    final void cCc() {
        this.uTm = 300;
        this.mStartTime = SystemClock.uptimeMillis();
        h.mEJ.h(13361, new Object[]{Integer.valueOf(0)});
    }

    public final void run() {
        cCc();
    }
}
