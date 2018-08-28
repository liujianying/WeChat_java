package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import java.util.Stack;

public final class f implements c {
    public String doU;
    public a fnf;
    public a fng;
    public Stack<a> fnh;
    public Stack<a> fni;
    public Paint fnj = new Paint();
    public Paint fnk;
    public g fnl;
    private c fnm;

    public f(c cVar) {
        this.fnm = cVar;
        this.fnf = new a();
        this.fng = new a();
        this.fnf.setStyle(Style.STROKE);
        this.fng.setStyle(Style.FILL);
        this.fnf.setAntiAlias(true);
        this.fng.setAntiAlias(true);
        this.fnf.setStrokeWidth((float) com.tencent.mm.plugin.appbrand.q.f.lP(1));
        this.fng.setStrokeWidth((float) com.tencent.mm.plugin.appbrand.q.f.lP(1));
        this.fnh = new Stack();
        this.fni = new Stack();
        this.fnj.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
    }

    public final void invalidate() {
        this.fnm.invalidate();
    }
}
