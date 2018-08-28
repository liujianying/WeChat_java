package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.h.a.c.c.a;
import com.tencent.mm.plugin.h.a.c.c.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public BluetoothDevice fNN;
    public long hiL;
    public a hiM = null;
    public com.tencent.mm.plugin.h.a.c.c.b hiN = null;
    public c hiO = null;
    public long mSessionId;
    public int mState = 0;

    public b(long j) {
        this.hiL = j;
        this.mSessionId = j;
        this.fNN = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(com.tencent.mm.plugin.h.a.e.a.bZ(j));
    }

    public final void disconnect() {
        x.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
        this.mState = 0;
        if (this.hiM != null) {
            this.hiM.disconnect();
            this.hiM = null;
        }
        if (this.hiN != null) {
            this.hiN.cancel();
            e.S(this.hiN);
            this.hiN = null;
        }
        if (this.hiO != null) {
            this.hiO.cancel();
            e.S(this.hiN);
            this.hiO = null;
        }
    }
}
