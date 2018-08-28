package com.tencent.mm.plugin.appbrand.report;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends d {
    long gqL;
    public long gqM;
    private final c gqN = new c(this, (byte) 0);
    final b gqO = new b(this, (byte) 0);
    final a gqP = new a(this, (byte) 0);
    private boolean gqQ = false;
    public boolean mStopped = false;

    private final class b extends d {
        private long gqT;

        private b() {
        }

        /* synthetic */ b(f fVar, byte b) {
            this();
        }

        public final String getName() {
            return f.this.mName + "|Foreground";
        }

        public final boolean j(Message message) {
            if (1 != message.what) {
                return super.j(message);
            }
            f.this.b(f.this.gqP);
            return true;
        }

        public final void enter() {
            super.enter();
            this.gqT = bi.VF();
        }

        public final void exit() {
            super.exit();
            f.this.gqM = bi.VF() - this.gqT;
        }
    }

    public f(String str) {
        super("MicroMsg.StayingRecorder[" + str + "]", Looper.getMainLooper());
        a(this.gqO);
        a(this.gqP);
        a(this.gqN);
        b(this.gqN);
        start();
    }

    public final boolean amC() {
        return cjn() == this.gqP || this.gqQ;
    }

    public final void amD() {
        x.d(this.mName, "toForeground");
        jG(2);
    }

    public final void amE() {
        x.d(this.mName, "toBackground");
        jG(1);
    }

    private void jG(int i) {
        if (cjm() == null) {
            Dd(i);
        } else if (Looper.myLooper() == this.sJQ.getLooper()) {
            this.sJQ.handleMessage(Message.obtain(this.sJQ, i));
        } else {
            De(i);
        }
    }

    public final void start() {
        if (!this.mStopped) {
            super.start();
        }
    }

    protected final void abD() {
        super.abD();
        this.gqQ = true;
    }
}
