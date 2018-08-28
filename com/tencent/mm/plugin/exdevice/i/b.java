package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a implements d {
    private final d izx;

    public b(c cVar, d dVar) {
        super(cVar, dVar);
        a(this);
        this.izx = dVar;
    }

    public final void a(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (2 == ((h) this.izu).aGE()) {
            x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
            com.tencent.mm.plugin.exdevice.h.b Ak = ad.aHe().Ak(this.izu.hjj);
            if (Ak != null) {
                switch (Ak.field_closeStrategy) {
                    case 1:
                        x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[]{Integer.valueOf(Ak.field_closeStrategy), Long.valueOf(this.izu.hjj)});
                        if (u.aHG().isY != null) {
                            u.aHG().isY.cT(this.izu.hjj);
                            break;
                        }
                        break;
                    case 2:
                        x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[]{Integer.valueOf(Ak.field_closeStrategy), Long.valueOf(this.izu.hjj)});
                        if (!a.A("shut_down_device", this.izu.hjj)) {
                            x.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
                            break;
                        }
                        break;
                    default:
                        x.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", new Object[]{Integer.valueOf(Ak.field_closeStrategy)});
                        break;
                }
            }
            x.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[]{Long.valueOf(this.izu.hjj)});
            if (this.izx != null) {
                this.izx.a(j, i, i2, str);
                return;
            }
            return;
        }
        if (this.izx != null) {
            this.izx.a(j, i, i2, str);
        }
    }
}
