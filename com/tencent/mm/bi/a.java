package com.tencent.mm.bi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import com.tencent.mm.api.d;
import com.tencent.mm.api.e;
import com.tencent.mm.api.i;
import com.tencent.mm.api.l;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.d.b;
import com.tencent.mm.d.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b {
    com.tencent.mm.api.m.a bwU;
    com.tencent.mm.view.a qVl;
    HashMap<d, b> qVm;
    LinkedList<b> qVn;
    private e qVo;
    Bitmap qVp;
    private boolean qVq = true;
    d qVr = d.bwM;
    d qVs = d.bwM;
    b qVt = null;

    public final void a(com.tencent.mm.view.a aVar) {
        this.qVl = aVar;
    }

    public final void a(com.tencent.mm.api.m.a aVar) {
        boolean z = true;
        this.bwU = aVar;
        this.qVm = new HashMap();
        this.qVn = new LinkedList();
        String str = aVar.path;
        if (bi.oW(str) || !new File(str).exists()) {
            x.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[]{str});
            z = false;
        } else {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                x.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), str});
                z = false;
            }
        }
        if (z) {
            this.qVp = c.j(bi.aG(aVar.path, ""), 1280, 1280, 0);
        }
        cfU();
    }

    public final d[] getFeatures() {
        return this.qVl.getFeatures();
    }

    public final l getSelectedFeatureListener() {
        return new 1(this);
    }

    public final void setActionBarCallback(e eVar) {
        this.qVo = eVar;
    }

    public final void setAutoShowFooterAndBar(boolean z) {
        this.qVq = z;
    }

    public final void ua() {
        if (this.qVo != null) {
            this.qVo.ua();
        }
    }

    public final boolean tW() {
        if (this.qVl.getTextEditView().getVisibility() == 0) {
            kW(false);
            this.qVl.setFooterVisible(true);
            return true;
        } else if (this.qVl.getChatFooterPanel() == null || this.qVl.getChatFooterPanel().getVisibility() != 0) {
            return false;
        } else {
            this.qVl.mK(true);
            this.qVl.setFooterVisible(true);
            return true;
        }
    }

    public final void onFinish() {
        if (this.qVo != null) {
            this.qVo.onFinish();
        }
    }

    public final void a(Editable editable, int i, int i2) {
        kW(false);
        this.qVl.setFooterVisible(true);
        b cfR = cfR();
        if (cfR.vE() == com.tencent.mm.d.a.bBj) {
            com.tencent.mm.d.e eVar = (com.tencent.mm.d.e) cfR;
            EditText editText = (EditText) this.qVl.getTextEditView().findViewById(com.tencent.mm.bd.a.e.text_edit);
            if (editText.getTag() == null || !(editText.getTag() instanceof com.tencent.mm.t.e)) {
                eVar.a(j.a(this.qVl.getContext(), editable), i, i2);
            } else {
                eVar.a((com.tencent.mm.t.e) editText.getTag(), j.a(this.qVl.getContext(), editable), i, i2);
            }
            editText.setTag(null);
        }
    }

    public final void cfP() {
        this.qVl.setFooterVisible(true);
        kW(false);
    }

    public final com.tencent.mm.view.a cfQ() {
        return this.qVl;
    }

    public final Context getContext() {
        return this.qVl.getContext();
    }

    public final com.tencent.mm.api.m.a getConfig() {
        return this.bwU;
    }

    public final <T extends b> T cfR() {
        if (this.qVt != null) {
            return this.qVt;
        }
        x.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
        return b.bBs;
    }

    public final float getInitScale() {
        return this.qVl.getBaseBoardView().getInitScale();
    }

    public final float getCurScale() {
        return this.qVl.getBaseBoardView().getCurScale();
    }

    public final void a(com.tencent.mm.api.j jVar, boolean z) {
        com.tencent.mm.sdk.f.e.post(new b(this, jVar, z), "onFinalGenerate");
    }

    public final void onDestroy() {
        Iterator it = this.qVn.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onDestroy();
        }
        this.qVn.clear();
        this.qVm.clear();
    }

    public final void onAttachedToWindow() {
        x.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
        Iterator it = this.qVn.iterator();
        while (it.hasNext()) {
            boolean z;
            b bVar = (b) it.next();
            ArtistCacheManager yn = ArtistCacheManager.yn();
            com.tencent.mm.d.a vE = bVar.vE();
            if (ArtistCacheManager.dac.containsKey(yn.dae) && ((com.tencent.mm.cache.ArtistCacheManager.a) ArtistCacheManager.dac.get(yn.dae)).dah.containsKey(vE)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bVar.vH();
                bVar.aH(true);
                x.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[]{bVar.vE()});
            }
        }
        if (this.qVl.getBaseBoardView().cCg()) {
            this.qVl.getBaseBoardView().cCh();
            this.qVl.getBaseBoardView().invalidate();
        }
    }

    public final Bitmap cfS() {
        return this.qVp;
    }

    public final boolean cfT() {
        return cfR().vE() != com.tencent.mm.d.a.bBk && this.qVq;
    }

    public final <T extends b> T b(d dVar) {
        return (b) this.qVm.get(dVar);
    }

    public final void c(i iVar) {
        ((com.tencent.mm.d.e) b(d.bwP)).b(iVar);
    }

    public final boolean I(MotionEvent motionEvent) {
        b bVar;
        boolean z = false;
        if (!(cfR().vE() == com.tencent.mm.d.a.bBk || cfR().vE() == com.tencent.mm.d.a.bBl)) {
            bVar = null;
            if (this.qVm.containsKey(d.bwO)) {
                bVar = (b) this.qVm.get(d.bwO);
            } else if (this.qVm.containsKey(d.bwP)) {
                bVar = (b) this.qVm.get(d.bwP);
            }
            if (bVar != null) {
                z = bVar.q(motionEvent);
            }
            if (z) {
                this.qVt = bVar;
            }
        }
        if (!z) {
            this.qVt = (b) this.qVm.get(this.qVl.getBaseFooterView().getCurFeatureType());
            Iterator it = this.qVn.iterator();
            while (it.hasNext()) {
                bVar = (b) it.next();
                if (bVar.vE() != com.tencent.mm.d.a.bBj && bVar.q(motionEvent)) {
                    return true;
                }
            }
        }
        return z;
    }

    public final void onDraw(Canvas canvas) {
        Iterator it = this.qVn.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.isAlive()) {
                if (cfR().vE() == bVar.vE()) {
                    bVar.onDraw(canvas);
                } else {
                    canvas.save();
                    canvas.clipRect(this.qVl.getBaseBoardView().getAliveRect());
                    bVar.b(canvas);
                    canvas.restore();
                }
            }
        }
    }

    public final com.tencent.mm.cache.d a(com.tencent.mm.d.a aVar) {
        return ArtistCacheManager.yn().a(aVar);
    }

    private void cfU() {
        this.qVn.clear();
        this.qVm.clear();
        this.qVm.put(d.bwM, b.bBs);
        for (d dVar : this.qVl.getFeatures()) {
            b bVar = null;
            switch (7.qVw[dVar.ordinal()]) {
                case 1:
                case 2:
                    int i;
                    Iterator it = this.qVn.iterator();
                    while (it.hasNext()) {
                        b bVar2 = (b) it.next();
                        if (bVar2.vE() == com.tencent.mm.d.a.bBj) {
                            i = 1;
                            bVar = bVar2;
                            if (i == 0) {
                                bVar = new com.tencent.mm.d.e();
                                ((com.tencent.mm.d.e) bVar).bCy = new a(this);
                                break;
                            }
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        bVar = new com.tencent.mm.d.e();
                        ((com.tencent.mm.d.e) bVar).bCy = new a(this);
                        break;
                    }
                    break;
                case 3:
                    bVar = new com.tencent.mm.d.c();
                    break;
                case 4:
                    bVar = new com.tencent.mm.d.d();
                    break;
                case 5:
                    bVar = new f();
                    break;
            }
            if (bVar != null) {
                if (!this.qVm.containsKey(dVar)) {
                    this.qVm.put(dVar, bVar);
                }
                if (!this.qVn.contains(bVar)) {
                    this.qVn.add(bVar);
                    bVar.a(this, this.qVl.getBaseBoardView().getMainMatrix(), this.qVl.getBaseBoardView().getAliveRect());
                }
            }
        }
        Collections.sort(this.qVn, new 2(this));
        x.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[]{Integer.valueOf(this.qVm.size() - 1)});
    }

    final void kW(boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(this.qVl.getContext(), com.tencent.mm.bd.a.a.push_up_in);
            loadAnimation.setAnimationListener(new 3(this));
            this.qVl.getTextEditView().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(this.qVl.getContext(), com.tencent.mm.bd.a.a.push_down_out);
        loadAnimation.setAnimationListener(new 4(this));
        this.qVl.getTextEditView().startAnimation(loadAnimation);
    }
}
