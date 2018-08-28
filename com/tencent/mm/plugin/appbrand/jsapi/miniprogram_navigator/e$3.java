package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.ui.MMActivity.a;

class e$3 implements a {
    final /* synthetic */ g fdq;
    final /* synthetic */ AppBrandInitConfig fdr;

    e$3(g gVar, AppBrandInitConfig appBrandInitConfig) {
        this.fdq = gVar;
        this.fdr = appBrandInitConfig;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == e.KD()) {
            this.fdq.fcr.a(this.fdr, intent == null ? null : (MiniProgramNavigationBackResult) intent.getParcelableExtra("result_key_mini_program_navigate_back_result"), this.fdq);
        }
    }
}
