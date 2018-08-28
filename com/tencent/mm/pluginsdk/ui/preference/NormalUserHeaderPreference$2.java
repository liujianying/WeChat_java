package com.tencent.mm.pluginsdk.ui.preference;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.storage.ab;

class NormalUserHeaderPreference$2 implements OnClickListener {
    final /* synthetic */ NormalUserHeaderPreference qPp;

    NormalUserHeaderPreference$2(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.qPp = normalUserHeaderPreference;
    }

    public final void onClick(View view) {
        String str = NormalUserHeaderPreference.b(this.qPp).field_username;
        f fVar = new f(NormalUserHeaderPreference.a(this.qPp), str);
        if (ab.gY(str)) {
            ab.XV(str);
        }
        fVar.cde();
    }
}
