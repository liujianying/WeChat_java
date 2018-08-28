package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends FileObserver {
    private String mQA;
    private a qzu;

    public t(String str, a aVar) {
        super(str);
        x.i("MicroMsg.ScreenshotObserver", "observer  " + str);
        this.qzu = aVar;
    }

    public final void onEvent(int i, String str) {
        if (str != null && i == 8) {
            if (this.mQA == null || !str.equalsIgnoreCase(this.mQA)) {
                this.mQA = str;
                this.qzu.bDa();
                x.i("MicroMsg.ScreenshotObserver", "Send event to listener. " + str);
            }
        }
    }

    public final void start() {
        super.startWatching();
    }

    public final void stop() {
        super.stopWatching();
    }
}
