package com.tencent.mm.plugin.appbrand.appusage;

class v$1 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ String dhF;
    final /* synthetic */ int fhP;

    v$1(String str, String str2, int i) {
        this.dhF = str;
        this.bAj = str2;
        this.fhP = i;
    }

    public final void run() {
        v.m(this.dhF, this.bAj, this.fhP);
    }
}
