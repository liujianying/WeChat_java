package com.tencent.mm.plugin.j.c;

import com.tencent.mm.plugin.j.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class a implements Runnable {
    private bd bGS;
    private int opType;

    public a(bd bdVar, int i) {
        this.bGS = bdVar;
        this.opType = i;
        x.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.bGS.field_msgId), Integer.valueOf(this.bGS.getType()), Integer.valueOf(this.opType)});
    }

    public final void run() {
        switch (this.opType) {
            case 1:
                b.avr().K(this.bGS);
                return;
            default:
                x.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.opType)});
                return;
        }
    }
}
