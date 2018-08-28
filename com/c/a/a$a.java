package com.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class a$a extends Handler {
    final /* synthetic */ a bge;
    private final int bgf = 2001;
    private final int bgg = 2002;
    private final int bgh = 2003;
    private final int bgi = 2004;
    private final int bgj = 2005;
    private final int bgk = 2006;

    public a$a(a aVar, Looper looper) {
        this.bge = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = 2005;
        new StringBuilder("what = ").append(message.what);
        switch (message.what) {
            case 1:
                if (this.bge.bgb == null) {
                    return;
                }
                return;
            case 2:
                if (this.bge.bgb == null) {
                    return;
                }
                return;
            case 3:
                if (this.bge.bgb == null) {
                    return;
                }
                return;
            case 6:
                if (this.bge.bgb != null) {
                    this.bge.bgb.aK(0, message.arg1);
                }
                removeMessages(8);
                return;
            case 7:
                if (this.bge.bgb != null) {
                    switch (message.arg1) {
                        case 2001:
                            i = 2002;
                            break;
                        case 2002:
                            i = 2003;
                            break;
                        case 2003:
                        case 2006:
                            break;
                        case 2004:
                            i = 2000;
                            break;
                        case 2005:
                            i = 2006;
                            break;
                        default:
                            i = 2020;
                            break;
                    }
                    this.bge.bgb.aK(i, -1);
                }
                removeMessages(8);
                return;
            case 8:
                if (this.bge.bgb != null) {
                    this.bge.bgb.aK(2001, -1);
                }
                removeMessages(8);
                this.bge.abort();
                return;
            default:
                return;
        }
    }
}
