package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class SnsSelectContactDialog$2 implements OnClickListener {
    final /* synthetic */ SnsSelectContactDialog nZA;

    SnsSelectContactDialog$2(SnsSelectContactDialog snsSelectContactDialog) {
        this.nZA = snsSelectContactDialog;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Select_Contact", bi.c(SnsSelectContactDialog.c(this.nZA), ","));
        this.nZA.setResult(-1, intent);
        this.nZA.finish();
    }
}
