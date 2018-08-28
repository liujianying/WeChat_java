package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.e;

public abstract class d {
    boolean vlZ = false;
    public b vmm;

    abstract boolean cFX();

    abstract void cFY();

    abstract void execute();

    final synchronized void b(e eVar) {
        if (this.vlZ) {
            c.w("Soter.BaseSoterTask", "soter: warning: already removed the task!", new Object[0]);
        } else {
            f cFZ = f.cFZ();
            String str = "Soter.SoterTaskManager";
            String str2 = "soter: removing task: %d";
            Object[] objArr = new Object[1];
            objArr[0] = this != null ? Integer.valueOf(hashCode()) : "null";
            c.i(str, str2, objArr);
            if (this == null) {
                c.e("Soter.SoterTaskManager", "soter: task is null", new Object[0]);
            } else {
                synchronized (cFZ.vmx) {
                    if (f.vmw.get(hashCode()) == null) {
                        c.i("Soter.SoterTaskManager", "soter: no such task: %d. maybe this task did not pass preExecute", new Object[]{Integer.valueOf(hashCode())});
                    } else {
                        f.vmw.remove(hashCode());
                    }
                }
            }
            g.cGb().A(new 1(this, eVar));
        }
    }
}
