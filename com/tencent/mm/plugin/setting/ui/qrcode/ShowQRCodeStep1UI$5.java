package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.as.a;
import com.tencent.mm.kernel.g;

class ShowQRCodeStep1UI$5 implements OnCancelListener {
    final /* synthetic */ ShowQRCodeStep1UI mPK;
    final /* synthetic */ a mPL;

    ShowQRCodeStep1UI$5(ShowQRCodeStep1UI showQRCodeStep1UI, a aVar) {
        this.mPK = showQRCodeStep1UI;
        this.mPL = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mPL);
    }
}
