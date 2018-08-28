package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.y;

public class EmojiStoreV2SingleProductDialogUI extends MMBaseActivity {
    private String ben;
    public String cYO;
    private ProgressBar eWx;
    private c evj;
    private int fdx;
    private long ihD;
    private a ihj = new 6(this);
    private ta iqI = new ta();
    private EmojiInfo iqJ;
    private View iqK;
    private MMAnimateView iqL;
    private ImageView iqM;
    private Button iqN;
    private Button iqO;
    private OnClickListener iqP = new 1(this);
    private OnClickListener iqQ = new 2(this);
    private View.OnClickListener iqR = new 3(this);
    private i iqS = new 4(this);
    private com.tencent.mm.sdk.b.c iqT = new 5(this);
    private ag mHandler = new ag();

    static /* synthetic */ void b(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI, ta taVar) {
        if (taVar != null) {
            EmojiInfo Zy = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(taVar.rwk);
            au.HU();
            String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), taVar.rem, taVar.rwk);
            if (Zy == null && e.cn(L)) {
                int i = o.Wf(L) ? EmojiInfo.tcJ : EmojiInfo.tcI;
                EmojiInfo emojiInfo = new EmojiInfo();
                emojiInfo.field_md5 = taVar.rwk;
                emojiInfo.field_catalog = EmojiInfo.tcB;
                emojiInfo.field_type = i;
                emojiInfo.field_size = e.cm(L);
                emojiInfo.field_temp = 1;
                emojiInfo.field_designerID = taVar.rwl;
                emojiInfo.field_thumbUrl = taVar.lPl;
                com.tencent.mm.plugin.emoji.model.i.aEA().igx.n(emojiInfo);
                Zy = emojiInfo;
            }
            if (Zy != null) {
                com.tencent.mm.plugin.emoji.model.i.aEw().a(emojiStoreV2SingleProductDialogUI, Zy, 5, q.GF());
                return;
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "add failed");
    }

    static /* synthetic */ void e(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        if (emojiStoreV2SingleProductDialogUI.mHandler != null) {
            emojiStoreV2SingleProductDialogUI.mHandler.post(new 8(emojiStoreV2SingleProductDialogUI));
        }
    }

    public void onCreate(Bundle bundle) {
        View view;
        String str;
        c.a aVar;
        c anj;
        super.onCreate(bundle);
        setContentView(R.i.transparent_background);
        this.fdx = getIntent().getIntExtra("scene", 0);
        this.ihD = getIntent().getLongExtra("searchID", 0);
        this.cYO = getIntent().getStringExtra("Select_Conv_User");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("extra_object");
        if (byteArrayExtra != null) {
            try {
                this.iqI = (ta) this.iqI.aG(byteArrayExtra);
                if (this.iqI != null) {
                    this.iqJ = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(this.iqI.rwk);
                    if (!(this.iqJ == null || bi.oW(this.iqJ.field_groupId) || !bi.oW(this.iqI.rem))) {
                        this.iqI.rem = this.iqJ.field_groupId;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", e, "", new Object[0]);
            }
            com.tencent.mm.sdk.b.a.sFg.b(this.iqT);
            com.tencent.mm.plugin.emoji.model.i.aEu().ihj = this.ihj;
            this.iqK = y.gq(this).inflate(R.i.emoji_store_v2_single_product_dialog, null);
            this.eWx = (ProgressBar) this.iqK.findViewById(R.h.dialog_loading);
            this.iqL = (MMAnimateView) this.iqK.findViewById(R.h.dialog_image);
            this.iqM = (ImageView) this.iqK.findViewById(R.h.dialog_close);
            this.iqM.setOnClickListener(this.iqR);
            view = this.iqK;
            str = "";
            if ((this instanceof Activity) || !((Activity) this).isFinishing()) {
                aVar = new c.a(this);
                aVar.abt(str);
                aVar.dR(view);
                aVar.mF(true);
                anj = aVar.anj();
                anj.show();
                h.a(this, anj);
            } else {
                anj = null;
            }
            this.evj = anj;
            this.evj.a(getString(R.l.app_send), false, this.iqP);
            this.evj.b(getString(R.l.app_added), false, this.iqQ);
            this.evj.setOnDismissListener(new 7(this));
            this.iqN = this.evj.getButton(-1);
            this.iqN.setTextColor(getResources().getColor(R.e.green_text_color));
            this.iqO = this.evj.getButton(-2);
            au.HU();
            this.ben = EmojiLogic.L(com.tencent.mm.model.c.Gg(), this.iqI.rem, this.iqI.rwk);
            if (e.cm(this.ben) <= 0) {
                this.iqL.setVisibility(0);
                this.eWx.setVisibility(8);
                this.iqJ = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(this.iqI.rwk);
                if (this.iqJ == null || (this.iqJ.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
                    this.iqL.setImageFilePath(this.ben);
                } else {
                    this.iqL.g(((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.iqJ), "");
                }
                aGf();
            }
            this.iqL.setVisibility(8);
            this.eWx.setVisibility(0);
            this.iqO.setText(R.l.emoji_store_add_emoji);
            this.iqN.setText(R.l.app_send);
            this.iqO.setEnabled(false);
            this.iqO.setTextColor(getResources().getColor(R.e.grey_btn_color_disable));
            this.iqN.setEnabled(false);
            this.iqN.setTextColor(getResources().getColor(R.e.grey_btn_color_disable));
            com.tencent.mm.ak.a.a aDZ = com.tencent.mm.plugin.emoji.model.i.aDZ();
            String str2 = this.iqI.jPK;
            str = this.iqI.jPK;
            aDZ.a(str2, null, f.o(this.ben, new Object[]{this.iqI}), this.iqS);
            return;
        }
        setResult(0);
        finish();
        com.tencent.mm.sdk.b.a.sFg.b(this.iqT);
        com.tencent.mm.plugin.emoji.model.i.aEu().ihj = this.ihj;
        this.iqK = y.gq(this).inflate(R.i.emoji_store_v2_single_product_dialog, null);
        this.eWx = (ProgressBar) this.iqK.findViewById(R.h.dialog_loading);
        this.iqL = (MMAnimateView) this.iqK.findViewById(R.h.dialog_image);
        this.iqM = (ImageView) this.iqK.findViewById(R.h.dialog_close);
        this.iqM.setOnClickListener(this.iqR);
        view = this.iqK;
        str = "";
        if (this instanceof Activity) {
        }
        aVar = new c.a(this);
        aVar.abt(str);
        aVar.dR(view);
        aVar.mF(true);
        anj = aVar.anj();
        anj.show();
        h.a(this, anj);
        this.evj = anj;
        this.evj.a(getString(R.l.app_send), false, this.iqP);
        this.evj.b(getString(R.l.app_added), false, this.iqQ);
        this.evj.setOnDismissListener(new 7(this));
        this.iqN = this.evj.getButton(-1);
        this.iqN.setTextColor(getResources().getColor(R.e.green_text_color));
        this.iqO = this.evj.getButton(-2);
        au.HU();
        this.ben = EmojiLogic.L(com.tencent.mm.model.c.Gg(), this.iqI.rem, this.iqI.rwk);
        if (e.cm(this.ben) <= 0) {
            this.iqL.setVisibility(8);
            this.eWx.setVisibility(0);
            this.iqO.setText(R.l.emoji_store_add_emoji);
            this.iqN.setText(R.l.app_send);
            this.iqO.setEnabled(false);
            this.iqO.setTextColor(getResources().getColor(R.e.grey_btn_color_disable));
            this.iqN.setEnabled(false);
            this.iqN.setTextColor(getResources().getColor(R.e.grey_btn_color_disable));
            com.tencent.mm.ak.a.a aDZ2 = com.tencent.mm.plugin.emoji.model.i.aDZ();
            String str22 = this.iqI.jPK;
            str = this.iqI.jPK;
            aDZ2.a(str22, null, f.o(this.ben, new Object[]{this.iqI}), this.iqS);
            return;
        }
        this.iqL.setVisibility(0);
        this.eWx.setVisibility(8);
        this.iqJ = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(this.iqI.rwk);
        if (this.iqJ == null || (this.iqJ.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
            this.iqL.setImageFilePath(this.ben);
        } else {
            this.iqL.g(((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.iqJ), "");
        }
        aGf();
    }

    protected void onResume() {
        super.onResume();
        aGf();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9001 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bi.oW(stringExtra) && this.iqI != null) {
                x.d("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "UserName:%s ,MD5:%s", stringExtra, this.iqI.rwk);
                a(stringExtra, this.iqI);
                com.tencent.mm.plugin.messenger.a.g.bcT().dF(intent.getStringExtra("custom_send_text"), stringExtra);
            }
        }
    }

    private void aGf() {
        this.iqJ = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(this.iqI.rwk);
        if (this.iqJ != null && this.iqJ.field_catalog == EmojiGroupInfo.tcA && bi.oW(this.iqJ.field_groupId)) {
            this.iqO.setEnabled(false);
            this.iqO.setText(R.l.app_added);
            this.iqO.setTextColor(getResources().getColor(R.e.grey_btn_color_disable));
        } else if (e.cn(this.ben)) {
            this.iqO.setEnabled(true);
            this.iqO.setText(R.l.emoji_store_add_emoji);
            this.iqO.setTextColor(getResources().getColor(R.e.green_text_color));
        } else {
            this.iqO.setEnabled(false);
            this.iqO.setEnabled(false);
            this.iqO.setText(R.l.emoji_store_add_emoji);
            this.iqO.setTextColor(getResources().getColor(R.e.grey_btn_color_disable));
        }
    }

    private void a(String str, ta taVar) {
        if (bi.oW(str) || taVar == null) {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "username or emoji is null.");
            return;
        }
        EmojiInfo emojiInfo;
        EmojiInfo Zy = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(taVar.rwk);
        if (Zy == null) {
            au.HU();
            String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), taVar.rem, taVar.rwk);
            if (e.cn(L)) {
                Zy = com.tencent.mm.plugin.emoji.model.i.aEA().igx.b(taVar.rwk, "", EmojiInfo.tcB, o.Wf(L) ? EmojiInfo.tcJ : EmojiInfo.tcI, e.cm(L), "");
                Zy.field_designerID = taVar.rwl;
                Zy.field_thumbUrl = taVar.lPl;
            }
            emojiInfo = Zy;
        } else {
            Zy.field_designerID = taVar.rwl;
            Zy.field_thumbUrl = taVar.lPl;
            emojiInfo = Zy;
        }
        for (String str2 : bi.F(bi.aG(str, "").split(","))) {
            if (emojiInfo != null) {
                com.tencent.mm.plugin.emoji.model.i.aEw().a(str2, emojiInfo, null);
                setResult(-1);
                finish();
                overridePendingTransition(R.a.pop_in, R.a.pop_out);
            }
        }
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.iqT);
        com.tencent.mm.plugin.emoji.model.i.aEu().ihj = null;
        super.onDestroy();
    }
}
