package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.IntentFilter;
import android.os.Message;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$g extends b {
    final /* synthetic */ a nEe;

    n$a$g(a aVar) {
        this.nEe = aVar;
    }

    public final void enter() {
        super.enter();
        if (this.nEe.nDS.nDP == null) {
            this.nEe.nDS.nDP = new n.b(this.nEe.nDS, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            this.nEe.nDS.context.registerReceiver(this.nEe.nDS.nDP, intentFilter);
        }
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(n.b(this.nEe.nDS).rU)) {
            this.nEe.b(this.nEe.nDZ);
        } else if (AdLandingPagesProxy.getInstance().isApkExist(n.b(this.nEe.nDS).bPS)) {
            this.nEe.b(this.nEe.nDY);
        } else if (AdLandingPagesProxy.getInstance().isDownloading(n.b(this.nEe.nDS).bPS)) {
            this.nEe.b(this.nEe.nDV);
        } else if (AdLandingPagesProxy.getInstance().isPaused(n.b(this.nEe.nDS).bPS)) {
            this.nEe.b(this.nEe.nDX);
        } else {
            this.nEe.nDS.nDN.setVisibility(8);
            this.nEe.nDS.nDM.setVisibility(0);
            this.nEe.nDS.nDM.setText(n.b(this.nEe.nDS).title);
        }
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                this.nEe.b(this.nEe.nEb);
                return true;
            case 3:
                this.nEe.b(this.nEe.nDZ);
                return true;
            case 11:
                this.nEe.b(this.nEe.nDW);
                return true;
            default:
                return false;
        }
    }
}
