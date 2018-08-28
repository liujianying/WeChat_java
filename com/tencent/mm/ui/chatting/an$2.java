package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.ab;
import java.util.List;

class an$2 implements OnClickListener {
    final /* synthetic */ ab eLI;
    final /* synthetic */ List tMZ;
    final /* synthetic */ boolean tNa;
    final /* synthetic */ Context val$context;

    public an$2(Context context, ab abVar, List list, boolean z) {
        this.val$context = context;
        this.eLI = abVar;
        this.tMZ = list;
        this.tNa = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        an.a(this.val$context, this.eLI, this.tMZ, this.tNa);
    }
}
