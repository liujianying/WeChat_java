package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.model.s;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.luckymoney.particles.a.a;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private View Iq;
    private TextView hVS;
    private TextView hXT;
    private long hmf = 0;
    private ImageView iDX;
    private boolean ikj = false;
    private View iln;
    private TextView kLF;
    private ListView kLN;
    private ImageView kLO;
    private TextView kLP;
    private ImageView kLQ;
    private View kLR;
    private View kLS;
    OnScrollListener kLU = new 1(this);
    private List<n> kLz = new LinkedList();
    private SoundPool kMT;
    private b kOs = new b() {
        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            switch (random.nextInt(8)) {
                case 0:
                    if (LuckyMoneyDetailUI.this.kVj == null) {
                        LuckyMoneyDetailUI.this.kVj = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.lucky_money_f2f_firework_ribbon_1), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.kVj);
                case 1:
                    if (LuckyMoneyDetailUI.this.kVk == null) {
                        LuckyMoneyDetailUI.this.kVk = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.lucky_money_f2f_firework_ribbon_2), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.kVk);
                case 2:
                    if (LuckyMoneyDetailUI.this.kVl == null) {
                        LuckyMoneyDetailUI.this.kVl = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.lucky_money_f2f_firework_ribbon_3), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.kVl);
                case 3:
                    if (LuckyMoneyDetailUI.this.kVe == null) {
                        LuckyMoneyDetailUI.this.kVe = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.lucky_money_f2f_firework_leaf_top_1), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.kVe);
                case 4:
                    if (LuckyMoneyDetailUI.this.kVf == null) {
                        LuckyMoneyDetailUI.this.kVf = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.lucky_money_f2f_firework_leaf_top_2), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.kVf);
                case 5:
                    if (LuckyMoneyDetailUI.this.kVg == null) {
                        LuckyMoneyDetailUI.this.kVg = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.lucky_money_f2f_firework_leaf_top_3), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.kVg);
                case 6:
                    if (LuckyMoneyDetailUI.this.kVh == null) {
                        LuckyMoneyDetailUI.this.kVh = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.lucky_money_f2f_firework_leaf_top_4), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.kVh);
                case 7:
                    if (LuckyMoneyDetailUI.this.kVi == null) {
                        LuckyMoneyDetailUI.this.kVi = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.lucky_money_f2f_firework_leaf_top_5), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.kVi);
                default:
                    return null;
            }
        }
    };
    private int kQd = -1;
    private CdnImageView kUV;
    private ImageView kUW;
    private View kUX;
    private ImageView kUY;
    private TextView kUZ;
    private LuckyMoneyWishFooter kUh;
    private View kUj;
    private boolean kUl = true;
    private int kUm;
    private String kUn;
    private String kUo;
    private String kUp;
    private String kUq;
    private Map<String, Integer> kUs = new HashMap();
    private i kUt;
    private String kUu = "";
    private boolean kUv = false;
    private View kVa;
    private RelativeLayout kVb;
    private int[] kVc;
    private ViewGroup kVd;
    private Bitmap kVe;
    private Bitmap kVf;
    private Bitmap kVg;
    private Bitmap kVh;
    private Bitmap kVi;
    private Bitmap kVj;
    private Bitmap kVk;
    private Bitmap kVl;
    private final int kVm = 750;
    private final int kVn = aq.CTRL_BYTE;
    private TextView klp;
    private int tH = 0;

    static /* synthetic */ void w(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = luckyMoneyDetailUI.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            x.i("MicroMsg.LuckyMoneyDetailUI", "hy: screen  width: %d, scale : %f, fixedHeight: %d", new Object[]{Integer.valueOf(displayMetrics.widthPixels), Double.valueOf(((double) displayMetrics.widthPixels) / 750.0d), Integer.valueOf((int) (240.0d * (((double) displayMetrics.widthPixels) / 750.0d)))});
            luckyMoneyDetailUI.kVb.setLayoutParams(new LayoutParams(luckyMoneyDetailUI.kVb.getLayoutParams().width, r1));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.kUn = getIntent().getStringExtra("key_sendid");
        this.kUp = getIntent().getStringExtra("key_native_url");
        this.kUm = getIntent().getIntExtra("key_jump_from", 2);
        x.i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + bi.oV(this.kUn) + ", nativeurl=" + bi.oV(this.kUp) + ", jumpFrom=" + this.kUm);
        if (this.kUm == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (byteArrayExtra != null) {
                    f fVar = (f) new f().aG(byteArrayExtra);
                    if (fVar != null) {
                        a(fVar);
                        if (getIntent().getBooleanExtra("play_sound", false)) {
                            k.I(this, a$i.lucky_cashrecivedrevised);
                        }
                        addTextOptionMenu(0, getString(a$i.lucky_money_check_mine_title_opt), new 13(this));
                        DN(getResources().getColor(c.lucky_money_goldstyle_envelop_primary_text_color));
                    }
                }
            } catch (Exception e) {
                x.w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bi.oW(this.kUn) && !bi.oW(this.kUp)) {
            try {
                this.kUn = Uri.parse(this.kUp).getQueryParameter("sendid");
            } catch (Exception e2) {
            }
        }
        if (bi.oW(this.kUn)) {
            x.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
        } else {
            bbr();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
            k.I(this, a$i.lucky_cashrecivedrevised);
        }
        addTextOptionMenu(0, getString(a$i.lucky_money_check_mine_title_opt), new 13(this));
        DN(getResources().getColor(c.lucky_money_goldstyle_envelop_primary_text_color));
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        TextView textView = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.action_option_text);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(c.lucky_money_goldstyle_envelop_primary_text_color));
        }
        return onCreatePanelMenu;
    }

    protected void onResume() {
        super.onResume();
        this.hmf = bi.VE();
    }

    protected void onPause() {
        super.onPause();
        d.h("LuckyMoneyDetailUI", this.hmf, bi.VE());
    }

    protected final void initView() {
        setMMTitle(a$i.lucky_money_detail);
        setBackBtn(new 14(this));
        cqh();
        this.kLN = (ListView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_record_list);
        this.kUt = new i(this.mController.tml);
        this.Iq = LayoutInflater.from(this).inflate(g.lucky_money_detail_header, null);
        this.kLN.addHeaderView(this.Iq);
        this.kLN.setAdapter(this.kUt);
        this.Iq.setOnClickListener(new 15(this));
        this.kLN.setOnScrollListener(this.kLU);
        this.kLN.setOnItemClickListener(new 16(this));
        this.iln = LayoutInflater.from(this).inflate(g.lucky_money_detail_footer, null);
        this.kLO = (ImageView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_sender_avatar);
        this.kLP = (TextView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_whose);
        this.kLQ = (ImageView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_group_icon);
        this.klp = (TextView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_wishing);
        this.kLR = this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_amount_area);
        this.kLF = (TextView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_amount);
        this.kLS = this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_layout);
        this.hXT = (TextView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_tips);
        this.kUV = (CdnImageView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_icon);
        this.hVS = (TextView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_desc);
        this.kUW = (ImageView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_top_bg);
        this.kUj = this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_opertiaon_ll);
        this.kUX = this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_background_area);
        this.kUY = (ImageView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_background);
        this.kUZ = (TextView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_normal_wish);
        this.kVa = findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_normal_wish_divider);
        this.kVb = (RelativeLayout) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_background_area);
        this.iDX = (ImageView) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_background);
        this.kUh = (LuckyMoneyWishFooter) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_wish_footer);
        this.kVd = (ViewGroup) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_f2f_firework_recv_container);
        this.kUV.setUseSdcardCache(true);
        this.kUh.a(new 17(this));
        this.kUh.setOnWishSendImp(new 18(this));
        this.kUh.post(new 19(this));
        this.kUh.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            public final void qN(int i) {
                if (i == -2 && LuckyMoneyDetailUI.this.kUh.kXI) {
                    LuckyMoneyDetailUI.this.kUh.setModeClick(false);
                }
            }
        });
        this.kUt.kXt = new 3(this);
        this.kUh.setMaxLength(25);
        this.kUZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyDetailUI.this.kUh.setVisibility(0);
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.kUh.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.kUh.setVisibility(8);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
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
                h.bA(this, getString(a$i.has_send));
                this.kUt.kLB = false;
                bbs();
                ac acVar = (ac) lVar;
                if (this.kLz != null) {
                    for (int i3 = 0; i3 < this.kLz.size(); i3++) {
                        n nVar = (n) this.kLz.get(i3);
                        if (nVar.kPS.equalsIgnoreCase(acVar.kPS)) {
                            nVar.kQE = acVar.kLf;
                            this.kUt.notifyDataSetChanged();
                            break;
                        }
                    }
                    if (this.kUZ.getVisibility() == 0) {
                        this.kUZ.setVisibility(8);
                        this.hVS.setVisibility(0);
                        this.kVa.setVisibility(8);
                        this.kUt.bw(this.kLz);
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
                com.tencent.mm.ui.widget.snackbar.b.h(this, getString(a$i.has_send));
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
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            boolean b = realnameGuideHelper.b(this, bundle, new 5(this));
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
        return g.lucky_money_detail_ui;
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

    private void a(final f fVar) {
        if (fVar != null) {
            this.kUl = fVar.kPV == 1;
            if (this.tH == 0) {
                this.kUo = fVar.kPS;
                Object obj = (fVar == null || fVar.kPI != 0 || fVar.kQe == null || fVar.kQe.size() <= 0 || !((n) fVar.kQe.get(0)).kPS.equals(this.kUo) || fVar.kPT == 1) ? null : 1;
                if (obj != null) {
                    this.kUt.kLB = false;
                    this.kUZ.setVisibility(0);
                    this.kVa.setVisibility(0);
                    this.hVS.setVisibility(8);
                } else {
                    this.hVS.setVisibility(0);
                    this.kUt.kLA = this.kUo;
                }
                this.kUt.kLC = fVar.kQd;
                if (fVar != null) {
                    ActionBarActivity actionBarActivity = this.mController.tml;
                    if (fVar.kQd == 2) {
                        this.kLO.setImageResource(e.lucky_money_busi_default_avatar);
                        if (fVar.resourceId != 0) {
                            x.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + fVar.resourceId);
                            hg hgVar = new hg();
                            hgVar.bQx.bQz = fVar.resourceId;
                            hgVar.bJX = new 8(this, hgVar, fVar);
                            com.tencent.mm.sdk.b.a.sFg.a(hgVar, Looper.myLooper());
                        } else {
                            o.a(this.kLO, fVar.kPM, fVar.kQg);
                        }
                    } else {
                        o.a(this.kLO, fVar.kPM, fVar.kQg);
                    }
                    o.a(actionBarActivity, this.kLP, fVar.kPL);
                    o.a(actionBarActivity, this.klp, fVar.kLf);
                    if (fVar.kPI == 1) {
                        this.kLQ.setVisibility(0);
                        this.kLQ.setImageResource(e.lucky_money_group_icon);
                    } else if (fVar.kPI == 2) {
                        if (!s.he(fVar.kQg)) {
                            j jVar = new j();
                            jVar.username = fVar.kQg;
                            q.KH().a(jVar);
                        }
                        this.kLQ.setVisibility(0);
                        this.kLQ.setImageResource(e.lucky_money_f2f_record_icon);
                    } else {
                        this.kLQ.setVisibility(8);
                    }
                    if (!bi.oW(fVar.kQb)) {
                        o.d(this.kUW, fVar.kQb, e.lucky_money_index_top_bg);
                        this.kUW.setScaleType(ScaleType.FIT_XY);
                    }
                    if (bi.oW(fVar.kQc)) {
                        x.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
                        this.kVb.setVisibility(8);
                    } else {
                        x.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[]{fVar.kQc});
                        this.kVb.setVisibility(4);
                        o.g(this.iDX, fVar.kQc);
                        com.tencent.mm.sdk.platformtools.ah.i(new 9(this), 500);
                    }
                    if (fVar.ceT != 2 || this.kUm == 3) {
                        this.kLR.setVisibility(8);
                    } else {
                        this.kLF.setText(com.tencent.mm.wallet_core.ui.e.A(((double) fVar.cfh) / 100.0d));
                        if (fVar.kPT != 1) {
                            this.kUt.kLB = true;
                        } else {
                            this.kUt.kLB = false;
                        }
                        this.kLR.setVisibility(0);
                    }
                    if (bi.oW(fVar.kNi)) {
                        x.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                        this.kLS.setVisibility(8);
                    } else {
                        this.kLS.setVisibility(0);
                        this.hXT.setText(fVar.kNi);
                        if (fVar.kNg == 1) {
                            x.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", new Object[]{fVar.kQi});
                            if (bi.oW(fVar.kQi)) {
                                this.kUV.setVisibility(8);
                            } else {
                                this.kUV.setUrl(fVar.kQi);
                                this.kUV.setVisibility(0);
                            }
                            this.hXT.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, fVar);
                                }
                            });
                        } else {
                            x.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                            this.hXT.setTextColor(getResources().getColor(c.lucky_money_operation_text_normal_color));
                        }
                    }
                    if (bi.oW(fVar.kPW)) {
                        this.hVS.setText(null);
                    } else {
                        this.hVS.setText(fVar.kPW);
                    }
                }
                if (fVar != null) {
                    ViewGroup viewGroup;
                    List list = fVar.kPZ;
                    if (list != null && list.size() > 0) {
                        View findViewById = this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_operation_container_1);
                        View findViewById2 = this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_operation_container_2);
                        View findViewById3 = this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_operation_container_3);
                        viewGroup = (ViewGroup) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_operation_1);
                        ViewGroup viewGroup2 = (ViewGroup) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_operation_2);
                        ViewGroup viewGroup3 = (ViewGroup) this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_operation_3);
                        View findViewById4 = this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_divider_operation_1);
                        View findViewById5 = this.Iq.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_divider_operation_2);
                        g.c cVar = new g.c();
                        cVar.textColor = getResources().getColor(c.lucky_money_goldstyle_grey_text_color);
                        if (list.size() > 0) {
                            g.a(this, viewGroup, (ai) list.get(0), cVar);
                            findViewById.setVisibility(0);
                        }
                        if (list.size() > 1) {
                            g.a(this, viewGroup2, (ai) list.get(1), cVar);
                            findViewById2.setVisibility(0);
                        }
                        if (list.size() > 2) {
                            g.a(this, viewGroup3, (ai) list.get(2), cVar);
                            findViewById3.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                            findViewById4.setVisibility(0);
                        }
                        if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                            findViewById5.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                            this.kUj.requestLayout();
                            this.kUj.setVisibility(0);
                        }
                    }
                    viewGroup = (ViewGroup) this.iln.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_footer_operation);
                    g.c cVar2 = new g.c();
                    cVar2.textColor = getResources().getColor(c.lucky_money_goldstyle_grey_text_color);
                    cVar2.textSize = getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.SmallerTextSize);
                    g.a(this, viewGroup, fVar.kQa, cVar2);
                }
                com.tencent.mm.plugin.report.service.h.mEJ.h(11701, new Object[]{Integer.valueOf(sj(fVar.kQd)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
            }
            if (fVar != null) {
                Object obj2 = ((fVar.ceS == 3 || fVar.ceS == 2) && fVar.kPU == 1 && !this.kUl && fVar.kPX == 1) ? 1 : null;
                Object obj3 = (fVar.kPY == null || fVar.kPY.ddp != 1 || bi.oW(fVar.kPY.kPw)) ? null : 1;
                TextView textView = (TextView) this.iln.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_send_btn);
                if (obj2 == null && obj3 == null) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new 11(this, fVar));
                    if (obj3 != null) {
                        this.kUq = fVar.kPY.kPw;
                        textView.setText(fVar.kPY.kPx);
                    }
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11701, new Object[]{Integer.valueOf(sj(fVar.kQd)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                    textView.setVisibility(0);
                }
                this.kQd = fVar.kQd;
                ((TextView) this.iln.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_detail_record_link)).setVisibility(8);
                if (!this.kUv) {
                    this.kLN.addFooterView(this.iln);
                    this.kUv = true;
                }
            }
            List list2 = fVar.kQe;
            if (list2 != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list2.size()) {
                        break;
                    }
                    n nVar = (n) list2.get(i2);
                    if (!this.kUs.containsKey(nVar.kPS)) {
                        this.kLz.add(list2.get(i2));
                        this.kUs.put(nVar.kPS, Integer.valueOf(1));
                    }
                    i = i2 + 1;
                }
                this.tH += list2.size();
                this.ikj = false;
                if (this.kUZ.getVisibility() != 0) {
                    this.hVS.setVisibility(0);
                    this.kUt.bw(this.kLz);
                }
            }
            if (fVar.kPI == 2 && !bi.oW(fVar.kPK)) {
                this.kMT = new SoundPool(2, 3, 0);
                this.kVc = new int[2];
                try {
                    this.kVc[0] = this.kMT.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
                    this.kVc[1] = this.kMT.load(getResources().getAssets().openFd("whistle.m4a"), 0);
                } catch (IOException e) {
                    x.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + e.getMessage());
                }
                this.kMT.setOnLoadCompleteListener(new 6(this, fVar));
                this.Iq.postDelayed(new Runnable() {
                    public final void run() {
                        ViewGroup t = LuckyMoneyDetailUI.this.kVd;
                        b u = LuckyMoneyDetailUI.this.kOs;
                        com.tencent.mm.plugin.luckymoney.particles.a aVar = new com.tencent.mm.plugin.luckymoney.particles.a(t);
                        com.tencent.mm.plugin.luckymoney.particles.c am = new com.tencent.mm.plugin.luckymoney.particles.c(t.getContext(), u, new com.tencent.mm.plugin.luckymoney.particles.d(-100, t.getHeight() / 2), t).I(600.0f, 150.0f).J(-1000.0f, 250.0f).al(-200.0f).am(1500.0f);
                        am.kSA = 600.0f;
                        am.kSB = 300.0f;
                        am = am.bbb();
                        am.kSd = com.tencent.mm.plugin.luckymoney.particles.e.bbf();
                        aVar.kRR = am.bbc().bbd();
                        aVar.z(100, 400);
                        t = LuckyMoneyDetailUI.this.kVd;
                        u = LuckyMoneyDetailUI.this.kOs;
                        aVar = new com.tencent.mm.plugin.luckymoney.particles.a(t);
                        am = new com.tencent.mm.plugin.luckymoney.particles.c(t.getContext(), u, new com.tencent.mm.plugin.luckymoney.particles.d(t.getWidth() + 100, t.getHeight() / 2), t).I(-600.0f, 150.0f).J(-1000.0f, 250.0f).al(200.0f).am(1500.0f);
                        am.kSA = 600.0f;
                        am.kSB = 300.0f;
                        am = am.bbb();
                        am.kSd = com.tencent.mm.plugin.luckymoney.particles.e.bbf();
                        aVar.kRR = am.bbc().bbd();
                        aVar.z(100, 400);
                    }
                }, 300);
            }
            y yVar = new y();
            yVar.field_mNativeUrl = this.kUp;
            yVar.field_hbType = fVar.kPI;
            yVar.field_receiveAmount = fVar.cfh;
            yVar.field_receiveTime = System.currentTimeMillis();
            yVar.field_hbStatus = fVar.ceS;
            yVar.field_receiveStatus = fVar.ceT;
            if (yVar.field_receiveAmount > 0) {
                com.tencent.mm.plugin.wallet_core.model.o.bOT().a(yVar);
            }
        }
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
        if (this.kMT != null) {
            this.kMT.release();
            for (int unload : this.kVc) {
                this.kMT.unload(unload);
            }
        }
    }

    private static int sj(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
