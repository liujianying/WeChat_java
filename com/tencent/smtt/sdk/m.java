package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;

final class m implements TbsDownloaderCallback {
    final /* synthetic */ Context a;
    final /* synthetic */ PreInitCallback b;

    m(Context context, PreInitCallback preInitCallback) {
        this.a = context;
        this.b = preInitCallback;
    }

    public final void onNeedDownloadFinish(boolean z, int i) {
        if (TbsShareManager.findCoreForThirdPartyApp(this.a) != 0 || TbsShareManager.getCoreDisabled()) {
            if (QbSdk.i && TbsShareManager.isThirdPartyApp(this.a)) {
                TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.a);
            }
            QbSdk.preInit(this.a, this.b);
            return;
        }
        TbsShareManager.forceToLoadX5ForThirdApp(this.a, false);
        if (QbSdk.i && TbsShareManager.isThirdPartyApp(this.a)) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.a);
        }
    }
}
