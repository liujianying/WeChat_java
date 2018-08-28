package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.music.model.d.b;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;

public class b$a {
    com.tencent.mm.an.a bTF;
    final /* synthetic */ b lAF;
    MusicItemLayout lAG;
    View lAH;
    View lAI;
    View lAJ;
    CdnImageView lAK;
    TextView lAL;
    TextView lAM;
    LyricView lAN;
    boolean lAO;
    private AnimationListener lAP = new 3(this);
    private int mode = 1;

    public class a extends Animation {
        final int kGo;
        final int lAT;
        View view;

        public a(View view, int i) {
            this.view = view;
            this.kGo = i;
            this.lAT = view.getHeight();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            this.view.getLayoutParams().height = (int) (((float) this.lAT) + (((float) (this.kGo - this.lAT)) * f));
            this.view.requestLayout();
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
        }

        public final boolean willChangeBounds() {
            return true;
        }
    }

    public b$a(b bVar) {
        this.lAF = bVar;
    }

    public final void f(com.tencent.mm.an.a aVar, boolean z) {
        if (aVar != null) {
            x.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[]{aVar.field_songName});
            this.bTF = aVar;
            if (bi.oW(aVar.field_songHAlbumUrl)) {
                e bic = h.bic();
                boolean z2 = this.lAF.lzc;
                if (aVar != null) {
                    if (bic.lyg != null) {
                        g.Eh().dpP.c(bic.lyg);
                        bic.lyg = null;
                    }
                    if (aVar.field_songId <= 0) {
                        x.e("MicroMsg.Music.MusicPlayerManager", "can't get songId ");
                        com.tencent.mm.plugin.report.service.h.mEJ.k(10911, "1");
                    } else {
                        bic.lyg = new b(aVar, z2);
                        g.Eh().dpP.a(bic.lyg, 0);
                    }
                }
            }
            this.lAG.setTag(this);
            if ((!com.tencent.mm.plugin.music.model.g.f(aVar) || this.lAF.scene == 3) && !bi.oW(aVar.field_songSinger)) {
                this.lAM.setText(aVar.field_songSinger);
                this.lAM.setVisibility(0);
            } else {
                this.lAM.setVisibility(8);
            }
            this.lAL.setText(aVar.field_songName);
            this.lAL.setTag(aVar.field_songName);
            LyricView lyricView = this.lAN;
            com.tencent.mm.plugin.music.model.f.a bid = h.bid();
            lyricView.setLyricObj(bid.lzY.get(aVar.field_musicId) != null ? (com.tencent.mm.plugin.music.model.a) bid.lzY.get(aVar.field_musicId) : bid.e(aVar, this.lAF.lzc));
            if (!com.tencent.mm.plugin.music.model.g.f(aVar) || this.lAF.lzc) {
                this.lAN.setCurrentTime(1);
            }
            biF();
            d dVar = this.lAF.lAC;
            View view = this.lAK;
            Context context = this.lAF.context;
            boolean z3 = this.lAF.lzc;
            if (z) {
                dVar.cYh.remove(aVar.field_musicId);
            }
            Bitmap bitmap = (Bitmap) dVar.cYh.get(aVar.field_musicId);
            int[] s;
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = null;
                x.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[]{aVar.field_musicId, aVar.field_songHAlbumUrl, aVar.field_songAlbumUrl, aVar.field_songAlbumLocalPath});
                view.setTag(aVar);
                com.tencent.mm.ak.a.a.c.a aVar2;
                if (aVar.PU()) {
                    aVar2 = new com.tencent.mm.ak.a.a.c.a();
                    aVar2.dXA = com.tencent.mm.plugin.music.d.a.h(aVar, true);
                    aVar2.dXy = true;
                    aVar2.dXw = true;
                    aVar2.dXN = com.tencent.mm.plugin.music.b.b.default_icon_music;
                    if (z3) {
                        aVar2.dXI = true;
                        aVar2.dXJ = 10;
                    }
                    o.Pj().a(aVar.field_songHAlbumUrl, view, aVar2.Pt(), dVar.lxV);
                } else {
                    switch (aVar.field_musicType) {
                        case 0:
                        case 5:
                        case 7:
                        case 10:
                        case 11:
                            break;
                        case 1:
                        case 8:
                        case 9:
                            ate ate = new ate();
                            ate.ksA = aVar.field_songMediaId;
                            ate.rVE = aVar.field_songAlbumUrl;
                            ate.rVF = aVar.field_songAlbumType;
                            ate.jPK = ate.rVE;
                            if (n.nkx != null) {
                                bitmap = n.nkx.b(ate);
                                if (bitmap == null) {
                                    view.setImageResource(com.tencent.mm.plugin.music.b.b.default_icon_music);
                                    if (!(aVar.PT() || dVar.lxU == null)) {
                                        dVar.lxU.a(aVar, new int[]{-16777216, -1});
                                    }
                                    n.nkx.cx(view);
                                    n.nkx.a(ate, view, context.hashCode(), av.tbu);
                                    dVar.lxW.removeCallbacksAndMessages(null);
                                    dVar.lxW.postDelayed(new d.b(dVar, aVar), 1000);
                                    break;
                                }
                                bitmap = c.e(bitmap, 10);
                                break;
                            }
                            break;
                        case 4:
                            aVar2 = new com.tencent.mm.ak.a.a.c.a();
                            aVar2.dXA = com.tencent.mm.plugin.music.d.a.h(aVar, false);
                            aVar2.dXy = true;
                            aVar2.dXw = true;
                            if (z3) {
                                aVar2.dXI = true;
                                aVar2.dXJ = 10;
                            }
                            o.Pj().a(aVar.field_songAlbumUrl, view, aVar2.Pt(), dVar.lxV);
                            break;
                        case 6:
                            bitmap = o.Pf().b(aVar.field_songAlbumLocalPath, com.tencent.mm.bp.a.getDensity(context), false);
                            break;
                    }
                    if (bitmap == null) {
                        bitmap = o.Pf().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bp.a.getDensity(context), false);
                    }
                    if (bitmap != null) {
                        bitmap = c.e(bitmap, 10);
                    } else {
                        view.setImageResource(com.tencent.mm.plugin.music.b.b.default_icon_music);
                        if (!(aVar.PT() || dVar.lxU == null)) {
                            dVar.lxU.a(aVar, new int[]{-16777216, -1});
                        }
                        x.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[]{aVar.field_songAlbumUrl});
                        if (!TextUtils.isEmpty(aVar.field_songAlbumUrl)) {
                            aVar2 = new com.tencent.mm.ak.a.a.c.a();
                            aVar2.dXA = com.tencent.mm.plugin.music.d.a.h(aVar, true);
                            aVar2.dXy = true;
                            aVar2.dXw = true;
                            if (z3) {
                                aVar2.dXI = true;
                                aVar2.dXJ = 10;
                            }
                            o.Pj().a(aVar.field_songAlbumUrl, view, aVar2.Pt(), dVar.lxV);
                        }
                    }
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    dVar.a(aVar, bitmap);
                    view.setImageBitmap(bitmap);
                    s = com.tencent.mm.an.c.s(bitmap);
                    if (!aVar.f(s)) {
                        aVar = h.bid().Z(aVar.field_musicId, s[0], s[1]);
                    }
                    if (dVar.lxU != null && aVar != null) {
                        dVar.lxU.a(aVar, s);
                        return;
                    }
                    return;
                }
                return;
            }
            x.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[]{aVar.field_musicId});
            view.setImageBitmap(bitmap);
            s = aVar.PT() ? new int[]{aVar.field_songBgColor, aVar.field_songLyricColor} : com.tencent.mm.an.c.s(bitmap);
            if (dVar.lxU != null) {
                dVar.lxU.a(aVar, s);
            }
        }
    }

    public final boolean biE() {
        return this.mode == 2;
    }

    public final void biF() {
        if (!this.lAO && this.mode != 1) {
            f.cW(3, this.lAF.scene);
            if (this.lAF.lAD == 0) {
                this.lAF.lAD = this.lAH.getMeasuredHeight();
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.lAF.lAD);
                layoutParams.weight = 0.0f;
                this.lAH.setLayoutParams(layoutParams);
            }
            f.lyo = true;
            f.bia();
            this.mode = 1;
            this.lAO = true;
            Animation aVar = new a(this.lAN, this.lAF.lAz);
            aVar.setDuration(500);
            aVar.setAnimationListener(this.lAP);
            this.lAN.startAnimation(aVar);
        }
    }

    public final void biG() {
        if (!this.lAO && this.mode != 2) {
            f.cW(2, this.lAF.scene);
            if (this.lAF.lAD == 0) {
                this.lAF.lAD = this.lAH.getMeasuredHeight();
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.lAF.lAD);
                layoutParams.weight = 0.0f;
                this.lAH.setLayoutParams(layoutParams);
            }
            f.lyo = true;
            f.bia();
            this.mode = 2;
            this.lAO = true;
            Animation aVar = new a(this.lAN, this.lAF.lAA);
            aVar.setDuration(500);
            aVar.setAnimationListener(this.lAP);
            this.lAN.startAnimation(aVar);
        }
    }

    public final void biH() {
        f.lyo = true;
        f.bia();
        if (this.mode == 1) {
            biG();
        } else {
            biF();
        }
    }
}
