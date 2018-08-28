package com.tencent.tencentmap.mapsdk.a;

import com.qq.jutil.string.StringUtil;
import com.qq.sim.Millis100TimeProvider;

public class bb implements Comparable<bb> {
    String a;
    String b;
    int c;
    protected boolean d;
    String e;
    int f;
    int g;
    int h;
    bf i;
    private int j;
    private long k;
    private String l;

    public static bb a(String str, String str2, int i, int i2, int i3) {
        boolean z = true;
        String toLowerCase = str2.toLowerCase();
        int indexOf = toLowerCase.indexOf("  ");
        while (indexOf >= 0) {
            toLowerCase = StringUtil.replaceAll(toLowerCase, "  ", " ");
            indexOf = toLowerCase.indexOf("  ");
        }
        String[] split = StringUtil.split(toLowerCase, " ");
        if (split.length < 5) {
            throw new bl("node config error " + toLowerCase);
        }
        String str3 = "";
        String str4 = "";
        int i4 = 0;
        boolean z2 = true;
        int i5 = 0;
        while (i4 < split.length) {
            String str5;
            boolean z3;
            if (split[i4].equals("-h")) {
                str3 = split[i4 + 1];
                str5 = str4;
                z3 = z2;
            } else if (split[i4].equals("-p")) {
                i5 = Integer.parseInt(split[i4 + 1]);
                str5 = str4;
                z3 = z2;
            } else if (split[i4].equals("-a")) {
                z3 = Integer.parseInt(split[i4 + 1]);
                str5 = str4;
            } else if (split[i4].equals("-s")) {
                str5 = split[i4 + 1];
                z3 = z2;
            } else {
                str5 = str4;
                z3 = z2;
            }
            i4++;
            str4 = str5;
            z2 = z3;
        }
        bb bbVar = new bb(str, split[0], str3, i5, i, i2);
        if (!z2) {
            z = false;
        }
        bbVar.d = z;
        if (str4 != null && str4.length() > 0) {
            bbVar.a(str4);
        }
        return bbVar;
    }

    public bb(String str, fl flVar) {
        this.d = true;
        this.f = 60000;
        this.e = str;
        if (flVar.d == 0) {
            this.a = "udp";
        } else if (flVar.d == 1) {
            this.a = "tcp";
        }
        this.b = flVar.a;
        this.c = flVar.b;
        this.g = flVar.c;
        this.h = flVar.c;
        b(flVar.e);
        a(flVar.h);
    }

    public bb(String str, String str2, String str3, int i, int i2, int i3) {
        this(str, str2, str3, i, i2, i3, 0);
    }

    public bb(String str, String str2, String str3, int i, int i2, int i3, int i4) {
        this.d = true;
        this.f = 60000;
        this.e = str;
        this.a = str2;
        this.b = str3;
        this.c = i;
        this.g = i2;
        this.h = i3;
        b(i4);
    }

    public String a() {
        return a(this.a, this.b, this.c, this.l);
    }

    public static String a(String str, String str2, int i, String str3) {
        if (str3 == null || str3.length() <= 0) {
            return str + ">" + str2 + ":" + i;
        }
        return str + ">" + str2 + ":" + i + "|" + str3;
    }

    public int b() {
        return this.c;
    }

    @Deprecated
    protected void a(int i) {
    }

    public void a(boolean z) {
        if (z) {
            this.k = Millis100TimeProvider.INSTANCE.currentTimeMillis();
        } else {
            this.k = 0;
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return a();
    }

    public String c() {
        int i = 0;
        if (this.d) {
            i = 1;
        }
        String str = this.a + " -h " + this.b + " -p " + this.c + " -t 3000 -a " + i + " -g " + e();
        if (this.l == null || this.l.length() <= 0) {
            return str;
        }
        return str + " -s " + this.l;
    }

    public String d() {
        return a() + " syncTimeout:" + this.g + " active:" + this.d + " asyncTimeout:" + this.h + " grid:" + e() + " setDivision:" + this.l;
    }

    public boolean equals(Object obj) {
        return (obj instanceof bb) && ((bb) obj).toString().equals(toString());
    }

    public void b(int i) {
        this.j = i;
    }

    public int e() {
        return this.j;
    }

    /* renamed from: a */
    public int compareTo(bb bbVar) {
        return a().hashCode() - bbVar.a().hashCode();
    }

    /* renamed from: f */
    public bb clone() {
        return new bb(this.e, this.a, this.b, this.c, this.g, this.h, this.j);
    }

    public boolean g() {
        return this.d;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public String h() {
        return this.l;
    }

    public void a(String str) {
        this.l = str;
    }
}
