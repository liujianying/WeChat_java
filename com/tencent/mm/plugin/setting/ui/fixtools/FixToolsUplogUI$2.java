package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMWizardActivity;

class FixToolsUplogUI$2 implements OnClickListener {
    final /* synthetic */ FixToolsUplogUI mPy;

    FixToolsUplogUI$2(FixToolsUplogUI fixToolsUplogUI) {
        this.mPy = fixToolsUplogUI;
    }

    public final void onClick(View view) {
        h.mEJ.a(873, 16, 1, false);
        Intent intent = new Intent(this.mPy.mController.tml, FixToolsUpLogUploadingUI.class);
        intent.putExtra("date", FixToolsUplogUI.bP());
        MMWizardActivity.D(this.mPy, intent);
    }
}
