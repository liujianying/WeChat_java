package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class TXLivePusher$6 implements Runnable {
    final /* synthetic */ TXLivePusher this$0;
    final /* synthetic */ String val$coverPath;
    final /* synthetic */ String val$videoFilePath;

    TXLivePusher$6(TXLivePusher tXLivePusher, String str, String str2) {
        this.this$0 = tXLivePusher;
        this.val$videoFilePath = str;
        this.val$coverPath = str2;
    }

    public void run() {
        TXRecordResult tXRecordResult = new TXRecordResult();
        tXRecordResult.retCode = 0;
        tXRecordResult.descMsg = "record success";
        tXRecordResult.videoPath = this.val$videoFilePath;
        tXRecordResult.coverPath = this.val$coverPath;
        if (TXLivePusher.access$600(this.this$0) != null) {
            TXLivePusher.access$600(this.this$0).onRecordComplete(tXRecordResult);
        }
        TXCLog.w(TXLivePusher.access$700(), "record complete success");
    }
}
