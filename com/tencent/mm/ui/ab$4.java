package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI;

class ab$4 implements OnClickListener {
    final /* synthetic */ ab toE;

    ab$4(ab abVar) {
        this.toE = abVar;
    }

    public final void onClick(View view) {
        h.mEJ.h(11264, new Object[]{Integer.valueOf(1)});
        this.toE.startActivity(new Intent(this.toE.getContext(), SelfQRCodeUI.class));
    }
}
