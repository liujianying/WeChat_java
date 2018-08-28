package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class au implements mk {
    Map<Integer, List<bb>> a = new HashMap();
    Map<Integer, List<bb>> b = new HashMap();
    List<bb> c = new ArrayList();
    List<bb> d = new ArrayList();
    List<bb> e = new ArrayList();
    List<bb> f = new ArrayList();
    ReentrantReadWriteLock g = new ReentrantReadWriteLock();
    ReadLock h = this.g.readLock();
    WriteLock i = this.g.writeLock();
    String j;
    private HashSet<String> k = new HashSet();

    public au(String str) {
        this.j = str;
    }

    public void a(bf bfVar) {
        try {
            this.i.lock();
            for (bb bbVar : this.f) {
                if (bbVar.equals(bfVar.d())) {
                    bbVar.a(true);
                    this.d.remove(bbVar);
                    this.k.remove(bbVar.a());
                    if (!this.e.contains(bbVar)) {
                        this.e.add(bbVar);
                    }
                    if (this.b.get(Integer.valueOf(bbVar.e())) != null) {
                        ((List) this.b.get(Integer.valueOf(bbVar.e()))).remove(bbVar);
                    }
                }
            }
            ax.c(this.j + " " + bfVar.d() + " setServiceFail activeServices:" + this.d + " inactiveServices:" + this.e);
        } finally {
            this.i.unlock();
        }
    }

    public void b(bf bfVar) {
        try {
            this.i.lock();
            for (bb bbVar : this.f) {
                if (bbVar.equals(bfVar.d())) {
                    bbVar.a(false);
                    if (!this.d.contains(bbVar)) {
                        this.d.add(bbVar);
                        this.k.add(bbVar.a());
                    }
                    if (this.b.get(Integer.valueOf(bbVar.e())) == null) {
                        this.b.put(Integer.valueOf(bbVar.e()), new ArrayList());
                    }
                    if (!((List) this.b.get(Integer.valueOf(bbVar.e()))).contains(bbVar)) {
                        ((List) this.b.get(Integer.valueOf(bbVar.e()))).add(bbVar);
                    }
                    this.e.remove(bbVar);
                }
            }
            ax.c(this.j + " " + bfVar.d() + " setServiceActive activeServices:" + this.d + " inactiveServices:" + this.e);
        } finally {
            this.i.unlock();
        }
    }

    public List<bb> a() {
        try {
            this.h.lock();
            List<bb> list = this.d;
            return list;
        } finally {
            this.h.unlock();
        }
    }

    public List<bb> b() {
        try {
            this.h.lock();
            List<bb> list = this.e;
            return list;
        } finally {
            this.h.unlock();
        }
    }

    public List<bb> c() {
        try {
            this.h.lock();
            List<bb> list = this.f;
            return list;
        } finally {
            this.h.unlock();
        }
    }

    public boolean d() {
        boolean z = true;
        try {
            this.h.lock();
            if (this.a.size() != 1) {
                z = false;
            }
            this.h.unlock();
            return z;
        } catch (Throwable th) {
            this.h.unlock();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.j);
        for (bb d : this.f) {
            stringBuffer.append(";" + d.d());
        }
        return stringBuffer.toString();
    }

    private ArrayList<bb> a(ArrayList<fl> arrayList, boolean z) {
        Object arrayList2 = new ArrayList(arrayList.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                bb bbVar = new bb(this.j, (fl) arrayList.get(i2));
                bbVar.b(z);
                arrayList2.add(bbVar);
                i = i2 + 1;
            } else {
                Collections.sort(arrayList2);
                return arrayList2;
            }
        }
    }

    public void a(ArrayList<fl> arrayList, ArrayList<fl> arrayList2) {
        b(a((ArrayList) arrayList, true), a((ArrayList) arrayList2, false));
    }

    void b(ArrayList<bb> arrayList, ArrayList<bb> arrayList2) {
        bb bbVar;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        List arrayList3 = new ArrayList();
        HashSet hashSet = new HashSet();
        List arrayList4 = new ArrayList();
        List arrayList5 = new ArrayList();
        List arrayList6 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bbVar = (bb) it.next();
            if (!hashMap.containsKey(Integer.valueOf(bbVar.e()))) {
                hashMap.put(Integer.valueOf(bbVar.e()), new ArrayList());
            }
            if (!hashMap2.containsKey(Integer.valueOf(bbVar.e()))) {
                hashMap2.put(Integer.valueOf(bbVar.e()), new ArrayList());
            }
            ((List) hashMap.get(Integer.valueOf(bbVar.e()))).add(bbVar);
            ((List) hashMap2.get(Integer.valueOf(bbVar.e()))).add(bbVar);
            arrayList3.add(bbVar);
            hashSet.add(bbVar.a());
            arrayList5.add(bbVar);
            arrayList6.add(bbVar);
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
            bbVar = (bb) it.next();
            if (!hashMap.containsKey(Integer.valueOf(bbVar.e()))) {
                hashMap.put(Integer.valueOf(bbVar.e()), new ArrayList());
            }
            ((List) hashMap.get(Integer.valueOf(bbVar.e()))).add(bbVar);
            arrayList4.add(bbVar);
            arrayList5.add(bbVar);
        }
        try {
            this.i.lock();
            this.c = arrayList6;
            this.a = hashMap;
            this.b = hashMap2;
            this.d = arrayList3;
            this.k = hashSet;
            this.e = arrayList4;
            this.f = arrayList5;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.j + " setServices gridServices:" + this.a + " gridActiveServices:" + this.b);
            stringBuffer.append(" allServices: ");
            for (bb bbVar2 : this.f) {
                stringBuffer.append(bbVar2 + ";");
            }
            ax.c(stringBuffer.toString());
        } finally {
            this.i.unlock();
        }
    }

    public boolean c(bf bfVar) {
        return this.k.contains(bfVar.e());
    }

    public String e() {
        return this.j;
    }

    public List<bb> f() {
        return this.c;
    }

    public bb a(int i, int i2) {
        try {
            this.h.lock();
            List list = (List) this.b.get(Integer.valueOf(i));
            if (list == null || list.size() == 0) {
                this.h.unlock();
                return null;
            }
            bb bbVar = (bb) list.get(Math.abs(i2) % list.size());
            this.h.unlock();
            return bbVar;
        } catch (Throwable th) {
            this.h.unlock();
        }
    }

    public boolean a(int i) {
        try {
            this.h.lock();
            List list = (List) this.a.get(Integer.valueOf(i));
            boolean z = (list == null || list.isEmpty()) ? false : true;
            this.h.unlock();
            return z;
        } catch (Throwable th) {
            this.h.unlock();
        }
    }
}
