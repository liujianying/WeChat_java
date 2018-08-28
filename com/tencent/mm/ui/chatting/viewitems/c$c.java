package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.Iterator;

final class c$c extends a {
    public static int[] jfV = new int[]{R.h.chatting_note_thumb_iv_0, R.h.chatting_note_thumb_iv_1, R.h.chatting_note_thumb_iv_2, R.h.chatting_note_thumb_iv_3, R.h.chatting_note_thumb_iv_4};
    protected TextView eCm;
    protected TextView eCn;
    protected TextView jet;
    private ArrayList<MMImageView> nPW = new ArrayList();
    protected MMImageView tZI;
    protected ImageView tZJ;
    protected ImageView tZK;
    protected TextView tZL;
    protected LinearLayout tZM;
    protected TextView tZN;
    protected ImageView tZO;
    protected MMPinProgressBtn tZP;
    protected ImageView tZQ;
    protected ImageView tZR;
    protected ImageView tZS;
    protected ImageView tZT;
    protected TextView tZU;
    protected ChattingItemFooter tZV;
    protected ImageView tZW;
    protected LinearLayout tZX;
    protected ViewGroup tZY;
    protected TextView tZZ;
    protected LinearLayout uaa;
    protected RelativeLayout uab;
    protected FrameLayout uac;
    protected LinearLayout uad;
    protected LinearLayout uae;
    protected ViewStub uaf;
    protected ImageView uag;
    protected ImageView uah;
    ImageView uai;
    protected LinearLayout uaj;
    protected ImageView uak;
    protected TextView ual;
    protected TextView uam;
    protected ImageView uan;
    protected TextView uao;
    protected TextView uap;
    protected LinearLayout uaq;
    protected ImageView uar;
    protected ImageView uas;
    protected TextView uat;
    public int uau = 0;
    private int uav = Integer.MAX_VALUE;

    c$c() {
    }

