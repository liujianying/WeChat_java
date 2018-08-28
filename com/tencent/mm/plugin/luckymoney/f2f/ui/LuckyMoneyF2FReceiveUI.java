package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.f2f.a.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.c.bfi;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

@a(3)
public class LuckyMoneyF2FReceiveUI extends LuckyMoneyBaseUI {
    private int amount;
    private DisplayMetrics ewi;
    private String ixy;
    private String kLZ;
    private ImageView kNF;
    private TextView kNG;
    private String kNe;
    private String kNj;
    private View kOG;
    private TextView kOH;
    private ImageView kOI;
    private ValueAnimator kOJ;
    private ValueAnimator kOK;
    private Intent kOL;
    private boolean kOM = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kOG = findViewById(f.lucky_money_receive_ll);
        this.kNF = (ImageView) findViewById(f.lucky_money_receive_sender_avatar);
        this.kNG = (TextView) findViewById(f.lucky_money_receive_sender_nickname);
        this.kOH = (TextView) findViewById(f.lucky_money_receive_tips);
        this.kOI = (ImageView) findViewById(f.lucky_money_recieve_close_btn);
        this.kOI.setOnClickListener(new 1(this));
        this.mController.contentView.setVisibility(8);
        this.ixy = getIntent().getStringExtra("key_share_url");
        i.zk(6);
        b(new b(this.ixy), true);
        this.ewi = getResources().getDisplayMetrics();
        this.kOJ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        this.kOK = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        this.kOK.setStartDelay(1000);
        this.kOJ.addUpdateListener(new 2(this));
        this.kOJ.addListener(new 3(this));
        this.kOK.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                x.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
                if (LuckyMoneyF2FReceiveUI.this.kOL != null) {
                    LuckyMoneyF2FReceiveUI.this.a(LuckyMoneyDetailUI.class, LuckyMoneyF2FReceiveUI.this.kOL);
                }
                LuckyMoneyF2FReceiveUI.this.setResult(-1, null);
                LuckyMoneyF2FReceiveUI.this.finish();
                if (LuckyMoneyF2FReceiveUI.this.kOL != null) {
                    LuckyMoneyF2FReceiveUI.this.overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.pop_in, com.tencent.mm.plugin.wxpay.a.a.pop_out);
                }
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
    }

    protected final int getLayoutId() {
        return g.lucky_money_f2f_receive_ui;
    }

    protected void onResume() {
        super.onResume();
        jr(1997);
        if (this.kOM) {
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        js(1997);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(lVar instanceof b)) {
            return true;
        }
        b bVar = (b) lVar;
        int i3 = bVar.ceS;
        int i4 = bVar.kNd;
        this.amount = bVar.amount;
        int i5 = bVar.kNg;
        String str2 = bVar.kNh;
        String str3 = bVar.kNi;
        x.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[]{Integer.valueOf(bVar.ceS), Integer.valueOf(bVar.kNd), Integer.valueOf(bVar.bJL)});
        bfi bfi;
        RealnameGuideHelper realnameGuideHelper;
        if (i4 == 2) {
            if (i3 == 5) {
                h.a(this, getString(a$i.lucky_money_f2f_has_expired), "", new 5(this));
            } else {
                this.kLZ = bVar.kLZ;
                this.kNe = bVar.kNe;
                this.kNj = bVar.kNj;
                this.kOL = new Intent();
                if (!(bi.oW(this.kNe) || s.he(this.kNe))) {
                    j jVar = new j();
                    jVar.username = this.kNe;
                    q.KH().a(jVar);
                }
                o.a(this.kNF, null, this.kNe);
                com.tencent.mm.plugin.luckymoney.b.f fVar = new com.tencent.mm.plugin.luckymoney.b.f();
                fVar.cfh = (long) this.amount;
                fVar.kLZ = this.kLZ;
                fVar.ceS = i3;
                fVar.ceT = i4;
                fVar.kNi = str3;
                fVar.kNg = i5;
                fVar.kQg = this.kNe;
                fVar.kNh = str2;
                fVar.kPL = o.gS(this.kNe);
                fVar.kNj = this.kNj;
                fVar.kPI = 2;
                x.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[]{Integer.valueOf(bVar.kNk)});
                if (bVar.kNk > 0) {
                    fVar.kPK = getString(a$i.lucky_money_lucky_best);
                }
                fVar.kPM = o.Gd(this.kNe);
                try {
                    this.kOL.putExtra("key_detail_info", fVar.toByteArray());
                    bfi = bVar.kNf;
                    if (bfi != null) {
                        realnameGuideHelper = new RealnameGuideHelper();
                        realnameGuideHelper.a(String.valueOf(bfi.qYW), bfi.kRt, bfi.kRu, bfi.kRv, bfi.kRw, lVar.getType());
                        this.kOL.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    }
                } catch (IOException e) {
                    x.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + e.getMessage());
                }
                if (!bi.G(new String[]{this.kLZ, this.kNe})) {
                    o.a(this, this.kNG, o.gS(this.kNe));
                    o.a(this, this.kOH, this.kNj);
                    this.kOJ.start();
                    this.mController.contentView.setVisibility(0);
                }
            }
            return true;
        }
        if (bVar.kNf != null) {
            x.i("LuckyMoneyF2FReceiveUI", "need real name verify");
            bfi = bVar.kNf;
            realnameGuideHelper = new RealnameGuideHelper();
            realnameGuideHelper.a(String.valueOf(bfi.qYW), bfi.kRt, bfi.kRu, bfi.kRv, bfi.kRw, lVar.getType());
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            6 6 = new 6(this);
            7 7 = new 7(this);
            if (realnameGuideHelper.a(this, bundle, 6, false)) {
                this.kOM = true;
                return true;
            }
        }
        if (bi.oW(str)) {
            str = getString(a$i.lucky_money_f2f_receive_fail);
        }
        h.a(this, str, "", new 8(this));
        return true;
    }
}
