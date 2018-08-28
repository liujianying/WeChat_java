package com.tencent.tencentmap.mapsdk.a;

import com.qq.jutil.string.StringUtil;
import java.util.ArrayList;

public class al {
    String a;
    int b;
    int c;
    int d;
    int e;
    ay f;
    int g;
    public au h;
    int i;
    int j;
    boolean k;
    long l;
    String m;
    String n;
    String o;
    String p;
    private int q;

    public int a() {
        return this.c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(c() + "@");
        for (bb d : this.h.c()) {
            stringBuffer.append(d.d() + ":");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.endsWith(":")) {
            return stringBuffer2.substring(0, stringBuffer2.length() - 1);
        }
        return stringBuffer2;
    }

    public void a(au auVar) {
        this.h = auVar;
    }

    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        for (bb c : this.h.c()) {
            stringBuffer.append(c.c() + ":");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.endsWith(":")) {
            return stringBuffer2.substring(0, stringBuffer2.length() - 1);
        }
        return stringBuffer2;
    }

    public static ai<ArrayList<bb>, ArrayList<bb>> a(String str, int i, int i2, int i3, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String a : StringUtil.split(str2, ":")) {
            bb a2 = bb.a(str, a, i, i2, i3);
            if (a2.g()) {
                arrayList.add(a2);
            } else {
                arrayList2.add(a2);
            }
        }
        ai<ArrayList<bb>, ArrayList<bb>> aiVar = new ai();
        aiVar.a = arrayList;
        aiVar.b = arrayList2;
        return aiVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof al) && ((al) obj).q == this.q;
    }

    public int hashCode() {
        return this.q;
    }

    public String c() {
        return this.a;
    }

    public int d() {
        return this.e;
    }

    public ay e() {
        return this.f;
    }

    public String f() {
        return this.n;
    }

    public String g() {
        return this.o;
    }

    public String h() {
        return this.p;
    }
}
