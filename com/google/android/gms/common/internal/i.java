package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;

public final class i implements OnClickListener {
    private final Intent Hq;
    private final Fragment aNT;
    private final int aNU;
    private final Activity mActivity;

    public i(Activity activity, Intent intent) {
        this.mActivity = activity;
        this.aNT = null;
        this.Hq = intent;
        this.aNU = 2;
    }

    public i(Fragment fragment, Intent intent) {
        this.mActivity = null;
        this.aNT = fragment;
        this.Hq = intent;
        this.aNU = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.Hq != null && this.aNT != null) {
                this.aNT.startActivityForResult(this.Hq, this.aNU);
            } else if (this.Hq != null) {
                this.mActivity.startActivityForResult(this.Hq, this.aNU);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
        }
    }
}
