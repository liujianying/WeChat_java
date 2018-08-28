package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ak.o;
import com.tencent.mm.an.a;
import com.tencent.mm.an.b;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.js;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.music.b$a;
import com.tencent.mm.plugin.music.b$e;
import com.tencent.mm.plugin.music.model.e.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c$a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class g {
    private static final Pattern eXs = Pattern.compile("songid=([0-9]+)");
    private static final String[] lys = new String[]{"#", "?", "&"};
    private static String lyt = null;
    private static String lyu = null;

    public static String dV(Context context) {
        String str = "";
        String packageName = ad.getPackageName();
        if (packageName == null) {
            return str;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo == null) {
                return str;
            }
            return (str + packageInfo.versionName) + "." + packageInfo.versionCode;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "", new Object[0]);
            return str;
        }
    }

    public static boolean f(a aVar) {
        x.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[]{aVar.field_songWapLinkUrl, aVar.field_songWebUrl, aVar.field_songWifiUrl});
        if (bi.oW(aVar.field_songWapLinkUrl) && bi.oW(aVar.field_songWebUrl) && bi.oW(aVar.field_songWifiUrl)) {
            return false;
        }
        return true;
    }

    public static String a(String str, String str2, boolean z, PBool pBool) {
        String str3;
        if (z || bi.oW(str2)) {
            str3 = str;
        } else {
            str3 = str2;
        }
        if (bi.oW(str3)) {
            return str3;
        }
        PString pString = new PString();
        x.i("MicroMsg.Music.MusicUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", new Object[]{str, str2, Boolean.valueOf(z)});
        String It = It(str3);
        if (It != null) {
            if (a(It, z, pString)) {
                pBool.value = z;
            }
        } else if (str3.contains("wechat_music_url=")) {
            a(str3.substring(str3.indexOf("wechat_music_url=") + 17), z, pString);
        } else {
            pString.value = str3;
        }
        return pString.value;
    }

    private static String It(String str) {
        if (bi.oW(str)) {
            return null;
        }
        if (lyt != null && str.equals(lyt)) {
            return lyu;
        }
        int indexOf;
        String str2 = "";
        String str3 = null;
        for (String str22 : lys) {
            str22 = str22 + "p=";
            if (str.contains(str22)) {
                str3 = str;
            }
            if (str3 != null) {
                break;
            }
        }
        if (str3 == null) {
            return null;
        }
        indexOf = str3.indexOf(str22);
        if (indexOf < 0) {
            x.w("MicroMsg.Music.MusicUtil", "pIndex is %d, return", new Object[]{Integer.valueOf(indexOf)});
            return null;
        }
        String substring = str3.substring(str22.length() + indexOf);
        for (String indexOf2 : lys) {
            int indexOf3 = substring.indexOf(indexOf2);
            if (indexOf3 > 0) {
                substring = substring.substring(0, indexOf3);
            }
        }
        if (substring == null) {
            return substring;
        }
        lyt = str;
        lyu = substring;
        return substring;
    }

    private static boolean a(String str, boolean z, PString pString) {
        String str2 = new String(Iu(str));
        int indexOf = str2.indexOf("{");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("song_WapLiveURL");
            str2 = jSONObject.getString("song_WifiURL");
            x.d("MicroMsg.Music.MusicUtil", "waplive: " + string + "  wifi:" + str2);
            if (!z) {
                str2 = string;
            }
            pString.value = str2;
            return true;
        } catch (Throwable e) {
            pString.value = str;
            x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "decodeJson", new Object[0]);
            return false;
        }
    }

    private static byte[] Iu(String str) {
        byte[] bArr = new byte[((str.length() / 2) + (str.length() % 2))];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            try {
                int m;
                int i3 = i + 1;
                int m2 = m(str.charAt(i));
                if (i3 < str.length()) {
                    i = i3 + 1;
                    m = m(str.charAt(i3));
                } else {
                    m = 0;
                    i = i3;
                }
                i3 = i2 + 1;
                bArr[i2] = (byte) (m | (m2 << 4));
                i2 = i3;
            } catch (Exception e) {
                return null;
            }
        }
        return bArr;
    }

    private static int Iv(String str) {
        int i = 0;
        if (bi.oW(str)) {
            return i;
        }
        Matcher matcher = eXs.matcher(str);
        if (!matcher.find()) {
            return i;
        }
        try {
            return Integer.valueOf(matcher.group(1)).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "getSongId", new Object[i]);
            return i;
        }
    }

    private static int m(char c) {
        if (c >= '1' && c <= '9') {
            return c - 48;
        }
        if (c < 'A' || c > 'F') {
            return 0;
        }
        return (c - 65) + 10;
    }

    private static String g(avq avq) {
        String str;
        if (avq != null) {
            if (!bi.oW(avq.rYp)) {
                str = avq.rYp;
            } else if (!bi.oW(avq.rYr)) {
                str = avq.rYr;
            } else if (!bi.oW(avq.rYq)) {
                str = avq.rYq;
            }
            if (str == null) {
                return null;
            }
            String It = It(avq.rYp);
            if (It != null) {
                return It;
            }
            It = It(avq.rYr);
            if (It == null) {
                return It(avq.rYq);
            }
            return It;
        }
        str = null;
        if (str == null) {
            return null;
        }
        String It2 = It(avq.rYp);
        if (It2 != null) {
            return It2;
        }
        It2 = It(avq.rYr);
        if (It2 == null) {
            return It(avq.rYq);
        }
        return It2;
    }

    public static avq h(avq avq) {
        if (avq != null) {
            avq.rKe = Iv(avq.rYp);
            if (avq.rKe <= 0) {
                avq.rKe = Iv(avq.rYr);
                if (avq.rKe <= 0) {
                    avq.rKe = Iv(avq.rYq);
                    int i = avq.rKe;
                }
            }
        }
        if (!(avq == null || g(avq) == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            String g = g(avq);
            if (g != null) {
                x.d("MicroMsg.Music.MusicUtil", "bcdUrl: %s", new Object[]{g});
                String str = new String(Iu(g));
                int indexOf = str.indexOf("{");
                if (indexOf != -1) {
                    str = str.substring(indexOf);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    avq.rKe = jSONObject.optInt("song_ID");
                    if (bi.oW(avq.rYl)) {
                        avq.rYl = jSONObject.optString("song_Name");
                    }
                    if (bi.oW(avq.rYq)) {
                        avq.rYq = jSONObject.optString("song_WapLiveURL");
                    }
                    if (bi.oW(avq.rYp)) {
                        avq.rYp = jSONObject.optString("song_WifiURL");
                    }
                    if (bi.oW(avq.rYn)) {
                        avq.rYn = jSONObject.optString("song_Album");
                    }
                    if (bi.oW(avq.rYm)) {
                        avq.rYm = jSONObject.optString("song_Singer");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "", new Object[0]);
                }
                if (avq.rKe == 0) {
                    avq.rKe = Iv(lyt);
                }
                x.i("MicroMsg.Music.MusicUtil", "parseBCDForMusicWrapper %s: expend: %d %d", new Object[]{avq.rsp, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(avq.rKe)});
            }
        }
        return avq;
    }

    public static void a(avq avq, Activity activity) {
        h.mEJ.k(10910, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        ch chVar = new ch();
        wl wlVar = new wl();
        wr wrVar = new wr();
        vx vxVar = new vx();
        wrVar.Vw(q.GF());
        wrVar.Vx(q.GF());
        wrVar.CO(5);
        wrVar.fU(bi.VF());
        wrVar.VC(j(avq));
        vxVar.UI(avq.rYp);
        vxVar.UJ(avq.rYq);
        vxVar.UH(avq.rYr);
        a IC = h.bid().IC(com.tencent.mm.plugin.music.d.a.x(avq));
        if (IC.PU()) {
            vxVar.UK(IC.field_songHAlbumUrl);
        } else {
            vxVar.UK(IC.field_songAlbumUrl);
        }
        vxVar.kX(true);
        String i = i(avq);
        if (FileOp.cn(i)) {
            vxVar.UQ(i);
        } else {
            vxVar.kY(true);
        }
        vxVar.UB(avq.rYl);
        vxVar.UC(avq.rYm);
        vxVar.CF(7);
        chVar.bJF.title = avq.rYl;
        chVar.bJF.desc = avq.rYm;
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 7;
        wlVar.a(wrVar);
        wlVar.rBI.add(vxVar);
        chVar.bJF.activity = activity;
        chVar.bJF.bJM = 3;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
    }

    public static boolean b(avq avq, Activity activity) {
        h.mEJ.k(10910, "4");
        if (avq == null) {
            return false;
        }
        String str;
        String str2 = avq.rYr;
        int indexOf = str2 == null ? -1 : str2.indexOf("#p=");
        if ((indexOf < 0 ? null : str2.substring(indexOf + 3)) == null) {
            x.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[]{str2});
            str = "androidqqmusic://";
        } else {
            x.i("MicroMsg.Music.MusicUtil", "get qq music data %s", new Object[]{indexOf < 0 ? null : str2.substring(indexOf + 3)});
            str = String.format("androidqqmusic://from=webPlayer&data=%s", new Object[]{str});
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            x.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[]{str});
            return false;
        }
        b.PW();
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(268435456);
        if (bi.k(activity, intent)) {
            activity.startActivity(intent);
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", str2);
        b.ezn.j(intent, activity);
        return false;
    }

    public static void x(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("scene_from", 6);
        d.b(activity, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    public static void a(avq avq, Intent intent, MMActivity mMActivity) {
        String stringExtra = intent.getStringExtra("Select_Conv_User");
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = avq.rYr;
        wXMusicObject.musicDataUrl = avq.rYp;
        wXMusicObject.musicLowBandUrl = avq.rYq;
        wXMusicObject.musicLowBandDataUrl = avq.rYq;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = avq.rYl;
        wXMediaMessage.description = avq.rYm;
        Bitmap bitmap = null;
        String i = i(avq);
        if (i != null && FileOp.cn(i)) {
            int dimension = (int) mMActivity.getResources().getDimension(b$a.NormalAvatarSize);
            bitmap = c.aj(i, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = bi.U(bitmap);
        } else {
            wXMediaMessage.thumbData = bi.U(c.CV(com.tencent.mm.plugin.music.b.b.default_icon_music));
        }
        b.ezn.a(mMActivity, j(avq), wXMediaMessage, stringExtra, k(avq));
        x.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[]{stringExtra});
    }

    public static void c(avq avq, Activity activity) {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = avq.rYr;
        wXMusicObject.musicDataUrl = avq.rYp;
        wXMusicObject.musicLowBandUrl = avq.rYq;
        wXMusicObject.musicLowBandDataUrl = avq.rYq;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = avq.rYl;
        wXMediaMessage.description = avq.rYm;
        Bitmap bitmap = null;
        String i = i(avq);
        if (i != null && FileOp.cn(i)) {
            int dimension = (int) activity.getResources().getDimension(b$a.NormalAvatarSize);
            bitmap = c.aj(i, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = bi.U(bitmap);
        } else {
            wXMediaMessage.thumbData = bi.U(c.CV(com.tencent.mm.plugin.music.b.b.default_icon_music));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        intent.putExtra("Ksnsupload_musicid", avq.rsp);
        intent.putExtra("Ksnsupload_appid", j(avq));
        intent.putExtra("Ksnsupload_appname", k(avq));
        String ic = u.ic("music_player");
        u.Hx().v(ic, true).p("prePublishId", "music_player");
        intent.putExtra("reportSessionId", ic);
        b.ezn.m(intent, activity);
    }

    private static String i(avq avq) {
        String str = "";
        a IC = h.bid().IC(com.tencent.mm.plugin.music.d.a.x(avq));
        if (IC != null) {
            str = com.tencent.mm.plugin.music.d.a.h(IC, true);
            if (!FileOp.cn(str)) {
                switch (avq.rYj) {
                    case 0:
                        str = o.Pf().E(avq.rYt, true);
                        break;
                    case 4:
                        js jsVar = new js();
                        jsVar.bTw.action = 12;
                        jsVar.bTw.bTB = avq.rYo;
                        com.tencent.mm.sdk.b.a.sFg.m(jsVar);
                        str = jsVar.bTx.bTD;
                        if (bi.oW(str)) {
                            str = avq.rYt;
                        }
                        if (!FileOp.cn(str)) {
                            str = com.tencent.mm.plugin.music.d.a.h(IC, false);
                            break;
                        }
                        break;
                    case 5:
                        if (avq.rYt != null) {
                            str = avq.rYt;
                            break;
                        }
                        str = "";
                        break;
                    case 6:
                        if (avq.rYt != null) {
                            str = avq.rYt;
                            break;
                        }
                        str = "";
                        break;
                    case 7:
                    case 10:
                    case 11:
                        if (avq.rYt != null) {
                            str = avq.rYt;
                            break;
                        }
                        str = "";
                        break;
                    default:
                        if (n.nky != null) {
                            ate ate = new ate();
                            ate.ksA = avq.rvP;
                            ate.rVE = avq.rYo;
                            ate.rVF = avq.rYv;
                            ate.jPK = ate.rVE;
                            str = n.nkx.a(ate);
                            break;
                        }
                        break;
                }
            }
            x.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[]{str});
        }
        return str;
    }

    public static String j(avq avq) {
        String str = avq.jQb;
        if (!bi.oW(str)) {
            return str;
        }
        switch (avq.rYj) {
            case 4:
                return "wx485a97c844086dc9";
            case 5:
                return "wx482a4001c37e2b74";
            default:
                return str;
        }
    }

    private static String k(avq avq) {
        switch (avq.rYj) {
            case 0:
            case 1:
            case 8:
                return ad.getContext().getString(b$e.sns_music_prefix);
            case 4:
                return ad.getContext().getString(b$e.shake_music_app);
            case 5:
                return ad.getContext().getString(b$e.scan_music_prefix);
            default:
                return ad.getContext().getString(b$e.default_music_prefix);
        }
    }

    public static void y(Activity activity) {
        if (((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(82, Boolean.valueOf(true))).booleanValue()) {
            com.tencent.mm.kernel.g.Ei().DT().set(82, Boolean.valueOf(false));
            switch (h.bic().bhR().field_musicType) {
                case 0:
                    J(activity, b$e.shake_first_time_chatting);
                    return;
                case 1:
                case 8:
                    J(activity, b$e.shake_first_time_timeline);
                    return;
                case 4:
                    J(activity, b$e.shake_first_time_shake);
                    return;
                case 6:
                    J(activity, b$e.shake_first_time_favorite);
                    return;
                default:
                    return;
            }
        } else if (h.bic().mode == 2) {
            Toast.makeText(ad.getContext(), b$e.switch_to_multi_music, 0).show();
        } else {
            Toast.makeText(ad.getContext(), b$e.switch_to_single_music, 0).show();
        }
    }

    public static boolean tB(int i) {
        switch (i) {
            case 10:
            case 11:
                return true;
            default:
                return f.tI(i);
        }
    }

    public static boolean l(avq avq) {
        if (avq == null || TextUtils.isEmpty(avq.protocol)) {
            return false;
        }
        x.d("MicroMsg.Music.MusicUtil", "protocol:%s", new Object[]{avq.protocol});
        if ("hls".equalsIgnoreCase(avq.protocol)) {
            return true;
        }
        return false;
    }

    public static boolean g(a aVar) {
        if (aVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.field_songWifiUrl) && TextUtils.isEmpty(aVar.field_songWapLinkUrl) && TextUtils.isEmpty(aVar.field_songWebUrl)) {
            return false;
        }
        return true;
    }

    public static void F(String str, String str2, int i) {
        x.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[]{str, str2, Integer.valueOf(i)});
        qu quVar = new qu();
        quVar.cbq.appId = str;
        quVar.cbq.cbu = -1;
        quVar.cbq.cbt = i;
        quVar.cbq.userName = str2;
        quVar.cbq.scene = 1056;
        if (i == 1) {
            quVar.cbq.cbx = true;
        }
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
    }

    private static com.tencent.mm.ui.widget.a.c J(Context context, int i) {
        c$a c_a = new c$a(context);
        c_a.Gq(b$e.app_tip);
        c_a.Gr(i);
        c_a.Gt(b$e.welcome_i_know).a(null);
        c_a.mF(true);
        com.tencent.mm.ui.widget.a.c anj = c_a.anj();
        anj.show();
        return anj;
    }

    public static int cH(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.length() <= 0 ? 0 : Integer.valueOf(str).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "getInt", new Object[0]);
            return 0;
        }
    }
}
