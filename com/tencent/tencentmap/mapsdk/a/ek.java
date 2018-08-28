package com.tencent.tencentmap.mapsdk.a;

import java.nio.ByteBuffer;
import java.util.HashMap;

public class ek extends dj {
    static HashMap<String, byte[]> h = null;
    static HashMap<String, HashMap<String, byte[]>> i = null;
    protected io g;
    private int j;
    private int k;

    public ek() {
        this.g = new io();
        this.j = 0;
        this.k = 0;
        this.g.a = (short) 2;
    }

    public <T> void a(String str, T t) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is " + str);
        }
        super.a(str, t);
    }

    public byte[] a() {
        if (this.g.a != (short) 2) {
            if (this.g.e == null) {
                this.g.e = "";
            }
            if (this.g.f == null) {
                this.g.f = "";
            }
        } else if (this.g.e == null || this.g.e.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.g.f == null || this.g.f.equals("")) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        me meVar = new me(0);
        meVar.a(this.c);
        if (this.g.a == (short) 2 || this.g.a == (short) 1) {
            meVar.a(this.a, 0);
        } else {
            meVar.a(this.e, 0);
        }
        this.g.g = mg.a(meVar.a());
        meVar = new me(0);
        meVar.a(this.c);
        this.g.writeTo(meVar);
        byte[] a = mg.a(meVar.a());
        int length = a.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(a).flip();
        return allocate.array();
    }

    private void b() {
        md mdVar = new md(this.g.g);
        mdVar.a(this.c);
        if (h == null) {
            HashMap hashMap = new HashMap();
            h = hashMap;
            hashMap.put("", new byte[0]);
        }
        this.e = mdVar.a(h, 0, false);
    }

    private void c() {
        md mdVar = new md(this.g.g);
        mdVar.a(this.c);
        if (i == null) {
            i = new HashMap();
            HashMap hashMap = new HashMap();
            hashMap.put("", new byte[0]);
            i.put("", hashMap);
        }
        this.a = mdVar.a(i, 0, false);
        this.b = new HashMap();
    }

    public void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        Object obj = new byte[4];
        System.arraycopy(bArr, 0, obj, 0, 4);
        allocate.put(obj).flip();
        this.j = allocate.getInt();
        try {
            md mdVar = new md(bArr, 4);
            mdVar.a(this.c);
            this.g.readFrom(mdVar);
            if (this.g.a == (short) 3) {
                b();
                return;
            }
            this.e = null;
            c();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void c(String str) {
        this.g.e = str;
    }

    public void d(String str) {
        this.g.f = str;
    }

    public void a(int i) {
        this.g.d = i;
    }
}
