package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.rtmp.TXLiveConstants;

public class EmojiStoreTopicUI extends BaseEmojiStoreUI {
    private int fdx;
    private int inD;
    private String inE;
    private String inF;
    private String inG;
    private String inH;
    private String inI;

    static /* synthetic */ void c(EmojiStoreTopicUI emojiStoreTopicUI) {
        d dVar = new d(emojiStoreTopicUI.mController.tml, 1, false);
        dVar.ofp = new 3(emojiStoreTopicUI);
        dVar.ofq = new 4(emojiStoreTopicUI);
        dVar.bXO();
        h.mEJ.h(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(emojiStoreTopicUI.inD)});
    }

    protected final void aFc() {
        super.aFc();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.mEJ.h(12740, new Object[]{Integer.valueOf(3), "", "", Integer.valueOf(this.inD), Integer.valueOf(this.fdx)});
    }

    protected final void initView() {
        this.inD = getIntent().getIntExtra("topic_id", -1);
        this.inE = getIntent().getStringExtra("topic_name");
        this.inH = getIntent().getStringExtra("topic_ad_url");
        this.inF = getIntent().getStringExtra("topic_icon_url");
        this.inG = getIntent().getStringExtra("topic_desc");
        this.inI = getIntent().getStringExtra("sns_object_data");
        this.fdx = getIntent().getIntExtra("extra_scence", 0);
        if (!bi.oW(this.inI)) {
            this.inD = EmojiLogic.zw(this.inI);
            this.inE = EmojiLogic.zx(this.inI);
            this.inF = EmojiLogic.zz(this.inI);
            this.inG = EmojiLogic.zy(this.inI);
            this.inH = EmojiLogic.zA(this.inI);
        }
        setMMTitle(this.inE);
        super.initView();
        addIconOptionMenu(0, R.k.ofm_send_icon, new 1(this));
        showOptionMenu(0, false);
        zJ(this.inH);
    }

    protected final void zJ(String str) {
        if (this.ikd != null && this.ike != null && !bi.oW(str)) {
            a.getDensity(this);
            EmojiInfo a = EmojiLogic.a("Toptic", 8, str, true);
            if (a == null) {
                o.Pj().a(str, null, f.g("Toptic", str, new Object[]{"Toptic", "BANNER"}), new 2(this));
                return;
            }
            this.ike.setImageFilePath(a.cnF());
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void a(com.tencent.mm.plugin.emoji.model.f fVar, boolean z, boolean z2) {
        super.a(fVar, z, z2);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        aFs();
        if (i == TXLiveConstants.PLAY_EVT_RTMP_STREAM_BEGIN && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bi.oW(stringExtra)) {
                x.d("MicroMsg.emoji.EmojiStoreTopicUI", ".." + stringExtra);
                int i3 = this.inD;
                String str = this.inE;
                String str2 = this.inG;
                String str3 = this.inF;
                String str4 = this.inH;
                i.aEw();
                k.a(this, stringExtra, 26, i3, str, str2, str3, str4, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void a(boolean z, com.tencent.mm.plugin.emoji.model.f fVar, boolean z2, boolean z3) {
        super.a(z, fVar, z2, z3);
    }

    protected final int aFm() {
        return 7;
    }

    public final int aFn() {
        return this.inD;
    }

    protected final boolean aFt() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a aFf() {
        return new com.tencent.mm.plugin.emoji.a.f(this.mController.tml);
    }

    protected final boolean aFk() {
        if (bi.oW(this.inH)) {
            return false;
        }
        return true;
    }

    protected final boolean aFj() {
        return false;
    }

    public final void l(Message message) {
        super.l(message);
        if (message.what == 1009) {
            zJ(this.inH);
        }
    }

    protected final int aFd() {
        return 11;
    }

    protected final int aFe() {
        return 14;
    }

    public final void a(int i, int i2, String str, l lVar) {
        super.a(i, i2, str, lVar);
        if (this.ikh) {
            showOptionMenu(0, false);
        } else {
            showOptionMenu(0, true);
        }
    }
}
