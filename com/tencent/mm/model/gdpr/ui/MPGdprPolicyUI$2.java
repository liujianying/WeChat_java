package com.tencent.mm.model.gdpr.ui;

import com.tencent.mm.plugin.webview.ui.tools.widget.b;

class MPGdprPolicyUI$2 implements b {
    final /* synthetic */ MPGdprPolicyUI dEr;

    MPGdprPolicyUI$2(MPGdprPolicyUI mPGdprPolicyUI) {
        this.dEr = mPGdprPolicyUI;
    }

    public final boolean iZ(String str) {
        this.dEr.runOnUiThread(new 1(this, str));
        return true;
    }
}
