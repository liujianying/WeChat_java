package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.h.c;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.k.a;
import com.tencent.mm.plugin.r.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class i implements c, a {
    private Context context;
    private String hNf = "";
    private ViewGroup kFK;
    private View kFL;
    private h kFM;
    private j kFN;
    private ArrayList<String> kFO;
    private String kFP = "";
    private boolean kFQ = false;
    public a kFR;
    private d kFl;

    public i(Context context, ViewGroup viewGroup, View view, String str, d dVar) {
        this.kFK = viewGroup;
        this.kFL = view;
        this.context = context;
        this.kFO = new ArrayList();
        this.hNf = str;
        this.kFl = dVar;
        init();
    }

    private void init() {
        x.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[]{this.hNf});
        this.kFM = new h(this.context, this.kFL, this.hNf);
        this.kFM.kFC = this;
        this.kFN = new j(this.context, this.kFK, this.hNf);
        for (String add : l.aZj().ns(this.hNf)) {
            this.kFO.add(add);
        }
    }

    public final void D(ArrayList<String> arrayList) {
        String str;
        x.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        this.kFM.D(arrayList);
        j jVar = this.kFN;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (jVar.kFT.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        it = jVar.kFT.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        if (jVar.kGf) {
            jVar.kGf = false;
            if (arrayList2.size() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    jVar.kFT.add((String) it2.next());
                }
            }
            jVar.gh(false);
            return;
        }
        Message obtain;
        if (arrayList2.size() > 0) {
            str = (String) arrayList2.get(0);
            jVar.kFT.add(str);
            if (!bi.oW(r.gT(str))) {
                jVar.mHandler.removeMessages(3);
                obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = str;
                jVar.mHandler.sendMessage(obtain);
                jVar.gh(true);
            }
        }
        if (arrayList3.size() > 0) {
            str = (String) arrayList3.get(0);
            if (!bi.oW(str) && jVar.kFT.indexOf(str) != -1) {
                jVar.kFT.remove(jVar.kFT.indexOf(str));
                if (!bi.oW(r.gT(str))) {
                    obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = str;
                    jVar.mHandler.sendMessage(obtain);
                    jVar.gh(true);
                }
            }
        }
    }

    public final void FT(String str) {
        if (this.kFR != null) {
            this.kFR.FT(str);
        }
    }

    public final void aZF() {
        x.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
        this.kFQ = true;
        String GF = q.GF();
        this.kFM.aZB();
        this.kFM.FQ(GF);
        j jVar = this.kFN;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
        jVar.mHandler.removeMessages(6);
        jVar.mHandler.removeMessages(5);
        Message obtain = Message.obtain();
        obtain.what = 6;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        Object viewByItag = this.kFl.getViewByItag(GF);
        if (viewByItag instanceof TrackPoint) {
            ((TrackPoint) viewByItag).set2Top();
        }
        this.kFP = GF;
    }

    public final void FU(String str) {
        x.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[]{str});
        if (!this.kFQ) {
            this.kFP = str;
            h hVar = this.kFM;
            String str2 = this.kFP;
            x.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[]{str2});
            if (bi.oW(str2)) {
                hVar.aZB();
            } else {
                hVar.aZB();
                hVar.FQ(str2);
            }
            j jVar = this.kFN;
            str2 = this.kFP;
            x.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[]{str2});
            if (bi.oW(str2)) {
                jVar.kGk = false;
                jVar.mHandler.removeMessages(10);
                Message obtain = Message.obtain();
                obtain.what = 10;
                jVar.mHandler.sendMessage(obtain);
                jVar.gh(true);
            } else {
                if (!bi.oW(r.gT(str2))) {
                    jVar.kGk = true;
                    jVar.mHandler.removeMessages(5);
                    Message obtain2 = Message.obtain();
                    obtain2.what = 5;
                    obtain2.obj = str2;
                    jVar.mHandler.sendMessageAtFrontOfQueue(obtain2);
                }
                jVar.gh(true);
            }
            Object viewByItag = this.kFl.getViewByItag(this.kFP);
            if (viewByItag instanceof TrackPoint) {
                ((TrackPoint) viewByItag).set2Top();
            }
        }
    }

    public final void aZG() {
        x.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
        h hVar = this.kFM;
        String GF = q.GF();
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[]{GF});
        if (hVar.kFA.FS(GF)) {
            hVar.kFA.FR(GF).aZE();
            hVar.kFA.notifyDataSetChanged();
            hVar.kFz.invalidate();
        }
        j jVar = this.kFN;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
        jVar.mHandler.removeMessages(9);
        jVar.mHandler.removeMessages(10);
        Message obtain = Message.obtain();
        obtain.what = 9;
        jVar.mHandler.sendMessage(obtain);
        this.kFP = "";
        this.kFQ = false;
    }

    public final void aZH() {
        j jVar = this.kFN;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
        jVar.mHandler.removeMessages(8);
        Message obtain = Message.obtain();
        obtain.what = 8;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
    }

    public final void FV(String str) {
        j jVar = this.kFN;
        x.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[]{str});
        if (!bi.oW(str) && !bi.oW(r.gT(str))) {
            jVar.kGk = true;
            jVar.mHandler.removeMessages(7);
            Message obtain = Message.obtain();
            obtain.what = 7;
            jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        }
    }
}
