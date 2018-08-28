package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$e extends b {
    final /* synthetic */ a nEe;

    n$a$e(a aVar) {
        this.nEe = aVar;
    }

    public final void enter() {
        super.enter();
        this.nEe.nDS.nDN.setVisibility(8);
        this.nEe.nDS.nDM.setVisibility(0);
        this.nEe.nDS.nDM.setText("继续下载");
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                this.nEe.b(this.nEe.nDV);
                return true;
            case 3:
                this.nEe.b(this.nEe.nDZ);
                return true;
            case 8:
                a.a(this.nEe, "下载失败");
                this.nEe.b(this.nEe.nEa);
                return true;
            default:
                return false;
        }
    }
}
