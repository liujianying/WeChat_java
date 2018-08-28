package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ab.j;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.j.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public class a$a extends j {
    private final a gUS = new a();
    private final b gUT = new b();

    protected final d Ic() {
        return this.gUS;
    }

    public final e Id() {
        return this.gUT;
    }

    public final int getType() {
        return 1000;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/bakchatcreateqrcodeoffline";
    }

    public final int KP() {
        return 1;
    }
}
