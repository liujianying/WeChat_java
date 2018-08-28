package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.websearch.api.ad;

public class FTSWebViewUI extends FTSBaseWebViewUI {
    protected final String getHint() {
        return getString(R.l.app_search);
    }

    protected final void ant() {
        super.ant();
        ad.Ab(this.scene);
        if (this.scene == 21) {
            ad.Ad(17);
        }
    }

    protected void onResume() {
        super.onResume();
        ad.bTj();
    }

    protected void onPause() {
        super.onPause();
        ad.bTk();
    }

    protected void onDestroy() {
        super.onDestroy();
        ad.bTl();
        ad.bTm();
        if (this.scene == 21) {
            ad.Ad(18);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        bXz();
    }

    public void onClickCancelBtn(View view) {
        super.onClickCancelBtn(view);
        finish();
    }

    private void bXz() {
        if (this.scene == 21) {
            ad.Ad(19);
        }
    }

    protected final void bWw() {
        bXz();
        super.bWw();
    }
}
