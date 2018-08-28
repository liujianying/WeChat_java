package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cfg;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l extends c {
    private int pJt;
    private String talker;

    public l(int i, String str) {
        this.pJt = i;
        this.talker = str;
    }

    public final String getName() {
        return "WearVoipControllerTask";
    }

    protected final void send() {
        switch (this.pJt) {
            case 20010:
                cfg cfg = new cfg();
                cfg.szk = this.talker;
                cfg.hcS = h.PP(this.talker);
                try {
                    a.bSl();
                    r.b(this.pJt, cfg.toByteArray(), false);
                    return;
                } catch (IOException e) {
                    return;
                }
            case 20011:
            case 20012:
                try {
                    a.bSl();
                    r.b(this.pJt, this.talker.getBytes("utf8"), false);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    return;
                }
            default:
                return;
        }
    }
}
