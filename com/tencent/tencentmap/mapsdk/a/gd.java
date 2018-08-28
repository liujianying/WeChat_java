package com.tencent.tencentmap.mapsdk.a;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class gd {
    private static HashMap e = null;
    private HashMap a = new HashMap();
    private ga b = new ga();
    private String c = "GBK";
    private ge d = new ge();

    public final void a(int i) {
        this.d.b = i;
    }

    public final void a(String str) {
        this.d.d = str;
    }

    public final void a(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (obj == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (obj instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            gb gbVar = new gb();
            gbVar.a(this.c);
            gbVar.a(obj, 0);
            ByteBuffer a = gbVar.a();
            Object obj2 = new byte[a.position()];
            System.arraycopy(a.array(), 0, obj2, 0, obj2.length);
            this.a.put(str, obj2);
        }
    }

    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            ga gaVar = new ga(bArr, 4);
            gaVar.a(this.c);
            this.d.a(gaVar);
            gaVar = new ga(this.d.e);
            gaVar.a(this.c);
            if (e == null) {
                HashMap hashMap = new HashMap();
                e = hashMap;
                hashMap.put("", new byte[0]);
            }
            this.a = gaVar.a(e, 0, false);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final byte[] a() {
        gb gbVar = new gb(0);
        gbVar.a(this.c);
        gbVar.a(this.a, 0);
        this.d.a = (short) 3;
        ge geVar = this.d;
        ByteBuffer a = gbVar.a();
        Object obj = new byte[a.position()];
        System.arraycopy(a.array(), 0, obj, 0, obj.length);
        geVar.e = obj;
        gbVar = new gb(0);
        gbVar.a(this.c);
        this.d.a(gbVar);
        a = gbVar.a();
        Object obj2 = new byte[a.position()];
        System.arraycopy(a.array(), 0, obj2, 0, obj2.length);
        int length = obj2.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(obj2).flip();
        return allocate.array();
    }

    public final Object b(String str, Object obj) {
        if (!this.a.containsKey(str)) {
            return null;
        }
        try {
            this.b.a((byte[]) this.a.get(str));
            this.b.a(this.c);
            return this.b.a(obj, 0, true);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    public final void b(String str) {
        this.d.c = str;
    }
}
