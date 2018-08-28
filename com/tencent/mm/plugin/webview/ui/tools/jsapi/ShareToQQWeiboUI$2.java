package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.ui.base.h;

class ShareToQQWeiboUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShareToQQWeiboUI qkz;

    ShareToQQWeiboUI$2(ShareToQQWeiboUI shareToQQWeiboUI) {
        this.qkz = shareToQQWeiboUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        final w wVar = new w(this.qkz.getIntent().getIntExtra("type", 0), this.qkz.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.a(this.qkz).getText().toString());
        au.DF().a(wVar, 0);
        ShareToQQWeiboUI shareToQQWeiboUI = this.qkz;
        ActionBarActivity actionBarActivity = this.qkz.mController.tml;
        this.qkz.getString(R.l.app_tip);
        ShareToQQWeiboUI.a(shareToQQWeiboUI, h.a(actionBarActivity, this.qkz.getString(R.l.main_sending), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                au.DF().c(wVar);
            }
        }));
        return true;
    }
}
