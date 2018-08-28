package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.x;

class SettingsManageAuthUI$1 implements OnScrollListener {
    final /* synthetic */ SettingsManageAuthUI mSw;

    SettingsManageAuthUI$1(SettingsManageAuthUI settingsManageAuthUI) {
        this.mSw = settingsManageAuthUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 == i3) {
            x.i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
            if (SettingsManageAuthUI.a(this.mSw) != null) {
                SettingsManageAuthUI.aJ(SettingsManageAuthUI.a(this.mSw));
                SettingsManageAuthUI.b(this.mSw);
            }
        }
    }
}
