package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;

public class j$a extends d implements b {
    public eu qWp = new eu();
    public byte[] qWq;

    public final byte[] Ie() {
        this.qWp.shX = k.a(this);
        x.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[]{this.qWq, Integer.valueOf(this.qWp.rfh), this.qWp.rfi, this.qWp.rfj, this.qWp.rfk, Integer.valueOf(this.qWp.otY), Long.valueOf(this.qWp.hbZ), this.qWp.rfl, this.qWp.rfm});
        return this.qWp.toByteArray();
    }

    public final int If() {
        return TbsLog.TBSLOG_CODE_SDK_BASE;
    }

    public final int getCmdId() {
        return TbsLog.TBSLOG_CODE_SDK_BASE;
    }
}
