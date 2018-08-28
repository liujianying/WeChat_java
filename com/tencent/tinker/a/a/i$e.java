package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import java.nio.ByteBuffer;

public final class i$e extends a {
    private final String name;
    final /* synthetic */ i voZ;

    /* synthetic */ i$e(i iVar, String str, ByteBuffer byteBuffer, byte b) {
        this(iVar, str, byteBuffer);
    }

    private i$e(i iVar, String str, ByteBuffer byteBuffer) {
        this.voZ = iVar;
        super(byteBuffer);
        this.name = str;
    }

    public final s cGo() {
        a(i.a(this.voZ).vpx, false);
        return super.cGo();
    }

    public final u cGp() {
        a(i.a(this.voZ).vps, false);
        return super.cGp();
    }

    public final n cGq() {
        a(i.a(this.voZ).vpo, false);
        return super.cGq();
    }

    public final p cGr() {
        a(i.a(this.voZ).vpp, false);
        return super.cGr();
    }

    public final r cGs() {
        a(i.a(this.voZ).vpn, false);
        return super.cGs();
    }

    public final f cGt() {
        a(i.a(this.voZ).vpq, false);
        return super.cGt();
    }

    public final g cGu() {
        a(i.a(this.voZ).vpw, false);
        return super.cGu();
    }

    public final h cGv() {
        a(i.a(this.voZ).vpy, false);
        return super.cGv();
    }

    public final e cGw() {
        a(i.a(this.voZ).vpv, false);
        return super.cGw();
    }

    public final a cGx() {
        a(i.a(this.voZ).vpz, false);
        return super.cGx();
    }

    public final b cGy() {
        a(i.a(this.voZ).vpu, false);
        return super.cGy();
    }

    public final c cGz() {
        a(i.a(this.voZ).vpt, false);
        return super.cGz();
    }

    public final d cGA() {
        a(i.a(this.voZ).vpB, false);
        return super.cGA();
    }

    public final k cGB() {
        a(i.a(this.voZ).vpA, false);
        return super.cGB();
    }

    private void a(t.a aVar, boolean z) {
        if (!aVar.vpI) {
            return;
        }
        if (z) {
            super.Hy((((this.aig.position() + 3) & -4) - this.aig.position()) * 1);
            while ((this.aig.position() & 3) != 0) {
                this.aig.put((byte) 0);
            }
            if (this.aig.position() > this.vpO) {
                this.vpO = this.aig.position();
                return;
            }
            return;
        }
        this.aig.position((this.aig.position() + 3) & -4);
    }

    public final int a(s sVar) {
        a(i.a(this.voZ).vpx, true);
        return super.a(sVar);
    }

    public final int a(u uVar) {
        a(i.a(this.voZ).vps, true);
        return super.a(uVar);
    }

    public final int a(n nVar) {
        a(i.a(this.voZ).vpo, true);
        return super.a(nVar);
    }

    public final int a(p pVar) {
        a(i.a(this.voZ).vpp, true);
        return super.a(pVar);
    }

    public final int a(r rVar) {
        a(i.a(this.voZ).vpn, true);
        return super.a(rVar);
    }

    public final int a(f fVar) {
        a(i.a(this.voZ).vpq, true);
        return super.a(fVar);
    }

    public final int a(g gVar) {
        a(i.a(this.voZ).vpw, true);
        return super.a(gVar);
    }

    public final int a(h hVar) {
        a(i.a(this.voZ).vpy, true);
        return super.a(hVar);
    }

    public final int a(e eVar) {
        a(i.a(this.voZ).vpv, true);
        return super.a(eVar);
    }

    public final int a(a aVar) {
        a(i.a(this.voZ).vpz, true);
        return super.a(aVar);
    }

    public final int a(b bVar) {
        a(i.a(this.voZ).vpu, true);
        return super.a(bVar);
    }

    public final int a(c cVar) {
        a(i.a(this.voZ).vpt, true);
        return super.a(cVar);
    }

    public final int a(d dVar) {
        a(i.a(this.voZ).vpB, true);
        return super.a(dVar);
    }

    public final int a(k kVar) {
        a(i.a(this.voZ).vpA, true);
        return super.a(kVar);
    }
}
