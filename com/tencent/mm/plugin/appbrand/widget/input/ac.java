package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.f;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

final class ac<Input extends EditText & z> {
    final String TAG;
    final Input gIY;
    final float gIZ;
    f gJa;
    MotionEvent gJb;
    boolean gJc = false;
    final Runnable gJd = new 1(this);
    final Runnable gJe = new 2(this);

    ac(Input input) {
        this.gIY = input;
        this.TAG = "MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[]{input.toString()});
        this.gIZ = (float) ViewConfiguration.get(input.getContext()).getScaledTouchSlop();
    }

    final void apS() {
        this.gJc = false;
        this.gIY.removeCallbacks(this.gJd);
        this.gIY.removeCallbacks(this.gJe);
        this.gJa = null;
        if (this.gJb != null) {
            this.gJb.recycle();
            this.gJb = null;
        }
    }

    final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        float x = motionEvent.getX(motionEvent.getActionIndex());
        float y = motionEvent.getY(motionEvent.getActionIndex());
        x.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[]{Float.valueOf(this.gIZ), Float.valueOf(x), Float.valueOf(motionEvent2.getX(motionEvent2.getActionIndex())), Float.valueOf(y), Float.valueOf(motionEvent2.getY(motionEvent2.getActionIndex())), b.C(motionEvent), b.C(motionEvent2)});
        if (Math.abs(motionEvent2.getY(motionEvent2.getActionIndex()) - y) > this.gIZ || Math.abs(r4 - x) > this.gIZ) {
            return false;
        }
        return true;
    }
}
