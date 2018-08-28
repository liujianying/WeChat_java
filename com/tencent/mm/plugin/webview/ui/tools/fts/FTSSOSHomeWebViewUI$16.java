package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.au.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

class FTSSOSHomeWebViewUI$16 implements OnClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$16(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final void onClick(View view) {
        FTSSOSHomeWebViewUI.i(this.qeq);
        if (this.qeq.qdo) {
            FTSSOSHomeWebViewUI.a(this.qeq).Dd(1);
            String charSequence = ((TextView) view).getText().toString();
            int a = a.a((JSONObject) view.getTag(), charSequence, this.qeq);
            if (a != 0) {
                FTSSOSHomeWebViewUI.a(this.qeq, charSequence);
            } else {
                FTSSOSHomeWebViewUI.a(this.qeq, "");
            }
            if (this.qeq.qdD != a) {
                h.mEJ.h(15521, new Object[]{Integer.valueOf(this.qeq.scene), Integer.valueOf(4), this.qeq.bXk().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.qeq.qdD)});
            }
            if (!(this.qeq.qdD == a || this.qeq.bXk().getTagList().isEmpty())) {
                String totalQuery = this.qeq.getTotalQuery();
                this.qeq.bXk().clearText();
                this.qeq.bXk().j(totalQuery, null);
                this.qeq.bXk().aQY();
            }
            this.qeq.qdD = a;
            this.qeq.bXf();
            FTSSOSHomeWebViewUI.d(this.qeq, a);
            try {
                FTSSOSHomeWebViewUI.e(this.qeq, 0);
                Bundle bundle = new Bundle();
                bundle.putInt(DownloadSettingTable$Columns.TYPE, a);
                bundle.putBoolean("isHomePage", a == 0);
                if (this.qeq.aUM() != 20 || FTSSOSHomeWebViewUI.a(this.qeq).bXy()) {
                    this.qeq.qdC = this.qeq.aUM();
                    bundle.putInt("scene", this.qeq.aUM());
                } else if (a != 0) {
                    this.qeq.qdC = 22;
                    bundle.putInt("scene", 22);
                } else {
                    this.qeq.qdC = 20;
                    bundle.putInt("scene", 20);
                }
                FTSSOSHomeWebViewUI.n(this.qeq).post(new 1(this, a, FTSSOSHomeWebViewUI.j(this.qeq).p(4, bundle)));
            } catch (Exception e) {
            }
        }
    }
}
