package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.ui.j.6;

class j$6$2 implements OnClickListener {
    final /* synthetic */ String fKy;
    final /* synthetic */ 6 tjj;

    j$6$2(6 6, String str) {
        this.tjj = 6;
        this.fKy = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.setClass(this.tjj.tjf.tiY, BindMobileUI.class);
        intent.putExtra("kstyle_bind_wording", new BindWordingContent(this.fKy, ""));
        MMWizardActivity.D(this.tjj.tjf.tiY, intent);
        dialogInterface.dismiss();
    }
}
