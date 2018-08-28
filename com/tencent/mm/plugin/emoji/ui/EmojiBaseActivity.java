package com.tencent.mm.plugin.emoji.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity extends MMActivity {
    a ilh;
    b ili;
    private HandlerThread mHandlerThread;

    public abstract void k(Message message);

    public abstract void l(Message message);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandlerThread = e.Xs("EmojiBaseActivity_handlerThread");
        this.mHandlerThread.start();
        this.ilh = new a(this, this.mHandlerThread.getLooper());
        this.ili = new b(this, getMainLooper());
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!(this.ilh == null || this.ilh.getLooper() == null)) {
            this.ilh.getLooper().quit();
        }
        this.mHandlerThread = null;
        this.ilh = null;
        this.ili = null;
    }

    public final void ct(int i, int i2) {
        if (this.ili != null) {
            this.ili.sendEmptyMessageDelayed(i, (long) i2);
        }
    }

    public final void m(Message message) {
        if (this.ili != null) {
            this.ili.sendMessage(message);
        }
    }

    public final void aFD() {
        if (this.ili != null) {
            this.ili.removeMessages(131074);
        }
    }
}
