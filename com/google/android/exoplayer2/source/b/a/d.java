package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.h.s.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d implements a<c> {
    private static final Pattern auY = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern auZ = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern ava = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern avb = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern avc = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern avd = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern ave = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern avf = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern avh = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern avi = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern avj = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern avk = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern avl = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final Pattern avm = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern avn = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern avo = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern avp = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern avq = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern avr = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern avs = al("AUTOSELECT");
    private static final Pattern avt = al("DEFAULT");
    private static final Pattern avu = al("FORCED");

    private static c a(Uri uri, InputStream inputStream) {
        Closeable bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Queue linkedList = new LinkedList();
        try {
            if (a(bufferedReader)) {
                String readLine;
                c a;
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        readLine = readLine.trim();
                        if (!readLine.isEmpty()) {
                            if (readLine.startsWith("#EXT-X-STREAM-INF")) {
                                linkedList.add(readLine);
                                a = a(new a(linkedList, bufferedReader), uri.toString());
                                t.b(bufferedReader);
                                break;
                            } else if (readLine.startsWith("#EXT-X-TARGETDURATION") || readLine.startsWith("#EXT-X-MEDIA-SEQUENCE") || readLine.startsWith("#EXTINF") || readLine.startsWith("#EXT-X-KEY") || readLine.startsWith("#EXT-X-BYTERANGE") || readLine.equals("#EXT-X-DISCONTINUITY") || readLine.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || readLine.equals("#EXT-X-ENDLIST")) {
                                linkedList.add(readLine);
                                a = b(new a(linkedList, bufferedReader), uri.toString());
                            } else {
                                linkedList.add(readLine);
                            }
                        }
                    } else {
                        t.b(bufferedReader);
                        throw new o("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                linkedList.add(readLine);
                a = b(new a(linkedList, bufferedReader), uri.toString());
                return a;
            }
            b.e("ExoPlayer", "parse, not the #EXTM3U header, uri:%s, reader:%s", new Object[]{uri.toString(), bufferedReader.readLine()});
            throw new n("Input does not start with the #EXTM3U header.", uri);
        } finally {
            t.b(bufferedReader);
        }
    }

    private static boolean a(BufferedReader bufferedReader) {
        int read = bufferedReader.read();
        if (read == ai.CTRL_BYTE) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        char a = a(bufferedReader, true, read);
        for (read = 0; read < 7; read++) {
            if (a != "#EXTM3U".charAt(read)) {
                return false;
            }
            a = bufferedReader.read();
        }
        return t.dd(a(bufferedReader, false, a));
    }

    private static int a(BufferedReader bufferedReader, boolean z, int i) {
        while (i != -1 && Character.isWhitespace(i) && (z || !t.dd(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    private static a a(a aVar, String str) {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Format format = null;
        List list = null;
        int i = 0;
        while (aVar.hasNext()) {
            String next = aVar.next();
            b.i("master ExoPlayer", next, new Object[0]);
            if (next.startsWith("#EXT")) {
                arrayList4.add(next);
            }
            int i2;
            String d;
            String e;
            String e2;
            int parseInt;
            if (next.startsWith("#EXT-X-MEDIA")) {
                i2 = ((f(next, avu) ? 2 : 0) | (f(next, avt) ? 1 : 0)) | (f(next, avs) ? 4 : 0);
                d = d(next, avm);
                e = e(next, avq);
                String d2 = d(next, avp);
                e2 = e(next, avo);
                Object obj = -1;
                switch (e2.hashCode()) {
                    case -959297733:
                        if (e2.equals("SUBTITLES")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case -333210994:
                        if (e2.equals("CLOSED-CAPTIONS")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 62628790:
                        if (e2.equals("AUDIO")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        Format b = Format.b(e, "application/x-mpegURL", i2, d2);
                        if (d != null) {
                            arrayList2.add(new a.a(d, b));
                            break;
                        }
                        format = b;
                        break;
                    case 1:
                        arrayList3.add(new a.a(d, Format.a(e, "application/x-mpegURL", "text/vtt", i2, d2)));
                        break;
                    case 2:
                        String e3 = e(next, avr);
                        if (e3.startsWith("CC")) {
                            d = "application/cea-608";
                            parseInt = Integer.parseInt(e3.substring(2));
                        } else {
                            d = "application/cea-708";
                            parseInt = Integer.parseInt(e3.substring(7));
                        }
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(Format.a(e, null, d, i2, d2, parseInt));
                        break;
                    default:
                        break;
                }
            } else if (next.startsWith("#EXT-X-STREAM-INF")) {
                int i3;
                i2 = b(next, auZ);
                e = d(next, auY);
                if (e != null) {
                    i2 = Integer.parseInt(e);
                }
                d = d(next, ava);
                e = d(next, avb);
                i |= next.contains("CLOSED-CAPTIONS=NONE");
                if (e != null) {
                    String[] split = e.split("x");
                    int parseInt2 = Integer.parseInt(split[0]);
                    int parseInt3 = Integer.parseInt(split[1]);
                    if (parseInt2 <= 0 || parseInt3 <= 0) {
                        parseInt2 = -1;
                        parseInt3 = -1;
                    }
                    parseInt = parseInt3;
                    i3 = parseInt2;
                } else {
                    i3 = -1;
                    parseInt = -1;
                }
                e2 = aVar.next();
                if (hashSet.add(e2)) {
                    arrayList.add(new a.a(e2, Format.a(Integer.toString(arrayList.size()), "application/x-mpegURL", d, i2, i3, parseInt)));
                }
            }
        }
        if (i != 0) {
            list = Collections.emptyList();
        }
        return new a(str, arrayList4, arrayList, arrayList2, arrayList3, format, list);
    }

    private static b b(a aVar, String str) {
        int i = 0;
        long j = -9223372036854775807L;
        int i2 = 0;
        int i3 = 1;
        long j2 = -9223372036854775807L;
        boolean z = false;
        boolean z2 = false;
        b$a b_a = null;
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j3 = 0;
        boolean z3 = false;
        long j4 = 0;
        long j5 = -1;
        boolean z4 = false;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        long j6 = 0;
        long j7 = 0;
        int i5 = 0;
        int i6 = 0;
        while (aVar.hasNext()) {
            String next = aVar.next();
            b.i("ExoPlayer", next, new Object[0]);
            if (next.startsWith("#EXT")) {
                arrayList2.add(next);
            }
            String e;
            int i7;
            String[] split;
            long parseLong;
            long parseLong2;
            if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                e = e(next, ave);
                if ("VOD".equals(e)) {
                    i = 1;
                } else {
                    if ("EVENT".equals(e)) {
                        i7 = 2;
                    } else {
                        i7 = i;
                    }
                    i = i7;
                }
            } else if (next.startsWith("#EXT-X-START")) {
                j = (long) (c(next, avi) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-MAP")) {
                String e2 = e(next, avm);
                e = d(next, avk);
                if (e != null) {
                    split = e.split("@");
                    parseLong = Long.parseLong(split[0]);
                    if (split.length > 1) {
                        j4 = Long.parseLong(split[1]);
                    }
                } else {
                    parseLong = j5;
                }
                b$a b_a2 = new b$a(e2, j4, parseLong);
                j4 = 0;
                j5 = -1;
                b_a = b_a2;
            } else if (next.startsWith("#EXT-X-TARGETDURATION")) {
                j2 = ((long) b(next, avc)) * 1000000;
            } else if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                i7 = b(next, avf);
                i4 = i7;
                i2 = i7;
            } else if (next.startsWith("#EXT-X-VERSION")) {
                i3 = b(next, avd);
            } else if (next.startsWith("#EXTINF")) {
                j3 = (long) (c(next, avh) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-KEY")) {
                z4 = "AES-128".equals(e(next, avl));
                if (z4) {
                    str2 = e(next, avm);
                    str3 = d(next, avn);
                } else {
                    str2 = null;
                    str3 = null;
                }
            } else if (next.startsWith("#EXT-X-BYTERANGE")) {
                split = e(next, avj).split("@");
                j5 = Long.parseLong(split[0]);
                if (split.length > 1) {
                    parseLong2 = Long.parseLong(split[1]);
                } else {
                    parseLong2 = j4;
                }
                j4 = parseLong2;
            } else if (next.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                i6 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                z3 = true;
            } else if (next.equals("#EXT-X-DISCONTINUITY")) {
                i5++;
            } else if (next.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                if (j7 == 0) {
                    j7 = com.google.android.exoplayer2.b.o(t.aD(next.substring(next.indexOf(58) + 1))) - j6;
                }
            } else if (!next.startsWith("#")) {
                String str4;
                long j8;
                if (!z4) {
                    str4 = null;
                } else if (str3 != null) {
                    str4 = str3;
                } else {
                    str4 = Integer.toHexString(i4);
                }
                int i8 = i4 + 1;
                if (j5 == -1) {
                    j8 = 0;
                } else {
                    j8 = j4;
                }
                arrayList.add(new b$a(next, j3, i5, j6, z4, str2, str4, j8, j5));
                parseLong = j6 + j3;
                j3 = 0;
                if (j5 != -1) {
                    parseLong2 = j8 + j5;
                } else {
                    parseLong2 = j8;
                }
                j5 = -1;
                i4 = i8;
                j4 = parseLong2;
                j6 = parseLong;
            } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z = true;
            } else if (next.equals("#EXT-X-ENDLIST")) {
                z2 = true;
            }
        }
        return new b(i, str, arrayList2, j, j7, z3, i6, i2, i3, j2, z, z2, j7 != 0, b_a, arrayList);
    }

    private static int b(String str, Pattern pattern) {
        return Integer.parseInt(e(str, pattern));
    }

    private static double c(String str, Pattern pattern) {
        return Double.parseDouble(e(str, pattern));
    }

    private static String d(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1) : null;
    }

    private static String e(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new o("Couldn't match " + pattern.pattern() + " in " + str);
    }

    private static boolean f(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).equals("YES");
        }
        return false;
    }

    private static Pattern al(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }
}
