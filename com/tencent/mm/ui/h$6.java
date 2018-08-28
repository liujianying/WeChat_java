package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI;

class h$6 implements OnClickListener {
    final /* synthetic */ h tiG;

    h$6(h hVar) {
        this.tiG = hVar;
    }

    public final void onClick(View view) {
        this.tiG.startActivity(new Intent(this.tiG.getContext(), SettingsManageFindMoreUI.class));
    }
}
