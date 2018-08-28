package com.tencent.mm.modelvoiceaddr.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.modelvoiceaddr.e;
import com.tencent.mm.plugin.f.a$b;
import com.tencent.mm.plugin.f.a.a;
import com.tencent.mm.plugin.f.a.c;
import com.tencent.mm.plugin.f.a.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceSearchLayout extends LinearLayout {
    private static final int[] erx = new int[]{a$b.voicesearch_silence_check001, a$b.voicesearch_silence_check002, a$b.voicesearch_silence_check003, a$b.voicesearch_silence_check004, a$b.voicesearch_feedback005, a$b.voicesearch_feedback006, a$b.voicesearch_feedback007, a$b.voicesearch_feedback008, a$b.voicesearch_feedback009, a$b.voicesearch_feedback010, a$b.voicesearch_feedback011, a$b.voicesearch_feedback012, a$b.voicesearch_feedback013, a$b.voicesearch_feedback014};
    private static final int[] ery = new int[]{a$b.voicesearch_silence_check001, a$b.voicesearch_silence_check001, a$b.voicesearch_silence_check001, a$b.voicesearch_silence_check002, a$b.voicesearch_silence_check003, a$b.voicesearch_silence_check002, a$b.voicesearch_silence_check001, a$b.voicesearch_silence_check004, a$b.voicesearch_silence_check001, a$b.voicesearch_silence_check001};
    private static final int[] erz = new int[]{a$b.voicesearch_loading001, a$b.voicesearch_loading010, a$b.voicesearch_loading010, a$b.voicesearch_loading010, a$b.voicesearch_loading001};
    private int bJu = 0;
    boolean bTv = false;
    private int erA = 0;
    private int erB = 0;
    int erC = 0;
    final al erD = new al(new 1(this), true);
    private View ern = null;
    a ero = null;
    private Button erp;
    boolean erq = false;
    int err = 0;
    private b ers;
    private View ert;
    private AnimationDrawable eru;
    e erv;
    private boolean erw = false;

    static /* synthetic */ int f(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.erB + 1;
        voiceSearchLayout.erB = i;
        return i;
    }

    static /* synthetic */ int i(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.bJu - 1;
        voiceSearchLayout.bJu = i;
        return i;
    }

    static /* synthetic */ int j(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.bJu + 1;
        voiceSearchLayout.bJu = i;
        return i;
    }

    static /* synthetic */ void k(VoiceSearchLayout voiceSearchLayout) {
        voiceSearchLayout.erq = true;
        voiceSearchLayout.setSearchStartBtnView(true);
    }

    public void setOnVisibleChangeListener(b bVar) {
        this.ers = bVar;
    }

    public void setOnSearchListener(a aVar) {
        this.ero = aVar;
    }

    @TargetApi(11)
    public VoiceSearchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceSearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoiceSearchLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.ern = inflate(context, d.voice_search_layout, this);
        this.erp = (Button) this.ern.findViewById(c.voice_search_start_btn);
        this.ert = this.ern.findViewById(c.voice_search_field);
        setSearchStartBtnView(false);
        reset();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.erq) {
            x.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.bTv);
            if (this.bTv) {
                Uh();
                this.bTv = false;
            }
        }
        return true;
    }

    public final void Uh() {
        x.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.bTv);
        if (this.bTv) {
            this.bTv = false;
            if (this.ero != null) {
                this.ero.Um();
            }
        }
        reset();
        if (getVisibility() == 0) {
            setVisibility(8);
            if (this.ers != null) {
                this.ers.bZ(false);
            }
        }
        yM();
        if (this.erv != null) {
            this.erv.cancel();
        }
        if (this.erD != null) {
            this.erD.SO();
        }
    }

    public final void reset() {
        setSearchStartBtnView(false);
        this.bTv = false;
        this.erq = false;
        this.erp.setBackgroundResource(a$b.voicesearch_btn_normal);
    }

    private void setSearchStartBtnView(boolean z) {
        if (z) {
            this.erp.setBackgroundResource(a$b.voice_search_start_anim);
            this.eru = (AnimationDrawable) this.erp.getBackground();
            if (this.eru != null) {
                this.eru.start();
                return;
            }
            return;
        }
        this.erp.setBackgroundResource(a$b.voicesearch_btn_normal);
    }

    public void setVisibility(int i) {
        if (super.getVisibility() != i && !this.erw) {
            Animation loadAnimation;
            if (i == 8) {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), a.fast_faded_out);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), a.fast_faded_in);
            }
            startAnimation(loadAnimation);
            super.setVisibility(i);
            if (this.ers != null) {
                this.ers.bZ(i == 0);
            }
        }
    }

    public void setTopMargin(int i) {
        LayoutParams layoutParams = (LayoutParams) this.ert.getLayoutParams();
        layoutParams.topMargin = i;
        this.ert.setLayoutParams(layoutParams);
    }

    private void setAmpImage(int i) {
        if (this.erp != null) {
            this.erp.setBackgroundResource(i);
        }
    }

    final void bY(boolean z) {
        if (z) {
            x.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
            f.yz().yL();
        } else {
            yM();
        }
        MediaPlayer jVar = new j();
        if (z) {
            try {
                jVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + com.tencent.mm.plugin.f.a.e.on));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                jVar.release();
                return;
            }
        }
        jVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + com.tencent.mm.plugin.f.a.e.off));
        jVar.setAudioStreamType(5);
        jVar.setOnCompletionListener(new 2(this));
        jVar.setOnErrorListener(new 3(this));
        jVar.prepare();
        jVar.setLooping(false);
        jVar.start();
    }

    private static void yM() {
        x.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
        f.yz().yM();
    }
}
