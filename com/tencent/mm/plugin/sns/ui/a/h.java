package com.tencent.mm.plugin.sns.ui.a;

import android.annotation.TargetApi;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;

public final class h extends a {
    private static int[] okg = new int[]{f.turn_media_type_img_0, f.turn_media_type_img_1};
    private static int[] okh = new int[]{f.turn_media_type_sight_0};
    private static int[][] oki;
    public int mScreenHeight = 0;
    private int mScreenWidth = 0;
    private int okf = 0;

    static {
        r0 = new int[3][];
        r0[0] = new int[]{f.turn_media_type_title_1, f.turn_media_type_subtitle_1};
        r0[1] = new int[]{f.turn_media_type_title_0, f.turn_media_type_subtitle_0};
        r0[2] = new int[]{f.turn_media_type_title_0, f.turn_media_type_subtitle_1};
        oki = r0;
    }

    public final void c(c cVar) {
        if (this.mActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            this.okf = Math.min(this.mScreenWidth, this.mScreenHeight) - a.fromDPToPix(this.mActivity, 82);
        }
        if (cVar.oiQ == null || cVar.ojJ) {
            cVar.ojI = cVar.jEz.findViewById(f.turn_media_container);
            cVar.ojJ = true;
        } else {
            cVar.oiQ.setLayoutResource(g.sns_timeline_turn_media);
            cVar.ojI = cVar.oiQ.inflate();
            cVar.ojJ = true;
        }
        LayoutParams layoutParams = cVar.ojI.getLayoutParams();
        layoutParams.width = this.okf;
        layoutParams.height = this.okf;
        ak akVar = cVar.ojL;
        akVar.nRC = i(cVar.ojI, 0, 6);
        akVar.nRB = akVar.nRC;
        akVar.neL = (com.tencent.mm.plugin.sight.decode.a.a) akVar.nRC.findViewById(f.image);
        akVar.nEI = (ImageView) akVar.nRC.findViewById(f.status_btn);
        akVar.nRD = (MMPinProgressBtn) akVar.nRC.findViewById(f.progress);
        akVar.nRE = (TextView) akVar.nRC.findViewById(f.endtv);
        akVar.nEJ = (TextView) akVar.nRC.findViewById(f.errorTv);
        ((SightPlayImageView) akVar.neL).ndG = true;
        ((SightPlayImageView) akVar.neL).setScaleType(QImageView.a.uHR);
        akVar.neL.dt(this.okf, this.okf);
    }

