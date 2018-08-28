package com.tencent.mm.plugin.music.model.f;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.music.b;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends i<com.tencent.mm.an.a> {
    public e diF;
    public f<String, com.tencent.mm.an.a> lzX = new f(20);
    public f<String, com.tencent.mm.plugin.music.model.a> lzY = new f(10);

    public a(e eVar) {
        super(eVar, com.tencent.mm.an.a.dhO, "Music", null);
        this.diF = eVar;
    }

    public final com.tencent.mm.an.a IC(String str) {
        if (this.lzX.get(str) != null) {
            return (com.tencent.mm.an.a) this.lzX.get(str);
        }
        String format = String.format("Select * From Music Where musicId=?", new Object[0]);
        Cursor b = this.diF.b(format, new String[]{str}, 2);
        if (b == null || !b.moveToFirst()) {
            if (b != null) {
                b.close();
            }
            return null;
        }
        com.tencent.mm.an.a aVar = new com.tencent.mm.an.a();
        aVar.d(b);
        b.close();
        this.lzX.put(str, aVar);
        return aVar;
    }

    public final com.tencent.mm.plugin.music.model.a e(com.tencent.mm.an.a aVar, boolean z) {
        com.tencent.mm.plugin.music.model.a.a aVar2;
        String str = aVar.field_songLyric;
        String string = ad.getContext().getString(b.e.music_prefix);
        String str2 = aVar.field_songSnsShareUser;
        boolean f = g.f(aVar);
        String str3 = aVar.field_songSinger;
        com.tencent.mm.plugin.music.model.a aVar3 = new com.tencent.mm.plugin.music.model.a();
        long VG = bi.VG();
        if (bi.oW(str)) {
            com.tencent.mm.plugin.music.model.a.a aVar4 = new com.tencent.mm.plugin.music.model.a.a();
            aVar4.timestamp = 0;
            if (z) {
                aVar4.content = str3;
            } else if (f) {
                aVar4.content = ad.getContext().getString(b.e.no_lyric_wording);
            } else {
                aVar4.content = ad.getContext().getString(b.e.no_licence_lyric_wording);
            }
            if (aVar4.content != null) {
                aVar3.lxL.add(aVar4);
            }
        } else {
            if (str != null) {
                int i;
                int i2;
                Matcher matcher = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(str.replaceAll("\n", " ").replaceAll("\r", " "));
                while (matcher.find()) {
                    CharSequence group = matcher.group();
                    matcher.start();
                    matcher.end();
                    if (group == null) {
                        x.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
                    } else if (group.startsWith("[ti:")) {
                        aVar3.title = com.tencent.mm.plugin.music.model.a.dT(group, "[ti:");
                    } else if (group.startsWith("[ar:")) {
                        aVar3.fHZ = com.tencent.mm.plugin.music.model.a.dT(group, "[ar:");
                    } else if (group.startsWith("[al:")) {
                        aVar3.album = com.tencent.mm.plugin.music.model.a.dT(group, "[al:");
                    } else if (group.startsWith("[by:")) {
                        aVar3.lxN = com.tencent.mm.plugin.music.model.a.dT(group, "[by:");
                    } else if (group.startsWith("[offset:")) {
                        aVar3.mb = bi.getLong(com.tencent.mm.plugin.music.model.a.dT(group, "[offset:"), 0);
                    } else if (group.startsWith("[re:")) {
                        aVar3.lxO = com.tencent.mm.plugin.music.model.a.dT(group, "[re:");
                    } else if (group.startsWith("[ve:")) {
                        aVar3.lxP = com.tencent.mm.plugin.music.model.a.dT(group, "[ve:");
                    } else {
                        Pattern compile = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
                        Matcher matcher2 = compile.matcher(group);
                        com.tencent.mm.plugin.music.model.a.a aVar5 = new com.tencent.mm.plugin.music.model.a.a();
                        while (matcher2.find()) {
                            if (matcher2.groupCount() > 0) {
                                aVar5.timestamp = com.tencent.mm.plugin.music.model.a.Ir(matcher2.group(1));
                            }
                            String[] split = compile.split(group);
                            if (split == null || split.length <= 0) {
                                aVar3.lxM.add(Long.valueOf(aVar5.timestamp));
                                break;
                            }
                            String str4 = split[split.length - 1];
                            if (str4 != null) {
                                str4 = str4.trim();
                            }
                            if (bi.oW(str4)) {
                                str4 = " ";
                            }
                            aVar5.content = str4;
                            i = 0;
                            while (true) {
                                i2 = i;
                                if (i2 >= aVar3.lxM.size()) {
                                    break;
                                }
                                com.tencent.mm.plugin.music.model.a.a aVar6 = new com.tencent.mm.plugin.music.model.a.a();
                                aVar6.timestamp = ((Long) aVar3.lxM.get(i2)).longValue();
                                aVar6.content = aVar5.content;
                                aVar6.lxR = true;
                                i = i2 + 1;
                            }
                            aVar3.lxM.clear();
                            i2 = aVar3.lxL.size() - 1;
                            while (i2 >= 0 && ((com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(i2)).timestamp != aVar5.timestamp) {
                                if (((com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(i2)).timestamp < aVar5.timestamp) {
                                    aVar3.lxL.add(i2 + 1, aVar5);
                                    break;
                                }
                                i2--;
                            }
                            if (i2 < 0) {
                                aVar3.lxL.add(0, aVar5);
                            }
                        }
                    }
                }
                x.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[]{Long.valueOf(aVar3.mb)});
                if (aVar3.mb != 0) {
                    i = 0;
                    while (true) {
                        i2 = i;
                        if (i2 >= aVar3.lxL.size()) {
                            break;
                        }
                        aVar2 = (com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(i2);
                        aVar2.timestamp += aVar3.mb;
                        i = i2 + 1;
                    }
                    aVar3.mb = 0;
                }
                i = 0;
                while (true) {
                    int i3 = i;
                    if (i3 >= aVar3.lxL.size() - 1) {
                        break;
                    }
                    aVar2 = (com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(i3);
                    if (aVar2.lxR && aVar2.content.equals(((com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(i3 + 1)).content)) {
                        aVar2.content = " ";
                    }
                    i = i3 + 1;
                }
            } else {
                x.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
            }
            x.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[]{str});
            x.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[]{Integer.valueOf(aVar3.lxL.size())});
        }
        if (bi.oW(str2)) {
            x.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        } else {
            aVar2 = new com.tencent.mm.plugin.music.model.a.a();
            aVar2.timestamp = 0;
            aVar2.content = ad.getContext().getString(b.e.user_share_music, new Object[]{r.gT(str2)});
            if (aVar3.lxL.isEmpty()) {
                aVar3.lxL.add(aVar2);
            } else if (aVar3.lxL.size() == 1) {
                aVar3.lxL.add(0, aVar2);
                ((com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(1)).timestamp = 5000;
            } else {
                aVar3.lxL.add(0, aVar2);
                ((com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(2)).timestamp >> 2);
            }
        }
        if (!bi.oW(str)) {
            if (bi.oW(string)) {
                x.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
            } else {
                aVar2 = new com.tencent.mm.plugin.music.model.a.a();
                aVar2.timestamp = 0;
                aVar2.content = string;
                if (aVar3.lxL.isEmpty()) {
                    aVar3.lxL.add(aVar2);
                } else if (aVar3.lxL.size() == 1) {
                    aVar3.lxL.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(1)).timestamp = 5000;
                } else {
                    aVar3.lxL.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.model.a.a) aVar3.lxL.get(2)).timestamp >> 2);
                }
            }
        }
        x.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[]{Long.valueOf(bi.bI(VG))});
        this.lzY.put(aVar.field_musicId, aVar3);
        return aVar3;
    }

    public final com.tencent.mm.an.a Z(String str, int i, int i2) {
        x.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.an.a IC = IC(str);
        if (IC == null) {
            x.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[]{str});
            return null;
        }
        IC.field_songBgColor = i;
        IC.field_songLyricColor = i2;
        c(IC, new String[]{"songBgColor", "songLyricColor"});
        this.lzX.put(str, IC);
        return IC;
    }

    public final com.tencent.mm.an.a w(avq avq) {
        int i;
        String x = com.tencent.mm.plugin.music.d.a.x(avq);
        com.tencent.mm.an.a IC = IC(x);
        if (IC == null) {
            IC = new com.tencent.mm.an.a();
            i = 0;
        } else {
            i = 1;
        }
        IC.field_musicId = x;
        IC.field_originMusicId = avq.rsp;
        IC.field_musicType = avq.rYj;
        IC.field_appId = avq.jQb;
        if (bi.oW(IC.field_appId)) {
            IC.field_appId = g.j(avq);
        }
        IC.field_songAlbum = avq.rYn;
        IC.field_songAlbumType = avq.rYv;
        IC.field_songWifiUrl = avq.rYp;
        IC.field_songName = avq.rYl;
        IC.field_songSinger = avq.rYm;
        IC.field_songWapLinkUrl = avq.rYq;
        IC.field_songWebUrl = avq.rYr;
        IC.field_songAlbumLocalPath = avq.rYt;
        IC.field_songMediaId = avq.rvP;
        IC.field_songSnsAlbumUser = avq.rYz;
        IC.field_songAlbumUrl = avq.rYo;
        IC.field_songSnsShareUser = avq.rYA;
        if (!bi.oW(avq.rYw)) {
            IC.field_songHAlbumUrl = avq.rYw;
        }
        IC.field_updateTime = System.currentTimeMillis();
        if (IC.field_songId == 0) {
            g.h(avq);
            IC.field_songId = avq.rKe;
        }
        if ((bi.oW(IC.field_songWapLinkUrl) || IC.field_songWapLinkUrl.equals(IC.field_songWebUrl)) && !bi.oW(IC.field_songWifiUrl)) {
            IC.field_songWapLinkUrl = IC.field_songWifiUrl;
        }
        if (IC.field_songId == 0 && avq.rYj == 4) {
            try {
                IC.field_songId = Integer.valueOf(avq.rsp).intValue();
            } catch (Exception e) {
            }
        }
        IC.field_hideBanner = avq.rYC;
        IC.field_jsWebUrlDomain = avq.rYD;
        IC.field_startTime = avq.dGs;
        IC.eaZ = avq.eaZ;
        IC.field_protocol = avq.protocol;
        IC.field_barBackToWebView = avq.rYE;
        IC.field_musicbar_url = avq.rYF;
        if (i != 0) {
            x.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[]{x});
            c(IC, new String[0]);
        } else {
            x.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[]{x});
            b(IC);
        }
        this.lzX.put(x, IC);
        return IC;
    }

    public final void aa(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiDownloadedLength", Long.valueOf(j));
        int update = this.diF.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.an.a aVar = (com.tencent.mm.an.a) this.lzX.get(str);
        if (aVar != null) {
            aVar.field_wifiDownloadedLength = j;
        }
    }

    public final void ab(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songWifiFileLength", Long.valueOf(j));
        int update = this.diF.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.an.a aVar = (com.tencent.mm.an.a) this.lzX.get(str);
        if (aVar != null) {
            aVar.field_songWifiFileLength = j;
        }
    }

    public final void bN(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiEndFlag", Integer.valueOf(i));
        int update = this.diF.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
        com.tencent.mm.an.a aVar = (com.tencent.mm.an.a) this.lzX.get(str);
        if (aVar != null) {
            aVar.field_wifiEndFlag = i;
        }
    }

    public final void ac(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadedLength", Long.valueOf(j));
        int update = this.diF.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.an.a aVar = (com.tencent.mm.an.a) this.lzX.get(str);
        if (aVar != null) {
            aVar.field_downloadedLength = j;
        }
    }

    public final void bO(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("endFlag", Integer.valueOf(i));
        int update = this.diF.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
        com.tencent.mm.an.a aVar = (com.tencent.mm.an.a) this.lzX.get(str);
        if (aVar != null) {
            aVar.field_endFlag = i;
        }
    }

    public final void ad(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songFileLength", Long.valueOf(j));
        int update = this.diF.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.an.a aVar = (com.tencent.mm.an.a) this.lzX.get(str);
        if (aVar != null) {
            aVar.field_songFileLength = j;
        }
    }
}
