package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.an;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.e.e;

class SnsSettingIntroduceUI$2 implements OnClickListener {
    final /* synthetic */ SnsSettingIntroduceUI oaS;

    SnsSettingIntroduceUI$2(SnsSettingIntroduceUI snsSettingIntroduceUI) {
        this.oaS = snsSettingIntroduceUI;
    }

    public final void onClick(View view) {
        an anVar = new an();
        anVar.bHV.index = 3;
        a.sFg.m(anVar);
        d.b(this.oaS.mController.tml, "setting", ".ui.setting.SettingsUI", new Intent());
        Intent intent = new Intent();
        intent.putExtra("enter_scene", e.thw);
        d.b(this.oaS.mController.tml, "setting", ".ui.setting.SettingsPrivacyUI", intent);
        h.mEJ.h(14090, new Object[]{Integer.valueOf(2)});
        this.oaS.finish();
    }
}
