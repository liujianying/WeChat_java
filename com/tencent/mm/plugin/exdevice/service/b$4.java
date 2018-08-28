package com.tencent.mm.plugin.exdevice.service;

class b$4 implements Runnable {
    final /* synthetic */ long iyA;
    final /* synthetic */ b iyw;
    final /* synthetic */ long iyz;

    b$4(b bVar, long j, long j2) {
        this.iyw = bVar;
        this.iyz = j;
        this.iyA = j2;
    }

    public final void run() {
        b.a(this.iyw, this.iyz, this.iyA);
    }
}
