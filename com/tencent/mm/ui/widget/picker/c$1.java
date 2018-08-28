package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Locale;

class c$1 implements OnClickListener {
    final /* synthetic */ c uLp;

    c$1(c cVar) {
        this.uLp = cVar;
    }

    public final void onClick(View view) {
        Object obj;
        c cVar = this.uLp;
        if (c.a(this.uLp) == null) {
            obj = null;
        } else {
            CustomTimePicker a = c.a(this.uLp);
            obj = String.format(Locale.US, "%02d:%02d", new Object[]{a.getCurrentHour(), a.getCurrentMinute()});
        }
        c.a(cVar, true, obj);
    }
}
