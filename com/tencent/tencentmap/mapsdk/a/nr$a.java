package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.tencentmap.mapsdk.a.nr.b;

class nr$a {
    final /* synthetic */ nr a;
    private oq b = null;
    private int c = 0;
    private iy d = null;
    private Bitmap[] e = new Bitmap[4];

    public nr$a(nr nrVar, oq oqVar, int i) {
        this.a = nrVar;
        this.b = oqVar;
        this.c = i;
        f();
        e();
    }

    public int a() {
        return this.c;
    }

    public boolean b() {
        return this.b.k();
    }

    public int c() {
        if (this.b == null) {
            return 0;
        }
        return this.b.h();
    }

    public iy d() {
        return this.d;
    }

    public iy a(hh hhVar, b bVar) {
        pa a = this.b.a();
        ox g = this.b.g();
        if (g == null) {
            g = a.i();
        }
        if (g == null) {
            return null;
        }
        int a2;
        int b;
        int i;
        float u;
        float v;
        double d;
        double d2;
        DoublePoint b2 = hhVar.b(nr.a(this.a, g));
        if (a != null) {
            a2 = a.a(nr.a(this.a));
            b = a.b(nr.a(this.a));
            i = a2;
        } else {
            a2 = this.b.b();
            b = this.b.c();
            i = a2;
        }
        if (a != null) {
            u = a.u();
            v = a.v();
        } else {
            u = this.b.d();
            v = this.b.e();
        }
        if (u >= 0.0f && u <= 1.0f) {
            b2.x -= (((double) u) - 0.5d) * ((double) i);
        }
        if (v >= 0.0f && v <= 1.0f) {
            b2.y -= (((double) v) - 0.5d) * ((double) b);
        }
        Bitmap bitmap = this.e[bVar.ordinal()];
        int width = bitmap.getWidth() / 2;
        a2 = (bitmap.getHeight() / 2) + (b / 2);
        if (bVar == b.a) {
            d = b2.x - ((double) width);
            d2 = b2.y - ((double) a2);
        } else if (bVar == b.b) {
            d = b2.x + ((double) width);
            d2 = b2.y - ((double) a2);
        } else if (bVar == b.c) {
            d = b2.x + ((double) width);
            d2 = ((double) a2) + b2.y;
        } else {
            d = b2.x - ((double) width);
            d2 = ((double) a2) + b2.y;
        }
        this.d.a(hhVar.a(new DoublePoint(d, d2)));
        this.d.a(a(bVar), new Bitmap[]{bitmap});
        return this.d;
    }

    private void e() {
        if (this.b != null) {
            this.d = new iy(new iz().a(0.5f, 0.5f).a(a(b.a), new Bitmap[]{this.e[0]}));
        }
    }

    private void f() {
        this.e[0] = a(nr.a(this.a), b.a);
        this.e[1] = a(nr.a(this.a), b.b);
        this.e[2] = a(nr.a(this.a), b.c);
        this.e[3] = a(nr.a(this.a), b.d);
    }

    private Bitmap a(Context context, b bVar) {
        View b = b(context, bVar);
        b.measure(0, 0);
        int measuredWidth = b.getMeasuredWidth();
        int measuredHeight = b.getMeasuredHeight();
        b.layout(0, 0, measuredWidth, measuredHeight);
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
        createBitmap.eraseColor(0);
        b.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private String a(b bVar) {
        String obj = toString();
        if (bVar == b.a) {
            return "b_lt_" + obj;
        }
        if (bVar == b.b) {
            return "b_rt_" + obj;
        }
        if (bVar == b.c) {
            return "b_rb_" + obj;
        }
        return "b_lb_" + obj;
    }

    private View b(Context context, b bVar) {
        Drawable[] j = this.b.j();
        if (j == null || j.length < 4) {
            j = nr.b(this.a);
        }
        View i = this.b.i();
        if (i == null) {
            i = a(context);
        }
        i.setBackgroundDrawable(j[bVar.ordinal()]);
        return i;
    }

    private View a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        View textView = new TextView(context);
        textView.setGravity(17);
        textView.setPadding(30, 30, 30, 30);
        textView.setId(100);
        textView.setTextSize(14.0f);
        textView.setTextColor(-16777216);
        textView.setText(this.b.f());
        linearLayout.addView(textView, new LayoutParams(-2, -2));
        return textView;
    }
}
