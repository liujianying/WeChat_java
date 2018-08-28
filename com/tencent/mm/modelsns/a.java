package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.design.a$i;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.h;
import java.util.Set;

public final class a {
    public static Set<String> egz;

    public static Intent a(WXMediaMessage wXMediaMessage, String str, String str2) {
        int i;
        x.d("MicroMsg.ShareSnsImpl", "appmsg.description " + wXMediaMessage.description);
        x.d("MicroMsg.ShareSnsImpl", "appmsg.title " + wXMediaMessage.title);
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
            case 6:
                i = 3;
                break;
            case 7:
                i = 3;
                break;
            case a$i.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
            case a$i.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                i = 15;
                break;
            default:
                i = -1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("KThrid_app", true);
        x.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i + " " + iMediaObject.type());
        intent.putExtra("Ksnsupload_appid", str);
        intent.putExtra("Ksnsupload_appname", str2);
        intent.putExtra("KSnsAction", true);
        intent.putExtra("need_result", true);
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        if (i == -1) {
            x.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
            return null;
        }
        String aG;
        String str3;
        String cu;
        StringBuilder stringBuilder;
        Bitmap mZ;
        Options VZ;
        switch (iMediaObject.type()) {
            case 1:
                intent.putExtra(h.thz, ((WXTextObject) iMediaObject).text);
                intent.putExtra("Ksnsupload_type", 8);
                return intent;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", wXImageObject.imagePath);
                return intent;
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                aG = bi.aG(!bi.oW(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                bi.aG(!bi.oW(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                bi.aG(!bi.oW(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, "");
                intent.putExtra("Ksnsupload_link", aG);
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 2);
                intent.putExtra("ksnsis_music", true);
                return intent;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                intent.putExtra("Ksnsupload_link", bi.aG(!bi.oW(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""));
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("ksnsis_video", true);
                return intent;
            case 5:
                intent.putExtra("Ksnsupload_link", ((WXWebpageObject) iMediaObject).webpageUrl);
                intent.putExtra("Ksnsupload_title", bi.aG(wXMediaMessage.title, ""));
                intent.putExtra("Ksnsupload_imgbuf", wXMediaMessage.thumbData);
                intent.putExtra("Ksnsupload_type", 1);
                return intent;
            case 6:
                x.e("MicroMsg.ShareSnsImpl", "file is not support!");
                return null;
            case 7:
                return null;
            case a$i.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                aG = wXVideoFileObject.filePath;
                str3 = "";
                cu = g.cu(aG);
                if (bi.oW(str3) || !FileOp.cn(str3)) {
                    stringBuilder = new StringBuilder();
                    au.HU();
                    str3 = stringBuilder.append(c.getAccSnsTmpPath()).append(cu).toString();
                    try {
                        mZ = mZ(aG);
                        if (mZ != null) {
                            x.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[]{Integer.valueOf(mZ.getWidth()), Integer.valueOf(mZ.getHeight())});
                            com.tencent.mm.sdk.platformtools.c.a(mZ, 80, CompressFormat.JPEG, str3, true);
                            VZ = com.tencent.mm.sdk.platformtools.c.VZ(str3);
                            x.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[]{Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                        } else {
                            x.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[]{aG});
                            return null;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[]{e.getMessage()});
                    }
                }
                intent.putExtra("KSightPath", aG);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", cu);
                return intent;
            case a$i.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                aG = wXGameVideoFileObject.filePath;
                String str4 = "";
                x.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", new Object[]{aG, str4, wXGameVideoFileObject.videoUrl, wXGameVideoFileObject.thumbUrl});
                String cu2 = g.cu(aG);
                if (bi.oW(str4) || !FileOp.cn(str4)) {
                    stringBuilder = new StringBuilder();
                    au.HU();
                    str3 = stringBuilder.append(c.getAccSnsTmpPath()).append(cu2).toString();
                    try {
                        mZ = mZ(aG);
                        if (mZ != null) {
                            x.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[]{Integer.valueOf(mZ.getWidth()), Integer.valueOf(mZ.getHeight())});
                            com.tencent.mm.sdk.platformtools.c.a(mZ, 80, CompressFormat.JPEG, str3, true);
                            VZ = com.tencent.mm.sdk.platformtools.c.VZ(str3);
                            x.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[]{Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                        } else {
                            x.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[]{aG});
                            return null;
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[]{e2.getMessage()});
                    }
                } else {
                    str3 = str4;
                }
                intent.putExtra("KSightPath", aG);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", cu2);
                intent.putExtra("KSightCdnUrl", cu);
                intent.putExtra("KSightCdnThumbUrl", r5);
                return intent;
            default:
                x.e("MicroMsg.ShareSnsImpl", "none type not support!");
                return null;
        }
    }

    private static Bitmap mZ(String str) {
        qa qaVar = new qa();
        qaVar.caG.caI = str;
        com.tencent.mm.sdk.b.a.sFg.m(qaVar);
        return (Bitmap) qaVar.caH.result;
    }
}
