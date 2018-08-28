package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.cdw;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class e extends c {
    protected final void send() {
        int size = ((i) g.l(i.class)).bcY().bdg().size();
        cdw cdw = new cdw();
        cdw.jTt = a.bSl().pIO.PK(q.GF()).id;
        cdw.bHD = ad.getContext().getString(R.l.app_name);
        cdw.jSA = ad.getContext().getString(R.l.notificaiton_notify_fail_msg, new Object[]{Integer.valueOf(size)});
        try {
            a.bSl();
            r.b(20005, cdw.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearFailMsgCreateTask";
    }
}
