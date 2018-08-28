package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.collect.b.d;
import com.tencent.mm.plugin.collect.b.d.a;
import com.tencent.mm.plugin.collect.b.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.protocal.c.att;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.e$a;
import com.tencent.mm.ui.widget.a.e$b;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class CollectMainUI extends WalletPreferenceUI implements a, aw.a {
    private static int hYJ = -1;
    private static int hYK = -1;
    private static int hYL = -1;
    private static int hYM = -1;
    private static int hYq;
    private int cdM;
    private f gua = null;
    protected ScrollView hVW = null;
    private Vibrator hXL;
    private ImageView hXM = null;
    private TextView hXN = null;
    private WalletTextView hXO = null;
    private TextView hXP = null;
    private TextView hXQ = null;
    private TextView hXR = null;
    private View hXS = null;
    private TextView hXT = null;
    private Dialog hXU = null;
    private View hXV = null;
    private View hXW = null;
    private boolean hXX = false;
    private View hXY = null;
    private ImageView hXZ;
    private long hXx;
    protected CdnImageView hYA;
    protected TextView hYB;
    protected TextView hYC;
    protected ImageView hYD;
    protected ViewGroup hYE;
    protected View hYF;
    private int hYG = 0;
    private att hYH;
    private y.a hYI = new 12(this);
    private TextView hYa;
    private TextView hYb;
    private TextView hYc;
    protected TextView hYd;
    private RelativeLayout hYe;
    private Bitmap hYf = null;
    protected String hYg = null;
    protected String hYh = null;
    protected String hYi = null;
    private String hYj = null;
    private List<a> hYk = new LinkedList();
    private double hYl;
    private String hYm = null;
    private String hYn = null;
    protected boolean hYo = false;
    private long hYp;
    private View hYr;
    private b hYs = new b(this, (byte) 0);
    private SpannableStringBuilder hYt;
    private SpannableStringBuilder hYu;
    private com.tencent.mm.plugin.collect.b.f hYv;
    private int hYw = 0;
    private String hYx;
    private String hYy;
    private String hYz;

    static /* synthetic */ void cn(String str, String str2) {
        if (!bi.oW(str)) {
            qu quVar = new qu();
            quVar.cbq.userName = str;
            quVar.cbq.cbs = bi.aG(str2, "");
            quVar.cbq.scene = 1072;
            quVar.cbq.cbt = 0;
            com.tencent.mm.sdk.b.a.sFg.m(quVar);
        }
    }

    static /* synthetic */ void v(CollectMainUI collectMainUI) {
        collectMainUI.hXx &= -32769;
        g.Ek();
        g.Ei().DT().set(147457, Long.valueOf(collectMainUI.hXx));
        aup aup = new aup();
        aup.mEc = 2;
        ((i) g.l(i.class)).FQ().b(new h.a(209, aup));
        com.tencent.mm.plugin.collect.a.a.aBC().aBG();
    }

    static /* synthetic */ void w(CollectMainUI collectMainUI) {
        collectMainUI.hXx |= 32768;
        g.Ek();
        g.Ei().DT().set(147457, Long.valueOf(collectMainUI.hXx));
        aup aup = new aup();
        aup.mEc = 1;
        ((i) g.l(i.class)).FQ().b(new h.a(209, aup));
        com.tencent.mm.plugin.collect.a.a.aBC().aBF();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        lF(getResources().getColor(c.CollectMainBgColor));
        lC(true);
        cqh();
        g.Ek();
        this.cdM = ((Integer) g.Ei().DT().get(aa.a.sTs, Integer.valueOf(0))).intValue();
        this.hXx = q.GK();
        int intExtra = getIntent().getIntExtra("key_from_scene", 1);
        com.tencent.mm.plugin.report.service.h.mEJ.h(14021, new Object[]{Integer.valueOf(2), Integer.valueOf(intExtra)});
        g.Ek();
        boolean equals = ((String) g.Ei().DT().get(327731, "0")).equals("0");
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.slide_right_in, com.tencent.mm.plugin.wxpay.a.a.slide_left_out);
        if (equals) {
            com.tencent.mm.ui.base.h.a(this.mController.tml, q.GS() ? com.tencent.mm.plugin.wxpay.a.i.collect_main_first_enter_tips_payu : com.tencent.mm.plugin.wxpay.a.i.collect_main_first_enter_tips, com.tencent.mm.plugin.wxpay.a.i.collect_main_first_enter_tips_title, new 1(this));
            g.Ek();
            g.Ei().DT().set(327731, "1");
            g.Ek();
            g.Ei().DT().lm(true);
        }
        com.tencent.mm.plugin.collect.a.a.aBC();
        d aBD = com.tencent.mm.plugin.collect.a.a.aBD();
        if (!aBD.htB.contains(this)) {
            aBD.htB.add(this);
        }
        initView();
        aCk();
        aoV();
        this.hXL = (Vibrator) getSystemService("vibrator");
        this.hYp = bi.VE();
        if (hYJ < 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            hYJ = (displayMetrics.widthPixels / 2) - b.b(this.mController.tml, 20.0f);
            hYK = b.b(this.mController.tml, 60.0f);
            hYL = b.b(this.mController.tml, 40.0f);
            hYM = b.b(this.mController.tml, 70.0f);
        }
        aCp();
        com.tencent.mm.wallet_core.c.q.fu(16, 0);
    }

    protected void onDestroy() {
        if (this.hXM != null) {
            this.hXM.setImageBitmap(null);
        }
        Bitmap bitmap = this.hYf;
        if (!(bitmap == null || bitmap.isRecycled())) {
            x.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[]{bitmap});
            bitmap.recycle();
        }
        if (this.hXU != null) {
            this.hXU.dismiss();
        }
        com.tencent.mm.plugin.collect.a.a.aBC();
        com.tencent.mm.plugin.collect.a.a.aBD().htB.remove(this);
        this.hXL.cancel();
        if (this.hYv != null) {
            com.tencent.mm.plugin.collect.b.f fVar = this.hYv;
            for (Entry entry : fVar.diQ.entrySet()) {
                x.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
                g.Ek();
                g.Eh().dpP.c((l) entry.getKey());
            }
            fVar.diQ.clear();
            g.Ek();
            g.Eh().dpP.b(1588, fVar);
        }
        y.c(this.hYI);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(com.tencent.mm.plugin.wxpay.a.i.offline_collect_btn_text);
        setBackBtn(new 14(this));
        this.gua = this.tCL;
        this.hXS = findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_receive_area);
        this.hYF = findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_receive_area_1);
        this.hXO = (WalletTextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_fixed_fee);
        this.hXN = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_fixed_desc);
        this.hXP = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_fixed_fee_currency);
        this.hXQ = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_receice_amount);
        this.hYd = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.banner_tips);
        this.hXV = (RelativeLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_qrcode_area);
        this.hXW = findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_header_divider);
        this.hYr = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.collect_main_footer, null, false);
        this.hXR = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_save_qrcode);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(com.tencent.mm.plugin.wxpay.a.i.collect_main_save_qrcode));
        spannableStringBuilder.setSpan(new m(new 15(this)), 0, spannableStringBuilder.length(), 18);
        this.hXR.setText(spannableStringBuilder);
        this.hXR.setClickable(true);
        this.hXR.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
        this.kww.addFooterView(this.hYr, null, false);
        this.kww.setFooterDividersEnabled(false);
        this.hXM = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_ftf_pay_qrcode);
        this.hXT = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_tips);
        this.hYc = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_set_money_tv);
        this.hYc.setClickable(true);
        this.hYc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
        this.hYt = new SpannableStringBuilder(getString(com.tencent.mm.plugin.wxpay.a.i.collect_main_fixed));
        this.hYu = new SpannableStringBuilder(getString(com.tencent.mm.plugin.wxpay.a.i.collect_main_fixed_cancel));
        m mVar = new m(new 16(this));
        m mVar2 = new m(new 17(this));
        this.hYt.setSpan(mVar, 0, this.hYt.length(), 18);
        if (com.tencent.mm.ui.a.a.a.cqX().cqW()) {
            this.hYc.setOnClickListener(new 18(this, mVar, mVar2));
        }
        this.hYu.setSpan(mVar2, 0, this.hYu.length(), 18);
        this.hYc.setText(this.hYt);
        this.hYe = (RelativeLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_menu_more_btn_layout);
        this.hXM.setOnLongClickListener(new 19(this));
        this.hXY = findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_receive_toast);
        this.hXZ = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_receive_toast_avatar);
        this.hYa = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_receive_toast_name);
        this.hYb = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_receive_toast_fee);
        this.hYA = (CdnImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_assist_icon);
        this.hYB = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_assist_title);
        this.hYC = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_assist_wording);
        this.hYD = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_assist_red_dot);
        this.hYE = (ViewGroup) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_assist_layout);
        this.hXV.postDelayed(new 20(this), 300);
        sy syVar = new sy();
        syVar.cdO.buF = "8";
        syVar.bJX = new 2(this, syVar);
        com.tencent.mm.sdk.b.a.sFg.m(syVar);
    }

    private void ed(boolean z) {
        if (this.hYf == null || this.hYf.isRecycled()) {
            x.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
            Toast.makeText(this.mController.tml, getString(com.tencent.mm.plugin.wxpay.a.i.collect_qrcode_save_failed), 1).show();
        } else {
            Object obj;
            Bitmap a = com.tencent.mm.plugin.collect.b.b.a(this, this.hYg, q.GF(), this.hYw, this.hYz, b.b(this, 197.0f), this.hYI, false);
            if (a == null || a.isRecycled()) {
                obj = null;
            } else {
                int i;
                if (this.hYo) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11343, new Object[]{Integer.valueOf(1), Integer.valueOf((int) Math.round(this.hYl * 100.0d))});
                } else {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11343, new Object[]{Integer.valueOf(0)});
                }
                if (this.hXX) {
                    i = 0;
                } else {
                    this.hVW = (ScrollView) ((ViewStub) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_save_view_stub)).inflate();
                    aCn();
                    this.hXX = true;
                    i = 250;
                }
                this.hVW.setVisibility(4);
                ((ImageView) this.hVW.findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_save_ftf_pay_qrcode)).setImageBitmap(this.hYf);
                TextView textView = (TextView) this.hVW.findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_save_receiver_1);
                TextView textView2 = (TextView) this.hVW.findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_save_receiver_2);
                LinearLayout linearLayout = (LinearLayout) this.hVW.findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_save_root_layout);
                LinearLayout linearLayout2 = (LinearLayout) this.hVW.findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_save_fixed_ll);
                TextView textView3 = (TextView) this.hVW.findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_save_fixed_currency);
                TextView textView4 = (TextView) this.hVW.findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_save_fixed_desc);
                TextView textView5 = (TextView) this.hVW.findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_save_fixed_fee);
                CharSequence dx = e.dx(e.gT(q.GF()), 10);
                if (!bi.oW(aCl())) {
                    dx = dx + getString(com.tencent.mm.plugin.wxpay.a.i.collect_main_save_bottom_tips2, new Object[]{r9});
                }
                if (this.hYw != 1) {
                    textView.setText(j.a(this, dx, textView.getTextSize()));
                } else if (bi.oW(this.hYy)) {
                    textView.setText(j.a(this, dx, textView.getTextSize()));
                } else {
                    textView.setText(this.hYy);
                    textView2.setText(j.a(this, dx, textView2.getTextSize()));
                    textView2.setVisibility(0);
                }
                if (this.hYo) {
                    if (bi.oW(this.hYn)) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setText(this.hYn);
                        textView4.setVisibility(0);
                    }
                    textView3.setText(aCm());
                    textView5.setText(e.A(this.hYl));
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout2.setVisibility(8);
                }
                ah.i(new 5(this, linearLayout, z), (long) i);
                obj = 1;
            }
            if (obj == null) {
                Toast.makeText(this.mController.tml, getString(com.tencent.mm.plugin.wxpay.a.i.collect_qrcode_save_failed), 1).show();
            }
        }
        this.tCL.notifyDataSetChanged();
    }

    protected final void aoV() {
        if (bi.oW(this.hYg)) {
            x.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
            return;
        }
        if (this.hYw == 1) {
            if (!bi.oW(this.hYx)) {
                this.hXT.setText(this.hYx);
            }
            if (!bi.oW(this.hYy)) {
                TextView textView = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_hk_tips);
                textView.setText(this.hYy);
                textView.setVisibility(0);
            }
        }
        aCo();
        aCq();
        com.tencent.mm.protocal.c.aw bOL = com.tencent.mm.plugin.wallet_core.model.i.bOL();
        int i = this.hYo ? 33 : 32;
        if (bOL != null) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(13447, new Object[]{Integer.valueOf(i), bOL.raZ, bOL.rba, this.hYg, Double.valueOf(this.hYl), Long.valueOf(bi.VE()), Long.valueOf(bOL.raY), bOL.rbb, bOL.rbc});
        }
    }

    protected void aCo() {
        this.hXM.setImageBitmap(null);
        if (this.hYo) {
            if (bi.oW(this.hYj)) {
                x.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
                return;
            }
            this.hYf = yF(this.hYj);
        } else if (bi.oW(this.hYg)) {
            x.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
            return;
        } else {
            this.hYf = yF(this.hYg);
        }
        if (this.hYf == null || this.hYf.isRecycled()) {
            x.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bi.oV(this.hYj));
        } else {
            this.hXM.setImageBitmap(this.hYf);
        }
        if (this.hYo) {
            this.hXO.setPrefix(aCm());
            this.hXO.setText(e.A(this.hYl));
            this.hXO.setVisibility(0);
            if (bi.oW(this.hYn)) {
                this.hXN.setVisibility(8);
            } else {
                this.hXN.setText(j.a(this.mController.tml, this.hYn, this.hXN.getTextSize()));
                this.hXN.setVisibility(0);
            }
            findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_fixed_layout).setVisibility(0);
            return;
        }
        this.hXP.setVisibility(8);
        this.hXO.setVisibility(8);
        this.hXN.setVisibility(8);
        findViewById(com.tencent.mm.plugin.wxpay.a.f.collect_main_fixed_layout).setVisibility(8);
    }

    private void aCp() {
        getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(CollectMainUI.this.mController.tml, 37);
                ViewGroup.LayoutParams layoutParams = CollectMainUI.this.hYr.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fromDPToPix;
                    CollectMainUI.this.hYr.setLayoutParams(layoutParams);
                    CollectMainUI.this.hYr.requestLayout();
                }
            }
        });
    }

    private void aCq() {
        double d;
        if (this.hYk == null || this.hYk.size() <= 0) {
            d = 0.0d;
        } else {
            this.hXV.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.collect_header_top_corner);
            this.gua.removeAll();
            d = 0.0d;
            for (int i = 0; i < this.hYk.size(); i++) {
                c cVar;
                a aVar = (a) this.hYk.get(i);
                String valueOf = String.valueOf(i);
                if (i == this.hYk.size() - 1) {
                    cVar = new c(this, com.tencent.mm.plugin.wxpay.a.g.collect_pay_info_bottom_corner_preference);
                } else {
                    cVar = new c(this);
                }
                cVar.setKey(valueOf);
                valueOf = aVar.daA;
                if (bi.oW(valueOf) && !bi.oW(aVar.username)) {
                    valueOf = e.gT(aVar.username);
                }
                cVar.cZH = valueOf;
                cVar.cYO = aVar.username;
                if (aVar.status == 0) {
                    cVar.setSummary(com.tencent.mm.plugin.wxpay.a.i.collect_main_paying);
                } else if (aVar.status == 1) {
                    if (aVar.hDh) {
                        d += aVar.hUL;
                        cVar.setSummary(e.e(aVar.hUL, aVar.bJg));
                    } else {
                        cVar.setSummary(com.tencent.mm.plugin.wxpay.a.i.collect_main_pay_suc);
                    }
                    this.gua.a(cVar);
                } else if (aVar.status == 2) {
                    cVar.setSummary(com.tencent.mm.plugin.wxpay.a.i.collect_main_pay_cancel);
                }
                this.gua.a(cVar);
            }
            this.gua.notifyDataSetChanged();
            this.hXQ.setText(e.e(d, ((a) this.hYk.get(0)).bJg));
            this.hXQ.setVisibility(0);
        }
        if (this.hYk == null || this.hYk.size() <= 0) {
            this.hXQ.setVisibility(8);
            this.hXS.setVisibility(8);
            this.hXW.setVisibility(8);
            return;
        }
        this.hYE.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.collect_main_assist_bg);
        this.hXS.setVisibility(0);
        if (d > 0.0d && this.hYk.size() > 0) {
            this.hYF.setVisibility(0);
            this.hXW.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.collect_main;
    }

    public final int Ys() {
        return com.tencent.mm.plugin.wxpay.a.l.collect_main_preference;
    }

    public final int auY() {
        return com.tencent.mm.plugin.wxpay.a.g.collect_main_header;
    }

    public boolean h(int i, int i2, String str, l lVar) {
        return false;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    private Bitmap yF(String str) {
        return com.tencent.mm.plugin.collect.b.b.a(this, str, q.GF(), this.hYw, this.hYz, this.hYI, false);
    }

    public final void b(t tVar) {
        Object obj = null;
        x.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
        if (((this.cdM == 1 || this.cdM == 0) && tVar.msgType == 9) || (this.cdM == 8 && tVar.msgType == 26)) {
            if (this.hXL != null) {
                this.hXL.vibrate(50);
            }
            if (((long) tVar.timestamp) < this.hYp) {
                x.d("MicroMsg.CollectMainUI", "Recieve but time out ");
                return;
            }
            Object obj2;
            int i = 0;
            while (i < this.hYk.size()) {
                if (tVar.status == 0 && bi.oV(tVar.username).equals(((a) this.hYk.get(i)).username) && ((a) this.hYk.get(i)).status == 2) {
                    this.hYk.remove(i);
                    this.hYk.add(i, new a(this, tVar));
                    obj2 = 1;
                    break;
                } else if (tVar.bOe.equals(((a) this.hYk.get(i)).bOe)) {
                    x.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + tVar.bOe);
                    if (((a) this.hYk.get(i)).status == 0) {
                        ((a) this.hYk.get(i)).status = tVar.status;
                        ((a) this.hYk.get(i)).hUL = tVar.hUL;
                        ((a) this.hYk.get(i)).bJg = tVar.bJg;
                        if (tVar.status == 1) {
                            a aVar = (a) this.hYk.get(i);
                            this.hYs.hYY.add(aVar);
                        }
                    }
                    int obj22 = 1;
                } else {
                    i++;
                }
            }
            obj22 = null;
            if (obj22 == null) {
                for (i = 0; i < this.hYk.size(); i++) {
                    if (tVar.timestamp > ((t) this.hYk.get(i)).timestamp) {
                        this.hYk.add(i, new a(this, tVar));
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    this.hYk.add(new a(this, tVar));
                }
            }
            ah.A(new 4(this));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case GLIcon.LEFT /*4096*/:
                if (i2 != -1 || intent == null) {
                    this.hYo = false;
                } else {
                    this.hYj = intent.getStringExtra("ftf_pay_url");
                    this.hYl = intent.getDoubleExtra("ftf_fixed_fee", 0.0d);
                    this.hYm = intent.getStringExtra("ftf_fixed_fee_type");
                    this.hYn = intent.getStringExtra("ftf_fixed_desc");
                    this.hYi = intent.getStringExtra("key_currency_unit");
                    this.hYc.setText(this.hYu);
                    this.hYo = true;
                }
                aoV();
                aCp();
                return;
            case 4097:
                this.hXx = q.GK();
                return;
            default:
                return;
        }
    }

    protected void onResume() {
        super.onResume();
        aw.a(this, this);
    }

    protected void onPause() {
        super.onPause();
        aw.a(this, null);
    }

    public final void aou() {
        x.i("MicroMsg.CollectMainUI", "do screen shot");
        com.tencent.mm.plugin.report.service.h.mEJ.h(13944, new Object[]{Integer.valueOf(9)});
        if (this.hYG == 1) {
            e$a e_a = new e$a(this.mController.tml);
            e$a abA = e_a.abA(getString(com.tencent.mm.plugin.wxpay.a.i.collect_material_guide_screen_shot_text));
            abA.qIF.uJP.uIH = true;
            abA.uKv = true;
            abA.uKu = getString(com.tencent.mm.plugin.wxpay.a.i.collect_material_guide_apply_text);
            abA.uKt = getString(com.tencent.mm.plugin.wxpay.a.i.collect_material_guide_save_text);
            abA.qIF.uJP.uJn = getResources().getColor(c.normal_text_color);
            abA.qIF.mF(true);
            abA.qIF.mG(true);
            abA.a(new e$b() {
                public final void b(boolean z, String str) {
                    if (CollectMainUI.this.hYH != null) {
                        CollectMainUI.cn(CollectMainUI.this.hYH.username, CollectMainUI.this.hYH.rWY);
                        com.tencent.mm.plugin.report.service.h.mEJ.h(15387, new Object[]{Integer.valueOf(3)});
                    }
                }
            }, new e$b() {
                public final void b(boolean z, String str) {
                    CollectMainUI.this.ed(true);
                }
            });
            e_a.eIW.show();
            return;
        }
        com.tencent.mm.ui.base.h.a(this.mController.tml, getString(com.tencent.mm.plugin.wxpay.a.i.collect_main_screen_shot_tips), "", getString(com.tencent.mm.plugin.wxpay.a.i.collect_main_screen_shot_save_btn_text), getString(com.tencent.mm.plugin.wxpay.a.i.app_cancel), false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                CollectMainUI.this.ed(true);
                com.tencent.mm.plugin.report.service.h.mEJ.h(13944, new Object[]{Integer.valueOf(10)});
            }
        }, new 9(this));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.slide_left_in, com.tencent.mm.plugin.wxpay.a.a.slide_right_out);
    }

    protected void aCk() {
        if (com.tencent.mm.plugin.collect.b.f.hTN == null) {
            com.tencent.mm.plugin.collect.b.f.hTN = new com.tencent.mm.plugin.collect.b.f();
        }
        this.hYv = com.tencent.mm.plugin.collect.b.f.hTN;
        com.tencent.mm.plugin.collect.b.f fVar = this.hYv;
        g.Ek();
        g.Eh().dpP.a(1588, fVar);
        com.tencent.mm.plugin.collect.b.f fVar2 = this.hYv;
        10 10 = new 10(this);
        g.Ek();
        String str = (String) g.Ei().DT().get(aa.a.sYo, "");
        g.Ek();
        String str2 = (String) g.Ei().DT().get(aa.a.sYp, "");
        if (bi.oW(str)) {
            x.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
            str = o.bOW().bPv();
        }
        10.cl(str, str2);
        com.tencent.mm.plugin.collect.b.l lVar = new com.tencent.mm.plugin.collect.b.l();
        fVar2.diQ.put(lVar, 10);
        g.Ek();
        g.Eh().dpP.a(lVar, 0);
    }

    private static atm aCr() {
        try {
            g.Ek();
            return I(new JSONObject((String) g.Ei().DT().get(aa.a.sYq, "")));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
            return null;
        }
    }

    private static List<atm> aCs() {
        List<atm> arrayList = new ArrayList();
        try {
            g.Ek();
            String str = (String) g.Ei().DT().get(aa.a.sYs, "");
            if (!bi.oW(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(I(jSONArray.getJSONObject(i)));
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
        }
        return arrayList;
    }

    private static atm I(JSONObject jSONObject) {
        atm atm = new atm();
        atm.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE, -1);
        atm.url = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, "");
        atm.bSc = jSONObject.optString("wording", "");
        atm.rWQ = jSONObject.optString("waapp_username", "");
        atm.rWR = jSONObject.optString("waapp_path", "");
        return atm;
    }

    protected String aCl() {
        if (bi.oW(this.hYh)) {
            this.hYh = o.bOW().aCl();
            this.hYh = e.abZ(this.hYh);
        }
        return this.hYh;
    }

    protected String aCm() {
        return e.abW(this.hYm);
    }

    protected final void aM(List<atm> list) {
        if (list != null) {
            for (atm atm : list) {
                if (atm.type == 1) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(1), atm.bSc, "", "", "", Integer.valueOf(1)});
                } else if (atm.type == 2) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(2), atm.bSc, "", "", atm.url, Integer.valueOf(1)});
                } else if (atm.type == 3) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(3), atm.bSc, atm.rWQ, atm.rWR, "", Integer.valueOf(1)});
                }
            }
        }
        this.hYe.setOnClickListener(new 13(this, list));
    }

    protected void aCn() {
    }
}
