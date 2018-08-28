package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.i.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c implements d {
    public static c isX;
    private byte[] cWZ = new byte[0];
    private final Map<Integer, Set<d>> dJw = new HashMap();
    private ah egm = new ah("ExdeviceHandlerThread");
    public m isY;
    a isZ;
    Vector<ae> ita = new Vector();

    public final boolean a(ae aeVar) {
        this.egm.H(new 2(this, aeVar));
        return true;
    }

    final void aGK() {
        x.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[]{Integer.valueOf(this.ita.size())});
        if (!this.ita.isEmpty()) {
            a((ae) this.ita.remove(0));
        }
    }

    public final void a(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(this.ita.size())});
        synchronized (this.cWZ) {
            aGK();
        }
    }
}
