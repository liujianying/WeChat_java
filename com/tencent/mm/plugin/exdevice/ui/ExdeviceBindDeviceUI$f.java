package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.c;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.d;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.protocal.c.aue;

class ExdeviceBindDeviceUI$f {
    public String iAH;
    public c iBA;
    public d iBB;
    public alx iBC;
    public aly iBD;
    public int iBE;
    public aue iBF;
    public String iBG;
    final /* synthetic */ ExdeviceBindDeviceUI iBf;
    public boolean iBy;
    public int iBz;

    private ExdeviceBindDeviceUI$f(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
        this.iBf = exdeviceBindDeviceUI;
        this.iBy = false;
        this.iBz = b.iBq;
    }

    /* synthetic */ ExdeviceBindDeviceUI$f(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
        this(exdeviceBindDeviceUI);
    }

    public final String getKey() {
        if (this.iBz == b.iBq) {
            return this.iBB.izI + this.iBB.iut;
        }
        return this.iBA.bvw;
    }

    public final String aHN() {
        if (this.iBz != b.iBq) {
            return this.iBA.bvw;
        }
        if (this.iBD == null) {
            return null;
        }
        return this.iBD.rgL;
    }
}
