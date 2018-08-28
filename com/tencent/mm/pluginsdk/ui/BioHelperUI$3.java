package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

class BioHelperUI$3 implements OnClickListener {
    final /* synthetic */ BioHelperUI qEQ;

    BioHelperUI$3(BioHelperUI bioHelperUI) {
        this.qEQ = bioHelperUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", new StringBuilder(BioHelperUI.b(this.qEQ)).toString());
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        d.b(this.qEQ, "webview", ".ui.tools.WebViewUI", intent);
        this.qEQ.finish();
    }
}
