package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.b;

public final class al extends c<oc> {
    Activity activity = null;
    private a tMJ = null;

    public al(a aVar, Activity activity) {
        super(0);
        this.tMJ = aVar;
        this.activity = activity;
        this.sFo = oc.class.getName().hashCode();
    }

    private boolean a(oc ocVar) {
        int i = 1;
        if (!(this.tMJ == null || ocVar == null || !(ocVar instanceof oc))) {
            bd bdVar;
            long j = ocVar.bYY.bJC;
            String str = ocVar.bYY.bYZ;
            bd bdVar2 = ocVar.bYY.bZa;
            if (bdVar2 == null || bdVar2.field_msgId <= 0) {
                bdVar = ocVar.bYY.bZa;
            } else {
                bdVar = bdVar2;
            }
            if (bdVar != null) {
                switch (bdVar.getType()) {
                    case 3:
                        switch (3.tML[this.tMJ.ordinal()]) {
                            case 1:
                                if (bdVar != null && bdVar.field_msgId > 0) {
                                    try {
                                        g.ND().lx(d.a("downimg", bdVar.field_createTime, bdVar.field_talker, bdVar.field_msgId));
                                        x.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[]{Boolean.valueOf(true)});
                                        au.DF().cancel(109);
                                        o.Pg().l(com.tencent.mm.ui.chatting.gallery.d.bv(bdVar).dTK, j);
                                    } catch (Throwable e) {
                                        x.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[]{e.getMessage()});
                                    }
                                }
                                if (this.activity != null && (this.activity instanceof ImageGalleryUI)) {
                                    x.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[]{Long.valueOf(j), Long.valueOf(((ImageGalleryUI) this.activity).bJC)});
                                    if (j == ((ImageGalleryUI) this.activity).bJC) {
                                        h.a(this.activity, str, "", false, new 1(this));
                                        break;
                                    }
                                }
                                break;
                        }
                        break;
                    case 43:
                    case 62:
                        String str2 = "MicroMsg.RevokeMsgListener";
                        String str3 = "ashutest::revoke msg, type %s, isWorkerThread %B";
                        Object[] objArr = new Object[2];
                        objArr[0] = this.tMJ;
                        objArr[1] = Boolean.valueOf(Looper.myLooper() == au.Em().lnJ.getLooper());
                        x.v(str2, str3, objArr);
                        switch (3.tML[this.tMJ.ordinal()]) {
                            case 2:
                                aP(bdVar);
                                if (this.activity instanceof ImageGalleryUI) {
                                    ImageGalleryUI imageGalleryUI = (ImageGalleryUI) this.activity;
                                    if (!(imageGalleryUI.tTx != null && b.bh(bdVar) && bdVar.field_msgId == imageGalleryUI.tTx.cwN().field_msgId)) {
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        imageGalleryUI.FE(imageGalleryUI.getCurrentItem());
                                        h.a(this.activity, str, "", false, new 2(this));
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                aP(bdVar);
                                break;
                        }
                        break;
                }
            }
            x.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        }
        return false;
    }

    private static void aP(bd bdVar) {
        r nW = t.nW(bdVar.field_imgPath);
        if (nW != null) {
            try {
                g.ND().lx(d.a("downvideo", nW.createTime, nW.Tj(), nW.getFileName()));
                x.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[]{Boolean.valueOf(true)});
                a Tf = com.tencent.mm.modelvideo.o.Tf();
                com.tencent.mm.kernel.g.DF().c(Tf.eox);
                Tf.wx();
                com.tencent.mm.model.bd.j(bdVar);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[]{e.getMessage()});
            }
        }
    }
}
