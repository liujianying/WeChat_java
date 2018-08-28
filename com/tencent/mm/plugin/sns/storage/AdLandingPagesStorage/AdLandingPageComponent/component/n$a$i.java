package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$i extends b {
    final /* synthetic */ a nEe;

    n$a$i(a aVar) {
        this.nEe = aVar;
    }

    public final void enter() {
        super.enter();
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(n.b(this.nEe.nDS).rU)) {
            this.nEe.nDS.nDN.setVisibility(8);
            this.nEe.nDS.nDM.setVisibility(0);
            this.nEe.nDS.nDM.setText("打开应用");
            return;
        }
        this.nEe.b(this.nEe.nDY);
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                if (this.nEe.nDS.bAc()) {
                    return true;
                }
                a.a(this.nEe, "打开失败");
                this.nEe.b(this.nEe.nDZ);
                return true;
            case 4:
                this.nEe.b(this.nEe.nDW);
                AdLandingPagesProxy.getInstance().deleteDeferredDeepLink(n.b(this.nEe.nDS).rU);
                return true;
            default:
                return false;
        }
    }
}
