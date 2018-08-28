package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a;
import com.tencent.mm.ui.base.h;

class SettingsManageAuthUI$a$1 implements OnClickListener {
    final /* synthetic */ int hW;
    final /* synthetic */ a mSy;

    SettingsManageAuthUI$a$1(a aVar, int i) {
        this.mSy = aVar;
        this.hW = i;
    }

    public final void onClick(View view) {
        if (this.mSy.vN(this.hW) != null) {
            c cVar = new c(this.mSy.vN(this.hW).bPS, 1);
            if (SettingsManageAuthUI.f(this.mSy.mSw) != null) {
                SettingsManageAuthUI.f(this.mSy.mSw).dismiss();
            }
            g.DF().a(cVar, 0);
            SettingsManageAuthUI.a(this.mSy.mSw, h.a(this.mSy.mSw, this.mSy.mSw.getString(i.app_sending), true, new 1(this, cVar)));
        }
    }
}
