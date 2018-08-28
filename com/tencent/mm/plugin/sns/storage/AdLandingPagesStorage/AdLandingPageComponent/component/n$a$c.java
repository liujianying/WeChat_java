package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.platformtools.x;

class n$a$c extends b {
    final /* synthetic */ a nEe;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a nEf;

    n$a$c(a aVar) {
        this.nEe = aVar;
    }

    public final void enter() {
        super.enter();
        this.nEe.nDS.nDM.setVisibility(8);
        this.nEe.nDS.nDN.setVisibility(0);
        if (AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS) || AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS)) {
            if (this.nEf == null) {
                this.nEf = new a(this, (byte) 0);
            }
            this.nEe.nDS.nDN.setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS));
            if (!AdLandingPagesProxy.getInstance().resumeTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS, this.nEf, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).nyk, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).nyj)) {
                AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS);
                this.nEe.b(this.nEe.nDV);
            }
        } else if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).downloadUrl)) {
            this.nEe.b(this.nEe.nEb);
        } else if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS)) {
            this.nEe.nDS.nDN.setProgress(100);
            this.nEe.b(this.nEe.nDY);
        } else {
            AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS);
            this.nEf = new a(this, (byte) 0);
            AdLandingPagesProxy.getInstance().startDownload(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).rU, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bKg, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).downloadUrl, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).nzT, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).nzU, this.nEf, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).nyk, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).nyj);
        }
    }

    public final boolean j(Message message) {
        x.i("LogStateTransitionState", "recv msg.what " + message.what);
        switch (message.what) {
            case 0:
                if (AdLandingPagesProxy.getInstance().pauseTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS) && AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS)) {
                    this.nEe.b(this.nEe.nDX);
                }
                return true;
            case 1:
                int i = message.arg1;
                if (i >= 0) {
                    this.nEe.nDS.nDN.setProgress(i);
                }
                return true;
            case 3:
                this.nEe.b(this.nEe.nDZ);
                return true;
            case 7:
                this.nEe.b(this.nEe.nDX);
                return true;
            case 8:
                a.a(this.nEe, "下载失败");
                this.nEe.b(this.nEe.nEa);
                return true;
            case 9:
                if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).nzU) {
                    AdLandingPagesProxy.getInstance().reportDownloadInfo(4, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bPS, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).rU, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).bKg, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.nEe.nDS.nDt).downloadUrl);
                }
                this.nEe.nDS.bAd();
                this.nEe.b(this.nEe.nDY);
                return true;
            default:
                return false;
        }
    }
}
