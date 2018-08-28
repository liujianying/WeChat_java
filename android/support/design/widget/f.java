package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.a$i;
import android.support.v4.d.d;
import android.support.v4.d.e;
import android.support.v4.view.z;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class f {
    private static final boolean cZ = (VERSION.SDK_INT < 18);
    private static final Paint da = null;
    private Paint dA;
    private float dB;
    private float dC;
    private float dD;
    private float dE;
    private boolean dF;
    private final TextPaint dG;
    Interpolator dH;
    private Interpolator dI;
    private float dJ;
    private float dK;
    private float dL;
    private int dM;
    private float dN;
    private float dO;
    private float dP;
    private int dQ;
    private boolean db;
    float dc;
    private final Rect dd;
    private final Rect de;
    private final RectF dg;
    int dh = 16;
    int di = 16;
    float dj = 15.0f;
    float dk = 15.0f;
    private int dl;
    int dm;
    private float dn;
    private float do;
    private float dp;
    private float dq;
    private float dr;
    private float ds;
    Typeface dt;
    Typeface du;
    private Typeface dv;
    private CharSequence dw;
    private boolean dx;
    private boolean dy;
    private Bitmap dz;
    CharSequence mText;
    private final View mView;

    public f(View view) {
        this.mView = view;
        this.dG = new TextPaint(129);
        this.de = new Rect();
        this.dd = new Rect();
        this.dg = new RectF();
    }

    final void b(Interpolator interpolator) {
        this.dI = interpolator;
        Z();
    }

    final void v(int i) {
        if (this.dm != i) {
            this.dm = i;
            Z();
        }
    }

    final void w(int i) {
        if (this.dl != i) {
            this.dl = i;
            Z();
        }
    }

    final void b(int i, int i2, int i3, int i4) {
        if (!a(this.dd, i, i2, i3, i4)) {
            this.dd.set(i, i2, i3, i4);
            this.dF = true;
            W();
        }
    }

    final void c(int i, int i2, int i3, int i4) {
        if (!a(this.de, i, i2, i3, i4)) {
            this.de.set(i, i2, i3, i4);
            this.dF = true;
            W();
        }
    }

    private void W() {
        boolean z = this.de.width() > 0 && this.de.height() > 0 && this.dd.width() > 0 && this.dd.height() > 0;
        this.db = z;
    }

    final void x(int i) {
        if (this.dh != i) {
            this.dh = i;
            Z();
        }
    }

    final void y(int i) {
        if (this.di != i) {
            this.di = i;
            Z();
        }
    }

    final void z(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, a$i.TextAppearance);
        if (obtainStyledAttributes.hasValue(a$i.TextAppearance_android_textColor)) {
            this.dm = obtainStyledAttributes.getColor(a$i.TextAppearance_android_textColor, this.dm);
        }
        if (obtainStyledAttributes.hasValue(a$i.TextAppearance_android_textSize)) {
            this.dk = (float) obtainStyledAttributes.getDimensionPixelSize(a$i.TextAppearance_android_textSize, (int) this.dk);
        }
        this.dM = obtainStyledAttributes.getInt(a$i.TextAppearance_android_shadowColor, 0);
        this.dK = obtainStyledAttributes.getFloat(a$i.TextAppearance_android_shadowDx, 0.0f);
        this.dL = obtainStyledAttributes.getFloat(a$i.TextAppearance_android_shadowDy, 0.0f);
        this.dJ = obtainStyledAttributes.getFloat(a$i.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.dt = B(i);
        }
        Z();
    }

    final void A(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, a$i.TextAppearance);
        if (obtainStyledAttributes.hasValue(a$i.TextAppearance_android_textColor)) {
            this.dl = obtainStyledAttributes.getColor(a$i.TextAppearance_android_textColor, this.dl);
        }
        if (obtainStyledAttributes.hasValue(a$i.TextAppearance_android_textSize)) {
            this.dj = (float) obtainStyledAttributes.getDimensionPixelSize(a$i.TextAppearance_android_textSize, (int) this.dj);
        }
        this.dQ = obtainStyledAttributes.getInt(a$i.TextAppearance_android_shadowColor, 0);
        this.dO = obtainStyledAttributes.getFloat(a$i.TextAppearance_android_shadowDx, 0.0f);
        this.dP = obtainStyledAttributes.getFloat(a$i.TextAppearance_android_shadowDy, 0.0f);
        this.dN = obtainStyledAttributes.getFloat(a$i.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.du = B(i);
        }
        Z();
    }

    private Typeface B(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    final void a(Typeface typeface) {
        this.du = typeface;
        this.dt = typeface;
        Z();
    }

    final Typeface X() {
        return this.dt != null ? this.dt : Typeface.DEFAULT;
    }

    final void h(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.dc) {
            this.dc = f;
            Y();
        }
    }

    private void Y() {
        i(this.dc);
    }

    private void i(float f) {
        this.dg.left = a((float) this.dd.left, (float) this.de.left, f, this.dH);
        this.dg.top = a(this.dn, this.do, f, this.dH);
        this.dg.right = a((float) this.dd.right, (float) this.de.right, f, this.dH);
        this.dg.bottom = a((float) this.dd.bottom, (float) this.de.bottom, f, this.dH);
        this.dr = a(this.dp, this.dq, f, this.dH);
        this.ds = a(this.dn, this.do, f, this.dH);
        j(a(this.dj, this.dk, f, this.dI));
        if (this.dm != this.dl) {
            this.dG.setColor(b(this.dl, this.dm, f));
        } else {
            this.dG.setColor(this.dm);
        }
        this.dG.setShadowLayer(a(this.dN, this.dJ, f, null), a(this.dO, this.dK, f, null), a(this.dP, this.dL, f, null), b(this.dQ, this.dM, f));
        z.E(this.mView);
    }

    public final void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.dw != null && this.db) {
            float f;
            float f2 = this.dr;
            float f3 = this.ds;
            int i = (!this.dy || this.dz == null) ? 0 : 1;
            if (i != 0) {
                f = this.dB * this.dD;
            } else {
                this.dG.ascent();
                f = 0.0f;
                this.dG.descent();
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.dD != 1.0f) {
                canvas.scale(this.dD, this.dD, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.dz, f2, f3, this.dA);
            } else {
                canvas.drawText(this.dw, 0, this.dw.length(), f2, f3, this.dG);
            }
        }
        canvas.restoreToCount(save);
    }

    private void j(float f) {
        k(f);
        boolean z = cZ && this.dD != 1.0f;
        this.dy = z;
        if (this.dy && this.dz == null && !this.dd.isEmpty() && !TextUtils.isEmpty(this.dw)) {
            i(0.0f);
            this.dB = this.dG.ascent();
            this.dC = this.dG.descent();
            int round = Math.round(this.dG.measureText(this.dw, 0, this.dw.length()));
            int round2 = Math.round(this.dC - this.dB);
            if (round > 0 && round2 > 0) {
                this.dz = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.dz).drawText(this.dw, 0, this.dw.length(), 0.0f, ((float) round2) - this.dG.descent(), this.dG);
                if (this.dA == null) {
                    this.dA = new Paint(3);
                }
            }
        }
        z.E(this.mView);
    }

    private void k(float f) {
        boolean z = true;
        if (this.mText != null) {
            float width;
            float f2;
            boolean z2;
            if (n(f, this.dk)) {
                width = (float) this.de.width();
                f2 = this.dk;
                this.dD = 1.0f;
                if (this.dv != this.dt) {
                    this.dv = this.dt;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                width = (float) this.dd.width();
                f2 = this.dj;
                if (this.dv != this.du) {
                    this.dv = this.du;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (n(f, this.dj)) {
                    this.dD = 1.0f;
                } else {
                    this.dD = f / this.dj;
                }
            }
            if (width > 0.0f) {
                if (this.dE != f2 || this.dF || r0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.dE = f2;
                this.dF = false;
            }
            if (this.dw == null || r0) {
                this.dG.setTextSize(this.dE);
                this.dG.setTypeface(this.dv);
                TextPaint textPaint = this.dG;
                if (this.dD != 1.0f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                textPaint.setLinearText(z2);
                CharSequence ellipsize = TextUtils.ellipsize(this.mText, this.dG, width, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.dw)) {
                    d dVar;
                    this.dw = ellipsize;
                    CharSequence charSequence = this.dw;
                    if (z.I(this.mView) != 1) {
                        z = false;
                    }
                    if (z) {
                        dVar = e.th;
                    } else {
                        dVar = e.tg;
                    }
                    this.dx = dVar.a(charSequence, charSequence.length());
                }
            }
        }
    }

    public final void Z() {
        int i = 1;
        float f = 0.0f;
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            float measureText;
            float f2 = this.dE;
            k(this.dk);
            if (this.dw != null) {
                measureText = this.dG.measureText(this.dw, 0, this.dw.length());
            } else {
                measureText = 0.0f;
            }
            int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(this.di, this.dx ? 1 : 0);
            switch (absoluteGravity & 112) {
                case a$i.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.do = ((float) this.de.top) - this.dG.ascent();
                    break;
                case 80:
                    this.do = (float) this.de.bottom;
                    break;
                default:
                    this.do = (((this.dG.descent() - this.dG.ascent()) / 2.0f) - this.dG.descent()) + ((float) this.de.centerY());
                    break;
            }
            switch (absoluteGravity & 8388615) {
                case 1:
                    this.dq = ((float) this.de.centerX()) - (measureText / 2.0f);
                    break;
                case 5:
                    this.dq = ((float) this.de.right) - measureText;
                    break;
                default:
                    this.dq = (float) this.de.left;
                    break;
            }
            k(this.dj);
            if (this.dw != null) {
                f = this.dG.measureText(this.dw, 0, this.dw.length());
            }
            int i2 = this.dh;
            if (!this.dx) {
                i = 0;
            }
            i2 = android.support.v4.view.f.getAbsoluteGravity(i2, i);
            switch (i2 & 112) {
                case a$i.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.dn = ((float) this.dd.top) - this.dG.ascent();
                    break;
                case 80:
                    this.dn = (float) this.dd.bottom;
                    break;
                default:
                    this.dn = (((this.dG.descent() - this.dG.ascent()) / 2.0f) - this.dG.descent()) + ((float) this.dd.centerY());
                    break;
            }
            switch (i2 & 8388615) {
                case 1:
                    this.dp = ((float) this.dd.centerX()) - (f / 2.0f);
                    break;
                case 5:
                    this.dp = ((float) this.dd.right) - f;
                    break;
                default:
                    this.dp = (float) this.dd.left;
                    break;
            }
            aa();
            j(f2);
            Y();
        }
    }

    final void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.dw = null;
            aa();
            Z();
        }
    }

    private void aa() {
        if (this.dz != null) {
            this.dz.recycle();
            this.dz = null;
        }
    }

    private static boolean n(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static int b(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static float a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return a.b(f, f2, f3);
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
