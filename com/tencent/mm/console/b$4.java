package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.f.e;
import java.util.ArrayList;

class b$4 implements OnClickListener {
    final /* synthetic */ int dgZ;
    final /* synthetic */ ArrayList dha;
    final /* synthetic */ String dhd;
    final /* synthetic */ Context val$context;

    b$4(String str, int i, ArrayList arrayList, Context context) {
        this.dhd = str;
        this.dgZ = i;
        this.dha = arrayList;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e.post(new 1(this), "copy -n");
    }
}
