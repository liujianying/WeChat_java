package c.t.m.g;

import android.os.Bundle;

public class cd$a {
    public String a;
    public boolean b = false;
    public boolean c = false;
    public String d = "";
    public Bundle e;
    private int f;

    public cd$a(int i, String str, boolean z, boolean z2, String str2, Bundle bundle) {
        this.f = i;
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = str2;
        this.e = bundle;
    }

    public final String toString() {
        return "appid:" + this.f + "," + this.a + "," + this.b + "," + this.c + "," + this.d;
    }
}
