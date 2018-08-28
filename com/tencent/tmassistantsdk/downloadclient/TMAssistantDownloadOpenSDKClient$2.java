package com.tencent.tmassistantsdk.downloadclient;

import android.content.Intent;
import android.os.Handler;
import com.tencent.tmassistantsdk.util.TMLog;

class TMAssistantDownloadOpenSDKClient$2 implements Runnable {
    final /* synthetic */ TMAssistantDownloadOpenSDKClient this$0;
    final /* synthetic */ Handler val$mSDKHandler;

    TMAssistantDownloadOpenSDKClient$2(TMAssistantDownloadOpenSDKClient tMAssistantDownloadOpenSDKClient, Handler handler) {
        this.this$0 = tMAssistantDownloadOpenSDKClient;
        this.val$mSDKHandler = handler;
    }

    public void run() {
        try {
            Intent bindServiceIntent = this.this$0.getBindServiceIntent();
            this.this$0.retryBindResult = this.this$0.mContext.bindService(bindServiceIntent, this.this$0, 1);
        } catch (Exception e) {
            TMLog.e("TMAssistantDownloadOpenSDKClient", "retry bind service Exception:" + e.toString());
        }
        TMAssistantDownloadOpenSDKClient tMAssistantDownloadOpenSDKClient = this.this$0;
        tMAssistantDownloadOpenSDKClient.retryCount++;
        TMLog.i("TMAssistantDownloadOpenSDKClient", "retry bind service! retryBindResult:" + this.this$0.retryBindResult + ",retryCount:" + this.this$0.retryCount);
        if (!this.this$0.retryBindResult && this.this$0.retryCount < 3) {
            this.val$mSDKHandler.postDelayed(this, 1000);
        }
    }
}
