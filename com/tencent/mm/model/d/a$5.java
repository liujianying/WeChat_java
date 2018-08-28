package com.tencent.mm.model.d;

import android.content.pm.IPackageStatsObserver$Stub;
import android.content.pm.PackageStats;
import com.tencent.mm.sdk.platformtools.x;

class a$5 extends IPackageStatsObserver$Stub {
    final /* synthetic */ a dFa;

    a$5(a aVar) {
        this.dFa = aVar;
    }

    public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
        a.m(this.dFa)[0] = packageStats.cacheSize;
        a.m(this.dFa)[1] = packageStats.dataSize;
        a.m(this.dFa)[2] = packageStats.codeSize;
        x.i("MicroMsg.HandlerTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", new Object[]{Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize)});
    }
}
