package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.c.a.b;

public class g$a {
    public c eIW;
    public OnDismissListener gFM;
    Context mContext;
    private final a qIF;
    String qIG = null;

    public g$a(Context context) {
        this.mContext = context;
        this.qIF = new a(this.mContext);
        this.qIF.mF(false);
        this.qIF.mG(false);
        this.qIF.a(new 1(this));
    }

    public final g$a bZ(Object obj) {
        g.b(this.mContext, this.qIF, obj);
        this.qIF.mE(true);
        return this;
    }

    public final g$a cdO() {
        this.qIF.uJP.uJi = 2;
        return this;
    }

    public final g$a TH(String str) {
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this.mContext, (int) (14.0f * com.tencent.mm.bp.a.fe(this.mContext)));
        if (!bi.oW(str)) {
            this.qIF.S(((com.tencent.mm.plugin.emoji.b.a) g.l(com.tencent.mm.plugin.emoji.b.a.class)).a(str.toString(), (float) fromDPToPix));
        }
        return this;
    }

    public final g$a TI(String str) {
        this.qIF.abv(str);
        return this;
    }

    public final g$a cdP() {
        this.qIF.uJP.uJl = 8;
        return this;
    }

    public final g$a c(Bitmap bitmap, int i) {
        this.qIF.a(bitmap, true, i);
        this.qIF.mE(false);
        g.b(this.qIF, bitmap);
        return this;
    }

    public final g$a TJ(String str) {
        g.a(this.mContext, this.qIF, str);
        this.qIF.mE(false);
        return this;
    }

    public final g$a a(b bVar) {
        this.qIF.uJP.uIK = bVar;
        return this;
    }

    public final g$a dh(View view) {
        this.qIF.dR(view);
        return this;
    }

    public final g$a g(Boolean bool) {
        this.qIF.uJP.uID = bool.booleanValue();
        if (bool.booleanValue()) {
            this.qIF.abw(this.mContext.getString(R.l.confirm_dialog_edittext_hint));
        }
        return this;
    }

    public final g$a TK(String str) {
        this.qIF.abw(str);
        return this;
    }

    public final g$a cdQ() {
        this.qIF.mE(false);
        return this;
    }

    public final g$a BX(int i) {
        this.qIG = this.mContext.getResources().getString(i);
        return this;
    }

    public final g$a a(q.a aVar) {
        this.eIW = this.qIF.anj();
        if (this.gFM != null) {
            this.eIW.setOnDismissListener(this.gFM);
        }
        g.a(this.mContext, this.eIW, this.qIG, aVar, aVar);
        return this;
    }
}
