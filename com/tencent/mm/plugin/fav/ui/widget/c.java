package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c extends LinearLayout {
    private View jfo;
    public View jfp;
    public View jfq;
    private a jfr;
    private boolean jfs = false;
    private boolean jft = false;
    private int jfu;

    public interface a {
        void aMx();
    }

    public c(Context context) {
        super(context);
        setOrientation(1);
        MarginLayoutParams layoutParams = new LayoutParams(-1, -2);
        this.jfo = View.inflate(getContext(), f.fav_oldversion_bar, null);
        View inflate = View.inflate(getContext(), f.fav_full_bar, null);
        inflate.findViewById(e.oldversion_container).setOnClickListener(new 1(this));
        this.jfp = inflate;
        inflate = View.inflate(getContext(), f.fav_netwarn_bar, null);
        inflate.findViewById(e.fav_warn_retry_btn).setOnClickListener(new 2(this));
        this.jfq = inflate;
        addView(this.jfo, new LayoutParams(layoutParams));
        addView(this.jfp, new LayoutParams(layoutParams));
        addView(this.jfq, new LayoutParams(layoutParams));
    }

    public final void eX(boolean z) {
        this.jfo.setVisibility(z ? 0 : 8);
    }

    private void pR(int i) {
        this.jfu = i;
        x.i("MicroMsg.FavHeaderView", "showStatusBar status:" + i);
        if (i == 0) {
            this.jfq.setVisibility(8);
            this.jfp.setVisibility(8);
        } else if (i == 1) {
            if (!this.jfs) {
                h.mEJ.h(14109, new Object[]{Integer.valueOf(1)});
            }
            this.jfs = true;
            this.jfq.setVisibility(8);
            this.jfp.setVisibility(0);
            this.jfp.findViewById(e.oldversion_title_full).setVisibility(0);
            this.jfp.findViewById(e.oldversion_title_support).setVisibility(8);
        } else if (i == 2) {
            this.jfq.setVisibility(0);
            this.jfp.setVisibility(8);
        } else if (i == 3) {
            if (!this.jft) {
                h.mEJ.h(14109, new Object[]{Integer.valueOf(0)});
            }
            this.jft = true;
            this.jfq.setVisibility(8);
            this.jfp.setVisibility(0);
            this.jfp.findViewById(e.oldversion_title_full).setVisibility(8);
            this.jfp.findViewById(e.oldversion_title_support).setVisibility(0);
        }
    }

    public final void aMS() {
        long j;
        int i;
        List<g> aLF = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLF();
        if (aLF != null) {
            j = 0;
            i = 0;
            for (g a : aLF) {
                j = b.a(a) + j;
                i = 1;
            }
            x.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[]{Integer.valueOf(aLF.size()), Long.valueOf(j)});
        } else {
            j = 0;
            i = 0;
        }
        if (i != 0) {
            if (j > b.aKR()) {
                pR(1);
            } else {
                pR(2);
            }
        } else if (b.aKU()) {
            pR(3);
        } else {
            pR(0);
        }
    }

    public final void setCleanFavSpace(a aVar) {
        this.jfr = aVar;
    }
}
