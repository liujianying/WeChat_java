package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class g$2 extends a {
    final /* synthetic */ g oxj;

    g$2(g gVar) {
        this.oxj = gVar;
    }

    public final void keep_OnOpenSuccess() {
        x.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
        if (g.b(this.oxj) != 1) {
            x.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", new Object[]{Integer.valueOf(g.b(this.oxj))});
            return;
        }
        b.bGW().bHa();
        new ag(Looper.getMainLooper()).post(new 1(this));
        g.d(this.oxj);
        g.a(this.oxj).St();
    }

    public final void keep_OnError(int i) {
        x.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[]{Integer.valueOf(i)});
        b.bGW().bHa();
        b.bGW().owo = 1;
        g.a(this.oxj).i("component OnError " + i, 99, i);
        new ag(Looper.getMainLooper()).post(new 2(this));
    }
}
