package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class g {
    Handler b = new h(this);
    c bgu;

    public final void a(int i) {
        Message obtainMessage = this.b.obtainMessage(100);
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        obtainMessage.setData(bundle);
        this.b.sendMessage(obtainMessage);
    }
}
