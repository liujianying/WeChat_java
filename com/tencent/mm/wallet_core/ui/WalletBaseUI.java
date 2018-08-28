package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mm.ab.l;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.smtt.utils.TbsLog;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;

public abstract class WalletBaseUI extends MMActivity implements f {
    public static final int eCE = a.fromDPToPix(ad.getContext(), 270);
    private static i uYQ = null;
    private Dialog jhd;
    public View kMk;
    public a kTx;
    public MyKeyboardWindow mKeyboard;
    public Bundle sy = new Bundle();
    private OnMenuItemClickListener tQp;
    private c uYN = null;
    public com.tencent.mm.wallet_core.d.i uYO = null;
    private g uYP = null;
    private OnMenuItemClickListener uYR;
    public boolean uYS = false;

    public abstract boolean d(int i, int i2, String str, l lVar);

    public final String bNs() {
        if (this.sy == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.sy.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.bOd;
        }
        return "";
    }

    public void baT() {
        x.d("MicroMsg.WalletBaseUI", "cancelforceScene");
        this.uYO.baT();
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.tencent.mm.kernel.g.Eg().Dx()) {
            x.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
            h.a(this, getString(com.tencent.mm.plugin.wxpay.a.i.wallet_account_not_ready), "", false, new 1(this));
        }
        this.uYO = new com.tencent.mm.wallet_core.d.i(this, this);
        this.uYO.jr(385);
        this.uYO.jr(1518);
        x.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
        c af = com.tencent.mm.wallet_core.a.af(this);
        if (af != null) {
            this.uYO.dox = af.aNK();
        }
        x.d("MicroMsg.WalletBaseUI", "proc " + af);
        this.sy = com.tencent.mm.wallet_core.a.ae(this);
        if (this.sy == null) {
            this.sy = new Bundle();
        }
        this.uYO.sy = this.sy;
        if (bbU() && !com.tencent.mm.wallet_core.a.ad(this)) {
            x.e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
        }
        if (getLayoutId() > 0) {
            String str = "";
            if (!bi.oW(str)) {
                setMMSubTitle(str);
            }
        }
        setBackBtn(new 3(this));
        this.uYP = cDL();
        if (this.uYP != null && this.uYP.r(new Object[0])) {
            ux(4);
        } else if (getLayoutId() <= 0) {
            ux(4);
        } else if (bbR()) {
            ux(4);
        } else {
            ux(0);
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.tQp = onMenuItemClickListener;
        super.setBackBtn(onMenuItemClickListener);
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.uYR = onMenuItemClickListener;
        super.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public final void a(String str, OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.uYR = onMenuItemClickListener;
        super.a(0, str, onMenuItemClickListener, i);
    }

    public void onResume() {
        super.onResume();
        if (o.cCZ()) {
            l bVar;
            if (q.GS()) {
                bVar = new b();
            } else {
                bVar = new m();
            }
            this.uYO.a(bVar, false);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.uYO.js(385);
        this.uYO.js(1518);
    }

    public void b(int i, int i2, String str, l lVar, boolean z) {
        x.d("MicroMsg.WalletBaseUI", "errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        TenpaySecureEditText.setSalt(o.cDa());
        if (lVar instanceof i) {
            i iVar = (i) lVar;
            uYQ = iVar;
            if (this.sy != null) {
                if (iVar.pmS > 0) {
                    this.sy.putInt("key_is_gen_cert", iVar.pmS);
                }
                if (iVar.pmU > 0) {
                    this.sy.putInt("key_is_hint_crt", iVar.pmU);
                }
                if (iVar.pmW > 0) {
                    this.sy.putInt("key_is_ignore_cert", iVar.pmW);
                }
                if (!bi.oW(iVar.pmT)) {
                    this.sy.putString("key_crt_token", iVar.pmT);
                }
                if (!bi.oW(iVar.pmV)) {
                    this.sy.putString("key_crt_wording", iVar.pmV);
                }
            }
        }
        k(i, i2, str, lVar);
        f.a(this, i, i2, str, lVar, z);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        cDL().onActivityResult(i, i2, intent);
    }

    public void rj(int i) {
    }

    public boolean k(int i, int i2, String str, l lVar) {
        return true;
    }

    public boolean bbU() {
        return true;
    }

    public boolean aWj() {
        return false;
    }

    public boolean bbR() {
        if (getLayoutId() > 0 && !this.uYO.baU()) {
            return false;
        }
        return true;
    }

    /* renamed from: bND */
    public boolean f() {
        return false;
    }

    public final void cDH() {
        PayInfo payInfo = (PayInfo) this.sy.getParcelable("key_pay_info");
        if (payInfo == null) {
            payInfo = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        if (payInfo != null && !bi.oW(payInfo.fMk)) {
            this.uYO.a(new e(payInfo.fMk, payInfo.bOd), true, 1);
            payInfo.fMk = null;
        }
    }

    public boolean Wt() {
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kMk != null && this.kMk.isShown()) {
                Wq();
                return true;
            } else if (f()) {
                YC();
                showDialog(TbsLog.TBSLOG_CODE_SDK_BASE);
                return true;
            } else if (this.tQp != null && Wt()) {
                this.tQp.onMenuItemClick(null);
                return true;
            } else if (this.uYR != null) {
                this.uYR.onMenuItemClick(null);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final boolean Xf() {
        if (this.tQp != null) {
            this.tQp.onMenuItemClick(null);
            return true;
        } else if (this.uYR == null) {
            return super.Xf();
        } else {
            this.uYR.onMenuItemClick(null);
            return true;
        }
    }

    public Dialog onCreateDialog(int i) {
        x.i("MicroMsg.WalletBaseUI", "onCreateDialog id = " + i);
        switch (i) {
            case TbsLog.TBSLOG_CODE_SDK_BASE /*1000*/:
                int a;
                c af = com.tencent.mm.wallet_core.a.af(this);
                if (af != null) {
                    a = af.a((MMActivity) this, 1);
                } else {
                    a = -1;
                }
                if (a != -1) {
                    return h.a(this, true, getString(a), "", getString(com.tencent.mm.plugin.wxpay.a.i.app_yes), getString(com.tencent.mm.plugin.wxpay.a.i.app_no), new 4(this), new 5(this));
                }
                if (af != null) {
                    af.b(this, this.sy);
                } else {
                    finish();
                }
                return super.onCreateDialog(i);
            default:
                return super.onCreateDialog(i);
        }
    }

    public final void d(View view, int i, boolean z) {
        a(view, i, z, true);
    }

    public void a(View view, int i, boolean z, boolean z2) {
        a(view, i, z, true, z2);
    }

    @TargetApi(14)
    public final void a(View view, int i, boolean z, boolean z2, boolean z3) {
        a(view, null, i, z, z2, z3);
    }

    public final void a(View view, EditText editText, int i, boolean z, boolean z2, boolean z3) {
        EditText editText2;
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_num_keyboard);
        this.kMk = findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_keyboard_layout);
        View findViewById = findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_push_down);
        if (editText == null) {
            editText2 = (EditText) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.wallet_content);
        } else {
            editText2 = editText;
        }
        if (this.mKeyboard != null && editText2 != null && this.kMk != null) {
            OnFocusChangeListener onFocusChangeListener = null;
            if (z3) {
                onFocusChangeListener = editText2.getOnFocusChangeListener();
            }
            e.setNoSystemInputOnEditText(editText2);
            editText2.setOnFocusChangeListener(new 6(this, z, z2, view, editText2, i, onFocusChangeListener));
            editText2.setOnClickListener(new 7(this, z, i, editText2));
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    WalletBaseUI.this.Wq();
                }
            });
        }
    }

    public final boolean mM(boolean z) {
        if (uYQ == null || (!uYQ.bkT() && !z)) {
            return false;
        }
        this.uYO.a(uYQ, true);
        return true;
    }

    public static void cDI() {
        f.cDI();
    }

    public void Wq() {
        if (this.kMk != null && this.kMk.isShown()) {
            this.kMk.setVisibility(8);
            if (this.kTx != null) {
                this.kTx.fI(false);
            }
        }
    }

    public final void cDJ() {
        if (this.kMk != null && !this.kMk.isShown()) {
            this.kMk.setVisibility(0);
            if (this.kTx != null) {
                this.kTx.fI(true);
            }
        }
    }

    public final void Hb(int i) {
        this.mKeyboard.setXMode(i);
    }

    public final c cDK() {
        if (this.uYN == null) {
            this.uYN = com.tencent.mm.wallet_core.a.af(this);
        }
        return this.uYN;
    }

    public final g cDL() {
        if (this.uYP == null) {
            c cDK = cDK();
            if (cDK != null) {
                this.uYP = cDK.a((MMActivity) this, this.uYO);
            }
            if (this.uYP == null) {
                this.uYP = new 9(this, this, this.uYO);
            }
        }
        return this.uYP;
    }

    public final CharSequence cDM() {
        if (this.uYP == null) {
            return null;
        }
        return this.uYP.ui(0);
    }

    public void bMZ() {
        cDK().a((Activity) this, 0, this.sy);
    }

    public final void jr(int i) {
        this.uYO.jr(i);
    }

    public final void js(int i) {
        this.uYO.js(i);
    }

    public final void a(l lVar, boolean z, boolean z2) {
        c cDK = cDK();
        if (cDK != null) {
            this.uYO.sy = cDK.jfZ;
        }
        int i = 1;
        if (!z2) {
            i = 2;
        }
        this.uYO.a(lVar, z, i);
    }

    public final void aBy() {
        if (this.jhd == null || !(this.jhd == null || this.jhd.isShowing())) {
            if (this.jhd != null) {
                this.jhd.dismiss();
            }
            this.jhd = g.a(this, false, new 10(this));
        }
    }

    public final void bfe() {
        if (this.jhd != null) {
            this.jhd.dismiss();
        }
    }

    public void ux(int i) {
        super.ux(i);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("key_process_is_end", false) && !intent.getBooleanExtra("key_process_is_stay", true)) {
            setIntent(intent);
            Bundle extras = getIntent().getExtras();
            int i = (extras == null || !extras.containsKey("key_process_result_code")) ? 0 : extras.getInt("key_process_result_code", 0);
            if (i == -1) {
                x.i("MicroMsg.WalletBaseUI", "process end ok!");
                setResult(-1, getIntent());
            } else {
                x.i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : " + i);
                setResult(0, getIntent());
            }
            finish();
        }
    }

    public final void a(View view, View view2, int i) {
        if (view != null) {
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int fl = (a.fl(this) - r0) - a.fromDPToPix(this, i);
            x.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + view2.getHeight()), Integer.valueOf(a.fl(this)), Integer.valueOf(fl), Integer.valueOf(eCE)});
            if (fl > 0 && fl < eCE) {
                x.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(eCE - fl)});
                view.post(new 2(this, view, r0));
            }
        }
    }
}
