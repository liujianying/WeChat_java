package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;

class SnsTransparentUI$2 implements OnDismissListener {
    final /* synthetic */ SnsTransparentUI ofM;

    SnsTransparentUI$2(SnsTransparentUI snsTransparentUI) {
        this.ofM = snsTransparentUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ad.ef(this.ofM);
        this.ofM.finish();
    }
}
