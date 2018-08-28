package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$b extends b {
    final /* synthetic */ a nEe;

    n$a$b(a aVar) {
        this.nEe = aVar;
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                this.nEe.b(this.nEe.nDX);
                return true;
            case 5:
                a.a(this.nEe, "下载失败");
                this.nEe.b(this.nEe.nEa);
                return true;
            case 6:
                this.nEe.b(this.nEe.nDV);
                return true;
            case 10:
                this.nEe.b(this.nEe.nDW);
                return true;
            default:
                return false;
        }
    }

    public final void enter() {
        super.enter();
        AdLandingPagesProxy.getInstance().doAdChannelScene(n.b(this.nEe.nDS).rU, n.b(this.nEe.nDS).channelId, this.nEe.nDS.nDR);
        AdLandingPagesProxy.getInstance().stopTask(n.b(this.nEe.nDS).bPS);
        this.nEe.nDS.nDM.setVisibility(8);
        this.nEe.nDS.nDN.setVisibility(0);
        this.nEe.nDS.nDN.setProgress(0);
        x.i("LogStateTransitionState", "appid %s, channelId %s", new Object[]{n.b(this.nEe.nDS).rU, n.b(this.nEe.nDS).channelId});
    }
}
