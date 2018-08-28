package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.aa.c;
import com.tencent.mm.bk.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cdz;
import com.tencent.mm.protocal.c.cea;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class f extends c {
    private String nickname;
    private int type;
    private String username;

    public f(String str, String str2, int i) {
        this.username = str;
        this.nickname = str2;
        this.type = i;
    }

    protected final void send() {
        com.tencent.mm.plugin.wear.model.f PK = a.bSl().pIO.PK(this.username);
        cea cea = new cea();
        if (this.type == 1) {
            cdz cdz = new cdz();
            cdz.jTt = PK.id;
            cdz.hbL = this.username;
            cdz.hcS = this.nickname;
            cdz.jSA = ad.getContext().getString(R.l.notification_receive_new_friend);
            Bitmap a = c.a(this.username, false, -1);
            if (a != null) {
                cdz.szc = new b(h.N(a));
            }
            cea.hbG.add(cdz);
        }
        try {
            a.bSl();
            r.b(20006, cea.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearFriendCreateTask";
    }
}
