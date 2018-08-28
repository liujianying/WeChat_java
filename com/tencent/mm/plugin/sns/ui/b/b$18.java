package com.tencent.mm.plugin.sns.ui.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class b$18 implements OnTouchListener {
    final /* synthetic */ b olf;

    b$18(b bVar) {
        this.olf = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        x.d("MicroMsg.TimelineClickListener", "v " + view.getId() + "  ");
        this.olf.cG(view);
        return false;
    }
}
