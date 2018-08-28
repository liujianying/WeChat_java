package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.collect.b.b;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.c;
import com.tencent.mm.wallet_core.c.h$a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class RemittanceF2fDynamicCodeUI extends WalletBaseUI {
    private static int mCG = 60000;
    private int amount;
    private String bNY;
    private y.a hYI = new 1(this);
    private String hYz;
    private String lOs;
    private Button mAE;
    private ImageView mCA;
    private LinearLayout mCB;
    private WalletTextView mCC;
    private boolean mCD = false;
    private long mCE = 0;
    private long mCF = 0;
    private al mCH = new al(new a(this, (byte) 0), true);
    private PayInfo mCn;
    private String mCo;
    private String mCp;
    private String mCq;
    private String mCr;
    private String mCs;
    private String mCt;
    private String mCu;
    private List<uz> mCv = new ArrayList();
    private boolean mCw = false;
    private TextView mCx;
    private TextView mCy;
    private LinearLayout mCz;
    private String mxZ;
    private String nickname;
    private String username;

    static /* synthetic */ void b(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        remittanceF2fDynamicCodeUI.mCA.setImageBitmap(b.a(remittanceF2fDynamicCodeUI, remittanceF2fDynamicCodeUI.bNY, remittanceF2fDynamicCodeUI.username, remittanceF2fDynamicCodeUI.mCn.myh, remittanceF2fDynamicCodeUI.hYz, remittanceF2fDynamicCodeUI.hYI, remittanceF2fDynamicCodeUI.mCw));
        if (!bi.oW(remittanceF2fDynamicCodeUI.mCu)) {
            remittanceF2fDynamicCodeUI.mCx.setText(remittanceF2fDynamicCodeUI.mCu);
        }
        if (bi.oW(remittanceF2fDynamicCodeUI.mCt)) {
            remittanceF2fDynamicCodeUI.mCB.setVisibility(8);
        } else {
            remittanceF2fDynamicCodeUI.mCy.setText(remittanceF2fDynamicCodeUI.mCt);
            remittanceF2fDynamicCodeUI.mCB.setVisibility(0);
        }
        remittanceF2fDynamicCodeUI.mCz.removeAllViews();
        if (!remittanceF2fDynamicCodeUI.mCv.isEmpty()) {
            for (uz uzVar : remittanceF2fDynamicCodeUI.mCv) {
                F2fDynamicCodeItemLayout f2fDynamicCodeItemLayout = new F2fDynamicCodeItemLayout(remittanceF2fDynamicCodeUI);
                CharSequence charSequence = uzVar.aAL;
                CharSequence charSequence2 = uzVar.value;
                f2fDynamicCodeItemLayout.myG.setText(charSequence);
                f2fDynamicCodeItemLayout.idh.setText(charSequence2);
                remittanceF2fDynamicCodeUI.mCz.addView(f2fDynamicCodeItemLayout, new LayoutParams(-1, -2));
            }
        }
        remittanceF2fDynamicCodeUI.mCz.requestLayout();
    }

    static /* synthetic */ void d(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        c cVar = new c(remittanceF2fDynamicCodeUI.mController.tml, 1, false);
        cVar.ofp = new 6(remittanceF2fDynamicCodeUI);
        cVar.ofq = new 7(remittanceF2fDynamicCodeUI);
        cVar.bXO();
        cVar.uJQ = new 8(remittanceF2fDynamicCodeUI);
    }

    static /* synthetic */ void f(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        x.i("MicroMsg.RemittanceF2fDynamicCodeUI", "do get dynamic code %s", new Object[]{remittanceF2fDynamicCodeUI.mCs});
        remittanceF2fDynamicCodeUI.mCD = true;
        remittanceF2fDynamicCodeUI.a(new m(remittanceF2fDynamicCodeUI.amount, remittanceF2fDynamicCodeUI.username, remittanceF2fDynamicCodeUI.mCo, remittanceF2fDynamicCodeUI.mCp, remittanceF2fDynamicCodeUI.mCq, remittanceF2fDynamicCodeUI.mCr, remittanceF2fDynamicCodeUI.mCs, remittanceF2fDynamicCodeUI.nickname, remittanceF2fDynamicCodeUI.lOs), false, false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (brD()) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.remittance_busi_common_bg)));
                View customView = getSupportActionBar().getCustomView();
                if (customView != null) {
                    View findViewById = customView.findViewById(f.divider);
                    if (findViewById != null) {
                        findViewById.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.half_alpha_white));
                    }
                    customView = customView.findViewById(16908308);
                    if (customView != null && (customView instanceof TextView)) {
                        ((TextView) customView).setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.black));
                    }
                }
            }
            if (VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.remittance_busi_common_bg));
            }
            if (d.fR(21)) {
                if (d.fR(23)) {
                    getWindow().getDecorView().setSystemUiVisibility(8192);
                } else {
                    getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
                }
            }
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (RemittanceF2fDynamicCodeUI.this.c()) {
                        RemittanceF2fDynamicCodeUI.this.YC();
                        RemittanceF2fDynamicCodeUI.this.showDialog(TbsLog.TBSLOG_CODE_SDK_BASE);
                    } else {
                        RemittanceF2fDynamicCodeUI.this.finish();
                    }
                    return true;
                }
            }, h.back_icon_normal_black);
            jr(2736);
            setMMTitle(i.remittance_busi_pay);
            this.mCn = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
            if (this.mCn == null) {
                x.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
                finish();
            }
            ux(4);
            this.amount = this.mCn.qUL.getInt("extinfo_key_15");
            this.username = this.mCn.qUL.getString("extinfo_key_1");
            this.lOs = this.mCn.qUL.getString("extinfo_key_2");
            this.mCq = this.mCn.qUL.getString("extinfo_key_17");
            this.mCr = this.mCn.qUL.getString("extinfo_key_18");
            this.mCo = getIntent().getStringExtra("key_rcvr_open_id");
            this.mCs = getIntent().getStringExtra("key_mch_info");
            this.mCp = getIntent().getStringExtra("key_transfer_qrcode_id");
            this.hYz = getIntent().getStringExtra("key_mch_photo");
            this.mxZ = getIntent().getStringExtra("show_paying_wording");
            this.mCt = getIntent().getStringExtra("dynamic_code_spam_wording");
            this.mCw = getIntent().getBooleanExtra("show_avatar_type", false);
            this.nickname = e.gT(this.username);
            initView();
        }
    }

    protected final void initView() {
        if (brD()) {
            this.mCx = (TextView) findViewById(f.rfdc_supervision_tv);
            this.mCy = (TextView) findViewById(f.rfdc_spam_tv);
            this.mAE = (Button) findViewById(f.rfdc_pay_btn);
            this.mCA = (ImageView) findViewById(f.rfdc_code_iv);
            this.mCz = (LinearLayout) findViewById(f.rfdc_items_layout);
            this.mCB = (LinearLayout) findViewById(f.spam_ll);
            this.mCC = (WalletTextView) findViewById(f.pay_fee_tv);
            this.mCC.setText(getString(i.remittance_scan_qrcode_amount, new Object[]{e.B(((double) this.amount) / 100.0d)}));
            this.mAE.setOnClickListener(new 4(this));
            this.mCA.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    RemittanceF2fDynamicCodeUI.d(RemittanceF2fDynamicCodeUI.this);
                    return false;
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        if (brD()) {
            this.mCF = this.mCE <= 0 ? 0 : ((long) mCG) - (System.currentTimeMillis() - this.mCE);
            x.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", new Object[]{Long.valueOf(this.mCE), Long.valueOf(this.mCF)});
            if (this.mCF < 0) {
                this.mCF = 0;
            }
            this.mCH.J(this.mCF, (long) mCG);
            x.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
        }
    }

    public void onPause() {
        super.onPause();
        if (brD()) {
            this.mCH.SO();
            x.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
        }
    }

    public void onDestroy() {
        if (brD()) {
            js(2736);
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (brD()) {
            x.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
            if (i != 1) {
                return;
            }
            if (i2 == -1) {
                setResult(-1, intent);
                finish();
                return;
            }
            fn fnVar = new fn();
            fnVar.bNV.bNW = false;
            com.tencent.mm.sdk.b.a.sFg.m(fnVar);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (brD() && (lVar instanceof m)) {
            this.mCD = false;
            m mVar = (m) lVar;
            ux(0);
            mVar.a(new 2(this, mVar)).b(new h$a() {
                public final void g(int i, int i2, String str, l lVar) {
                }
            }).c(new 9(this));
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.remittance_f2f_dynamic_code_ui;
    }

    private boolean brD() {
        return getIntent().getBooleanExtra("from_patch_ui", false);
    }
}
