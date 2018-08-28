package com.tencent.mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.z$d;
import com.tencent.mm.plugin.notification.b;

public class DownloadReceiver extends ResultReceiver {
    private static final String TAG = DownloadReceiver.class.getSimpleName();
    private z$d iby;

    protected void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        if (i == 4657) {
            int i2 = bundle.getInt("progress");
            if (b.lHh != null) {
                if (i2 < 100) {
                    this.iby.b(100, i2, false).c("Download in progress:" + i2);
                    b.lHh.notify(4657, this.iby.build());
                    return;
                }
                this.iby.b(0, 0, false).c("Download Complete");
                b.lHh.notify(4658, this.iby.build());
            }
        }
    }
}
