package com.tencent.mm.plugin.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
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
import com.tencent.d.b.f.f;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.e.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class o extends i implements c {
    private static HashMap<String, Boolean> pxW = new HashMap();
    public OnCancelListener DI;
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
    protected PayInfo mpb;
    protected a pcA = new a();
    public FavorPayInfo pfz = new FavorPayInfo();
    protected a pgk = null;
    public TextView pgv;
    public boolean pxA = false;
    protected boolean pxB = true;
    public Bankcard pxC = null;
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
    boolean pxP = false;
    public c pxU;
    public a pxV;
    public Button pxh;
    public ImageView pxi;
    public TextView pxj;
    public TextView pxk;
    public FavourLayout pxl;
    public CdnImageView pxm;
    public TextView pxn;
    public EditHintPasswdView pxo;
    public View pxq;
    public View pxr;
    public TextView pxs;
    public ImageView pxt;
    public TextView pxu;
    public TextView pxv;
    public View pxw;
    public TextView pxx;
    public OnClickListener pxz;

    private static class b implements OnCancelListener {
        private OnCancelListener pye;

        /* synthetic */ b(OnCancelListener onCancelListener, byte b) {
            this(onCancelListener);
        }

        private b(OnCancelListener onCancelListener) {
            this.pye = null;
            this.pye = onCancelListener;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            o.jy(false);
            if (this.pye != null) {
                this.pye.onCancel(dialogInterface);
            }
        }
    }

    public interface c {
        void a(String str, FavorPayInfo favorPayInfo, boolean z);
    }

    static /* synthetic */ boolean c(o oVar) {
        String str = "MicroMsg.WalletPwdDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!oVar.isPaused);
        x.i(str, str2, objArr);
        return !oVar.isPaused;
    }

    public o(Context context) {
        super(context, j.mmpwddialog);
        co(context);
    }

    public void co(Context context) {
        x.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
        et(context);
        eu(context);
        bQt();
    }

    public final void et(Context context) {
        this.hyK = View.inflate(context, bQz(), null);
        this.pxh = (Button) this.hyK.findViewById(a$f.mm_alert_ok_btn);
        this.pxi = (ImageView) this.hyK.findViewById(a$f.wallet_pwd_close_iv);
        this.mKeyboard = (MyKeyboardWindow) this.hyK.findViewById(a$f.tenpay_num_keyboard);
        this.kMk = this.hyK.findViewById(a$f.tenpay_keyboard_layout);
        this.mHZ = (TextView) this.hyK.findViewById(a$f.content);
        this.pxj = (TextView) this.hyK.findViewById(a$f.wallet_pwd_title_tv);
        this.mBQ = (TextView) this.hyK.findViewById(a$f.fee);
        this.pgv = (TextView) this.hyK.findViewById(a$f.origin_fee);
        this.pgv.getPaint().setFlags(16);
        this.pxk = (TextView) this.hyK.findViewById(a$f.bankcard_tv);
        this.pxl = (FavourLayout) this.hyK.findViewById(a$f.favour_tip);
        this.pxm = (CdnImageView) this.hyK.findViewById(a$f.bankcard_logo);
        this.pxq = this.hyK.findViewById(a$f.favor_ll);
        this.pxn = (TextView) this.hyK.findViewById(a$f.more_favors);
        this.eKk = (ImageView) this.hyK.findViewById(a$f.chatting_user_iv);
        this.pxr = this.hyK.findViewById(a$f.bankcard_layout);
        this.pxs = (TextView) this.hyK.findViewById(a$f.seperator);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.eKk, e.getUsername());
        this.pxo = (EditHintPasswdView) this.hyK.findViewById(a$f.input_et);
        this.pxt = (ImageView) this.hyK.findViewById(a$f.has_larger_favor_reddot);
        this.pxD = (TextView) this.hyK.findViewById(a$f.wallet_pay_mode_tv);
        this.pxE = this.hyK.findViewById(a$f.finger_print_layout);
        this.pxF = (TextView) this.hyK.findViewById(a$f.finger_print_tips);
        this.pxG = (ImageView) this.hyK.findViewById(a$f.finger_print_icon);
        this.pxu = (TextView) this.hyK.findViewById(a$f.charge_fee);
        this.pxv = (TextView) this.hyK.findViewById(a$f.random_offer_title);
        this.pxw = this.hyK.findViewById(a$f.favor_container);
        this.pxx = (TextView) this.hyK.findViewById(a$f.favors_desc);
        this.pxl.setVisibility(8);
    }

    @TargetApi(14)
    public void eu(Context context) {
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.pxh.setEnabled(false);
        this.pxh.setTextColor(context.getResources().getColorStateList(com.tencent.mm.plugin.wxpay.a.c.wallet_alert_btn_text_color));
        com.tencent.mm.wallet_core.ui.formview.a.a(this.pxo);
        this.pxo.setOnInputValidListener(new EditHintPasswdView.a() {
            public final void fE(boolean z) {
                if (z) {
                    o.this.bQv();
                    h.mEJ.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                }
            }
        });
        this.pxo.requestFocus();
        TextView textView = (TextView) this.hyK.findViewById(a$f.wallet_pwd_title_tv);
        if (textView != null) {
            textView.setText(v.hg(context));
        }
        EditText editText = (EditText) this.hyK.findViewById(a$f.wallet_content);
        e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            com.tencent.mm.ui.a.c cVar = new com.tencent.mm.ui.a.c();
            this.mKeyboard.setSecureAccessibility(cVar);
            editText.setAccessibilityDelegate(cVar);
        }
        editText.setOnClickListener(new 2(this));
        this.hyK.findViewById(a$f.tenpay_push_down).setOnClickListener(new 3(this));
    }

    private void bQt() {
        boolean z;
        x.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
        this.pxJ = 0;
        this.pxD.setVisibility(8);
        this.pxE.setVisibility(8);
        this.pxM = bi.VG();
        k kVar = (k) g.l(k.class);
        if (com.tencent.mm.plugin.wallet_core.model.o.bOW() == null || !kVar.aNa()) {
            z = true;
        } else {
            z = kVar.aNt();
        }
        x.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[]{Boolean.valueOf(z)});
        if ((this.mpb == null || !(this.mpb.qUM == 100000 || this.mpb.qUM == 100102)) && z) {
            if (this.mpb != null && this.mpb.qUM == 100001) {
                this.mpb.pxN = 1;
            }
            if (kVar == null || !kVar.aNh() || kVar.aNc()) {
                z = false;
            } else {
                z = true;
            }
            x.v("MicroMsg.WalletPwdDialog", "alvinluo isDeviceSupportFp: %b", new Object[]{Boolean.valueOf(z)});
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
                if (this.mpb != null) {
                    this.mpb.pxN = 1;
                }
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
                if (this.mpb != null) {
                    this.mpb.pxN = 0;
                }
                h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                e.He(8);
            } else {
                if (this.mpb != null) {
                    this.mpb.pxN = 0;
                }
                this.pxD.setVisibility(8);
                h.mEJ.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            }
            x.i("MicroMsg.WalletPwdDialog", "isOpenTouch:" + z2 + ",  isDeviceSupport:" + z + ", use_pay_touch:" + this.pxI + ", isForcePwdMode:" + bQw());
            this.pxD.setOnClickListener(new 4(this));
            return;
        }
        if (!this.kMk.isShown()) {
            this.kMk.setVisibility(0);
        }
        if (this.mpb != null) {
            this.mpb.pxN = 0;
            this.mpb.bQb = "";
            this.mpb.bQc = "";
        }
        this.pxE.setVisibility(0);
        this.pxF.setVisibility(0);
        TextView textView = this.pxF;
        int i = (this.mpb == null || this.mpb.qUM != 100102) ? com.tencent.mm.plugin.wxpay.a.i.wallet_finger_print_not_recorded : com.tencent.mm.plugin.wxpay.a.i.wallet_fingerprint_severe_error_hint;
        textView.setText(i);
        this.pxF.setTextColor(getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.wallet_pwd_bank_card_text_color));
        if (z) {
            this.pxr.setVisibility(8);
            this.pxs.setVisibility(8);
        } else {
            this.pxr.setVisibility(0);
            this.pxs.setVisibility(0);
        }
        if (this.mpb != null && this.mpb.qUM == 100102) {
            g.Ei().DT().a(aa.a.sQx, Boolean.valueOf(true));
            kVar.eZ(false);
            g.Ei().DT().a(aa.a.sQv, Boolean.valueOf(false));
        }
        h.mEJ.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
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
        this.mpb.pxN = 0;
        h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        e.He(29);
        bQh();
    }

    private void bQg() {
        com.tencent.mm.plugin.soter.c.a.bFf();
        lg lgVar = new lg();
        lgVar.bVz.bQa = this.mpb.bOd;
        lgVar.bVz.bVB = 1;
        lgVar.bVz.bVD = new 5(this, lgVar);
        com.tencent.mm.sdk.b.a.sFg.a(lgVar, Looper.getMainLooper());
    }

    private static void bQh() {
        x.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.sFg.m(new nd());
    }

    public int bQz() {
        return a$g.wallet_full_pwd_dialog;
    }

    private void jz(boolean z) {
        View findViewById = this.hyK.findViewById(a$f.bank_card_iv_un_read);
        if (findViewById == null) {
            return;
        }
        if (z) {
            findViewById.setVisibility(0);
            this.pxP = true;
            return;
        }
        findViewById.setVisibility(8);
        this.pxP = false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.DI != null) {
                this.DI.onCancel(this);
            }
            if (this.pxV != null) {
                this.pxV.blf();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.hyK);
        f.cFZ().cGa();
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.eWV = z;
        setCanceledOnTouchOutside(this.eWV);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + e.getMessage());
        }
        bQh();
        this.pcA.destory();
        if (this.jhg != null) {
            this.jhg.cancel();
        }
    }

    public final void Pu(String str) {
        this.mHZ.setText(str);
    }

    public final void d(String str, double d) {
        if (TextUtils.isEmpty(str)) {
            this.mBQ.setVisibility(8);
            this.pxB = true;
            jA(this.pxB);
            return;
        }
        this.mBQ.setVisibility(0);
        this.mBQ.setText(str);
        if (d == 0.0d) {
            this.pxB = false;
            jA(this.pxB);
            return;
        }
        this.pxB = true;
        jA(this.pxB);
    }

    private void Pv(String str) {
        if (TextUtils.isEmpty(str)) {
            x.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
            this.pxu.setVisibility(8);
            return;
        }
        this.pxu.setVisibility(0);
        this.pxu.setText(str);
    }

    public final void ff(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.pxn.setVisibility(8);
        } else {
            this.pxn.setVisibility(0);
            this.pxn.setText(str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.pxx.setVisibility(8);
            return;
        }
        this.pxx.setText(str);
        this.pxx.setVisibility(0);
    }

    public final void Pw(String str) {
        if (TextUtils.isEmpty(str)) {
            this.pgv.setVisibility(8);
            return;
        }
        this.pgv.setVisibility(0);
        this.pgv.setText(str);
    }

    private void g(Bankcard bankcard) {
        if (bankcard == null) {
            x.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
        } else if (bankcard.bOs()) {
            this.pxm.setImageResource(com.tencent.mm.plugin.wxpay.a.e.wallet_balance_manager_logo_small);
        } else if (bankcard.bOt()) {
            this.pcA.a(bankcard, this.pxm);
        } else if (bankcard.bOw()) {
            this.pxm.setImageDrawable(com.tencent.mm.svg.a.a.c(getContext().getResources(), a$h.honey_pay_bank_logo));
            if (!bi.oW(bankcard.pmk)) {
                this.pxm.setUseSdcardCache(true);
                this.pxm.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.bPR());
                this.pxm.cS(bankcard.pmk, a$h.honey_pay_bank_logo);
            }
        } else {
            this.pcA.a(getContext(), bankcard, this.pxm);
        }
    }

    public final void a(CharSequence charSequence, View.OnClickListener onClickListener, boolean z) {
        if (TextUtils.isEmpty(charSequence)) {
            this.pxr.setVisibility(8);
            this.pxs.setVisibility(8);
            return;
        }
        this.pxr.setOnClickListener(onClickListener);
        this.pxk.setText(charSequence);
        jA(this.pxB);
        if (z) {
            this.pxq.setVisibility(0);
        } else {
            this.pxq.setVisibility(8);
        }
    }

    private void jA(boolean z) {
        if (z) {
            this.pxr.setVisibility(0);
            this.pxs.setVisibility(0);
            return;
        }
        this.pxr.setVisibility(8);
        this.pxs.setVisibility(8);
    }

    public final void a(final Context context, final Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard) {
        this.pgk = b.psB.a(orders);
        if (orders == null || orders.ppg == null || orders.ppg.pdZ == null || orders.ppg.pdZ.size() <= 0 || this.pgk == null) {
            this.pxn.setVisibility(8);
            return;
        }
        if (favorPayInfo == null) {
            this.pfz = this.pgk.Pq(orders.ppg.pdY);
        } else {
            this.pfz = favorPayInfo;
        }
        this.pxn.setVisibility(0);
        if (this.pxr != null) {
            this.pxr.setTag(this.pfz);
        }
        this.pxC = bankcard;
        this.pxw.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.pxt.setVisibility(8);
                u.d(o.this.mpb == null ? 0 : o.this.mpb.bVY, o.this.mpb == null ? "" : o.this.mpb.bOd, 12, "");
                j.a(context, orders, o.this.pfz.pnP, new 1(this));
            }
        });
        Assert.assertNotNull(this.pgk);
        this.pxt.setVisibility(8);
    }

    public final void bQA() {
        if (this.pxh != null) {
            this.pxz = null;
            this.pxh.setOnClickListener(new 7(this));
        }
    }

    public void bQv() {
        jy(false);
        if (this.pxz != null) {
            this.pxz.onClick(this, 0);
        }
        dismiss();
        if (this.pxU != null) {
            this.pxU.a(this.pxo.getText(), this.pfz, this.pxA);
        }
        if (this.pxM < 0) {
            x.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
        } else if (this.pxH == 0) {
            h.mEJ.a(686, 0, 1, false);
            h.mEJ.a(686, 1, bi.bI(this.pxM), false);
        } else if (this.pxH == 1) {
            h.mEJ.a(686, 2, 1, false);
            h.mEJ.a(686, 3, bi.bI(this.pxM), false);
        }
    }

    public final void a(OnCancelListener onCancelListener) {
        if (this.pxi != null) {
            this.DI = onCancelListener;
            this.pxi.setVisibility(0);
            this.pxi.setOnClickListener(new 8(this, onCancelListener));
        }
    }

    public final void jB(boolean z) {
        if (z) {
            this.pxr.setVisibility(0);
        } else {
            this.pxr.setVisibility(8);
        }
    }

    public final void Px(String str) {
        if (bi.oW(str)) {
            this.pxv.setVisibility(8);
            return;
        }
        this.pxv.setText(str);
        this.pxv.setVisibility(0);
    }

    public final void bqn() {
        if (this.pxo != null) {
            this.pxo.bqn();
        }
    }

    public static o a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        return a(context, true, orders, favorPayInfo, bankcard, payInfo, null, cVar, onClickListener, onCancelListener);
    }

    public static o a(Context context, boolean z, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, String str, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (orders == null || orders.ppf == null || orders.ppf.size() <= 0) {
            return null;
        }
        String str2;
        String bb;
        double d;
        String str3;
        List bPV;
        String string;
        CharSequence charSequence;
        a a = b.psB.a(orders);
        String str4 = "MicroMsg.WalletPwdDialog";
        String str5 = "showAlert with favInfo %s bindSerial %s  bankcardType %s";
        Object[] objArr = new Object[3];
        objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
        if (bankcard == null) {
            str2 = "";
        } else {
            str2 = bankcard.field_bindSerial;
        }
        objArr[1] = str2;
        if (bankcard == null) {
            str2 = "";
        } else {
            str2 = bankcard.field_bankcardType;
        }
        objArr[2] = str2;
        x.i(str4, str5, objArr);
        if (a != null) {
            if (favorPayInfo != null && bankcard != null) {
                boolean z2;
                if (bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                x.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[]{favorPayInfo.pnP, Boolean.valueOf(z2)});
                bb = a.bb(favorPayInfo.pnP, z2);
                x.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[]{bb});
                Map hashMap = new HashMap();
                if (a.psv.pea != null && a.psv.pea.pek != null) {
                    List list = a.psv.pea.pek;
                    if (a.psx.containsKey(bb)) {
                        d = ((com.tencent.mm.plugin.wallet.a.h) a.psx.get(bb)).pen;
                    } else {
                        d = 0.0d;
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            break;
                        }
                        com.tencent.mm.plugin.wallet.a.h hVar = (com.tencent.mm.plugin.wallet.a.h) list.get(i2);
                        str4 = null;
                        if (bb.equals("0") && !hVar.equals("0")) {
                            str4 = hVar.pem;
                        } else if (hVar.pem.startsWith(bb) && !bb.equals(hVar.pem)) {
                            str4 = hVar.pem.replace(bb + "-", "");
                        }
                        String[] Po = a.Po(str4);
                        if (Po != null && Po.length > 0) {
                            q qVar = (q) a.psw.get(Po[0]);
                            if (qVar != null) {
                                Object obj;
                                if (qVar.peQ != 0) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null && qVar.peT.size() > 0) {
                                    Iterator it = qVar.peT.iterator();
                                    while (it.hasNext()) {
                                        String a2 = ab.a((com.tencent.mm.bk.b) it.next());
                                        a.a aVar = (a.a) hashMap.get(a2);
                                        if (aVar == null || hVar.pen > aVar.psy.pen) {
                                            aVar = new a.a();
                                            aVar.psy = hVar;
                                            aVar.lNT = qVar.lNT;
                                            aVar.psz = hVar.pen - d;
                                            aVar.psA = qVar.peR;
                                            hashMap.put(a2, aVar);
                                        }
                                    }
                                }
                            }
                        }
                        i = i2 + 1;
                    }
                } else {
                    x.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
                }
                a.a aVar2 = (a.a) hashMap.get(bankcard.field_bindSerial);
                a.a aVar3 = (a.a) a.ba(bb, true).get(bankcard.field_bankcardType);
                com.tencent.mm.plugin.wallet.a.h aZ = a.aZ(bb, z2);
                str3 = "MicroMsg.WalletPwdDialog";
                String str6 = "defaultComposeInfo %s wrapperSerial %s wrapper %s";
                Object[] objArr2 = new Object[3];
                objArr2[0] = aZ == null ? "" : aZ.pem;
                objArr2[1] = aVar2 == null ? "" : aVar2.toString();
                objArr2[2] = aVar3 == null ? "" : aVar3.toString();
                x.i(str3, str6, objArr2);
                if (aVar2 != null && aVar2.psy != null && !bi.oW(aVar2.psy.pem)) {
                    favorPayInfo.pnP = aVar2.psy.pem;
                } else if (aVar3 != null && aVar3.psy != null && !bi.oW(aVar3.psy.pem)) {
                    favorPayInfo.pnP = aVar3.psy.pem;
                } else if (aZ != null) {
                    favorPayInfo.pnP = aZ.pem;
                } else {
                    favorPayInfo.pnP = bb;
                }
            } else if (orders.ppg != null) {
                favorPayInfo = a.Pq(a.Pr(orders.ppg.pdY));
            }
            bPV = a.bPV();
        } else {
            x.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            bPV = null;
        }
        String str7 = "";
        str2 = payInfo.qUL == null ? "" : payInfo.qUL.getString("extinfo_key_19", "");
        com.tencent.mm.storage.ab Ye;
        int i3;
        if (!bi.oW(str2)) {
            str7 = str2;
        } else if (payInfo.bVY == 32 || payInfo.bVY == 33) {
            str2 = payInfo.qUL.getString("extinfo_key_5", "");
            str3 = payInfo.qUL.getString("extinfo_key_1", "");
            str5 = context.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_remittance_desc_txt);
            if (!bi.oW(str2)) {
                str5 = str2;
                str7 = str2;
            }
            if (bi.oW(str3)) {
                x.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                g.Ek();
                Ye = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(str3);
                if (Ye != null) {
                    objArr = new Object[1];
                    objArr[0] = e.acg(Ye.BL()) + (bi.oW(str) ? "" : "(" + str + ")");
                    str7 = bi.q(str5, objArr);
                } else {
                    x.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + str3);
                }
            }
        } else if (payInfo.bVY == 31) {
            str5 = payInfo.qUL.getString("extinfo_key_1", "");
            if (bi.oW(str5)) {
                x.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                g.Ek();
                Ye = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(str5);
                if (Ye != null) {
                    str2 = Ye.BK();
                    i3 = com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_remittance_desc_txt;
                    objArr = new Object[1];
                    objArr[0] = str2 + (bi.oW(str) ? "" : "(" + str + ")");
                    str7 = context.getString(i3, objArr);
                } else {
                    x.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + str5);
                }
            }
        } else if (payInfo.bVY == 42) {
            str5 = payInfo.qUL.getString("extinfo_key_1", "");
            if (bi.oW(str5)) {
                x.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                g.Ek();
                Ye = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(str5);
                if (Ye != null) {
                    str2 = Ye.BK();
                    i3 = com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_aa_desc_txt;
                    objArr = new Object[1];
                    objArr[0] = str2 + (bi.oW(str) ? "" : "(" + str + ")");
                    str7 = context.getString(i3, objArr);
                } else {
                    x.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + str5);
                }
            }
        } else if (payInfo.bVY == 48) {
            str7 = context.getString(com.tencent.mm.plugin.wxpay.a.i.qr_reward_grant_btn);
        } else if (payInfo.bVY == 49) {
            if (bi.oW(payInfo.qUL.getString("extinfo_key_1", ""))) {
                x.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[]{Integer.valueOf(payInfo.bVY)});
            } else {
                str7 = context.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_remittance_desc_txt, new Object[]{payInfo.qUL.getString("extinfo_key_1", "")});
            }
        }
        if (!bi.oW(str7) || orders == null || orders.ppf == null) {
            x.w("MicroMsg.WalletPwdDialog", "orders null?:" + (orders == null));
            str5 = str7;
        } else {
            Commodity commodity = (Commodity) orders.ppf.get(0);
            if (commodity != null) {
                str5 = commodity.lNK;
                Object obj2 = (payInfo == null || !(payInfo.bVY == 31 || payInfo.bVY == 32 || payInfo.bVY == 33)) ? null : 1;
                if (obj2 != null) {
                    if (!bi.oW(str5)) {
                        str5 = str5 + "\n";
                    }
                    str5 = str5 + commodity.desc;
                }
                if (bi.oW(str5)) {
                    str5 = commodity.desc;
                }
            }
            str5 = str7;
        }
        String str8 = null;
        bb = null;
        String str9 = null;
        str2 = null;
        d = orders.mBj;
        boolean z3 = false;
        if (a == null || favorPayInfo == null) {
            str4 = null;
        } else {
            com.tencent.mm.plugin.wallet.a.h Pn = a.Pn(favorPayInfo.pnP);
            if (Pn != null && Pn.pef > 0.0d) {
                z3 = true;
                bb = e.e(orders.mBj, orders.lNV);
                str8 = e.e(Pn.pee, orders.lNV);
                d = Pn.pdX;
                str9 = Pn.peh;
                if (pxW.containsKey(payInfo.bOd)) {
                    str4 = null;
                } else {
                    h.mEJ.h(14530, new Object[]{Integer.valueOf(3)});
                    str4 = null;
                }
            } else if (bPV == null || bPV.size() <= 0) {
                str8 = e.e(orders.mBj, orders.lNV);
                str4 = null;
            } else {
                str8 = e.e(Pn.pee, orders.lNV);
                z3 = true;
                str4 = context.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_pwd_dialog_more_favors);
            }
            if (!(Pn == null || Pn.peg == 0)) {
                str2 = Pn.pei;
                if (!bi.oW(str9)) {
                    str2 = "," + str2;
                }
            }
            if (!(bi.oW(str9) && bi.oW(r4))) {
                if (bi.oW(str4)) {
                    str4 = null;
                } else {
                    str4 = "," + str4;
                }
            }
        }
        if (orders.mxE > 0.0d) {
            Resources resources = context.getResources();
            int i4 = com.tencent.mm.plugin.wxpay.a.i.wallet_charge_fee_msg;
            Object[] objArr3 = new Object[1];
            objArr3[0] = e.e(orders.mxE, orders.lNV);
            string = resources.getString(i4, objArr3);
        } else {
            string = null;
        }
        if (bankcard == null) {
            charSequence = "";
        } else {
            charSequence = bankcard.field_desc;
        }
        if (bankcard.bOw()) {
            charSequence = com.tencent.mm.pluginsdk.ui.d.j.a(context, charSequence);
        }
        final o oVar = new o(context);
        oVar.a(context, orders, favorPayInfo, bankcard);
        oVar.jB(z);
        oVar.pxB = z;
        oVar.bQA();
        oVar.a((OnCancelListener) new b(onCancelListener, (byte) 0));
        oVar.setOnCancelListener(new b(onCancelListener, (byte) 0));
        oVar.setCancelable(true);
        oVar.Pu(str5);
        oVar.d(str8, d);
        oVar.Pw(bb);
        final PayInfo payInfo2 = payInfo;
        final View.OnClickListener onClickListener2 = onClickListener;
        oVar.a(charSequence, new View.OnClickListener() {
            public final void onClick(View view) {
                o.pxW.put(payInfo2.bOd, Boolean.valueOf(true));
                onClickListener2.onClick(view);
                if (oVar.pxP) {
                    h.mEJ.h(14530, new Object[]{Integer.valueOf(2)});
                }
            }
        }, z3);
        oVar.g(bankcard);
        boolean z4 = orders.ppd == 1;
        oVar.mpb = payInfo;
        oVar.pxI = z4;
        if (!com.tencent.mm.model.q.GS()) {
            oVar.bQt();
        }
        oVar.ff(str9, str4);
        str4 = orders.lNV;
        oVar.Px(str2);
        oVar.Pv(string);
        oVar.pxU = cVar;
        LinkedList a3 = a(bankcard, orders);
        if (oVar.pxl != null) {
            if (a3.size() > 0) {
                oVar.pxl.setWording(a3);
                oVar.pxl.setVisibility(0);
            } else {
                oVar.pxl.setVisibility(8);
            }
        }
        if (a(bankcard, orders, payInfo.bOd)) {
            oVar.jz(true);
            h.mEJ.h(14530, new Object[]{Integer.valueOf(1)});
        } else {
            oVar.jz(false);
        }
        oVar.show();
        com.tencent.mm.ui.base.h.a(context, oVar);
        return oVar;
    }

    private static LinkedList<String> a(Bankcard bankcard, Orders orders) {
        LinkedList<String> linkedList = new LinkedList();
        if (!(orders == null || orders.ppg == null || orders.ppg.pej == null)) {
            Iterator it = orders.ppg.pej.pdN.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wallet.a.b bVar = (com.tencent.mm.plugin.wallet.a.b) it.next();
                if (bVar.lMW.equals(bankcard.field_bindSerial)) {
                    it = bVar.pdP.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wallet.a.c cVar = (com.tencent.mm.plugin.wallet.a.c) it.next();
                        if (cVar.pdQ != 0) {
                            linkedList.add(cVar.mwP);
                        }
                    }
                    return linkedList;
                }
            }
        }
        return linkedList;
    }

    private static boolean a(Bankcard bankcard, Orders orders, String str) {
        if (pxW.containsKey(str) || orders.ppg == null || orders.ppg.pej == null) {
            return false;
        }
        boolean z;
        if (orders.ppg.pej.pdN.size() > 0) {
            Iterator it = orders.ppg.pej.pdN.iterator();
            z = false;
            while (it.hasNext()) {
                boolean z2;
                com.tencent.mm.plugin.wallet.a.b bVar = (com.tencent.mm.plugin.wallet.a.b) it.next();
                if (bVar.lMW == null || !bVar.lMW.equals(bankcard.field_bindSerial)) {
                    z2 = z;
                } else {
                    z2 = true;
                }
                z = z2;
            }
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        if (orders.ppg.pej.pdN.size() > 0) {
            return true;
        }
        if (orders.ppg.pej.pdO == null || orders.ppg.pej.pdO.pet.size() <= 0) {
            return false;
        }
        return true;
    }

    public static o a(Context context, String str, String str2, c cVar, OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        return a(context, str, str2, "", cVar, onCancelListener, aVar);
    }

    public static o a(Context context, String str, String str2, String str3, c cVar, OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        o oVar = new o(context);
        oVar.bQA();
        oVar.a(onCancelListener);
        oVar.setOnCancelListener(onCancelListener);
        oVar.setCancelable(true);
        oVar.Pu(str);
        if (TextUtils.isEmpty(str2)) {
            oVar.mBQ.setVisibility(8);
        } else {
            oVar.mBQ.setVisibility(0);
            oVar.mBQ.setText(str2);
        }
        oVar.pxB = true;
        oVar.jA(oVar.pxB);
        oVar.jB(false);
        oVar.pxB = false;
        oVar.pxV = aVar;
        oVar.Pv(str3);
        oVar.pxU = cVar;
        oVar.show();
        com.tencent.mm.ui.base.h.a(context, oVar);
        return oVar;
    }

    public static o a(Context context, String str, double d, String str2, Bankcard bankcard, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        boolean z = true;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        o oVar = new o(context);
        oVar.bQA();
        oVar.a(onCancelListener);
        oVar.setOnCancelListener(onCancelListener);
        oVar.setCancelable(true);
        oVar.Pu(str);
        oVar.d(e.e(d, str2), d);
        oVar.pxB = true;
        CharSequence charSequence = bankcard == null ? "" : bankcard.field_desc;
        oVar.g(bankcard);
        if (TextUtils.isEmpty(charSequence)) {
            z = false;
        }
        oVar.jB(z);
        if (bankcard != null) {
            oVar.a(charSequence, onClickListener, false);
        }
        oVar.pxU = cVar;
        oVar.show();
        com.tencent.mm.ui.base.h.a(context, oVar);
        return oVar;
    }

    public final void bPW() {
        this.isPaused = false;
        if (!com.tencent.mm.model.q.GS()) {
        }
    }

    public final void bPX() {
        this.isPaused = true;
        if (!com.tencent.mm.model.q.GS() && this.pxH == 1) {
            bQu();
        }
    }

    private static void jy(boolean z) {
        g.Ek();
        g.Ei().DT().a(aa.a.sQr, Boolean.valueOf(z));
    }

    private static boolean bQw() {
        g.Ek();
        Object obj = g.Ei().DT().get(aa.a.sQr, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }
}
