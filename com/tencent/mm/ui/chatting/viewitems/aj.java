package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.b.b.ad;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.viewitems.b.a;

public final class aj {

    public static final class c extends a {
        TextView tZU;
        ImageView uai;
        TextView ucQ;
        int ueG;
        TextView ueH;
        TextView ueI;
        AnimImageView ueJ;
        FrameLayout ueK;
        FrameLayout ueL;
        ImageView ueM;
        AnimImageView ueN;
        ProgressBar ueO;
        TextView ueP;
        Animation ueQ;
        ViewStub uef;
        ChattingItemTranslate ueg;

        static /* synthetic */ void c(Context context, CharSequence charSequence) {
            Intent intent = new Intent(context, TextPreviewUI.class);
            intent.putExtra("key_chat_text", charSequence);
            context.startActivity(intent);
            b.gE(context);
        }

        public final a b(View view, boolean z, boolean z2) {
            super.dx(view);
            this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
            this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
            this.ueI = (TextView) view.findViewById(R.h.chatting_voice_play_anim_tv);
            this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
            this.gFD = view.findViewById(R.h.chatting_maskview);
            this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
            this.ucQ = (TextView) view.findViewById(R.h.chatting_content_itv);
            this.ueK = (FrameLayout) view.findViewById(R.h.chatting_voice_play_content);
            this.uef = (ViewStub) view.findViewById(R.h.translate_item_vs);
            this.ueH = (TextView) view.findViewById(R.h.chatting_voice_forwardflag);
            this.ueJ = (AnimImageView) view.findViewById(R.h.chatting_voice_anim);
            this.ueJ.setType(1);
            if (z) {
                this.ueJ.setFromVoice(true);
                this.ueJ.setFromGroup(z2);
                this.tZU = (TextView) view.findViewById(R.h.chatting_appmsg_comment_tv);
                this.ueN = (AnimImageView) view.findViewById(R.h.chatting_voice_loading);
                this.ueN.setFromVoice(true);
                this.ueN.setFromGroup(z2);
                this.ueN.setType(0);
            } else {
                this.ueL = (FrameLayout) view.findViewById(R.h.chatting_voice_recording);
                this.ueM = (ImageView) view.findViewById(R.h.chatting_voice_recording_hl);
                this.ueO = (ProgressBar) view.findViewById(R.h.chatting_voice_sending);
                this.mgA = (ProgressBar) view.findViewById(R.h.uploading_pb);
                this.ueP = (TextView) view.findViewById(R.h.chatting_voice_sending_bg);
                this.ueJ.setFromVoice(false);
                this.ueJ.setFromGroup(z2);
                this.uai = (ImageView) view.findViewById(R.h.chatting_status_tick);
            }
            return this;
        }

