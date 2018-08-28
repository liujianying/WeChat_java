package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.s;
import com.tencent.mm.plugin.luckymoney.b.t;
import com.tencent.mm.plugin.luckymoney.b.u;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

@a(3)
public class LuckyMoneyBusiReceiveUI extends LuckyMoneyBaseUI {
    private TextView kLF;
    private ImageView kLO;
    private TextView kMF;
    private Button kMG;
    private View kMK;
    private ImageView kOI;
    private TextView kUA;
    private View kUB;
    private ImageView kUC;
    private TextView kUD;
    private View kUE;
    private TextView kUF;
    private Button kUG;
    private TextView kUH;
    private CheckBox kUI;
    private int kUJ;
    private String kUK = null;
    private int kUL = 0;
    private u kUM;
    private RealnameGuideHelper kUN;
    private String kUn = null;
    private String kUp = null;
    private int kUr = 0;
    private TextView kUz;
    private p tipDialog = null;

    static /* synthetic */ void i(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        luckyMoneyBusiReceiveUI.b(new t(luckyMoneyBusiReceiveUI.kUM.kLZ, luckyMoneyBusiReceiveUI.kUM.ceR, luckyMoneyBusiReceiveUI.kUM.kQQ, luckyMoneyBusiReceiveUI.getIntent().getStringExtra("packageExt"), luckyMoneyBusiReceiveUI.getIntent().getStringExtra("key_username")), false);
        o.a(luckyMoneyBusiReceiveUI.kMG);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kUp = getIntent().getStringExtra("key_native_url");
        this.kUJ = getIntent().getIntExtra("key_way", 5);
        this.kUr = getIntent().getIntExtra("key_static_from_scene", 0);
        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bi.oV(this.kUp) + ", mWay=" + this.kUJ);
        init();
        h.mEJ.h(11701, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        initView();
        jr(980);
    }

