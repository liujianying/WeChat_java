package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardManageUI$9 implements OnItemClickListener {
    final /* synthetic */ WalletBankcardManageUI pdm;

    WalletBankcardManageUI$9(WalletBankcardManageUI walletBankcardManageUI) {
        this.pdm = walletBankcardManageUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Bankcard bankcard = (Bankcard) adapterView.getAdapter().getItem(i);
        e.He(18);
        if (bankcard != null) {
            String str;
            a b = WalletBankcardManageUI.b(this.pdm);
            if (b.pcB != null && !b.pcB.isEmpty()) {
                for (String str2 : b.pcB) {
                    if (str2.equals(bankcard.field_bindSerial)) {
                        x.d("MicroMsg.BankcardListAdapter", "remove new: %s", new Object[]{str2});
                        b.pcB.remove(str2);
                        g.Ek();
                        g.Ei().DT().a(a.sYg, bi.c(b.pcB, ","));
                        break;
                    }
                }
            }
            if (bankcard.bOr()) {
                Bundle bundle;
                if (bankcard.field_wxcreditState == 0) {
                    if (b.a(bankcard) && bankcard != null) {
                        g.Ek();
                        str2 = (String) g.Ei().DT().get(196659, null);
                        StringBuilder stringBuilder = new StringBuilder();
                        if (TextUtils.isEmpty(str2)) {
                            stringBuilder.append(bankcard.field_bankcardType);
                        } else {
                            stringBuilder.append(str2);
                            stringBuilder.append("&");
                            stringBuilder.append(bankcard.field_bankcardType);
                        }
                        g.Ek();
                        g.Ei().DT().set(196659, stringBuilder.toString());
                    }
                    bundle = new Bundle();
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_username", bankcard.field_bizUsername);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a(this.pdm, "WXCreditOpenProcess", bundle, null);
                } else {
                    bundle = new Bundle();
                    bundle.putParcelable("key_bankcard", bankcard);
                    com.tencent.mm.wallet_core.a.a(this.pdm, "WXCreditManagerProcess", bundle, null);
                }
            } else if (bankcard.bOw()) {
                x.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
                Intent intent = new Intent();
                intent.putExtra("key_card_no", bankcard.field_bindSerial);
                d.b(this.pdm, "honey_pay", ".ui.HoneyPayCardBackUI", intent);
            } else {
                x.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[]{Boolean.valueOf((o.bOW().bPw().prx & GLIcon.LEFT) > 0), Integer.valueOf(o.bOW().bPw().prx)});
                if ((o.bOW().bPw().prx & GLIcon.LEFT) > 0) {
                    x.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                    g.Ek();
                    str2 = (String) g.Ei().DT().get(a.sTa, "");
                    g.Ek();
                    long longValue = ((Long) g.Ei().DT().get(a.sTb, Long.valueOf(0))).longValue();
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (bi.oW(str2) || currentTimeMillis - longValue >= 7200) {
                        x.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
                        com.tencent.mm.sdk.b.a.sFg.b(new 1(this, bankcard));
                    } else {
                        x.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                        this.pdm.b(bankcard);
                    }
                } else {
                    this.pdm.c(bankcard);
                }
            }
            h.mEJ.h(14422, new Object[]{Integer.valueOf(1), bankcard.field_bankcardType});
            return;
        }
        this.pdm.bNj();
        h.mEJ.h(14422, new Object[]{Integer.valueOf(2)});
    }
}
