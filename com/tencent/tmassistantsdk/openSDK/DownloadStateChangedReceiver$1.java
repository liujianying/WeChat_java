package com.tencent.tmassistantsdk.openSDK;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;

class DownloadStateChangedReceiver$1 implements Runnable {
    final /* synthetic */ DownloadStateChangedReceiver this$0;
    final /* synthetic */ Intent val$intent;

    DownloadStateChangedReceiver$1(DownloadStateChangedReceiver downloadStateChangedReceiver, Intent intent) {
        this.this$0 = downloadStateChangedReceiver;
        this.val$intent = intent;
    }

    public void run() {
        TMQQDownloaderStateChangeParam tMQQDownloaderStateChangeParam = new TMQQDownloaderStateChangeParam();
        tMQQDownloaderStateChangeParam.hostPackageName = this.val$intent.getStringExtra("hostPackageName");
        tMQQDownloaderStateChangeParam.hostVersion = this.val$intent.getStringExtra("hostVersion");
        tMQQDownloaderStateChangeParam.taskId = this.val$intent.getStringExtra("taskId");
        tMQQDownloaderStateChangeParam.errorCode = bi.getInt(this.val$intent.getStringExtra("errorCode"), 0);
        tMQQDownloaderStateChangeParam.errorMsg = this.val$intent.getStringExtra("errorMsg");
        tMQQDownloaderStateChangeParam.state = bi.getInt(this.val$intent.getStringExtra("state"), 0);
        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam();
        tMQQDownloaderOpenSDKParam.SNGAppId = this.val$intent.getStringExtra("sngAppId");
        tMQQDownloaderOpenSDKParam.taskAppId = this.val$intent.getStringExtra("taskAppId");
        tMQQDownloaderOpenSDKParam.taskApkId = this.val$intent.getStringExtra("taskApkId");
        tMQQDownloaderOpenSDKParam.taskPackageName = this.val$intent.getStringExtra("taskPackageName");
        tMQQDownloaderOpenSDKParam.taskVersion = bi.getInt(this.val$intent.getStringExtra("taskVersion"), 0);
        tMQQDownloaderOpenSDKParam.via = this.val$intent.getStringExtra("via");
        tMQQDownloaderOpenSDKParam.uin = this.val$intent.getStringExtra("uin");
        tMQQDownloaderOpenSDKParam.uinType = this.val$intent.getStringExtra("uinType");
        tMQQDownloaderStateChangeParam.param = tMQQDownloaderOpenSDKParam;
        Iterator it = this.this$0.mListeners.iterator();
        while (it.hasNext()) {
            ((IDownloadStateChangedListener) it.next()).onDownloadStateChanged(tMQQDownloaderStateChangeParam);
        }
    }
}
