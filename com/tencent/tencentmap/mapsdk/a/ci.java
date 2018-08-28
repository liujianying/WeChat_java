package com.tencent.tencentmap.mapsdk.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ci {
    protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
    protected HashMap<String, Object> b = new HashMap();
    protected String c = "GBK";
    md d = new md();
    private HashMap<String, Object> e = new HashMap();

    ci() {
    }

    public void a(String str) {
        this.c = str;
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            me meVar = new me();
            meVar.a(this.c);
            meVar.a((Object) t, 0);
            Object a = mg.a(meVar.a());
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            a(arrayList, (Object) t);
            hashMap.put(ag.a(arrayList), a);
            this.e.remove(str);
            this.a.put(str, hashMap);
        }
    }

    public <T> T a(String str, boolean z, ClassLoader classLoader) {
        String str2 = null;
        if (!this.a.containsKey(str)) {
            return null;
        }
        if (this.e.containsKey(str)) {
            return this.e.get(str);
        }
        byte[] bArr;
        byte[] bArr2 = new byte[0];
        Iterator it = ((HashMap) this.a.get(str)).entrySet().iterator();
        if (it.hasNext()) {
            Entry entry = (Entry) it.next();
            str2 = (String) entry.getKey();
            bArr = (byte[]) entry.getValue();
        } else {
            bArr = bArr2;
        }
        try {
            Object b = b(str2, z, classLoader);
            this.d.a(bArr);
            this.d.a(this.c);
            T a = this.d.a(b, 0, true);
            b(str, a);
            return a;
        } catch (Exception e) {
            throw new bh(e);
        }
    }

    private Object b(String str, boolean z, ClassLoader classLoader) {
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        Object a = ag.a(str, z, classLoader);
        this.b.put(str, a);
        return a;
    }

    private void b(String str, Object obj) {
        this.e.put(str, obj);
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        Object obj2 = obj;
        while (true) {
            if (obj2.getClass().isArray()) {
                if (!obj2.getClass().getComponentType().toString().equals("byte")) {
                    throw new IllegalArgumentException("only byte[] is supported");
                } else if (Array.getLength(obj2) > 0) {
                    arrayList.add("java.util.List");
                    obj2 = Array.get(obj2, 0);
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
            } else if (obj2 instanceof Array) {
                throw new IllegalArgumentException("can not support Array, please use List");
            } else if (obj2 instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj2;
                if (list.size() > 0) {
                    obj2 = list.get(0);
                } else {
                    arrayList.add("?");
                    return;
                }
            } else if (obj2 instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj2;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                } else {
                    arrayList.add("?");
                    arrayList.add("?");
                    return;
                }
            } else {
                arrayList.add(obj2.getClass().getName());
                return;
            }
        }
    }

    public byte[] a() {
        me meVar = new me(0);
        meVar.a(this.c);
        meVar.a(this.a, 0);
        return mg.a(meVar.a());
    }

    public void a(byte[] bArr) {
        this.d.a(bArr);
        this.d.a(this.c);
        Map hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.a = this.d.a(hashMap, 0, false);
    }
}
