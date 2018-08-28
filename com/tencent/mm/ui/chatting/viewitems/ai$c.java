package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class ai$c extends d {
    public static boolean tWC = false;

    public ai$c(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        b.ehL.z(auVar.bXQ);
        ai$e ai_e = (ai$e) auVar;
        com.tencent.mm.modelstat.a.a(ai_e.bXQ, com.tencent.mm.modelstat.a.a.ehI);
        int i;
        if (2 != ai_e.hER) {
            bd bdVar2 = ai_e.bXQ;
            if (bdVar2.field_isSend == 0) {
                bd bdVar3 = ai_e.bXQ;
                r nW = t.nW(bdVar3.field_imgPath);
                x.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + nW.status + " is sender:" + bdVar3.field_isSend);
                switch (ai_e.hER) {
                    case 3:
                        h(nW);
                        break;
                    case 4:
                        au.HU();
                        if (!c.isSDCardAvailable()) {
                            s.gH(this.tKy.tTq.getContext());
                            break;
                        } else {
                            t.nT(bdVar3.field_imgPath);
                            break;
                        }
                }
            }
            if (bdVar2.field_isSend == 1) {
                bdVar2 = ai_e.bXQ;
                if (bdVar2 == null) {
                    x.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
                    return;
                }
                r nI = o.Ta().nI(bdVar2.field_imgPath);
                if (nI == null) {
                    x.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[]{bdVar2.field_imgPath});
                    return;
                }
                i = nI.status;
                x.i("MicroMsg.DesignerClickListener", " videoSendEvent status : " + i);
                String string;
                switch (ai_e.hER) {
                    case 3:
                        au.HU();
                        if (!c.isSDCardAvailable()) {
                            s.gH(this.tKy.tTq.getContext());
                            return;
                        } else if (i == TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH) {
                            x.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
                            h(nI);
                            return;
                        } else if (nI.Tn()) {
                            x.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
                            string = this.tKy.tTq.getContext().getString(R.l.video_export_file_error);
                            if (i == 142) {
                                string = this.tKy.tTq.getContext().getString(R.l.video_export_file_error);
                            } else if (i == 141) {
                                string = this.tKy.tTq.getContext().getString(R.l.video_export_file_too_big);
                            } else if (i == 140) {
                                string = this.tKy.tTq.getContext().getString(R.l.video_export_duration_too_long);
                            }
                            h.b(this.tKy.tTq.getContext(), string, this.tKy.tTq.getContext().getString(R.l.tip_title), true);
                            return;
                        } else {
                            bdVar2.cmw();
                            au.HU();
                            c.FT().a(bdVar2.field_msgId, bdVar2);
                            if (nI.status == 198) {
                                t.nV(bdVar2.field_imgPath);
                                return;
                            } else {
                                t.nR(bdVar2.field_imgPath);
                                return;
                            }
                        }
                    case 4:
                        au.HU();
                        if (!c.isSDCardAvailable()) {
                            s.gH(this.tKy.tTq.getContext());
                            return;
                        } else if (i == TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW) {
                            x.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
                            t.nT(bdVar2.field_imgPath);
                            return;
                        } else {
                            string = bdVar2.field_imgPath;
                            nI = t.nW(string);
                            if (nI == null) {
                                x.e("MicroMsg.VideoLogic", "ERR:" + g.Ac() + " getinfo failed: " + string);
                                g.getLine();
                            } else if (nI.status == 104 || nI.status == 103) {
                                nI.status = 105;
                                nI.enK = bi.VE();
                                nI.bWA = 1280;
                                if (!t.e(nI)) {
                                    x.e("MicroMsg.VideoLogic", "ERR:" + g.Ac() + " update failed: " + string);
                                    g.getLine();
                                }
                            } else {
                                x.e("MicroMsg.VideoLogic", "ERR:" + g.Ac() + " get status failed: " + string + " status:" + nI.status);
                                g.getLine();
                            }
                            x.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
                            ox oxVar = new ox();
                            oxVar.bZS.bGS = bdVar2;
                            com.tencent.mm.sdk.b.a.sFg.m(oxVar);
                            return;
                        }
                    default:
                        return;
                }
            }
        } else if (com.tencent.mm.p.a.by(this.tKy.tTq.getContext()) || com.tencent.mm.p.a.bw(this.tKy.tTq.getContext())) {
            x.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        } else {
            int height;
            String str;
            Bundle bundle;
            bd bdVar4 = ai_e.bXQ;
            int[] iArr = new int[2];
            i = 0;
            if (view != null) {
                view.getLocationInWindow(iArr);
                i = view.getWidth();
                height = view.getHeight();
            } else {
                height = 0;
            }
            long j = bdVar4.field_msgId;
            long j2 = bdVar4.field_msgSvrId;
            String str2 = ai_e.userName;
            String str3 = ai_e.chatroomName;
            Intent intent = new Intent(this.tKy.tTq.getContext(), ImageGalleryUI.class);
            intent.putExtra("show_search_chat_content_result", ((w) this.tKy.O(w.class)).cvQ());
            intent.putExtra("img_gallery_msg_id", j);
            intent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.b.b.c) this.tKy.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur());
            intent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.b.b.c) this.tKy.O(com.tencent.mm.ui.chatting.b.b.c.class)).cuC());
            intent.putExtra("img_gallery_msg_svr_id", j2);
            intent.putExtra("img_gallery_talker", str2);
            intent.putExtra("img_gallery_chatroom_name", str3);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i);
            intent.putExtra("img_gallery_height", height);
            intent.putExtra("img_gallery_enter_from_chatting_ui", ((w) this.tKy.O(w.class)).cvL());
            str3 = this.tKy.getTalkerUserName();
            String cwp = bdVar4.field_isSend == 1 ? this.tKy.cwp() : str2;
            Bundle bundle2 = new Bundle();
            if (this.tKy.cwr()) {
                str = "stat_scene";
                height = 2;
                bundle = bundle2;
            } else {
                str = "stat_scene";
                if (com.tencent.mm.model.s.hf(str3)) {
                    height = 7;
                    bundle = bundle2;
                } else {
                    height = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str, height);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
            bundle2.putString("stat_chat_talker_username", str3);
            bundle2.putString("stat_send_msg_user", cwp);
            intent.putExtra("_stat_obj", bundle2);
            this.tKy.startActivity(intent);
            this.tKy.tTq.overridePendingTransition(0, 0);
            if (bdVar4.cmk() && ai_e.userName != null) {
                com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.tFH, bdVar4);
                if (ai_e.userName.toLowerCase().endsWith("@chatroom")) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11444, new Object[]{Integer.valueOf(2)});
                } else {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11444, new Object[]{Integer.valueOf(1)});
                }
            }
        }
    }

    private void h(r rVar) {
        au.HU();
        if (!c.isSDCardAvailable()) {
            s.gH(this.tKy.tTq.getContext());
        } else if (rVar.status == 198) {
            t.nU(rVar.getFileName());
        } else if (ab.bU(this.tKy.tTq.getContext()) || tWC) {
            t.nS(rVar.getFileName());
        } else {
            tWC = true;
            h.a(this.tKy.tTq.getContext(), R.l.video_export_file_warning, R.l.app_tip, new 1(this, rVar), new 2(this));
        }
    }
}
