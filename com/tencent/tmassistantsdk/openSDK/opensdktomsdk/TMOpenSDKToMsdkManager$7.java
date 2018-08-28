package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKContentType;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;
import com.tencent.tmassistantsdk.util.TMLog;

class TMOpenSDKToMsdkManager$7 implements Runnable {
    final /* synthetic */ TMOpenSDKToMsdkManager this$0;
    final /* synthetic */ String val$downloadUrl;
    final /* synthetic */ String val$jumpUrl;

    TMOpenSDKToMsdkManager$7(TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager, String str, String str2) {
        this.this$0 = tMOpenSDKToMsdkManager;
        this.val$jumpUrl = str;
        this.val$downloadUrl = str2;
    }

    public void run() {
        if (!(this.this$0.mContext == null || this.this$0.mOpenSDK == null || TextUtils.isEmpty(this.val$jumpUrl))) {
            this.this$0.insertActionId = this.this$0.mOpenSDK.addDownloadTaskFromAuthorize(this.val$jumpUrl);
        }
        TMAssistantDownloadSDKClient client = this.this$0.getClient();
        if (client != null) {
            try {
                int startDownloadTask = client.startDownloadTask(this.val$downloadUrl, TMAssistantDownloadSDKContentType.CONTENT_TYPE_APK);
                Message message;
                if (4 == startDownloadTask) {
                    String str = client.getDownloadTaskState(this.val$downloadUrl).mSavePath;
                    Message message2 = new Message();
                    message2.what = 0;
                    message2.obj = str;
                    this.this$0.mMainMessageHandler.sendMessage(message2);
                } else if (startDownloadTask == 0) {
                    TMLog.i("OpensdkToMsdkManager", "start success!");
                } else if (1 == startDownloadTask) {
                    message = new Message();
                    message.what = 5;
                    message.obj = Integer.valueOf(1);
                    this.this$0.mMainMessageHandler.sendMessage(message);
                } else {
                    message = new Message();
                    message.what = 3;
                    this.this$0.mMainMessageHandler.sendMessage(message);
                }
                TipsInfoLog createTipsInfoLog;
                if (startDownloadTask == 4) {
                    createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.this$0.mAuthorizedInfo);
                    createTipsInfoLog.installBtnClickCount++;
                    TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                    return;
                }
                createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.this$0.mAuthorizedInfo);
                createTipsInfoLog.downloadBtnClickCount++;
                TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
            } catch (Throwable e) {
                x.printErrStackTrace("OpensdkToMsdkManager", e, "", new Object[0]);
            }
        }
    }
}
