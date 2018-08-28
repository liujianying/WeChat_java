package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e {
    private static final List<WeakReference<ControlBoardPanel>> gQA = new LinkedList();
    private static final a gQB = new 1();

    static /* synthetic */ void a(ControlBoardPanel controlBoardPanel) {
        if (controlBoardPanel != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < gQA.size()) {
                    WeakReference weakReference = (WeakReference) gQA.get(i2);
                    if (weakReference != null && controlBoardPanel == weakReference.get()) {
                        gQA.remove(weakReference);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static void cP(Context context) {
        View view;
        View view2;
        if (context != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= gQA.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) gQA.get(i2);
                if (weakReference != null) {
                    view = (ControlBoardPanel) weakReference.get();
                    if (view != null && context == view.getContext()) {
                        break;
                    }
                }
                i = i2 + 1;
            }
        }
        view = null;
        if (view == null) {
            view = new ControlBoardPanel(context);
            gQA.add(new WeakReference(view));
            view2 = view;
        } else {
            view2 = view;
        }
        a aVar = gQB;
        if (!view2.gQK) {
            view2.gQK = true;
            Activity activity = (Activity) view2.getContext();
            view2.gQJ = new LayoutParams(-2, -2, 1003, 520, -3);
            view2.gQJ.y = com.tencent.mm.compatible.util.a.h(activity);
            view2.gQJ.token = activity.getWindow().getDecorView().getWindowToken();
            view2.gQJ.gravity = 51;
            view2.gQJ.softInputMode = 16;
            view2.gQI.addView(view2, view2.gQJ);
            view2.reset();
            view2.gQB = aVar;
            if (view2.gQB != null) {
                view2.gQB.a(view2, true);
            }
        }
    }
}
