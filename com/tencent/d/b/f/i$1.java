package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.g$a;
import com.tencent.d.b.b.a;

class i$1 implements g$a {
    final /* synthetic */ i vmY;

    i$1(i iVar) {
        this.vmY = iVar;
    }

    @SuppressLint({"ApplySharedPref"})
    public final void cFM() {
        c.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
        SharedPreferences cFR = a.cFO().cFR();
        if (cFR != null) {
            Editor edit = cFR.edit();
            edit.putBoolean(i.bO(), true);
            edit.commit();
        }
    }

    public final boolean cFL() {
        SharedPreferences cFR = a.cFO().cFR();
        if (cFR == null) {
            return false;
        }
        c.i("Soter.TaskInit", "soter: is triggered OOM: %b", new Object[]{Boolean.valueOf(cFR.getBoolean(i.bO(), false))});
        return cFR.getBoolean(i.bO(), false);
    }
}
