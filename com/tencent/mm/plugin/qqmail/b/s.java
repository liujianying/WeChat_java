package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class s {
    r mds;

    public s() {
        au.HU();
        String str = (String) c.DT().get(282625, "");
        try {
            this.mds = new r();
            this.mds.aG(Base64.decode(str, 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            x.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
            this.mds = new r();
        }
    }

    public final void JV(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mds.lap.size()) {
                break;
            } else if (((q) this.mds.lap.get(i2)).mck.equals(str)) {
                this.mds.lap.remove(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        save();
    }

    static void JW(String str) {
        bd bdVar = new bd();
        bdVar.ep("qqmail");
        bdVar.ay(com.tencent.mm.model.bd.iD("qqmail"));
        bdVar.eX(0);
        bdVar.setContent(String.format(ad.getContext().getString(R.l.send_mail_fail_prompt), new Object[]{str}));
        bdVar.setType(1);
        bdVar.setStatus(3);
        au.HU();
        x.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[]{Long.valueOf(c.FT().T(bdVar))});
    }

    final void save() {
        try {
            x.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[]{Base64.encodeToString(this.mds.toByteArray(), 0)});
            au.HU();
            c.DT().set(282625, r0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            x.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
        }
    }
}
