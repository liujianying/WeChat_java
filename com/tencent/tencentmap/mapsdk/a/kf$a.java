package com.tencent.tencentmap.mapsdk.a;

class kf$a {
    ox[] a = new ox[2];
    final /* synthetic */ kf b;

    kf$a(kf kfVar, ox oxVar, ox oxVar2) {
        this.b = kfVar;
        this.a[0] = oxVar;
        this.a[1] = oxVar2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a[0].toString());
        stringBuilder.append("    ");
        stringBuilder.append(this.a[1].toString());
        return stringBuilder.toString();
    }
}
