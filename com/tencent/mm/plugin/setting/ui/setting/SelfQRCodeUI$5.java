package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ac.f;
import com.tencent.mm.as.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;

class SelfQRCodeUI$5 implements OnCancelListener {
    final /* synthetic */ a mPL;
    final /* synthetic */ SelfQRCodeUI mQy;

    SelfQRCodeUI$5(SelfQRCodeUI selfQRCodeUI, a aVar) {
        this.mQy = selfQRCodeUI;
        this.mPL = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mPL);
        if (s.fq(SelfQRCodeUI.c(this.mQy)) || f.kM(SelfQRCodeUI.c(this.mQy))) {
            this.mQy.finish();
        }
    }
}
