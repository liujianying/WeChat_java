package com.tencent.mm.sdk.d;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class d {
    public String mName;
    public volatile c sJQ;
    volatile HandlerThread sJR;

    public d(String str, Looper looper) {
        this.mName = str;
        this.sJQ = new c(looper, this, (byte) 0);
    }

    public final void a(c cVar) {
        c.a(this.sJQ, cVar);
    }

    public final void b(c cVar) {
        c.b(this.sJQ, cVar);
    }

    public final Message cjm() {
        c cVar = this.sJQ;
        if (cVar == null) {
            return null;
        }
        return c.b(cVar);
    }

    public final a cjn() {
        c cVar = this.sJQ;
        if (cVar == null) {
            return null;
        }
        return c.c(cVar);
    }

    public final void b(a aVar) {
        c.a(this.sJQ, aVar);
    }

    public void i(Message message) {
        if (c.d(this.sJQ)) {
            new StringBuilder(" - unhandledMessage: msg.what=").append(message.what);
        }
    }

    public void abD() {
    }

    public boolean h(Message message) {
        return true;
    }

    private Message obtainMessage(int i) {
        return Message.obtain(this.sJQ, i);
    }

    public final void Dd(int i) {
        c cVar = this.sJQ;
        if (cVar != null) {
            cVar.sendMessage(obtainMessage(i));
        }
    }

    public final void De(int i) {
        c cVar = this.sJQ;
        if (cVar != null) {
            cVar.sendMessageAtFrontOfQueue(obtainMessage(i));
        }
    }

    public final void quit() {
        c cVar = this.sJQ;
        if (cVar != null) {
            c.e(cVar);
        }
    }

    public void start() {
        c cVar = this.sJQ;
        if (cVar != null) {
            c.f(cVar);
        }
    }
}
