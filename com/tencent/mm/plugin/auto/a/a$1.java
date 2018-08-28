package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.ah;
import android.support.v4.app.z$g;
import android.support.v4.app.z.f;
import com.tencent.mm.R;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.g;
import java.util.List;

class a$1 extends c<v> {
    final /* synthetic */ a gRg;

    a$1(a aVar) {
        this.gRg = aVar;
        this.sFo = v.class.getName().hashCode();
    }

    private static boolean a(v vVar) {
        if (vVar instanceof v) {
            try {
                z$g z_g;
                a aVar = vVar.bHd;
                String str = vVar.bHd.username;
                String str2 = vVar.bHd.title;
                if (a.aqG()) {
                    PendingIntent broadcast = PendingIntent.getBroadcast(ad.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", str), 134217728);
                    PendingIntent broadcast2 = PendingIntent.getBroadcast(ad.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", str), 134217728);
                    ah.a aVar2 = new ah.a("key_voice_reply_text");
                    aVar2.qF = ad.getContext().getString(R.l.app_reply);
                    ah ahVar = new ah(aVar2.qE, aVar2.qF, aVar2.qG, aVar2.qH, aVar2.mExtras, (byte) 0);
                    f.a.a aVar3 = new f.a.a(str2);
                    aVar3.pW = broadcast;
                    aVar3.pU = ahVar;
                    aVar3.pV = broadcast2;
                    int fo = com.tencent.mm.k.f.fo(str);
                    if (fo > 10) {
                        fo = 10;
                    }
                    au.HU();
                    List by = com.tencent.mm.model.c.FT().by(str, fo);
                    for (int size = by.size() - 1; size >= 0; size--) {
                        String trim;
                        Object string;
                        bd bdVar = (bd) by.get(size);
                        Object obj = null;
                        if (s.fq(bdVar.field_talker)) {
                            String str3 = bdVar.field_talker;
                            int iA = com.tencent.mm.model.bd.iA(bdVar.field_content);
                            if (iA != -1) {
                                trim = bdVar.field_content.substring(0, iA).trim();
                                if (trim != null && trim.length() > 0) {
                                    str3 = trim;
                                }
                            }
                            au.HU();
                            ab Yg = com.tencent.mm.model.c.FR().Yg(str3);
                            trim = r.a(Yg, str3);
                            if (s.fq(str3) && (Yg.field_username.equals(trim) || bi.oW(trim))) {
                                string = ad.getContext().getString(R.l.chatting_roominfo_noname);
                            } else {
                                str3 = trim;
                            }
                        } else {
                            string = null;
                        }
                        String obj2;
                        if (bdVar.ckA()) {
                            obj2 = ad.getContext().getString(R.l.notification_img_content);
                        } else if (bdVar.isText()) {
                            if (!s.fq(bdVar.field_talker) || bdVar.field_isSend == 1) {
                                obj2 = bdVar.field_content;
                            } else {
                                int iA2 = com.tencent.mm.model.bd.iA(bdVar.field_content);
                                obj2 = iA2 != -1 ? bdVar.field_content.substring(iA2 + 1).trim() : bdVar.field_content;
                            }
                        } else if (bdVar.ckz()) {
                            obj2 = ad.getContext().getString(R.l.notification_voice_content);
                        } else if (bdVar.cmj()) {
                            obj2 = ad.getContext().getString(R.l.notification_video_content);
                        } else if (bdVar.cmk()) {
                            obj2 = ad.getContext().getString(R.l.notification_short_video_content);
                        } else if (bdVar.aQm()) {
                            g.a gp = g.a.gp(bdVar.field_content);
                            if (gp != null) {
                                switch (gp.type) {
                                    case 2:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_img_content), new Object[0]);
                                        break;
                                    case 3:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_app_music_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 4:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_app_video_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 5:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_app_link_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 6:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_app_file_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 8:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_custom_emoji_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 10:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_app_product_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 13:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_app_mall_product_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 15:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_app_emoji_share_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 16:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_card_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 19:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_app_record_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 20:
                                        obj2 = String.format(ad.getContext().getString(R.l.notification_app_tv_content), new Object[]{bi.aG(gp.title, "")});
                                        break;
                                    case 24:
                                        obj2 = ad.getContext().getString(R.l.favorite_wenote_msg);
                                        break;
                                }
                            }
                        } else if (bdVar.cml()) {
                            trim = ad.getContext().getString(R.l.notification_emoji_content);
                            d emojiMgr = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
                            if (emojiMgr != null) {
                                EmojiInfo zi = emojiMgr.zi(bdVar.field_imgPath);
                                obj2 = (zi == null || bi.oW(emojiMgr.zf(zi.Xh()))) ? ad.getContext().getString(R.l.notification_emoji_content) : "[" + emojiMgr.zf(zi.Xh()) + "]";
                            } else {
                                obj2 = trim;
                            }
                        } else if (bdVar.aQo()) {
                            obj2 = ad.getContext().getString(R.l.notification_location_content);
                        } else if (bdVar.cme() || bdVar.cmf()) {
                            if (!bdVar.field_content.equals(bd.tbx)) {
                                obj2 = bdVar.field_content;
                                su suVar = new su();
                                suVar.cdE.bOh = 1;
                                suVar.cdE.content = obj2;
                                com.tencent.mm.sdk.b.a.sFg.m(suVar);
                                if ((suVar.cdF.type == 3 ? 1 : null) == null) {
                                    obj2 = ad.getContext().getString(R.l.notification_voip_content);
                                }
                            }
                            obj2 = ad.getContext().getString(R.l.notification_voip_voice_content);
                        } else if (bdVar.cmi()) {
                            au.HU();
                            bd.a GR = com.tencent.mm.model.c.FT().GR(bdVar.field_content);
                            obj2 = String.format(ad.getContext().getString(R.l.notification_card_content), new Object[]{GR.getDisplayName()});
                        } else if (bdVar.getType() == -1879048186) {
                            obj2 = ad.getContext().getString(R.l.notification_app_location_share_content);
                        }
                        if (obj2 == null) {
                            obj2 = ad.getContext().getString(R.l.notification_simple_tip);
                        }
                        if (string != null) {
                            obj2 = String.format("%s: %s", new Object[]{string, obj2});
                        }
                        aVar3.qa.add(obj2);
                        if (size == 0) {
                            aVar3.pY = bdVar.field_createTime;
                        }
                    }
                    f fVar = new f();
                    fVar.pS = new f.a((String[]) aVar3.qa.toArray(new String[aVar3.qa.size()]), aVar3.pU, aVar3.pV, aVar3.pW, new String[]{aVar3.qb}, aVar3.pY);
                    z_g = fVar;
                } else {
                    z_g = null;
                }
                aVar.bHe = z_g;
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.auto.AutoLogic", th, "", new Object[0]);
            }
        }
        return false;
    }
}
