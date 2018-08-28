package com.tencent.mm.booter.notification.a;

import com.tencent.mm.R;
import com.tencent.mm.bf.a;
import com.tencent.mm.k.f;

public final class c {
    public int cZf = -1;

    public final int y(String str, int i) {
        this.cZf = a.cbg();
        if (f.fW(i)) {
            if (f.fm(str)) {
                try {
                    this.cZf = R.g.voip_newmessagetips1;
                } catch (Exception e) {
                }
            } else if (f.fn(str)) {
                try {
                    this.cZf = R.g.voip_newmessagetips1;
                } catch (Exception e2) {
                }
            }
        }
        if (this.cZf < 0) {
            this.cZf = a.cbg();
        }
        return this.cZf;
    }
}
