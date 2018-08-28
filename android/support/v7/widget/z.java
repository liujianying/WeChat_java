package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.RecyclerView.p.a;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

public abstract class z extends p {
    protected final DecelerateInterpolator BS = new DecelerateInterpolator();
    protected final LinearInterpolator PD = new LinearInterpolator();
    protected PointF PE;
    private final float PF;
    protected int PG = 0;
    protected int PH = 0;

    public abstract PointF bf(int i);

    public z(Context context) {
        this.PF = a(context.getResources().getDisplayMetrics());
    }

    protected final void a(View view, a aVar) {
        LayoutParams layoutParams;
        int i = 0;
        int fm = fm();
        h hVar = this.QG;
        if (hVar == null || !hVar.eZ()) {
            fm = 0;
        } else {
            layoutParams = (LayoutParams) view.getLayoutParams();
            fm = e(h.bh(view) - layoutParams.leftMargin, layoutParams.rightMargin + h.bj(view), hVar.getPaddingLeft(), hVar.mWidth - hVar.getPaddingRight(), fm);
        }
        int fn = fn();
        h hVar2 = this.QG;
        if (hVar2 != null && hVar2.fa()) {
            layoutParams = (LayoutParams) view.getLayoutParams();
            i = e(h.bi(view) - layoutParams.topMargin, layoutParams.bottomMargin + h.bk(view), hVar2.getPaddingTop(), hVar2.mHeight - hVar2.getPaddingBottom(), fn);
        }
        int ceil = (int) Math.ceil(((double) bi((int) Math.sqrt((double) ((fm * fm) + (i * i))))) / 0.3356d);
        if (ceil > 0) {
            aVar.a(-fm, -i, ceil, this.BS);
        }
    }

    protected final void a(int i, int i2, a aVar) {
        if (this.Sa.QV.getChildCount() == 0) {
            stop();
            return;
        }
        this.PG = R(this.PG, i);
        this.PH = R(this.PH, i2);
        if (this.PG == 0 && this.PH == 0) {
            PointF bf = bf(this.Sv);
            if (bf == null || (bf.x == 0.0f && bf.y == 0.0f)) {
                aVar.SC = this.Sv;
                stop();
                return;
            }
            double sqrt = Math.sqrt((double) ((bf.x * bf.x) + (bf.y * bf.y)));
            bf.x = (float) (((double) bf.x) / sqrt);
            bf.y = (float) (((double) bf.y) / sqrt);
            this.PE = bf;
            this.PG = (int) (bf.x * 10000.0f);
            this.PH = (int) (bf.y * 10000.0f);
            aVar.a((int) (((float) this.PG) * 1.2f), (int) (((float) this.PH) * 1.2f), (int) (((float) bi(10000)) * 1.2f), this.PD);
        }
    }

    protected final void onStop() {
        this.PH = 0;
        this.PG = 0;
        this.PE = null;
    }

    public float a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int bi(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.PF));
    }

    public int fm() {
        if (this.PE == null || this.PE.x == 0.0f) {
            return 0;
        }
        return this.PE.x > 0.0f ? 1 : -1;
    }

    public int fn() {
        if (this.PE == null || this.PE.y == 0.0f) {
            return 0;
        }
        return this.PE.y > 0.0f ? 1 : -1;
    }

    private static int R(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    private static int e(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }
}
