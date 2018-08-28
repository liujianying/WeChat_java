package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceProfileAffectedUserView$1 implements OnItemClickListener {
    final /* synthetic */ ExdeviceProfileAffectedUserView iDP;
    final /* synthetic */ Context val$context;

    ExdeviceProfileAffectedUserView$1(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView, Context context) {
        this.iDP = exdeviceProfileAffectedUserView;
        this.val$context = context;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) adapterView.getAdapter().getItem(i);
        x.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", new Object[]{str});
        if (bi.oW(str)) {
            x.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
            return;
        }
        Intent intent = new Intent(this.val$context, ExdeviceProfileUI.class);
        intent.putExtra("username", str);
        this.val$context.startActivity(intent);
    }
}
