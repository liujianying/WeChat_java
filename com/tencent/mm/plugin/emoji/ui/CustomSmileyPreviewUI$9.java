package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.sdk.platformtools.bi;

class CustomSmileyPreviewUI$9 implements Runnable {
    final /* synthetic */ CustomSmileyPreviewUI ikY;

    CustomSmileyPreviewUI$9(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.ikY = customSmileyPreviewUI;
    }

    public final void run() {
        if (CustomSmileyPreviewUI.h(this.ikY) != null && CustomSmileyPreviewUI.h(this.ikY).rHt != null) {
            CustomSmileyPreviewUI.i(this.ikY).setVisibility(0);
            CustomSmileyPreviewUI.j(this.ikY).setText(CustomSmileyPreviewUI.h(this.ikY).rHt.jPe);
            if (bi.oW(CustomSmileyPreviewUI.h(this.ikY).rHt.jPG)) {
                CustomSmileyPreviewUI.k(this.ikY).setVisibility(8);
            } else {
                CustomSmileyPreviewUI.k(this.ikY).setVisibility(0);
                o.Pj().a(CustomSmileyPreviewUI.h(this.ikY).rHt.jPG, CustomSmileyPreviewUI.k(this.ikY), f.ct(CustomSmileyPreviewUI.b(this.ikY).field_groupId, CustomSmileyPreviewUI.h(this.ikY).rHt.jPG));
            }
            CustomSmileyPreviewUI.l(this.ikY).setText(R.l.emoji_activity_detail);
            CustomSmileyPreviewUI.i(this.ikY).setOnClickListener(new 1(this));
            CustomSmileyPreviewUI.m(this.ikY).setVisibility(8);
        } else if (CustomSmileyPreviewUI.g(this.ikY) == null || CustomSmileyPreviewUI.g(this.ikY).rHp == null) {
            CustomSmileyPreviewUI.i(this.ikY).setVisibility(8);
        } else {
            CustomSmileyPreviewUI.i(this.ikY).setVisibility(0);
            CustomSmileyPreviewUI.j(this.ikY).setText(CustomSmileyPreviewUI.g(this.ikY).rHp.jPe);
            o.Pj().a(CustomSmileyPreviewUI.g(this.ikY).rHp.rxm, CustomSmileyPreviewUI.k(this.ikY), f.cs(CustomSmileyPreviewUI.b(this.ikY).field_groupId, CustomSmileyPreviewUI.g(this.ikY).rHp.rxm));
            CustomSmileyPreviewUI.m(this.ikY).setVisibility(8);
        }
    }
}
