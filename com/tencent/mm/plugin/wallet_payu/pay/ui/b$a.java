package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;

class b$a {
    public String pFG;
    public Bankcard pFH;
    public FavorPayInfo pFI;
    public boolean pFJ;
    public b pFK;
    public OnCancelListener pFL;
    final /* synthetic */ b pFM;
    public a pxV;

    public b$a(b bVar, String str, Bankcard bankcard, FavorPayInfo favorPayInfo, boolean z, OnCancelListener onCancelListener, a aVar, b bVar2) {
        this.pFM = bVar;
        this.pFG = str;
        this.pFH = bankcard;
        this.pFI = favorPayInfo;
        this.pFJ = z;
        this.pFL = onCancelListener;
        this.pxV = aVar;
        this.pFK = bVar2;
    }
}
