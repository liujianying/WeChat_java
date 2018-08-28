package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.ui.MMWizardActivity;

class BindMobileOrQQHeaderView$1 implements OnClickListener {
    final /* synthetic */ BindMobileOrQQHeaderView lBy;

    BindMobileOrQQHeaderView$1(BindMobileOrQQHeaderView bindMobileOrQQHeaderView) {
        this.lBy = bindMobileOrQQHeaderView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.lBy.getContext(), BindMContactIntroUI.class);
        intent.putExtra("key_upload_scene", 7);
        MMWizardActivity.D(this.lBy.getContext(), intent);
        if (g.IW().iP("3") != null) {
            g.IW().iP("3").result = "1";
            f.iU("3");
        }
    }
}
