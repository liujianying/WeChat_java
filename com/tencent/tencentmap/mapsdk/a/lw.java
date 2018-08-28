package com.tencent.tencentmap.mapsdk.a;

public class lw {
    public static lv a(byte[] bArr) {
        lv lvVar = new lv();
        md mdVar = new md(bArr);
        mdVar.a("utf-8");
        lvVar.readFrom(mdVar);
        md mdVar2 = new md(lvVar.h);
        lu luVar = new lu();
        luVar.readFrom(mdVar2);
        if (luVar.b.a == 0) {
            return lvVar;
        }
        throw new Exception(luVar.b.b);
    }

    public static lv a(mf mfVar, int i, String str) {
        mfVar.display(new StringBuilder(), 0);
        lv lvVar = new lv();
        lvVar.a = (short) 0;
        lvVar.b = i;
        lvVar.c = str;
        lvVar.d = 0;
        lvVar.e = (byte) 0;
        lvVar.f = "0";
        lvVar.g = "0";
        lu luVar = new lu();
        luVar.a = System.currentTimeMillis();
        lvVar.h = luVar.toByteArray();
        lvVar.i = mfVar.toByteArray("UTF-8");
        return lvVar;
    }
}
