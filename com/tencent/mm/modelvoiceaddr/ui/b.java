package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.mm.modelvoiceaddr.e;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.4;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.o;

public final class b extends o {
    public boolean erG = true;
    int erH;
    int erI;
    a erJ;
    private VoiceSearchLayout erK;
    private a erL = new 1(this);

    public b(byte b) {
        super((byte) 0);
    }

    public final void a(a aVar) {
        this.erJ = aVar;
        this.uBw = aVar;
    }

    public final void o(VoiceSearchLayout voiceSearchLayout) {
        this.erK = voiceSearchLayout;
        this.erI = 1;
        if (1 == this.erI) {
            this.erH = 2;
        } else {
            this.erH = 1;
        }
    }

    public final void cancel() {
        x.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
        if (this.erK != null) {
            this.erK.Uh();
        }
        if (this.uBv != null) {
            this.uBv.setEditTextEnabled(true);
            this.uBv.setStatusBtnEnabled(true);
        }
    }

    protected final boolean Un() {
        boolean z = false;
        String str = "MicroMsg.VoiceSearchViewHelper";
        String str2 = "check has voice search, Enable %B, layout is null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.erG);
        if (this.erK == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        return this.erG;
    }

    protected final void Uo() {
        x.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
        if (this.uBv != null) {
            this.uBv.setEditTextEnabled(false);
            this.uBv.setStatusBtnEnabled(false);
        }
        if (this.erK != null && this.erK.getVisibility() == 8) {
            x.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
            VoiceSearchLayout voiceSearchLayout = this.erK;
            int i = this.erI;
            x.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.bj(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO"))});
            if (com.tencent.mm.pluginsdk.permission.a.bj(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")) {
                boolean z;
                x.d("MicroMsg.VoiceSearchLayout", "doStart " + voiceSearchLayout.bTv);
                voiceSearchLayout.err = i;
                voiceSearchLayout.bTv = true;
                voiceSearchLayout.erq = false;
                if (voiceSearchLayout.ero != null) {
                    voiceSearchLayout.ero.Ul();
                }
                voiceSearchLayout.setVisibility(0);
                voiceSearchLayout.erD.J(50, 50);
                voiceSearchLayout.bY(true);
                voiceSearchLayout.erC = 0;
                voiceSearchLayout.erv = new e(new 4(voiceSearchLayout), i);
                e eVar = voiceSearchLayout.erv;
                x.i("MicroMsg.SceneVoiceAddr", "start record");
                if (eVar.eqm == 0 && ao.is2G(ad.getContext())) {
                    z = true;
                } else {
                    z = false;
                }
                eVar.eqx = z;
                x.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[]{Boolean.valueOf(eVar.eqx)});
                com.tencent.mm.sdk.f.e.post(new e.a(eVar), "SceneVoiceAddr_record");
            } else if (voiceSearchLayout.getContext() instanceof Activity) {
                com.tencent.mm.pluginsdk.permission.a.g((Activity) voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO");
            }
        }
    }

    public final void a(Activity activity, Menu menu) {
        super.a(activity, menu);
        if (this.erK != null) {
            this.erK.setOnSearchListener(this.erL);
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            boolean z = this.erK != null && this.erK.getVisibility() == 0;
            x.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", new Object[]{Boolean.valueOf(z)});
            cancel();
            if (z) {
                return true;
            }
        }
        x.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
        return super.onKeyDown(i, keyEvent);
    }

    protected final void Up() {
        cancel();
    }
}
