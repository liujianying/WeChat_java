package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class SnsTransparentUI extends MMActivity {
    private Map<String, Bitmap> nEi = new HashMap();

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        Intent intent = getIntent();
        if (intent != null) {
            switch (intent.getIntExtra("op", -1)) {
                case 2:
                    String stringExtra = intent.getStringExtra("adlandingXml");
                    String stringExtra2 = intent.getStringExtra("shareTitle");
                    String stringExtra3 = intent.getStringExtra("shareThumbUrl");
                    String stringExtra4 = intent.getStringExtra("shareDesc");
                    String stringExtra5 = intent.getStringExtra("shareUrl");
                    String stringExtra6 = intent.getStringExtra("statExtStr");
                    x.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI");
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", 259);
                    intent2.putExtra("select_is_ret", true);
                    d.a(this, ".ui.transmit.SelectConversationUI", intent2, 0, new 1(this, stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6));
                    return;
                case 4:
                    c.a.qPG.a(this, intent.getStringExtra("phoneNum"), new 2(this), new Bundle());
                    return;
                default:
                    return;
            }
        }
    }
}
