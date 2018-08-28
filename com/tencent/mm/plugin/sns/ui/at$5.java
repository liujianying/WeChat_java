package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.e.e;

class at$5 implements OnClickListener {
    final /* synthetic */ at nZP;

    at$5(at atVar) {
        this.nZP = atVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("enter_scene", e.thx);
        d.b(at.a(this.nZP), "setting", ".ui.setting.SettingsPrivacyUI", intent);
        h.mEJ.h(14098, new Object[]{Integer.valueOf(8)});
    }
}
