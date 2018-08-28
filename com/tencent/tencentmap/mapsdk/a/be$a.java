package com.tencent.tencentmap.mapsdk.a;

class be$a implements by<Integer, ao> {
    final /* synthetic */ be a;

    public void a(Integer num, ao aoVar, long j) {
        if (aoVar.g()) {
            aoVar.a(new bi("asyncMsg " + aoVar.h() + " waiteResp timeout "));
            az a = az.a(-7, aoVar.h());
            a.a(aoVar);
            this.a.g.e().a(a);
        } else {
            aoVar.a(new bi("msg " + aoVar.h() + " waiteResp timeout "));
        }
        String m = aoVar.m();
        bf bfVar = (bf) this.a.j.get(m);
        if (bfVar != null) {
            aoVar.a();
            bfVar.a(bw.a(this.a.b, aoVar.f(), aoVar.d(), "", aoVar.k(), aoVar.l(), 0, this.a.g.f(), this.a.g.g(), this.a.g.h(), bfVar.d().h()), 2, aoVar.j(), "", false);
            return;
        }
        ax.a(this + " timeoutHandler endPoint " + m + " inactive");
    }
}
