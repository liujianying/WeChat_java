package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;

public final class h extends a implements a, s.a, al.a {
    private d gbl;
    private HashMap<String, i.a> tVv;
    private boolean tVw;

    public h(b bVar) {
        super(bVar);
        this.tVw = false;
        this.tVw = false;
        this.tVv = new HashMap();
        o.Ta().a(this, Looper.getMainLooper());
        this.gbl = new d();
    }

    public final boolean a(j jVar, bd bdVar, int i) {
        super.a(jVar, bdVar, i);
        o.Ta();
        Bitmap e = b.e(s.nL(bdVar.field_imgPath), 1.0f);
        if (this.tVv != null) {
            this.tVv.put(bdVar.field_imgPath, new i.a(bdVar, i));
        }
        a(jVar, false);
        ((View) jVar.cxy().tWS).setVisibility(8);
        jVar.cxy().tWT.setImageBitmap(e);
        jVar.cxy().tWT.setVisibility(0);
        jVar.cxy().tWW.setVisibility(8);
        r nW = t.nW(bdVar.field_imgPath);
        jVar.tWW.setTag(nW);
        bri bri = nW == null ? null : nW.enV;
        if (bri == null) {
            jVar.jcm.setVisibility(8);
        } else if (ai.oW(bri.dyJ)) {
            x.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
            CharSequence charSequence = bri.dyM;
            String str = bri.dyN;
            if (bi.oW(charSequence) || bi.oW(str)) {
                jVar.jcm.setVisibility(8);
            } else {
                jVar.jcm.setText(charSequence);
                jVar.jcm.setVisibility(0);
                jVar.jcm.setTag(bdVar);
            }
        } else {
            jVar.jcm.setVisibility(0);
            jVar.jcm.setText(this.tTx.tTy.getString(R.l.sns_ad_sight_full, new Object[]{Integer.valueOf(bri.rBq)}));
            String string = this.tTx.tTy.getString(R.l.sns_ad_sight_full);
            if (bri.rBq / 60 > 0) {
                string = string + this.tTx.tTy.getString(R.l.sns_ad_sight_full_m, new Object[]{Integer.valueOf(bri.rBq / 60)});
            }
            if (bri.rBq % 60 > 0) {
                string = string + this.tTx.tTy.getString(R.l.sns_ad_sight_full_s, new Object[]{Integer.valueOf(bri.rBq % 60)});
            }
            jVar.jcm.setText(string + this.tTx.tTy.getString(R.l.sns_ad_sight_full_end));
            jVar.jcm.setTag(bdVar);
        }
        if (jVar.cxy().tWS instanceof VideoSightView) {
            n.a(jVar.jcm, (VideoSightView) jVar.cxy().tWS);
        }
        return true;
    }

