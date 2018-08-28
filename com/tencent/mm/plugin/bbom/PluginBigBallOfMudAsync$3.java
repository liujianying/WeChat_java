package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.pluginsdk.ui.d.l.3;
import com.tencent.mm.pluginsdk.ui.d.l.4;
import com.tencent.mm.ui.tools.k;
import java.util.List;

class PluginBigBallOfMudAsync$3 implements c {
    final /* synthetic */ PluginBigBallOfMudAsync heB;

    PluginBigBallOfMudAsync$3(PluginBigBallOfMudAsync pluginBigBallOfMudAsync) {
        this.heB = pluginBigBallOfMudAsync;
    }

    public final void a(Context context, List<String> list, OnDismissListener onDismissListener) {
        if (!list.isEmpty() && context != null) {
            new k(context).a(null, new 3(list), new 4(context), onDismissListener);
        }
    }

    public final void a(Context context, String str, OnDismissListener onDismissListener, Bundle bundle) {
        l.a(context, str, onDismissListener, bundle);
    }
}
