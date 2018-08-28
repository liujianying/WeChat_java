package com.tencent.mm.plugin.music.model.b;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;
import com.tencent.mm.plugin.music.model.a.b;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements Runnable {
    public com.tencent.mm.an.a bTF;
    public int dAa = 0;
    public boolean iXC;
    public boolean isStop = true;
    public float lyF;
    private long lyG = 307200;
    public int lyH = -1;
    public b lyI;
    public String mimeType = "";

    public a(com.tencent.mm.an.a aVar) {
        this.bTF = aVar;
        this.iXC = ao.isWifi(ad.getContext());
    }

    public final void start() {
        if (this.isStop) {
            this.isStop = false;
            e.post(this, "music_download_thread");
        }
    }

    public final void run() {
        Throwable e;
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        if (!this.isStop) {
            boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
            this.dAa = 0;
            this.lyH = 0;
            if (isNetworkConnected) {
                String Iw;
                boolean Ik;
                String Iy;
                long j;
                long j2;
                long j3;
                Object obj;
                if (this.iXC) {
                    Iw = b.Iw(this.bTF.playUrl);
                    Ik = com.tencent.mm.plugin.music.cache.e.Ik(Iw);
                    x.i("MicroMsg.Music.MusicDownloadTask", "contain shake tag downloadUrl:%s", new Object[]{Iw});
                    Iy = b.Iy(Iw);
                    j = this.bTF.field_wifiDownloadedLength;
                    j2 = this.bTF.field_songWifiFileLength;
                    if (j2 != 0) {
                        this.lyG = j2 / 4;
                    }
                    if (j < this.lyG) {
                        j3 = this.lyG;
                    } else {
                        j3 = (long) (((float) j) + (0.15f * ((float) this.bTF.field_songWifiFileLength)));
                    }
                    obj = this.bTF.field_wifiEndFlag == 1 ? 1 : null;
                } else {
                    Iy = b.Iw(this.bTF.playUrl);
                    Ik = false;
                    j = this.bTF.field_downloadedLength;
                    j2 = this.bTF.field_songFileLength;
                    if (j2 != 0) {
                        this.lyG = j2 / 4;
                    }
                    if (j < this.lyG) {
                        j3 = this.lyG;
                    } else {
                        j3 = (long) (((float) j) + (0.15f * ((float) this.bTF.field_songFileLength)));
                    }
                    obj = this.bTF.field_endFlag == 1 ? 1 : null;
                }
                if (this.lyG < 256000) {
                    this.lyG = 256000;
                    x.i("MicroMsg.Music.MusicDownloadTask", "music firstTimeDownloadSize is less than startPlayLength, update firstTimeDownloadSize");
                }
                File file = new File(com.tencent.mm.plugin.music.d.a.g(this.bTF, this.iXC));
                if (!file.exists()) {
                    try {
                        x.i("MicroMsg.Music.MusicDownloadTask", "create file:%b", new Object[]{Boolean.valueOf(file.createNewFile())});
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2, " createNewFile fail, path:%s", new Object[]{file.getAbsolutePath()});
                    }
                    j = 0;
                    j3 = this.lyG;
                    obj = null;
                    x.i("MicroMsg.Music.MusicDownloadTask", "music file delete and create again %d", new Object[]{Long.valueOf(j3)});
                }
                x.i("MicroMsg.Music.MusicDownloadTask", "downloadLength=%d musicFile.Length=%d endRange=%d", new Object[]{Long.valueOf(j), Long.valueOf(file.length()), Long.valueOf(j3)});
                if ((j >= this.lyG && this.lyF == 0.0f) || r4 != null) {
                    x.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                    this.isStop = true;
                    ah.A(new a(this, 1));
                } else if (bi.oW(Iy)) {
                    x.e("MicroMsg.Music.MusicDownloadTask", "downloadUrl is null");
                    this.isStop = true;
                    ah.A(new a(this, -2));
                } else {
                    InputStream inputStream2 = null;
                    RandomAccessFile randomAccessFile2;
                    u l;
                    try {
                        if (file.exists()) {
                            randomAccessFile2 = new RandomAccessFile(file, "rws");
                            try {
                                x.i("MicroMsg.Music.MusicDownloadTask", "create connection %s", new Object[]{Iy});
                                Map hashMap = new HashMap(10);
                                hashMap.put("Accept-Encoding", "gzip, deflate");
                                if (j3 > j) {
                                    x.d("MicroMsg.Music.MusicDownloadTask", "range : %d-%d", new Object[]{Long.valueOf(j), Long.valueOf(j3)});
                                    hashMap.put("range", "bytes=" + j + "-" + j3);
                                }
                                if (Ik || com.tencent.mm.plugin.music.d.b.IG(Iy)) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "set cookie");
                                    hashMap.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
                                    hashMap.put("referer", "stream12.qqmusic.qq.com");
                                }
                                hashMap.put("user-agent", System.getProperty("http.agent") + " Built-in music  MicroMessenger/" + g.dV(ad.getContext()));
                                l = l(Iy, hashMap);
                                try {
                                    int responseCode = l.getResponseCode();
                                    if (responseCode == m.CTRL_INDEX || responseCode == 206) {
                                        String str;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "getResponseCode:%d", new Object[]{Integer.valueOf(responseCode)});
                                        x.d("MicroMsg.Music.MusicDownloadTask", "user-agent: " + l.aBv.getRequestProperty("user-agent"));
                                        x.i("MicroMsg.Music.MusicDownloadTask", "ContentType:%s", new Object[]{l.aBv.getContentType()});
                                        this.mimeType = Iw;
                                        if (!TextUtils.isEmpty(this.mimeType) && TextUtils.isEmpty(this.bTF.field_mimetype)) {
                                            this.bTF.field_mimetype = this.mimeType;
                                            com.tencent.mm.plugin.music.model.f.a bid = h.bid();
                                            String str2 = this.bTF.field_musicId;
                                            str = this.mimeType;
                                            ContentValues contentValues = new ContentValues();
                                            contentValues.put("mimetype", str);
                                            bid.diF.update("Music", contentValues, "musicId=?", new String[]{str2});
                                            com.tencent.mm.an.a aVar = (com.tencent.mm.an.a) bid.lzX.get(str2);
                                            if (aVar != null) {
                                                aVar.field_mimetype = str;
                                            }
                                        }
                                        long[] Iz = Iz(l.getHeaderField("Content-Range"));
                                        x.i("MicroMsg.Music.MusicDownloadTask", "content-range: %s contentLen=%d", new Object[]{str, Long.valueOf(bi.getLong(l.getHeaderField("Content-Length"), 0))});
                                        if (Iz == null) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not support range feature");
                                            if (j != 0) {
                                                j = 0;
                                            }
                                            j2 = j3;
                                        } else {
                                            if (j > 0) {
                                                if (j != Iz[0]) {
                                                    x.e("MicroMsg.Music.MusicDownloadTask", "return http error, need to download again");
                                                    tD(6);
                                                    if (j2 == 0 && j > 0) {
                                                        x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                                        try {
                                                            randomAccessFile2.setLength(j);
                                                        } catch (Throwable e22) {
                                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22, " music raf close fail", new Object[0]);
                                                        }
                                                        ed(j);
                                                        if (j < 256000) {
                                                            ah.A(new a(this, 1));
                                                        }
                                                    } else if (j2 != 0 && j != j2) {
                                                        x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                                        y(j, j2);
                                                    } else if (j2 == 0 || j != j2) {
                                                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                                    } else {
                                                        x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                                        ed(j2);
                                                        if (j < 256000) {
                                                            ah.A(new a(this, 1));
                                                        }
                                                    }
                                                    try {
                                                        randomAccessFile2.close();
                                                    } catch (Throwable e222) {
                                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222, " music raf close fail", new Object[0]);
                                                    }
                                                    if (l != null) {
                                                        l.aBv.disconnect();
                                                    }
                                                    this.isStop = true;
                                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                                    return;
                                                }
                                            }
                                            j2 = Iz[2];
                                        }
                                        j3 = 10000000;
                                        if (j2 != 0) {
                                            j3 = j2;
                                        }
                                        x.i("MicroMsg.Music.MusicDownloadTask", "fileLen=%d downloadLength=%d", new Object[]{Long.valueOf(j3), Long.valueOf(j)});
                                        randomAccessFile2.setLength(j3);
                                        randomAccessFile2.seek(j);
                                        InputStream inputStream3 = l.getInputStream();
                                        try {
                                            byte[] bArr = new byte[4096];
                                            while (!this.isStop) {
                                                int read = inputStream3.read(bArr);
                                                if (read <= 0) {
                                                    x.e("MicroMsg.Music.MusicDownloadTask", "read length:%d, isStop:%b, downloadLength:%d, realFileLength:%d", new Object[]{Integer.valueOf(read), Boolean.valueOf(this.isStop), Long.valueOf(j), Long.valueOf(j3)});
                                                    break;
                                                }
                                                randomAccessFile2.write(bArr, 0, read);
                                                j += (long) read;
                                                x.v("MicroMsg.Music.MusicDownloadTask", "update updateCurrentDownloadLength %d %d", new Object[]{Long.valueOf(j), Long.valueOf(j3)});
                                                if (this.iXC) {
                                                    this.bTF.field_wifiDownloadedLength = j;
                                                    this.bTF.field_songWifiFileLength = j3;
                                                } else {
                                                    this.bTF.field_downloadedLength = j;
                                                    this.bTF.field_songFileLength = j3;
                                                }
                                                if (j >= 256000) {
                                                    ah.A(new a(this, 1));
                                                }
                                            }
                                            if (j2 == 0 && j > 0) {
                                                x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                                try {
                                                    randomAccessFile2.setLength(j);
                                                } catch (Throwable e2222) {
                                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222, " music raf close fail", new Object[0]);
                                                }
                                                ed(j);
                                                if (j < 256000) {
                                                    ah.A(new a(this, 1));
                                                }
                                            } else if (j2 != 0 && j != j2) {
                                                x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                                y(j, j2);
                                            } else if (j2 == 0 || j != j2) {
                                                x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                            } else {
                                                x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                                ed(j2);
                                                if (j < 256000) {
                                                    ah.A(new a(this, 1));
                                                }
                                            }
                                            if (inputStream3 != null) {
                                                try {
                                                    inputStream3.close();
                                                } catch (Throwable e22222) {
                                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222, " music is close fail", new Object[0]);
                                                }
                                            }
                                            try {
                                                randomAccessFile2.close();
                                            } catch (Throwable e222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222, " music raf close fail", new Object[0]);
                                            }
                                            if (l != null) {
                                                l.aBv.disconnect();
                                            }
                                            this.isStop = true;
                                            x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                            return;
                                        } catch (ProtocolException e3) {
                                            e222222 = e3;
                                            randomAccessFile = randomAccessFile2;
                                            inputStream = inputStream3;
                                        } catch (NoRouteToHostException e4) {
                                            e222222 = e4;
                                            inputStream2 = inputStream3;
                                        } catch (UnknownServiceException e5) {
                                            e222222 = e5;
                                            inputStream2 = inputStream3;
                                        } catch (IOException e6) {
                                            e222222 = e6;
                                            inputStream2 = inputStream3;
                                        } catch (Exception e7) {
                                            e222222 = e7;
                                            inputStream2 = inputStream3;
                                        } catch (Throwable th) {
                                            e222222 = th;
                                            inputStream2 = inputStream3;
                                        }
                                    } else {
                                        tC(responseCode);
                                        x.e("MicroMsg.Music.MusicDownloadTask", "music http req error responseCode:%d", new Object[]{Integer.valueOf(responseCode)});
                                        this.lyH = responseCode;
                                        tD(-1);
                                        if (j2 == 0 && j > 0) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile2.setLength(j);
                                            } catch (Throwable e2222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222, " music raf close fail", new Object[0]);
                                            }
                                            ed(j);
                                            if (j < 256000) {
                                                ah.A(new a(this, 1));
                                            }
                                        } else if (j2 != 0 && j != j2) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            y(j, j2);
                                        } else if (j2 == 0 || j != j2) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        } else {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            ed(j2);
                                            if (j < 256000) {
                                                ah.A(new a(this, 1));
                                            }
                                        }
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Throwable e22222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222, " music raf close fail", new Object[0]);
                                        }
                                        if (l != null) {
                                            l.aBv.disconnect();
                                        }
                                        this.isStop = true;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        return;
                                    }
                                } catch (ProtocolException e8) {
                                    e22222222 = e8;
                                    randomAccessFile = randomAccessFile2;
                                    inputStream = null;
                                } catch (NoRouteToHostException e9) {
                                    e22222222 = e9;
                                    try {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                        this.dAa = 751;
                                        tD(5);
                                        if (j2 != 0 && j > 0) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile2.setLength(j);
                                            } catch (Throwable e222222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222, " music raf close fail", new Object[0]);
                                            }
                                            ed(j);
                                            if (j < 256000) {
                                                ah.A(new a(this, 1));
                                            }
                                        } else if (j2 == 0 && j != j2) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            y(j, j2);
                                        } else if (j2 == 0 && j == j2) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            ed(j2);
                                            if (j < 256000) {
                                                ah.A(new a(this, 1));
                                            }
                                        } else {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Throwable e2222222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222, " music is close fail", new Object[0]);
                                            }
                                        }
                                        if (randomAccessFile2 != null) {
                                            try {
                                                randomAccessFile2.close();
                                            } catch (Throwable e22222222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222, " music raf close fail", new Object[0]);
                                            }
                                        }
                                        if (l != null) {
                                            l.aBv.disconnect();
                                        }
                                        this.isStop = true;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                    } catch (Throwable th2) {
                                        e22222222222 = th2;
                                        if (j2 != 0 && j > 0) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile2.setLength(j);
                                            } catch (Throwable e10) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e10, " music raf close fail", new Object[0]);
                                            }
                                            ed(j);
                                            if (j < 256000) {
                                                ah.A(new a(this, 1));
                                            }
                                        } else if (j2 == 0 && j != j2) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            y(j, j2);
                                        } else if (j2 == 0 && j == j2) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            ed(j2);
                                            if (j < 256000) {
                                                ah.A(new a(this, 1));
                                            }
                                        } else {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Throwable e102) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e102, " music is close fail", new Object[0]);
                                            }
                                        }
                                        if (randomAccessFile2 != null) {
                                            try {
                                                randomAccessFile2.close();
                                            } catch (Throwable e1022) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e1022, " music raf close fail", new Object[0]);
                                            }
                                        }
                                        if (l != null) {
                                            l.aBv.disconnect();
                                        }
                                        this.isStop = true;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        throw e22222222222;
                                    }
                                } catch (UnknownServiceException e11) {
                                    e22222222222 = e11;
                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                    this.dAa = 752;
                                    tD(5);
                                    if (j2 != 0 && j > 0) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                        try {
                                            randomAccessFile2.setLength(j);
                                        } catch (Throwable e222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222, " music raf close fail", new Object[0]);
                                        }
                                        ed(j);
                                        if (j < 256000) {
                                            ah.A(new a(this, 1));
                                        }
                                    } else if (j2 == 0 && j != j2) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        y(j, j2);
                                    } else if (j2 == 0 && j == j2) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        ed(j2);
                                        if (j < 256000) {
                                            ah.A(new a(this, 1));
                                        }
                                    } else {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e2222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Throwable e22222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (l != null) {
                                        l.aBv.disconnect();
                                    }
                                    this.isStop = true;
                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                } catch (IOException e12) {
                                    e22222222222222 = e12;
                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                    this.dAa = 753;
                                    tD(5);
                                    if (j2 != 0 && j > 0) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                        try {
                                            randomAccessFile2.setLength(j);
                                        } catch (Throwable e222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222, " music raf close fail", new Object[0]);
                                        }
                                        ed(j);
                                        if (j < 256000) {
                                            ah.A(new a(this, 1));
                                        }
                                    } else if (j2 == 0 && j != j2) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        y(j, j2);
                                    } else if (j2 == 0 && j == j2) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        ed(j2);
                                        if (j < 256000) {
                                            ah.A(new a(this, 1));
                                        }
                                    } else {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e2222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Throwable e22222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (l != null) {
                                        l.aBv.disconnect();
                                    }
                                    this.isStop = true;
                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                } catch (Exception e13) {
                                    e22222222222222222 = e13;
                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                    this.dAa = 754;
                                    tD(5);
                                    if (j2 != 0 && j > 0) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                        try {
                                            randomAccessFile2.setLength(j);
                                        } catch (Throwable e222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222, " music raf close fail", new Object[0]);
                                        }
                                        ed(j);
                                        if (j < 256000) {
                                            ah.A(new a(this, 1));
                                        }
                                    } else if (j2 == 0 && j != j2) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        y(j, j2);
                                    } else if (j2 == 0 && j == j2) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        ed(j2);
                                        if (j < 256000) {
                                            ah.A(new a(this, 1));
                                        }
                                    } else {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e2222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Throwable e22222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (l != null) {
                                        l.aBv.disconnect();
                                    }
                                    this.isStop = true;
                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                }
                            } catch (ProtocolException e14) {
                                e22222222222222222222 = e14;
                                randomAccessFile = randomAccessFile2;
                                inputStream = null;
                                l = null;
                                try {
                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                    this.dAa = 750;
                                    tD(5);
                                    if (j2 != 0 && j > 0) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                        try {
                                            randomAccessFile.setLength(j);
                                        } catch (Throwable e222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222, " music raf close fail", new Object[0]);
                                        }
                                        ed(j);
                                        if (j < 256000) {
                                            ah.A(new a(this, 1));
                                        }
                                    } else if (j2 == 0 && j != j2) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        y(j, j2);
                                    } else if (j2 == 0 && j == j2) {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        ed(j2);
                                        if (j < 256000) {
                                            ah.A(new a(this, 1));
                                        }
                                    } else {
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable e2222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable e22222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (l != null) {
                                        l.aBv.disconnect();
                                    }
                                    this.isStop = true;
                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                } catch (Throwable th3) {
                                    e22222222222222222222222 = th3;
                                    randomAccessFile2 = randomAccessFile;
                                    inputStream2 = inputStream;
                                    if (j2 != 0) {
                                    }
                                    if (j2 == 0) {
                                    }
                                    if (j2 == 0) {
                                    }
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e10222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e10222, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Throwable e102222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e102222, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (l != null) {
                                        l.aBv.disconnect();
                                    }
                                    this.isStop = true;
                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                    throw e22222222222222222222222;
                                }
                            } catch (NoRouteToHostException e15) {
                                e22222222222222222222222 = e15;
                                l = null;
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                this.dAa = 751;
                                tD(5);
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable e222222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222, " music is close fail", new Object[0]);
                                    }
                                }
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Throwable e2222222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                }
                                if (l != null) {
                                    l.aBv.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            } catch (UnknownServiceException e16) {
                                e2222222222222222222222222 = e16;
                                l = null;
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                this.dAa = 752;
                                tD(5);
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable e22222222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222222, " music is close fail", new Object[0]);
                                    }
                                }
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Throwable e222222222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                }
                                if (l != null) {
                                    l.aBv.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            } catch (IOException e17) {
                                e222222222222222222222222222 = e17;
                                l = null;
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                this.dAa = 753;
                                tD(5);
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable e2222222222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222222222, " music is close fail", new Object[0]);
                                    }
                                }
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Throwable e22222222222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                }
                                if (l != null) {
                                    l.aBv.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            } catch (Exception e18) {
                                e22222222222222222222222222222 = e18;
                                l = null;
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                this.dAa = 754;
                                tD(5);
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable e222222222222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222222222, " music is close fail", new Object[0]);
                                    }
                                }
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Throwable e2222222222222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                }
                                if (l != null) {
                                    l.aBv.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            } catch (Throwable th4) {
                                e2222222222222222222222222222222 = th4;
                                l = null;
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable e1022222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e1022222, " music is close fail", new Object[0]);
                                    }
                                }
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Throwable e10222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e10222222, " music raf close fail", new Object[0]);
                                    }
                                }
                                if (l != null) {
                                    l.aBv.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                throw e2222222222222222222222222222222;
                            }
                        }
                        this.isStop = true;
                        x.e("MicroMsg.Music.MusicDownloadTask", "create fail or musicFile not exist, musicFile:%s", new Object[]{file.getAbsolutePath()});
                        tD(19);
                        if (j2 == 0 && j > 0) {
                            x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                            RandomAccessFile randomAccessFile3 = null;
                            try {
                                randomAccessFile3.setLength(j);
                            } catch (Throwable e22222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222222222222, " music raf close fail", new Object[0]);
                            }
                            ed(j);
                            if (j < 256000) {
                                ah.A(new a(this, 1));
                            }
                        } else if (j2 != 0 && j != j2) {
                            x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                            y(j, j2);
                        } else if (j2 == 0 || j != j2) {
                            x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        } else {
                            x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                            ed(j2);
                            if (j < 256000) {
                                ah.A(new a(this, 1));
                            }
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (ProtocolException e19) {
                        e22222222222222222222222222222222 = e19;
                        randomAccessFile = null;
                        inputStream = null;
                        l = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.dAa = 750;
                        tD(5);
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222222222222, " music is close fail", new Object[0]);
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e2222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222222222222222, " music raf close fail", new Object[0]);
                            }
                        }
                        if (l != null) {
                            l.aBv.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (NoRouteToHostException e20) {
                        e2222222222222222222222222222222222 = e20;
                        randomAccessFile2 = null;
                        l = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.dAa = 751;
                        tD(5);
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable e22222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222222222222222, " music is close fail", new Object[0]);
                            }
                        }
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable e222222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222222222222222, " music raf close fail", new Object[0]);
                            }
                        }
                        if (l != null) {
                            l.aBv.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (UnknownServiceException e21) {
                        e222222222222222222222222222222222222 = e21;
                        randomAccessFile2 = null;
                        l = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.dAa = 752;
                        tD(5);
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable e2222222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222222222222222222, " music is close fail", new Object[0]);
                            }
                        }
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable e22222222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222222222222222222, " music raf close fail", new Object[0]);
                            }
                        }
                        if (l != null) {
                            l.aBv.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (IOException e23) {
                        e22222222222222222222222222222222222222 = e23;
                        randomAccessFile2 = null;
                        l = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.dAa = 753;
                        tD(5);
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable e222222222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222222222222222222, " music is close fail", new Object[0]);
                            }
                        }
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable e2222222222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222222222222222222222, " music raf close fail", new Object[0]);
                            }
                        }
                        if (l != null) {
                            l.aBv.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (Exception e24) {
                        e2222222222222222222222222222222222222222 = e24;
                        randomAccessFile2 = null;
                        l = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.dAa = 754;
                        tD(5);
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable e22222222222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222222222222222222222, " music is close fail", new Object[0]);
                            }
                        }
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable e222222222222222222222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222222222222222222222, " music raf close fail", new Object[0]);
                            }
                        }
                        if (l != null) {
                            l.aBv.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (Throwable th5) {
                        e222222222222222222222222222222222222222222 = th5;
                        randomAccessFile2 = null;
                        l = null;
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable e102222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e102222222, " music is close fail", new Object[0]);
                            }
                        }
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable e1022222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e1022222222, " music raf close fail", new Object[0]);
                            }
                        }
                        if (l != null) {
                            l.aBv.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                        throw e222222222222222222222222222222222222222222;
                    }
                }
            } else if (this.bTF.field_wifiDownloadedLength != 0 && this.bTF.field_wifiDownloadedLength >= this.lyG && (((float) this.bTF.field_wifiDownloadedLength) / ((float) this.bTF.field_songWifiFileLength)) - this.lyF >= 0.15f) {
                x.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                this.isStop = true;
                this.iXC = true;
                ah.A(new a(this, 1));
            } else if (this.bTF.field_downloadedLength == 0 || this.bTF.field_downloadedLength < this.lyG || (((float) this.bTF.field_downloadedLength) / ((float) this.bTF.field_songFileLength)) - this.lyF < 0.15f) {
                x.i("MicroMsg.Music.MusicDownloadTask", "not connect network");
                this.isStop = true;
                tD(4);
            } else {
                x.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                this.isStop = true;
                this.iXC = false;
                ah.A(new a(this, 1));
            }
        }
    }

    private static u l(String str, Map<String, String> map) {
        u uVar = null;
        int i = 0;
        while (true) {
            if (uVar != null) {
                uVar.aBv.disconnect();
            }
            x.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", new Object[]{str});
            uVar = com.tencent.mm.network.b.a(str, null);
            uVar.setRequestMethod("GET");
            uVar.setConnectTimeout(25000);
            uVar.aBv.setInstanceFollowRedirects(true);
            for (Entry entry : map.entrySet()) {
                uVar.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            int responseCode = uVar.getResponseCode();
            x.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", new Object[]{Integer.valueOf(responseCode), Integer.valueOf(i)});
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303) {
                return uVar;
            }
            tC(responseCode);
            String headerField = uVar.getHeaderField("Location");
            if (headerField == null) {
                x.e("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", new Object[]{Integer.valueOf(responseCode)});
                return uVar;
            }
            URL url = new URL(uVar.aBv.getURL(), headerField);
            x.i("MicroMsg.Music.MusicDownloadTask", "location:%s", new Object[]{headerField});
            x.i("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", new Object[]{url.toString()});
            if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                responseCode = i + 1;
                if (responseCode > 5) {
                    x.e("MicroMsg.Music.MusicDownloadTask", "Too many redirects: " + responseCode);
                    return uVar;
                }
                str = url.toString();
                i = responseCode;
            } else {
                x.e("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", new Object[]{Integer.valueOf(responseCode)});
                return uVar;
            }
        }
    }

    private static void tC(int i) {
        if (i == 300 || i == 301 || i == 302 || i == 303) {
            IDKey iDKey = new IDKey();
            iDKey.SetID(558);
            iDKey.SetKey(15);
            iDKey.SetValue(1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(iDKey);
            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
        }
    }

    private void tD(int i) {
        ah.A(new a(this, i));
    }

    private void ed(long j) {
        if (this.iXC) {
            this.bTF.field_wifiDownloadedLength = j;
            h.bid().aa(this.bTF.field_musicId, j);
            h.bid().bN(this.bTF.field_musicId, 1);
            h.bid().ab(this.bTF.field_musicId, j);
        } else {
            this.bTF.field_downloadedLength = j;
            h.bid().ac(this.bTF.field_musicId, j);
            h.bid().bO(this.bTF.field_musicId, 1);
            h.bid().ad(this.bTF.field_musicId, j);
        }
        ah.A(new a(this, 2));
    }

    private void y(long j, long j2) {
        if (this.iXC) {
            this.bTF.field_wifiDownloadedLength = j;
            h.bid().aa(this.bTF.field_musicId, j);
            h.bid().bN(this.bTF.field_musicId, 0);
            h.bid().ab(this.bTF.field_musicId, j2);
        } else {
            this.bTF.field_downloadedLength = j;
            h.bid().ac(this.bTF.field_musicId, j);
            h.bid().bO(this.bTF.field_musicId, 0);
            h.bid().ad(this.bTF.field_musicId, j2);
        }
        ah.A(new a(this, 3));
    }

    private static long[] Iz(String str) {
        if (bi.oW(str)) {
            return null;
        }
        try {
            String[] split = str.replace("bytes", "").trim().split("-");
            long longValue = Long.valueOf(split[0]).longValue();
            split = split[1].split("/");
            long longValue2 = Long.valueOf(split[0]).longValue();
            long longValue3 = Long.valueOf(split[1]).longValue();
            return new long[]{longValue, longValue2, longValue3};
        } catch (Exception e) {
            return null;
        }
    }
}
