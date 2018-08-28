package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

class AppBrandAuthorizeUI$5 implements OnClickListener {
    final /* synthetic */ AppBrandAuthorizeUI guf;
    final /* synthetic */ eb gug;
    final /* synthetic */ Preference guh;
    final /* synthetic */ f gui;

    AppBrandAuthorizeUI$5(AppBrandAuthorizeUI appBrandAuthorizeUI, eb ebVar, Preference preference, f fVar) {
        this.guf = appBrandAuthorizeUI;
        this.gug = ebVar;
        this.guh = preference;
        this.gui = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state open");
        this.gug.state = 1;
        ((CheckBoxPreference) this.guh).qpJ = true;
        this.gui.notifyDataSetChanged();
    }
}
