package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class TXLivePusher$5 implements Runnable {
    final /* synthetic */ TXLivePusher this$0;

    TXLivePusher$5(TXLivePusher tXLivePusher) {
        this.this$0 = tXLivePusher;
    }

    public void run() {
        TXRecordResult tXRecordResult = new TXRecordResult();
        tXRecordResult.retCode = -1;
        tXRecordResult.descMsg = "record video failed";
        if (TXLivePusher.access$600(this.this$0) != null) {
            TXLivePusher.access$600(this.this$0).onRecordComplete(tXRecordResult);
        }
        TXCLog.w(TXLivePusher.access$700(), "record complete fail");
    }
}
