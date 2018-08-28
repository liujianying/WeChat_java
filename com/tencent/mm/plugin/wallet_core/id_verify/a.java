package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends b {
    private int bjW = 0;
    private boolean hxu = false;
    private String mActivityName = null;
    private int mMode;
    private String pjT = null;
    private boolean pjU = false;
    private int pjV = -1;

    public final c a(Activity activity, Bundle bundle) {
        boolean z;
        y(new Object[]{"start", activity, bundle});
        if (this.jfZ == null) {
            this.jfZ = new Bundle();
        }
        if (bundle == null) {
            bundle = this.jfZ;
        }
        if (bundle != null) {
            this.mMode = bundle.getInt("real_name_verify_mode", 0);
        } else {
            this.mMode = 0;
        }
        this.pjV = this.mMode;
        bundle.putBoolean("key_is_realname_verify_process", true);
        this.pjT = bundle.getString("realname_verify_process_jump_plugin", "");
        this.mActivityName = bundle.getString("realname_verify_process_jump_activity", "");
        if (bundle.getInt("realname_verify_process_allow_idverify", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pjU = z;
        x.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", new Object[]{Boolean.valueOf(this.pjU), this.pjT, this.mActivityName});
        switch (this.mMode) {
            case 0:
                p.GZ(10);
                c(activity, SwitchRealnameVerifyModeUI.class, bundle);
                break;
            case 1:
                bundle.putBoolean("key_need_bind_response", true);
                p.GZ(10);
                super.a(activity, bundle);
                break;
            case 2:
                c(activity, WalletRealNameVerifyUI.class, bundle);
                break;
        }
        return this;
    }

    public final void c(Activity activity, int i) {
        y(new Object[]{"back", activity, Integer.valueOf(i)});
        p.cDe();
        if (activity instanceof SwitchRealnameVerifyModeUI) {
            if (i == 0) {
                b(activity, this.jfZ);
            }
        } else if ((activity instanceof WalletRealNameVerifyUI) || (activity instanceof WalletBankcardIdUI)) {
            if (this.pjV != 0) {
                b(activity, this.jfZ);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, this.jfZ);
        }
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        y(new Object[]{"forward", activity, "actionCode:" + i, bundle});
        int i2 = this.jfZ.getInt("real_name_verify_mode", this.mMode);
        if (this.mMode != i2) {
            this.mMode = i2;
        }
        if (this.mMode == 2) {
            if (activity instanceof WalletRealNameVerifyUI) {
                c(activity, WalletSetPasswordUI.class, bundle);
            } else if (activity instanceof WalletSetPasswordUI) {
                c(activity, WalletPwdConfirmUI.class, bundle);
            } else if (!(activity instanceof WalletPwdConfirmUI) && (activity instanceof SwitchRealnameVerifyModeUI)) {
                c(activity, WalletRealNameVerifyUI.class, bundle);
                this.mMode = 2;
            }
        } else if (this.mMode == 1) {
            if (activity instanceof SwitchRealnameVerifyModeUI) {
                if (o.bOW().bPs()) {
                    c(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    c(activity, WalletBankcardIdUI.class, bundle);
                }
            } else if (activity instanceof WalletCheckPwdUI) {
                c(activity, WalletBankcardIdUI.class, bundle);
            } else {
                super.a(activity, i, bundle);
            }
        } else if (activity instanceof WalletRealNameVerifyUI) {
            c(activity, WalletBankcardIdUI.class, bundle);
            this.mMode = 1;
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        Bundle bundle2;
        y(new Object[]{"end", activity, bundle});
        p.cDe();
        if (bundle == null) {
            bundle2 = this.jfZ;
        } else {
            bundle2 = bundle;
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (this.mMode == 1) {
            cCV();
            if (bundle2.getBoolean("intent_bind_end", false)) {
                this.bjW = -1;
            } else {
                this.bjW = 0;
            }
        } else if (bundle2.containsKey("realname_verify_process_ret")) {
            this.bjW = bundle2.getInt("realname_verify_process_ret", -1);
        } else {
            this.bjW = 0;
        }
        if (bundle2.containsKey("intent_bind_end")) {
            bundle2.remove("intent_bind_end");
        }
        if (bundle2.containsKey("key_is_bind_reg_process")) {
            bundle2.remove("key_is_bind_reg_process");
        }
        bundle2.putInt("realname_verify_process_ret", this.bjW);
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        if (this.bjW == -1) {
            Toast.makeText(activity, activity.getString(a$i.realname_verify_succ), 0).show();
        }
        sz szVar = new sz();
        if (this.bjW == -1) {
            szVar.cdR.scene = 17;
        } else if (this.bjW == 0) {
            szVar.cdR.scene = 18;
        } else {
            szVar.cdR.scene = 0;
        }
        szVar.bJX = new 1(this, szVar, intent, activity);
        szVar.bJX.run();
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (!(mMActivity instanceof WalletPwdConfirmUI)) {
            return mMActivity instanceof WalletRealNameVerifyUI ? new 3(this, mMActivity, iVar) : super.a(mMActivity, iVar);
        } else {
            if (this.mMode == 2) {
                return new 2(this, mMActivity, iVar);
            }
            return super.a(mMActivity, iVar);
        }
    }

    public final String aNK() {
        return "realname_verify_process";
    }

    public final int a(MMActivity mMActivity, int i) {
        return a$i.wallet_input_realname_finish_confirm;
    }
}
