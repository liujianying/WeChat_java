package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class ComposeUI$22 implements OnClickListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$22(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.mfs, MailAddrListUI.class);
        intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.f(this.mfs).a(false, null));
        intent.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
        this.mfs.startActivityForResult(intent, 2);
        this.mfs.overridePendingTransition(R.a.push_up_in, R.a.fast_faded_out);
    }
}
