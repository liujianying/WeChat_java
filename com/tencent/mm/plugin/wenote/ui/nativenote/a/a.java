package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView$m;
import android.support.v7.widget.RecyclerView.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ad;

public final class a extends LinearLayoutManager {
    private final int qvb = j.s(ad.getContext(), true);
    public int qvc = -1;
    public boolean qvd = false;

    public final int b(int i, RecyclerView$m recyclerView$m, q qVar) {
        int i2 = 1;
        int i3 = 0;
        if (!this.qvd) {
            return super.b(i, recyclerView$m, qVar);
        }
        int i4 = i < 0 ? k.aq(49.0f) <= ((float) Math.abs(i)) ? 1 : i3 : i3;
        if (i <= 0) {
            i2 = i4;
        } else if (((float) this.qvb) + k.aq(49.0f) >= ((float) i)) {
            i2 = i3;
        }
        if (i2 != 0 && this.qvd) {
            return i3;
        }
        try {
            return super.b(i, recyclerView$m, qVar);
        } catch (Exception e) {
            return i3;
        }
    }

    protected final int a(q qVar) {
        if (this.qvc > 0) {
            return this.qvc;
        }
        return 900;
    }

    public final void c(RecyclerView$m recyclerView$m, q qVar) {
        try {
            super.c(recyclerView$m, qVar);
        } catch (Exception e) {
        }
    }
}
