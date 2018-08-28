package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.plugin.remittance.model.o;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.lr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class RemittanceResultUI extends WalletBaseUI {
    private Orders mCZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (brH()) {
            int i;
            boolean z;
            int i2;
            PayInfo payInfo;
            fp fpVar;
            ux(4);
            getWindow().setBackgroundDrawableResource(c.transparent);
            this.mCZ = (Orders) this.sy.getParcelable("key_orders");
            PayInfo payInfo2 = (PayInfo) this.sy.getParcelable("key_pay_info");
            if (payInfo2 != null) {
                i = payInfo2.bVY;
            } else {
                i = 0;
            }
            if (i == 31 || i == 5) {
                z = false;
            } else {
                z = true;
            }
            String str = "MicroMsg.RemittanceResultUI";
            String str2 = "orders==null:%s, paysScene: %s, needFetchF2fData: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.mCZ == null);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.mCZ != null) {
                x.i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", new Object[]{Integer.valueOf(this.mCZ.ppp)});
                if (this.mCZ.ppp != 1) {
                    E(RemittanceResultOldUI.class);
                } else if (z) {
                    Orders orders = this.mCZ;
                    if (payInfo2 == null || payInfo2.qUL == null) {
                        E(RemittanceResultNewUI.class);
                        finish();
                    } else {
                        x.i("MicroMsg.RemittanceResultUI", "fetch f2f data");
                        String string = payInfo2.qUL.getString("extinfo_key_11");
                        String str3 = "";
                        if (orders != null && orders.ppf.size() > 0) {
                            str3 = ((Commodity) orders.ppf.get(0)).bOe;
                        }
                        int i3 = payInfo2.qUL.getInt("extinfo_key_15", 0);
                        str2 = payInfo2.qUL.getString("extinfo_key_7");
                        String string2 = payInfo2.qUL.getString("extinfo_key_3");
                        int i4 = payInfo2.qUL.getInt("extinfo_key_12", 0);
                        String string3 = payInfo2.qUL.getString("extinfo_key_13");
                        String string4 = payInfo2.qUL.getString("extinfo_key_14");
                        String string5 = payInfo2.qUL.getString("extinfo_key_16");
                        if (bi.oW(string5)) {
                            string5 = str3;
                        }
                        x.i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", new Object[]{string, string5, Integer.valueOf(i3), str2, string2, Integer.valueOf(i4), string3, string4, Integer.valueOf(payInfo2.bVU), Integer.valueOf(payInfo2.bVY)});
                        jr(2773);
                        int i5 = payInfo2.bVU;
                        int i6 = payInfo2.bVY;
                        a(new o(string, string5, i3, str2, string2, i5, i4, string3, string4), true, true);
                    }
                }
                i2 = 0;
                payInfo = (PayInfo) this.sy.getParcelable("key_pay_info");
                if (payInfo != null) {
                    i2 = payInfo.bVY;
                }
                if (i2 != 33 || i2 == 32 || i2 == 48 || i2 == 31) {
                    fpVar = new fp();
                    fpVar.bOc.bOd = payInfo.bOd;
                    if (i2 == 31) {
                        fpVar.bOc.type = 0;
                    } else if (i2 == 32 || i2 == 33) {
                        fpVar.bOc.type = 1;
                    }
                    if (!(this.mCZ == null || this.mCZ.ppf.isEmpty())) {
                        fpVar.bOc.bOe = ((Commodity) this.mCZ.ppf.get(0)).bOe;
                    }
                    com.tencent.mm.sdk.b.a.sFg.m(fpVar);
                }
                return;
            }
            E(RemittanceResultNewUI.class);
            finish();
            i2 = 0;
            payInfo = (PayInfo) this.sy.getParcelable("key_pay_info");
            if (payInfo != null) {
                i2 = payInfo.bVY;
            }
            if (i2 != 33) {
            }
            fpVar = new fp();
            fpVar.bOc.bOd = payInfo.bOd;
            if (i2 == 31) {
                fpVar.bOc.type = 0;
            } else if (i2 == 32 || i2 == 33) {
                fpVar.bOc.type = 1;
            }
            fpVar.bOc.bOe = ((Commodity) this.mCZ.ppf.get(0)).bOe;
            com.tencent.mm.sdk.b.a.sFg.m(fpVar);
        }
    }

    private void E(Class<?> cls) {
        if (cDK() == null) {
            a(cls, getIntent());
        } else {
            cDK().c(this, cls, this.sy);
        }
    }

    protected boolean brH() {
        return true;
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof o)) {
            return false;
        }
        x.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        o oVar = (o) lVar;
        if (i == 0 && i2 == 0) {
            lr lrVar = oVar.mxu;
            x.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", new Object[]{Integer.valueOf(lrVar.hUm), lrVar.hUn, lrVar.pqb});
            if (lrVar.hUm == 0) {
                try {
                    this.sy.putByteArray("key_succpage_resp", lrVar.toByteArray());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RemittanceResultUI", e, "pass succ page resp error: %s", new Object[]{e.getMessage()});
                }
                E(RemittanceResultNewUI.class);
                finish();
                return true;
            }
            Toast.makeText(this, lrVar.hUn, 1).show();
        }
        E(RemittanceResultNewUI.class);
        finish();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        js(2773);
    }

    protected int getLayoutId() {
        return -1;
    }
}
