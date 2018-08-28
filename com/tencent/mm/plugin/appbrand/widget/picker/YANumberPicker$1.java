package com.tencent.mm.plugin.appbrand.widget.picker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class YANumberPicker$1 extends Handler {
    final /* synthetic */ YANumberPicker gOL;

    YANumberPicker$1(YANumberPicker yANumberPicker, Looper looper) {
        this.gOL = yANumberPicker;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = 0;
        switch (message.what) {
            case 1:
                if (YANumberPicker.a(this.gOL).isFinished()) {
                    int c;
                    if (YANumberPicker.d(this.gOL) != 0) {
                        if (YANumberPicker.b(this.gOL) == 0) {
                            YANumberPicker.b(this.gOL, 1);
                        }
                        int e;
                        if (YANumberPicker.d(this.gOL) < (-YANumberPicker.e(this.gOL)) / 2) {
                            e = (int) ((((float) (YANumberPicker.e(this.gOL) + YANumberPicker.d(this.gOL))) * 300.0f) / ((float) YANumberPicker.e(this.gOL)));
                            int i2 = 0;
                            YANumberPicker.a(this.gOL).startScroll(0, YANumberPicker.f(this.gOL), i2, YANumberPicker.d(this.gOL) + YANumberPicker.e(this.gOL), e * 3);
                            c = YANumberPicker.c(this.gOL, (YANumberPicker.f(this.gOL) + YANumberPicker.e(this.gOL)) + YANumberPicker.d(this.gOL));
                            i = e;
                        } else {
                            e = (int) ((((float) (-YANumberPicker.d(this.gOL))) * 300.0f) / ((float) YANumberPicker.e(this.gOL)));
                            YANumberPicker.a(this.gOL).startScroll(0, YANumberPicker.f(this.gOL), 0, YANumberPicker.d(this.gOL), e * 3);
                            c = YANumberPicker.c(this.gOL, YANumberPicker.f(this.gOL) + YANumberPicker.d(this.gOL));
                            i = e;
                        }
                        this.gOL.postInvalidate();
                    } else {
                        YANumberPicker.b(this.gOL, 0);
                        c = YANumberPicker.c(this.gOL, YANumberPicker.f(this.gOL));
                    }
                    Message c2 = YANumberPicker.c(2, YANumberPicker.g(this.gOL), c, message.obj);
                    if (YANumberPicker.h(this.gOL)) {
                        YANumberPicker.i(this.gOL).sendMessageDelayed(c2, (long) (i * 2));
                        return;
                    } else {
                        YANumberPicker.c(this.gOL).sendMessageDelayed(c2, (long) (i * 2));
                        return;
                    }
                }
                if (YANumberPicker.b(this.gOL) == 0) {
                    YANumberPicker.b(this.gOL, 1);
                }
                YANumberPicker.c(this.gOL).sendMessageDelayed(YANumberPicker.c(1, 0, 0, message.obj), 32);
                return;
            case 2:
                YANumberPicker.a(this.gOL, message.arg1, message.arg2, message.obj);
                return;
            default:
                return;
        }
    }
}
