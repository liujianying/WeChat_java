package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.y;
import com.tencent.mm.w.a.k;

public final class l extends p {
    private LayoutInflater Bc;
    private boolean nTs = true;
    public c ofp;
    public d ofq;
    private com.tencent.mm.ui.base.l ofr;
    private a uAC;
    private a uAx;
    private b uAy;

    static /* synthetic */ CharSequence f(l lVar) {
        return (lVar.ofr.Io == null || lVar.ofr.Io.length() == 0) ? lVar.mContext.getResources().getString(k.app_choose) : lVar.ofr.Io;
    }

    public l(Context context) {
        super(context);
        this.Bc = y.gq(context);
        this.ofr = new com.tencent.mm.ui.base.l(context);
    }

    public final boolean dZ() {
        if (this.ofp != null) {
            this.ofp.a(this.ofr);
        }
        boolean z = this.ofr.Io != null && this.ofr.Io.length() > 0;
        this.nTs = z;
        return super.dZ();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.nTs || i != 0) {
            if (this.nTs) {
                i--;
            }
            if (this.ofq != null) {
                this.ofq.onMMMenuItemSelected(this.ofr.getItem(i), i);
            }
            dismiss();
        }
    }

    protected final BaseAdapter avF() {
        if (this.uAC == null) {
            this.uAC = new a(this, (byte) 0);
        }
        return this.uAC;
    }
}
