package com.tencent.rtmp.sharp.jni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;

class TraeAudioManager$e {
    HashMap<String, a> a = new HashMap();
    String b = "DEVICE_NONE";
    String c = "DEVICE_NONE";
    String d = "DEVICE_NONE";
    ReentrantLock e = new ReentrantLock();
    boolean f = false;
    String g = "unknow";
    final /* synthetic */ TraeAudioManager h;

    public TraeAudioManager$e(TraeAudioManager traeAudioManager) {
        this.h = traeAudioManager;
    }

    public boolean a(String str) {
        AudioDeviceInterface.LogTraceEntry(" strConfigs:" + str);
        if (str == null || str.length() <= 0) {
            return false;
        }
        String replace = str.replace("\n", "").replace("\r", "");
        if (replace == null || replace.length() <= 0) {
            return false;
        }
        if (replace.indexOf(";") < 0) {
            replace = replace + ";";
        }
        String[] split = replace.split(";");
        if (split == null || 1 > split.length) {
            return false;
        }
        this.e.lock();
        for (int i = 0; i < split.length; i++) {
            a(split[i], i);
        }
        this.e.unlock();
        this.h.printDevices();
        return true;
    }

    boolean a(String str, int i) {
        AudioDeviceInterface.LogTraceEntry(" devName:" + str + " priority:" + i);
        a aVar = new a(this);
        if (aVar.a(str, i)) {
            if (!this.a.containsKey(str)) {
                this.a.put(str, aVar);
                this.f = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " n" + e() + " 0:" + a(0));
                }
                AudioDeviceInterface.LogTraceExit();
                return true;
            } else if (!QLog.isColorLevel()) {
                return false;
            } else {
                QLog.e("TRAE", 2, "err dev exist!");
                return false;
            }
        } else if (!QLog.isColorLevel()) {
            return false;
        } else {
            QLog.e("TRAE", 2, " err dev init!");
            return false;
        }
    }

    public void a() {
        this.e.lock();
        this.a.clear();
        this.b = "DEVICE_NONE";
        this.c = "DEVICE_NONE";
        this.d = "DEVICE_NONE";
        this.e.unlock();
    }

    public boolean b() {
        this.e.lock();
        boolean z = this.f;
        this.e.unlock();
        return z;
    }

    public void c() {
        this.e.lock();
        this.f = false;
        this.e.unlock();
    }

    public boolean a(String str, boolean z) {
        boolean z2;
        this.e.lock();
        a aVar = (a) this.a.get(str);
        if (aVar == null || aVar.b() == z) {
            z2 = false;
        } else {
            aVar.a(z);
            this.f = true;
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " ++setVisible:" + str + (z ? " Y" : " N"));
            }
            z2 = true;
        }
        this.e.unlock();
        return z2;
    }

    public void b(String str) {
        if (str == null) {
            this.g = "unknow";
        } else if (str.isEmpty()) {
            this.g = "unknow";
        } else {
            this.g = str;
        }
    }

    public String d() {
        return this.g;
    }

    public boolean c(String str) {
        boolean b;
        this.e.lock();
        a aVar = (a) this.a.get(str);
        if (aVar != null) {
            b = aVar.b();
        } else {
            b = false;
        }
        this.e.unlock();
        return b;
    }

    public int d(String str) {
        int c;
        this.e.lock();
        a aVar = (a) this.a.get(str);
        if (aVar != null) {
            c = aVar.c();
        } else {
            c = -1;
        }
        this.e.unlock();
        return c;
    }

    public int e() {
        this.e.lock();
        int size = this.a.size();
        this.e.unlock();
        return size;
    }

    public String a(int i) {
        a aVar;
        String a;
        String str = "DEVICE_NONE";
        int i2 = 0;
        this.e.lock();
        Iterator it = this.a.entrySet().iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            Entry entry = (Entry) it.next();
            if (i3 == i) {
                aVar = (a) entry.getValue();
                break;
            }
            i2 = i3 + 1;
        }
        if (aVar != null) {
            a = aVar.a();
        } else {
            a = str;
        }
        this.e.unlock();
        return a;
    }

    public String e(String str) {
        this.e.lock();
        a aVar = null;
        for (Entry entry : this.a.entrySet()) {
            entry.getKey();
            entry.getValue();
            a aVar2 = (a) entry.getValue();
            if (!(aVar2 == null || !aVar2.b() || aVar2.a().equals(str))) {
                if (aVar == null) {
                    aVar = aVar2;
                } else {
                    if (aVar2.c() < aVar.c()) {
                        aVar2 = aVar;
                    }
                    aVar = aVar2;
                }
            }
        }
        this.e.unlock();
        return aVar != null ? aVar.a() : "DEVICE_SPEAKERPHONE";
    }

    public String f() {
        this.e.lock();
        a aVar = null;
        for (Entry entry : this.a.entrySet()) {
            entry.getKey();
            entry.getValue();
            a aVar2 = (a) entry.getValue();
            if (aVar2 != null && aVar2.b()) {
                if (aVar == null) {
                    aVar = aVar2;
                } else {
                    if (aVar2.c() < aVar.c()) {
                        aVar2 = aVar;
                    }
                    aVar = aVar2;
                }
            }
        }
        this.e.unlock();
        return aVar != null ? aVar.a() : "DEVICE_SPEAKERPHONE";
    }

    public String g() {
        String str;
        this.e.lock();
        a aVar = (a) this.a.get(this.d);
        if (aVar == null || !aVar.b()) {
            str = null;
        } else {
            str = this.d;
        }
        this.e.unlock();
        return str;
    }

    public String h() {
        this.e.lock();
        String m = m();
        this.e.unlock();
        return m;
    }

    public String i() {
        this.e.lock();
        String n = n();
        this.e.unlock();
        return n;
    }

    public boolean f(String str) {
        boolean z;
        this.e.lock();
        a aVar = (a) this.a.get(str);
        if (aVar == null || !aVar.b()) {
            z = false;
        } else {
            this.d = str;
            z = true;
        }
        this.e.unlock();
        return z;
    }

    public boolean g(String str) {
        boolean z;
        this.e.lock();
        a aVar = (a) this.a.get(str);
        if (aVar == null || !aVar.b()) {
            z = false;
        } else {
            if (!(this.c == null || this.c.equals(str))) {
                this.b = this.c;
            }
            this.c = str;
            this.d = "";
            z = true;
        }
        this.e.unlock();
        return z;
    }

    public HashMap<String, Object> j() {
        HashMap<String, Object> hashMap = new HashMap();
        this.e.lock();
        hashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", l());
        hashMap.put("EXTRA_DATA_CONNECTEDDEVICE", m());
        hashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", n());
        this.e.unlock();
        return hashMap;
    }

    public ArrayList<String> k() {
        ArrayList arrayList = new ArrayList();
        this.e.lock();
        ArrayList<String> l = l();
        this.e.unlock();
        return l;
    }

    ArrayList<String> l() {
        ArrayList<String> arrayList = new ArrayList();
        for (Entry value : this.a.entrySet()) {
            a aVar = (a) value.getValue();
            if (aVar != null && aVar.b()) {
                arrayList.add(aVar.a());
            }
        }
        return arrayList;
    }

    String m() {
        String str = "DEVICE_NONE";
        a aVar = (a) this.a.get(this.c);
        if (aVar == null || !aVar.b()) {
            return str;
        }
        return this.c;
    }

    String n() {
        String str = "DEVICE_NONE";
        a aVar = (a) this.a.get(this.b);
        if (aVar == null || !aVar.b()) {
            return str;
        }
        return this.b;
    }
}
