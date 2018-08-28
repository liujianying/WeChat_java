package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.e.b;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.protocal.c.ccg;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponUI extends MMActivity implements e {
    private String cZG = null;
    private String cZH = null;
    private c kup = new 1(this);
    private ProgressDialog kuy;
    private String kxW = null;
    private String kxX = null;
    private String kxY = null;
    private String kxZ = null;
    private LinearLayout kyA;
    private ImageView kyB;
    private LinearLayout kyC;
    private ImageView kyD;
    private TextView kyE;
    private TextView kyF;
    private TextView kyG;
    private ImageView kyH;
    private TextView kyI;
    private TextView kyJ;
    private View kyK;
    private IPCallDynamicTextView kyL;
    private b kyM = new b();
    private LinkedList<ccg> kyN = null;
    private boolean kyO = false;
    private String kya = null;
    private String kyb = null;
    private String kyc = null;
    private String kyd = null;
    private RelativeLayout kyr;
    private TextView kys;
    private ImageView kyt;
    private RelativeLayout kyu;
    private TextView kyv;
    private ImageView kyw;
    private LinearLayout kyx;
    private LinearLayout kyy;
    private LinearLayout kyz;

    static /* synthetic */ void d(IPCallShareCouponUI iPCallShareCouponUI) {
        b bVar = iPCallShareCouponUI.kyM;
        bVar.krN++;
        h.mEJ.a(257, 2, 1, true);
        String string = ad.getContext().getString(R.l.ip_call_normal_question_url);
        try {
            g.Eg();
            int Df = a.Df();
            String encode = URLEncoder.encode(d.DEVICE_NAME, "utf-8");
            String encode2 = URLEncoder.encode(bi.ciX(), "utf-8");
            String encode3 = URLEncoder.encode(q.zy(), "utf-8");
            String encode4 = URLEncoder.encode(d.qVH, "utf-8");
            String encode5 = URLEncoder.encode(d.qVI, "utf-8");
            String encode6 = URLEncoder.encode(d.qVJ, "utf-8");
            String encode7 = URLEncoder.encode(au.DA(), "utf-8");
            string = string + "&version=" + d.qVN + "&lang=" + w.fD(ad.getContext()) + ("&uin=" + Df + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + encode7 + "&signature=" + URLEncoder.encode(bi.fT(ad.getContext()), "utf-8") + "&scene=0");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.IPCallShareCouponUI", "[royle]UnsupportedEncodingException:%s", new Object[]{e.getMessage()});
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        com.tencent.mm.bg.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void e(IPCallShareCouponUI iPCallShareCouponUI) {
        b bVar = iPCallShareCouponUI.kyM;
        bVar.krO++;
        h.mEJ.a(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.l.ip_call_agreement_url));
        intent.putExtra("showShare", false);
        com.tencent.mm.bg.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void f(IPCallShareCouponUI iPCallShareCouponUI) {
        b bVar = iPCallShareCouponUI.kyM;
        bVar.krM++;
        h.mEJ.a(257, 1, 1, true);
        au.HU();
        com.tencent.mm.model.c.DT().a(aa.a.sRe, Boolean.valueOf(false));
        iPCallShareCouponUI.kyH.setVisibility(8);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.l.ip_call_exchange_record_url));
        intent.putExtra("showShare", false);
        com.tencent.mm.bg.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void i(IPCallShareCouponUI iPCallShareCouponUI) {
        akc aYD = com.tencent.mm.plugin.ipcall.b.c.aYD();
        if (aYD != null && !bi.oW(aYD.rMR)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aYD.rMR);
            intent.putExtra("showShare", false);
            com.tencent.mm.bg.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        au.DF().a(257, this);
        com.tencent.mm.sdk.b.a.sFg.b(this.kup);
        setMMTitle(R.l.ip_calladdress_account);
        setBackBtn(new 8(this));
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, R.g.mm_title_btn_menu, new 6(this));
        this.kyL = (IPCallDynamicTextView) findViewById(R.h.balance);
        this.kyr = (RelativeLayout) findViewById(R.h.rechargeLayout);
        this.kys = (TextView) findViewById(R.h.recharge_info_tv);
        this.kyt = (ImageView) findViewById(R.h.recharge_dot);
        au.HU();
        if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRc, Boolean.valueOf(false))).booleanValue()) {
            this.kyt.setVisibility(0);
        }
        au.HU();
        this.kys.setText((String) com.tencent.mm.model.c.DT().get(aa.a.sRb, ""));
        this.kyu = (RelativeLayout) findViewById(R.h.purchase_package_rl);
        this.kyv = (TextView) findViewById(R.h.package_info_tv);
        this.kyw = (ImageView) findViewById(R.h.package_dot);
        au.HU();
        this.kyv.setText((String) com.tencent.mm.model.c.DT().get(aa.a.sRd, ""));
        this.kyI = (TextView) findViewById(R.h.coupons_time);
        this.kyJ = (TextView) findViewById(R.h.package_desc_tv);
        this.kyK = findViewById(R.h.small_divider);
        this.kyx = (LinearLayout) findViewById(R.h.exchange_records);
        this.kyH = (ImageView) findViewById(R.h.new_dot);
        au.HU();
        if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRe, Boolean.valueOf(false))).booleanValue()) {
            this.kyH.setVisibility(0);
        }
        this.kyE = (TextView) findViewById(R.h.normal_question);
        this.kyF = (TextView) findViewById(R.h.agreement);
        this.kyG = (TextView) findViewById(R.h.stop_tip_tv);
        this.kyy = (LinearLayout) findViewById(R.h.share_coupon);
        this.kyz = (LinearLayout) findViewById(R.h.my_gift_card);
        this.kyC = (LinearLayout) findViewById(R.h.see_price);
        this.kyD = (ImageView) findViewById(R.h.see_price_new_dot);
        this.kyA = (LinearLayout) findViewById(R.h.msg_center);
        this.kyB = (ImageView) findViewById(R.h.msg_center_new_dot);
        au.HU();
        if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRk, Boolean.valueOf(false))).booleanValue()) {
            this.kyB.setVisibility(0);
        }
        if (com.tencent.mm.plugin.ipcall.b.c.aYC()) {
            z = true;
        } else {
            z = com.tencent.mm.k.g.AT().getInt("WCOPurchaseSwitch", 0) == 1;
        }
        if (z) {
            this.kyr.setVisibility(8);
        }
        z = (com.tencent.mm.plugin.ipcall.b.c.aYC() || com.tencent.mm.k.g.AT().getInt("WCOPackagePurchaseSwitch", 0) == 0) ? false : true;
        if (z) {
            this.kyu.setVisibility(0);
        }
        if (com.tencent.mm.k.g.AT().getInt("WCOAccountDetailSwitch", 0) == 1) {
            this.kyx.setVisibility(8);
        }
        if (com.tencent.mm.plugin.ipcall.b.c.aYC()) {
            z = true;
        } else {
            z = com.tencent.mm.k.g.AT().getInt("WCOInviteFriend", 0) == 1;
        }
        if (z) {
            this.kyy.setVisibility(8);
        }
        this.kyE.setOnClickListener(new 9(this));
        this.kyF.setOnClickListener(new 10(this));
        this.kyx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                IPCallShareCouponUI.f(IPCallShareCouponUI.this);
            }
        });
        this.kyy.setOnClickListener(new 12(this));
        this.kyA.setOnClickListener(new 13(this));
        this.kyz.setOnClickListener(new 14(this));
        this.kyr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                au.HU();
                if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRc, Boolean.valueOf(false))).booleanValue()) {
                    i.M(3, -1, -1);
                }
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sRc, Boolean.valueOf(false));
                IPCallShareCouponUI.this.kyt.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.tml, IPCallRechargeUI.class);
                IPCallShareCouponUI.this.startActivity(intent);
            }
        });
        this.kyu.setOnClickListener(new 2(this));
        this.kyC.setOnClickListener(new 3(this));
        akc aYD = com.tencent.mm.plugin.ipcall.b.c.aYD();
        if (aYD != null) {
            a(aYD);
            aoV();
        } else {
            this.kyL.setText("0");
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(R.l.app_tip);
            this.kuy = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(R.l.ip_call_loading_tip), true, new 4(this));
        }
        if (com.tencent.mm.plugin.ipcall.b.c.aYC()) {
            String string = getString(R.l.ipcall_stop_tip);
            CharSequence charSequence = string + getString(R.l.ipcall_stop_see_detail);
            5 5 = new 5(this);
            Spannable newSpannable = Factory.getInstance().newSpannable(charSequence);
            int length = string.length();
            int length2 = newSpannable.length();
            if (length < 0 || length >= length2 || length2 < 0 || length2 > newSpannable.length()) {
                newSpannable.setSpan(5, 0, newSpannable.length(), 33);
            } else {
                newSpannable.setSpan(5, length, length2, 33);
            }
            this.kyG.setText(newSpannable);
            this.kyG.setMovementMethod(LinkMovementMethod.getInstance());
            this.kyG.setVisibility(0);
        } else {
            this.kyG.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.layoutRechargeAndPackage);
        if (linearLayout != null && this.kyr.getVisibility() == 8 && this.kyu.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        linearLayout = (LinearLayout) findViewById(R.h.layoutShareAndCard);
        if (linearLayout != null && this.kyy.getVisibility() == 8 && this.kyz.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        this.kyM.start();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.ipcall.a.f.b.aXT().fY(false);
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(257, this);
        com.tencent.mm.sdk.b.a.sFg.c(this.kup);
        this.kyM.krL = bi.VF();
        this.kyM.finish();
    }

    protected final int getLayoutId() {
        return R.i.ip_call_coupons_ui;
    }

    private void aoV() {
        if (!bi.oW(this.kyb)) {
            if (this.kya == null) {
                this.kyL.setValue(this.kyb, this.kyb);
            } else {
                this.kyL.setValue(this.kya, this.kyb);
            }
            this.kya = this.kyb;
        }
        this.kyI.getText();
        this.kyI.setText(this.kyc);
        if (bi.oW(this.kyc)) {
            this.kyI.setVisibility(8);
        } else {
            this.kyI.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (this.kyN != null && this.kyN.size() > 0) {
            Iterator it = this.kyN.iterator();
            while (it.hasNext()) {
                ccg ccg = (ccg) it.next();
                if (!(ccg == null || bi.oW(ccg.syk))) {
                    stringBuffer.append(ccg.syk).append(10);
                }
            }
        }
        if (bi.oW(stringBuffer.toString())) {
            this.kyJ.setText("");
            this.kyJ.setVisibility(8);
        } else {
            if (stringBuffer.charAt(stringBuffer.length() - 1) == 10) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.kyJ.setText(stringBuffer.toString());
            this.kyJ.setVisibility(0);
        }
        if (this.kyI.getVisibility() == 0 && this.kyJ.getVisibility() == 0) {
            this.kyK.setVisibility(0);
        } else {
            this.kyK.setVisibility(8);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof com.tencent.mm.plugin.ipcall.a.d.g)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            a(((com.tencent.mm.plugin.ipcall.a.d.g) lVar).krt);
            aoV();
            if (this.kuy != null && this.kuy.isShowing()) {
                this.kuy.dismiss();
            }
        } else if (this.kuy != null && this.kuy.isShowing()) {
            this.kuy.dismiss();
            com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.ip_call_load_error_tip), getString(R.l.ip_call_func_name), new 7(this));
        }
    }

    private void a(akc akc) {
        this.kxW = akc.rMH;
        this.cZG = akc.jOS;
        this.kxX = akc.rMI;
        this.cZH = akc.bHD;
        this.kxY = akc.ksB;
        this.kxZ = akc.rMJ;
        this.kyb = akc.rMK;
        this.kyc = akc.rML;
        this.kyd = akc.rMM;
        this.kyN = akc.rMv;
    }
}