    public final void cwV() {
        SparseArray sparseArray = this.tTx.tzb;
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                j jVar = (j) ((View) sparseArray.get(keyAt)).getTag();
                if (jVar.tWR != null && jVar.cxy().tWR.getVisibility() == 0) {
                    jVar.cxy().tWS.setVideoCallback(null);
                    if (((View) jVar.cxy().tWS).getVisibility() == 0 && jVar != null) {
                        a(jVar, false);
                        if (jVar.cxy().tWS != null) {
                            jVar.cxy().tWS.stop();
                        }
                        x.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
                        this.gbl.bv(false);
                        this.tTx.tTy.mController.tml.getWindow().clearFlags(128);
                    }
                }
            }
        }
    }

    public final void FB(int i) {
        bd ES = this.tTx.ES(i);
        j Fl = Fl(i);
        if (ES != null && Fl != null) {
            r nW = t.nW(ES.field_imgPath);
            if (nW != null) {
                if (ES.field_isSend == 0) {
                    if (nW.status == 113 || nW.status == 111 || nW.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        a(nW, Fl);
                        return;
                    } else if (nW.status == 198) {
                        a(nW, Fl);
                        return;
                    }
                }
                b(ES, Fl);
            }
        }
    }

    private void a(r rVar, j jVar) {
        if (rVar != null) {
            t.nU(rVar.getFileName());
            jVar.cxy().tWV.setVisibility(0);
            jVar.cxy().tWV.setProgress(t.f(rVar));
            o.Ta().a(this, Looper.getMainLooper());
        }
    }

    private void b(bd bdVar, j jVar) {
        if (!this.tVw) {
            jVar.cxy().tWW.setVisibility(8);
            o.Ta();
            String nK = s.nK(bdVar.field_imgPath);
            if (bdVar.cmu()) {
                Toast.makeText(this.tTx.tTy, R.l.video_fail_or_clean, 0).show();
            } else if (nK == null || !e.cn(nK)) {
                Toast.makeText(this.tTx.tTy, R.l.video_fail_or_clean, 0).show();
            } else {
                this.tTx.tTy.mController.tml.getWindow().addFlags(128);
                Boolean bool = (Boolean) jVar.tWQ.get(nK);
                if (bool == null || !bool.booleanValue()) {
                    ((View) jVar.cxy().tWS).setTag(nK);
                    jVar.cxy().tWU.setVisibility(8);
                    jVar.cxy().tWS.stop();
                    if (this.tTx.tTy.gJ(bdVar.field_msgId) == 3) {
                        jVar.cxy().tWS.setMute(true);
                    } else {
                        jVar.cxy().tWS.setMute(false);
                    }
                    jVar.cxy().tWS.setVideoPath(nK);
                    if (jVar.cxy().tWS.q(this.tTx.tTy.mController.tml, false)) {
                        ((View) jVar.cxy().tWS).setVisibility(0);
                        jVar.cxy().tWT.setVisibility(8);
                    } else {
                        jVar.cxy().tWU.setVisibility(0);
                        jVar.cxy().tWU.setOnClickListener(new 1(this, jVar));
                        ((View) jVar.cxy().tWS).setVisibility(8);
                        jVar.cxy().tWT.setVisibility(0);
                    }
                    x.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
                    this.gbl.a(this);
                }
                ((View) jVar.cxy().tWS).setVisibility(0);
            }
        }
    }

    private static void a(j jVar, boolean z) {
        if (jVar != null) {
            jVar.cxy().tWV.setVisibility(8);
            if (z) {
                jVar.cxy().tWT.setVisibility(8);
                ((View) jVar.cxy().tWS).setVisibility(0);
                return;
            }
            jVar.cxy().tWT.setVisibility(0);
            ((View) jVar.cxy().tWS).setVisibility(8);
        }
    }

    public final boolean vD() {
        if (this.tTx != null) {
            j cwO = this.tTx.cwO();
            if (!(cwO == null || cwO.tWR == null || cwO.cxy().tWR.getVisibility() != 0)) {
                a(cwO, true);
            }
        }
        return false;
    }

    private boolean a(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        o.Ta().a(this);
        if (this.tTx.tTy.getCurrentItem() == aVar.pos) {
            j Fl = Fl(aVar.pos);
            if (Fl != null) {
                Fl.cxy().tWV.setVisibility(8);
            }
            return true;
        }
        this.tTx.Ft(aVar.pos);
        return false;
    }

    public final void detach() {
        cwV();
        this.tTx.tTy.mController.tml.getWindow().clearFlags(128);
        this.tVw = true;
        super.detach();
        this.tVv.clear();
        this.tVv = null;
        o.Ta().a(this);
        x.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
        this.gbl.bv(true);
    }

    public final void a(s.a.a aVar) {
        String str = aVar.fileName;
        if (!ai.oW(str) && this.tVv != null) {
            i.a aVar2 = (i.a) this.tVv.get(str);
            if (aVar2 != null) {
                bd bdVar = aVar2.bGS;
                if (bdVar != null && bdVar.field_imgPath != null && bdVar.field_imgPath.equals(str)) {
                    r nW = t.nW(bdVar.field_imgPath);
                    if (nW == null) {
                        return;
                    }
                    if (!bdVar.cmu() && nW.status != 198) {
                        int f = t.f(nW);
                        j Fl = Fl(aVar2.pos);
                        if (this.tTx.tTy.getCurrentItem() == aVar2.pos && Fl != null) {
                            Fl.cxy().tWV.setVisibility(0);
                            Fl.cxy().tWV.setProgress(f);
                        } else if (Fl == null) {
                            return;
                        }
                        if (f >= Fl.cxz().tWV.getMax() && a(aVar2)) {
                            b(bdVar, Fl);
                        }
                    } else if (a(aVar2)) {
                        Toast.makeText(this.tTx.tTy, R.l.video_fail_or_clean, 0).show();
                    }
                }
            }
        }
    }
}
