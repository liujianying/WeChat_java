package com.tencent.mm.plugin.emoji.ui.v2;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.support.v4.view.ViewPager.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.mogic.WxViewPager;

class EmojiStoreV2UI$a extends p implements e, a {
    private boolean irW = false;
    final /* synthetic */ EmojiStoreV2UI irY;
    private WxViewPager irZ;

    public EmojiStoreV2UI$a(EmojiStoreV2UI emojiStoreV2UI, FragmentActivity fragmentActivity, WxViewPager wxViewPager, boolean z) {
        this.irY = emojiStoreV2UI;
        super(fragmentActivity.getSupportFragmentManager());
        this.irW = z;
        this.irZ = wxViewPager;
        this.irZ.setAdapter(this);
        this.irZ.setOnPageChangeListener(this);
        this.irZ.setCurrentItem(EmojiStoreV2UI.b(emojiStoreV2UI));
        d.fS(11);
        if (EmojiStoreV2UI.c(emojiStoreV2UI) != null) {
            EmojiStoreV2UI.c(emojiStoreV2UI).setOnTabClickListener(this);
        }
    }

    /* renamed from: oX */
    public final a V(int i) {
        return this.irY.oW(i);
    }

    public final int getCount() {
        if (this.irW) {
            return 2;
        }
        return 1;
    }

    public final void a(int i, float f, int i2) {
        if (EmojiStoreV2UI.c(this.irY) != null) {
            EmojiStoreV2UI.c(this.irY).h(i, f);
        }
    }

    public final void O(int i) {
        x.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", new Object[]{Integer.valueOf(i)});
        EmojiStoreV2UI.a(this.irY, i);
        if (EmojiStoreV2UI.c(this.irY) != null) {
            EmojiStoreV2UI.c(this.irY).setTo(i);
        }
        if (EmojiStoreV2UI.b(this.irY) == 1 && !EmojiStoreV2UI.d(this.irY)) {
            h.mEJ.h(12090, new Object[0]);
            EmojiStoreV2UI emojiStoreV2UI = this.irY;
            au.HU();
            c.DT().a(aa.a.sOX, Boolean.valueOf(false));
            if (emojiStoreV2UI.irT != null) {
                emojiStoreV2UI.irT.eu(false);
            }
            EmojiStoreV2UI.e(this.irY);
        }
    }

    public final void N(int i) {
        x.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", new Object[]{Integer.valueOf(i)});
        if (i == 0 && this.irY.oW(EmojiStoreV2UI.b(this.irY)) != null) {
            a oW = this.irY.oW(EmojiStoreV2UI.b(this.irY));
            if (oW.CU != null && oW.ihz != null && oW.aGk()) {
                oW.ihz.aoV();
            }
        }
    }

    public final void oV(int i) {
        if (i != EmojiStoreV2UI.b(this.irY)) {
            this.irZ.k(i, false);
        }
        EmojiStoreV2UI.a(this.irY, i);
    }
}
