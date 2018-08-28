package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.plugin.luckymoney.particles.c.2;
import com.tencent.mm.plugin.wxpay.a.d;
import java.util.Iterator;

public final class a {
    private static int kRL;
    private static int kRM;
    private static int kRN;
    private static int kRO;
    private static int kRP;
    private static int kRQ;
    public c kRR;

    public a(ViewGroup viewGroup) {
        if (kRL == 0) {
            Resources resources = viewGroup.getResources();
            kRL = resources.getDimensionPixelSize(d.default_confetti_size);
            kRM = resources.getDimensionPixelOffset(d.default_velocity_slow);
            kRN = resources.getDimensionPixelOffset(d.default_velocity_normal);
            kRO = resources.getDimensionPixelOffset(d.default_velocity_fast);
            kRP = resources.getDimensionPixelOffset(d.default_velocity_very_fast);
            kRQ = resources.getDimensionPixelOffset(d.default_explosion_radius);
        }
    }

    public static a a(ViewGroup viewGroup, b bVar) {
        a aVar = new a(viewGroup);
        c am = new c(viewGroup.getContext(), bVar, new d(viewGroup.getWidth() / 2, viewGroup.getHeight() + 400), viewGroup).I(0.0f, 800.0f).J(-2000.0f, 1250.0f).am(2000.0f);
        am.kSA = 3000.0f;
        am.kSB = 500.0f;
        am = am.bbb();
        am.kSd = e.bbf();
        aVar.kRR = am.bbc().bbd();
        return aVar;
    }

    public final c z(int i, long j) {
        c cVar = this.kRR;
        cVar.kRZ = 0;
        cVar.kSa = j;
        cVar.kSb = ((float) i) / 1000.0f;
        cVar.kSc = 1.0f / cVar.kSb;
        if (cVar.gGc != null) {
            cVar.gGc.cancel();
        }
        cVar.kRY = 0;
        Iterator it = cVar.kRX.iterator();
        while (it.hasNext()) {
            cVar.kRW.add(it.next());
            it.remove();
        }
        ViewParent parent = cVar.kRV.getParent();
        if (parent != null) {
            if (parent != cVar.kRU) {
                ((ViewGroup) parent).removeView(cVar.kRV);
            }
            cVar.kRV.terminated = false;
            cVar.A(cVar.kRZ, 0);
            cVar.gGc = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
            cVar.gGc.addUpdateListener(new 2(cVar));
            cVar.gGc.start();
            return cVar;
        }
        cVar.kRU.addView(cVar.kRV);
        cVar.kRV.terminated = false;
        cVar.A(cVar.kRZ, 0);
        cVar.gGc = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
        cVar.gGc.addUpdateListener(new 2(cVar));
        cVar.gGc.start();
        return cVar;
    }
}
