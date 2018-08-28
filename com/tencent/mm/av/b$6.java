package com.tencent.mm.av;

import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.mm.sdk.platformtools.x;

class b$6 implements ServerMessageListener {
    final /* synthetic */ b eel;

    b$6(b bVar) {
        this.eel = bVar;
    }

    public final void onMessage(int i, String str) {
        x.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[]{Integer.valueOf(i), str});
        if (i != 0 && b.o(this.eel) > 3) {
            x.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[]{Integer.valueOf(3)});
            b.QE();
            this.eel.Qx();
        }
    }
}
