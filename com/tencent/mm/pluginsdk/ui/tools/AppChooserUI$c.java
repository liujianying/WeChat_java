package com.tencent.mm.pluginsdk.ui.tools;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

class AppChooserUI$c {
    boolean knb;
    boolean oEK;
    final /* synthetic */ AppChooserUI qRB;
    ResolveInfo qRF;
    CharSequence qRG;
    Drawable qRH;
    boolean qRI;
    boolean qRJ;

    public AppChooserUI$c(AppChooserUI appChooserUI) {
        this.qRB = appChooserUI;
    }

    public AppChooserUI$c(AppChooserUI appChooserUI, ResolveInfo resolveInfo, CharSequence charSequence) {
        this.qRB = appChooserUI;
        this.qRF = resolveInfo;
        this.qRG = charSequence;
        this.qRI = false;
        this.oEK = true;
        this.qRJ = false;
    }
}
