package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$f extends b {
    final /* synthetic */ a nEe;

    n$a$f(a aVar) {
        this.nEe = aVar;
    }

    public final void enter() {
        super.enter();
        this.nEe.nDS.nDN.setVisibility(8);
        this.nEe.nDS.nDM.setVisibility(0);
        this.nEe.nDS.nDM.setText("重新下载");
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                this.nEe.b(this.nEe.nEb);
                return true;
            default:
                return false;
        }
    }
}
