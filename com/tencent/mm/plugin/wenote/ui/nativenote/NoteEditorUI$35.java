package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;

class NoteEditorUI$35 implements OnTouchListener {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$35(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            NoteEditorUI.a(this.qur, motionEvent.getX());
            NoteEditorUI.b(this.qur, motionEvent.getY());
        }
        float abs;
        float abs2;
        if (motionEvent.getAction() == 1 && NoteEditorUI.K(this.qur).u(motionEvent.getX(), motionEvent.getY()) == null) {
            abs = Math.abs(NoteEditorUI.N(this.qur) - motionEvent.getX());
            abs2 = Math.abs(NoteEditorUI.O(this.qur) - motionEvent.getY());
            if (abs < 30.0f && abs2 < 30.0f) {
                if (NoteEditorUI.b(this.qur).getVisibility() != 8) {
                    if (NoteEditorUI.a(this.qur) != null) {
                        NoteEditorUI.a(this.qur).qqu.dismiss();
                    }
                    NoteEditorUI.b(this.qur).setVisibility(8);
                } else {
                    int size = c.bZD().size();
                    b Bv = c.bZD().Bv(size - 1);
                    if (Bv != null) {
                        boolean z = Bv.qoH;
                        c.bZD().bZG();
                        Bv.qoH = true;
                        Bv.qoN = false;
                        Bv.qoJ = -1;
                        NoteEditorUI.P(this.qur).bl(size - 1);
                        this.qur.e(true, 50);
                        this.qur.Q(1, 0);
                        if (NoteEditorUI.G(this.qur) && z) {
                            NoteEditorUI.w(this.qur).postDelayed(new Runnable() {
                                public final void run() {
                                    e.cap().ky(true);
                                    e.cap().kx(true);
                                }
                            }, 100);
                        }
                    }
                }
            }
        } else if (motionEvent.getAction() == 2) {
            abs = Math.abs(NoteEditorUI.N(this.qur) - motionEvent.getX());
            abs2 = Math.abs(NoteEditorUI.O(this.qur) - motionEvent.getY());
            if (abs > 120.0f || abs2 > 120.0f) {
                if (NoteEditorUI.G(this.qur)) {
                    if (e.cap().cao() == 1) {
                        this.qur.bZs();
                        e.cap().cat();
                    }
                } else if (!NoteEditorUI.Q(this.qur)) {
                    this.qur.bZs();
                }
            }
        }
        return false;
    }
}
