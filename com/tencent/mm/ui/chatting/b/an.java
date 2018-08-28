package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.af;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;

@a(cwo = af.class)
public class an extends a implements af {
    private long tTb = -1;
    private SparseBooleanArray tTc = new SparseBooleanArray();

    private void do(final String str, final int i) {
        au.Em().H(new Runnable() {
            public final void run() {
                t.W(str, i);
            }
        });
    }

    public final boolean a(MenuItem menuItem, bd bdVar) {
        int i;
        switch (menuItem.getItemId()) {
            case s$l.AppCompatTheme_ratingBarStyle /*106*/:
                r nI = o.Ta().nI(bdVar.field_imgPath);
                if (nI == null) {
                    x.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
                } else if (nI.status == 199) {
                    o.Ta();
                    String nK = s.nK(bdVar.field_imgPath);
                    if (nI != null) {
                        i = 0;
                        if (com.tencent.mm.model.s.fq(nI.Tj())) {
                            i = m.gK(nI.Tj());
                        }
                        h.mEJ.a(106, 215, 1, false);
                        h.mEJ.h(12084, new Object[]{Integer.valueOf(nI.dHI), Integer.valueOf(nI.enM * 1000), Integer.valueOf(0), Integer.valueOf(2), nI.Tj(), Integer.valueOf(i), r.nH(nI.Tm()), Long.valueOf(nI.createTime)});
                    }
                    String nX = t.nX(nK);
                    if (bi.oW(nX)) {
                        Toast.makeText(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.video_file_save_failed), 1).show();
                    } else {
                        Toast.makeText(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.video_file_saved, new Object[]{nX}), 1).show();
                        l.a(nX, this.bAG.tTq.getContext());
                    }
                } else {
                    do(nI.getFileName(), 6);
                    Intent intent = new Intent(this.bAG.tTq.getContext(), ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", bdVar.field_msgId);
                    intent.putExtra("img_gallery_msg_svr_id", bdVar.field_msgSvrId);
                    intent.putExtra("img_gallery_talker", bdVar.field_talker);
                    intent.putExtra("img_gallery_chatroom_name", bdVar.field_talker);
                    intent.putExtra("img_gallery_enter_video_opcode", t.e(bdVar.field_msgId, 2));
                    i.a(this.bAG, bdVar, intent);
                    this.bAG.tTq.startActivity(intent);
                    this.bAG.tTq.overridePendingTransition(0, 0);
                }
                return true;
            case s$l.AppCompatTheme_ratingBarStyleIndicator /*107*/:
                au.HU();
                if (!c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.gH(this.bAG.tTq.getContext());
                    break;
                }
                r nW = t.nW(bdVar.field_imgPath);
                if (nW != null) {
                    if (!bdVar.cmu()) {
                        o.Ta();
                        Intent intent2;
                        if (!i.e(bdVar, s.nK(bdVar.field_imgPath))) {
                            if (nW.status != 199) {
                                if (!bdVar.cmj() && !bdVar.cmk()) {
                                    x.w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
                                    break;
                                }
                                do(nW.getFileName(), 3);
                                intent2 = new Intent(this.bAG.tTq.getContext(), ImageGalleryUI.class);
                                intent2.putExtra("img_gallery_msg_id", bdVar.field_msgId);
                                intent2.putExtra("img_gallery_msg_svr_id", bdVar.field_msgSvrId);
                                intent2.putExtra("img_gallery_talker", bdVar.field_talker);
                                intent2.putExtra("img_gallery_chatroom_name", bdVar.field_talker);
                                intent2.putExtra("img_gallery_enter_video_opcode", t.e(bdVar.field_msgId, 1));
                                i.a(this.bAG, bdVar, intent2);
                                this.bAG.tTq.startActivity(intent2);
                                this.bAG.tTq.overridePendingTransition(0, 0);
                                if (!nW.To()) {
                                    x.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
                                    t.nS(bdVar.field_imgPath);
                                    break;
                                }
                                x.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
                                t.oa(bdVar.field_imgPath);
                                break;
                            }
                            intent2 = new Intent(this.bAG.tTq.getContext(), MsgRetransmitUI.class);
                            intent2.putExtra("Retr_length", nW.enM);
                            intent2.putExtra("Retr_File_Name", bdVar.field_imgPath);
                            intent2.putExtra("Retr_video_isexport", nW.enQ);
                            intent2.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                            intent2.putExtra("Retr_From", "chattingui");
                            x.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + bdVar.getType());
                            if (bdVar.cmk()) {
                                intent2.putExtra("Retr_Msg_Type", 11);
                            } else {
                                intent2.putExtra("Retr_Msg_Type", 1);
                            }
                            this.bAG.tTq.startActivity(intent2);
                            break;
                        }
                        x.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
                        do(nW.getFileName(), 3);
                        intent2 = new Intent(this.bAG.tTq.getContext(), ImageGalleryUI.class);
                        intent2.putExtra("img_gallery_msg_id", bdVar.field_msgId);
                        intent2.putExtra("img_gallery_msg_svr_id", bdVar.field_msgSvrId);
                        intent2.putExtra("img_gallery_talker", bdVar.field_talker);
                        intent2.putExtra("img_gallery_chatroom_name", bdVar.field_talker);
                        intent2.putExtra("img_gallery_enter_video_opcode", t.e(bdVar.field_msgId, 1));
                        i.a(this.bAG, bdVar, intent2);
                        this.bAG.tTq.startActivity(intent2);
                        this.bAG.tTq.overridePendingTransition(0, 0);
                        if (!nW.To()) {
                            x.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
                            t.nS(bdVar.field_imgPath);
                            break;
                        }
                        x.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
                        t.oa(bdVar.field_imgPath);
                        break;
                    }
                    x.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
                    com.tencent.mm.ui.base.h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getContext().getString(R.l.video_clean), this.bAG.tTq.getContext().getString(R.l.app_tip), new 2(this));
                    break;
                }
                x.e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
                break;
                break;
            case 130:
                Intent intent3 = menuItem.getIntent();
                int i2 = 0;
                i = 0;
                int[] iArr = new int[2];
                if (intent3 == null) {
                    x.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
                } else {
                    i2 = intent3.getIntExtra("img_gallery_width", 0);
                    i = intent3.getIntExtra("img_gallery_height", 0);
                    iArr[0] = intent3.getIntExtra("img_gallery_left", 0);
                    iArr[1] = intent3.getIntExtra("img_gallery_top", 0);
                }
                intent3 = new Intent(this.bAG.tTq.getContext(), ImageGalleryUI.class);
                intent3.putExtra("img_gallery_msg_id", bdVar.field_msgId);
                intent3.putExtra("img_gallery_msg_svr_id", bdVar.field_msgSvrId);
                intent3.putExtra("img_gallery_talker", bdVar.field_talker);
                intent3.putExtra("img_gallery_chatroom_name", bdVar.field_talker);
                intent3.putExtra("img_gallery_left", iArr[0]);
                intent3.putExtra("img_gallery_top", iArr[1]);
                intent3.putExtra("img_gallery_width", i2);
                intent3.putExtra("img_gallery_height", i);
                intent3.putExtra("img_gallery_enter_video_opcode", t.e(bdVar.field_msgId, 3));
                i.a(this.bAG, bdVar, intent3);
                this.bAG.tTq.startActivity(intent3);
                this.bAG.tTq.overridePendingTransition(0, 0);
                return true;
        }
        return false;
    }

    public final boolean g(bd bdVar, boolean z) {
        if (bdVar.cmj()) {
            o.Ta();
            if (FileOp.cn(s.nK(bdVar.field_imgPath))) {
                return z;
            }
            return false;
        } else if (!bdVar.cmk()) {
            return z;
        } else {
            o.Ta();
            if (FileOp.cn(s.nK(bdVar.field_imgPath))) {
                return z;
            }
            return false;
        }
    }

    public final void ax(Intent intent) {
        if (intent != null) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                x.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
            } else if (ab.bU(this.bAG.tTq.getContext())) {
                ag(stringArrayListExtra);
            } else {
                com.tencent.mm.ui.base.h.a(this.bAG.tTq.getContext(), R.l.video_export_file_warning, R.l.app_tip, new 3(this, stringArrayListExtra), null);
            }
        }
    }

    private void ag(ArrayList<String> arrayList) {
        x.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[]{arrayList.toString()});
        j jVar = new j(this.bAG.tTq.getContext(), arrayList, null, this.bAG.getTalkerUserName(), 2, new 4(this));
        com.tencent.mm.ui.chatting.c.a aVar = this.bAG;
        Context context = this.bAG.tTq.getContext();
        this.bAG.tTq.getMMResources().getString(R.l.app_tip);
        aVar.d(context, this.bAG.tTq.getMMResources().getString(R.l.app_waiting), new 5(this, jVar));
        e.post(jVar, "ChattingUI_importMultiVideo");
    }

    public final void T(Intent intent) {
        x.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
        if (ab.bU(this.bAG.tTq.getContext())) {
            U(intent);
        } else {
            com.tencent.mm.ui.base.h.a(this.bAG.tTq.getContext(), R.l.video_export_file_warning, R.l.app_tip, new 6(this, intent), null);
        }
    }

    private void U(Intent intent) {
        com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        cVar.a(this.bAG.tTq.getContext(), intent, new 7(this));
        com.tencent.mm.ui.chatting.c.a aVar = this.bAG;
        Context context = this.bAG.tTq.getContext();
        this.bAG.tTq.getMMResources().getString(R.l.app_tip);
        aVar.d(context, this.bAG.tTq.getMMResources().getString(R.l.app_waiting), new 8(this, cVar));
    }

    private void ay(Intent intent) {
        x.d("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
        if (intent == null) {
            x.e("MicroMsg.ChattingUI.VideoComponent", "data == null");
            return;
        }
        String stringExtra = intent.getStringExtra("VideoRecorder_ToUser");
        String stringExtra2 = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        x.e("MicroMsg.ChattingUI.VideoComponent", "fileName " + stringExtra2 + " length " + intExtra + " user " + stringExtra);
        if (!bi.oW(stringExtra) && !bi.oW(stringExtra2) && intExtra >= 0) {
            if (stringExtra.equals("medianote") && (q.GJ() & 16384) == 0) {
                r rVar = new r();
                rVar.fileName = stringExtra2;
                rVar.enM = intExtra;
                rVar.bWJ = stringExtra;
                rVar.enF = (String) g.Ei().DT().get(2, "");
                rVar.createTime = bi.VE();
                rVar.enK = bi.VE();
                rVar.enH = intExtra;
                rVar.emu = intExtra;
                o.Ta();
                int nM = s.nM(s.nK(stringExtra2));
                if (nM <= 0) {
                    x.e("MicroMsg.VideoLogic", "get Video size failed :" + stringExtra2);
                    return;
                }
                rVar.dHI = nM;
                o.Ta();
                stringExtra = s.nL(stringExtra2);
                intExtra = s.nM(stringExtra);
                if (intExtra <= 0) {
                    x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + stringExtra + " size:" + intExtra);
                    return;
                }
                rVar.enJ = intExtra;
                x.d("MicroMsg.VideoLogic", "init record file:" + stringExtra2 + " thumbsize:" + rVar.enJ + " videosize:" + rVar.dHI);
                rVar.status = 199;
                bd bdVar = new bd();
                bdVar.ep(rVar.Tj());
                bdVar.setType(43);
                bdVar.eX(1);
                bdVar.eq(stringExtra2);
                bdVar.setStatus(2);
                bdVar.ay(com.tencent.mm.model.bd.iD(rVar.Tj()));
                rVar.enN = (int) com.tencent.mm.model.bd.i(bdVar);
                o.Ta().a(rVar);
                return;
            }
            t.b(stringExtra2, intExtra, stringExtra, null);
            t.nR(stringExtra2);
            this.bAG.lT(true);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 208:
                T(intent);
                return;
            case 215:
                T(intent);
                return;
            case 216:
                ay(intent);
                return;
            case 218:
                if (intent == null) {
                    return;
                }
                if (intent.getBooleanExtra("from_record", false)) {
                    ay(intent);
                    return;
                } else {
                    T(intent);
                    return;
                }
            case 226:
                if (intent == null) {
                    x.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
                    return;
                }
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult == null) {
                    x.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
                    return;
                } else if (sightCaptureResult.lec) {
                    ((com.tencent.mm.ui.chatting.b.b.x) this.bAG.O(com.tencent.mm.ui.chatting.b.b.x.class)).a(sightCaptureResult);
                    return;
                } else {
                    boolean z;
                    x.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path ", new Object[]{sightCaptureResult.lee, sightCaptureResult.lef});
                    o.Ta();
                    String nK = s.nK(sightCaptureResult.leg);
                    if (!sightCaptureResult.lee.equals(nK)) {
                        x.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[]{sightCaptureResult.lee, nK});
                        FileOp.av(sightCaptureResult.lee, nK);
                    }
                    String str = sightCaptureResult.leg;
                    int i3 = sightCaptureResult.lei;
                    String talkerUserName = this.bAG.getTalkerUserName();
                    aso aso = sightCaptureResult.lej;
                    r rVar = new r();
                    rVar.fileName = str;
                    rVar.enM = i3;
                    rVar.bWJ = talkerUserName;
                    rVar.enF = (String) g.Ei().DT().get(2, "");
                    rVar.createTime = bi.VE();
                    rVar.enK = bi.VE();
                    rVar.enW = aso;
                    rVar.enQ = 0;
                    rVar.enT = 1;
                    o.Ta();
                    i3 = s.nM(s.nK(str));
                    if (i3 <= 0) {
                        x.e("MicroMsg.VideoLogic", "get Video size failed :" + str);
                        z = false;
                    } else {
                        rVar.dHI = i3;
                        o.Ta();
                        nK = s.nL(str);
                        int nM = s.nM(nK);
                        if (nM <= 0) {
                            x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + nK + " size:" + nM);
                            z = false;
                        } else {
                            rVar.enJ = nM;
                            x.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + rVar.enJ + " videosize:" + rVar.dHI);
                            rVar.status = s$l.AppCompatTheme_checkboxStyle;
                            bd bdVar = new bd();
                            bdVar.ep(rVar.Tj());
                            bdVar.setType(43);
                            bdVar.eX(1);
                            bdVar.eq(str);
                            bdVar.setStatus(1);
                            bdVar.ay(com.tencent.mm.model.bd.iD(rVar.Tj()));
                            rVar.enN = (int) com.tencent.mm.model.bd.i(bdVar);
                            z = o.Ta().a(rVar);
                        }
                    }
                    if (z) {
                        t.nR(sightCaptureResult.leg);
                        return;
                    } else {
                        x.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
                        return;
                    }
                }
            default:
                return;
        }
    }

    public final void cpI() {
        x.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
        o.Ta().a(((com.tencent.mm.ui.chatting.b.b.g) this.bAG.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctQ(), au.Em().lnJ.getLooper());
    }

    public final void cpJ() {
        x.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
        o.Ta().a(((com.tencent.mm.ui.chatting.b.b.g) this.bAG.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctQ());
    }

    public final void cpK() {
        b.Fm();
        this.tTc.clear();
    }
}
