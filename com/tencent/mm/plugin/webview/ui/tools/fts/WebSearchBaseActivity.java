package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.tencent.mm.R;

public abstract class WebSearchBaseActivity extends CustomStatusBarMMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cqf();
        nS(-16777216);
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.e.websearch_bg));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.websearch_bg)));
        }
        setBackBtn(new 1(this));
    }

    protected final int getStatusBarColor() {
        return getResources().getColor(R.e.websearch_bg);
    }
}
