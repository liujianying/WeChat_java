package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends b {
    private TextView eCm;
    private View gYR = null;
    private ImageView gmn;
    private boolean usL = false;
    boolean usX = false;
    private c usY;

    public o(Context context) {
        super(context);
        if (!this.usL && this.view != null) {
            this.gYR = this.view.findViewById(R.h.tniview);
            this.eCm = (TextView) this.view.findViewById(R.h.tni_detail);
            this.gmn = (ImageView) this.view.findViewById(R.h.tni_icon);
            this.usL = true;
            this.usY = new 1(this);
            a.sFg.b(this.usY);
        }
    }

    public final int getLayoutId() {
        return R.i.try_newinit_banner;
    }

    public final boolean anR() {
        if (!this.usX) {
            x.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[]{Boolean.valueOf(this.usX)});
            this.gYR.setVisibility(8);
            return false;
        } else if (l.PJ()) {
            boolean z;
            this.eCm.setText(R.l.banner_new_init_retry);
            this.gmn.setVisibility(0);
            this.gYR.setOnClickListener(new 2(this));
            this.gYR.setVisibility(0);
            String str = "MicroMsg.TryNewInitBanner";
            String str2 = "summerinit update set visible [%b]";
            Object[] objArr = new Object[1];
            if (this.gYR.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            return true;
        } else {
            x.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
            this.usX = false;
            this.gYR.setVisibility(8);
            return false;
        }
    }

    public final void setVisibility(int i) {
        if (this.gYR != null) {
            this.gYR.setVisibility(i);
        }
    }

    public final void destroy() {
        a.sFg.c(this.usY);
    }
}
