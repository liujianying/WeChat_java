package com.tencent.mm.plugin.setting.ui.fixtools;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.a.a;
import com.tencent.mm.sdk.platformtools.x;

class FixToolsUpLogUploadingUI$3 implements a {
    final /* synthetic */ FixToolsUpLogUploadingUI mPr;

    FixToolsUpLogUploadingUI$3(FixToolsUpLogUploadingUI fixToolsUpLogUploadingUI) {
        this.mPr = fixToolsUpLogUploadingUI;
    }

    public final void vK(int i) {
        x.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", new Object[]{Integer.valueOf(i)});
        if (i < 0) {
            h.mEJ.a(873, 18, 1, false);
            FixToolsUpLogUploadingUI.c(this.mPr).setImageResource(com.tencent.mm.plugin.setting.a.h.fix_tools_failed);
            FixToolsUpLogUploadingUI.d(this.mPr).setText(i.fix_tools_uplog_fail);
            this.mPr.mPq.setVisibility(8);
            FixToolsUpLogUploadingUI.e(this.mPr).setVisibility(0);
        } else if (i >= 100) {
            h.mEJ.a(873, 17, 1, false);
            FixToolsUpLogUploadingUI.c(this.mPr).setImageResource(com.tencent.mm.plugin.setting.a.h.fix_tools_finish);
            FixToolsUpLogUploadingUI.d(this.mPr).setText(i.fix_tools_uplog_success);
            this.mPr.mPq.setVisibility(8);
            FixToolsUpLogUploadingUI.e(this.mPr).setVisibility(0);
        } else {
            this.mPr.mPq.setProgress(i);
        }
    }
}