        public static void a(c cVar, bd bdVar, int i, com.tencent.mm.ui.chatting.c.a aVar, boolean z, OnLongClickListener onLongClickListener) {
            if (cVar != null) {
                float f;
                e cuM;
                n nVar = new n(bdVar.field_content);
                float bD = q.bD(nVar.time);
                d cwl = ((ag) aVar.O(ag.class)).cwl();
                if (cwl == null || bdVar.field_msgId != cwl.tHf) {
                    cVar.ueJ.setVisibility(8);
                    cVar.ueJ.bqN();
                } else {
                    cVar.ueJ.setVisibility(0);
                    cVar.ueJ.cre();
                }
                if (bdVar.field_isSend == 0) {
                    if (nVar.time == 0) {
                        bdVar.cmF();
                        a(cVar, 8, 0, true);
                        cVar.ueN.bqN();
                        cVar.ueN.setVisibility(8);
                        cVar.tZv.setVisibility(8);
                        f = 0.0f;
                        cVar.ueG = com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr(0));
                        cVar.ueI.setWidth(cVar.ueG);
                        cVar.ucQ.setText(aVar.tTq.getMMResources().getString(R.l.fmt_time_length, new Object[]{Integer.valueOf(0)}));
                        cVar.ueJ.setWidth(com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr(0)));
                    } else if (nVar.time == -1) {
                        bdVar.cmF();
                        a(cVar, 8, 0, true);
                        cVar.ueN.bqN();
                        cVar.ueN.setVisibility(8);
                        cVar.ueG = 80;
                        cVar.ueI.setWidth(80);
                        cVar.ucQ.setVisibility(8);
                        cVar.ueJ.setWidth(com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr((int) bD)));
                        f = bD;
                    } else {
                        bdVar.cmF();
                        a(cVar, 8, 0, true);
                        cVar.ueN.bqN();
                        cVar.ueN.setVisibility(8);
                        cVar.ucQ.setVisibility(0);
                        cVar.ueG = com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr((int) bD));
                        cVar.ueI.setWidth(cVar.ueG);
                        cVar.ucQ.setText(aVar.tTq.getMMResources().getString(R.l.fmt_time_length, new Object[]{Integer.valueOf((int) bD)}));
                        cVar.ueJ.setWidth(com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr((int) bD)));
                    }
                    if (1 == bdVar.field_isSend) {
                        if (bdVar.field_status == 1) {
                            bdVar.cmF();
                            a(cVar, 0, 8, false);
                            cVar.ueL.setVisibility(8);
                            cVar.cxS();
                            bD = f;
                        } else if (nVar.time == -1) {
                            bdVar.cmF();
                            a(cVar, 8, 0, false);
                            cVar.ueI.setWidth(80);
                            cVar.ueG = 80;
                            cVar.ucQ.setVisibility(8);
                            cVar.ueL.setVisibility(8);
                            cVar.ueJ.setWidth(com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr((int) f)));
                            cVar.cxS();
                            bD = f;
                        } else if (bdVar.field_status == 7) {
                            bdVar.cmF();
                            a(cVar, 8, 8, false);
                            cVar.ucQ.setVisibility(8);
                            cVar.ueL.setVisibility(0);
                            cVar.cxS();
                            if (cVar.ueM != null) {
                                cVar.ueQ = AnimationUtils.loadAnimation(cVar.jEz.getContext(), R.a.voice_recording_animation);
                                cVar.ueM.startAnimation(cVar.ueQ);
                            }
                            bD = f;
                        } else {
                            bdVar.cmF();
                            a(cVar, 8, 0, false);
                            cVar.ueL.setVisibility(8);
                            cVar.ucQ.setVisibility(0);
                            cVar.cxS();
                            if (nVar.time == 0) {
                                f = 0.0f;
                            }
                            cVar.ueG = com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr((int) f));
                            cVar.ueI.setWidth(cVar.ueG);
                            cVar.ucQ.setText(aVar.tTq.getMMResources().getString(R.l.fmt_time_length, new Object[]{Integer.valueOf((int) f)}));
                            cVar.ueJ.setWidth(com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr((int) f)));
                        }
                        cuM = ((com.tencent.mm.ui.chatting.b.b.b) aVar.O(com.tencent.mm.ui.chatting.b.b.b.class)).cuM();
                        if (cuM != null) {
                            cVar.ucQ.setTextColor(cuM.qEW);
                            if (cuM.qEX) {
                                cVar.ucQ.setShadowLayer(2.0f, 1.2f, 1.2f, cuM.qEY);
                            } else {
                                cVar.ucQ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                            }
                            if (cuM.qEZ) {
                                cVar.ucQ.setBackgroundResource(R.g.chatting_voice_second_bg);
                            } else {
                                cVar.ucQ.setBackgroundColor(0);
                            }
                        }
                        cVar.ueI.setTag(new ChattingItemTranslate.a(bdVar, aVar.cwr(), i));
                        cVar.ueI.setOnClickListener(cVar.tZx.d(aVar));
                        cVar.ueI.setOnLongClickListener(onLongClickListener);
                        cVar.ueI.setOnTouchListener(((g) aVar.O(g.class)).ctw());
                        if ((bdVar.cqa & 1) == 1) {
                            cVar.ueH.setVisibility(0);
                            if (bdVar.field_isSend == 0) {
                                cVar.ueJ.setBackgroundResource(R.g.chatfrom_bg_voice_forward);
                            } else {
                                cVar.ueP.setBackgroundResource(R.g.chatto_bg_voice_forward);
                                cVar.ueJ.setBackgroundResource(R.g.chatto_bg_voice_forward);
                            }
                        } else {
                            cVar.ueH.setVisibility(8);
                            if (bdVar.field_isSend == 0) {
                                cVar.ueJ.setBackgroundResource(R.g.chatfrom_bg);
                            } else {
                                cVar.ueP.setBackgroundResource(R.g.chatto_bg);
                                cVar.ueJ.setBackgroundResource(R.g.chatto_bg);
                            }
                        }
                        if (z) {
                            aVar.getTalkerUserName();
                        } else {
                            aVar.cwp();
                        }
                        ((com.tencent.mm.ui.chatting.b.b.e) aVar.O(com.tencent.mm.ui.chatting.b.b.e.class)).gT(aVar.getTalkerUserName());
                        com.tencent.mm.ui.a.a.a.cqX().J(cVar.ueI, (int) bD);
                        cVar.ucQ.setContentDescription(" ");
                    }
                    bD = f;
                    cuM = ((com.tencent.mm.ui.chatting.b.b.b) aVar.O(com.tencent.mm.ui.chatting.b.b.b.class)).cuM();
                    if (cuM != null) {
                        cVar.ucQ.setTextColor(cuM.qEW);
                        if (cuM.qEX) {
                            cVar.ucQ.setShadowLayer(2.0f, 1.2f, 1.2f, cuM.qEY);
                        } else {
                            cVar.ucQ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                        }
                        if (cuM.qEZ) {
                            cVar.ucQ.setBackgroundResource(R.g.chatting_voice_second_bg);
                        } else {
                            cVar.ucQ.setBackgroundColor(0);
                        }
                    }
                    cVar.ueI.setTag(new ChattingItemTranslate.a(bdVar, aVar.cwr(), i));
                    cVar.ueI.setOnClickListener(cVar.tZx.d(aVar));
                    cVar.ueI.setOnLongClickListener(onLongClickListener);
                    cVar.ueI.setOnTouchListener(((g) aVar.O(g.class)).ctw());
                    if ((bdVar.cqa & 1) == 1) {
                        cVar.ueH.setVisibility(8);
                        if (bdVar.field_isSend == 0) {
                            cVar.ueJ.setBackgroundResource(R.g.chatfrom_bg);
                        } else {
                            cVar.ueP.setBackgroundResource(R.g.chatto_bg);
                            cVar.ueJ.setBackgroundResource(R.g.chatto_bg);
                        }
                    } else {
                        cVar.ueH.setVisibility(0);
                        if (bdVar.field_isSend == 0) {
                            cVar.ueJ.setBackgroundResource(R.g.chatfrom_bg_voice_forward);
                        } else {
                            cVar.ueP.setBackgroundResource(R.g.chatto_bg_voice_forward);
                            cVar.ueJ.setBackgroundResource(R.g.chatto_bg_voice_forward);
                        }
                    }
                    if (z) {
                        aVar.cwp();
                    } else {
                        aVar.getTalkerUserName();
                    }
                    ((com.tencent.mm.ui.chatting.b.b.e) aVar.O(com.tencent.mm.ui.chatting.b.b.e.class)).gT(aVar.getTalkerUserName());
                    com.tencent.mm.ui.a.a.a.cqX().J(cVar.ueI, (int) bD);
                    cVar.ucQ.setContentDescription(" ");
                }
                f = bD;
                if (1 == bdVar.field_isSend) {
                    if (bdVar.field_status == 1) {
                        bdVar.cmF();
                        a(cVar, 0, 8, false);
                        cVar.ueL.setVisibility(8);
                        cVar.cxS();
                        bD = f;
                    } else if (nVar.time == -1) {
                        bdVar.cmF();
                        a(cVar, 8, 0, false);
                        cVar.ueI.setWidth(80);
                        cVar.ueG = 80;
                        cVar.ucQ.setVisibility(8);
                        cVar.ueL.setVisibility(8);
                        cVar.ueJ.setWidth(com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr((int) f)));
                        cVar.cxS();
                        bD = f;
                    } else if (bdVar.field_status == 7) {
                        bdVar.cmF();
                        a(cVar, 8, 8, false);
                        cVar.ucQ.setVisibility(8);
                        cVar.ueL.setVisibility(0);
                        cVar.cxS();
                        if (cVar.ueM != null) {
                            cVar.ueQ = AnimationUtils.loadAnimation(cVar.jEz.getContext(), R.a.voice_recording_animation);
                            cVar.ueM.startAnimation(cVar.ueQ);
                        }
                        bD = f;
                    } else {
                        bdVar.cmF();
                        a(cVar, 8, 0, false);
                        cVar.ueL.setVisibility(8);
                        cVar.ucQ.setVisibility(0);
                        cVar.cxS();
                        if (nVar.time == 0) {
                            f = 0.0f;
                        }
                        cVar.ueG = com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr((int) f));
                        cVar.ueI.setWidth(cVar.ueG);
                        cVar.ucQ.setText(aVar.tTq.getMMResources().getString(R.l.fmt_time_length, new Object[]{Integer.valueOf((int) f)}));
                        cVar.ueJ.setWidth(com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), nr((int) f)));
                    }
                    cuM = ((com.tencent.mm.ui.chatting.b.b.b) aVar.O(com.tencent.mm.ui.chatting.b.b.b.class)).cuM();
                    if (cuM != null) {
                        cVar.ucQ.setTextColor(cuM.qEW);
                        if (cuM.qEX) {
                            cVar.ucQ.setShadowLayer(2.0f, 1.2f, 1.2f, cuM.qEY);
                        } else {
                            cVar.ucQ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                        }
                        if (cuM.qEZ) {
                            cVar.ucQ.setBackgroundResource(R.g.chatting_voice_second_bg);
                        } else {
                            cVar.ucQ.setBackgroundColor(0);
                        }
                    }
                    cVar.ueI.setTag(new ChattingItemTranslate.a(bdVar, aVar.cwr(), i));
                    cVar.ueI.setOnClickListener(cVar.tZx.d(aVar));
                    cVar.ueI.setOnLongClickListener(onLongClickListener);
                    cVar.ueI.setOnTouchListener(((g) aVar.O(g.class)).ctw());
                    if ((bdVar.cqa & 1) == 1) {
                        cVar.ueH.setVisibility(0);
                        if (bdVar.field_isSend == 0) {
                            cVar.ueJ.setBackgroundResource(R.g.chatfrom_bg_voice_forward);
                        } else {
                            cVar.ueP.setBackgroundResource(R.g.chatto_bg_voice_forward);
                            cVar.ueJ.setBackgroundResource(R.g.chatto_bg_voice_forward);
                        }
                    } else {
                        cVar.ueH.setVisibility(8);
                        if (bdVar.field_isSend == 0) {
                            cVar.ueJ.setBackgroundResource(R.g.chatfrom_bg);
                        } else {
                            cVar.ueP.setBackgroundResource(R.g.chatto_bg);
                            cVar.ueJ.setBackgroundResource(R.g.chatto_bg);
                        }
                    }
                    if (z) {
                        aVar.getTalkerUserName();
                    } else {
                        aVar.cwp();
                    }
                    ((com.tencent.mm.ui.chatting.b.b.e) aVar.O(com.tencent.mm.ui.chatting.b.b.e.class)).gT(aVar.getTalkerUserName());
                    com.tencent.mm.ui.a.a.a.cqX().J(cVar.ueI, (int) bD);
                    cVar.ucQ.setContentDescription(" ");
                }
                bD = f;
                cuM = ((com.tencent.mm.ui.chatting.b.b.b) aVar.O(com.tencent.mm.ui.chatting.b.b.b.class)).cuM();
                if (cuM != null) {
                    cVar.ucQ.setTextColor(cuM.qEW);
                    if (cuM.qEX) {
                        cVar.ucQ.setShadowLayer(2.0f, 1.2f, 1.2f, cuM.qEY);
                    } else {
                        cVar.ucQ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    }
                    if (cuM.qEZ) {
                        cVar.ucQ.setBackgroundResource(R.g.chatting_voice_second_bg);
                    } else {
                        cVar.ucQ.setBackgroundColor(0);
                    }
                }
                cVar.ueI.setTag(new ChattingItemTranslate.a(bdVar, aVar.cwr(), i));
                cVar.ueI.setOnClickListener(cVar.tZx.d(aVar));
                cVar.ueI.setOnLongClickListener(onLongClickListener);
                cVar.ueI.setOnTouchListener(((g) aVar.O(g.class)).ctw());
                if ((bdVar.cqa & 1) == 1) {
                    cVar.ueH.setVisibility(0);
                    if (bdVar.field_isSend == 0) {
                        cVar.ueJ.setBackgroundResource(R.g.chatfrom_bg_voice_forward);
                    } else {
                        cVar.ueP.setBackgroundResource(R.g.chatto_bg_voice_forward);
                        cVar.ueJ.setBackgroundResource(R.g.chatto_bg_voice_forward);
                    }
                } else {
                    cVar.ueH.setVisibility(8);
                    if (bdVar.field_isSend == 0) {
                        cVar.ueJ.setBackgroundResource(R.g.chatfrom_bg);
                    } else {
                        cVar.ueP.setBackgroundResource(R.g.chatto_bg);
                        cVar.ueJ.setBackgroundResource(R.g.chatto_bg);
                    }
                }
                if (z) {
                    aVar.getTalkerUserName();
                } else {
                    aVar.cwp();
                }
                ((com.tencent.mm.ui.chatting.b.b.e) aVar.O(com.tencent.mm.ui.chatting.b.b.e.class)).gT(aVar.getTalkerUserName());
                com.tencent.mm.ui.a.a.a.cqX().J(cVar.ueI, (int) bD);
                cVar.ucQ.setContentDescription(" ");
            }
        }

        private void cxS() {
            if (this.ueQ != null) {
                this.ueQ.cancel();
                this.ueQ = null;
            }
        }

        private static void a(c cVar, int i, int i2, boolean z) {
            cVar.tZv.setVisibility(i2);
            cVar.ucQ.setVisibility(i2);
            cVar.ueK.setVisibility(i2);
            if (z) {
                cVar.ueN.setVisibility(i);
                cVar.tZU.setVisibility(i2);
                return;
            }
            cVar.ueP.setVisibility(i);
        }

        private static int nr(int i) {
            if (i <= 2) {
                return 80;
            }
            if (i < 10) {
                return ((i - 2) * 9) + 80;
            }
            if (i < 60) {
                return (((i / 10) + 7) * 9) + 80;
            }
            return 204;
        }
    }

    static /* synthetic */ void bD(bd bdVar) {
        fl flVar = new fl();
        flVar.bNO.bNP = 3;
        flVar.bNO.scene = 1;
        flVar.bNO.fileName = bdVar.field_imgPath;
        com.tencent.mm.sdk.b.a.sFg.m(flVar);
    }

    public static void a(com.tencent.mm.ui.chatting.c.a aVar, au auVar) {
        if (com.tencent.mm.p.a.by(aVar.tTq.getContext()) || com.tencent.mm.p.a.bw(aVar.tTq.getContext())) {
            x.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
            return;
        }
        au.HU();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            s.gH(aVar.tTq.getContext());
        } else if (auVar != null && auVar.bXQ != null) {
            n nVar = new n(auVar.bXQ.field_content);
            if (ai.oW(auVar.bXQ.field_content) || nVar.time == 0) {
                Toast.makeText(aVar.tTq.getContext(), R.l.chatting_data_broken, 0).show();
                return;
            }
            d cwl = ((ag) aVar.O(ag.class)).cwl();
            if (aVar.O(g.class) != null && cwl != null) {
                bd bdVar = auVar.bXQ;
                if (((ag) aVar.O(ag.class)).cwl().tHf != bdVar.field_msgId) {
                    ad adVar = (ad) aVar.O(ad.class);
                    int i = adVar.gG(bdVar.field_msgId) ? 7 : adVar.gD(bdVar.field_msgId) ? 6 : 0;
                    if (i != 0) {
                        fl flVar = new fl();
                        flVar.bNO.bNP = 1;
                        flVar.bNO.scene = i;
                        flVar.bNO.fileName = bdVar.field_imgPath;
                        com.tencent.mm.sdk.b.a.sFg.m(flVar);
                    }
                }
                int i2 = auVar.position;
                bdVar = auVar.bXQ;
                if (bdVar != null && bdVar.ckz()) {
                    nVar = new n(bdVar.field_content);
                    if (nVar.time != 0 || bdVar.field_isSend != 0) {
                        if (bdVar.field_status != 1 || bdVar.field_isSend != 1) {
                            if (bdVar.field_isSend != 0 || nVar.time != -1) {
                                cwl.csL();
                                au.HU();
                                Boolean bool = (Boolean) com.tencent.mm.model.c.DT().get(4115, null);
                                if (bool == null || !bool.booleanValue()) {
                                    au.HU();
                                    com.tencent.mm.model.c.DT().set(4115, Boolean.valueOf(true));
                                    cwl.csR();
                                    cwl.tHi = s.a(cwl.bAG.tTq.getActivity(), cwl.context.getString(R.l.chatting_music_volumn_change), 4000);
                                }
                                if (cwl.iWF.isPlaying() && bdVar.field_msgId == cwl.tHf) {
                                    cwl.tHo = true;
                                    cwl.csQ();
                                    return;
                                }
                                cwl.ao(bdVar);
                                if (bdVar.field_isSend == 0 && !q.F(bdVar)) {
                                    cwl.EG(i2 + 1);
                                }
                                cwl.bhU();
                            }
                        }
                    }
                }
            }
        }
    }
}
