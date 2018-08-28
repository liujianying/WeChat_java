package com.qq.wx.voice.embed.recognizer;

public final class e {
    public Grammar bgs;
    g bgt;
    byte[] c;
    public boolean d;
    public boolean e;

    public e() {
        this.bgs = null;
        this.bgt = new g();
        this.c = null;
        this.d = false;
        this.e = false;
        this.bgs = new Grammar();
    }

    public final int a(c cVar, byte[] bArr) {
        if (!this.d) {
            return -304;
        }
        if (!this.e) {
            return -302;
        }
        this.bgt.bgu = cVar;
        this.c = bArr;
        if (this.c == null) {
            return -301;
        }
        try {
            new Thread(new a(this, (byte) 0)).start();
            return 0;
        } catch (Exception e) {
            return -302;
        }
    }
}
