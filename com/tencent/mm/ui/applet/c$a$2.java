package com.tencent.mm.ui.applet;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.bv.b;
import com.tencent.mm.ui.applet.c.a;

class c$a$2 implements OnTouchListener {
    final /* synthetic */ a trJ;
    int trK;
    int trL;
    int trM = ((this.trP.widthPixels - this.trJ.trH.width) - 1);
    int trN = ((this.trP.heightPixels - this.trJ.trH.height) - 1);
    long trO;
    final /* synthetic */ DisplayMetrics trP;

    c$a$2(a aVar, DisplayMetrics displayMetrics) {
        this.trJ = aVar;
        this.trP = displayMetrics;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.trK = ((int) motionEvent.getRawX()) - this.trJ.trH.x;
                this.trL = ((int) motionEvent.getRawY()) - this.trJ.trH.y;
                this.trO = System.currentTimeMillis();
                break;
            case 1:
                if (System.currentTimeMillis() - this.trO < 300) {
                    b.cot();
                    b.V(false, true);
                    this.trJ.crb();
                    break;
                }
                break;
            case 2:
                this.trM = (this.trP.widthPixels - this.trJ.trH.width) - 1;
                this.trN = (this.trP.heightPixels - this.trJ.trH.height) - 1;
                this.trJ.trH.x = ((int) motionEvent.getRawX()) - this.trK;
                this.trJ.trH.y = ((int) motionEvent.getRawY()) - this.trL;
                this.trJ.trH.x = this.trJ.trH.x < 0 ? 0 : this.trJ.trH.x;
                this.trJ.trH.x = this.trJ.trH.x > this.trM ? this.trM : this.trJ.trH.x;
                this.trJ.trH.y = this.trJ.trH.y < 0 ? 0 : this.trJ.trH.y;
                this.trJ.trH.y = this.trJ.trH.y > this.trN ? this.trN : this.trJ.trH.y;
                this.trJ.trG.updateViewLayout(this.trJ.trF, this.trJ.trH);
                break;
        }
        return false;
    }
}
