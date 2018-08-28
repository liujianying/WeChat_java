package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class AddMoreFriendsUI$4 implements OnClickListener {
    final /* synthetic */ AddMoreFriendsUI otn;

    AddMoreFriendsUI$4(AddMoreFriendsUI addMoreFriendsUI) {
        this.otn = addMoreFriendsUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11264, new Object[]{Integer.valueOf(1)});
        Intent intent = new Intent();
        intent.setClassName(this.otn, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
        this.otn.mController.tml.startActivity(intent);
    }
}
