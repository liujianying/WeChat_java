package com.tencent.mm.plugin.shake.b;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ag.a;

public abstract class l$b {
    public l$a mWQ;
    protected boolean mWR = false;
    protected long mWS = l.mWM;
    private ag mWT = new ag(new a() {
        public final boolean handleMessage(Message message) {
            if (!(message.what != l.mWN || l$b.this.mWR || l$b.this.mWQ == null)) {
                l$b.this.mWQ.d(null, 5);
            }
            return false;
        }
    });

    public abstract void init();

    public abstract void pause();

    public abstract void reset();

    public abstract void resume();

    public abstract void start();

    public l$b(l$a l_a) {
        this.mWQ = l_a;
    }

    public void bup() {
        reset();
        this.mWQ = null;
    }
}
