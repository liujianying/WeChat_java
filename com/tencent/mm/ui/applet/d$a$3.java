package com.tencent.mm.ui.applet;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.bv.d;
import com.tencent.mm.ui.applet.d.a;

class d$a$3 implements OnTouchListener {
    int trK;
    int trL;
    int trM = ((this.trP.widthPixels - this.tse.trH.width) - 1);
    int trN = ((this.trP.heightPixels - this.tse.trH.height) - 1);
    long trO;
    final /* synthetic */ DisplayMetrics trP;
    final /* synthetic */ a tse;

    d$a$3(a aVar, DisplayMetrics displayMetrics) {
        this.tse = aVar;
        this.trP = displayMetrics;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.trK = ((int) motionEvent.getRawX()) - this.tse.trH.x;
                this.trL = ((int) motionEvent.getRawY()) - this.tse.trH.y;
                this.trO = System.currentTimeMillis();
                break;
            case 1:
                if (System.currentTimeMillis() - this.trO < 300) {
                    a aVar = this.tse;
                    aVar.tsd.removeMessages(0);
                    aVar.tsc = 0;
                    if (!aVar.trZ) {
                        aVar.bRk.setVisibility(0);
                        aVar.bRk.setBackgroundDrawable(aVar.context.getResources().getDrawable(R.g.trace_stop_nor));
                        aVar.trZ = !aVar.trZ;
                        aVar.tsb = new d.a(null, 6, 8, 0);
                        d.cov().c(aVar.tsb);
                        aVar.crd();
                        break;
                    }
                    aVar.bRm.setVisibility(0);
                    aVar.bRk.setVisibility(4);
                    if (!d.cov().b(aVar.tsb)) {
                        aVar.gC(aVar.context);
                        break;
                    }
                }
                break;
            case 2:
                this.trM = (this.trP.widthPixels - this.tse.trH.width) - 1;
                this.trN = (this.trP.heightPixels - this.tse.trH.height) - 1;
                this.tse.trH.x = ((int) motionEvent.getRawX()) - this.trK;
                this.tse.trH.y = ((int) motionEvent.getRawY()) - this.trL;
                this.tse.trH.x = this.tse.trH.x < 0 ? 0 : this.tse.trH.x;
                this.tse.trH.x = this.tse.trH.x > this.trM ? this.trM : this.tse.trH.x;
                this.tse.trH.y = this.tse.trH.y < 0 ? 0 : this.tse.trH.y;
                this.tse.trH.y = this.tse.trH.y > this.trN ? this.trN : this.tse.trH.y;
                this.tse.trG.updateViewLayout(this.tse.trF, this.tse.trH);
                break;
        }
        return false;
    }
}
