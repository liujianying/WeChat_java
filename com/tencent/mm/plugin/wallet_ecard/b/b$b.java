package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$b extends g {
    final /* synthetic */ b pCf;

    public b$b(b bVar, MMActivity mMActivity, i iVar) {
        this.pCf = bVar;
        super(mMActivity, iVar);
    }

    public final boolean m(Object... objArr) {
        String str = (String) objArr[0];
        int i = b.a(this.pCf).getInt(a.pBy);
        this.uXK.jr(1958);
        this.uXK.a(new e(b.b(this.pCf), str, i, null), true);
        b.c(this.pCf).putString("key_pwd1", str);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof e)) {
            return false;
        }
        this.uXK.js(1958);
        e eVar = (e) lVar;
        if (i != 0 || i2 != 0) {
            x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{eVar});
            h.a(this.fEY, b.d(this.fEY, new String[]{str}), "", false, new 2(this));
        } else if (eVar.pCc.hwV == 0) {
            Bundle bundle = new Bundle();
            x.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", new Object[]{eVar.pCc.rhc, Boolean.valueOf(eVar.pCc.saG)});
            b.d(this.pCf).putString(a.pBA, eVar.pCc.rhc);
            if (eVar.pCc.saG) {
                bundle.putBoolean(a.pBQ, true);
            }
            this.pCf.a(this.fEY, 0, bundle);
        } else if (!(b.a((WalletBaseUI) this.fEY, eVar.pCc.rhe) || b.a((WalletBaseUI) this.fEY, eVar, eVar.hUm, eVar.hUn, eVar.pCc.hwV, eVar.pCc.hwW))) {
            h.a(this.fEY, b.d(this.fEY, new String[]{eVar.pCc.hwW, eVar.hUn, str}), "", false, new 1(this));
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        Bundle bundle = new Bundle();
        bundle.putInt("key_process_result_code", 0);
        this.pCf.b(this.fEY, bundle);
    }
}
