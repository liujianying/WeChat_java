package com.tencent.smtt.utils;

class g implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ e b;

    g(e eVar, int i) {
        this.b = eVar;
        this.a = i;
    }

    public void run() {
        this.b.e.setText("已下载" + this.a + "%");
    }
}
