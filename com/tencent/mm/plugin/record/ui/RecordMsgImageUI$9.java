package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n$d;

class RecordMsgImageUI$9 implements n$d {
    final /* synthetic */ RecordMsgImageUI mtp;

    RecordMsgImageUI$9(RecordMsgImageUI recordMsgImageUI) {
        this.mtp = recordMsgImageUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                RecordMsgImageUI.f(this.mtp);
                return;
            case 1:
                RecordMsgImageUI recordMsgImageUI = this.mtp;
                ch chVar = new ch();
                e.a(chVar, recordMsgImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), recordMsgImageUI.bqL());
                chVar.bJF.bJM = 10;
                chVar.bJF.activity = recordMsgImageUI;
                a.sFg.m(chVar);
                return;
            case 2:
                RecordMsgImageUI.g(this.mtp);
                return;
            case 3:
                String h = RecordMsgImageUI.h(this.mtp);
                if (!bi.oW(h)) {
                    mu muVar = (mu) RecordMsgImageUI.i(this.mtp).get(h);
                    if (muVar != null) {
                        cb cbVar = new cb();
                        cbVar.bJq.activity = this.mtp;
                        cbVar.bJq.bHL = muVar.bXK.result;
                        cbVar.bJq.bJr = muVar.bXK.bJr;
                        cbVar.bJq.bJt = 8;
                        RecordMsgImageUI.a(this.mtp, cbVar);
                        cbVar.bJq.bJs = muVar.bXK.bJs;
                        if (this.mtp.getIntent() != null) {
                            cbVar.bJq.bJx = this.mtp.getIntent().getBundleExtra("_stat_obj");
                        }
                        a.sFg.m(cbVar);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
