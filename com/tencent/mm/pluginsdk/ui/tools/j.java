package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(11)
public final class j {
    public static void a(ListView listView, int i, int i2, boolean z) {
        if (listView != null) {
            x.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
            listView.setItemChecked(i, true);
            listView.setSelectionFromTop(i, i2);
        }
    }
}
