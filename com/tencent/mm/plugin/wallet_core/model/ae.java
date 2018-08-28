package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

public final class ae {
    public int prx = 0;

    public ae(int i) {
        g.Ek();
        g.Ei().DT().set(196660, Integer.valueOf(i));
        this.prx = i;
        x.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + i);
    }

    public ae() {
        g.Ek();
        this.prx = ((Integer) g.Ei().DT().get(196660, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.prx);
    }

    public final boolean bPj() {
        boolean z;
        if ((this.prx & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.prx)});
        return z;
    }

    public final boolean bPk() {
        boolean z;
        if ((this.prx & 128) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.prx)});
        return z;
    }

    public final boolean bPl() {
        boolean z;
        if ((this.prx & 256) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.prx)});
        return z;
    }

    public final boolean bPm() {
        boolean z;
        if ((this.prx & 2048) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.prx)});
        return z;
    }

    public final boolean bPn() {
        boolean z;
        if ((this.prx & 65536) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.prx)});
        return z;
    }

    public final boolean bPo() {
        boolean z;
        if ((this.prx & 2097152) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.prx)});
        return z;
    }
}
