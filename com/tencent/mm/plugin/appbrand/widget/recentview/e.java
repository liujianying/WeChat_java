package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.p;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k {
    RecyclerView Sa;
    p Sb;
    private int gKM = 0;
    private int gPD;
    p gPE;
    int gPF;
    private int gPG = 0;
    private boolean gPH = false;
    boolean gPI = false;
    int mOffsetX;

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        this.mOffsetX += i;
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        if (i == 0 && this.gPG != 2) {
            int mr = mr(this.mOffsetX);
            if (this.Sa != null && this.gPI) {
                this.Sb.Sv = mr;
                this.Sa.getLayoutManager().a(this.Sb);
            }
            this.gPH = true;
        } else if (!this.gPH && i == 2) {
            this.gPH = true;
        } else if (i == 0) {
            this.gPD = this.mOffsetX;
            this.gPH = false;
            this.gPI = false;
            this.gKM = ((LinearLayoutManager) this.Sa.getLayoutManager()).fi() / this.gPF;
        } else if (i == 1) {
            x.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
            this.gPI = true;
        }
        this.gPG = i;
    }

    final int mr(int i) {
        float width = (float) this.Sa.getWidth();
        if (((float) (i - this.gPD)) >= width / 2.0f) {
            this.gKM = ((LinearLayoutManager) this.Sa.getLayoutManager()).fj() / this.gPF;
        } else if (((float) (i - this.gPD)) <= (-width) / 2.0f) {
            this.gKM = ((LinearLayoutManager) this.Sa.getLayoutManager()).fi() / this.gPF;
        }
        int itemCount = this.Sa.getAdapter().getItemCount() / this.gPF;
        if (this.Sa.getAdapter().getItemCount() % this.gPF != 0) {
            itemCount++;
        }
        this.gKM = Math.max(Math.min(this.gKM, itemCount - 1), -1);
        x.i("ViewPagerHelper", "[getOffsetToPosition] mCurPage:%s pos:%s", new Object[]{Integer.valueOf(this.gKM), Integer.valueOf(this.gKM * this.gPF)});
        return this.gKM * this.gPF;
    }
}
