package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import com.tencent.tencentmap.mapsdk.a.tc.a;

public final class tb extends View {
    private sl a;
    private Bitmap b;
    private Paint c = new Paint();
    private int d = 0;
    private int e = 10;
    private int f = 10;
    private final float g;

    public tb(sl slVar) {
        super(sl.a());
        this.a = slVar;
        this.g = 80.0f * slVar.f().b();
        this.c.setAntiAlias(true);
        this.c.setColor(-16777216);
        this.c.setStyle(Style.STROKE);
    }

    public final void a() {
        if (this.b != null) {
            this.b.recycle();
        }
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap a = sz.a(bitmap, (float) (((double) this.a.f().b()) * 0.6d));
            if (a != null) {
                if (((float) a.getWidth()) < this.g) {
                    a = sz.a(a, this.g / ((float) a.getWidth()));
                }
                this.b = a;
                setVisibility(0);
                invalidate();
                return;
            }
            return;
        }
        setVisibility(0);
    }

    public final void onDraw(Canvas canvas) {
        if (this.b != null) {
            int width = this.b.getWidth() + 3;
            int height = this.b.getHeight() + 3;
            switch (this.d) {
                case 0:
                    this.e = 10;
                    this.f = this.a.c().getHeight() - height;
                    break;
                case 1:
                    this.e = this.a.c().getWidth() - width;
                    this.f = this.a.c().getHeight() - height;
                    break;
                case 2:
                    this.e = this.a.c().getWidth() - width;
                    this.f = 10;
                    break;
                case 3:
                    this.e = 10;
                    this.f = 10;
                    break;
                case 4:
                    this.e = (this.a.c().getWidth() - width) / 2;
                    this.f = this.a.c().getHeight() - height;
                    break;
                default:
                    this.e = (this.a.c().getWidth() - width) / 2;
                    this.f = 10;
                    break;
            }
            if (this.a.f().c() == a.b) {
                this.f -= 2;
            } else {
                this.f -= 8;
            }
            new StringBuilder("left:").append(this.e).append(", top:").append(this.f);
            canvas.drawBitmap(this.b, (float) (this.e - 5), (float) this.f, this.c);
        }
    }
}
