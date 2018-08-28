package com.tencent.mm.bi;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.widget.EditText;
import com.tencent.mm.api.d;
import com.tencent.mm.api.l;
import com.tencent.mm.bd.a.e;
import com.tencent.mm.bi.a.7;
import com.tencent.mm.d.a;
import com.tencent.mm.d.b;
import com.tencent.mm.d.c;
import com.tencent.mm.d.c.8;
import com.tencent.mm.d.c.9;
import com.tencent.mm.d.f;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements l {
    final /* synthetic */ a qVu;

    a$1(a aVar) {
        this.qVu = aVar;
    }

    public final void a(d dVar) {
        x.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", new Object[]{dVar});
        if (this.qVu.qVl.getSelectedFeatureListener() != null) {
            this.qVu.qVl.getSelectedFeatureListener().a(dVar);
        }
        if (dVar == d.bwS) {
            this.qVu.qVl.getFooterBg().setVisibility(8);
        }
        b bVar = (b) this.qVu.qVm.get(dVar);
        if (bVar != null) {
            if (bVar.isCreated && !bVar.isAlive()) {
                bVar.vH();
            }
            if (bVar.vE() != a.bBg) {
                bVar.setOneFingerMoveEnable(false);
            }
            bVar.vI();
            this.qVu.qVt = bVar;
            switch (7.qVw[dVar.ordinal()]) {
                case 1:
                    ((EditText) this.qVu.qVl.getTextEditView().findViewById(e.text_edit)).setTextColor(com.tencent.mm.view.footer.a.uUQ[0]);
                    this.qVu.kW(true);
                    this.qVu.qVl.setFooterVisible(false);
                    break;
                case 2:
                    this.qVu.qVl.setActionBarVisible(false);
                    this.qVu.qVl.setFooterVisible(false);
                    this.qVu.qVl.mK(false);
                    break;
                case 3:
                    this.qVu.qVr = this.qVu.qVs;
                    return;
            }
            this.qVu.qVs = dVar;
        }
    }

    public final void a(d dVar, int i) {
        x.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[]{dVar, Integer.valueOf(i)});
        if (this.qVu.qVl.getSelectedFeatureListener() != null) {
            this.qVu.qVl.getSelectedFeatureListener().a(dVar, i);
        }
        this.qVu.qVt = (b) this.qVu.qVm.get(dVar);
        if (this.qVu.cfR().vE() != a.bBg) {
            if (this.qVu.qVl.getFooterBg().getVisibility() == 8) {
                this.qVu.qVl.getFooterBg().setVisibility(0);
            }
            switch (7.qVw[dVar.ordinal()]) {
                case 3:
                    c cVar = (c) this.qVu.cfR();
                    float width;
                    if (i == 0) {
                        cVar.bCa++;
                        cVar.bBK.cancel();
                        if (cVar.bBY != null) {
                            cVar.bBY.cancel();
                        }
                        Matrix matrix = new Matrix();
                        matrix.postRotate(-90.0f, (float) cVar.bwl.centerX(), (float) cVar.bwl.centerY());
                        if (cVar.bBZ.isEmpty()) {
                            cVar.bBZ.set(cVar.bwl);
                        }
                        RectF rectF = new RectF(cVar.bBZ);
                        matrix.mapRect(rectF);
                        width = (1.0f * ((float) cVar.bBG.width())) / rectF.width();
                        float height = (1.0f * ((float) cVar.bBG.height())) / rectF.height();
                        if (width >= height) {
                            width = height;
                        }
                        matrix.postScale(width, width, (float) cVar.bwl.centerX(), (float) cVar.bwl.centerY());
                        rectF.set(cVar.bBZ);
                        matrix.mapRect(rectF);
                        cVar.bBZ.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        height = (float) cVar.bwl.centerX();
                        float centerY = (float) cVar.bwl.centerY();
                        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("rotation", new int[]{0, -90});
                        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("deltaX", new int[]{0, cVar.bBG.centerX() - ((int) height)});
                        PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("deltaY", new int[]{0, cVar.bBG.centerY() - ((int) centerY)});
                        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, ofInt2, ofInt3});
                        ofPropertyValuesHolder.addUpdateListener(new 8(cVar, height, centerY, width));
                        ofPropertyValuesHolder.addListener(new 9(cVar));
                        ofPropertyValuesHolder.setDuration(200);
                        ofPropertyValuesHolder.start();
                        return;
                    } else if (1 == i) {
                        x.i("MicroMsg.CropArtist", "[cancel]");
                        cVar.bBK.cancel();
                        if (cVar.bBY != null) {
                            cVar.bBY.cancel();
                        }
                        cVar.bBn.cfQ().getBaseBoardView().uUg = cVar.bBn.cfQ().getBaseBoardView().getRawBoardRect();
                        com.tencent.mm.t.a yp = ((com.tencent.mm.cache.a) cVar.vG()).yp();
                        width = 0.0f;
                        if (yp != null) {
                            width = cVar.getRotation() - cVar.a(yp.mMatrix);
                        }
                        if (!(yp == null || yp.dnF.isEmpty())) {
                            cVar.bBn.cfQ().getBaseBoardView().m(yp.dnF);
                        }
                        cVar.bBn.cfQ().getBaseBoardView().a(null, width, true);
                        cVar.bBn.cfQ().getActionBar().setVisibility(0);
                        this.qVu.qVt = (b) this.qVu.qVm.get(this.qVu.qVr);
                        this.qVu.qVl.getBaseFooterView().setCurFeatureType(this.qVu.qVr);
                        return;
                    } else if (2 == i) {
                        x.i("MicroMsg.CropArtist", "[doCrop]");
                        if (cVar.bBY != null) {
                            cVar.bBY.cancel();
                        }
                        if (cVar.bBK.bwt) {
                            cVar.bBK.bwp = null;
                            cVar.c();
                        } else {
                            if (!cVar.bBK.bwu) {
                                cVar.bBK.cancel();
                                cVar.bBK.play();
                            }
                            cVar.bBK.bwp = new AnimatorListener() {
                                public final void onAnimationStart(Animator animator) {
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    c.this.bBK.bwp = null;
                                    c.this.c();
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    c.this.bBK.bwp = null;
                                }

                                public final void onAnimationRepeat(Animator animator) {
                                }
                            };
                        }
                        this.qVu.qVt = (b) this.qVu.qVm.get(this.qVu.qVr);
                        this.qVu.qVl.getBaseFooterView().setCurFeatureType(this.qVu.qVr);
                        return;
                    } else if (3 == i) {
                        x.i("MicroMsg.CropArtist", "[reset]");
                        cVar.bCb = true;
                        cVar.bBK.cancel();
                        if (cVar.bBY != null) {
                            cVar.bBY.cancel();
                        }
                        cVar.bBZ.setEmpty();
                        cVar.vS();
                        cVar.bBQ = false;
                        cVar.bBn.cfQ().getBaseBoardView().uUg = cVar.bwl;
                        cVar.bBn.cfQ().getBaseBoardView().a(new c.7(cVar), cVar.getRotation(), true);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    com.tencent.mm.d.d dVar2 = (com.tencent.mm.d.d) this.qVu.cfR();
                    if (i != -1) {
                        this.qVu.qVl.getBaseFooterView();
                        dVar2.pN = com.tencent.mm.view.footer.a.getColor(i);
                        return;
                    }
                    dVar2.vN();
                    return;
                case 5:
                    f fVar = (f) this.qVu.cfR();
                    if (i == 0) {
                        fVar.bCF = com.tencent.mm.t.d.a.doc;
                        return;
                    } else if (1 == i) {
                        fVar.bCF = com.tencent.mm.t.d.a.dod;
                        return;
                    } else {
                        fVar.vN();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public final void aD(boolean z) {
    }
}
