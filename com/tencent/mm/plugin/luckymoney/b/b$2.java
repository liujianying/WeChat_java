package com.tencent.mm.plugin.luckymoney.b;

class b$2 implements Runnable {
    final /* synthetic */ String ewx;
    final /* synthetic */ int kPA;
    final /* synthetic */ int kPB;

    b$2(String str, int i, int i2) {
        this.ewx = str;
        this.kPA = i;
        this.kPB = i2;
    }

    public final void run() {
        b.W(this.ewx, this.kPA, this.kPB);
    }
}
