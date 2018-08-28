package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.sns.i$l;

class TXCFLVDownloader$1 extends Handler {
    final /* synthetic */ TXCFLVDownloader a;

    TXCFLVDownloader$1(TXCFLVDownloader tXCFLVDownloader, Looper looper) {
        this.a = tXCFLVDownloader;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case i$l.AppCompatTheme_buttonStyle /*100*/:
                TXCFLVDownloader.access$000(this.a);
                return;
            case i$l.AppCompatTheme_buttonStyleSmall /*101*/:
                TXCFLVDownloader.access$100(this.a);
                return;
            case i$l.AppCompatTheme_checkboxStyle /*102*/:
                TXCFLVDownloader.access$200(this.a);
                return;
            case i$l.AppCompatTheme_checkedTextViewStyle /*103*/:
                TXCFLVDownloader.access$300(this.a);
                return;
            case i$l.AppCompatTheme_ratingBarStyle /*106*/:
                try {
                    Looper.myLooper().quit();
                    return;
                } catch (Exception e) {
                    return;
                }
            default:
                return;
        }
    }
}