    public final c$c p(View view, boolean z) {
        super.dx(view);
        this.tZI = (MMImageView) view.findViewById(R.h.chatting_appmsg_thumb_iv);
        this.eCm = (TextView) view.findViewById(R.h.chatting_appmsg_title_tv);
        this.tZN = (TextView) view.findViewById(R.h.chatting_appmsg_top_title_tv);
        this.eCn = (TextView) view.findViewById(R.h.chatting_appmsg_desc_tv);
        this.jet = (TextView) view.findViewById(R.h.chatting_appmsg_source_tv);
        this.tZJ = (ImageView) view.findViewById(R.h.chatting_appmsg_source_iv);
        this.tZL = (TextView) view.findViewById(R.h.chatting_appmsg_source_tag_tv);
        this.tZK = (ImageView) view.findViewById(R.h.chatting_appmsg_source_tag_iv);
        this.tZM = (LinearLayout) view.findViewById(R.h.chatting_appmsg_source_area);
        this.tZO = (ImageView) view.findViewById(R.h.chatting_appmsg_sub_menu_icon);
        this.tZP = (MMPinProgressBtn) view.findViewById(R.h.chatting_file_progress);
        this.tZQ = (ImageView) this.jEz.findViewById(R.h.chatting_file_mask);
        this.tZR = (ImageView) this.jEz.findViewById(R.h.chatting_continue_btn);
        this.tZS = (ImageView) this.jEz.findViewById(R.h.chatting_stop_btn);
        this.tZT = (ImageView) view.findViewById(R.h.chatting_appmsg_media_icon);
        this.tZU = (TextView) view.findViewById(R.h.chatting_appmsg_comment_tv);
        this.tZW = (ImageView) view.findViewById(R.h.chatting_appmsg_refuse_iv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        this.tZV = (ChattingItemFooter) view.findViewById(R.h.footer);
        this.tZX = (LinearLayout) view.findViewById(R.h.app_msg_layout);
        this.tZY = (ViewGroup) view.findViewById(R.h.location_share_layout);
        this.tZZ = (TextView) view.findViewById(R.h.location_share_content);
        this.uaa = (LinearLayout) view.findViewById(R.h.chatting_area);
        this.uac = (FrameLayout) view.findViewById(R.h.chatting_click_area);
        this.uad = (LinearLayout) view.findViewById(R.h.chatting_appmsg_content);
        this.uah = (ImageView) view.findViewById(R.h.chatting_content_mask_iv);
        this.uab = (RelativeLayout) view.findViewById(R.h.chatting_appmsg_thumb_area);
        this.uaf = (ViewStub) view.findViewById(R.h.note_image_ll);
        this.uag = (ImageView) view.findViewById(R.h.chatting_dividing_line);
        if (!z) {
            this.uai = (ImageView) this.jEz.findViewById(R.h.chatting_status_tick);
            this.mgA = (ProgressBar) this.jEz.findViewById(R.h.uploading_pb);
        }
        this.uaq = (LinearLayout) view.findViewById(R.h.chatting_appmsg_appbrand_content);
        this.uar = (ImageView) view.findViewById(R.h.chatting_appmsg_appbrand_cover_iv);
        this.uas = (ImageView) view.findViewById(R.h.error_icon_iv);
        this.uat = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_nickname_tv);
        this.uaj = (LinearLayout) view.findViewById(R.h.chatting_appmsg_appbrand_card_content);
        this.uak = (ImageView) view.findViewById(R.h.chatting_appbrand_card_avatar_iv);
        this.ual = (TextView) view.findViewById(R.h.chatting_appbrand_card_nickname_tv);
        this.uam = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_desc_tv);
        this.uan = (ImageView) view.findViewById(R.h.chatting_appmsg_appbrand_source_iv);
        this.uao = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_source_tv);
        this.uap = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_source_tag_tv);
        if (this.tZN != null && VERSION.SDK_INT >= 16) {
            this.uav = this.tZN.getMaxLines();
        }
        this.uau = b.gO(ad.getContext());
        return this;
    }

    public final void reset() {
        if (this.tZN != null) {
            this.tZN.setMaxLines(this.uav);
        }
    }

    public static void a(c$c c_c, String str, int i) {
        int SY = l.SY(str);
        if (SY == -1 || SY >= 100 || i <= 0) {
            c_c.tZP.setVisibility(8);
            c_c.tZQ.setVisibility(8);
            return;
        }
        c_c.tZP.setVisibility(0);
        c_c.tZQ.setVisibility(0);
        c_c.tZP.setProgress(SY);
    }

    public static void a(c$c c_c, Boolean bool, bd bdVar, String str, String str2) {
        long j = bdVar.field_msgId;
        b fH = ao.asF().fH(j);
        if (fH == null) {
            x.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[]{Long.valueOf(j), str2});
            return;
        }
        if (bool.booleanValue()) {
            if (fH.field_status == 101) {
                c_c.tZS.setVisibility(0);
                c_c.tZP.setVisibility(0);
                c_c.tZQ.setVisibility(0);
            } else if (fH.field_status == 102) {
                c_c.tZS.setVisibility(8);
                c_c.tZP.setVisibility(8);
                c_c.tZQ.setVisibility(8);
            } else {
                c_c.tZS.setVisibility(8);
                c_c.tZP.setVisibility(8);
                c_c.tZQ.setVisibility(8);
            }
        } else if (fH.field_status == 101) {
            c_c.tZS.setVisibility(0);
            c_c.tZR.setVisibility(8);
        } else if (fH.field_status == 105) {
            c_c.tZS.setVisibility(8);
            c_c.tZR.setVisibility(0);
        } else {
            c_c.tZS.setVisibility(8);
            c_c.tZR.setVisibility(8);
        }
        if (bdVar.field_status == 5) {
            c_c.tZS.setVisibility(8);
            c_c.tZR.setVisibility(8);
        }
        c_c.tZS.setOnClickListener(new 1(bool, j, str, str2, bdVar));
        c_c.tZR.setOnClickListener(new 2(bool, j, str2, bdVar));
    }

    static void a(com.tencent.mm.ui.chatting.c.a aVar, c$c c_c, g.a aVar2, boolean z) {
        String str;
        CharSequence charSequence;
        c_c.eCm.setVisibility(8);
        if (aVar2.title == null || aVar2.title.trim().length() <= 0) {
            c_c.tZN.setVisibility(8);
            str = null;
        } else {
            str = aVar2.title;
            c_c.tZN.setVisibility(0);
            c_c.tZN.setMaxLines(2);
        }
        c_c.eCn.setMaxLines(4);
        c_c.tZT.setVisibility(8);
        c_c.tZO.setVisibility(4);
        if (z) {
            c_c.tZI.setVisibility(8);
        }
        mw mwVar = new mw();
        mwVar.bXL.type = 0;
        mwVar.bXL.bXN = aVar2.dwW;
        com.tencent.mm.sdk.b.a.sFg.m(mwVar);
        c cVar = mwVar.bXM.bXV;
        if (cVar != null) {
            c_c.tZN.setText(j.a(c_c.tZN.getContext(), bi.aG(cVar.title, aVar2.title), c_c.tZN.getTextSize()));
            String str2 = cVar.desc;
            if (str2 == null) {
                x.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[]{aVar2.dwW});
            } else {
                str2 = str2.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            if (str2 != null && str2.length() > 100) {
                str2 = str2.substring(0, 100);
            }
            c_c.eCn.setText(j.a(c_c.eCn.getContext(), bi.aG(str2, aVar2.description), c_c.eCn.getTextSize()));
            Iterator it = cVar.dzs.iterator();
            int i = 0;
            Object obj = null;
            String str3 = null;
            charSequence = str;
            while (it.hasNext()) {
                vx vxVar = (vx) it.next();
                if (bi.oW(vxVar.rzD) || !vxVar.rzD.equals(".htm") || bi.oW(vxVar.rAq) || !vxVar.rAq.equals("WeNoteHtmlFile")) {
                    int i2;
                    if (vxVar.rAi.rAJ.rBh != null) {
                        i2 = 1;
                        charSequence = aVar.tTq.getContext().getString(R.l.record_chatroom_title);
                    } else {
                        if (vxVar.rAi.rAJ.bSS != null) {
                            if (str3 == null) {
                                str3 = vxVar.rAk;
                                i2 = i;
                            } else if (str3 != vxVar.rAk) {
                                obj = vxVar.rAk;
                                i2 = i;
                            }
                        }
                        i2 = i;
                    }
                    switch (vxVar.bjS) {
                        case 1:
                            i = i2;
                            continue;
                        case 2:
                            if (z) {
                                c_c.tZI.setVisibility(0);
                                c_c.tZI.setImageResource(R.g.app_attach_file_icon_pic);
                            }
                            i = i2;
                            continue;
                        case 3:
                            if (z) {
                                c_c.tZI.setVisibility(0);
                                c_c.tZI.setImageResource(R.k.app_attach_file_icon_voice);
                            }
                            i = i2;
                            continue;
                        case 4:
                            if (z) {
                                c_c.tZI.setVisibility(0);
                                c_c.tZI.setImageResource(R.k.app_attach_file_icon_video);
                            }
                            c_c.tZT.setVisibility(0);
                            c_c.tZT.setImageResource(R.g.video_download_btn);
                            i = i2;
                            continue;
                        case 5:
                            if (z) {
                                c_c.tZI.setVisibility(0);
                                c_c.tZI.setImageResource(R.k.app_attach_file_icon_webpage);
                            }
                            i = i2;
                            continue;
                        case 6:
                            c_c.tZI.setVisibility(0);
                            c_c.tZI.setImageResource(R.k.app_attach_file_icon_location);
                            i = i2;
                            continue;
                        case 7:
                            if (z) {
                                c_c.tZI.setVisibility(0);
                                c_c.tZI.setImageResource(R.k.app_attach_file_icon_music);
                            }
                            c_c.tZT.setVisibility(0);
                            c_c.tZT.setImageResource(R.g.music_playicon);
                            i = i2;
                            continue;
                        case 8:
                            if (z) {
                                c_c.tZI.setVisibility(0);
                                c_c.tZI.setImageResource(com.tencent.mm.pluginsdk.c.Sz(vxVar.rzD));
                            }
                            i = i2;
                            continue;
                        case 10:
                        case 11:
                        case 14:
                            if (z) {
                                c_c.tZI.setVisibility(0);
                                c_c.tZI.setImageResource(R.k.app_attach_file_icon_unknow);
                            }
                            i = i2;
                            continue;
                        case 16:
                            if (z) {
                                c_c.tZI.setVisibility(0);
                                c_c.tZI.setImageResource(R.g.default_avatar);
                                break;
                            }
                            break;
                    }
                    i = i2;
                }
            }
            if (str3 != null && obj == null && i == 0) {
                charSequence = aVar.tTq.getContext().getString(R.l.favorite_record_chatroom_title, new Object[]{str3});
            } else if (!(str3 == null || obj == null || str3.equals(obj) || i != 0)) {
                charSequence = aVar.tTq.getContext().getString(R.l.favorite_record_chat_title, new Object[]{str3, obj});
            }
        } else {
            Object obj2 = str;
        }
        if (!bi.oW(charSequence)) {
            c_c.tZN.setText(charSequence);
        }
        c_c.tZI.setVisibility(8);
        c_c.uab.setVisibility(8);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(com.tencent.mm.ui.chatting.c.a r21, com.tencent.mm.ui.chatting.viewitems.c$c r22, com.tencent.mm.y.g.a r23, com.tencent.mm.storage.bd r24, boolean r25) {
        /*
        r2 = new com.tencent.mm.g.a.mw;
        r2.<init>();
        r3 = r2.bXL;
        r4 = 0;
        r3.type = r4;
        r3 = r2.bXL;
        r0 = r23;
        r4 = r0.dwW;
        r3.bXN = r4;
        r3 = com.tencent.mm.sdk.b.a.sFg;
        r3.m(r2);
        r2 = r2.bXM;
        r15 = r2.bXV;
        r0 = r22;
        r2 = r0.uab;
        r3 = 8;
        r2.setVisibility(r3);
        r2 = 4;
        r7 = new java.lang.String[r2];
        r2 = 4;
        r6 = new java.lang.String[r2];
        r2 = 4;
        r8 = new int[r2];
        r2 = 4;
        r10 = new java.lang.String[r2];
        r2 = 4;
        r9 = new java.lang.String[r2];
        r2 = 4;
        r11 = new int[r2];
        r2 = 4;
        r5 = new java.lang.String[r2];
        if (r15 == 0) goto L_0x02d7;
    L_0x003b:
        r3 = 0;
        r2 = r15.desc;
        r0 = r23;
        r4 = r0.description;
        r12 = com.tencent.mm.sdk.platformtools.bi.aG(r2, r4);
        r4 = 0;
        r2 = 0;
        r13 = r15.dzs;
        r14 = r13.iterator();
        r13 = r2;
    L_0x004f:
        r2 = r14.hasNext();
        if (r2 == 0) goto L_0x0158;
    L_0x0055:
        r2 = r14.next();
        r2 = (com.tencent.mm.protocal.c.vx) r2;
        r0 = r2.rzD;
        r16 = r0;
        r16 = com.tencent.mm.sdk.platformtools.bi.oW(r16);
        if (r16 != 0) goto L_0x0089;
    L_0x0065:
        r0 = r2.rzD;
        r16 = r0;
        r17 = ".htm";
        r16 = r16.equals(r17);
        if (r16 == 0) goto L_0x0089;
    L_0x0072:
        r0 = r2.rAq;
        r16 = r0;
        r16 = com.tencent.mm.sdk.platformtools.bi.oW(r16);
        if (r16 != 0) goto L_0x0089;
    L_0x007c:
        r0 = r2.rAq;
        r16 = r0;
        r17 = "WeNoteHtmlFile";
        r16 = r16.equals(r17);
        if (r16 != 0) goto L_0x004f;
    L_0x0089:
        r0 = r2.bjS;
        r16 = r0;
        switch(r16) {
            case 1: goto L_0x0093;
            case 2: goto L_0x00d0;
            case 3: goto L_0x004f;
            case 4: goto L_0x0090;
            case 5: goto L_0x0090;
            case 6: goto L_0x004f;
            case 7: goto L_0x0090;
            case 8: goto L_0x0130;
            default: goto L_0x0090;
        };
    L_0x0090:
        r2 = r12;
    L_0x0091:
        r12 = r2;
        goto L_0x004f;
    L_0x0093:
        if (r4 != 0) goto L_0x0090;
    L_0x0095:
        r0 = r2.desc;
        r16 = r0;
        r17 = com.tencent.mm.sdk.platformtools.bi.oW(r16);
        if (r17 != 0) goto L_0x0090;
    L_0x009f:
        r4 = "\n";
        r17 = "";
        r0 = r16;
        r1 = r17;
        r4 = r0.replaceAll(r4, r1);
        r4 = r4.trim();
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x0392;
    L_0x00b7:
        r2 = r2.desc;
        r3 = "&lt;";
        r4 = "<";
        r2 = r2.replaceAll(r3, r4);
        r3 = "&gt;";
        r4 = ">";
        r2 = r2.replaceAll(r3, r4);
    L_0x00cd:
        r4 = 1;
        r3 = r2;
        goto L_0x004f;
    L_0x00d0:
        if (r25 == 0) goto L_0x00f3;
    L_0x00d2:
        r0 = r22;
        r0 = r0.uab;
        r16 = r0;
        r17 = 0;
        r16.setVisibility(r17);
        r0 = r22;
        r0 = r0.tZI;
        r16 = r0;
        r17 = 0;
        r16.setVisibility(r17);
        r0 = r22;
        r0 = r0.tZI;
        r16 = r0;
        r17 = com.tencent.mm.R.g.app_attach_file_icon_pic;
        r16.setImageResource(r17);
    L_0x00f3:
        r16 = 4;
        r0 = r16;
        if (r13 >= r0) goto L_0x012b;
    L_0x00f9:
        r0 = r2.dwE;
        r16 = r0;
        r7[r13] = r16;
        r0 = r2.rzk;
        r16 = r0;
        r6[r13] = r16;
        r0 = r2.rzU;
        r16 = r0;
        r0 = r16;
        r0 = (int) r0;
        r16 = r0;
        r8[r13] = r16;
        r0 = r2.rzo;
        r16 = r0;
        r10[r13] = r16;
        r0 = r2.rzq;
        r16 = r0;
        r9[r13] = r16;
        r0 = r2.rzJ;
        r16 = r0;
        r0 = r16;
        r0 = (int) r0;
        r16 = r0;
        r11[r13] = r16;
        r2 = r2.jdM;
        r5[r13] = r2;
    L_0x012b:
        r2 = r13 + 1;
        r13 = r2;
        goto L_0x004f;
    L_0x0130:
        r16 = com.tencent.mm.sdk.platformtools.bi.oW(r12);
        if (r16 == 0) goto L_0x0090;
    L_0x0136:
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r16 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r17 = com.tencent.mm.R.l.app_file;
        r16 = r16.getString(r17);
        r0 = r16;
        r12 = r12.append(r0);
        r2 = r2.title;
        r2 = r12.append(r2);
        r12 = r2.toString();
        r2 = r12;
        goto L_0x0091;
    L_0x0158:
        r2 = 0;
        if (r3 == 0) goto L_0x0340;
    L_0x015b:
        r14 = "\n";
        r16 = 2;
        r0 = r16;
        r16 = r3.split(r14, r0);
        r17 = new java.util.ArrayList;
        r17.<init>();
        r0 = r16;
        r14 = r0.length;
        if (r14 <= 0) goto L_0x018c;
    L_0x0170:
        r0 = r16;
        r0 = r0.length;
        r18 = r0;
        r14 = 0;
    L_0x0176:
        r0 = r18;
        if (r14 >= r0) goto L_0x018c;
    L_0x017a:
        r19 = r16[r14];
        r20 = r19.length();
        if (r20 <= 0) goto L_0x0189;
    L_0x0182:
        r0 = r17;
        r1 = r19;
        r0.add(r1);
    L_0x0189:
        r14 = r14 + 1;
        goto L_0x0176;
    L_0x018c:
        r14 = r17.size();
        r16 = 1;
        r0 = r16;
        if (r14 != r0) goto L_0x038f;
    L_0x0196:
        r2 = 1;
        r14 = r2;
    L_0x0198:
        r2 = r17.size();
        r16 = 1;
        r0 = r16;
        if (r2 != r0) goto L_0x02d8;
    L_0x01a2:
        r2 = r15.dzs;
        r2 = r2.size();
        r15 = 2;
        if (r2 != r15) goto L_0x02d8;
    L_0x01ab:
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r12 = com.tencent.mm.R.l.favorite_wenote;
        r2 = r2.getString(r12);
    L_0x01b5:
        r15 = r2.trim();
    L_0x01b9:
        if (r15 == 0) goto L_0x038c;
    L_0x01bb:
        r2 = "&lt;";
        r12 = "<";
        r2 = r15.replaceAll(r2, r12);
        r12 = "&gt;";
        r15 = ">";
        r2 = r2.replaceAll(r12, r15);
    L_0x01cf:
        r0 = r22;
        r12 = r0.tZN;
        r12 = r12.getContext();
        r0 = r22;
        r15 = r0.tZN;
        r15 = r15.getTextSize();
        r15 = (int) r15;
        r2 = com.tencent.mm.pluginsdk.ui.d.j.a(r12, r2, r15);
        r0 = r22;
        r12 = r0.tZN;
        r12.setText(r2);
        if (r3 == 0) goto L_0x0389;
    L_0x01ed:
        r2 = r3.length();
        r12 = 100;
        if (r2 <= r12) goto L_0x0389;
    L_0x01f5:
        r2 = 0;
        r12 = 100;
        r2 = r3.substring(r2, r12);
        r3 = "&lt;";
        r12 = "<";
        r2 = r2.replaceAll(r3, r12);
        r3 = "&gt;";
        r12 = ">";
        r2 = r2.replaceAll(r3, r12);
    L_0x0210:
        r0 = r22;
        r3 = r0.eCn;
        r3 = r3.getContext();
        r0 = r22;
        r12 = r0.eCn;
        r12 = r12.getTextSize();
        r12 = (int) r12;
        r3 = com.tencent.mm.pluginsdk.ui.d.j.a(r3, r2, r12);
        r0 = r22;
        r12 = r0.eCn;
        r12.setText(r3);
        if (r13 <= 0) goto L_0x0376;
    L_0x022e:
        r0 = r22;
        r3 = r0.uab;
        r12 = 8;
        r3.setVisibility(r12);
        if (r14 != 0) goto L_0x0241;
    L_0x0239:
        if (r4 == 0) goto L_0x0241;
    L_0x023b:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 == 0) goto L_0x034e;
    L_0x0241:
        r0 = r22;
        r2 = r0.eCn;
        r3 = 8;
        r2.setVisibility(r3);
        r0 = r22;
        r2 = r0.tZN;
        r3 = 2;
        r2.setMaxLines(r3);
    L_0x0252:
        r0 = r22;
        r2 = r0.uag;
        r3 = 8;
        r2.setVisibility(r3);
        r0 = r22;
        r2 = r0.uaf;
        r3 = com.tencent.mm.R.i.chatting_item_note_image_multi;
        r2.setLayoutResource(r3);
        r0 = r22;
        r2 = r0.uaf;	 Catch:{ Exception -> 0x0368 }
        r2 = r2.inflate();	 Catch:{ Exception -> 0x0368 }
        r2 = (android.widget.LinearLayout) r2;	 Catch:{ Exception -> 0x0368 }
        r0 = r22;
        r0.uae = r2;	 Catch:{ Exception -> 0x0368 }
    L_0x0272:
        r2 = 4;
        if (r13 <= r2) goto L_0x0373;
    L_0x0275:
        r4 = 4;
    L_0x0276:
        r0 = r24;
        r12 = r0.field_talker;
        r2 = r21;
        r3 = r22;
        a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        r0 = r22;
        r2 = r0.uae;
        r3 = com.tencent.mm.R.h.chatting_note_thumb_mask;
        r2 = r2.findViewById(r3);
        r2 = (android.widget.ImageView) r2;
        r0 = r22;
        r3 = r0.uae;
        r4 = com.tencent.mm.R.h.chatting_note_thumb_exceed_num;
        r3 = r3.findViewById(r4);
        r3 = (android.widget.TextView) r3;
        if (r3 == 0) goto L_0x02ae;
    L_0x029b:
        r4 = 0;
        r5 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = r5.getResources();
        r6 = com.tencent.mm.R.f.SmallPadding;
        r5 = r5.getDimensionPixelSize(r6);
        r5 = (float) r5;
        r3.setTextSize(r4, r5);
    L_0x02ae:
        r4 = 4;
        if (r13 <= r4) goto L_0x02d7;
    L_0x02b1:
        if (r2 == 0) goto L_0x02b7;
    L_0x02b3:
        r4 = 0;
        r2.setVisibility(r4);
    L_0x02b7:
        if (r3 == 0) goto L_0x02d7;
    L_0x02b9:
        r2 = new java.lang.StringBuilder;
        r4 = "(";
        r2.<init>(r4);
        r2 = r2.append(r13);
        r4 = ")";
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.setText(r2);
        r2 = 0;
        r3.setVisibility(r2);
    L_0x02d7:
        return;
    L_0x02d8:
        if (r13 <= 0) goto L_0x02f8;
    L_0x02da:
        r2 = 0;
        r0 = r17;
        r2 = r0.get(r2);
        r2 = (java.lang.String) r2;
        r3 = r17.size();
        r12 = 1;
        if (r3 <= r12) goto L_0x02f5;
    L_0x02ea:
        r3 = 1;
        r0 = r17;
        r3 = r0.get(r3);
        r3 = (java.lang.String) r3;
        goto L_0x01b5;
    L_0x02f5:
        r3 = 0;
        goto L_0x01b5;
    L_0x02f8:
        r2 = 0;
        r0 = r17;
        r2 = r0.get(r2);
        r2 = (java.lang.String) r2;
        r3 = java.util.regex.Pattern.quote(r2);
        r15 = 2;
        r12 = r12.split(r3, r15);
        r3 = 0;
        r3 = r12[r3];
        r3 = r3.trim();
        r15 = r12.length;
        r16 = 1;
        r0 = r16;
        if (r15 <= r0) goto L_0x01b5;
    L_0x0318:
        r3 = new java.lang.StringBuilder;
        r15 = 0;
        r15 = r12[r15];
        r15 = r15.trim();
        r3.<init>(r15);
        r15 = "\n";
        r3 = r3.append(r15);
        r15 = 1;
        r12 = r12[r15];
        r12 = r12.trim();
        r3 = r3.append(r12);
        r3 = r3.toString();
        r3 = r3.trim();
        goto L_0x01b5;
    L_0x0340:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r14 = com.tencent.mm.R.l.favorite_wenote;
        r15 = r3.getString(r14);
        r14 = r2;
        r3 = r12;
        goto L_0x01b9;
    L_0x034e:
        r0 = r22;
        r2 = r0.eCn;
        r3 = 1;
        r2.setMaxLines(r3);
        r0 = r22;
        r2 = r0.eCn;
        r3 = 0;
        r2.setVisibility(r3);
        r0 = r22;
        r2 = r0.tZN;
        r3 = 1;
        r2.setMaxLines(r3);
        goto L_0x0252;
    L_0x0368:
        r2 = move-exception;
        r0 = r22;
        r2 = r0.uaf;
        r3 = 0;
        r2.setVisibility(r3);
        goto L_0x0272;
    L_0x0373:
        r4 = r13;
        goto L_0x0276;
    L_0x0376:
        r0 = r22;
        r2 = r0.uaf;
        r3 = 8;
        r2.setVisibility(r3);
        r0 = r22;
        r2 = r0.uag;
        r3 = 0;
        r2.setVisibility(r3);
        goto L_0x02d7;
    L_0x0389:
        r2 = r3;
        goto L_0x0210;
    L_0x038c:
        r2 = r15;
        goto L_0x01cf;
    L_0x038f:
        r14 = r2;
        goto L_0x0198;
    L_0x0392:
        r2 = r3;
        goto L_0x00cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c$c.a(com.tencent.mm.ui.chatting.c.a, com.tencent.mm.ui.chatting.viewitems.c$c, com.tencent.mm.y.g$a, com.tencent.mm.storage.bd, boolean):void");
    }

    private static void a(com.tencent.mm.ui.chatting.c.a aVar, c$c c_c, int i, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr, String[] strArr4, String[] strArr5, int[] iArr2, String str) {
        MMImageView mMImageView;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 > 4) {
                break;
            }
            mMImageView = (MMImageView) c_c.uae.findViewById(jfV[i3]);
            if (mMImageView != null) {
                mMImageView.setImageDrawable(null);
                mMImageView.setVisibility(8);
            }
            i2 = i3 + 1;
        }
        ImageView imageView = (ImageView) c_c.uae.findViewById(R.h.chatting_note_thumb_mask);
        TextView textView = (TextView) c_c.uae.findViewById(R.h.chatting_note_thumb_exceed_num);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
        i2 = 0;
        while (true) {
            int i4 = i2;
            if (i4 < i) {
                MMImageView mMImageView2;
                if (i == 1) {
                    mMImageView = (MMImageView) c_c.uae.findViewById(jfV[i4]);
                    mMImageView.setImageResource(R.k.chatting_note_default_img_one);
                    mMImageView2 = mMImageView;
                } else {
                    mMImageView = (MMImageView) c_c.uae.findViewById(jfV[i4 + 1]);
                    mMImageView.setImageResource(R.k.chatting_note_default_img);
                    mMImageView2 = mMImageView;
                }
                mMImageView2.setVisibility(0);
                ao.cbX().a((com.tencent.mm.pluginsdk.model.app.j.a) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class), strArr[i4], bi.VF(), strArr2[i4], strArr3[i4], iArr[i4], str);
                String o = o.Pf().o("Note_" + strArr[i4], "", "");
                Bitmap a;
                if (FileOp.cn(o)) {
                    a = o.Pf().a(o, true, com.tencent.mm.bp.a.getDensity(ad.getContext()), false, true, false, 0, false);
                    if (a == null || a.isRecycled()) {
                        mMImageView2.setImageResource(R.k.chatting_note_default_img);
                    } else {
                        mMImageView2.setImageBitmap(a);
                    }
                } else {
                    ao.cbX().a((com.tencent.mm.pluginsdk.model.app.j.a) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class), strArr[i4], bi.VF(), strArr4[i4], strArr5[i4], iArr2[i4], str);
                    o.Pf().o("Note_" + strArr[i4], "", "");
                    com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), 45);
                    if (FileOp.cn(o)) {
                        a = o.Pf().b(o, com.tencent.mm.bp.a.getDensity(ad.getContext()), false);
                        if (a == null || a.isRecycled()) {
                            mMImageView2.setImageResource(R.k.chatting_note_default_img);
                        } else {
                            mMImageView2.setImageBitmap(a);
                        }
                    } else {
                        x.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
                    }
                }
                i2 = i4 + 1;
            } else {
                return;
            }
        }
    }
}
