package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.Sort3rdAppUI;
import com.tencent.mm.ui.base.h;

class ChattingSendDataToDeviceUI$3 implements OnItemClickListener {
    final /* synthetic */ ChattingSendDataToDeviceUI tLG;

    ChattingSendDataToDeviceUI$3(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
        this.tLG = chattingSendDataToDeviceUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[]{Integer.valueOf(i)});
        if (i == adapterView.getAdapter().getCount() - 1) {
            Intent intent = new Intent(this.tLG, Sort3rdAppUI.class);
            intent.addFlags(67108864);
            intent.putExtra("KFlag", ChattingSendDataToDeviceUI.h(this.tLG));
            this.tLG.startActivity(intent);
        } else if (this.tLG.tGV && i == adapterView.getAdapter().getCount() - 2) {
            if (this.tLG.filePath == null || this.tLG.fjS == null) {
                h.bA(this.tLG.getBaseContext(), this.tLG.getString(R.l.download_no_match_msg));
            } else {
                a.b(this.tLG, this.tLG.filePath, this.tLG.fjS.toLowerCase(), 1);
            }
        } else if (i >= 0 && i < adapterView.getAdapter().getCount() - 1) {
            f fVar = (f) ChattingSendDataToDeviceUI.i(this.tLG).get(i);
            if (g.a(this.tLG.getBaseContext(), fVar)) {
                com.tencent.mm.bu.a.post(new 1(this, fVar));
                return;
            }
            h.bA(this.tLG.getBaseContext(), this.tLG.getString(R.l.chatting_send_app_not_installed));
            fVar.field_status = 4;
            ao.bmf().a(fVar, new String[0]);
            ChattingSendDataToDeviceUI.j(this.tLG);
        }
    }
}
