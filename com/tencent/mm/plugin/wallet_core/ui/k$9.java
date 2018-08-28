package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.le;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;

class k$9 implements OnClickListener {
    final /* synthetic */ Dialog nmd;
    final /* synthetic */ ECardInfo pvF;
    final /* synthetic */ Context val$context;

    public k$9(ECardInfo eCardInfo, Context context, Dialog dialog) {
        this.pvF = eCardInfo;
        this.val$context = context;
        this.nmd = dialog;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletIdCardTip", "go to: %s", new Object[]{Integer.valueOf(this.pvF.pne)});
        if (this.pvF.pne == 1) {
            e.l(this.val$context, this.pvF.ceh, false);
        } else {
            le leVar = new le();
            leVar.bVx.YC = new WeakReference(this.val$context);
            a.sFg.m(leVar);
        }
        if (this.nmd != null && this.nmd.isShowing()) {
            this.nmd.dismiss();
        }
    }
}
