package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.SpanWatcher;
import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.x;

class x$2 implements SpanWatcher {
    final /* synthetic */ x gIT;

    x$2(x xVar) {
        this.gIT = xVar;
    }

    public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        if (af.bt(obj)) {
            x.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", new Object[]{spannable, obj.getClass().getSimpleName()});
        }
    }

    public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        if (af.bt(obj)) {
            x.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", new Object[]{spannable, obj.getClass().getSimpleName()});
            this.gIT.guJ.removeCallbacks(this.gIT.gIS);
            this.gIT.guJ.postDelayed(this.gIT.gIS, 100);
        }
    }

    public final void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        if (af.bt(obj)) {
            x.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", new Object[]{spannable, obj.getClass().getSimpleName()});
        }
    }
}
