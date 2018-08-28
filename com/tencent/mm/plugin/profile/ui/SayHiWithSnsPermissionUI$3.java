package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.bi;

class SayHiWithSnsPermissionUI$3 implements OnFocusChangeListener {
    final /* synthetic */ SayHiWithSnsPermissionUI lYi;

    SayHiWithSnsPermissionUI$3(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        this.lYi = sayHiWithSnsPermissionUI;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z && !bi.K(SayHiWithSnsPermissionUI.b(this.lYi).getHint()) && bi.K(SayHiWithSnsPermissionUI.b(this.lYi).getText())) {
            SayHiWithSnsPermissionUI.b(this.lYi).setText(SayHiWithSnsPermissionUI.b(this.lYi).getHint());
            SayHiWithSnsPermissionUI.b(this.lYi).setOnFocusChangeListener(null);
            SayHiWithSnsPermissionUI.b(this.lYi).setHint(null);
        }
    }
}
