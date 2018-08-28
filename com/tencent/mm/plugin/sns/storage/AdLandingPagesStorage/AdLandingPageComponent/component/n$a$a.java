package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.TextUtils;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;

class n$a$a extends b {
    final /* synthetic */ a nEe;

    n$a$a(a aVar) {
        this.nEe = aVar;
    }

    public final void enter() {
        super.enter();
        this.nEe.nDS.nDN.setVisibility(8);
        this.nEe.nDS.nDM.setEnabled(false);
        this.nEe.nDS.nDM.setText(!TextUtils.isEmpty(n.b(this.nEe.nDS).nzW) ? n.b(this.nEe.nDS).nzW : "暂不支持安卓手机");
        this.nEe.nDS.nDM.setVisibility(0);
    }
}
