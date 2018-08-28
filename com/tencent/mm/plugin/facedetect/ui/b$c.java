package com.tencent.mm.plugin.facedetect.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

@SuppressLint({"ValidFragment"})
public class b$c extends Fragment {
    private Button iRY = null;
    private WeakReference<b> iRZ;
    private View ido = null;

    public b$c(b bVar) {
        x.d("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo constructed");
        this.iRZ = new WeakReference(bVar);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ido = layoutInflater.inflate(g.face_tutorial_fragment_2, viewGroup, false);
        this.iRY = (Button) this.ido.findViewById(e.face_tt_confirm_btn);
        this.iRY.setOnClickListener(new 1(this));
        return this.ido;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
    }
}
