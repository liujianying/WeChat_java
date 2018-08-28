package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

class ax extends Handler {
    final /* synthetic */ TbsLogReport a;

    ax(TbsLogReport tbsLogReport, Looper looper) {
        this.a = tbsLogReport;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_INTERRUPTED) {
            if (message.obj instanceof TbsLogInfo) {
                TbsLogInfo tbsLogInfo = (TbsLogInfo) message.obj;
                this.a.a(message.arg1, tbsLogInfo);
            }
        } else if (message.what == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CONNECT_TIMEOUT) {
            this.a.g();
        }
    }
}
