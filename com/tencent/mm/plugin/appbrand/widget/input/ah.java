package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public final class ah implements OnGlobalLayoutListener {
    private final View gJC;
    private final a gJD;
    private int gJE;
    private int gJF;
    private boolean gJG;

    public static void a(View view, a aVar) {
        OnGlobalLayoutListener ahVar = new ah(view, aVar);
        ahVar.gJC.getViewTreeObserver().addOnGlobalLayoutListener(ahVar);
    }

    private ah(View view, a aVar) {
        this.gJC = view;
        this.gJD = aVar;
    }

    public final void onGlobalLayout() {
        if (!this.gJG) {
            this.gJG = true;
            this.gJE = this.gJC.getWidth();
            this.gJF = this.gJC.getHeight();
        } else if (this.gJC.getWidth() != this.gJE || this.gJC.getHeight() != this.gJF) {
            this.gJD.apg();
            this.gJE = this.gJC.getWidth();
            this.gJF = this.gJC.getHeight();
        }
    }
}
