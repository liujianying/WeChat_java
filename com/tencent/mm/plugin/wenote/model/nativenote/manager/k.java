package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.OnKeyListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.l;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.plugin.wenote.ui.nativenote.a;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class k implements c {
    public static int mScreenHeight;
    public static int mScreenWidth;
    public static k qrq = null;
    private static DisplayMetrics qrr;
    public static int qrs = -1;
    private static int qru = -1;
    public int JP;
    public long bJA = -1;
    public int gwO;
    public String qrA = null;
    public long qrB = -1;
    public int qrC = 0;
    public boolean qrD = false;
    private OnKeyListener qrE = new 1(this);
    public final al qrF = new al(new 2(this), true);
    private transient ArrayList<WXRTEditText> qro = new ArrayList();
    public a qrp;
    private int qrt;
    public long qrv = -1;
    private String qrw = "";
    public b qrx = null;
    private boolean qry = false;
    public int qrz = -1;

    public k(a aVar) {
        this.qrp = aVar;
        qrq = this;
        this.JP = e.cM(aVar.caT());
        this.gwO = e.eL(aVar.caT());
        int[] db = j.db(aVar.caT());
        mScreenHeight = db[1];
        mScreenWidth = db[0];
        qrr = aVar.caT().getResources().getDisplayMetrics();
        this.qrt = ((mScreenHeight - this.JP) - this.gwO) - ((int) aq(8.0f));
        this.qrw = c.bZD().bZK();
        m.qta = 0.0f;
    }

    public final void o(WXRTEditText wXRTEditText) {
        if (wXRTEditText.qqJ == 0) {
            wXRTEditText.setTextSize(0, (float) com.tencent.mm.bp.a.ad(wXRTEditText.getContext(), R.f.NormalTextSize));
        }
        b.setTextSize(wXRTEditText.getTextSize());
        wXRTEditText.qqz = this;
        wXRTEditText.setRichTextEditing(null);
        wXRTEditText.setOnKeyListener(this.qrE);
    }

    public final WXRTEditText cai() {
        c bZD = c.bZD();
        ArrayList arrayList = this.qro;
        if (arrayList != null) {
            arrayList.clear();
            synchronized (bZD) {
                if (bZD.gBc == null) {
                } else {
                    Iterator it = bZD.gBc.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.b) it.next();
                        if (bVar.qoM != null) {
                            arrayList.add(bVar.qoM);
                        } else if (!(bVar.qoK == null || bVar.qoL == null)) {
                            arrayList.add(bVar.qoK);
                            arrayList.add(bVar.qoL);
                        }
                    }
                }
            }
        }
        if (this.qro == null) {
            return null;
        }
        Iterator it2 = this.qro.iterator();
        while (it2.hasNext()) {
            WXRTEditText wXRTEditText = (WXRTEditText) it2.next();
            if (wXRTEditText.hasFocus()) {
                return wXRTEditText;
            }
        }
        return null;
    }

    public final void e(boolean z, long j) {
        this.qrp.caU().e(z, j);
    }

    public final void bZx() {
        this.qrp.caU().bZx();
        cak();
    }

    public final void Bs(int i) {
        this.qrp.caU().Q(i, 0);
    }

    public final void a(WXRTEditText wXRTEditText, boolean z, int i) {
        synchronized (this) {
            if (z) {
                cak();
            }
            this.qrp.caU().a(wXRTEditText, z, i);
        }
    }

    public final void a(WXRTEditText wXRTEditText, int i, int i2) {
        if (this.qrC == 2 && this.qrD && wXRTEditText != null) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            this.qrp.caU().ep(i, i2);
            if (wXRTEditText.getEditTextType() == 0) {
                Iterator it = u.qtA.iterator();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                while (it.hasNext()) {
                    boolean z5;
                    t tVar = (t) it.next();
                    if (tVar.q(wXRTEditText)) {
                        if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.b) {
                            z4 = true;
                        } else if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.c) {
                            z3 = true;
                        } else if (tVar instanceof l) {
                            z2 = true;
                        } else if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.j) {
                            z5 = true;
                            z = z5;
                        }
                    }
                    z5 = z;
                    z = z5;
                }
            } else {
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            this.qrx.ks(z4);
            this.qrx.kt(z3);
            this.qrx.ku(z2);
            this.qrx.kv(z);
        }
    }

    public final void a(WXRTEditText wXRTEditText, Spannable spannable, Spannable spannable2, int i) {
        String a = wXRTEditText.a(i.qrk);
        if (wXRTEditText.getEditTextType() == 0) {
            com.tencent.mm.plugin.wenote.model.a.b Bv = c.bZD().Bv(wXRTEditText.getRecyclerItemPosition());
            if (Bv != null && Bv.getType() == 1) {
                int Ss = spannable == null ? 0 : com.tencent.mm.plugin.wenote.b.c.Ss(spannable.toString());
                int Ss2 = spannable2 == null ? 0 : com.tencent.mm.plugin.wenote.b.c.Ss(spannable2.toString());
                if (c.bZD().eq(Ss2 - Ss, 0)) {
                    this.qrp.caU().bZn();
                    this.qrp.caU().Bo(wXRTEditText.getRecyclerItemPosition());
                    return;
                }
                c.bZD().bZG();
                ((h) Bv).qoJ = i;
                ((h) Bv).content = a;
                ((h) Bv).qoH = true;
                Bv.qoN = false;
                c bZD = c.bZD();
                bZD.qpU = (Ss2 - Ss) + bZD.qpU;
                return;
            }
            return;
        }
        wXRTEditText.setText("");
        if (!bi.oW(a)) {
            String str;
            h hVar = new h();
            if (a.equals("<br/>")) {
                str = "";
            } else {
                str = a;
            }
            hVar.content = str;
            int a2 = c.bZD().a(hVar, wXRTEditText, true, false, false);
            c.bZD().er(a2 - 1, a2 + 1);
        }
    }

    public static k caj() {
        return qrq;
    }

    public final void bZz() {
        this.qrp.caU().bZl();
    }

    public final void b(WXRTEditText wXRTEditText) {
        this.qrp.caU().a(wXRTEditText);
    }

    public static float aq(float f) {
        return TypedValue.applyDimension(1, f, qrr);
    }

    private synchronized void bi(String str, boolean z) {
        fz fzVar = new fz();
        fzVar.bOL.type = 19;
        fzVar.bOL.bJH = c.bZD().Sm(str);
        if (fzVar.bOL.bJH == null) {
            x.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
        } else {
            fzVar.bOL.title = str;
            fzVar.bOL.bJA = this.bJA;
            fzVar.bOL.bOS = z ? 1 : 0;
            fzVar.bOL.desc = "fav_update_note_storage";
            com.tencent.mm.sdk.b.a.sFg.m(fzVar);
            if (z) {
                this.qrz = fzVar.bOL.bOO.getIntExtra("fav_note_item_status", -1);
                this.qrA = fzVar.bOL.bOO.getStringExtra("fav_note_xml");
                this.qrB = fzVar.bOL.bOO.getLongExtra("fav_note_item_updatetime", -1);
            }
        }
    }

    private void cak() {
        if (this.qrv < 0 && this.bJA > 0) {
            this.qrF.J(60000, 60000);
            this.qrv = bi.VG();
            this.qrw = c.bZD().bZK();
        }
    }

    public final void cal() {
        if (this.bJA > 0 && this.qrv > 0) {
            String bZK = c.bZD().bZK();
            if (!bZK.equals(this.qrw)) {
                this.qrw = bZK;
                if (this.qry) {
                    bi(this.qrw, false);
                    return;
                }
                this.qry = true;
                bi(this.qrw, true);
            }
        }
    }

    public final WXRTEditText cam() {
        WXRTEditText cai = cai();
        if (cai != null || this.qro.size() <= 0) {
            return cai;
        }
        return (WXRTEditText) this.qro.get(this.qro.size() - 1);
    }

    public final <V, C extends g<V>> void b(t<V, C> tVar, V v) {
        WXRTEditText cai = cai();
        if (cai == null) {
            return;
        }
        if (cai.getEditTextType() == 0) {
            int i = cai.getSelection().Tw;
            int length = cai.getText().length();
            if ((v instanceof Boolean) && ((Boolean) v).booleanValue() && i == length) {
                cai.cab();
                cai.getText().append("\n");
                cai.cac();
                cai.setSelection(i);
            }
            cai.a(tVar, v);
            return;
        }
        cai.qqV = true;
        cai.qoR = tVar.caD();
        cai.getText().append("\n");
    }

    public static void can() {
        if (qrq != null) {
            qrq.qrp.caU().kr(true);
        }
    }
}
