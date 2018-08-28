package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$h extends b {
    final /* synthetic */ a nEe;
    private boolean nEh;

    n$a$h(a aVar) {
        this.nEe = aVar;
    }

    public final void enter() {
        super.enter();
        if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS)) {
            this.nEe.nDS.nDN.setVisibility(8);
            this.nEe.nDS.nDM.setVisibility(0);
            this.nEe.nDS.nDM.setText("安装应用");
            this.nEh = true;
            return;
        }
        this.nEe.b(this.nEe.nDW);
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                if (AdLandingPagesProxy.getInstance().installApp(this.nEe.nDS.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS)) {
                    this.nEh = true;
                    return true;
                }
                a.a(this.nEe, "安装失败");
                this.nEe.b(this.nEe.nEa);
                return true;
            case 2:
                if (!AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS)) {
                    this.nEe.b(this.nEe.nDW);
                }
                return true;
            case 3:
                if (this.nEh) {
                    this.nEh = false;
                    AdLandingPagesProxy.getInstance().reportDownloadInfo(5, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).rU, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bKg, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).downloadUrl);
                }
                this.nEe.b(this.nEe.nDZ);
                return true;
            default:
                return false;
        }
    }
}
