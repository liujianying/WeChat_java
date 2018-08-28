package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.j;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;

public class k$a extends j {
    private final a dZc;
    private final b dZd;
    private final boolean dZe;

    public k$a() {
        this.dZc = new a();
        this.dZd = new b();
        this.dZe = false;
    }

    public k$a(b bVar) {
        this.dZc = new a();
        this.dZd = bVar;
        this.dZe = true;
    }

    public final d Ic() {
        return this.dZc;
    }

    public final e Id() {
        return this.dZd;
    }

    public final int getType() {
        return 138;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/newsync";
    }
}
