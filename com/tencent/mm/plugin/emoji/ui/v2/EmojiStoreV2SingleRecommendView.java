package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.y;

public class EmojiStoreV2SingleRecommendView extends RecommendView implements OnClickListener, b {
    private ViewGroup goL;
    private String iil;
    private g ijT;
    protected final int ikp = 131074;
    private final int ikq = 131075;
    private final int ikr = 131076;
    private final String iks = "product_id";
    private final String ikt = "progress";
    private final String iku = "status";
    private ImageView imM;
    private String inf;
    private ag ioW = new 1(this);
    private TextView irA;
    private TextView irB;
    private Button irC;
    private ProgressBar irD;
    private EmojiGroupInfo irE;
    private boolean irF = true;
    private c irG = new 2(this);
    private ImageView irz;

    public EmojiStoreV2SingleRecommendView(Context context, boolean z) {
        super(context);
        this.irF = z;
        init();
    }

    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @TargetApi(11)
    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
        a.sFg.b(this.irG);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
        a.sFg.c(this.irG);
    }

    private void init() {
        if (this.irF) {
            this.goL = (ViewGroup) y.gq(getContext()).inflate(R.i.emoji_store_v2_single_recommend, this);
        } else {
            this.goL = (ViewGroup) y.gq(getContext()).inflate(R.i.emoji_store_v2_single_recommend_land, this);
        }
        this.imM = (ImageView) this.goL.findViewById(R.h.emoji_close);
        this.irz = (ImageView) this.goL.findViewById(R.h.emoji_icon);
        this.irA = (TextView) this.goL.findViewById(R.h.emoji_title);
        this.irB = (TextView) this.goL.findViewById(R.h.emoji_word);
        this.irC = (Button) this.goL.findViewById(R.h.emoji_download);
        this.irD = (ProgressBar) this.goL.findViewById(R.h.emoji_download_progress);
    }

    public void setProductID(String str) {
        this.iil = str;
        if (bi.oW(this.iil)) {
            this.goL.setVisibility(8);
            return;
        }
        this.irE = i.aEA().igy.br(this.iil, false);
        this.imM.setOnClickListener(this);
        this.irC.setOnClickListener(this);
        this.goL.setOnClickListener(this);
        setTitleName(this.irE);
        this.irD.setVisibility(8);
        o.Pj().a(this.irE.field_BigIconUrl, this.irz, f.g(this.iil, this.irE.field_BigIconUrl, new Object[0]));
    }

    private void setTitleName(EmojiGroupInfo emojiGroupInfo) {
        if (this.irC != null) {
            switch (emojiGroupInfo.field_buttonType) {
                case 1:
                    this.irC.setVisibility(0);
                    this.irC.setText(R.l.emoji_store_download);
                    break;
                case 2:
                    this.irC.setVisibility(0);
                    this.irC.setText(R.l.menu_show_emoji_detail);
                    break;
                default:
                    this.irC.setVisibility(8);
                    break;
            }
        }
        if (!bi.oW(emojiGroupInfo.field_packName)) {
            this.irA.setText(emojiGroupInfo.field_packName);
        }
        if (this.irB == null) {
            return;
        }
        if (bi.oW(emojiGroupInfo.field_recommandWord)) {
            this.irB.setVisibility(8);
            return;
        }
        this.irB.setVisibility(0);
        this.irB.setText(emojiGroupInfo.field_recommandWord);
    }

    public final void M(String str, String str2, String str3) {
        au.DF().a(new g(str, str2, str3), 0);
    }

    public final void aEs() {
    }

    public final void m(Message message) {
        if (this.ioW != null) {
            this.ioW.sendMessage(message);
        }
    }

    private void c(ts tsVar) {
        Intent intent = new Intent();
        intent.setClass(getContext(), EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", tsVar.rem);
        intent.putExtra("extra_name", tsVar.rwQ);
        intent.putExtra("extra_copyright", tsVar.rxa);
        intent.putExtra("extra_coverurl", tsVar.rwY);
        intent.putExtra("extra_description", tsVar.rwR);
        intent.putExtra("extra_price", tsVar.rwT);
        intent.putExtra("extra_type", tsVar.rwU);
        intent.putExtra("extra_flag", tsVar.rwV);
        intent.putExtra("extra_price_num", tsVar.rxb);
        intent.putExtra("extra_price_type", tsVar.rxc);
        intent.putExtra("preceding_scence", 108);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", 8);
        intent.putExtra("check_clickflag", false);
        getContext().startActivity(intent);
    }

    public void onClick(View view) {
        if (view == this.imM) {
            i.aEA().igy.Zu(this.iil);
            h.mEJ.h(12068, new Object[]{Integer.valueOf(2), this.iil, Integer.valueOf(this.irE.field_recommandType)});
        } else if (view == this.goL) {
            c(this.irE.cnc());
            h.mEJ.h(12068, new Object[]{Integer.valueOf(4), this.iil, Integer.valueOf(this.irE.field_recommandType)});
        } else if (view != this.irC) {
            x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
        } else if (this.irE.field_buttonType == 1) {
            this.ijT = new g(this.iil);
            au.DF().a(this.ijT, 0);
            h.mEJ.h(12068, new Object[]{Integer.valueOf(3), this.iil, Integer.valueOf(this.irE.field_recommandType)});
            h.mEJ.h(12066, new Object[]{Integer.valueOf(0), Integer.valueOf(8), "", this.iil});
        } else if (this.irE.field_buttonType == 2) {
            c(this.irE.cnc());
            h.mEJ.h(12068, new Object[]{Integer.valueOf(4), this.iil, Integer.valueOf(this.irE.field_recommandType)});
        } else {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
        }
    }
}
