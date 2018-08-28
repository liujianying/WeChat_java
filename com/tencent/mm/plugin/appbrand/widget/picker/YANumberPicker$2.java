package com.tencent.mm.plugin.appbrand.widget.picker;

import android.os.Handler;
import android.os.Message;

class YANumberPicker$2 extends Handler {
    final /* synthetic */ YANumberPicker gOL;

    YANumberPicker$2(YANumberPicker yANumberPicker) {
        this.gOL = yANumberPicker;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                YANumberPicker.a(this.gOL, message.arg1, message.arg2, message.obj);
                return;
            case 3:
                this.gOL.requestLayout();
                return;
            default:
                return;
        }
    }
}
