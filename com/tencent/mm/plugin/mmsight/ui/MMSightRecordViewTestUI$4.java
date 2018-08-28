package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ah;

class MMSightRecordViewTestUI$4 implements OnClickListener {
    final /* synthetic */ MMSightRecordViewTestUI loN;

    MMSightRecordViewTestUI$4(MMSightRecordViewTestUI mMSightRecordViewTestUI) {
        this.loN = mMSightRecordViewTestUI;
    }

    public final void onClick(View view) {
        MMSightRecordViewTestUI.a(this.loN).leB.wn();
        ah.i(new 1(this), 5000);
    }
}
