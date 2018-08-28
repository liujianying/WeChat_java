package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.b.q;
import com.tencent.mm.plugin.appbrand.compat.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private LinkedList<h> fSK;
    b.h gMr;
    private b gMs;
    public AnimatorSet gMt;
    g gMu;

    public d(LinkedList<h> linkedList, b.h hVar, b bVar) {
        this.fSK = linkedList;
        this.gMr = hVar;
        this.gMs = bVar;
        init();
    }

    private void init() {
        this.gMt = new AnimatorSet();
        this.gMu = new g();
        List arrayList = new ArrayList();
        Iterator it = this.fSK.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (hVar.rotate != 0.0f) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.gMr.getRotation(), this.gMr.getRotation() + hVar.rotate});
                ofFloat.setDuration((long) hVar.duration);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.addUpdateListener(new 2(this));
                arrayList.add(ofFloat);
            } else {
                arrayList.add(a(hVar));
            }
        }
        this.gMt.playSequentially(arrayList);
    }

    private ValueAnimator a(h hVar) {
        f[] fVarArr = new f[]{((c) g.l(c.class)).g(hVar.fTN, hVar.fTM), ((c) g.l(c.class)).g(hVar.latitude, hVar.longitude)};
        f c = this.gMu.c(fVarArr[0]);
        f c2 = this.gMu.c(fVarArr[1]);
        double[] dArr = new double[1];
        q adx = this.gMs.adx();
        double d = 0.0d;
        for (int i = 0; i <= 0; i++) {
            dArr[0] = adx.a(fVarArr[0], fVarArr[1]);
            d = dArr[0] + 0.0d;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((((double) hVar.duration) * dArr[0]) / d));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues(new float[]{(float) dArr[0]});
        valueAnimator.addUpdateListener(new 1(this, c, c2, dArr));
        return valueAnimator;
    }
}
