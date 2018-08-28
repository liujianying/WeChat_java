package com.tencent.rtmp;

import com.tencent.liteav.basic.util.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class TXLivePusher$3 implements Runnable {
    final /* synthetic */ TXLivePusher this$0;
    final /* synthetic */ String val$videoFilePath;

    TXLivePusher$3(TXLivePusher tXLivePusher, String str) {
        this.this$0 = tXLivePusher;
        this.val$videoFilePath = str;
    }

    public void run() {
        File parentFile = new File(this.val$videoFilePath).getParentFile();
        String format = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
        String str = parentFile + File.separator + String.format("TXUGCCover_%s.jpg", new Object[]{format});
        a.a(this.val$videoFilePath, str);
        TXLivePusher.access$400(this.this$0, this.val$videoFilePath, str);
    }
}
