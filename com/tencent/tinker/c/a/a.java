package com.tencent.tinker.c.a;

import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.a.a.j;
import com.tencent.tinker.c.a.a.a.l;
import com.tencent.tinker.c.a.a.a.m;
import com.tencent.tinker.c.a.a.a.o;
import com.tencent.tinker.c.a.c.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class a {
    private final i vqf;
    private final i vqg;
    private final com.tencent.tinker.c.a.b.a vqh;
    private final c vqi;
    private com.tencent.tinker.c.a.a.a.i<s> vqj;
    private com.tencent.tinker.c.a.a.a.i<Integer> vqk;
    private com.tencent.tinker.c.a.a.a.i<r> vql;
    private com.tencent.tinker.c.a.a.a.i<n> vqm;
    private com.tencent.tinker.c.a.a.a.i<p> vqn;
    private com.tencent.tinker.c.a.a.a.i<f> vqo;
    private com.tencent.tinker.c.a.a.a.i<u> vqp;
    private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> vqq;
    private com.tencent.tinker.c.a.a.a.i<b> vqr;
    private com.tencent.tinker.c.a.a.a.i<e> vqs;
    private com.tencent.tinker.c.a.a.a.i<g> vqt;
    private com.tencent.tinker.c.a.a.a.i<h> vqu;
    private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> vqv;
    private com.tencent.tinker.c.a.a.a.i<k> vqw;
    private com.tencent.tinker.c.a.a.a.i<d> vqx;

    public a(InputStream inputStream, InputStream inputStream2) {
        this(new i(inputStream), new com.tencent.tinker.c.a.b.a(inputStream2));
    }

    private a(i iVar, com.tencent.tinker.c.a.b.a aVar) {
        this.vqf = iVar;
        this.vqh = aVar;
        this.vqg = new i(aVar.vrf);
        this.vqi = new c();
    }

    public final void a(OutputStream outputStream) {
        int i = 0;
        byte[] mS = this.vqf.mS(false);
        if (mS == null) {
            throw new IOException("failed to compute old dex's signature.");
        } else if (this.vqh == null) {
            throw new IllegalArgumentException("patch file is null.");
        } else {
            if (com.tencent.tinker.a.a.b.c.l(mS, this.vqh.vry) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[]{Arrays.toString(mS), Arrays.toString(this.vqh.vry)}));
            }
            t tVar = this.vqg.voQ;
            tVar.vpk.off = 0;
            tVar.vpk.size = 1;
            tVar.vpr.size = 1;
            tVar.vpl.off = this.vqh.vrh;
            tVar.vpm.off = this.vqh.vri;
            tVar.vps.off = this.vqh.vro;
            tVar.vpn.off = this.vqh.vrj;
            tVar.vpo.off = this.vqh.vrk;
            tVar.vpp.off = this.vqh.vrl;
            tVar.vpq.off = this.vqh.vrm;
            tVar.vpr.off = this.vqh.vrn;
            tVar.vpx.off = this.vqh.vrt;
            tVar.vpz.off = this.vqh.vrv;
            tVar.vpu.off = this.vqh.vrq;
            tVar.vpt.off = this.vqh.vrp;
            tVar.vpB.off = this.vqh.vrx;
            tVar.vpA.off = this.vqh.vrw;
            tVar.vpy.off = this.vqh.vru;
            tVar.vpw.off = this.vqh.vrs;
            tVar.vpv.off = this.vqh.vrr;
            tVar.fileSize = this.vqh.vrf;
            Arrays.sort(tVar.vpC);
            tVar.cGM();
            this.vqj = new com.tencent.tinker.c.a.a.a.n(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqk = new o(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vql = new l(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqm = new j(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqn = new com.tencent.tinker.c.a.a.a.k(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqo = new com.tencent.tinker.c.a.a.a.f(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqp = new com.tencent.tinker.c.a.a.a.p(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqq = new com.tencent.tinker.c.a.a.a.b(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqr = new com.tencent.tinker.c.a.a.a.c(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqs = new com.tencent.tinker.c.a.a.a.e(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqt = new com.tencent.tinker.c.a.a.a.g(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqu = new com.tencent.tinker.c.a.a.a.h(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqv = new com.tencent.tinker.c.a.a.a.a(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqw = new m(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqx = new com.tencent.tinker.c.a.a.a.d(this.vqh, this.vqf, this.vqg, this.vqi);
            this.vqj.execute();
            this.vqk.execute();
            this.vqp.execute();
            this.vql.execute();
            this.vqm.execute();
            this.vqn.execute();
            this.vqv.execute();
            this.vqr.execute();
            this.vqq.execute();
            this.vqx.execute();
            this.vqu.execute();
            this.vqt.execute();
            this.vqs.execute();
            this.vqw.execute();
            this.vqo.execute();
            i.e Hu = this.vqg.Hu(tVar.vpk.off);
            Hu.write(("dex\n" + "035" + "\u0000").getBytes("UTF-8"));
            Hu.writeInt(tVar.epK);
            Hu.write(tVar.kMN);
            Hu.writeInt(tVar.fileSize);
            Hu.writeInt(112);
            Hu.writeInt(305419896);
            Hu.writeInt(tVar.vpD);
            Hu.writeInt(tVar.vpE);
            Hu.writeInt(tVar.vpr.off);
            Hu.writeInt(tVar.vpl.size);
            Hu.writeInt(tVar.vpl.exists() ? tVar.vpl.off : 0);
            Hu.writeInt(tVar.vpm.size);
            Hu.writeInt(tVar.vpm.exists() ? tVar.vpm.off : 0);
            Hu.writeInt(tVar.vpn.size);
            Hu.writeInt(tVar.vpn.exists() ? tVar.vpn.off : 0);
            Hu.writeInt(tVar.vpo.size);
            Hu.writeInt(tVar.vpo.exists() ? tVar.vpo.off : 0);
            Hu.writeInt(tVar.vpp.size);
            Hu.writeInt(tVar.vpp.exists() ? tVar.vpp.off : 0);
            Hu.writeInt(tVar.vpq.size);
            if (tVar.vpq.exists()) {
                i = tVar.vpq.off;
            }
            Hu.writeInt(i);
            Hu.writeInt(tVar.vpF);
            Hu.writeInt(tVar.vpG);
            tVar.b(this.vqg.Hu(tVar.vpr.off));
            this.vqg.cGn();
            outputStream.write(this.vqg.aig.array());
            outputStream.flush();
        }
    }
}
