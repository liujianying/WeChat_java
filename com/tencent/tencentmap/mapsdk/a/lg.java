package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Base64;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.lib.d;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import com.tencent.tencentmap.mapsdk.a.ld.b;

public class lg implements ld {
    private final int[] A = new int[]{2000000, 1000000, 500000, 200000, 100000, 50000, 20000, 10000, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, 2000, 1000, 500, 200, 100, 50, 20, 10, 5};
    private String B = "50m";
    private Paint C;
    private Paint D;
    private int E = 11;
    private int F = 109;
    private float G = 1.0f;
    private int H;
    private double I;
    private b J;
    private boolean K = true;
    private LinearLayout L;
    private LinearLayout M;
    private final int N;
    private final int O;
    private lo P;
    private boolean Q = false;
    private Context a;
    private ImageView b;
    private Bitmap c;
    private Bitmap d;
    private a e = a.b;
    private b f = b.c;
    private b g = b.a;
    private boolean h = true;
    private ViewGroup i;
    private float[] j = new float[]{-1.0f, -1.0f, -1.0f, -1.0f};
    private int[] k = new int[]{-1, -1, -1, -1};
    private int[] l = new int[]{-1, -1, -1, -1};
    private int[] m = new int[ld$a.values().length];
    private int[] n = new int[ld$a.values().length];
    private float[] o = new float[]{0.02f, 0.02f, 0.012f, 0.012f};
    private float[] p = new float[]{0.022f, 0.022f, 0.0125f, 0.0125f};
    private float[] q = new float[]{0.0185f, 0.0185f, 0.0104f, 0.0104f};
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private boolean x = false;
    private TextView y;
    private int z = 0;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.lg$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[b.values().length];

