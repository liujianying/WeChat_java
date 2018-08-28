package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class MMSightRecordViewTestUI$6 implements OnClickListener {
    final /* synthetic */ MMSightRecordViewTestUI loN;

    MMSightRecordViewTestUI$6(MMSightRecordViewTestUI mMSightRecordViewTestUI) {
        this.loN = mMSightRecordViewTestUI;
    }

    public final void onClick(View view) {
        MMSightRecordViewTestUI.a(this.loN).leB.switchCamera();
    }
}
