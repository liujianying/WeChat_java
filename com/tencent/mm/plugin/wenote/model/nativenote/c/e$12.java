package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.platformtools.x;

class e$12 implements OnClickListener {
    final /* synthetic */ e qsJ;

    public e$12(e eVar) {
        this.qsJ = eVar;
    }

    public final void onClick(View view) {
        b bVar = null;
        x.i("NoteSelectManager", "select");
        this.qsJ.cav();
        if (!e.cD()) {
            x.e("NoteSelectManager", "select: not init");
        } else if (this.qsJ.cao() != 1) {
            x.e("NoteSelectManager", "select: not insert");
            e.h(this.qsJ);
        } else if (c.bZD().Bv(e.i(this.qsJ).dHJ) == null) {
            x.e("NoteSelectManager", "select: item is null");
            e.h(this.qsJ);
        } else {
            RecyclerView a = e.a(this.qsJ);
            if (a == null) {
                x.e("NoteSelectManager", "select: recyclerView is null");
                e.h(this.qsJ);
                return;
            }
            c dd = f.dd(f.g(a, e.i(this.qsJ).dHJ));
            if (dd == null) {
                x.e("NoteSelectManager", "select: rteInfo is null");
                e.h(this.qsJ);
            } else if (dd.qrX != null) {
                Editable text = dd.qrX.getText();
                if (text == null) {
                    x.e("NoteSelectManager", "select: text is null");
                    e.h(this.qsJ);
                } else if (text.length() > 0) {
                    dd.qrX.ae(e.i(this.qsJ).startOffset, true);
                } else {
                    b Bv = c.bZD().Bv(e.i(this.qsJ).dHJ - 1);
                    if (Bv != null && Bv.getType() == -3) {
                        Bv = null;
                    }
                    b Bv2 = c.bZD().Bv(e.i(this.qsJ).dHJ + 1);
                    if (Bv2 == null || Bv2.getType() != -2) {
                        bVar = Bv2;
                    }
                    if (Bv != null) {
                        if (Bv.getType() == 1) {
                            Spanned Sk = a.Sk(((h) Bv).content);
                            if (Sk == null) {
                                x.e("NoteSelectManager", "select: spanned is null");
                                e.h(this.qsJ);
                                return;
                            }
                            this.qsJ.w(e.i(this.qsJ).dHJ - 1, Sk.length(), e.i(this.qsJ).dHJ, 0);
                        } else {
                            this.qsJ.w(e.i(this.qsJ).dHJ - 1, 0, e.i(this.qsJ).dHJ, 0);
                        }
                    } else if (bVar == null) {
                        x.e("NoteSelectManager", "select: no neighbor");
                        e.h(this.qsJ);
                        return;
                    } else if (bVar.getType() == 1) {
                        this.qsJ.w(e.i(this.qsJ).dHJ, 0, e.i(this.qsJ).dHJ + 1, 0);
                    } else {
                        this.qsJ.w(e.i(this.qsJ).dHJ, 0, e.i(this.qsJ).dHJ + 1, 1);
                    }
                    e.e(this.qsJ);
                    this.qsJ.Q(true, true);
                }
            } else if (dd.qrY == null || dd.qrZ == null) {
                x.e("NoteSelectManager", "select: rteInfo invalid");
                e.h(this.qsJ);
            } else {
                e.e(this.qsJ);
                this.qsJ.w(e.i(this.qsJ).dHJ, 0, e.i(this.qsJ).dHJ, 1);
                this.qsJ.Q(true, true);
            }
        }
    }
}
