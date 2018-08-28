package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.cem;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;

public final class i extends c {
    private ArrayList<Integer> pKh;
    private boolean qv = true;

    public i(ArrayList<Integer> arrayList) {
        this.pKh = arrayList;
    }

    public final String getName() {
        return "WearCancelNotificationTask";
    }

    protected final void send() {
        x.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", new Object[]{this.pKh});
        cem cem = new cem();
        if (this.pKh != null) {
            cem.szu.addAll(this.pKh);
        }
        cem.szv = this.qv;
        try {
            a.bSl();
            r.b(20004, cem.toByteArray(), false);
        } catch (IOException e) {
        }
    }
}
