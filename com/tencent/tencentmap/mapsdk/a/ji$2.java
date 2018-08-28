package com.tencent.tencentmap.mapsdk.a;

class ji$2 implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ String b;
    final /* synthetic */ ji c;

    ji$2(ji jiVar, byte[] bArr, String str) {
        this.c = jiVar;
        this.a = bArr;
        this.b = str;
    }

    public void run() {
        try {
            if (this.a == null) {
                ji.a(this.c).b(this.b);
            }
            ji.a(this.c).a(this.b, this.a);
        } catch (Exception e) {
        }
    }
}
