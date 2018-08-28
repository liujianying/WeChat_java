package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.support.v4.view.z;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;

class NoteEditorUI$22 implements Runnable {
    final /* synthetic */ NoteEditorUI qur;
    final /* synthetic */ Context val$context;

    NoteEditorUI$22(NoteEditorUI noteEditorUI, Context context) {
        this.qur = noteEditorUI;
        this.val$context = context;
    }

    public final void run() {
        int size = c.bZD().size();
        int childCount = NoteEditorUI.K(this.qur).getChildCount();
        if (size == childCount) {
            size = childCount - 1;
            float f = 0.0f;
            int i = size;
            while (i >= 0) {
                View childAt = NoteEditorUI.K(this.qur).getChildAt(i);
                float R = z.R(childAt);
                i--;
                f = f > ((float) childAt.getBottom()) + R ? f : ((float) childAt.getBottom()) + R;
            }
            if (f < ((float) j.db(this.val$context)[1]) && f > 0.0f) {
                LayoutParams layoutParams = (LayoutParams) NoteEditorUI.b(this.qur).getLayoutParams();
                layoutParams.height = (int) f;
                NoteEditorUI.b(this.qur).setLayoutParams(layoutParams);
            }
        }
        NoteEditorUI.b(this.qur).setVisibility(0);
        if (NoteEditorUI.a(this.qur) != null) {
            g a = NoteEditorUI.a(this.qur);
            int[] iArr = new int[]{0, 0};
            a.mParentView.getLocationOnScreen(iArr);
            a.qqu.showAtLocation(a.mParentView, 49, 0, iArr[1] + 50);
        }
    }
}
