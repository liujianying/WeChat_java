package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements ServiceConnection {
    final /* synthetic */ g oxj;

    g$1(g gVar) {
        this.oxj = gVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
        if (iBinder == null) {
            g.a(this.oxj).i("enterTalkRoom bindServie or protocalInit failed", 3, -1);
            return;
        }
        g.a(this.oxj, a.U(iBinder));
        if (g.b(this.oxj) >= 2) {
            new ag(Looper.getMainLooper()).post(new 1(this));
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
    }
}
