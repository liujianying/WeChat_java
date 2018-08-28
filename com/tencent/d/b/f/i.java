package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.d.a.a;
import com.tencent.d.a.c.b;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.f;
import com.tencent.d.a.c.g;
import com.tencent.d.b.e.d;
import java.nio.charset.Charset;

public class i extends d {
    private static final String vmU = ("soter_triggered_oom" + f.u(a.cFF().getBytes(Charset.forName("UTF-8"))));
    private boolean vmV = false;
    private String vmW = "";
    private g.a vmX = new 1(this);
    private d vmp;
    private String vmq = "";
    private int[] vmr;

    static /* synthetic */ void c(i iVar) {
        SharedPreferences cFR = com.tencent.d.b.b.a.cFO().cFR();
        c.d("Soter.TaskInit", "soter: ask status: %d", new Object[]{Integer.valueOf(cFR.getInt(com.tencent.d.a.c.d.cFJ().vly, 0))});
        if (Hr(cFR.getInt(com.tencent.d.a.c.d.cFJ().vly, 0)) && a.cFC()) {
            a.cFB();
        }
        for (int i : iVar.vmr) {
            String str = (String) com.tencent.d.b.b.a.cFO().cFQ().get(i, "");
            if (!f.oW(str)) {
                c.d("Soter.TaskInit", "soter: %s status: %d", new Object[]{str, Integer.valueOf(cFR.getInt(str, 0))});
                if (Hr(cFR.getInt(str, 0)) && a.acz(str)) {
                    a.bD(str, false);
                }
            }
        }
    }

    public i(Context context, e eVar) {
        boolean z = false;
        b bVar = eVar.vms;
        if (bVar != null) {
            c.a(bVar);
        }
        com.tencent.d.b.b.a cFO = com.tencent.d.b.b.a.cFO();
        SharedPreferences sharedPreferences = context.getSharedPreferences("soter_status", 0);
        synchronized (com.tencent.d.b.b.a.class) {
            cFO.vlQ = sharedPreferences;
        }
        g.a(this.vmX);
        a.setUp();
        if (a.cFz() && a.hy(context)) {
            z = true;
        }
        this.vmV = z;
        this.vmp = eVar.vmp;
        this.vmr = eVar.vmr;
        this.vmq = eVar.vmq;
        this.vmW = eVar.vmt;
    }

    final boolean cFX() {
        int[] iArr = this.vmr;
        int i = (iArr == null || iArr.length <= 0) ? 1 : 0;
        if (i != 0) {
            c.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            b(new com.tencent.d.b.a.d(27, "no business scene provided"));
            return true;
        }
        if (f.oV(this.vmq).length() > 16) {
            c.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
            String u = f.u(this.vmq.getBytes(Charset.forName("UTF-8")));
            u = (f.oW(u) || u.length() < 16) ? null : u.substring(0, 16);
            if (f.oW(u)) {
                c.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
                b(new com.tencent.d.b.a.d(28, "the account salt length is too long"));
                return true;
            }
            this.vmq = u;
        }
        if (f.oW(this.vmW) || this.vmW.length() <= 24) {
            if (this.vmp == null) {
                c.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
            }
            if (!f.oW(this.vmW)) {
                c.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
                com.tencent.d.a.c.d.cFJ().vly = this.vmW;
            }
            g.cGb().C(new 2(this));
            return false;
        }
        c.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
        b(new com.tencent.d.b.a.d(29, "the passed ask name is too long (larger than 24)"));
        return true;
    }

    final void cFY() {
    }

    final void execute() {
        if (!this.vmV) {
            b(new com.tencent.d.b.a.d(2));
            synchronized (com.tencent.d.b.b.a.class) {
                com.tencent.d.b.b.a.cFO().mQ(false);
                com.tencent.d.b.b.a.cFO().cFP();
            }
        } else if (this.vmp == null) {
            com.tencent.d.b.b.a.cFO().mQ(true);
            com.tencent.d.b.b.a.cFO().cFP();
            b(new com.tencent.d.b.a.d(0));
        } else {
            this.vmp.bx(new d.a(a.cFF()));
            this.vmp.a(new 3(this));
            this.vmp.execute();
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void b(String str, int[] iArr) {
        for (int put : iArr) {
            com.tencent.d.b.b.a.cFO().cFQ().put(put, String.format("%suid%d_%s_scene%d", new Object[]{"Wechat", Integer.valueOf(Process.myUid()), f.oV(str), Integer.valueOf(iArr[r0])}));
        }
    }

    private static boolean Hr(int i) {
        return i == 2 || i == 1;
    }
}
