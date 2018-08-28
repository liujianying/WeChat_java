package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import java.util.Collection;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI extends MMActivity implements OnItemClickListener, e {
    private ProgressDialog eEX;
    private int ihC;
    private String ihI;
    private String iil;
    private adj imA;
    private Button imZ;
    private OnClickListener iqA = new 3(this);
    private TextWatcher iqB = new 4(this);
    private AnimationDrawable iqk;
    private int iqn;
    private EmojiStoreV2RewardBannerView iqo;
    private GridInScrollView iqp;
    private View iqq;
    private View iqr;
    private MMFormInputView iqs;
    private TextView iqt;
    private TextView iqu;
    private b iqv;
    private b iqw;
    private int iqx = a.iqE;
    private boolean iqy = false;
    private OnClickListener iqz = new 2(this);
    private ag mHandler = new 1(this);

    class c {
        TextView iqH;

        public c(View view) {
            this.iqH = (TextView) view.findViewById(R.h.priece);
        }
    }

    static /* synthetic */ void i(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        emojiStoreV2RewardUI.iqx = a.iqE;
        if (emojiStoreV2RewardUI.iqr != null) {
            emojiStoreV2RewardUI.iqr.setVisibility(8);
            emojiStoreV2RewardUI.iqq.setVisibility(0);
            emojiStoreV2RewardUI.iqr.startAnimation(AnimationUtils.loadAnimation(emojiStoreV2RewardUI.mController.tml, R.a.pop_out));
        }
    }

    protected final int getLayoutId() {
        return R.i.emoji_store_v2_rewardl_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iil = getIntent().getStringExtra("extra_id");
        this.ihI = getIntent().getStringExtra("name");
        this.ihC = getIntent().getIntExtra("scene", 0);
        this.iqn = getIntent().getIntExtra("pageType", 0);
        initView();
        this.imA = i.aEA().igC.ZF(this.iil);
        if (this.imA == null || this.imA.rHP == null) {
            et(false);
        } else {
            o.Pj().a(this.imA.rHP.rxs, null, f.h(this.iil, this.imA.rHP.rxs, new Object[0]));
            o.Pj().a(this.imA.rHP.rxt, null, f.h(this.iil, this.imA.rHP.rxt, new Object[0]));
        }
        aL();
        au.DF().a(830, this);
        au.DF().a(822, this);
        h.mEJ.a(408, 0, 1, false);
    }

    protected void onDestroy() {
        au.DF().b(830, this);
        au.DF().b(822, this);
        if (this.iqk != null && this.iqk.isRunning()) {
            this.iqk.stop();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", this.mController.tmG);
        if (this.iqx == a.iqE) {
            if (this.iqy) {
                h.mEJ.a(408, 2, 1, false);
            } else {
                h.mEJ.a(408, 1, 1, false);
                h.mEJ.h(12738, new Object[]{this.iil, Integer.valueOf(this.iqn), Integer.valueOf(this.ihC), Integer.valueOf(4)});
            }
            super.onBackPressed();
            return;
        }
        oS(a.iqE);
    }

    private void oS(int i) {
        if (i == a.iqF) {
            this.iqx = a.iqF;
            if (this.iqr != null) {
                this.iqr.setVisibility(0);
                this.iqr.startAnimation(AnimationUtils.loadAnimation(this.mController.tml, R.a.pop_in));
                this.iqs.getContentEditText().requestFocus();
                showVKB();
                this.iqq.setVisibility(8);
                return;
            }
            return;
        }
        YC();
        this.mHandler.postDelayed(new 5(this), 300);
    }

    protected final void initView() {
        if (bi.oW(this.ihI)) {
            setMMTitle(R.l.emoji_store_reward);
        } else {
            setMMTitle(getString(R.l.emoji_store_reward_to_designer, new Object[]{this.ihI}));
        }
        setMMSubTitle(R.l.wechat_authenticate_safely);
        setBackBtn(new 6(this));
        this.iqq = findViewById(R.h.reward_main);
        this.iqr = findViewById(R.h.reward_other);
        this.iqs = (MMFormInputView) findViewById(R.h.reward_other_price_et);
        this.imZ = (Button) findViewById(R.h.reward_reward_btn);
        this.imZ.setOnClickListener(this.iqz);
        this.imZ.setEnabled(false);
        this.iqs.setInputType(8194);
        this.iqs.addTextChangedListener(this.iqB);
        this.iqs.getContentEditText().setFilters(new InputFilter[]{new LengthFilter(12)});
        this.iqt = (TextView) findViewById(R.h.reward_custom);
        this.iqt.setOnClickListener(this.iqA);
        this.iqu = (TextView) findViewById(R.h.reward_choose_price);
        this.iqo = (EmojiStoreV2RewardBannerView) findViewById(R.h.beg_pic);
        this.iqp = (GridInScrollView) findViewById(16908298);
        this.iqv = new b(this);
        this.iqp.setAdapter(this.iqv);
        this.iqp.setOnItemClickListener(this);
        this.iqk = (AnimationDrawable) getResources().getDrawable(R.g.emoji_doge_loading);
    }

    private void aL() {
        if (this.imA != null) {
            this.iqt.setVisibility(0);
            this.iqu.setVisibility(0);
            if (this.imA.rHP == null || bi.oW(this.imA.rHP.rxr)) {
                this.iqo.setBackgroundDrawable(getResources().getDrawable(R.g.emotion_reward_banner_bg_color));
                this.iqo.setImageDrawable(this.iqk);
                this.iqo.setScaleType(ScaleType.CENTER);
                this.iqk.start();
            } else {
                String str = this.imA.rHP.rxr;
                au.HU();
                String K = EmojiLogic.K(com.tencent.mm.model.c.Gg(), this.iil, str);
                if (com.tencent.mm.a.e.cn(K)) {
                    this.iqo.setImageFilePath(K);
                    this.iqo.setScaleType(ScaleType.FIT_XY);
                    if (this.iqk != null && this.iqk.isRunning()) {
                        this.iqk.stop();
                    }
                } else {
                    o.Pj().a(str, this.iqo, f.h(this.iil, str, new Object[0]), new 7(this, str, K));
                    this.iqo.setBackgroundDrawable(getResources().getDrawable(R.g.emotion_reward_banner_bg_color));
                    this.iqo.setImageDrawable(this.iqk);
                    this.iqo.setScaleType(ScaleType.CENTER);
                    this.iqk.start();
                }
            }
        } else {
            this.iqt.setVisibility(8);
            this.iqu.setVisibility(8);
        }
        if (this.imA == null || this.imA.rHO == null) {
            this.iqp.setVisibility(8);
            return;
        }
        this.iqp.setVisibility(0);
        b bVar = this.iqv;
        Collection collection = this.imA.rHO;
        if (bVar.iqd == null) {
            bVar.iqd = new LinkedList();
        }
        bVar.iqd.clear();
        bVar.iqd.addAll(collection);
        bVar.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.iqv != null) {
            tq oT = this.iqv.oT(i);
            if (oT != null) {
                x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[]{Integer.valueOf(i)});
                a(this.iil, oT);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 8001:
                if (i2 == -1) {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, EmojiStoreV2RewardThanksUI.class);
                    intent2.putExtra("extra_id", this.iil);
                    startActivity(intent2);
                    h.mEJ.h(12738, new Object[]{this.iil, Integer.valueOf(this.iqn), Integer.valueOf(this.ihC), Integer.valueOf(1)});
                    h.mEJ.a(408, 9, 1, false);
                    et(true);
                    finish();
                    return;
                } else if (i2 == 0) {
                    h.mEJ.h(12738, new Object[]{this.iil, Integer.valueOf(this.iqn), Integer.valueOf(this.ihC), Integer.valueOf(3)});
                    h.mEJ.a(408, 3, 1, false);
                    return;
                } else {
                    if (!this.iqy) {
                        this.iqy = true;
                        h.mEJ.h(12738, new Object[]{this.iil, Integer.valueOf(this.iqn), Integer.valueOf(this.ihC), Integer.valueOf(2)});
                    }
                    h.mEJ.a(408, 4, 1, false);
                    return;
                }
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
        switch (lVar.getType()) {
            case 822:
                com.tencent.mm.plugin.emoji.f.o oVar = (com.tencent.mm.plugin.emoji.f.o) lVar;
                if (i == 0 && i2 == 0) {
                    x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
                    this.imA = oVar.aES();
                    o.Pj().a(this.imA.rHP.rxs, null, f.h(this.iil, this.imA.rHP.rxs, new Object[0]));
                    this.mHandler.sendEmptyMessage(1002);
                    return;
                }
                x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
                return;
            case 830:
                b bVar = (b) lVar;
                if (i == 0 && i2 == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("extinfo_key_10", true);
                    ActionBarActivity actionBarActivity = this.mController.tml;
                    String str2 = bVar.aEJ().reo;
                    String str3 = bVar.aEJ().jPc;
                    if (!bi.oW(str2)) {
                        PayInfo I = com.tencent.mm.pluginsdk.wallet.h.I(str2, str3, 5);
                        I.qUL = bundle;
                        com.tencent.mm.pluginsdk.wallet.h.a(actionBarActivity, I, 8001);
                        return;
                    }
                    return;
                } else if (i == 4) {
                    if (!this.iqy) {
                        this.iqy = true;
                        h.mEJ.h(12738, new Object[]{this.iil, Integer.valueOf(this.iqn), Integer.valueOf(this.ihC), Integer.valueOf(2)});
                    }
                    if (i2 == b.iii) {
                        h.mEJ.a(408, 6, 1, false);
                        if (bi.oW(str)) {
                            zK(getString(R.l.emoji_store_reward_magic_pay_limite));
                            return;
                        } else {
                            zK(str);
                            return;
                        }
                    } else if (i2 == b.iij) {
                        h.mEJ.a(408, 7, 1, false);
                        if (bi.oW(str)) {
                            zK(getString(R.l.emoji_store_reward_magic_receive_limite));
                            return;
                        } else {
                            zK(str);
                            return;
                        }
                    } else if (i2 == b.iik) {
                        h.mEJ.a(408, 5, 1, false);
                        if (bi.oW(str)) {
                            zK(getString(R.l.emoji_store_reward_magic_pay_self));
                            return;
                        } else {
                            zK(str);
                            return;
                        }
                    } else {
                        h.mEJ.a(408, 8, 1, false);
                        Toast.makeText(this, getString(R.l.emoji_store_ask_reward_failed), 0).show();
                        return;
                    }
                } else {
                    if (!this.iqy) {
                        this.iqy = true;
                        h.mEJ.h(12738, new Object[]{this.iil, Integer.valueOf(this.iqn), Integer.valueOf(this.ihC), Integer.valueOf(2)});
                    }
                    h.mEJ.a(408, 8, 1, false);
                    Toast.makeText(this, getString(R.l.emoji_store_ask_reward_failed), 0).show();
                    return;
                }
            default:
                x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[]{Integer.valueOf(lVar.getType())});
                return;
        }
    }

    private void a(String str, tq tqVar) {
        WI();
        this.iqw = new b(str, tqVar);
        au.DF().a(this.iqw, 0);
    }

    private void WI() {
        getString(R.l.app_tip);
        this.eEX = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.app_waiting), true, new 8(this));
    }

    private void zK(String str) {
        com.tencent.mm.ui.base.h.a(this.mController.tml, str, null, getString(R.l.emoji_sort_i_know), new 9(this));
    }

    private void et(boolean z) {
        x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
        if (z) {
            au.DF().a(new com.tencent.mm.plugin.emoji.f.o(this.iil, com.tencent.mm.plugin.emoji.f.o.iiS), 0);
            return;
        }
        au.DF().a(new com.tencent.mm.plugin.emoji.f.o(this.iil, com.tencent.mm.plugin.emoji.f.o.iiT), 0);
        WI();
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
