package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class DisasterUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.DisasterUI", "summerdiz onCreate :%d, content[%s], url[%s]", new Object[]{Integer.valueOf(hashCode()), getIntent().getStringExtra("key_disaster_content"), getIntent().getStringExtra("key_disaster_url")});
        ((TextView) findViewById(f.notify_text)).setText(r1);
        findViewById(f.notify_link).setOnClickListener(new 1(this, r2));
        setMMTitle(getString(j.disaster_tips));
        setBackBtn(new 2(this));
    }

    protected final int getLayoutId() {
        return g.disaster_ui;
    }

    public final boolean needShowIdcError() {
        return false;
    }
}
