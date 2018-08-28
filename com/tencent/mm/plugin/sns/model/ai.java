package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import java.util.HashMap;
import java.util.Map;

public final class ai extends a {
    int alpha = 255;
    long jEK;
    boolean jEL = false;
    private Map<String, Boolean> nre = new HashMap();

    public ai(String str, n nVar, long j) {
        super(str, nVar);
        if (j != 0) {
            this.jEK = j;
            this.nre.put(str, Boolean.valueOf(true));
            this.jEL = true;
        } else if (!this.nre.containsKey(str)) {
            this.jEK = SystemClock.uptimeMillis();
            this.nre.put(str, Boolean.valueOf(true));
            this.jEL = true;
        }
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Bitmap Fx = this.dvu.Fx();
        if (i.q(Fx)) {
            if (this.jEL) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.jEK)) / 150.0f;
                if (this.jEK == 0) {
                    uptimeMillis = 0.0f;
                }
                if (uptimeMillis >= 1.0f) {
                    this.jEL = false;
                } else {
                    dvs.setAlpha((int) (uptimeMillis * ((float) this.alpha)));
                    canvas.drawBitmap(Fx, null, bounds, dvs);
                    invalidateSelf();
                    return;
                }
            }
            dvs.setAlpha(this.alpha);
            canvas.drawBitmap(Fx, null, bounds, dvs);
            return;
        }
        canvas.drawColor(-1118482);
        this.jEK = 0;
    }
}
