package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.c.ts;

public final class d extends a {
    public d(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.ieo);
        return aVar;
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f oG = oG(i);
        if (!(aVar == null || oG == null)) {
            oG.ieD = false;
            oG.ieE = false;
            ts tsVar = oG.iez;
            if (tsVar != null) {
                aVar.setTitle(tsVar.rwQ);
                o.Pj().a(tsVar.jPG, aVar.aDm(), com.tencent.mm.plugin.emoji.e.f.cr(tsVar.rem, tsVar.jPG));
                aVar.yX(h.an("yyyy-MM-dd", ((long) tsVar.rxy) * 1000));
            }
        }
        return view;
    }

    public final int aDz() {
        return 0;
    }

    public final void oD(int i) {
    }

    public final int aDA() {
        return 0;
    }

    public final void oE(int i) {
    }

    public final int aDB() {
        return 0;
    }

    public final void oF(int i) {
    }
}
