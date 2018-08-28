package com.tencent.mm.plugin.appbrand.page;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.appbrand.jsapi.o.c;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.f.a;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.appbrand.widget.input.f;
import java.util.Iterator;

class p$22 implements OnTouchListener {
    final /* synthetic */ p gnH;
    final /* synthetic */ f gnM;
    final /* synthetic */ ad gnN;

    p$22(p pVar, f fVar, ad adVar) {
        this.gnH = pVar;
        this.gnM = fVar;
        this.gnN = adVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        if (motionEvent.getAction() != 0) {
            c.a(this.gnM, motionEvent);
        }
        ad adVar = this.gnN;
        if (motionEvent == null) {
            z = false;
        } else {
            r rVar;
            com.tencent.mm.plugin.appbrand.widget.b.f fVar = adVar.gJg.gGA;
            if (fVar.gFG.onFilterTouchEventForSecurity(motionEvent)) {
                Iterator cVar = motionEvent.getActionMasked() == 0 ? new com.tencent.mm.plugin.appbrand.widget.b.c(fVar.gFG) : fVar.gFH.iterator();
                fVar.gFI = motionEvent.getActionMasked() == 0 ? new a(motionEvent.getDownTime(), motionEvent.getEventTime(), (byte) 0) : null;
                z = false;
                while (cVar.hasNext()) {
                    boolean a;
                    View view2 = (View) cVar.next();
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = fVar.gFG.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(actionIndex) : -1;
                    float x = motionEvent.getX(actionIndex);
                    float y = motionEvent.getY(actionIndex);
                    if (motionEvent.getActionMasked() != 0) {
                        a = com.tencent.mm.plugin.appbrand.widget.b.a.a(fVar.gFG, motionEvent, view2, pointerId) | z;
                    } else if (com.tencent.mm.plugin.appbrand.widget.b.a.bS(view2) && com.tencent.mm.plugin.appbrand.widget.b.a.a(fVar.gFG, x, y, view2)) {
                        if (com.tencent.mm.plugin.appbrand.widget.b.a.bR(view2)) {
                            if (com.tencent.mm.plugin.appbrand.widget.b.a.a(fVar.gFG, motionEvent, view2, pointerId)) {
                                fVar.gFH.addLast(view2);
                                a = z | 1;
                            } else {
                                a = z;
                            }
                            z = a;
                        } else {
                            a = z;
                        }
                    }
                    z = a;
                }
                switch (motionEvent.getActionMasked()) {
                    case 1:
                    case 3:
                        fVar.gFH.clear();
                        break;
                }
            }
            z = false;
            b.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | " + z, motionEvent);
            if (2 == motionEvent.getActionMasked()) {
                if (z && !adVar.gJh) {
                    rVar = (r) adVar.gJl.cf(adVar.gJg);
                    if (rVar != null) {
                        adVar.gJi = !rVar.gnY;
                        rVar.setPullDownEnabled(false);
                        rVar.requestDisallowInterceptTouchEvent(true);
                        adVar.gJh = true;
                    }
                }
                if (z) {
                    adVar.gJj = true;
                } else if (adVar.gJj) {
                    adVar.gJj = false;
                }
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    break;
                case 1:
                case 3:
                    if (adVar.gJh) {
                        rVar = (r) adVar.gJl.cf(adVar.gJg);
                        if (rVar != null) {
                            rVar.setPullDownEnabled(adVar.gJi);
                        }
                        adVar.gJh = false;
                        break;
                    }
                    break;
            }
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }
}
