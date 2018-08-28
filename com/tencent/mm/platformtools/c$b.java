package com.tencent.mm.platformtools;

import android.os.Build.VERSION;
import android.widget.ListView;

public class c$b {
    public static void a(ListView listView) {
        if (VERSION.SDK_INT >= 8) {
            ad adVar = new ad();
            if (listView.getFirstVisiblePosition() > 10) {
                listView.setSelection(10);
            }
            if (VERSION.SDK_INT >= 8) {
                listView.smoothScrollToPosition(0);
                return;
            }
            return;
        }
        ac acVar = new ac();
        listView.setSelection(0);
    }
}
