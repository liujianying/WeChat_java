package com.tencent.mm.ui.chatting.b;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.gallery.f;

@a(cwo = n.class)
public class r extends a implements d.a, y.a, n {
    private c tQa = new 1(this);
    private al tQb = new al(new 2(this), false);
    private f tQc = f.a.tVr;

    static /* synthetic */ void a(r rVar, bd bdVar, aq aqVar) {
        int firstVisiblePosition = rVar.bAG.getListView().getFirstVisiblePosition();
        int lastVisiblePosition = rVar.bAG.getListView().getLastVisiblePosition();
        int max = Math.max(firstVisiblePosition, 0);
        int max2 = Math.max(lastVisiblePosition, 0);
        if (max < 0 || max2 >= rVar.bAG.getListView().getAdapter().getCount()) {
            x.i("MicroMsg.ChattingUI.GetImageComponent", "invalid position %d-%d, cnt:%d", Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(rVar.bAG.getListView().getAdapter().getCount()));
            return;
        }
        for (lastVisiblePosition = max; lastVisiblePosition <= max2; lastVisiblePosition++) {
            bd bdVar2 = (bd) rVar.bAG.getListView().getAdapter().getItem(lastVisiblePosition);
            if (!(bdVar == null || bdVar2 == null || bdVar2.field_msgId != bdVar.field_msgId)) {
                View childAt = rVar.bAG.getChildAt(lastVisiblePosition - max);
                if (childAt == null) {
                    x.e("MicroMsg.ChattingUI.GetImageComponent", "[getPhotoInfo] getChildAt(%d)", Integer.valueOf((lastVisiblePosition - max) + rVar.bAG.getHeaderViewsCount()));
                } else {
                    View view = null;
                    if (bdVar.ckA() || bdVar.cmj() || bdVar.cmk()) {
                        view = childAt.findViewById(R.h.chatting_content_iv);
                    } else if (bdVar.cmo()) {
                        view = childAt.findViewById(R.h.chatting_appmsg_thumb_iv);
                    }
                    if (view != null) {
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        aqVar.bIa.bIb = iArr[0];
                        aqVar.bIa.bIc = iArr[1];
                        aqVar.bIa.bId = view.getWidth();
                        aqVar.bIa.bIe = view.getHeight();
                    }
                }
            }
        }
    }

    public final void anA() {
        this.tQb.SO();
        this.tQb.J(1000, 1000);
    }

    private void SO() {
        if (au.HX()) {
            o.Pg().a((d.a) this);
        }
        this.tQb.SO();
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        com.tencent.mm.modelcontrol.c.NM();
        if (!com.tencent.mm.modelcontrol.c.NN()) {
            o.Pg().a((d.a) this);
        }
        boolean z = i3 == 0 && i4 == 0;
        o.Ph();
        b.a(j, j2, z);
        au.HU();
        ((g) this.bAG.O(g.class)).a(j2, com.tencent.mm.model.c.FT().dW(j2), z);
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }

    public final void m(String str, Bitmap bitmap) {
        if (!bi.oW(str) && bitmap != null && this.bAG != null) {
            com.tencent.mm.ui.chatting.c.a.cwt().post(new 3(this));
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        o.Pj().br(i);
        if (i == 0) {
            anA();
        } else if (i == 2) {
            SO();
        }
    }

    public final void cun() {
        super.cun();
        SO();
    }

    public final void cpG() {
    }

    public final void cpH() {
        com.tencent.mm.sdk.b.a.sFg.b(this.tQa);
    }

    public final void cpI() {
        com.tencent.mm.sdk.b.b lnVar = new ln();
        lnVar.bVQ.bVR = true;
        com.tencent.mm.sdk.b.a.sFg.a(lnVar, Looper.getMainLooper());
        y.b(this);
    }

    public final void cpJ() {
        com.tencent.mm.sdk.b.b lnVar = new ln();
        lnVar.bVQ.bVR = false;
        com.tencent.mm.sdk.b.a.sFg.a(lnVar, Looper.getMainLooper());
        y.c(this);
        SO();
    }

    public final void cpK() {
        SO();
        com.tencent.mm.sdk.b.a.sFg.c(this.tQa);
        f fVar = this.tQc;
        fVar.qD.clear();
        fVar.aRU();
    }
}
