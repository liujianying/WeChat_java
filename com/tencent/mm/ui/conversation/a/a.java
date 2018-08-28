package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    int abQ = 0;
    private View gYR = null;
    b urI;
    private d urJ;
    a urK;

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.gYR = this.view.findViewById(R.h.adlist);
            this.urJ = new d();
            this.urJ.urO = this.gYR;
            this.urJ.urP = (Button) this.view.findViewById(R.h.ad_close);
            this.urJ.urP.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (a.this.urI != null && a.this.urK != null) {
                        a.this.urK.QK(a.this.urI.getItem(a.this.abQ).urN.id);
                    }
                }
            });
            this.gYR.setOnClickListener(new 2(this));
        }
    }

    public final int getLayoutId() {
        return R.i.adlist_item;
    }

    public final void destroy() {
        if (g.Eg().Dx()) {
            au.HU();
            c.DT().b(this.urI);
        }
    }

    public final void setVisibility(int i) {
        if (this.gYR != null) {
            this.gYR.setVisibility(i);
        }
    }

    public final void release() {
        this.urI = null;
    }

    public final boolean anR() {
        this.urI = new b((Context) this.qJS.get());
        this.urK = new 3(this);
        com.tencent.mm.pluginsdk.h.a.a eW = com.tencent.mm.pluginsdk.h.a.a.eW(ad.getContext());
        if (this.urI != null) {
            if (eW != null) {
                this.urI.urM = eW;
                this.urI.WT();
                int i = (this.urI == null || this.urI.getCount() <= 0 || this.urI.getItem(0).a(this.urJ) != 0) ? 0 : 1;
                if (i != 0) {
                    x.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
                    setVisibility(0);
                    return true;
                }
            }
            setVisibility(8);
        }
        setVisibility(8);
        return false;
    }
}
