package com.tencent.tencentmap.mapsdk.a;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class cy {
    private static HashMap<String, byte[]> e = null;
    private HashMap<String, byte[]> a = new HashMap();
    private cv b = new cv();
    private String c = "GBK";
    private cz d = new cz();

    public final void a() {
        this.d.b = 1;
    }

    public final void a(String str) {
        this.d.d = str;
    }

    public final void b(String str) {
        this.d.c = str;
    }

    public final <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            cw cwVar = new cw();
            cwVar.a(this.c);
            cwVar.a(t, 0);
            ByteBuffer a = cwVar.a();
            Object obj = new byte[a.position()];
            System.arraycopy(a.array(), 0, obj, 0, obj.length);
            this.a.put(str, obj);
        }
    }

    public final byte[] b() {
        cw cwVar = new cw(0);
        cwVar.a(this.c);
        cwVar.a(this.a, 0);
        this.d.a = (short) 3;
        cz czVar = this.d;
        ByteBuffer a = cwVar.a();
        Object obj = new byte[a.position()];
        System.arraycopy(a.array(), 0, obj, 0, obj.length);
        czVar.e = obj;
        cwVar = new cw(0);
        cwVar.a(this.c);
        this.d.a(cwVar);
        a = cwVar.a();
        Object obj2 = new byte[a.position()];
        System.arraycopy(a.array(), 0, obj2, 0, obj2.length);
        int length = obj2.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(obj2).flip();
        return allocate.array();
    }

    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            cv cvVar = new cv(bArr, (byte) 0);
            cvVar.a(this.c);
            this.d.a(cvVar);
            cvVar = new cv(this.d.e);
            cvVar.a(this.c);
            if (e == null) {
                HashMap hashMap = new HashMap();
                e = hashMap;
                hashMap.put("", new byte[0]);
            }
            this.a = cvVar.a(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final <T> T b(String str, T t) {
        if (!this.a.containsKey(str)) {
            return null;
        }
        try {
            this.b.a((byte[]) this.a.get(str));
            this.b.a(this.c);
            return this.b.a(t, 0, true);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }
}
