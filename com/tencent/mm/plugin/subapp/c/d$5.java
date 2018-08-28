package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.g.a.nx;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class d$5 extends c<nx> {
    final /* synthetic */ d orm;

    d$5(d dVar) {
        this.orm = dVar;
        this.sFo = nx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = (int) ((nx) bVar).bYT.bGS.field_msgId;
        au.HU();
        bd dW = com.tencent.mm.model.c.FT().dW((long) i);
        if (!(dW.field_msgId == 0 || dW.field_imgPath == null || bi.oW(dW.field_imgPath))) {
            g Ok = h.Ok(dW.field_imgPath);
            if (!(Ok == null || bi.oW(Ok.field_filename))) {
                Ok.field_status = 3;
                Ok.field_offset = 0;
                Ok.field_createtime = System.currentTimeMillis() / 1000;
                Ok.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Ok.bWA = 16840;
                h.a(Ok);
                x.d("MicroMsg.VoiceRemindLogic", " file:" + Ok.field_filename + " msgid:" + Ok.field_msglocalid + "  stat:" + Ok.field_status);
                if (Ok.field_msglocalid == 0 || bi.oW(Ok.field_user)) {
                    x.e("MicroMsg.VoiceRemindLogic", " failed msg id:" + Ok.field_msglocalid + " user:" + Ok.field_user);
                } else {
                    dW.setStatus(1);
                    au.HU();
                    com.tencent.mm.model.c.FT().a(dW.field_msgId, dW);
                    d.bGu().run();
                }
            }
        }
        return false;
    }
}
