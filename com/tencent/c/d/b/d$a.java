package com.tencent.c.d.b;

public class d$a {
    public String name = "";
    public int pid;
    public int uid;
    public int vjv;
    public String vjw;

    d$a(int i, int i2, String str, int i3, String str2) {
        this.pid = i;
        this.vjv = i2;
        this.name = str;
        this.uid = i3;
        this.vjw = str2;
    }

    public final String toString() {
        return "PID=" + this.pid + " PPID=" + this.vjv + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.vjw;
    }
}
