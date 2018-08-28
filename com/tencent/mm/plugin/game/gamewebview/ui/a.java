package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    private String jIA;
    private String jIB;
    boolean jIv;
    private String jIw;
    private String jIx;
    private String jIy;
    private String jIz;
    private String lang = w.fD(ad.getContext());

    public a(Bundle bundle) {
        this.jIv = bundle.getBoolean("close_window_confirm_dialog_switch");
        this.jIw = bundle.getString("close_window_confirm_dialog_title_cn");
        this.jIx = bundle.getString("close_window_confirm_dialog_title_eng");
        this.jIy = bundle.getString("close_window_confirm_dialog_ok_cn");
        this.jIz = bundle.getString("close_window_confirm_dialog_ok_eng");
        this.jIA = bundle.getString("close_window_confirm_dialog_cancel_cn");
        this.jIB = bundle.getString("close_window_confirm_dialog_cancel_eng");
    }

    public final String aSC() {
        if ("zh_CN".equals(this.lang)) {
            return this.jIw;
        }
        return this.jIx;
    }

    public final String aSD() {
        if ("zh_CN".equals(this.lang)) {
            return this.jIy;
        }
        return this.jIz;
    }

    public final String aSE() {
        if ("zh_CN".equals(this.lang)) {
            return this.jIA;
        }
        return this.jIB;
    }
}
