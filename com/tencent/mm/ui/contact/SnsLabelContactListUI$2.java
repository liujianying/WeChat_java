package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.n;

class SnsLabelContactListUI$2 implements OnItemClickListener {
    final /* synthetic */ SnsLabelContactListUI ulZ;

    SnsLabelContactListUI$2(SnsLabelContactListUI snsLabelContactListUI) {
        this.ulZ = snsLabelContactListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent();
        a aVar = (a) SnsLabelContactListUI.a(this.ulZ).getItem(i);
        h hVar = n.nkC;
        if (hVar == null) {
            this.ulZ.finish();
            return;
        }
        intent = hVar.e(intent, aVar.field_username);
        if (intent == null) {
            this.ulZ.finish();
            return;
        }
        intent.putExtra("Contact_User", aVar.field_username);
        WorkerProfile.vt().bzM.d(intent, this.ulZ);
    }
}
