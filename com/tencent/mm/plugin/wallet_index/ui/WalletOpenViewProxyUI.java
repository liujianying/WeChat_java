package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.a.a.q;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.ayf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletOpenViewProxyUI extends WalletBaseUI {
    private Map<String, String> pDK = new HashMap();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(8);
        String stringExtra = getIntent().getStringExtra("packageExt");
        this.pDK = new HashMap();
        if (!bi.oW(stringExtra)) {
            String[] split = stringExtra.split("&");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    if (!bi.oW(split[i])) {
                        String[] split2 = split[i].split("=");
                        if (split2.length == 2 && !bi.oW(split2[0])) {
                            this.pDK.put(split2[0], split2[1]);
                        }
                    }
                }
            }
        }
        jr(2996);
        jr(580);
        jr(385);
        if (getIntent() == null) {
            x.d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            return;
        }
        stringExtra = (String) this.pDK.get("openview");
        String stringExtra2 = getIntent().getStringExtra("appId");
        String stringExtra3 = getIntent().getStringExtra("timeStamp");
        String stringExtra4 = getIntent().getStringExtra("nonceStr");
        String stringExtra5 = getIntent().getStringExtra("packageExt");
        String stringExtra6 = getIntent().getStringExtra("paySignature");
        if ("open_wcpay_f2f_receive_detail".equals(stringExtra)) {
            a(new u(stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6), true, false);
        } else if ("open_wcpay_grouppay_detail".equals(stringExtra)) {
            PB(stringExtra5);
        } else if ("open_wcpay_lqt_detail".equals(stringExtra)) {
            x.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui");
            if (this.pDK != null) {
                new Intent().putExtra("key_account_type", 1);
                stringExtra = (String) this.pDK.get("ecardtype");
                x.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui, ecardtype: %s, extradata: %s, need_open_lqb: %s", new Object[]{stringExtra, (String) this.pDK.get("extradata"), (String) this.pDK.get("need_open_lqb")});
                if (bi.getInt((String) this.pDK.get("need_open_lqb"), 0) == 1) {
                    if (bi.oW(stringExtra)) {
                        stringExtra = "WEB_DEBIT";
                    }
                    a(new q(stringExtra, stringExtra2), true, false);
                } else {
                    d.A(this.mController.tml, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    setResult(-1);
                    finish();
                }
            } else {
                d.A(this.mController.tml, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                setResult(-1);
                finish();
            }
            h.mEJ.a(663, 18, 1, false);
        } else {
            String str = stringExtra2;
            String str2 = stringExtra3;
            String str3 = stringExtra4;
            String str4 = stringExtra5;
            String str5 = stringExtra6;
            a(new com.tencent.mm.plugin.wallet_core.c.a(str, str2, str3, str4, getIntent().getStringExtra("signtype"), str5, getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 4, "openWCPaySpecificView", getIntent().getIntExtra("pay_channel", 0)), true, false);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletOpenViewProxyUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar});
        if (i != 0 || i2 != 0) {
            setResult(0);
            finish();
            return true;
        } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
            PB(getIntent().getStringExtra("packageExt"));
            return true;
        } else if (lVar instanceof u) {
            PB(getIntent().getStringExtra("packageExt"));
            return true;
        } else if (!(lVar instanceof q)) {
            return false;
        } else {
            ayf ayf = ((q) lVar).oZB;
            x.i("MicroMsg.WalletOpenViewProxyUI", "on open lqb account scene end, retcode: %s, regmsg: %s", new Object[]{Integer.valueOf(ayf.hwV), ayf.hwW});
            if (ayf.hwV == 0) {
                Intent intent = new Intent();
                intent.putExtra("key_account_type", 2);
                d.b(this.mController.tml, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                setResult(-1);
            } else {
                Toast.makeText(this, ayf.hwW, 1).show();
                setResult(0);
            }
            finish();
            return true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        js(580);
        js(385);
        js(2996);
    }

    protected final int getLayoutId() {
        return -1;
    }

    private void PB(String str) {
        Intent intent;
        if (bi.oW(str)) {
            x.w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
        } else {
            String str2 = (String) this.pDK.get("openview");
            if ("open_wcpay_biz_view".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
                d.A(this.mController.tml, "mall", ".ui.MallIndexUI");
            } else if ("open_wcpay_balance_view".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
                com.tencent.mm.pluginsdk.wallet.h.ab(this.mController.tml, 0);
            } else if ("open_wcpay_order_detail_view".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
                intent = new Intent();
                intent.putExtra("trans_id", (String) this.pDK.get("trans_id"));
                intent.putExtra("scene", 1);
                if (this.pDK.containsKey("bill_id")) {
                    intent.putExtra("bill_id", (String) this.pDK.get("bill_id"));
                }
                d.b(this.mController.tml, "order", ".ui.MallOrderTransactionInfoUI", intent);
            } else if ("open_wcpay_f2f_receive_detail".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
                intent = new Intent();
                intent.putExtra("key_timestamp", bi.getLong((String) this.pDK.get("fromtimestamp"), 0));
                intent.putExtra("key_from_scene", 1);
                d.b(this.mController.tml, "collect", ".ui.CollectBillUI", intent);
                h.mEJ.h(13944, new Object[]{Integer.valueOf(2)});
            } else if ("open_wcpay_grouppay_detail".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
                intent = new Intent();
                intent.putExtra("bill_no", (String) this.pDK.get("billno"));
                intent.putExtra("chatroom", (String) this.pDK.get("groupid"));
                intent.putExtra("key_sign", (String) this.pDK.get("sign"));
                intent.putExtra("key_ver", (String) this.pDK.get("ver"));
                intent.putExtra("enter_scene", 5);
                d.b(this.mController.tml, "aa", ".ui.PaylistAAUI", intent);
            } else if ("open_wcpay_t2bc_detail".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "do open_wcpay_t2bc_detail");
                intent = new Intent();
                intent.putExtra("key_transfer_bill_id", (String) this.pDK.get("transfer_bill_id"));
                intent.putExtra("key_enter_scene", 1);
                d.b(this.mController.tml, "remittance", ".bankcard.ui.BankRemitDetailUI", intent);
            } else if ("open_honey_pay_home".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "do open honey pay view");
                d.b(this.mController.tml, "honey_pay", ".ui.HoneyPayMainUI", new Intent());
            } else {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : " + str2);
            }
        }
        intent = new Intent();
        intent.putExtra("closeWebView", (String) this.pDK.get("closeWebView"));
        setResult(-1, intent);
        finish();
    }
}
