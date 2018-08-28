package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.e.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a$j;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;

public final class n extends i implements c {
    protected OnCancelListener DI;
    private String bOd;
    private String bVE = "";
    public ImageView eKk;
    protected boolean eWV;
    public View hyK;
    private boolean isPaused = false;
    private Animation jhg;
    private int jhh = 0;
    protected View kMk;
    public TextView mBQ;
    public TextView mHZ;
    protected MyKeyboardWindow mKeyboard;
    protected a pcA = new a();
    public TextView pgv;
    protected boolean pxA = false;
    protected boolean pxB = true;
    protected Bankcard pxC = null;
    public TextView pxD;
    public View pxE;
    public TextView pxF;
    public ImageView pxG;
    protected int pxH = 0;
    protected boolean pxI = false;
    private int pxJ = 0;
    private Animation pxK = null;
    private String pxL = "";
    private long pxM = -1;
    private int pxN = 0;
    private int pxO = 0;
    private boolean pxP = false;
    public Button pxh;
    public ImageView pxi;
    public TextView pxj;
    public TextView pxk;
    public FavourLayout pxl;
    public CdnImageView pxm;
    public TextView pxn;
    public EditHintPasswdView pxo;
    public b pxp;
    public View pxq;
    public View pxr;
    public TextView pxs;
    public ImageView pxt;
    public TextView pxu;
    public TextView pxv;
    public View pxw;
    public TextView pxx;
    protected a pxy;
    protected OnClickListener pxz;

