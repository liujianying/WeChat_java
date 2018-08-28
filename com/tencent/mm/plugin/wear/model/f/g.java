package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cee;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import java.io.IOException;

public final class g extends b {
    private bd bXQ;

    public g(bd bdVar) {
        this.bXQ = bdVar;
    }

    protected final void send() {
        cee cee = new cee();
        String str = this.bXQ.field_content;
        if (str != null) {
            a J = a.J(str, this.bXQ.field_reserved);
            if (J == null || !J.dyc.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                x.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
                return;
            }
            cee.szl = this.bXQ.field_msgId;
            cee.szk = this.bXQ.field_talker;
            str = this.bXQ.field_isSend == 1 ? J.dxW : J.dxV;
            cee.bHD = h.PP(this.bXQ.field_talker);
            if (s.fq(this.bXQ.field_talker)) {
                String d = b.d(this.bXQ.field_talker, this.bXQ);
                cee.jSA = String.format(ad.getContext().getString(R.l.notification_msg_chatroom_template), new Object[]{h.PP(d), Character.valueOf(8203), str});
            } else {
                cee.jSA = str;
            }
            try {
                com.tencent.mm.plugin.wear.model.a.bSl();
                r.b(20014, cee.toByteArray(), true);
                com.tencent.mm.plugin.wear.model.c.a.ee(10, 0);
                com.tencent.mm.plugin.wear.model.c.a.zC(10);
                return;
            } catch (IOException e) {
                return;
            }
        }
        x.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
    }

    public final String getName() {
        return "WearLuckyCreateTask";
    }
}