    private void init() {
        this.tipDialog = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.loading_tips), true, new 1(this));
        if (this.kUJ == 3) {
            b(new s(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
        } else if (this.kUJ == 4) {
            b(new s(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        } else {
            try {
                this.kUn = Uri.parse(bi.oV(this.kUp)).getQueryParameter("sendid");
            } catch (Exception e) {
            }
            if (bi.oW(this.kUn)) {
                finish();
                x.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
            } else {
                b(new u(this.kUn, this.kUp, this.kUJ, getIntent().getStringExtra("packageExt")), false);
            }
        }
        as(0, "");
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.hasExtra("key_is_realname_verify_process")) {
            if (intent.getIntExtra("realname_verify_process_ret", 0) == -1) {
                x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
                init();
                return;
            }
            x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
            as(-1, "");
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        js(980);
    }

    protected final void initView() {
        this.kMK = findViewById(a$f.lucky_money_busi_receive_ll);
        this.kLO = (ImageView) findViewById(a$f.lucky_money_busi_receive_sender_avatar);
        this.kMF = (TextView) findViewById(a$f.lucky_money_busi_receive_sender_nickname);
        this.kUA = (TextView) findViewById(a$f.lucky_money_busi_receive_maindesc);
        this.kUz = (TextView) findViewById(a$f.lucky_money_busi_receive_subdesc);
        this.kMG = (Button) findViewById(a$f.lucky_money_busi_receive_open);
        this.kOI = (ImageView) findViewById(a$f.lucky_money_busi_recieve_close_btn);
        this.kUB = findViewById(a$f.lucky_money_busi_amount_area);
        this.kLF = (TextView) findViewById(a$f.lucky_money_busi_amount);
        this.kUC = (ImageView) findViewById(a$f.lucky_money_busi_recieve_watermask);
        this.kUD = (TextView) findViewById(a$f.lucky_money_busi_recieve_check_detail);
        this.kUE = findViewById(a$f.lucky_money_busi_receive_share_area);
        this.kUF = (TextView) findViewById(a$f.lucky_money_busi_receive_share_hintmess);
        this.kUG = (Button) findViewById(a$f.lucky_money_busi_share_btn);
        this.kUH = (TextView) findViewById(a$f.lucky_money_busi_receive_savetips);
        this.kUI = (CheckBox) findViewById(a$f.lucky_money_busi_subcribe);
        this.kOI.setOnClickListener(new 3(this));
        ux(8);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        Intent intent;
        if (lVar instanceof u) {
            if (i == 0 && i2 == 0) {
                this.kUM = (u) lVar;
                this.kUn = this.kUM.kLZ;
                this.kUL = this.kUM.kPI;
                h.mEJ.h(13050, new Object[]{Integer.valueOf(this.kUr), Integer.valueOf(1), this.kUM.kQN});
                if (this.kUM.ceT == 2) {
                    as(-1, "");
                    b(new w(this.kUn, 11, 0, this.kUp, "v1.0"), false);
                } else {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    o.i(this.kLO, this.kUM.kQR);
                    o.a(this.mController.tml, this.kMF, this.kUM.kQH);
                    o.g(this.kUC, this.kUM.kQb);
                    if (this.kUM.ceT == 1 || this.kUM.ceS == 4 || this.kUM.ceS == 5 || this.kUM.ceS == 1) {
                        h.mEJ.h(11701, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                        this.kUz.setVisibility(4);
                        this.kUA.setText(this.kUM.kPJ);
                        this.kMG.setVisibility(8);
                        if (this.kUL == 1) {
                            this.kUD.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    h.mEJ.h(11701, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                                    Intent intent = new Intent();
                                    intent.setClass(LuckyMoneyBusiReceiveUI.this.mController.tml, LuckyMoneyBusiDetailUI.class);
                                    intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.this.kUp);
                                    intent.putExtra("key_sendid", LuckyMoneyBusiReceiveUI.this.kUM.kLZ);
                                    intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.this.kUr);
                                    LuckyMoneyBusiReceiveUI.this.startActivity(intent);
                                    LuckyMoneyBusiReceiveUI.this.finish();
                                }
                            });
                            this.kUD.setVisibility(0);
                        } else {
                            this.kUD.setVisibility(8);
                        }
                    } else {
                        if (!bi.oW(this.kUM.kQN)) {
                            this.kUK = this.kUM.kQN;
                            if (this.kUM.kQO == 1) {
                                this.kUI.setVisibility(8);
                            } else {
                                x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.kUM.kQN);
                                if (this.kUM.kQL == 1) {
                                    this.kUI.setChecked(true);
                                } else {
                                    this.kUI.setChecked(false);
                                }
                                this.kUI.setText(this.kUM.kQM);
                            }
                        }
                        this.kMG.setOnClickListener(new 4(this));
                        if (bi.oW(this.kUM.kPJ)) {
                            this.kUz.setVisibility(8);
                        } else {
                            this.kUz.setText(this.kUM.kPJ);
                        }
                        if (bi.oW(this.kUM.kQS)) {
                            this.kUA.setVisibility(8);
                        } else {
                            this.kUA.setText(this.kUM.kQS);
                        }
                    }
                    o.a(this.kMK, null);
                    this.mController.contentView.setVisibility(0);
                }
                return true;
            }
        } else if (lVar instanceof t) {
            o.c(this.kMG);
            if (i == 0 && i2 == 0) {
                as(-1, "");
                final t tVar = (t) lVar;
                if (tVar.ceT != 2) {
                    this.kUz.setVisibility(4);
                    this.kUA.setText(tVar.kPJ);
                    this.kMG.setVisibility(8);
                    if (this.kUL == 1) {
                        this.kUD.setOnClickListener(new 9(this, tVar));
                        this.kUD.setVisibility(0);
                    } else {
                        this.kUD.setVisibility(8);
                    }
                } else if (tVar.hUg <= 1 || !(tVar.kPY == null || tVar.kPY.ddp == 1)) {
                    x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
                    intent = new Intent();
                    intent.putExtra("key_sendid", tVar.kLZ);
                    intent.putExtra("key_static_from_scene", this.kUr);
                    if (tVar.kMP != null) {
                        intent.putExtra("key_realname_guide_helper", tVar.kMP);
                    }
                    try {
                        intent.putExtra("key_detail_info", tVar.kQP.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e) {
                        x.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                    }
                    if (g.AT().getInt("PlayCoinSound", 0) > 0) {
                        intent.putExtra("play_sound", true);
                    }
                    d.b(this.mController.tml, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
                    finish();
                    return true;
                } else {
                    CharSequence string;
                    final View findViewById = findViewById(a$f.lucky_money_busi_receive_top_ll);
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-findViewById.getHeight()));
                    translateAnimation.setDuration(400);
                    translateAnimation.setFillAfter(true);
                    translateAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            findViewById.setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    findViewById.startAnimation(translateAnimation);
                    this.kLF.setText(e.A(((double) tVar.cfh) / 100.0d));
                    this.kMF.setText(tVar.kQH);
                    this.kUz.setVisibility(8);
                    this.kUA.setVisibility(8);
                    this.kUB.setVisibility(0);
                    this.kMG.setVisibility(8);
                    if (bi.oW(tVar.kQK)) {
                        string = getString(i.lucky_money_share);
                    } else {
                        string = tVar.kQK;
                    }
                    this.kUG.setText(string);
                    this.kUH.setVisibility(0);
                    h.mEJ.h(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
                    x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + tVar.hUg);
                    if (tVar.hUg > 1 || (tVar.kPY != null && tVar.kPY.ddp == 1)) {
                        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
                        this.kUN = tVar.kMP;
                        this.kUG.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                CharSequence string;
                                LuckyMoneyBusiReceiveUI.this.kMK.setVisibility(4);
                                LuckyMoneyBusiReceiveUI.this.kUH.setVisibility(8);
                                LuckyMoneyBusiReceiveUI.this.kUB.setVisibility(8);
                                if (tVar.kPY == null || bi.oW(tVar.kPY.kPx)) {
                                    string = LuckyMoneyBusiReceiveUI.this.getString(i.lucky_money_share_friends_tips);
                                } else {
                                    string = tVar.kPY.kPx;
                                }
                                LuckyMoneyBusiReceiveUI.this.kUG.setText(string);
                                LuckyMoneyBusiReceiveUI.this.kUF.setText(tVar.kQI);
                                LuckyMoneyBusiReceiveUI.this.kUE.setVisibility(0);
                                LuckyMoneyBusiReceiveUI.this.kUG.setOnClickListener(new 1(this));
                                o.a(LuckyMoneyBusiReceiveUI.this.kMK, new 2(this));
                            }
                        });
                    } else {
                        this.kUG.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                LuckyMoneyBusiReceiveUI.this.finish();
                            }
                        });
                    }
                    this.kUG.setVisibility(0);
                }
                return true;
            } else if (i2 == 416) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                this.kMG.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.festival_lucky_money_open_btn);
                AnonymousClass10 anonymousClass10 = new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                };
                2 2 = new 2(this);
                return o.a(this, i2, lVar, bundle, false, 1005);
            }
        } else if (lVar instanceof ah) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.h.bA(this, getString(i.has_send));
                h.mEJ.h(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                finish();
                return true;
            }
            com.tencent.mm.ui.base.h.bA(this, str);
            return true;
        } else if (lVar instanceof s) {
            if (i == 0 && i2 == 0) {
                l(new u(this.kUn, this.kUp, this.kUJ, getIntent().getStringExtra("packageExt")));
                return true;
            }
        } else if (lVar instanceof com.tencent.mm.plugin.luckymoney.b.p) {
            return true;
        } else {
            if (lVar instanceof w) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (i == 0 && i2 == 0) {
                    w wVar = (w) lVar;
                    intent = new Intent();
                    intent.setClass(this.mController.tml, LuckyMoneyBusiDetailUI.class);
                    try {
                        intent.putExtra("key_detail_info", wVar.kQP.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e2) {
                        x.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                    }
                    intent.putExtra("key_native_url", this.kUp);
                    intent.putExtra("key_sendid", this.kUn);
                    intent.putExtra("key_static_from_scene", this.kUr);
                    startActivity(intent);
                    finish();
                    return true;
                }
            }
        }
        if (!(i == 0 && i2 == 0)) {
            as(2, str);
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    h.mEJ.h(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), stringExtra});
                    if (!bi.oW(stringExtra)) {
                        l(new ah(stringExtra, this.kUn, "v1.0"));
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return a$g.lucky_money_busi_receive_ui;
    }

    private void as(int i, String str) {
        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), str});
        Intent intent = new Intent();
        intent.putExtra("key_result_errmsg", str);
        setResult(i, intent);
    }
}
