package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import com.tencent.mm.network.n.a;
import com.tencent.mm.pluginsdk.ui.tools.s;

class a$1 extends a {
    private final byte[] cWZ = new byte[0];

    a$1() {
    }

    public final void ev(int i) {
        synchronized (this.cWZ) {
            Bundle bundle = new Bundle();
            bundle.putInt("mm_to_client_notify_type", 1);
            bundle.putString("js_event_name", "onNetWorkChange");
            bundle.putString("netType", s.bUq());
            a.z(bundle);
        }
    }
}
