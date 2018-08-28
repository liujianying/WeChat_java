package com.tencent.mm.plugin.card.b;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.card.b.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class i$a$2 extends BroadcastReceiver {
    final /* synthetic */ a hux;

    i$a$2(a aVar) {
        this.hux = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.i("MicroMsg.CardLbsOrBluetooth", "Receive intent failed");
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            int state = defaultAdapter.getState();
            x.d("MicroMsg.CardLbsOrBluetooth", "state:%d", new Object[]{Integer.valueOf(state)});
            if (state == 12) {
                this.hux.hus = true;
                ah.i(this.hux.huv, this.hux.huu);
            } else if (state == 10) {
                ah.M(this.hux.huv);
                this.hux.hus = false;
                this.hux.hut.clear();
            }
        }
    }
}