        static {
            try {
                a[b.a.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[b.b.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[b.c.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[b.d.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[b.e.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[b.f.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public lg(Context context, int i, int i2, lo loVar) {
        this.a = context;
        this.N = i;
        this.O = i2;
        this.P = loVar;
        this.b = new ImageView(context);
        a(e());
        this.J = new b(this, this.a);
        this.y = new TextView(this.a);
        this.y.setText(this.B);
        this.y.setTextSize(12.0f);
        this.y.setTextColor(-16777216);
        this.y.setGravity(1);
        this.G = context.getResources().getDisplayMetrics().density;
        if (this.G <= 0.0f) {
            this.G = 1.0f;
        }
        this.C = new Paint();
        this.C.setAntiAlias(true);
        this.C.setColor(-16777216);
        this.C.setStrokeWidth(this.G * 1.0f);
        this.C.setStyle(Style.STROKE);
        this.D = new Paint(65);
        this.D.setStyle(Style.FILL);
        this.D.setColor(0);
        this.L = new LinearLayout(this.a);
        this.L.setOrientation(1);
        this.L.setGravity(16);
        this.M = new LinearLayout(this.a);
        this.M.setOrientation(1);
        this.M.setGravity(16);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.M.addView(this.y, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.M.addView(this.J, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.L.addView(this.b, layoutParams);
    }

    public boolean a(ViewGroup viewGroup) {
        int i = 0;
        if (viewGroup == null) {
            return false;
        }
        if (this.x) {
            this.x = false;
            q.a(this.d);
            int[] c = c(this.v, this.w);
            this.d = jz.a(this.c, this.a, c[0], c[1]);
            this.b.setImageBitmap(this.d);
        }
        this.i = viewGroup;
        LayoutParams f = f();
        if (viewGroup.indexOfChild(this.L) < 0) {
            viewGroup.addView(this.L, f);
        } else {
            viewGroup.updateViewLayout(this.L, f);
        }
        f = g();
        if (viewGroup.indexOfChild(this.M) < 0) {
            viewGroup.addView(this.M, f);
        } else {
            viewGroup.updateViewLayout(this.M, f);
        }
        if (!(this.y == null || this.J == null)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            this.J.measure(0, 0);
            this.y.measure(0, 0);
            layoutParams.leftMargin = (int) (((((float) this.F) + (6.0f * this.G)) - ((float) this.y.getWidth())) / 2.0f);
            this.M.updateViewLayout(this.y, layoutParams);
            this.M.updateViewLayout(this.J, this.J.getLayoutParams());
        }
        this.b.setVisibility(this.h ? 0 : 4);
        LinearLayout linearLayout = this.M;
        if (!this.K) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        viewGroup.requestLayout();
        return true;
    }

    private void d() {
        a(this.i);
    }

    public void a(a aVar) {
        if (this.e != aVar || this.P.a) {
            this.e = aVar;
            q.a(this.c);
            this.c = e();
            this.d = jz.a(this.c, this.a, this.v, this.w);
            this.b.setImageBitmap(this.d);
            if (this.P.a) {
                this.P.a = false;
            }
        }
    }

    private void a(Bitmap bitmap) {
        this.c = bitmap;
        if (this.c != null) {
            this.t = this.c.getWidth();
            this.u = this.c.getHeight();
            this.v = (int) (((double) (((float) this.t) * this.G)) * 0.3d);
            this.w = (int) (((double) (((float) this.u) * this.G)) * 0.3d);
            this.d = jz.a(this.c, this.a, this.v, this.w);
        }
        this.b.setImageBitmap(this.d);
    }

    private Bitmap e() {
        Bitmap bitmap = null;
        byte[] decode;
        if (this.e == a.b) {
            decode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAPYAAABaCAYAAACLzKtdAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA2ZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTM4IDc5LjE1OTgyNCwgMjAxNi8wOS8xNC0wMTowOTowMSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDowRDE2MUNEMzcwQUVFMzExOThDRkI0RTA2Q0E4MEI1MSIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDowMzM4M0MwNUQ3NTQxMUU3QUUzQkI4QTJGNTE1NUZFRiIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDowMzM4M0MwNEQ3NTQxMUU3QUUzQkI4QTJGNTE1NUZFRiIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M1LjEgV2luZG93cyI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjJCQTBGRTA3OUQxMzExRTdCQTYwODFFOTA4QTkzMERDIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOjJCQTBGRTA4OUQxMzExRTdCQTYwODFFOTA4QTkzMERDIi8+IDwvcmRmOkRlc2NyaXB0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", 3);
            try {
                bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } catch (Exception e) {
            }
            return bitmap == null ? kh.b(this.a, "logo.png") : bitmap;
        } else if (this.e != a.a) {
            return bitmap;
        } else {
            Bitmap bitmap2;
            decode = kh.d(this.a, "world_map_logo_" + this.P.c().a() + ".png");
            if (decode == null) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            }
            if (bitmap2 != null) {
                return bitmap2;
            }
            if ("bingmap".equals(this.P.c().a())) {
                return kh.b(this.a, "logo_bing.png");
            }
            if ("googlemap".equals(this.P.c().a())) {
                return kh.b(this.a, "logo_google.png");
            }
            return bitmap;
        }
    }

    public void a(int i, int i2) {
        this.r = i;
        this.s = i2;
        h();
        i();
    }

    public void a() {
        q.a(this.c);
        q.a(this.d);
    }

    public void a(b bVar) {
        if (this.f != bVar) {
            d();
        }
        this.f = bVar;
    }

    public void b(b bVar) {
        if (this.g != bVar) {
            d();
        }
        this.g = bVar;
    }

    private FrameLayout.LayoutParams f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        switch (AnonymousClass1.a[this.f.ordinal()]) {
            case 1:
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = this.m[ld$a.BOTTOM.e];
                layoutParams.leftMargin = this.m[ld$a.LEFT.e];
                break;
            case 2:
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = this.m[ld$a.BOTTOM.e];
                break;
            case 3:
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = this.m[ld$a.BOTTOM.e];
                layoutParams.rightMargin = this.m[ld$a.RIGHT.e];
                break;
            case 4:
                layoutParams.gravity = 51;
                layoutParams.topMargin = this.m[ld$a.TOP.e];
                layoutParams.leftMargin = this.m[ld$a.LEFT.e];
                break;
            case 5:
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.m[ld$a.TOP.e];
                break;
            case 6:
                layoutParams.gravity = 53;
                layoutParams.topMargin = this.m[ld$a.TOP.e];
                layoutParams.rightMargin = this.m[ld$a.RIGHT.e];
                break;
            default:
                d.b("Unknown position:" + this.f);
                break;
        }
        return layoutParams;
    }

    private FrameLayout.LayoutParams g() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        switch (AnonymousClass1.a[this.g.ordinal()]) {
            case 1:
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = this.n[ld$a.BOTTOM.e];
                layoutParams.leftMargin = this.n[ld$a.LEFT.e];
                break;
            case 2:
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = this.n[ld$a.BOTTOM.e];
                break;
            case 3:
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = this.n[ld$a.BOTTOM.e];
                layoutParams.rightMargin = this.n[ld$a.RIGHT.e];
                break;
            case 4:
                layoutParams.gravity = 51;
                layoutParams.topMargin = this.n[ld$a.TOP.e];
                layoutParams.leftMargin = this.n[ld$a.LEFT.e];
                break;
            case 5:
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.n[ld$a.TOP.e];
                break;
            case 6:
                layoutParams.gravity = 53;
                layoutParams.topMargin = this.n[ld$a.TOP.e];
                layoutParams.rightMargin = this.n[ld$a.RIGHT.e];
                break;
            default:
                d.b("Unknown positionScale:" + this.g);
                break;
        }
        return layoutParams;
    }

    private void h() {
        if (this.r != 0 && this.s != 0) {
            float[] fArr = this.o;
            if (this.r >= 1080) {
                fArr = this.q;
            } else if (this.r >= 720) {
                fArr = this.p;
            }
            int i = ld$a.LEFT.e;
            float f = fArr[i];
            if (this.j[i] >= 0.0f) {
                f = this.j[i];
            }
            this.m[i] = (int) (f * ((float) this.r));
            this.v = (int) (((double) (((float) this.t) * this.G)) * 0.3d);
            this.w = (int) (((double) (((float) this.u) * this.G)) * 0.3d);
            if (!this.Q) {
                this.l[ld$a.BOTTOM.e] = this.w;
                this.Q = true;
            }
            if (this.k[i] >= 0 && this.k[i] < this.r - this.v) {
                this.m[i] = this.k[i];
            }
            i = ld$a.RIGHT.e;
            f = fArr[i];
            if (this.j[i] >= 0.0f) {
                f = this.j[i];
            }
            this.m[i] = (int) (f * ((float) this.r));
            if (this.k[i] >= 0 && this.k[i] < this.r - this.v) {
                this.m[i] = this.k[i];
            }
            i = ld$a.BOTTOM.e;
            f = fArr[i];
            if (this.j[i] >= 0.0f) {
                f = this.j[i];
            }
            this.m[i] = (int) (f * ((float) this.s));
            if (this.k[i] >= 0 && this.k[i] < this.s - this.w) {
                this.m[i] = this.k[i];
            }
            int i2 = ld$a.TOP.e;
            float f2 = fArr[i2];
            if (this.j[i2] >= 0.0f) {
                f2 = this.j[i2];
            }
            this.m[i2] = (int) (f2 * ((float) this.s));
            if (this.k[i2] >= 0 && this.k[i2] < this.s - this.w) {
                this.m[i2] = this.k[i2];
            }
            this.x = true;
            d();
        }
    }

    private void i() {
        if (this.r != 0 && this.s != 0) {
            this.M.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = this.M.getMeasuredHeight();
            int measuredWidth = this.M.getMeasuredWidth();
            float[] fArr = this.o;
            if (this.r >= 1080) {
                fArr = this.q;
            } else if (this.r >= 720) {
                fArr = this.p;
            }
            int i = ld$a.LEFT.e;
            float f = fArr[i];
            if (this.j[i] >= 0.0f) {
                f = this.j[i];
            }
            this.n[i] = (int) (f * ((float) this.r));
            if (this.l[i] >= 0 && this.l[i] < this.r - measuredWidth) {
                this.n[i] = this.l[i];
            }
            i = ld$a.RIGHT.e;
            f = fArr[i];
            if (this.j[i] >= 0.0f) {
                f = this.j[i];
            }
            this.n[i] = (int) (f * ((float) this.r));
            if (this.l[i] >= 0 && this.l[i] < this.r - measuredWidth) {
                this.n[i] = this.l[i];
            }
            measuredWidth = ld$a.BOTTOM.e;
            f = fArr[measuredWidth];
            if (this.j[measuredWidth] >= 0.0f) {
                f = this.j[measuredWidth];
            }
            this.n[measuredWidth] = (int) (f * ((float) this.s));
            if (this.l[measuredWidth] >= 0 && this.l[measuredWidth] < this.s - measuredHeight) {
                this.n[measuredWidth] = this.l[measuredWidth];
            }
            int i2 = ld$a.TOP.e;
            float f2 = fArr[i2];
            if (this.j[i2] >= 0.0f) {
                f2 = this.j[i2];
            }
            this.n[i2] = (int) (f2 * ((float) this.s));
            if (this.l[i2] >= 0 && this.l[i2] < this.s - measuredHeight) {
                this.n[i2] = this.l[i2];
            }
            d();
        }
    }

    public void a(boolean z) {
        this.K = z;
        if (this.J != null) {
            this.M.setVisibility(z ? 0 : 8);
        }
    }

    public boolean b() {
        return this.K;
    }

    public void c() {
        if (this.J != null) {
            this.J.postInvalidate();
        }
    }

    public void a(int i, double d) {
        this.H = i;
        this.I = d;
        j();
        d();
    }

    private void b(int i, int i2) {
        int length = this.A.length;
        int i3 = this.H - this.N;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 >= length) {
            i3 = length - 1;
        }
        length = this.A[i3];
        float f = (float) i;
        if (this.I != 0.0d) {
            f = (float) (((double) length) / this.I);
        }
        this.F = Math.round(f);
        if (this.F > i2) {
            this.F = i2;
        } else if (this.F < i) {
            this.F = i;
        }
        String str = "m";
        if (length > 2000) {
            i3 = length / 1000;
            str = "km";
        } else {
            i3 = length;
        }
        this.B = i3 + str;
    }

    private void j() {
        int width = this.b.getWidth();
        if (width <= 0) {
            width = 1000;
        }
        b((int) Math.ceil((double) (((float) width) / 4.0f)), (int) (Math.ceil((double) ((((float) this.r) * 3.0f) / 8.0f)) - ((double) (6.0f * this.G))));
        this.y.setText(this.B);
    }

    private void a(Canvas canvas, int i) {
        int i2 = (int) (6.0f * this.G);
        int i3 = i / 2;
        canvas.drawPaint(this.D);
        d.b("drawScaleRuler,scaleViewWidth:" + this.F);
        canvas.drawLine((float) i2, (float) i3, (float) (this.F + i2), (float) i3, this.C);
        canvas.drawLine((float) i2, ((float) i3) - (this.G * 3.0f), (float) i2, (float) (i3 + 1), this.C);
        canvas.drawLine((float) (this.F + i2), ((float) i3) - (this.G * 3.0f), (float) (this.F + i2), (float) (i3 + 1), this.C);
    }

    private int[] c(int i, int i2) {
        int[] iArr = new int[2];
        float f = 1.0f;
        switch (this.z) {
            case -3:
                f = 0.7f;
                break;
            case -2:
                f = 0.8f;
                break;
            case -1:
                f = 0.8333333f;
                break;
            case 1:
                f = 1.2f;
                break;
        }
        iArr[0] = (int) (((float) i) * f);
        iArr[1] = (int) (f * ((float) i2));
        return iArr;
    }
}
