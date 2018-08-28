package com.tencent.d.b.f;

import android.util.SparseArray;
import com.tencent.d.a.c.c;
import com.tencent.d.b.a.e;

public class f {
    private static volatile f vmv = null;
    public static volatile SparseArray<d> vmw = null;
    public final Object vmx = new Object();

    private f() {
        vmw = new SparseArray(5);
    }

    public static f cFZ() {
        if (vmv != null) {
            return vmv;
        }
        f fVar;
        synchronized (f.class) {
            if (vmv == null) {
                vmv = new f();
            }
            fVar = vmv;
        }
        return fVar;
    }

    public final boolean a(d dVar, e eVar) {
        if (dVar.cFX()) {
            c.d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
            return false;
        }
        int hashCode = dVar.hashCode();
        synchronized (this.vmx) {
            int i = 0;
            while (i < vmw.size()) {
                int keyAt = vmw.keyAt(i);
                if (vmw.get(keyAt) == null || !((d) vmw.get(keyAt)).getClass().getName().equals(dVar.getClass().getName())) {
                    i++;
                } else {
                    c.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
                    eVar.errCode = 26;
                    eVar.Yy = "add SOTER task to queue failed. check the logcat for further information";
                    dVar.b(eVar);
                    return false;
                }
            }
            vmw.put(hashCode, dVar);
            g.cGb().C(new 1(this, dVar));
            return true;
        }
    }

    public final void cGa() {
        synchronized (this.vmx) {
            c.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
            if (vmw.size() != 0) {
                for (int i = 0; i < vmw.size(); i++) {
                    g.cGb().C(new 2(this, vmw.keyAt(i)));
                }
            }
            vmw.clear();
        }
    }
}
