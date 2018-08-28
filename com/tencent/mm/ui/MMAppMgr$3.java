package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.mm.sdk.platformtools.e;

class MMAppMgr$3 implements OnClickListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ SharedPreferences pGE;
    final /* synthetic */ CheckBox vLN;
    final /* synthetic */ OnClickListener vLO;

    MMAppMgr$3(CheckBox checkBox, SharedPreferences sharedPreferences, Activity activity, OnClickListener onClickListener) {
        this.vLN = checkBox;
        this.pGE = sharedPreferences;
        this.ews = activity;
        this.vLO = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.vLN.isChecked()) {
            Editor edit = this.pGE.edit();
            edit.putBoolean("gprs_alert", false);
            edit.commit();
        }
        e.sFD = false;
        dialogInterface.dismiss();
        MMAppMgr.go(this.ews);
        if (this.vLO != null) {
            this.vLO.onClick(dialogInterface, i);
        }
    }
}
