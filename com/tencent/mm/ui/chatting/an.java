package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.g$a;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWMediaConversation;
import com.tencent.wework.api.model.WWMediaFile;
import com.tencent.wework.api.model.WWMediaImage;
import com.tencent.wework.api.model.WWMediaLink;
import com.tencent.wework.api.model.WWMediaLocation;
import com.tencent.wework.api.model.WWMediaMergedConvs;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import com.tencent.wework.api.model.WWMediaText;
import com.tencent.wework.api.model.WWMediaVideo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class an {
    public static void a(Context context, ab abVar, List<bd> list, boolean z) {
        IWWAPI ii = WWAPIFactory.ii(context);
        try {
            BaseMessage c;
            if (list.size() == 1) {
                c = c((bd) list.get(0), z);
            } else {
                c = a(abVar, list, z);
            }
            ii.a(c);
        } catch (a e) {
            h.i(context, R.l.sending_ww_file_too_large_warning, R.l.app_tip);
        }
    }

    private static WWMediaObject c(bd bdVar, boolean z) {
        int type = bdVar.getType();
        if (type == 1) {
            return new WWMediaText(j.p(bdVar.field_content, bdVar.field_isSend, z));
        }
        String o;
        WWMediaObject wWMediaImage;
        if (type == 3) {
            e br;
            if (bdVar.field_msgId > 0) {
                br = o.Pf().br(bdVar.field_msgId);
            } else {
                br = null;
            }
            if ((br == null || br.dTK <= 0) && bdVar.field_msgSvrId > 0) {
                br = o.Pf().bq(bdVar.field_msgSvrId);
            }
            if (br == null) {
                return null;
            }
            o = o.Pf().o(f.c(br), "", "");
            wWMediaImage = new WWMediaImage();
            wWMediaImage.filePath = o;
            x.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[]{wWMediaImage.filePath});
            return wWMediaImage;
        } else if (type == 43) {
            wWMediaImage = new WWMediaVideo();
            r nW = t.nW(bdVar.field_imgPath);
            com.tencent.mm.modelvideo.o.Ta();
            wWMediaImage.filePath = s.nK(nW.getFileName());
            x.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[]{wWMediaImage.filePath});
            return wWMediaImage;
        } else if (type == 48) {
            wWMediaImage = new WWMediaLocation();
            o = j.p(bdVar.field_content, bdVar.field_isSend, z);
            au.HU();
            b GS = c.FT().GS(o);
            wWMediaImage.title = GS.kFa;
            wWMediaImage.dRH = GS.label;
            wWMediaImage.longitude = GS.kCx;
            wWMediaImage.latitude = GS.kCw;
            wWMediaImage.vzL = (double) GS.bSz;
            return wWMediaImage;
        } else if (type == 49 || type == 268435505) {
            return d(bdVar, z);
        } else {
            x.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[]{Integer.valueOf(type)});
            return null;
        }
    }

    private static WWMediaObject a(ab abVar, List<bd> list, boolean z) {
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        String str = abVar.field_username;
        Context context = ad.getContext();
        if (z) {
            str = context.getString(R.l.record_chatroom_title);
        } else {
            str = q.GH().equals(com.tencent.mm.model.r.gS(str)) ? context.getString(R.l.favorite_record_chatroom_title, new Object[]{q.GH()}) : context.getString(R.l.favorite_record_chat_title, new Object[]{q.GH(), com.tencent.mm.model.r.gS(str)});
        }
        wWMediaMergedConvs.title = str;
        for (bd bdVar : list) {
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String GF = bdVar.field_isSend == 1 ? q.GF() : !z ? bdVar.field_talker : com.tencent.mm.model.bd.iB(bdVar.field_content);
            wWMediaConversation.name = com.tencent.mm.model.r.gS(GF);
            try {
                Bitmap a = com.tencent.mm.aa.c.a(GF, false, -1);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                wWMediaConversation.vzJ = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
            wWMediaConversation.mEo = bdVar.field_createTime;
            wWMediaConversation.vzK = c(bdVar, z);
            if (wWMediaConversation.checkArgs()) {
                wWMediaMergedConvs.vzM.add(wWMediaConversation);
            }
        }
        return wWMediaMergedConvs;
    }

    private static WWMediaObject d(bd bdVar, boolean z) {
        g$a J;
        String str = bdVar.field_content;
        if (z) {
            int indexOf = bdVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str = bdVar.field_content.substring(indexOf + 1);
            }
        }
        if (str != null) {
            J = g$a.J(str, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J == null) {
            return null;
        }
        switch (J.type) {
            case 2:
                if (J.bGP == null || J.bGP.length() <= 0) {
                    return null;
                }
                com.tencent.mm.pluginsdk.model.app.b SR = ao.asF().SR(J.bGP);
                if (SR == null || !SR.aSc()) {
                    return null;
                }
                str = SR.field_fileFullPath;
                if (com.tencent.mm.a.e.cn(str)) {
                    WWMediaObject wWMediaImage = new WWMediaImage();
                    wWMediaImage.filePath = str;
                    x.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[]{wWMediaImage.filePath});
                    return wWMediaImage;
                }
                x.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[]{str, Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId)});
                return null;
            case 5:
                OutputStream byteArrayOutputStream;
                WWMediaLink wWMediaLink = new WWMediaLink();
                wWMediaLink.webpageUrl = J.url;
                wWMediaLink.title = J.title;
                wWMediaLink.description = J.description;
                Bitmap a = o.Pf().a(bdVar.field_imgPath, a.getDensity(null), false);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                }
                try {
                    a = o.Pf().a(bdVar.field_imgPath, a.getDensity(null), false);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
                return wWMediaLink;
            case 6:
                com.tencent.mm.pluginsdk.model.app.b SZ = l.SZ(J.bGP);
                if (SZ == null) {
                    SZ = ao.asF().fH(bdVar.field_msgId);
                }
                if (SZ.field_totalLen > DownloadHelper.SAVE_LENGTH) {
                    throw new a((byte) 0);
                }
                WWMediaFile wWMediaFile = new WWMediaFile();
                wWMediaFile.fileName = J.title;
                wWMediaFile.filePath = SZ.field_fileFullPath;
                wWMediaFile.contentLengthLimit = 104857600;
                return wWMediaFile;
            default:
                return null;
        }
    }
}
