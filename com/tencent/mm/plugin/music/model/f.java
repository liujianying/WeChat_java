package com.tencent.mm.plugin.music.model;

import android.support.design.a$i;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.an.a;
import com.tencent.mm.an.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class f {
    public static long dGw;
    public static boolean lyn;
    public static boolean lyo;
    public static int lyp;
    public static int lyq;
    private static a lyr;
    public static int scene;

    public static final void R(int i, int i2, int i3) {
        if (h.bic().bhR() != null) {
            x.v("MicroMsg.Music.MusicReportUtil", "kvReportShakeReport: %d, %d, %d, %s, %s, %s, %s, %d %s, %s", new Object[]{Integer.valueOf(13042), Integer.valueOf(i), Integer.valueOf(i2), h.bic().bhR().field_musicId, h.bic().bhR().field_songName, h.bic().bhR().field_songAlbum, Integer.valueOf(h.bic().bhR().field_songId), Integer.valueOf(i3), h.bic().bhR().field_songSinger, h.bic().bhR().field_appId});
            h.mEJ.h(13042, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i3), r0.field_songSinger, r0.field_appId});
        }
    }

    public static final void cW(int i, int i2) {
        if (h.bic().bhR() != null) {
            x.v("MicroMsg.Music.MusicReportUtil", "kvReportAction: %d, %s, %s, %s, %s, %d, %d, %s, %s", new Object[]{Integer.valueOf(13232), h.bic().bhR().field_musicId, h.bic().bhR().field_songName, h.bic().bhR().field_songAlbum, Integer.valueOf(h.bic().bhR().field_songId), Integer.valueOf(i2), Integer.valueOf(i), h.bic().bhR().field_songSinger, h.bic().bhR().field_appId});
            h.mEJ.h(13232, new Object[]{r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i2), Integer.valueOf(i), r0.field_songSinger, r0.field_appId});
        }
    }

    public static synchronized void e(a aVar) {
        synchronized (f.class) {
            lyr = aVar;
        }
    }

    public static final synchronized void bhZ() {
        int i = 1;
        synchronized (f.class) {
            if (lyr != null) {
                int i2;
                yL();
                String str = "MicroMsg.Music.MusicReportUtil";
                String str2 = "kvReportMusicPlayInfo: %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s";
                Object[] objArr = new Object[12];
                objArr[0] = Integer.valueOf(13044);
                objArr[1] = lyr.field_musicId;
                objArr[2] = lyr.field_songName;
                objArr[3] = lyr.field_songAlbum;
                objArr[4] = Integer.valueOf(lyr.field_songId);
                objArr[5] = Integer.valueOf(lyp);
                objArr[6] = Integer.valueOf(lyq);
                objArr[7] = Integer.valueOf(lyn ? 1 : 2);
                objArr[8] = Integer.valueOf(lyo ? 1 : 2);
                objArr[9] = Integer.valueOf(scene);
                objArr[10] = lyr.field_songSinger;
                objArr[11] = lyr.field_appId;
                x.v(str, str2, objArr);
                h hVar = h.mEJ;
                objArr = new Object[11];
                objArr[0] = lyr.field_musicId;
                objArr[1] = lyr.field_songName;
                objArr[2] = lyr.field_songAlbum;
                objArr[3] = Integer.valueOf(lyr.field_songId);
                objArr[4] = Integer.valueOf(lyp);
                objArr[5] = Integer.valueOf(lyq);
                if (lyn) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr[6] = Integer.valueOf(i2);
                if (!lyo) {
                    i = 2;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = Integer.valueOf(scene);
                objArr[9] = lyr.field_songSinger;
                objArr[10] = lyr.field_appId;
                hVar.h(13044, objArr);
            }
            lyr = null;
            lyn = false;
            lyo = false;
            lyp = 0;
            lyq = 0;
            dGw = 0;
            scene = 0;
        }
    }

    public static final void yL() {
        if (dGw > 0) {
            lyq = (int) (((long) lyq) + ((System.currentTimeMillis() - dGw) / 1000));
            dGw = 0;
        }
    }

    public static final void bia() {
        h.mEJ.a(285, 4, 1, false);
    }

    public static final void ty(int i) {
        if (i == 2) {
            avq Qa = b.Qa();
            if (Qa != null) {
                com.tencent.mm.plugin.fav.a.h.f(bi.getLong(Qa.eaZ, 0), 1, 0);
            }
        }
    }

    public static final void tz(int i) {
        if (i == 2) {
            avq Qa = b.Qa();
            if (Qa != null) {
                com.tencent.mm.plugin.fav.a.h.f(bi.getLong(Qa.eaZ, 0), 0, 0);
            }
        }
    }

    public static final void a(a aVar, boolean z) {
        if (aVar == null) {
            x.e("MicroMsg.Music.MusicReportUtil", "idKeyReportMusicPlayerSum music is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        iDKey3.SetValue(1);
        avq PV = aVar.PV();
        int i;
        IDKey iDKey4;
        if (z) {
            iDKey3.SetKey(10);
        } else if (g.l(PV)) {
            i = PV.rYj;
            x.i("MicroMsg.Music.MusicReportUtil", "idKeyReportExoMusicPlayerSum scene:%d", new Object[]{Integer.valueOf(i)});
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(797);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            iDKey2 = new IDKey();
            iDKey2.SetID(797);
            x.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerSumidKeyByMusicType, musicType:" + i);
            switch (i) {
                case 0:
                    i = 50;
                    break;
                case 1:
                    i = 51;
                    break;
                case 4:
                    i = 52;
                    break;
                case 6:
                    i = 53;
                    break;
                case 7:
                    i = 54;
                    break;
                case 8:
                    i = 55;
                    break;
                case 9:
                    i = 56;
                    break;
                case 10:
                    i = 57;
                    break;
                case 11:
                    i = 58;
                    break;
                default:
                    i = 59;
                    break;
            }
            iDKey2.SetKey(i);
            iDKey2.SetValue(1);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.mEJ.b(arrayList, true);
            return;
        } else if (g.tB(aVar.field_musicType)) {
            iDKey3.SetKey(2);
            i = aVar.field_musicType;
            x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerSumidKeyByMusicType, musicType:" + i);
            switch (i) {
                case 0:
                    i = 117;
                    break;
                case 1:
                    i = 118;
                    break;
                case 4:
                    i = 119;
                    break;
                case 5:
                    i = 120;
                    break;
                case 6:
                    i = 121;
                    break;
                case 7:
                    i = 122;
                    break;
                case 8:
                    i = 123;
                    break;
                case 9:
                    i = 124;
                    break;
                case 10:
                    i = 125;
                    break;
                case 11:
                    i = 126;
                    break;
                default:
                    i = 127;
                    break;
            }
            iDKey2.SetKey(i);
            arrayList.add(iDKey2);
            h.mEJ.h(14174, new Object[]{Integer.valueOf(1), Integer.valueOf(aVar.field_musicType)});
            if (com.tencent.mm.plugin.music.model.a.b.Ix(aVar.playUrl)) {
                iDKey4 = new IDKey();
                iDKey4.SetID(558);
                iDKey4.SetKey(216);
                iDKey4.SetValue(1);
                arrayList.add(iDKey4);
            }
        } else {
            iDKey3.SetKey(1);
            i = aVar.field_musicType;
            x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerSumidKeyByMusicType, musicType:" + i);
            switch (i) {
                case 0:
                    i = a$i.AppCompatTheme_radioButtonStyle;
                    break;
                case 1:
                    i = a$i.AppCompatTheme_ratingBarStyle;
                    break;
                case 4:
                    i = a$i.AppCompatTheme_ratingBarStyleIndicator;
                    break;
                case 5:
                    i = 108;
                    break;
                case 6:
                    i = a$i.AppCompatTheme_seekBarStyle;
                    break;
                case 7:
                    i = a$i.AppCompatTheme_spinnerStyle;
                    break;
                case 8:
                    i = 111;
                    break;
                case 9:
                    i = 112;
                    break;
                default:
                    i = 113;
                    break;
            }
            iDKey2.SetKey(i);
            arrayList.add(iDKey2);
            h.mEJ.h(14174, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType)});
            if (com.tencent.mm.plugin.music.model.a.b.Ix(aVar.playUrl)) {
                iDKey4 = new IDKey();
                iDKey4.SetID(558);
                iDKey4.SetKey(215);
                iDKey4.SetValue(1);
                arrayList.add(iDKey4);
            }
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey3);
        h.mEJ.b(arrayList, true);
    }

    public static final void tA(int i) {
        if (h.bic().bhR() != null) {
            x.i("MicroMsg.Music.MusicReportUtil", "ReportMusicPlayerShareStat ShareType:%d, MusicId:%s, MusicTitle:%s, Singer:%s, AppId:%s", new Object[]{Integer.valueOf(i), h.bic().bhR().field_musicId, h.bic().bhR().field_songName, h.bic().bhR().field_songSinger, h.bic().bhR().field_appId});
            h.mEJ.h(12836, new Object[]{Integer.valueOf(i), r0.field_musicId, r0.field_songName, r0.field_songSinger, r0.field_appId});
        }
    }

    public static void a(int i, a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat music is null, err");
            return;
        }
        x.i("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat scene:%d, action:%d, src:%s, title:%s, singer:%s", new Object[]{Integer.valueOf(aVar.field_musicType), Integer.valueOf(i), aVar.field_songWifiUrl, aVar.field_songName, aVar.field_songSinger});
        h.mEJ.h(15106, new Object[]{Integer.valueOf(aVar.field_musicType), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()), aVar.field_songWifiUrl, aVar.field_songName, aVar.field_songSinger});
    }
}
