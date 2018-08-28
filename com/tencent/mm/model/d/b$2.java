package com.tencent.mm.model.d;

import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageStats;
import com.tencent.mm.sdk.platformtools.x;

class b$2 extends Stub {
    final /* synthetic */ b dFo;

    b$2(b bVar) {
        this.dFo = bVar;
    }

    public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
        b.d(this.dFo)[0] = packageStats.cacheSize;
        b.d(this.dFo)[1] = packageStats.dataSize;
        b.d(this.dFo)[2] = packageStats.codeSize;
        x.i("MicroMsg.SQLTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", new Object[]{Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize)});
    }
}
