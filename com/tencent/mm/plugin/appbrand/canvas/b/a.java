package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.mm.plugin.appbrand.q.j;
import java.io.Serializable;

public final class a extends Paint implements Serializable {
    public int fns = a.fnw;
    private float fnt = (((float) getAlpha()) / 255.0f);
    private String fnu;
    private int fnv;
    private int pN = getColor();

    public enum a {
        ;

        static {
            fnw = 1;
            fnx = 2;
            fny = 3;
            fnz = 4;
            fnA = new int[]{fnw, fnx, fny, fnz};
        }
    }

    protected final Object clone() {
        return super.clone();
    }

    public final a adp() {
        a aVar = new a();
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Object a = j.a(Shader.class, "copy", shader, new Class[0], new Object[0], null);
            if (a != null && (a instanceof Shader)) {
                shader = (Shader) a;
            }
            aVar.setShader(shader);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.fns = this.fns;
        return aVar;
    }

    public final void X(float f) {
        this.fnt = f;
        setColor(this.pN);
    }

    public final void setColor(int i) {
        this.pN = i;
        super.setColor(((((int) (((float) Color.alpha(i)) * this.fnt)) & 255) << 24) | (16777215 & i));
    }

    public final void reset() {
        this.fns = a.fnw;
        super.reset();
    }

    public final void rp(String str) {
        this.fnu = str;
        setTypeface(Typeface.create(str, this.fnv));
    }

    public final void jN(int i) {
        this.fnv = i;
        setTypeface(Typeface.create(this.fnu, i));
    }
}