    static /* synthetic */ void a(n nVar) {
        nVar.pxD.setText(nVar.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_pay_mode));
        nVar.pxH = 1;
        nVar.pxM = bi.VG();
        nVar.pxE.setVisibility(0);
        nVar.pxG.setVisibility(0);
        nVar.pxF.setVisibility(8);
        nVar.pxo.setVisibility(8);
        nVar.kMk.setVisibility(8);
        nVar.pxj.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_finger_print_titile);
        jy(false);
        nVar.pxN = 1;
        h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
        e.He(9);
    }

    static /* synthetic */ boolean c(n nVar) {
        String str = "MicroMsg.WalletPwdCustomDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!nVar.isPaused);
        x.i(str, str2, objArr);
        return !nVar.isPaused;
    }

    private n(Context context) {
        super(context, a$j.mmpwddialog);
        x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
        this.hyK = View.inflate(context, g.wallet_full_pwd_dialog, null);
        this.pxh = (Button) this.hyK.findViewById(f.mm_alert_ok_btn);
        this.pxi = (ImageView) this.hyK.findViewById(f.wallet_pwd_close_iv);
        this.mKeyboard = (MyKeyboardWindow) this.hyK.findViewById(f.tenpay_num_keyboard);
        this.kMk = this.hyK.findViewById(f.tenpay_keyboard_layout);
        this.mHZ = (TextView) this.hyK.findViewById(f.content);
        this.pxj = (TextView) this.hyK.findViewById(f.wallet_pwd_title_tv);
        this.mBQ = (TextView) this.hyK.findViewById(f.fee);
        this.pgv = (TextView) this.hyK.findViewById(f.origin_fee);
        this.pgv.getPaint().setFlags(16);
        this.pxk = (TextView) this.hyK.findViewById(f.bankcard_tv);
        this.pxl = (FavourLayout) this.hyK.findViewById(f.favour_tip);
        this.pxm = (CdnImageView) this.hyK.findViewById(f.bankcard_logo);
        this.pxq = this.hyK.findViewById(f.favor_ll);
        this.pxn = (TextView) this.hyK.findViewById(f.more_favors);
        this.eKk = (ImageView) this.hyK.findViewById(f.chatting_user_iv);
        this.pxr = this.hyK.findViewById(f.bankcard_layout);
        this.pxs = (TextView) this.hyK.findViewById(f.seperator);
        b.a(this.eKk, e.getUsername());
        this.pxo = (EditHintPasswdView) this.hyK.findViewById(f.input_et);
        this.pxt = (ImageView) this.hyK.findViewById(f.has_larger_favor_reddot);
        this.pxD = (TextView) this.hyK.findViewById(f.wallet_pay_mode_tv);
        this.pxE = this.hyK.findViewById(f.finger_print_layout);
        this.pxF = (TextView) this.hyK.findViewById(f.finger_print_tips);
        this.pxG = (ImageView) this.hyK.findViewById(f.finger_print_icon);
        this.pxu = (TextView) this.hyK.findViewById(f.charge_fee);
        this.pxv = (TextView) this.hyK.findViewById(f.random_offer_title);
        this.pxw = this.hyK.findViewById(f.favor_container);
        this.pxx = (TextView) this.hyK.findViewById(f.favors_desc);
        this.pxl.setVisibility(8);
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.pxh.setEnabled(false);
        this.pxh.setTextColor(context.getResources().getColorStateList(c.wallet_alert_btn_text_color));
        com.tencent.mm.wallet_core.ui.formview.a.a(this.pxo);
        this.pxo.setOnInputValidListener(new 1(this));
        this.pxo.requestFocus();
        TextView textView = (TextView) this.hyK.findViewById(f.wallet_pwd_title_tv);
        if (textView != null) {
            textView.setText(v.hg(context));
        }
        EditText editText = (EditText) this.hyK.findViewById(f.wallet_content);
        e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            com.tencent.mm.ui.a.c cVar = new com.tencent.mm.ui.a.c();
            this.mKeyboard.setSecureAccessibility(cVar);
            editText.setAccessibilityDelegate(cVar);
        }
        editText.setOnClickListener(new 2(this));
        this.hyK.findViewById(f.tenpay_push_down).setOnClickListener(new 3(this));
        bQt();
    }

    private void bQt() {
        boolean z;
        x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
        this.pxJ = 0;
        this.pxD.setVisibility(8);
        this.pxE.setVisibility(8);
        this.pxM = bi.VG();
        k kVar = (k) com.tencent.mm.kernel.g.l(k.class);
        if (o.bOW() == null || !kVar.aNa()) {
            z = true;
        } else {
            z = kVar.aNt();
        }
        x.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[]{Boolean.valueOf(z)});
        this.pxN = 0;
        this.bVE = "";
        if (kVar == null || !kVar.aNh() || kVar.aNc()) {
            z = false;
        } else {
            z = true;
        }
        x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[]{Boolean.valueOf(z)});
        boolean z2 = kVar != null && kVar.aNa();
        if (z2 && z && this.pxI && !bQw()) {
            this.pxD.setVisibility(0);
            this.pxD.setText(getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_pay_mode));
            this.pxH = 1;
            this.pxE.setVisibility(0);
            this.pxG.setVisibility(0);
            this.pxo.setVisibility(8);
            this.kMk.setVisibility(8);
            this.pxj.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_finger_print_titile);
            this.pxN = 1;
            bQg();
            h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (z2 && z && this.pxI && bQw()) {
            this.pxD.setText(getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_finger_print_pay_mode));
            this.pxD.setVisibility(0);
            this.pxH = 0;
            this.pxE.setVisibility(8);
            this.pxo.setVisibility(0);
            if (!this.kMk.isShown()) {
                this.kMk.setVisibility(0);
            }
            this.pxj.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_titile);
            this.pxN = 0;
            this.bVE = "";
            h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            e.He(8);
        } else {
            this.pxN = 0;
            this.bVE = "";
            this.pxD.setVisibility(8);
            h.mEJ.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        }
        x.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + z2 + ",  isDeviceSupport:" + z + ", use_pay_touch:" + this.pxI + ", isForcePwdMode:" + bQw());
        this.pxD.setOnClickListener(new 4(this));
    }

    private void bQu() {
        this.pxD.setText(getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_finger_print_pay_mode));
        this.pxH = 0;
        this.pxM = bi.VG();
        this.pxE.setVisibility(8);
        this.pxo.setVisibility(0);
        if (!this.kMk.isShown()) {
            this.kMk.setVisibility(0);
        }
        this.pxj.setText(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_titile);
        jy(true);
        this.pxN = 0;
        this.bVE = "";
        h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        e.He(29);
        bQh();
    }

    private void bQg() {
        x.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[]{bi.cjd().toString()});
        com.tencent.mm.plugin.soter.c.a.bFf();
        lg lgVar = new lg();
        lgVar.bVz.bQa = this.bOd;
        lgVar.bVz.bVB = 1;
        lgVar.bVz.bVD = new 5(this, lgVar);
        com.tencent.mm.sdk.b.a.sFg.a(lgVar, Looper.getMainLooper());
    }

    private static void bQh() {
        x.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.sFg.m(new nd());
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.DI != null) {
                this.DI.onCancel(this);
            }
            if (this.pxy != null) {
                this.pxy.blf();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.hyK);
        com.tencent.d.b.f.f.cFZ().cGa();
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.eWV = z;
        setCanceledOnTouchOutside(this.eWV);
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + e.getMessage());
        }
        bQh();
        this.pcA.destory();
        if (this.jhg != null) {
            this.jhg.cancel();
        }
    }

    protected final void bQv() {
        jy(false);
        if (this.pxz != null) {
            this.pxz.onClick(this, 0);
        }
        dismiss();
        if (this.pxp != null) {
            x.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[]{Integer.valueOf(this.pxN), this.bVE});
            this.pxp.c(this.pxo.getText(), this.pxN == 1, this.bVE);
        }
        if (this.pxM < 0) {
            x.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
        } else if (this.pxH == 0) {
            h.mEJ.a(686, 0, 1, false);
            h.mEJ.a(686, 1, bi.bI(this.pxM), false);
        } else if (this.pxH == 1) {
            h.mEJ.a(686, 2, 1, false);
            h.mEJ.a(686, 3, bi.bI(this.pxM), false);
        }
    }

    public static n a(Context context, String str, String str2, String str3, boolean z, b bVar, OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        n nVar = new n(context);
        if (nVar.pxh != null) {
            nVar.pxz = null;
            nVar.pxh.setOnClickListener(new 6(nVar));
        }
        if (nVar.pxi != null) {
            nVar.DI = onCancelListener;
            nVar.pxi.setVisibility(0);
            nVar.pxi.setOnClickListener(new 7(nVar, onCancelListener));
        }
        nVar.setOnCancelListener(onCancelListener);
        nVar.setCancelable(true);
        nVar.mHZ.setText(str);
        if (TextUtils.isEmpty(str2)) {
            nVar.mBQ.setVisibility(8);
        } else {
            nVar.mBQ.setVisibility(0);
            nVar.mBQ.setText(str2);
        }
        nVar.pxr.setVisibility(8);
        nVar.pxB = false;
        nVar.pxy = aVar;
        if (TextUtils.isEmpty(str3)) {
            x.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
            nVar.pxu.setVisibility(8);
        } else {
            nVar.pxu.setVisibility(0);
            nVar.pxu.setText(str3);
        }
        nVar.pxp = bVar;
        nVar.pxI = z;
        if (!q.GS()) {
            nVar.bQt();
        }
        nVar.show();
        com.tencent.mm.ui.base.h.a(context, nVar);
        return nVar;
    }

    public final void bPW() {
        this.isPaused = false;
        if (!q.GS()) {
        }
    }

    public final void bPX() {
        this.isPaused = true;
        if (!q.GS() && this.pxH == 1) {
            bQu();
        }
    }

    private static void jy(boolean z) {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sQr, Boolean.valueOf(z));
    }

    private static boolean bQw() {
        com.tencent.mm.kernel.g.Ek();
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQr, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }
}
