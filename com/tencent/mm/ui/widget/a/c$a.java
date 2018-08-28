package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.view.View;

public class c$a {
    private Context mContext;
    public a uJP = new a();

    public c$a(Context context) {
        this.mContext = context;
    }

    public final c$a abt(String str) {
        this.uJP.title = str;
        return this;
    }

    public final c$a R(CharSequence charSequence) {
        this.uJP.title = charSequence;
        return this;
    }

    public final c$a Gq(int i) {
        this.uJP.title = this.mContext.getString(i);
        return this;
    }

    public final c$a abu(String str) {
        this.uJP.uIP = str;
        return this;
    }

    public final c$a Gr(int i) {
        this.uJP.uIP = this.mContext.getString(i);
        return this;
    }

    public final c$a S(CharSequence charSequence) {
        this.uJP.uIQ = charSequence;
        return this;
    }

    public final c$a mE(boolean z) {
        this.uJP.uIY = z;
        return this;
    }

    public final c$a a(String str, CharSequence charSequence, Boolean bool, c cVar, a aVar) {
        this.uJP.uIE = str;
        this.uJP.uIF = charSequence;
        this.uJP.uIG = bool.booleanValue();
        this.uJP.uII = cVar;
        this.uJP.uIJ = aVar;
        return this;
    }

    public final c$a a(d dVar) {
        this.uJP.uIL = dVar;
        return this;
    }

    public final c$a abv(String str) {
        this.uJP.bOX = str;
        return this;
    }

    public final c$a a(Bitmap bitmap, boolean z, int i) {
        this.uJP.uIO = bitmap;
        this.uJP.uIZ = z;
        this.uJP.uJk = i;
        return this;
    }

    public final c$a Gs(int i) {
        this.uJP.uJj = i;
        return this;
    }

    public final c$a abw(String str) {
        this.uJP.uIB = str;
        return this;
    }

    public final c$a dR(View view) {
        this.uJP.pYk = view;
        return this;
    }

    public final c$a abx(String str) {
        this.uJP.uIS = str;
        return this;
    }

    public final c$a Gt(int i) {
        this.uJP.uIS = this.mContext.getString(i);
        return this;
    }

    public final c$a a(OnClickListener onClickListener) {
        this.uJP.uJa = onClickListener;
        return this;
    }

    public final c$a a(boolean z, OnClickListener onClickListener) {
        this.uJP.uJa = onClickListener;
        this.uJP.uJo = z;
        return this;
    }

    public final c$a aby(String str) {
        this.uJP.uIT = str;
        return this;
    }

    public final c$a Gu(int i) {
        this.uJP.uIT = this.mContext.getString(i);
        return this;
    }

    public final c$a b(OnClickListener onClickListener) {
        this.uJP.uJb = onClickListener;
        return this;
    }

    public final c$a e(OnCancelListener onCancelListener) {
        this.uJP.DI = onCancelListener;
        return this;
    }

    public final c$a a(OnDismissListener onDismissListener) {
        this.uJP.DJ = onDismissListener;
        return this;
    }

    public final c$a mF(boolean z) {
        this.uJP.eWV = z;
        return this;
    }

    public final c$a mG(boolean z) {
        this.uJP.uIX = z;
        return this;
    }

    public c anj() {
        c cVar = new c(this.mContext);
        cVar.a(this.uJP);
        return cVar;
    }
}
