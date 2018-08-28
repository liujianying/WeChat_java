package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public final class f extends e {
    static final Mode jK = Mode.SRC_IN;
    f jL;
    private PorterDuffColorFilter jM;
    private ColorFilter jN;
    private boolean jO;
    boolean jP;
    private ConstantState jQ;
    private final float[] jR;
    private final Matrix jS;
    private final Rect jT;

    private static class c {
        int jA;
        int[] jU;
        final Matrix kh = new Matrix();
        final ArrayList<Object> ki = new ArrayList();
        float kj = 0.0f;
        float kk = 0.0f;
        float kl = 0.0f;
        float km = 0.0f;
        float kn = 0.0f;
        final Matrix ko = new Matrix();
        String kp = null;
        float mScaleX = 1.0f;
        float mScaleY = 1.0f;

        public c(c cVar, android.support.v4.e.a<String, Object> aVar) {
            this.kj = cVar.kj;
            this.kk = cVar.kk;
            this.kl = cVar.kl;
            this.mScaleX = cVar.mScaleX;
            this.mScaleY = cVar.mScaleY;
            this.km = cVar.km;
            this.kn = cVar.kn;
            this.jU = cVar.jU;
            this.kp = cVar.kp;
            this.jA = cVar.jA;
            if (this.kp != null) {
                aVar.put(this.kp, this);
            }
            this.ko.set(cVar.ko);
            ArrayList arrayList = cVar.ki;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof c) {
                        this.ki.add(new c((c) obj, aVar));
                    } else {
                        d bVar;
                        if (obj instanceof b) {
                            bVar = new b((b) obj);
                        } else if (obj instanceof a) {
                            bVar = new a((a) obj);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.ki.add(bVar);
                        if (bVar.kr != null) {
                            aVar.put(bVar.kr, bVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static class d {
        int jA;
        protected android.support.a.a.c.b[] kq = null;
        String kr;

        public d(d dVar) {
            this.kr = dVar.kr;
            this.jA = dVar.jA;
            this.kq = c.a(dVar.kq);
        }

        public final void a(Path path) {
            path.reset();
            if (this.kq != null) {
                android.support.a.a.c.b[] bVarArr = this.kq;
                float[] fArr = new float[6];
                char c = 'm';
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < bVarArr.length) {
                        int i3;
                        char c2 = bVarArr[i2].jH;
                        float[] fArr2 = bVarArr[i2].jI;
                        float f = fArr[0];
                        float f2 = fArr[1];
                        float f3 = fArr[2];
                        float f4 = fArr[3];
                        float f5 = fArr[4];
                        float f6 = fArr[5];
                        switch (c2) {
                            case 'A':
                            case 'a':
                                i3 = 7;
                                break;
                            case 'C':
                            case 'c':
                                i3 = 6;
                                break;
                            case 'H':
                            case 'V':
                            case 'h':
                            case 'v':
                                i3 = 1;
                                break;
                            case 'L':
                            case 'M':
                            case 'T':
                            case 'l':
                            case 'm':
                            case 't':
                                i3 = 2;
                                break;
                            case 'Q':
                            case 'S':
                            case 'q':
                            case 's':
                                i3 = 4;
                                break;
                            case 'Z':
                            case 'z':
                                path.close();
                                path.moveTo(f5, f6);
                                f4 = f6;
                                f3 = f5;
                                f2 = f6;
                                f = f5;
                                i3 = 2;
                                break;
                            default:
                                i3 = 2;
                                break;
                        }
                        int i4 = 0;
                        float f7 = f6;
                        float f8 = f5;
                        float f9 = f4;
                        float f10 = f2;
                        float f11 = f;
                        char c3 = c;
                        while (i4 < fArr2.length) {
                            float f12;
                            float f13;
                            switch (c2) {
                                case 'A':
                                    android.support.a.a.c.b.a(path, f11, f10, fArr2[i4 + 5], fArr2[i4 + 6], fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                                    f11 = fArr2[i4 + 5];
                                    f9 = fArr2[i4 + 6];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f3 = f11;
                                    f2 = f9;
                                    f = f11;
                                    break;
                                case 'C':
                                    path.cubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3], fArr2[i4 + 4], fArr2[i4 + 5]);
                                    f11 = fArr2[i4 + 4];
                                    f4 = fArr2[i4 + 5];
                                    f3 = fArr2[i4 + 2];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = fArr2[i4 + 3];
                                    f2 = f4;
                                    f = f11;
                                    break;
                                case 'H':
                                    path.lineTo(fArr2[i4 + 0], f10);
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = f10;
                                    f = fArr2[i4 + 0];
                                    break;
                                case 'L':
                                    path.lineTo(fArr2[i4 + 0], fArr2[i4 + 1]);
                                    f11 = fArr2[i4 + 0];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = fArr2[i4 + 1];
                                    f = f11;
                                    break;
                                case 'M':
                                    f13 = fArr2[i4 + 0];
                                    f4 = fArr2[i4 + 1];
                                    if (i4 <= 0) {
                                        path.moveTo(fArr2[i4 + 0], fArr2[i4 + 1]);
                                        f6 = f4;
                                        f5 = f13;
                                        f12 = f9;
                                        f2 = f4;
                                        f = f13;
                                        break;
                                    }
                                    path.lineTo(fArr2[i4 + 0], fArr2[i4 + 1]);
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = f4;
                                    f = f13;
                                    break;
                                case 'Q':
                                    path.quadTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3]);
                                    f3 = fArr2[i4 + 0];
                                    f9 = fArr2[i4 + 1];
                                    f11 = fArr2[i4 + 2];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = fArr2[i4 + 3];
                                    f = f11;
                                    break;
                                case 'S':
                                    if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                        f12 = (2.0f * f11) - f3;
                                        f6 = (2.0f * f10) - f9;
                                    } else {
                                        f6 = f10;
                                        f12 = f11;
                                    }
                                    path.cubicTo(f12, f6, fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3]);
                                    f3 = fArr2[i4 + 0];
                                    f9 = fArr2[i4 + 1];
                                    f11 = fArr2[i4 + 2];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = fArr2[i4 + 3];
                                    f = f11;
                                    break;
                                case 'T':
                                    if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                        f11 = (2.0f * f11) - f3;
                                        f10 = (2.0f * f10) - f9;
                                    }
                                    path.quadTo(f11, f10, fArr2[i4 + 0], fArr2[i4 + 1]);
                                    f13 = fArr2[i4 + 0];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f10;
                                    f3 = f11;
                                    f2 = fArr2[i4 + 1];
                                    f = f13;
                                    break;
                                case 'V':
                                    path.lineTo(f11, fArr2[i4 + 0]);
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = fArr2[i4 + 0];
                                    f = f11;
                                    break;
                                case 'a':
                                    android.support.a.a.c.b.a(path, f11, f10, fArr2[i4 + 5] + f11, fArr2[i4 + 6] + f10, fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                                    f11 += fArr2[i4 + 5];
                                    f9 = f10 + fArr2[i4 + 6];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f3 = f11;
                                    f2 = f9;
                                    f = f11;
                                    break;
                                case 'c':
                                    path.rCubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3], fArr2[i4 + 4], fArr2[i4 + 5]);
                                    f3 = f11 + fArr2[i4 + 2];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f10 + fArr2[i4 + 3];
                                    f2 = fArr2[i4 + 5] + f10;
                                    f = f11 + fArr2[i4 + 4];
                                    break;
                                case 'h':
                                    path.rLineTo(fArr2[i4 + 0], 0.0f);
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = f10;
                                    f = f11 + fArr2[i4 + 0];
                                    break;
                                case 'l':
                                    path.rLineTo(fArr2[i4 + 0], fArr2[i4 + 1]);
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = fArr2[i4 + 1] + f10;
                                    f = f11 + fArr2[i4 + 0];
                                    break;
                                case 'm':
                                    f13 = f11 + fArr2[i4 + 0];
                                    f4 = fArr2[i4 + 1] + f10;
                                    if (i4 <= 0) {
                                        path.rMoveTo(fArr2[i4 + 0], fArr2[i4 + 1]);
                                        f6 = f4;
                                        f5 = f13;
                                        f12 = f9;
                                        f2 = f4;
                                        f = f13;
                                        break;
                                    }
                                    path.rLineTo(fArr2[i4 + 0], fArr2[i4 + 1]);
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = f4;
                                    f = f13;
                                    break;
                                case 'q':
                                    path.rQuadTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3]);
                                    f3 = f11 + fArr2[i4 + 0];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f10 + fArr2[i4 + 1];
                                    f2 = fArr2[i4 + 3] + f10;
                                    f = f11 + fArr2[i4 + 2];
                                    break;
                                case 's':
                                    f12 = 0.0f;
                                    f6 = 0.0f;
                                    if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                        f12 = f11 - f3;
                                        f6 = f10 - f9;
                                    }
                                    path.rCubicTo(f12, f6, fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3]);
                                    f3 = f11 + fArr2[i4 + 0];
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f10 + fArr2[i4 + 1];
                                    f2 = fArr2[i4 + 3] + f10;
                                    f = f11 + fArr2[i4 + 2];
                                    break;
                                case 't':
                                    f12 = 0.0f;
                                    f4 = 0.0f;
                                    if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                        f12 = f11 - f3;
                                        f4 = f10 - f9;
                                    }
                                    path.rQuadTo(f12, f4, fArr2[i4 + 0], fArr2[i4 + 1]);
                                    f3 = f11 + f12;
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f10 + f4;
                                    f2 = fArr2[i4 + 1] + f10;
                                    f = f11 + fArr2[i4 + 0];
                                    break;
                                case 'v':
                                    path.rLineTo(0.0f, fArr2[i4 + 0]);
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = fArr2[i4 + 0] + f10;
                                    f = f11;
                                    break;
                                default:
                                    f6 = f7;
                                    f5 = f8;
                                    f12 = f9;
                                    f2 = f10;
                                    f = f11;
                                    break;
                            }
                            i4 += i3;
                            f7 = f6;
                            f8 = f5;
                            f9 = f12;
                            f10 = f2;
                            f11 = f;
                            c3 = c2;
                        }
                        fArr[0] = f11;
                        fArr[1] = f10;
                        fArr[2] = f3;
                        fArr[3] = f9;
                        fArr[4] = f8;
                        fArr[5] = f7;
                        c = bVarArr[i2].jH;
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean aU() {
            return false;
        }
    }

    private static class e {
        private static final Matrix ku = new Matrix();
        private int jA;
        float kA;
        float kB;
        float kC;
        float kD;
        int kE;
        String kF;
        final android.support.v4.e.a<String, Object> kG;
        private final Path ks;
        private final Path kt;
        private final Matrix kv;
        private Paint kw;
        private Paint kx;
        private PathMeasure ky;
        private final c kz;

        public e() {
            this.kv = new Matrix();
            this.kA = 0.0f;
            this.kB = 0.0f;
            this.kC = 0.0f;
            this.kD = 0.0f;
            this.kE = 255;
            this.kF = null;
            this.kG = new android.support.v4.e.a();
            this.kz = new c();
            this.ks = new Path();
            this.kt = new Path();
        }

        public e(e eVar) {
            this.kv = new Matrix();
            this.kA = 0.0f;
            this.kB = 0.0f;
            this.kC = 0.0f;
            this.kD = 0.0f;
            this.kE = 255;
            this.kF = null;
            this.kG = new android.support.v4.e.a();
            this.kz = new c(eVar.kz, this.kG);
            this.ks = new Path(eVar.ks);
            this.kt = new Path(eVar.kt);
            this.kA = eVar.kA;
            this.kB = eVar.kB;
            this.kC = eVar.kC;
            this.kD = eVar.kD;
            this.jA = eVar.jA;
            this.kE = eVar.kE;
            this.kF = eVar.kF;
            if (eVar.kF != null) {
                this.kG.put(eVar.kF, this);
            }
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.kh.set(matrix);
            cVar.kh.preConcat(cVar.ko);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < cVar.ki.size()) {
                    Object obj = cVar.ki.get(i4);
                    if (obj instanceof c) {
                        a((c) obj, cVar.kh, canvas, i, i2, colorFilter);
                    } else if (obj instanceof d) {
                        d dVar = (d) obj;
                        float f = ((float) i) / this.kC;
                        float f2 = ((float) i2) / this.kD;
                        float min = Math.min(f, f2);
                        Matrix matrix2 = cVar.kh;
                        this.kv.set(matrix2);
                        this.kv.postScale(f, f2);
                        float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
                        matrix2.mapVectors(fArr);
                        f2 = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
                        float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
                        float f3 = (fArr[3] * fArr[0]) - (fArr[1] * fArr[2]);
                        f2 = Math.max(f2, hypot);
                        f = 0.0f;
                        if (f2 > 0.0f) {
                            f = Math.abs(f3) / f2;
                        }
                        if (f != 0.0f) {
                            dVar.a(this.ks);
                            Path path = this.ks;
                            this.kt.reset();
                            if (dVar.aU()) {
                                this.kt.addPath(path, this.kv);
                                canvas.clipPath(this.kt, Op.REPLACE);
                            } else {
                                Paint paint;
                                b bVar = (b) dVar;
                                if (!(bVar.kb == 0.0f && bVar.kc == 1.0f)) {
                                    hypot = (bVar.kb + bVar.kd) % 1.0f;
                                    f3 = (bVar.kc + bVar.kd) % 1.0f;
                                    if (this.ky == null) {
                                        this.ky = new PathMeasure();
                                    }
                                    this.ky.setPath(this.ks, false);
                                    float length = this.ky.getLength();
                                    hypot *= length;
                                    f3 *= length;
                                    path.reset();
                                    if (hypot > f3) {
                                        this.ky.getSegment(hypot, length, path, true);
                                        this.ky.getSegment(0.0f, f3, path, true);
                                    } else {
                                        this.ky.getSegment(hypot, f3, path, true);
                                    }
                                    path.rLineTo(0.0f, 0.0f);
                                }
                                this.kt.addPath(path, this.kv);
                                if (bVar.jX != 0) {
                                    if (this.kx == null) {
                                        this.kx = new Paint();
                                        this.kx.setStyle(Style.FILL);
                                        this.kx.setAntiAlias(true);
                                    }
                                    paint = this.kx;
                                    paint.setColor(((((int) (((float) Color.alpha(bVar.jX)) * bVar.ka)) << 24) | (16777215 & bVar.jX)));
                                    paint.setColorFilter(colorFilter);
                                    canvas.drawPath(this.kt, paint);
                                }
                                if (bVar.jV != 0) {
                                    if (this.kw == null) {
                                        this.kw = new Paint();
                                        this.kw.setStyle(Style.STROKE);
                                        this.kw.setAntiAlias(true);
                                    }
                                    paint = this.kw;
                                    if (bVar.kf != null) {
                                        paint.setStrokeJoin(bVar.kf);
                                    }
                                    if (bVar.ke != null) {
                                        paint.setStrokeCap(bVar.ke);
                                    }
                                    paint.setStrokeMiter(bVar.kg);
                                    paint.setColor(((((int) (((float) Color.alpha(bVar.jV)) * bVar.jY)) << 24) | (16777215 & bVar.jV)));
                                    paint.setColorFilter(colorFilter);
                                    paint.setStrokeWidth((f * min) * bVar.jW);
                                    canvas.drawPath(this.kt, paint);
                                }
                            }
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }

        public final void a(Canvas canvas, int i, int i2) {
            a(this.kz, ku, canvas, i, i2, null);
        }
    }

    private static class f extends ConstantState {
        int jA;
        e kH;
        ColorStateList kI;
        Mode kJ;
        boolean kK;
        Bitmap kL;
        ColorStateList kM;
        Mode kN;
        int kO;
        boolean kP;
        boolean kQ;
        Paint kR;

        public f(f fVar) {
            this.kI = null;
            this.kJ = f.jK;
            if (fVar != null) {
                this.jA = fVar.jA;
                this.kH = new e(fVar.kH);
                if (fVar.kH.kx != null) {
                    this.kH.kx = new Paint(fVar.kH.kx);
                }
                if (fVar.kH.kw != null) {
                    this.kH.kw = new Paint(fVar.kH.kw);
                }
                this.kI = fVar.kI;
                this.kJ = fVar.kJ;
                this.kK = fVar.kK;
            }
        }

        public final void j(int i, int i2) {
            this.kL.eraseColor(0);
            this.kH.a(new Canvas(this.kL), i, i2);
        }

        public f() {
            this.kI = null;
            this.kJ = f.jK;
            this.kH = new e();
        }

        public final Drawable newDrawable() {
            return new f(this, (byte) 0);
        }

        public final Drawable newDrawable(Resources resources) {
            return new f(this, (byte) 0);
        }

        public final int getChangingConfigurations() {
            return this.jA;
        }
    }

    private static class g extends ConstantState {
        private final ConstantState jE;

        public g(ConstantState constantState) {
            this.jE = constantState;
        }

        public final Drawable newDrawable() {
            Drawable fVar = new f();
            fVar.jJ = (VectorDrawable) this.jE.newDrawable();
            return fVar;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable fVar = new f();
            fVar.jJ = (VectorDrawable) this.jE.newDrawable(resources);
            return fVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            Drawable fVar = new f();
            fVar.jJ = (VectorDrawable) this.jE.newDrawable(resources, theme);
            return fVar;
        }

        public final boolean canApplyTheme() {
            return this.jE.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.jE.getChangingConfigurations();
        }
    }

    private static class a extends d {
        public a(a aVar) {
            super(aVar);
        }

        final void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.kr = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.kq = c.z(string);
            }
        }

        public final boolean aU() {
            return true;
        }
    }

    private static class b extends d {
        private int[] jU;
        int jV = 0;
        float jW = 0.0f;
        int jX = 0;
        float jY = 1.0f;
        int jZ;
        float ka = 1.0f;
        float kb = 0.0f;
        float kc = 1.0f;
        float kd = 0.0f;
        Cap ke = Cap.BUTT;
        Join kf = Join.MITER;
        float kg = 4.0f;

        public b(b bVar) {
            super(bVar);
            this.jU = bVar.jU;
            this.jV = bVar.jV;
            this.jW = bVar.jW;
            this.jY = bVar.jY;
            this.jX = bVar.jX;
            this.jZ = bVar.jZ;
            this.ka = bVar.ka;
            this.kb = bVar.kb;
            this.kc = bVar.kc;
            this.kd = bVar.kd;
            this.ke = bVar.ke;
            this.kf = bVar.kf;
            this.kg = bVar.kg;
        }

        final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.jU = null;
            if (d.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.kr = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.kq = c.z(string);
                }
                this.jX = d.a(typedArray, xmlPullParser, "fillColor", 1, this.jX);
                this.ka = d.a(typedArray, xmlPullParser, "fillAlpha", 12, this.ka);
                int a = d.a(typedArray, xmlPullParser, "strokeLineCap", 8);
                Cap cap = this.ke;
                switch (a) {
                    case 0:
                        cap = Cap.BUTT;
                        break;
                    case 1:
                        cap = Cap.ROUND;
                        break;
                    case 2:
                        cap = Cap.SQUARE;
                        break;
                }
                this.ke = cap;
                a = d.a(typedArray, xmlPullParser, "strokeLineJoin", 9);
                Join join = this.kf;
                switch (a) {
                    case 0:
                        join = Join.MITER;
                        break;
                    case 1:
                        join = Join.ROUND;
                        break;
                    case 2:
                        join = Join.BEVEL;
                        break;
                }
                this.kf = join;
                this.kg = d.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.kg);
                this.jV = d.a(typedArray, xmlPullParser, "strokeColor", 3, this.jV);
                this.jY = d.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.jY);
                this.jW = d.a(typedArray, xmlPullParser, "strokeWidth", 4, this.jW);
                this.kc = d.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.kc);
                this.kd = d.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.kd);
                this.kb = d.a(typedArray, xmlPullParser, "trimPathStart", 5, this.kb);
            }
        }
    }

    /* synthetic */ f(f fVar, byte b) {
        this(fVar);
    }

    private f() {
        this.jP = true;
        this.jR = new float[9];
        this.jS = new Matrix();
        this.jT = new Rect();
        this.jL = new f();
    }

    private f(f fVar) {
        this.jP = true;
        this.jR = new float[9];
        this.jS = new Matrix();
        this.jT = new Rect();
        this.jL = fVar;
        this.jM = a(fVar.kI, fVar.kJ);
    }

    public final Drawable mutate() {
        if (this.jJ != null) {
            this.jJ.mutate();
        } else if (!this.jO && super.mutate() == this) {
            this.jL = new f(this.jL);
            this.jO = true;
        }
        return this;
    }

    public final ConstantState getConstantState() {
        if (this.jJ != null) {
            return new g(this.jJ.getConstantState());
        }
        this.jL.jA = getChangingConfigurations();
        return this.jL;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r12) {
        /*
        r11 = this;
        r10 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r9 = 0;
        r4 = 1;
        r5 = 0;
        r0 = r11.jJ;
        if (r0 == 0) goto L_0x0011;
    L_0x000b:
        r0 = r11.jJ;
        r0.draw(r12);
    L_0x0010:
        return;
    L_0x0011:
        r0 = r11.jT;
        r11.copyBounds(r0);
        r0 = r11.jT;
        r0 = r0.width();
        if (r0 <= 0) goto L_0x0010;
    L_0x001e:
        r0 = r11.jT;
        r0 = r0.height();
        if (r0 <= 0) goto L_0x0010;
    L_0x0026:
        r0 = r11.jN;
        if (r0 != 0) goto L_0x00e1;
    L_0x002a:
        r0 = r11.jM;
    L_0x002c:
        r1 = r11.jS;
        r12.getMatrix(r1);
        r1 = r11.jS;
        r3 = r11.jR;
        r1.getValues(r3);
        r1 = r11.jR;
        r1 = r1[r5];
        r3 = java.lang.Math.abs(r1);
        r1 = r11.jR;
        r6 = 4;
        r1 = r1[r6];
        r1 = java.lang.Math.abs(r1);
        r6 = r11.jR;
        r6 = r6[r4];
        r6 = java.lang.Math.abs(r6);
        r7 = r11.jR;
        r8 = 3;
        r7 = r7[r8];
        r7 = java.lang.Math.abs(r7);
        r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1));
        if (r6 != 0) goto L_0x0062;
    L_0x005e:
        r6 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r6 == 0) goto L_0x0064;
    L_0x0062:
        r1 = r2;
        r3 = r2;
    L_0x0064:
        r2 = r11.jT;
        r2 = r2.width();
        r2 = (float) r2;
        r2 = r2 * r3;
        r2 = (int) r2;
        r3 = r11.jT;
        r3 = r3.height();
        r3 = (float) r3;
        r1 = r1 * r3;
        r1 = (int) r1;
        r2 = java.lang.Math.min(r10, r2);
        r3 = java.lang.Math.min(r10, r1);
        if (r2 <= 0) goto L_0x0010;
    L_0x0080:
        if (r3 <= 0) goto L_0x0010;
    L_0x0082:
        r6 = r12.save();
        r1 = r11.jT;
        r1 = r1.left;
        r1 = (float) r1;
        r7 = r11.jT;
        r7 = r7.top;
        r7 = (float) r7;
        r12.translate(r1, r7);
        r1 = r11.jT;
        r1.offsetTo(r5, r5);
        r7 = r11.jL;
        r1 = r7.kL;
        if (r1 == 0) goto L_0x00b1;
    L_0x009e:
        r1 = r7.kL;
        r1 = r1.getWidth();
        if (r2 != r1) goto L_0x00e5;
    L_0x00a6:
        r1 = r7.kL;
        r1 = r1.getHeight();
        if (r3 != r1) goto L_0x00e5;
    L_0x00ae:
        r1 = r4;
    L_0x00af:
        if (r1 != 0) goto L_0x00bb;
    L_0x00b1:
        r1 = android.graphics.Bitmap.Config.ARGB_8888;
        r1 = android.graphics.Bitmap.createBitmap(r2, r3, r1);
        r7.kL = r1;
        r7.kQ = r4;
    L_0x00bb:
        r1 = r11.jP;
        if (r1 != 0) goto L_0x00e7;
    L_0x00bf:
        r1 = r11.jL;
        r1.j(r2, r3);
    L_0x00c4:
        r2 = r11.jL;
        r3 = r11.jT;
        r1 = r2.kH;
        r1 = r1.kE;
        r7 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r1 >= r7) goto L_0x0128;
    L_0x00d0:
        r1 = r4;
    L_0x00d1:
        if (r1 != 0) goto L_0x012a;
    L_0x00d3:
        if (r0 != 0) goto L_0x012a;
    L_0x00d5:
        r0 = 0;
    L_0x00d6:
        r1 = r2.kL;
        r2 = 0;
        r12.drawBitmap(r1, r2, r3, r0);
        r12.restoreToCount(r6);
        goto L_0x0010;
    L_0x00e1:
        r0 = r11.jN;
        goto L_0x002c;
    L_0x00e5:
        r1 = r5;
        goto L_0x00af;
    L_0x00e7:
        r1 = r11.jL;
        r7 = r1.kQ;
        if (r7 != 0) goto L_0x0126;
    L_0x00ed:
        r7 = r1.kM;
        r8 = r1.kI;
        if (r7 != r8) goto L_0x0126;
    L_0x00f3:
        r7 = r1.kN;
        r8 = r1.kJ;
        if (r7 != r8) goto L_0x0126;
    L_0x00f9:
        r7 = r1.kP;
        r8 = r1.kK;
        if (r7 != r8) goto L_0x0126;
    L_0x00ff:
        r7 = r1.kO;
        r1 = r1.kH;
        r1 = r1.kE;
        if (r7 != r1) goto L_0x0126;
    L_0x0107:
        r1 = r4;
    L_0x0108:
        if (r1 != 0) goto L_0x00c4;
    L_0x010a:
        r1 = r11.jL;
        r1.j(r2, r3);
        r1 = r11.jL;
        r2 = r1.kI;
        r1.kM = r2;
        r2 = r1.kJ;
        r1.kN = r2;
        r2 = r1.kH;
        r2 = r2.kE;
        r1.kO = r2;
        r2 = r1.kK;
        r1.kP = r2;
        r1.kQ = r5;
        goto L_0x00c4;
    L_0x0126:
        r1 = r5;
        goto L_0x0108;
    L_0x0128:
        r1 = r5;
        goto L_0x00d1;
    L_0x012a:
        r1 = r2.kR;
        if (r1 != 0) goto L_0x013a;
    L_0x012e:
        r1 = new android.graphics.Paint;
        r1.<init>();
        r2.kR = r1;
        r1 = r2.kR;
        r1.setFilterBitmap(r4);
    L_0x013a:
        r1 = r2.kR;
        r4 = r2.kH;
        r4 = r4.kE;
        r1.setAlpha(r4);
        r1 = r2.kR;
        r1.setColorFilter(r0);
        r0 = r2.kR;
        goto L_0x00d6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.a.a.f.draw(android.graphics.Canvas):void");
    }

    public final int getAlpha() {
        if (this.jJ != null) {
            return android.support.v4.b.a.a.d(this.jJ);
        }
        return this.jL.kH.kE;
    }

    public final void setAlpha(int i) {
        if (this.jJ != null) {
            this.jJ.setAlpha(i);
        } else if (this.jL.kH.kE != i) {
            this.jL.kH.kE = i;
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.jJ != null) {
            this.jJ.setColorFilter(colorFilter);
            return;
        }
        this.jN = colorFilter;
        invalidateSelf();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i) {
        if (this.jJ != null) {
            android.support.v4.b.a.a.a(this.jJ, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.jJ != null) {
            android.support.v4.b.a.a.a(this.jJ, colorStateList);
            return;
        }
        f fVar = this.jL;
        if (fVar.kI != colorStateList) {
            fVar.kI = colorStateList;
            this.jM = a(colorStateList, fVar.kJ);
            invalidateSelf();
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.jJ != null) {
            android.support.v4.b.a.a.a(this.jJ, mode);
            return;
        }
        f fVar = this.jL;
        if (fVar.kJ != mode) {
            fVar.kJ = mode;
            this.jM = a(fVar.kI, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.jJ != null) {
            return this.jJ.isStateful();
        }
        return super.isStateful() || !(this.jL == null || this.jL.kI == null || !this.jL.kI.isStateful());
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.jJ != null) {
            return this.jJ.setState(iArr);
        }
        f fVar = this.jL;
        if (fVar.kI == null || fVar.kJ == null) {
            return false;
        }
        this.jM = a(fVar.kI, fVar.kJ);
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.jJ != null) {
            return this.jJ.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.jJ != null) {
            return this.jJ.getIntrinsicWidth();
        }
        return (int) this.jL.kH.kA;
    }

    public final int getIntrinsicHeight() {
        if (this.jJ != null) {
            return this.jJ.getIntrinsicHeight();
        }
        return (int) this.jL.kH.kB;
    }

    public final boolean canApplyTheme() {
        if (this.jJ != null) {
            android.support.v4.b.a.a.e(this.jJ);
        }
        return false;
    }

    public static f a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            f fVar = new f();
            fVar.jJ = VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
            fVar.jQ = new g(fVar.jJ.getConstantState());
            return fVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (XmlPullParserException e) {
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    public static f a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.jJ != null) {
            this.jJ.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.jJ != null) {
            android.support.v4.b.a.a.a(this.jJ, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.jL;
        fVar.kH = new e();
        TypedArray a = e.a(resources, theme, attributeSet, a.jq);
        f fVar2 = this.jL;
        e eVar = fVar2.kH;
        int a2 = d.a(a, xmlPullParser, "tintMode", 6);
        Mode mode = Mode.SRC_IN;
        switch (a2) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            case 16:
                mode = Mode.ADD;
                break;
        }
        fVar2.kJ = mode;
        ColorStateList colorStateList = a.getColorStateList(1);
        if (colorStateList != null) {
            fVar2.kI = colorStateList;
        }
        boolean z = fVar2.kK;
        if (d.a(xmlPullParser, "autoMirrored")) {
            z = a.getBoolean(5, z);
        }
        fVar2.kK = z;
        eVar.kC = d.a(a, xmlPullParser, "viewportWidth", 7, eVar.kC);
        eVar.kD = d.a(a, xmlPullParser, "viewportHeight", 8, eVar.kD);
        if (eVar.kC <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.kD <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.kA = a.getDimension(3, eVar.kA);
            eVar.kB = a.getDimension(2, eVar.kB);
            if (eVar.kA <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.kB <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.kE = (int) (d.a(a, xmlPullParser, "alpha", 4, ((float) eVar.kE) / 255.0f) * 255.0f);
                String string = a.getString(0);
                if (string != null) {
                    eVar.kF = string;
                    eVar.kG.put(string, eVar);
                }
                a.recycle();
                fVar.jA = getChangingConfigurations();
                fVar.kQ = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.jM = a(fVar.kI, fVar.kJ);
            }
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = this.jL;
        e eVar = fVar.kH;
        int i = 1;
        Stack stack = new Stack();
        stack.push(eVar.kz);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i2 = eventType;
            if (i2 == 1) {
                break;
            }
            if (i2 == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) stack.peek();
                TypedArray a;
                if ("path".equals(name)) {
                    d bVar = new b();
                    TypedArray a2 = e.a(resources, theme, attributeSet, a.js);
                    bVar.a(a2, xmlPullParser);
                    a2.recycle();
                    cVar.ki.add(bVar);
                    if (bVar.kr != null) {
                        eVar.kG.put(bVar.kr, bVar);
                    }
                    eventType = 0;
                    i = bVar.jA | fVar.jA;
                    fVar.jA = i;
                } else if ("clip-path".equals(name)) {
                    d aVar = new a();
                    if (d.a(xmlPullParser, "pathData")) {
                        a = e.a(resources, theme, attributeSet, a.jt);
                        aVar.a(a);
                        a.recycle();
                    }
                    cVar.ki.add(aVar);
                    if (aVar.kr != null) {
                        eVar.kG.put(aVar.kr, aVar);
                    }
                    fVar.jA |= aVar.jA;
                    eventType = i;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        a = e.a(resources, theme, attributeSet, a.jr);
                        cVar2.jU = null;
                        cVar2.kj = d.a(a, xmlPullParser, "rotation", 5, cVar2.kj);
                        cVar2.kk = a.getFloat(1, cVar2.kk);
                        cVar2.kl = a.getFloat(2, cVar2.kl);
                        cVar2.mScaleX = d.a(a, xmlPullParser, "scaleX", 3, cVar2.mScaleX);
                        cVar2.mScaleY = d.a(a, xmlPullParser, "scaleY", 4, cVar2.mScaleY);
                        cVar2.km = d.a(a, xmlPullParser, "translateX", 6, cVar2.km);
                        cVar2.kn = d.a(a, xmlPullParser, "translateY", 7, cVar2.kn);
                        String string = a.getString(0);
                        if (string != null) {
                            cVar2.kp = string;
                        }
                        cVar2.ko.reset();
                        cVar2.ko.postTranslate(-cVar2.kk, -cVar2.kl);
                        cVar2.ko.postScale(cVar2.mScaleX, cVar2.mScaleY);
                        cVar2.ko.postRotate(cVar2.kj, 0.0f, 0.0f);
                        cVar2.ko.postTranslate(cVar2.km + cVar2.kk, cVar2.kn + cVar2.kl);
                        a.recycle();
                        cVar.ki.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.kp != null) {
                            eVar.kG.put(cVar2.kp, cVar2);
                        }
                        fVar.jA |= cVar2.jA;
                    }
                    eventType = i;
                }
            } else {
                if (i2 == 3) {
                    if ("group".equals(xmlPullParser.getName())) {
                        stack.pop();
                    }
                }
                eventType = i;
            }
            i2 = xmlPullParser.next();
        }
        if (i != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.jJ != null) {
            this.jJ.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.jJ != null) {
            return this.jJ.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.jL.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.jJ != null) {
            this.jJ.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.jJ != null) {
            this.jJ.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.jJ != null) {
            return this.jJ.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.jJ != null) {
            this.jJ.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
