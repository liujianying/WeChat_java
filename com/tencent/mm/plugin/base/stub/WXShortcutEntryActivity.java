package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.ah.b;
import com.tencent.mm.plugin.ah.c;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;

public class WXShortcutEntryActivity extends AutoLoginActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final boolean A(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
            finish();
            return;
        }
        c cVar = c.nbP;
        int a = s.a(intent, "type", 0);
        if (intent != null) {
            b bVar = (b) cVar.nbQ.get(a);
            if (bVar != null) {
                bVar.l(this, intent);
            }
        }
        finish();
    }
}