    @TargetApi(16)
    public final void a(c cVar, int i, ay ayVar, bsu bsu, int i2, av avVar) {
        int hashCode;
        View findViewById;
        cVar.ojI.setTag(cVar);
        cVar.ojI.setVisibility(0);
        cVar.ojI.setLayerType(2, null);
        for (int findViewById2 : okg) {
            findViewById = cVar.ojI.findViewById(findViewById2);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (findViewById instanceof MaskImageView) {
                ((MaskImageView) findViewById).setScaleType(QImageView.a.uHR);
            }
        }
        for (int findViewById22 : okh) {
            findViewById = cVar.ojI.findViewById(findViewById22);
            if (findViewById != null) {
                findViewById.setBackground(null);
                findViewById.setVisibility(8);
                if (findViewById instanceof ViewGroup) {
                    ((ViewGroup) findViewById).setClipChildren(false);
                }
            }
        }
        cVar.ojL.neL.clear();
        if (!ayVar.nLv || i2 != 12) {
            return;
        }
        if (bsu.sqc == null || bsu.sqc.ruA == null || bsu.sqc.ruA.size() < 2) {
            x.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
            return;
        }
        int i3;
        if (cVar.oiG == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        a aVar = null;
        a aVar2 = null;
        int i4 = 0;
        while (i4 < Math.min(bsu.sqc.ruA.size(), 2)) {
            a aVar3;
            a aVar4;
            ate ate = (ate) bsu.sqc.ruA.get(i4);
            View i5 = i(cVar.ojI, i4, 2);
            if (i5 != null) {
                LayoutParams layoutParams;
                ap apVar = new ap();
                apVar.bNH = cVar.bKW;
                apVar.index = i4;
                apVar.nTx = this.nTx;
                apVar.position = i;
                i5.setTag(apVar);
                com.tencent.mm.plugin.sns.model.g byl;
                if (ate.hcE == 2) {
                    byl = af.byl();
                    int hashCode2 = this.mActivity.hashCode();
                    com.tencent.mm.storage.av clT = com.tencent.mm.storage.av.clT();
                    clT.time = bsu.lOH;
                    byl.a(ate, i5, -1, hashCode2, clT, 3);
                } else {
                    byl = af.byl();
                    hashCode = this.mActivity.hashCode();
                    com.tencent.mm.storage.av clT2 = com.tencent.mm.storage.av.clT();
                    clT2.time = bsu.lOH;
                    byl.a(ate, i5, hashCode, clT2);
                }
                findViewById = null;
                if (ate.hcE == 6 && i3 == i4) {
                    final boolean z = i3 > 0;
                    final long j = ayVar.oew;
                    ak akVar = cVar.ojL;
                    n nVar = ayVar.nhc;
                    View view = akVar.nRB;
                    akVar.nRA = bsu;
                    final av avVar2 = avVar;
                    akVar.neL.setOnCompletionListener(new e() {
                        public final void d(b bVar, int i) {
                            if (i != -1 && avVar2 != null && avVar2.obV != null && avVar2.obV.nLJ != null) {
                                avVar2.obV.nLJ.o(j, z);
                            }
                        }
                    });
                    if (!avVar.obV.nLJ.ey(((long) i4) + j)) {
                        akVar.neL.setOnDecodeDurationListener(new 2(this, avVar, j, z, i4, akVar));
                    } else if (!(avVar == null || avVar.obV == null || avVar.obV.nLJ == null)) {
                        avVar.obV.nLJ.b(j, bi.VG(), z);
                    }
                    akVar.a(bsu, i, ayVar.nMU, ayVar.nLv);
                    akVar.nEJ.setVisibility(8);
                    com.tencent.mm.plugin.sns.model.g byl2 = af.byl();
                    long nanoTime = System.nanoTime() - System.nanoTime();
                    x.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(ate)), Long.valueOf(nanoTime)});
                    if (com.tencent.mm.plugin.sns.model.g.t(ate)) {
                        if (byl2.u(ate)) {
                            akVar.nEI.setVisibility(0);
                            akVar.nRD.setVisibility(8);
                            akVar.nEI.setImageDrawable(a.f(this.mActivity, i.shortvideo_play_btn));
                            akVar.nEI.setContentDescription(this.mActivity.getString(j.play_sight_desc));
                        } else if (byl2.v(ate)) {
                            akVar.nEI.setVisibility(8);
                            akVar.nRD.setVisibility(8);
                        } else if (!ayVar.nLv || byl2.b(nVar, null) > 5) {
                            byl2.y(ate);
                            akVar.nEI.setVisibility(0);
                            akVar.nRD.setVisibility(8);
                            akVar.nEI.setImageDrawable(a.f(this.mActivity, i.shortvideo_play_btn));
                            akVar.nEI.setContentDescription(this.mActivity.getString(j.play_sight_desc));
                        } else {
                            akVar.nEI.setVisibility(8);
                            akVar.nRD.setVisibility(8);
                        }
                        if (akVar.neL.bvF()) {
                            x.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + ate.ksA + " " + ate.jPK + " " + ate.rVE + " " + i);
                            byl2.y(ate);
                            akVar.nEI.setVisibility(0);
                            akVar.nRD.setVisibility(8);
                            akVar.nEI.setImageDrawable(a.f(this.mActivity, i.shortvideo_play_btn));
                            akVar.nEI.setContentDescription(this.mActivity.getString(j.play_sight_desc));
                        }
                    } else if (byl2.w(ate)) {
                        akVar.nEI.setVisibility(8);
                        akVar.nRD.setVisibility(0);
                        akVar.nRD.cAt();
                    } else if (ayVar.nLv && byl2.b(nVar, null) == 5) {
                        byl2.A(ate);
                        akVar.nEI.setVisibility(8);
                        akVar.nRD.setVisibility(0);
                        akVar.nRD.cAt();
                    } else if (byl2.x(ate)) {
                        akVar.nRD.setVisibility(8);
                        akVar.nEI.setImageResource(i$e.sight_chat_error);
                        akVar.nEI.setVisibility(0);
                    } else {
                        byl2.y(ate);
                        akVar.nEI.setVisibility(0);
                        akVar.nRD.setVisibility(8);
                        akVar.nEI.setImageDrawable(a.f(this.mActivity, i.shortvideo_play_btn));
                        akVar.nEI.setContentDescription(this.mActivity.getString(j.play_sight_desc));
                        if (!ayVar.nLv && byl2.a(nVar, null) == 4) {
                            akVar.nEJ.setVisibility(0);
                        } else if (ayVar.nLv && byl2.b(nVar, null) == 4) {
                            akVar.nEJ.setVisibility(0);
                        }
                    }
                    layoutParams = akVar.nRE.getLayoutParams();
                    layoutParams.width = this.okf;
                    layoutParams.height = this.okf;
                    akVar.nRE.setLayoutParams(layoutParams);
                    akVar.neL.setTagObject(akVar);
                    com.tencent.mm.plugin.sight.decode.a.a aVar5 = akVar.neL;
                    int hashCode3 = this.mActivity.hashCode();
                    com.tencent.mm.storage.av clT3 = com.tencent.mm.storage.av.clT();
                    clT3.time = bsu.lOH;
                    byl2.a(nVar, ate, aVar5, hashCode3, i, clT3, ayVar.nLv, true);
                    view.setVisibility(0);
                    akVar.nRC.setTag(akVar);
                    if (FileOp.cn(an.s(af.getAccSnsPath(), ate.ksA) + com.tencent.mm.plugin.sns.data.i.j(ate))) {
                        avVar.obV.nLJ.a(ayVar.oew, 0, true, z);
                    } else {
                        avVar.obV.nLJ.a(ayVar.oew, 0, false, z);
                    }
                    boolean z2 = ayVar.nLv ? af.byl().b(nVar, null) == 5 : af.byl().a(nVar, null) == 5;
                    avVar.obV.nLJ.a(ayVar.oew, z2, z);
                    findViewById = view;
                }
                layoutParams = i5.getLayoutParams();
                layoutParams.width = this.okf;
                layoutParams.height = this.okf;
                i5.setLayoutParams(layoutParams);
                if (findViewById != null) {
                    layoutParams = findViewById.getLayoutParams();
                    layoutParams.width = this.okf;
                    layoutParams.height = this.okf;
                    findViewById.setLayoutParams(layoutParams);
                }
                if (i3 == i4 && ate.hcE == 2) {
                    i5.setVisibility(0);
                    i5.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return false;
                        }
                    });
                }
                a aVar6 = new a();
                aVar6.index = i4;
                if (findViewById == null) {
                    findViewById = i5;
                }
                aVar6.view = findViewById;
                aVar6.okm = i5;
                aVar6.okn = cVar;
                aVar6.noc = ate;
                aVar6.nSE = ayVar.nhc;
                if (aVar != null) {
                    aVar.oko = aVar6;
                    aVar3 = aVar2;
                } else {
                    aVar3 = aVar6;
                }
                if (i4 == bsu.sqc.ruA.size() - 1) {
                    aVar6.oko = aVar3;
                }
                if (i4 == i3) {
                    cVar.ojK = aVar6;
                    a(aVar6);
                }
                aVar4 = aVar6;
            } else {
                aVar3 = aVar2;
                aVar4 = aVar;
            }
            i4++;
            aVar2 = aVar3;
            aVar = aVar4;
        }
        if (cVar.jEz != null && (cVar.jEz instanceof FrameLayout)) {
            ((FrameLayout) cVar.jEz).setClipChildren(false);
        }
        if (cVar.oiP != null) {
            cVar.oiP.setClipChildren(false);
        }
        if (cVar.ojO != null && (cVar.ojO instanceof LinearLayout)) {
            ((LinearLayout) cVar.ojO).setClipChildren(false);
        }
        cVar.ojI.setOnClickListener(new 4(this, avVar, i3, cVar));
    }

    public static View i(View view, int i, int i2) {
        if (i2 == 6) {
            return view.findViewById(okh[0]);
        }
        return view.findViewById(okg[i]);
    }

    private static void a(a aVar) {
        View findViewById = aVar.okn.ojI.findViewById(f.text_area_top);
        View findViewById2 = aVar.okn.ojI.findViewById(f.text_area_bottom);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
        ((TextView) aVar.okn.ojI.findViewById(f.turn_media_type_title_0)).setText(null);
        ((TextView) aVar.okn.ojI.findViewById(f.turn_media_type_title_1)).setText(null);
        ((TextView) aVar.okn.ojI.findViewById(f.turn_media_type_subtitle_0)).setText(null);
        ((TextView) aVar.okn.ojI.findViewById(f.turn_media_type_subtitle_1)).setText(null);
        com.tencent.mm.plugin.sns.storage.b bAF = aVar.nSE.bAF();
        if (bAF.nzv != null && bAF.nzv.nzE != null && bAF.nzv.nzE.size() >= 2) {
            com.tencent.mm.plugin.sns.storage.b.g gVar = (com.tencent.mm.plugin.sns.storage.b.g) bAF.nzv.nzE.get(aVar.index);
            if (gVar.nzK >= 0 && gVar.nzK < oki.length) {
                int[] iArr = oki[gVar.nzK];
                TextView textView = (TextView) aVar.okn.ojI.findViewById(iArr[0]);
                TextView textView2 = (TextView) aVar.okn.ojI.findViewById(iArr[1]);
                if (bi.oW(gVar.title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(gVar.title);
                }
                if (bi.oW(gVar.desc)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(gVar.desc);
                }
                ((View) textView.getParent()).setVisibility(0);
                ((View) textView2.getParent()).setVisibility(0);
            }
        }
    }
}
