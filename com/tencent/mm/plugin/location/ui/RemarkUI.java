package com.tencent.mm.plugin.location.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.plugin.map.a$f;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return a$f.remark_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(h.location_remark_hint);
        CharSequence stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (bi.oW(stringExtra)) {
            findViewById(e.location_info_ll).setVisibility(8);
        } else {
            ((TextView) findViewById(e.location_text_tv)).setText(stringExtra);
        }
    }

    protected final void w(CharSequence charSequence) {
        long longExtra = getIntent().getLongExtra("kFavInfoLocalId", -1);
        if (longExtra > 0) {
            String charSequence2 = charSequence == null ? "" : charSequence.toString();
            x.i("MicroMsg.MMTextInputUI", "same remark[%s]", new Object[]{charSequence2});
            if (!charSequence2.equals(getIntent().getStringExtra("kRemark"))) {
                ch chVar = new ch();
                chVar.bJF.type = -2;
                chVar.bJF.bJv = Long.toString(longExtra);
                chVar.bJF.desc = charSequence2;
                x.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", new Object[]{chVar.bJF.bJv, chVar.bJF.desc});
                a.sFg.m(chVar);
            }
        }
    }
}
