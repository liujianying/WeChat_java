package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;

class SnsSettingIntroduceUI$1 implements OnClickListener {
    final /* synthetic */ SnsSettingIntroduceUI oaS;

    SnsSettingIntroduceUI$1(SnsSettingIntroduceUI snsSettingIntroduceUI) {
        this.oaS = snsSettingIntroduceUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(14090, new Object[]{Integer.valueOf(3)});
        d.b(this.oaS, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.a(this.oaS));
        this.oaS.finish();
        this.oaS.overridePendingTransition(0, 0);
    }
}
