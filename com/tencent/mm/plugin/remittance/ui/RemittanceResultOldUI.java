package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class RemittanceResultOldUI extends RemittanceResultUI {
    private Orders mCZ;
    private String mDa;
    private boolean mDc;
    private int myU;

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.remittance_result_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCZ = (Orders) this.sy.getParcelable("key_orders");
        initView();
        if (this.myU == 31) {
            String str = "";
            if (this.mCZ.ppf.size() > 0) {
                str = ((Commodity) this.mCZ.ppf.get(0)).bOe;
            }
            x.i("MicroMsg.RemittanceResultOldUI", "transId: %s", new Object[]{str});
            b.bqQ().bqT().en(str, this.mDa);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            brF();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void initView() {
        int i = 1;
        boolean z = false;
        setMMTitle(getString(a$i.remittance_result_title));
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        TextView textView = (TextView) findViewById(f.remittance_result_fee);
        if (this.mCZ != null) {
            textView.setText(e.e(this.mCZ.mBj, this.mCZ.lNV));
        }
        PayInfo payInfo = (PayInfo) this.sy.getParcelable("key_pay_info");
        if (payInfo == null) {
            x.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
            finish();
            return;
        }
        String str = "";
        if (payInfo.qUL != null) {
            this.mDc = payInfo.qUL.getBoolean("extinfo_key_4");
            str = payInfo.qUL.getString("extinfo_key_1");
        }
        int i2 = payInfo.bVY;
        this.myU = i2;
        this.mDa = str;
        str = e.gT(str);
        if (i2 == 31) {
            textView = (TextView) findViewById(f.remittance_result_receiver_desc);
            CharSequence string = getString(a$i.remittance_result_receiver_desc, new Object[]{str});
            if (bi.oW(string)) {
                textView.setVisibility(8);
            } else {
                textView.setText(j.a(this, string, textView.getTextSize()));
                textView.setVisibility(0);
            }
            findViewById(f.remittance_result_f2f_area).setVisibility(8);
            if (this.mCZ.mxE > 0.0d) {
                ((TextView) findViewById(f.charge_fee)).setText(getResources().getString(a$i.remittance_result_charge_info, new Object[]{e.e(this.mCZ.mxE, this.mCZ.lNV)}));
                findViewById(f.charge_fee_container).setVisibility(0);
            }
        } else {
            String str2 = "";
            if (payInfo.qUL != null) {
                str2 = payInfo.qUL.getString("extinfo_key_2");
            }
            if (i2 == 32 || i2 == 33) {
                str2 = str;
            } else if (bi.oW(str2)) {
                str2 = str + getString(a$i.remittance_without_realname_title);
            } else {
                str2 = str + "（" + e.abZ(str2) + "）";
            }
            TextView textView2 = (TextView) findViewById(f.remittance_result_receiver_desc);
            if (bi.oW(str2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(j.a(this, getString(a$i.remittance_result_payer_desc, new Object[]{str2}), textView2.getTextSize()));
                textView2.setVisibility(0);
            }
            if (i2 == 33 || i2 == 32) {
                View findViewById = findViewById(f.remittance_result_f2f_recv_desc_area);
                textView2 = (TextView) findViewById(f.remittance_result_f2f_recv_desc_title);
                TextView textView3 = (TextView) findViewById(f.remittance_result_f2f_recv_desc);
                CharSequence string2 = payInfo.qUL.getString("extinfo_key_3");
                CharSequence string3 = payInfo.qUL.getString("extinfo_key_8");
                if (bi.oW(string2)) {
                    findViewById.setVisibility(8);
                    boolean z2 = false;
                } else {
                    textView3.setText(j.a(this, string2, textView3.getTextSize()));
                    findViewById.setVisibility(0);
                    if (bi.oW(string3)) {
                        i2 = 1;
                    } else {
                        textView2.setText(string3);
                        i2 = 1;
                    }
                }
                View findViewById2 = findViewById(f.remittance_result_f2f_payer_desc_area);
                textView2 = (TextView) findViewById(f.remittance_result_f2f_payer_desc_title);
                textView3 = (TextView) findViewById(f.remittance_result_f2f_payer_desc);
                string3 = payInfo.qUL.getString("extinfo_key_6");
                CharSequence string4 = payInfo.qUL.getString("extinfo_key_7");
                if (bi.oW(string4)) {
                    findViewById2.setVisibility(8);
                    i = 0;
                } else {
                    textView3.setText(j.a(this, string4, textView3.getTextSize()));
                    textView3.setVisibility(0);
                    if (!bi.oW(string3)) {
                        textView2.setText(j.a(this, string3, textView2.getTextSize()));
                    }
                }
                if (i2 == 0 && i == 0) {
                    findViewById(f.remittance_result_f2f_area).setVisibility(8);
                }
            } else if (!(i2 != 5 || this.mCZ.ppf == null || this.mCZ.ppf.get(0) == null || TextUtils.isEmpty(((Commodity) this.mCZ.ppf.get(0)).lNK))) {
                textView2.setText(((Commodity) this.mCZ.ppf.get(0)).lNK);
            }
        }
        ((Button) findViewById(f.remittance_result_next_btn)).setOnClickListener(new 1(this));
        com.tencent.mm.kernel.g.Ek();
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQv, Boolean.valueOf(false));
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            x.i("MicroMsg.RemittanceResultOldUI", "has show the finger print auth guide!");
            return;
        }
        c af = com.tencent.mm.wallet_core.a.af(this);
        Bundle bundle = new Bundle();
        if (af != null) {
            bundle = af.jfZ;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            x.i("MicroMsg.RemittanceResultOldUI", "pwd is empty, not show the finger print auth guide!");
        } else if (af != null) {
            af.a(this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
        }
    }

    private void brF() {
        if (this.sy.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.sy.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new 2(this));
                this.sy.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        brG();
    }

    private void brG() {
        cDK().b(this, this.sy);
        new ag().postDelayed(new Runnable() {
            public final void run() {
                if (RemittanceResultOldUI.this.myU == 33 || RemittanceResultOldUI.this.myU == 32) {
                    RemittanceResultOldUI.this.finish();
                } else if (bi.oW(RemittanceResultOldUI.this.mDa) || RemittanceResultOldUI.this.mDc) {
                    RemittanceResultOldUI.this.finish();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", RemittanceResultOldUI.this.mDa);
                    intent.putExtra("finish_direct", false);
                    d.e(RemittanceResultOldUI.this, ".ui.chatting.ChattingUI", intent);
                }
            }
        }, 100);
    }

    protected final boolean brH() {
        return false;
    }
}
