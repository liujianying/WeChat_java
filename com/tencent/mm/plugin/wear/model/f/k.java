package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.cer;
import java.io.IOException;

public final class k extends c {
    private String bIr;
    private int code;

    public k(int i, String str) {
        this.code = i;
        this.bIr = str;
    }

    protected final void send() {
        cer cer = new cer();
        switch (this.code) {
            case 0:
                cer.spd = 0;
                break;
            case 6:
                cer.spd = 196610;
                break;
            case 7:
                cer.spd = 196615;
                break;
            case 8:
                cer.spd = 196614;
                break;
            case 9:
                cer.spd = 196613;
                break;
        }
        cer.syk = this.bIr;
        try {
            a.bSl();
            r.b(20016, cer.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearPushPayResponseTask";
    }
}
