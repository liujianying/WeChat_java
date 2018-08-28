package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.b;
import com.tencent.mm.ui.widget.a.c;
import java.util.ArrayList;
import java.util.List;

public class EmojiAddCustomDialogUI extends MMBaseActivity implements e {
    private ProgressDialog eEX;
    private String fHy;
    private int fdx;
    private String ilc;
    private EmojiInfo ild;
    private c ile;
    private c ilf;
    private Context mContext;
    private ag mHandler = new 1(this);

    static /* synthetic */ void a(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        emojiAddCustomDialogUI.getString(R.l.app_tip);
        emojiAddCustomDialogUI.eEX = h.a(emojiAddCustomDialogUI, str, true, new 7(emojiAddCustomDialogUI));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        this.mContext = this;
        this.fHy = getIntent().getStringExtra("extra_id");
        this.fdx = getIntent().getIntExtra("extra_scence", -1);
        this.ilc = getIntent().getStringExtra("extra_username");
        if (bi.oW(this.fHy)) {
            x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
            finish();
        }
        this.ild = i.aEA().igx.Zy(this.fHy);
        au.DF().a(698, this);
        au.DF().a(423, this);
        au.DF().a(703, this);
        this.mHandler.sendEmptyMessageDelayed(1001, 300);
        Context context = this.mContext;
        EmojiInfo emojiInfo = this.ild;
        if (context == null) {
            x.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
        } else if (emojiInfo == null) {
            x.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
        } else {
            b abg = b.abg(emojiInfo.cnF());
            abg.fi = com.tencent.mm.k.b.Ay();
            abg.Gh(com.tencent.mm.k.b.Az()).a(new 2(this, emojiInfo));
        }
    }

    protected void onDestroy() {
        au.DF().b(698, this);
        au.DF().b(423, this);
        au.DF().b(703, this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, l lVar) {
        int type = lVar.getType();
        if (type == 698) {
            if (i2 == -434) {
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
                aFs();
                aFB();
                com.tencent.mm.plugin.report.service.h.mEJ.h(10431, new Object[]{Integer.valueOf(this.fdx), this.ild.Xh(), this.ild.field_designerID, this.ild.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.ild.field_size), this.ilc, this.ild.field_activityid});
            } else if (i == 0 && i2 == 0) {
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
                er erVar = (er) ((com.tencent.mm.plugin.emoji.f.c) lVar).diG.dIE.dIL;
                if (erVar == null || erVar.rff == null || erVar.rff.size() <= 0) {
                    aFA();
                    return;
                }
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[]{Integer.valueOf(erVar.rff.size())});
                erVar.rff.get(0);
                au.DF().a(new f(this.ild), 0);
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
            } else {
                aFz();
            }
        } else if (type == 423) {
            g gVar = (g) lVar;
            if (gVar == null || bi.oW(gVar.iiv) || this.ild == null || bi.oW(this.ild.field_groupId) || !this.ild.field_groupId.equalsIgnoreCase(gVar.iiv)) {
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                i(this.ild);
            } else if (i2 == 4) {
                aFs();
                zK(getString(R.l.emoji_add_failed_no_play));
            } else if (i2 == 8) {
                aFs();
                zK(getString(R.l.emoji_add_failed_no_area));
            } else if (i2 == 9) {
                aFs();
                zK(getString(R.l.emoji_add_failed_expired));
            } else if (i2 == -2) {
                aFs();
                zK(getString(R.l.emoji_add_failed_no_try));
            } else {
                aFs();
                zK(getString(R.l.emoji_add_failed));
            }
        } else if (type != 703) {
        } else {
            if (i == 0 && i2 == 0) {
                aFA();
            } else {
                aFz();
            }
        }
    }

    private void aFz() {
        x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
        aFs();
        h.bA(this.mContext, ad.getContext().getString(R.l.emoji_add_failed));
        com.tencent.mm.plugin.report.service.h.mEJ.h(10431, new Object[]{Integer.valueOf(this.fdx), this.ild.Xh(), this.ild.field_designerID, this.ild.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(this.ild.field_size), this.ilc, this.ild.field_activityid});
        finish();
    }

    private void aFA() {
        x.d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
        if (this.ild.field_catalog != EmojiInfo.tcH) {
            this.ild.field_catalog = EmojiInfo.tcH;
            int cnM = i.aEA().igx.cnM();
            if (cnM < n.aEj()) {
                cnM = n.aEj();
            } else {
                cnM++;
            }
            this.ild.field_reserved3 = cnM;
            i.aEA().igx.p(this.ild);
            com.tencent.mm.plugin.report.service.h.mEJ.h(10431, new Object[]{Integer.valueOf(this.fdx), this.ild.Xh(), this.ild.field_designerID, this.ild.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.ild.field_size), this.ilc, this.ild.field_activityid});
            com.tencent.mm.plugin.emoji.e.e.aDM().c(this.ild, false);
        }
        String str = this.ild.cnF() + "_cover";
        if (!(bi.oW(this.ild.field_thumbUrl) || com.tencent.mm.a.e.cn(str))) {
            a aVar = new a();
            aVar.dXA = str;
            aVar.dXy = true;
            aVar.dXw = false;
            o.Pj().a(this.ild.field_thumbUrl, null, aVar.Pt());
        }
        com.tencent.mm.storage.emotion.a aVar2 = i.aEA().igy;
        if (!com.tencent.mm.storage.emotion.a.cnl()) {
            i.aEA().igy.cnm();
        }
        aFs();
        h.bA(this.mContext, ad.getContext().getString(R.l.app_added));
        finish();
    }

    private static void i(EmojiInfo emojiInfo) {
        x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate ");
        List arrayList = new ArrayList();
        arrayList.add(emojiInfo.Xh());
        au.DF().a(new com.tencent.mm.plugin.emoji.f.c(1, arrayList), 0);
    }

    private void aFB() {
        this.ile = h.a(this.mContext, R.l.emoji_upper_limit_warning, R.l.app_empty_string, R.l.emoji_store_mgr_alert, R.l.app_cancel, new 3(this), new 4(this));
        if (this.ile != null) {
            this.ile.setOnDismissListener(new 5(this));
        }
    }

    private void zK(String str) {
        this.ilf = h.b(this, str, "", true);
        this.ilf.setOnDismissListener(new 8(this));
    }

    protected final void aFs() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1001);
        }
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
    }
}
