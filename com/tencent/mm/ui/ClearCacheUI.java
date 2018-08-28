package com.tencent.mm.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

public class ClearCacheUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.a(this, getIntent().getStringExtra("key_message"), getString(R.l.clear_cache_title), getString(R.l.clear_cache_now), getString(R.l.clear_cache_cancel), false, new 1(this, getIntent().getLongExtra("key_mask", 0)), new 2(this));
    }
}
