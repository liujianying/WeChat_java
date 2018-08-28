package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.Iterator;

class c$2 implements AnimatorUpdateListener {
    final /* synthetic */ c kSC;

    c$2(c cVar) {
        this.kSC = cVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        long currentPlayTime = valueAnimator.getCurrentPlayTime();
        c cVar = this.kSC;
        if (currentPlayTime < cVar.kSa) {
            if (cVar.kRY == 0) {
                cVar.kRY = currentPlayTime;
            } else {
                int nextFloat = (int) ((cVar.random.nextFloat() * cVar.kSb) * ((float) (currentPlayTime - cVar.kRY)));
                if (nextFloat > 0) {
                    cVar.kRY = (long) (((float) cVar.kRY) + (cVar.kSc * ((float) nextFloat)));
                    cVar.A(nextFloat, currentPlayTime);
                }
            }
        }
        c cVar2 = this.kSC;
        Iterator it = cVar2.kRX.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.kSO == -1) {
                bVar.kSO = currentPlayTime;
            }
            long j = currentPlayTime - bVar.kSO;
            bVar.kTd = j >= 0;
            if (bVar.kTd && !bVar.terminated) {
                bVar.kTa = b.a(j, bVar.kSP, bVar.kSR, bVar.kSj, bVar.kST, bVar.kSn);
                bVar.kTb = b.a(j, bVar.kSQ, bVar.kSS, bVar.kSl, bVar.kSU, bVar.kSp);
                bVar.kTc = b.a(j, bVar.kSV, bVar.kSW, bVar.kSv, bVar.kSX, bVar.kSx);
                if (bVar.kSd != null) {
                    bVar.alpha = (int) (bVar.kSd.getInterpolation(((float) j) / bVar.kSY) * 255.0f);
                } else {
                    bVar.alpha = 255;
                }
                boolean z = !bVar.kTe && ((float) j) >= bVar.kSY;
                bVar.terminated = z;
                bVar.kSZ = Math.min(1.0f, ((float) j) / bVar.kSY);
            }
            if ((!bVar.terminated ? 1 : null) == null) {
                it.remove();
                cVar2.kRW.add(bVar);
            }
        }
        if (this.kSC.kRX.size() != 0 || currentPlayTime < this.kSC.kSa) {
            this.kSC.kRV.invalidate();
        } else {
            this.kSC.bbe();
        }
    }
}
