package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.text.SpannableString;
import android.widget.RadioGroup;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.widget.a.c.a;

public class e$a {
    public c eIW;
    public Context mContext;
    public final a qIF;
    public String uKt = null;
    public String uKu = null;
    public boolean uKv = false;
    public boolean uKw = false;
    private RadioGroup uKx;

    public e$a(Context context) {
        this.mContext = context;
        this.qIF = new a(this.mContext);
        this.qIF.mF(false);
        this.qIF.mG(false);
        this.qIF.a(new 1(this));
    }

    public final e$a abz(String str) {
        int fromDPToPix = ap.fromDPToPix(this.mContext, (int) (20.0f * ap.fe(this.mContext)));
        if (str != null && str.length() > 0) {
            this.qIF.R((SpannableString) b.c(str.toString(), fromDPToPix));
        }
        this.qIF.abt(str);
        return this;
    }

    public final e$a abA(String str) {
        this.qIF.abu(str);
        return this;
    }

    public final e$a Gv(int i) {
        this.uKt = this.mContext.getResources().getString(i);
        return this;
    }

    public final e$a a(e$b e_b, e$b e_b2) {
        this.eIW = this.qIF.anj();
        if (this.uKx != null) {
            this.uKx.setTag(this.eIW);
        }
        e.a(this.mContext, this.eIW, this.uKt, this.uKu, this.uKw, e_b2, e_b);
        if (this.uKv) {
            this.eIW.Gp(this.mContext.getResources().getColor(c.green_text_color));
        }
        return this;
    }

    public final e$a a(e$b e_b) {
        this.eIW = this.qIF.anj();
        if (this.uKx != null) {
            this.uKx.setTag(this.eIW);
        }
        e.a(this.mContext, this.eIW, this.uKt, this.uKu, this.uKw, e_b, e_b);
        return this;
    }
}
