package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.pb.common.c.c;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class e implements b {
    private static e vcg = null;
    private Vector<d> dJu = new Vector();
    private Vector<d> dJv = new Vector();
    private final Handler handler = new 1(this, Looper.getMainLooper());
    private final SparseArray<Set<b>> vch = new SparseArray();
    private d vci = null;

    private e() {
    }

    public static e cEn() {
        if (vcg == null) {
            synchronized (e.class) {
                if (vcg == null) {
                    vcg = new e();
                }
            }
        }
        return vcg;
    }

    public final void a(int i, b bVar) {
        if (this.vch.get(i) == null) {
            this.vch.put(i, new HashSet());
        }
        if (!((Set) this.vch.get(i)).contains(bVar)) {
            ((Set) this.vch.get(i)).add(bVar);
        }
    }

    public final boolean a(d dVar) {
        if (!h.isNetworkConnected()) {
            int type = dVar.getType();
            if (type == 102 || type == 104 || type == 103) {
                c.x("MicroMsg.Voip", "doScene do retain mReissueNetScene");
                this.vci = dVar;
            }
        }
        Assert.assertTrue(true);
        if (dVar == null) {
            return false;
        }
        b(dVar);
        return true;
    }

    private void b(d dVar) {
        if (cEo()) {
            int i;
            this.dJu.add(dVar);
            if (dVar.vbZ == null) {
                c.x("MicroMsg.Voip", dVar.TAG2, "dosene reqData is null cmd=" + dVar.vcb);
                i = -1;
            } else {
                dVar.vbY = this;
                i = f.cEq().a(null, new i(dVar), dVar.vcb, dVar.cEm(), dVar.vbZ, dVar.vcc);
                if (i >= 0) {
                    dVar.mHandler.postDelayed(dVar.dJQ, 60000);
                }
                c.d("MicroMsg.Voip", "NETTASK_SEND dosene:cmd ", dVar.cEm(), Integer.valueOf(i));
            }
            if (i < 0) {
                c.x("MicroMsg.Voip", "doSceneImp do scene failed, ret %d,", Integer.valueOf(i));
                this.handler.post(new 2(this, dVar));
            }
        } else {
            this.dJv.add(dVar);
        }
        Lk();
    }

    public final void a(int i, int i2, String str, d dVar) {
        this.dJu.remove(dVar);
        Lk();
        this.handler.post(new 3(this, dVar, i, i2, str));
    }

    private void Lk() {
        if (this.dJv.size() > 0) {
            d dVar = (d) this.dJv.get(0);
            for (int i = 1; i < this.dJv.size(); i++) {
                this.dJv.get(i);
            }
            if (cEo()) {
                this.dJv.remove(dVar);
                b(dVar);
            }
        }
    }

    private boolean cEo() {
        if (this.dJu.size() >= 20) {
            return false;
        }
        return true;
    }
}
