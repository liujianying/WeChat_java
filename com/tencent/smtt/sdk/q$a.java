package com.tencent.smtt.sdk;

import com.tencent.smtt.sdk.WebStorage.QuotaUpdater;

class q$a implements QuotaUpdater {
    com.tencent.smtt.export.external.interfaces.QuotaUpdater a;
    final /* synthetic */ q b;

    q$a(q qVar, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        this.b = qVar;
        this.a = quotaUpdater;
    }

    public void updateQuota(long j) {
        this.a.updateQuota(j);
    }
}
