package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(3)
public class LuckyMoneyBusiDetailUI extends LuckyMoneyBaseUI {
    private View Iq;
    private TextView hVS;
    private TextView hXT;
    private boolean ikj = false;
    private View iln;
    private TextView kLF;
    private ListView kLN;
    private ImageView kLO;
    private TextView kLP;
    private View kLR;
    private View kLS;
    OnScrollListener kLU = new 1(this);
    private List<n> kLz = new LinkedList();
    private LuckyMoneyWishFooter kUh;
    private ImageView kUi;
    private View kUj;
    private ImageView kUk;
    private boolean kUl = true;
    private int kUm;
    private String kUn;
    private String kUo;
    private String kUp;
    private String kUq;
    private int kUr = 0;
    private Map<String, Integer> kUs = new HashMap();
    private i kUt;
    private String kUu = "";
    private boolean kUv = false;
    private TextView klp;
    private int tH = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kLN = (ListView) findViewById(a$f.busi_detail_record_list);
        this.kUt = new i(this.mController.tml);
        this.Iq = LayoutInflater.from(this).inflate(a$g.lucky_money_busi_detail_header, null);
        this.kLN.addHeaderView(this.Iq);
        this.kLN.setAdapter(this.kUt);
        this.Iq.setOnClickListener(new 7(this));
        this.kLN.setOnScrollListener(this.kLU);
        this.kLN.setOnItemClickListener(new 8(this));
        this.iln = LayoutInflater.from(this).inflate(a$g.lucky_money_busi_detail_footer, null);
        this.kLO = (ImageView) this.Iq.findViewById(a$f.busi_detail_avatar);
        this.kLP = (TextView) this.Iq.findViewById(a$f.busi_detail_whose);
        this.klp = (TextView) this.Iq.findViewById(a$f.busi_detail_wishing);
        this.kLR = this.Iq.findViewById(a$f.busi_detail_amount_area);
        this.kLF = (TextView) this.Iq.findViewById(a$f.busi_detail_amount);
        this.kLS = this.Iq.findViewById(a$f.busi_detail_hint_layout);
        this.hXT = (TextView) this.Iq.findViewById(a$f.busi_detail_tips);
        this.kUi = (ImageView) this.Iq.findViewById(a$f.busi_detail_icon);
        this.hVS = (TextView) this.Iq.findViewById(a$f.busi_detail_desc);
        this.kUj = this.Iq.findViewById(a$f.busi_detail_opertiaon_ll);
        this.kUk = (ImageView) this.Iq.findViewById(a$f.busi_detail_adimage);
        ImageView imageView = (ImageView) findViewById(a$f.busi_detail_close_btn);
        this.kUh = (LuckyMoneyWishFooter) findViewById(a$f.busi_detail_wish_footer);
        this.kUh.a(new 9(this));
        this.kUh.setOnWishSendImp(new 10(this));
        this.kUh.post(new 11(this));
        this.kUh.setOnkbdStateListener(new 12(this));
        this.kUt.kXt = new 13(this);
        i iVar = this.kUt;
        iVar.kXu = new i.a(iVar);
        this.kUh.setMaxLength(25);
        imageView.setOnClickListener(new 14(this));
        fixBackgroundRepeat(findViewById(a$f.busi_detail_bottom_decoration));
        this.kUn = getIntent().getStringExtra("key_sendid");
        this.kUp = getIntent().getStringExtra("key_native_url");
        this.kUm = getIntent().getIntExtra("key_jump_from", 2);
        this.kUr = getIntent().getIntExtra("key_static_from_scene", 0);
        x.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[]{this.kUn, this.kUp, Integer.valueOf(this.kUm)});
        if (this.kUm == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (byteArrayExtra != null) {
                    f fVar = (f) new f().aG(byteArrayExtra);
                    if (fVar != null) {
                        a(fVar);
                        if (getIntent().getBooleanExtra("play_sound", false)) {
                            k.I(this, i.lucky_cashrecivedrevised);
                        }
                    }
                }
            } catch (Exception e) {
                x.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bi.oW(this.kUn) && !bi.oW(this.kUp)) {
            try {
                this.kUn = Uri.parse(this.kUp).getQueryParameter("sendid");
            } catch (Exception e2) {
                x.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + e2.getLocalizedMessage());
            }
        }
        if (bi.oW(this.kUn)) {
            x.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
        } else {
            bbr();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
            k.I(this, i.lucky_cashrecivedrevised);
        }
    }

    public static void fixBackgroundRepeat(View view) {
        if (view != null) {
            Drawable background = view.getBackground();
            if (background != null && (background instanceof BitmapDrawable)) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
                bitmapDrawable.mutate();
                bitmapDrawable.setTileModeX(TileMode.REPEAT);
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.kUh.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.kUh.setVisibility(8);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        boolean z = false;
        if (lVar instanceof w) {
            if (i == 0 && i2 == 0) {
                w wVar = (w) lVar;
                f fVar = wVar.kQP;
                this.kUu = wVar.kRb;
                a(fVar);
                return true;
            }
            h.bA(this, str);
            return true;
        } else if (lVar instanceof ac) {
            if (i == 0 && i2 == 0) {
                h.bA(this, getString(i.has_send));
                this.kUt.kLB = false;
                bbs();
                ac acVar = (ac) lVar;
                if (this.kLz != null) {
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= this.kLz.size()) {
                            break;
                        }
                        n nVar = (n) this.kLz.get(z2);
                        if (nVar.kPS.equalsIgnoreCase(acVar.kPS)) {
                            nVar.kQE = acVar.kLf;
                            this.kUt.notifyDataSetChanged();
                            break;
                        }
                        z = z2 + 1;
                    }
                }
                return true;
            }
            h.bA(this, str);
            return true;
        } else if (!(lVar instanceof ah)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                h.bA(this, getString(i.has_send));
                return true;
            }
            h.bA(this, str);
            return true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bi.oW(stringExtra)) {
                        if (this.kUq != null && this.kUq.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            x.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            l(new ah(stringExtra.replaceAll(",", "|"), this.kUn, "v1.0"));
                            break;
                        }
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void finish() {
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
            boolean b = realnameGuideHelper.b(this, bundle, new 2(this));
            getIntent().removeExtra("key_realname_guide_helper");
            if (!b) {
                super.finish();
                return;
            }
            return;
        }
        super.finish();
    }

    protected final int getLayoutId() {
        return a$g.lucky_money_busi_detail_ui;
    }

    private void bbr() {
        this.ikj = true;
        if (this.tH <= 0 || this.kLz.size() <= 0 || this.kLz.get(this.kLz.size() - 1) == null) {
            this.kUu = "";
            l(new w(this.kUn, 11, this.tH, this.kUp, "v1.0", this.kUu));
            return;
        }
        l(new w(this.kUn, this.tH, this.kUp, bi.getLong(((n) this.kLz.get(this.kLz.size() - 1)).kQq, 0), "v1.0", this.kUu));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.mm.plugin.luckymoney.b.f r13) {
        /*
        r12 = this;
        if (r13 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r13.kPV;
        r1 = 1;
        if (r0 != r1) goto L_0x0339;
    L_0x0008:
        r0 = 1;
    L_0x0009:
        r12.kUl = r0;
        r0 = r12.tH;
        if (r0 != 0) goto L_0x023d;
    L_0x000f:
        r0 = r13.kPS;
        r12.kUo = r0;
        r0 = r12.kUt;
        r1 = r12.kUo;
        r0.kLA = r1;
        r0 = r12.kUt;
        r1 = r13.kQd;
        r0.kLC = r1;
        if (r13 == 0) goto L_0x00eb;
    L_0x0021:
        r0 = r12.mController;
        r0 = r0.tml;
        r1 = r13.kQd;
        r2 = 2;
        if (r1 != r2) goto L_0x0344;
    L_0x002a:
        r1 = r12.kLO;
        r2 = com.tencent.mm.plugin.wxpay.a.e.lucky_money_busi_default_avatar;
        r1.setImageResource(r2);
        r1 = r13.resourceId;
        if (r1 == 0) goto L_0x033c;
    L_0x0035:
        r1 = "MicroMsg.LuckyMoneyDetailUI";
        r2 = new java.lang.StringBuilder;
        r3 = "busi logo load from file:";
        r2.<init>(r3);
        r3 = r13.resourceId;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = new com.tencent.mm.g.a.hg;
        r1.<init>();
        r2 = r1.bQx;
        r3 = r13.resourceId;
        r2.bQz = r3;
        r2 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$3;
        r2.<init>(r12, r1, r13);
        r1.bJX = r2;
        r2 = com.tencent.mm.sdk.b.a.sFg;
        r3 = android.os.Looper.myLooper();
        r2.a(r1, r3);
    L_0x0068:
        r1 = r12.kLP;
        r2 = r13.kPL;
        com.tencent.mm.plugin.luckymoney.b.o.a(r0, r1, r2);
        r1 = r12.klp;
        r2 = r13.kLf;
        com.tencent.mm.plugin.luckymoney.b.o.a(r0, r1, r2);
        r0 = r13.ceT;
        r1 = 2;
        if (r0 != r1) goto L_0x0356;
    L_0x007b:
        r0 = r12.kUm;
        r1 = 3;
        if (r0 == r1) goto L_0x0356;
    L_0x0080:
        r0 = r12.kLF;
        r2 = r13.cfh;
        r2 = (double) r2;
        r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = r2 / r4;
        r1 = com.tencent.mm.wallet_core.ui.e.A(r2);
        r0.setText(r1);
        r0 = r13.kPT;
        r1 = 1;
        if (r0 == r1) goto L_0x034f;
    L_0x0094:
        r0 = r12.kUt;
        r1 = 1;
        r0.kLB = r1;
    L_0x0099:
        r0 = r12.kLR;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x009f:
        r0 = r13.kNi;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0382;
    L_0x00a7:
        r0 = r12.kLS;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r12.hXT;
        r1 = r13.kNi;
        r0.setText(r1);
        r0 = r13.kNg;
        r1 = 1;
        if (r0 != r1) goto L_0x0368;
    L_0x00b9:
        r0 = r13.kNh;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x035f;
    L_0x00c1:
        r0 = r13.kNh;
        r1 = "weixin://wxpay";
        r0 = r0.startsWith(r1);
        if (r0 != 0) goto L_0x035f;
    L_0x00cc:
        r0 = r12.kUi;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x00d2:
        r0 = r12.hXT;
        r1 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$4;
        r1.<init>(r12, r13);
        r0.setOnClickListener(r1);
    L_0x00dc:
        r0 = r13.kPW;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0394;
    L_0x00e4:
        r0 = r12.hVS;
        r1 = r13.kPW;
        r0.setText(r1);
    L_0x00eb:
        if (r13 == 0) goto L_0x0206;
    L_0x00ed:
        r4 = r13.kPZ;
        if (r4 == 0) goto L_0x01da;
    L_0x00f1:
        r0 = r4.size();
        if (r0 <= 0) goto L_0x01da;
    L_0x00f7:
        r0 = r12.Iq;
        r1 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_operation_container_1;
        r5 = r0.findViewById(r1);
        r0 = r12.Iq;
        r1 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_operation_container_2;
        r6 = r0.findViewById(r1);
        r0 = r12.Iq;
        r1 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_operation_container_3;
        r7 = r0.findViewById(r1);
        r0 = r12.Iq;
        r1 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_operation_1;
        r0 = r0.findViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        r1 = r12.Iq;
        r2 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_operation_2;
        r1 = r1.findViewById(r2);
        r1 = (android.view.ViewGroup) r1;
        r2 = r12.Iq;
        r3 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_operation_3;
        r2 = r2.findViewById(r3);
        r2 = (android.view.ViewGroup) r2;
        r3 = r12.Iq;
        r8 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_divider_operation_1;
        r8 = r3.findViewById(r8);
        r3 = r12.Iq;
        r9 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_divider_operation_2;
        r9 = r3.findViewById(r9);
        r10 = new com.tencent.mm.plugin.luckymoney.ui.g$c;
        r10.<init>();
        r3 = r12.getResources();
        r11 = com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_detail_primary_text_color;
        r3 = r3.getColor(r11);
        r10.textColor = r3;
        r3 = 1;
        r10.kWM = r3;
        r3 = r13.resourceId;
        r10.resourceId = r3;
        r3 = r12.kUr;
        r10.kWN = r3;
        r3 = r4.size();
        if (r3 <= 0) goto L_0x016d;
    L_0x015f:
        r3 = 0;
        r3 = r4.get(r3);
        r3 = (com.tencent.mm.plugin.luckymoney.b.ai) r3;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r0, r3, r10);
        r0 = 0;
        r5.setVisibility(r0);
    L_0x016d:
        r0 = r4.size();
        r3 = 1;
        if (r0 <= r3) goto L_0x0182;
    L_0x0174:
        r0 = 1;
        r0 = r4.get(r0);
        r0 = (com.tencent.mm.plugin.luckymoney.b.ai) r0;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r1, r0, r10);
        r0 = 0;
        r6.setVisibility(r0);
    L_0x0182:
        r0 = r4.size();
        r1 = 2;
        if (r0 <= r1) goto L_0x0197;
    L_0x0189:
        r0 = 2;
        r0 = r4.get(r0);
        r0 = (com.tencent.mm.plugin.luckymoney.b.ai) r0;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r2, r0, r10);
        r0 = 0;
        r7.setVisibility(r0);
    L_0x0197:
        r0 = r5.getVisibility();
        if (r0 != 0) goto L_0x01ad;
    L_0x019d:
        r0 = r6.getVisibility();
        if (r0 == 0) goto L_0x01a9;
    L_0x01a3:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01ad;
    L_0x01a9:
        r0 = 0;
        r8.setVisibility(r0);
    L_0x01ad:
        r0 = r6.getVisibility();
        if (r0 != 0) goto L_0x01bd;
    L_0x01b3:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01bd;
    L_0x01b9:
        r0 = 0;
        r9.setVisibility(r0);
    L_0x01bd:
        r0 = r5.getVisibility();
        if (r0 == 0) goto L_0x01cf;
    L_0x01c3:
        r0 = r6.getVisibility();
        if (r0 == 0) goto L_0x01cf;
    L_0x01c9:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01da;
    L_0x01cf:
        r0 = r12.kUj;
        r0.requestLayout();
        r0 = r12.kUj;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x01da:
        r0 = r12.iln;
        r1 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_footer_operation;
        r0 = r0.findViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        r1 = new com.tencent.mm.plugin.luckymoney.ui.g$c;
        r1.<init>();
        r2 = r12.getResources();
        r3 = com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_detail_primary_text_color;
        r2 = r2.getColor(r3);
        r1.textColor = r2;
        r2 = r12.getResources();
        r3 = com.tencent.mm.plugin.wxpay.a.d.SmallerTextSize;
        r2 = r2.getDimensionPixelSize(r3);
        r1.textSize = r2;
        r2 = r13.kQa;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r0, r2, r1);
    L_0x0206:
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 11701; // 0x2db5 float:1.6397E-41 double:5.781E-320;
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r13.kQd;
        r4 = sj(r4);
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
    L_0x023d:
        if (r13 == 0) goto L_0x0304;
    L_0x023f:
        r0 = r13.ceS;
        r1 = 3;
        if (r0 == r1) goto L_0x0249;
    L_0x0244:
        r0 = r13.ceS;
        r1 = 2;
        if (r0 != r1) goto L_0x039c;
    L_0x0249:
        r0 = r13.kPU;
        r1 = 1;
        if (r0 != r1) goto L_0x039c;
    L_0x024e:
        r0 = r12.kUl;
        if (r0 != 0) goto L_0x039c;
    L_0x0252:
        r0 = r13.kPX;
        r1 = 1;
        if (r0 != r1) goto L_0x039c;
    L_0x0257:
        r0 = 1;
        r1 = r0;
    L_0x0259:
        r0 = r13.kPY;
        if (r0 == 0) goto L_0x03a0;
    L_0x025d:
        r0 = r13.kPY;
        r0 = r0.ddp;
        r2 = 1;
        if (r0 != r2) goto L_0x03a0;
    L_0x0264:
        r0 = r13.kPY;
        r0 = r0.kPw;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x03a0;
    L_0x026e:
        r0 = 1;
        r2 = r0;
    L_0x0270:
        r0 = r12.iln;
        r3 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_send_btn;
        r0 = r0.findViewById(r3);
        r0 = (android.widget.TextView) r0;
        if (r1 != 0) goto L_0x027e;
    L_0x027c:
        if (r2 == 0) goto L_0x03a4;
    L_0x027e:
        r1 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$5;
        r1.<init>(r12, r13);
        r0.setOnClickListener(r1);
        if (r2 == 0) goto L_0x0295;
    L_0x0288:
        r1 = r13.kPY;
        r1 = r1.kPw;
        r12.kUq = r1;
        r1 = r13.kPY;
        r1 = r1.kPx;
        r0.setText(r1);
    L_0x0295:
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 11701; // 0x2db5 float:1.6397E-41 double:5.781E-320;
        r3 = 5;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r13.kQd;
        r5 = sj(r5);
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 2;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 3;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 4;
        r5 = 2;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r1.h(r2, r3);
        r1 = 0;
        r0.setVisibility(r1);
    L_0x02d0:
        r1 = r12.iln;
        r2 = com.tencent.mm.plugin.wxpay.a$f.busi_detail_record_link;
        r1 = r1.findViewById(r2);
        r1 = (android.widget.TextView) r1;
        r2 = r12.kUm;
        r3 = 1;
        if (r2 == r3) goto L_0x03ab;
    L_0x02df:
        r2 = r12.kUm;
        r3 = 3;
        if (r2 == r3) goto L_0x03ab;
    L_0x02e4:
        r0 = r0.getVisibility();
        if (r0 == 0) goto L_0x03ab;
    L_0x02ea:
        r0 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$6;
        r0.<init>(r12, r13);
        r1.setOnClickListener(r0);
        r0 = 0;
        r1.setVisibility(r0);
    L_0x02f6:
        r0 = r12.kUv;
        if (r0 != 0) goto L_0x0304;
    L_0x02fa:
        r0 = r12.kLN;
        r1 = r12.iln;
        r0.addFooterView(r1);
        r0 = 1;
        r12.kUv = r0;
    L_0x0304:
        r2 = r13.kQe;
        if (r2 == 0) goto L_0x03c5;
    L_0x0308:
        r0 = 0;
        r1 = r0;
    L_0x030a:
        r0 = r2.size();
        if (r1 >= r0) goto L_0x03b2;
    L_0x0310:
        r0 = r2.get(r1);
        r0 = (com.tencent.mm.plugin.luckymoney.b.n) r0;
        r3 = r12.kUs;
        r4 = r0.kPS;
        r3 = r3.containsKey(r4);
        if (r3 != 0) goto L_0x0335;
    L_0x0320:
        r3 = r12.kLz;
        r4 = r2.get(r1);
        r3.add(r4);
        r3 = r12.kUs;
        r0 = r0.kPS;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r3.put(r0, r4);
    L_0x0335:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x030a;
    L_0x0339:
        r0 = 0;
        goto L_0x0009;
    L_0x033c:
        r1 = r13.kPM;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0068;
    L_0x0344:
        r1 = r12.kLO;
        r2 = r13.kPM;
        r3 = r13.kQg;
        com.tencent.mm.plugin.luckymoney.b.o.a(r1, r2, r3);
        goto L_0x0068;
    L_0x034f:
        r0 = r12.kUt;
        r1 = 0;
        r0.kLB = r1;
        goto L_0x0099;
    L_0x0356:
        r0 = r12.kLR;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x009f;
    L_0x035f:
        r0 = r12.kUi;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00d2;
    L_0x0368:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "detail.jumpChange is false";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r12.hXT;
        r1 = r12.getResources();
        r2 = com.tencent.mm.plugin.wxpay.a.c.lucky_money_operation_text_normal_color;
        r1 = r1.getColor(r2);
        r0.setTextColor(r1);
        goto L_0x00dc;
    L_0x0382:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "detail.changeWording is empty";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r12.kLS;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00dc;
    L_0x0394:
        r0 = r12.hVS;
        r1 = 0;
        r0.setText(r1);
        goto L_0x00eb;
    L_0x039c:
        r0 = 0;
        r1 = r0;
        goto L_0x0259;
    L_0x03a0:
        r0 = 0;
        r2 = r0;
        goto L_0x0270;
    L_0x03a4:
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x02d0;
    L_0x03ab:
        r0 = 8;
        r1.setVisibility(r0);
        goto L_0x02f6;
    L_0x03b2:
        r0 = r12.tH;
        r1 = r2.size();
        r0 = r0 + r1;
        r12.tH = r0;
        r0 = 0;
        r12.ikj = r0;
        r0 = r12.kUt;
        r1 = r12.kLz;
        r0.bw(r1);
    L_0x03c5:
        r0 = r13.kQc;
        r1 = r13.kQf;
        r2 = r12.kUk;
        r3 = com.tencent.mm.plugin.wxpay.a.e.lucky_money_busi_ad_img_default;
        r2.setImageResource(r3);
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r2 == 0) goto L_0x043a;
    L_0x03d6:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "renderAdImage: no adImage";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r12.kUk;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x03e6:
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 13051; // 0x32fb float:1.8288E-41 double:6.448E-320;
        r2 = 10;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.kUr;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r13.kQc;
        r2[r3] = r4;
        r3 = 3;
        r4 = r13.kPZ;
        r4 = com.tencent.mm.plugin.luckymoney.b.o.bv(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = "";
        r2[r3] = r4;
        r3 = 5;
        r4 = "";
        r2[r3] = r4;
        r3 = 6;
        r4 = "";
        r2[r3] = r4;
        r3 = 7;
        r4 = "";
        r2[r3] = r4;
        r3 = 8;
        r4 = r13.kPL;
        r2[r3] = r4;
        r3 = 9;
        r4 = r13.resourceId;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        goto L_0x0002;
    L_0x043a:
        r2 = new android.util.DisplayMetrics;
        r2.<init>();
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = r2.getResources();
        r2 = r2.getDisplayMetrics();
        if (r2 == 0) goto L_0x047b;
    L_0x044d:
        r2 = r2.widthPixels;
        r3 = r12.getResources();
        r4 = com.tencent.mm.plugin.wxpay.a.d.lucky_money_busi_detail_list_padding;
        r3 = r3.getDimensionPixelSize(r4);
        r3 = r3 * 2;
        r2 = r2 - r3;
        r3 = r12.getResources();
        r4 = com.tencent.mm.plugin.wxpay.a.d.lucky_money_busi_detail_list_margin;
        r3 = r3.getDimensionPixelSize(r4);
        r3 = r3 * 2;
        r2 = r2 - r3;
        r2 = (float) r2;
        r3 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
        r2 = r2 * r3;
        r2 = (int) r2;
        r3 = r12.kUk;
        r3 = r3.getLayoutParams();
        r3.height = r2;
        r2 = r12.kUk;
        r2.setLayoutParams(r3);
    L_0x047b:
        r2 = r12.kUk;
        r3 = 0;
        com.tencent.mm.plugin.luckymoney.b.o.a(r2, r0, r1, r3);
        r0 = r12.kUk;
        r1 = 0;
        r0.setVisibility(r1);
        goto L_0x03e6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.a(com.tencent.mm.plugin.luckymoney.b.f):void");
    }

    private void bbs() {
        if (this.kUh != null && this.kUh.getVisibility() != 8) {
            this.kUh.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kUh != null) {
            this.kUh.bbE();
        }
    }

    private static int sj(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
