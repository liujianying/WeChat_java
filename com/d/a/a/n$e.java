package com.d.a.a;

class n$e {
    long bjr;
    boolean bjs;
    final /* synthetic */ n bjt;

    private n$e(n nVar) {
        this.bjt = nVar;
        this.bjs = y.bmP;
    }

    /* synthetic */ n$e(n nVar, byte b) {
        this(nVar);
    }

    final void aA(boolean z) {
        if ((this.bjs ^ z) != 0) {
            this.bjs = !this.bjs;
            this.bjt.biT.sK();
            this.bjt.biT.sM();
            this.bjt.biQ.aA(this.bjs);
            this.bjt.sz();
            if (y.bmK) {
                String str = "vehicle mode: " + (this.bjs ? "enable" : "disable");
                o.q("filter_input_log_" + y.bmR, str);
                o.q("filter_output_log_" + y.bmR, str);
            }
        }
    }

    final void reset() {
        this.bjr = 0;
        this.bjs = y.bmP;
    }
}
