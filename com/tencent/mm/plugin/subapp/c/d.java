package com.tencent.mm.plugin.subapp.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.am.f;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class d implements f, ar {
    private static HashMap<Integer, com.tencent.mm.bt.h.d> hsC;
    private static d org;
    private final Set<com.tencent.mm.model.am.d> dba = new HashSet();
    private String dqp;
    private a hsE;
    private k orf;
    private j orh;
    private List<Long> ori = new ArrayList();
    private c orj = new 3(this);
    private c ork = new 4(this);
    private c orl = new 5(this);

    static {
        HashMap hashMap = new HashMap();
        hsC = hashMap;
        hashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new 2());
    }

    public final void a(com.tencent.mm.model.am.d dVar) {
        x.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
        if (dVar != null) {
            this.dba.add(dVar);
        }
    }

    public final void b(com.tencent.mm.model.am.d dVar) {
        x.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
        if (dVar != null) {
            this.dba.remove(dVar);
        }
    }

    public final void f(String str, String str2, long j) {
        Context context = ad.getContext();
        if (context == null) {
            x.d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
            return;
        }
        try {
            boolean Ao = com.tencent.mm.k.f.Ao();
            boolean Am = com.tencent.mm.k.f.Am();
            x.d("MicroMsg.SubCoreVoiceRemind", "shake " + Ao + "sound " + Am);
            if (!s.hC(au.getNotification().xQ())) {
                if (Ao) {
                    bi.t(context, true);
                }
                if (Am) {
                    String An = com.tencent.mm.k.f.An();
                    Uri defaultUri = An == e.f.dgL ? RingtoneManager.getDefaultUri(2) : Uri.parse(An);
                    j jVar = new j();
                    try {
                        jVar.setDataSource(context, defaultUri);
                        jVar.setOnCompletionListener(new 1(this));
                        if (au.HV().getStreamVolume(5) != 0) {
                            if (au.HV().yK()) {
                                int streamVolume = au.HV().getStreamVolume(8);
                                int streamMaxVolume = au.HV().getStreamMaxVolume(8);
                                int streamVolume2 = au.HV().getStreamVolume(5);
                                if (streamVolume2 <= streamMaxVolume) {
                                    streamMaxVolume = streamVolume2;
                                }
                                au.HV().aP(8, streamMaxVolume);
                                jVar.setAudioStreamType(8);
                                jVar.setLooping(true);
                                jVar.prepare();
                                jVar.setLooping(false);
                                jVar.start();
                                au.HV().aP(8, streamVolume);
                                x.d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", new Object[]{Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume)});
                            } else {
                                jVar.setAudioStreamType(5);
                                jVar.setLooping(true);
                                jVar.prepare();
                                jVar.setLooping(false);
                                jVar.start();
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                        jVar.release();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e2, "relese error", new Object[0]);
                    }
                }
            } else if (Ao) {
                bi.t(context, true);
            }
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e22, "", new Object[0]);
        }
        if (this.dba == null || this.dba.size() == 0) {
            RemindDialog.w(context, str, str2);
            return;
        }
        for (com.tencent.mm.model.am.d n : this.dba) {
            n.n(str2, j);
        }
    }

    public final void ix(String str) {
        au.HU();
        com.tencent.mm.model.c.FW().Ys(str);
        this.ori.clear();
        au.HU();
        Cursor GO = com.tencent.mm.model.c.FT().GO(str);
        GO.moveToFirst();
        x.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
        while (!GO.isAfterLast()) {
            bd bdVar = new bd();
            bdVar.d(GO);
            long j = bdVar.field_msgId;
            x.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + j + " status = " + bdVar.field_status);
            GO.moveToNext();
            this.ori.add(Long.valueOf(j));
        }
        GO.close();
        au.HU();
        com.tencent.mm.model.c.FT().GM(str);
    }

    public final void HF() {
        bGu().run();
    }

    public final boolean aT(long j) {
        boolean contains = this.ori.contains(Long.valueOf(j));
        x.d("MicroMsg.SubCoreVoiceRemind", "silent " + contains + "  mid " + j);
        return contains;
    }

    public static d bGs() {
        au.HN();
        com.tencent.mm.plugin.subapp.a aVar = (com.tencent.mm.plugin.subapp.a) bs.iK("plugin.subapp");
        org = aVar == null ? null : (d) aVar.Oi(d.class.getName());
        x.i("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", new Object[]{aVar, org, bi.cjd()});
        if (org == null) {
            d dVar = new d();
            org = dVar;
            am.a.dBu = dVar;
            aVar.b(d.class.getName(), org);
        }
        return org;
    }

    public static k bGt() {
        g.Eg().Ds();
        if (bGs().orf == null) {
            d bGs = bGs();
            bGs();
            if (bGs().hsE == null) {
                StringBuilder stringBuilder = new StringBuilder();
                au.HU();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.Gp()).append("CommonOneMicroMsg.db").toString();
                bGs().hsE = u.a(d.class.hashCode(), stringBuilder2, hsC, false);
            }
            bGs.orf = new k(bGs().hsE);
        }
        return bGs().orf;
    }

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        stringBuilder.append(com.tencent.mm.model.c.Gp()).append("CommonOneMicroMsg.db");
        bGt();
        com.tencent.mm.sdk.b.a.sFg.b(this.orj);
        com.tencent.mm.sdk.b.a.sFg.b(this.ork);
        com.tencent.mm.sdk.b.a.sFg.b(this.orl);
        x.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", new Object[]{Integer.valueOf(hashCode())});
    }

    public final void bo(boolean z) {
        au.HU();
        String Gq = com.tencent.mm.model.c.Gq();
        if (bi.oW(Gq) || bi.oW(this.dqp) || !Gq.equals(this.dqp)) {
            x.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : " + Gq);
            this.dqp = Gq;
            File file = new File(Gq);
            if (!file.exists()) {
                file.mkdirs();
            }
            au.HU();
            File file2 = new File(com.tencent.mm.model.c.Gn());
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
    }

    public final void onAccountRelease() {
        if (this.orh != null) {
            this.orh.bFj = 0;
        }
        if (org != null) {
            x.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
            d dVar = org;
            if (dVar.hsE != null) {
                dVar.hsE.iQ(dVar.hashCode());
                dVar.hsE = null;
            }
            dVar.dqp = "";
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.orj);
        com.tencent.mm.sdk.b.a.sFg.c(this.ork);
        com.tencent.mm.sdk.b.a.sFg.c(this.orl);
    }

    public static j bGu() {
        g.Eg().Ds();
        if (bGs().orh == null) {
            bGs().orh = new j();
        }
        return bGs().orh;
    }
}
