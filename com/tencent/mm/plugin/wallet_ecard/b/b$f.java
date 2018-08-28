package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.wallet.balance.a.a.q;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.protocal.c.ayf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$f extends g {
    final /* synthetic */ b pCf;

    public b$f(b bVar, MMActivity mMActivity, i iVar) {
        this.pCf = bVar;
        super(mMActivity, iVar);
    }

    public final boolean m(Object... objArr) {
        ((Integer) objArr[0]).intValue();
        String str = (String) objArr[1];
        this.uXK.jr(2996);
        this.uXK.a(new q(b.b(this.pCf), str), true);
        return false;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof q)) {
            return false;
        }
        x.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        q qVar = (q) lVar;
        if (i == 0 && i2 == 0) {
            ayf ayf = qVar.oZB;
            if (ayf.hwV == 0) {
                Intent intent = new Intent();
                intent.putExtra("key_account_type", 2);
                d.b(this.fEY, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
            } else {
                Toast.makeText(this.fEY, ayf.hwW, 1).show();
            }
        } else {
            x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{lVar});
            h.b(this.fEY, b.d(this.fEY, new String[]{str}), "", false);
        }
        this.fEY.finish();
        this.pCf.b(this.fEY, new Bundle());
        return true;
    }
}
