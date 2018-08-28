package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;

class BaseVoicePrintUI$2 implements OnClickListener {
    final /* synthetic */ BaseVoicePrintUI oFR;

    BaseVoicePrintUI$2(BaseVoicePrintUI baseVoicePrintUI) {
        this.oFR = baseVoicePrintUI;
    }

    public final void onClick(View view) {
        this.oFR.finish();
    }
}
