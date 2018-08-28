package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public class EmojiStoreV2RewardThanksUI extends MMActivity {
    private String iil;
    private adj imA;
    private EmojiStoreV2RewardBannerView iqf;
    private View iqg;
    private MMCopiableTextView iqh;
    private TextView iqi;
    private TextView iqj;
    private AnimationDrawable iqk;
    private ag mHandler = new 1(this);

    protected final int getLayoutId() {
        return R.i.emoji_store_v2_reward_thanks_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iil = getIntent().getStringExtra("extra_id");
        initView();
        this.imA = i.aEA().igC.ZF(this.iil);
        if (this.imA == null) {
            this.iqf.setBackgroundDrawable(getResources().getDrawable(R.g.emotion_reward_banner_bg_color));
            this.iqf.setImageDrawable(this.iqk);
            this.iqf.setScaleType(ScaleType.CENTER);
            this.iqk.start();
        } else if (this.imA.rHP == null || bi.oW(this.imA.rHP.rxr)) {
            this.iqf.setBackgroundDrawable(getResources().getDrawable(R.g.emotion_reward_banner_bg_color));
            this.iqf.setImageDrawable(this.iqk);
            this.iqf.setScaleType(ScaleType.CENTER);
            this.iqk.start();
        } else {
            final String str = this.imA.rHP.rxs;
            au.HU();
            final String K = EmojiLogic.K(c.Gg(), this.iil, str);
            if (e.cn(K)) {
                this.iqf.setImageFilePath(K);
                this.iqf.setScaleType(ScaleType.FIT_XY);
                if (this.iqk != null && this.iqk.isRunning()) {
                    this.iqk.stop();
                }
            } else {
                o.Pj().a(str, this.iqf, f.h(this.iil, str, new Object[0]), new com.tencent.mm.ak.a.c.i() {
                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        if (!bi.oW(str) && str.equalsIgnoreCase(str)) {
                            Message message = new Message();
                            message.what = 1001;
                            message.obj = K;
                            EmojiStoreV2RewardThanksUI.this.mHandler.sendMessage(message);
                        }
                    }
                });
                this.iqf.setBackgroundDrawable(getResources().getDrawable(R.g.emotion_reward_banner_bg_color));
                this.iqf.setImageDrawable(this.iqk);
                this.iqf.setScaleType(ScaleType.CENTER);
                this.iqk.start();
            }
        }
        if (this.imA == null || this.imA.rHP == null) {
            this.iqg.setVisibility(8);
            return;
        }
        this.iqg.setVisibility(0);
        bi.oW(this.imA.rHP.rxu);
        this.iqh.setVisibility(0);
        this.iqh.setText(R.l.emoji_store_reward_thanks_msg);
        this.iqi.setVisibility(8);
        this.iqj.setVisibility(8);
    }

    protected void onDestroy() {
        if (this.iqk != null && this.iqk.isRunning()) {
            this.iqk.stop();
        }
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.emoji_store_reward_thanks);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmojiStoreV2RewardThanksUI.this.finish();
                return false;
            }
        });
        this.iqf = (EmojiStoreV2RewardBannerView) findViewById(R.h.thanks_pic);
        this.iqf.setScale(1.0f);
        this.iqg = findViewById(R.h.magic_word_container);
        this.iqh = (MMCopiableTextView) findViewById(R.h.magic_word_tip);
        this.iqi = (TextView) findViewById(R.h.magic_expire);
        this.iqj = (TextView) findViewById(R.h.magic_word_info);
        this.iqk = (AnimationDrawable) getResources().getDrawable(R.g.emoji_doge_loading);
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
