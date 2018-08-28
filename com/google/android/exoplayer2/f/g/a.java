package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.i.d;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a {
    private static final Pattern azs = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final j azt = new j();
    private final StringBuilder azu = new StringBuilder();

    public final d g(j jVar) {
        String str;
        int i;
        int i2;
        this.azu.setLength(0);
        int i3 = jVar.position;
        do {
        } while (!TextUtils.isEmpty(jVar.readLine()));
        this.azt.m(jVar.data, jVar.position);
        this.azt.setPosition(i3);
        j jVar2 = this.azt;
        StringBuilder stringBuilder = this.azu;
        h(jVar2);
        if (jVar2.me() < 5) {
            str = null;
        } else {
            if ("::cue".equals(jVar2.readString(5))) {
                i3 = jVar2.position;
                String a = a(jVar2, stringBuilder);
                if (a == null) {
                    str = null;
                } else if ("{".equals(a)) {
                    jVar2.setPosition(i3);
                    str = "";
                } else {
                    if ("(".equals(a)) {
                        i3 = jVar2.position;
                        int i4 = jVar2.limit;
                        int i5 = i3;
                        i = 0;
                        while (i5 < i4 && i == 0) {
                            i2 = i5 + 1;
                            boolean z = ((char) jVar2.data[i5]) == ')';
                            i5 = i2;
                            boolean i6 = z;
                        }
                        str = jVar2.readString((i5 - 1) - jVar2.position).trim();
                    } else {
                        str = null;
                    }
                    a = a(jVar2, stringBuilder);
                    if (!")".equals(a) || a == null) {
                        str = null;
                    }
                }
            } else {
                str = null;
            }
        }
        if (str == null || !"{".equals(a(this.azt, this.azu))) {
            return null;
        }
        d dVar = new d();
        if (!"".equals(str)) {
            i2 = str.indexOf(91);
            if (i2 != -1) {
                Matcher matcher = azs.matcher(str.substring(i2));
                if (matcher.matches()) {
                    dVar.azC = matcher.group(1);
                }
                str = str.substring(0, i2);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            i6 = str2.indexOf(35);
            if (i6 != -1) {
                dVar.azA = str2.substring(0, i6);
                dVar.azz = str2.substring(i6 + 1);
            } else {
                dVar.azA = str2;
            }
            if (split.length > 1) {
                dVar.azB = Arrays.asList((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
        i3 = 0;
        Object obj = null;
        while (i3 == 0) {
            i6 = this.azt.position;
            obj = a(this.azt, this.azu);
            if (obj == null || "}".equals(obj)) {
                i3 = true;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.azt.setPosition(i6);
                jVar2 = this.azt;
                stringBuilder = this.azu;
                h(jVar2);
                String b = b(jVar2, stringBuilder);
                if (!"".equals(b) && ":".equals(a(jVar2, stringBuilder))) {
                    String str3;
                    h(jVar2);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    i6 = 0;
                    while (i6 == 0) {
                        int i7 = jVar2.position;
                        String a2 = a(jVar2, stringBuilder);
                        if (a2 == null) {
                            str3 = null;
                            break;
                        } else if ("}".equals(a2) || ";".equals(a2)) {
                            jVar2.setPosition(i7);
                            i6 = true;
                        } else {
                            stringBuilder2.append(a2);
                        }
                    }
                    str3 = stringBuilder2.toString();
                    if (!(str3 == null || "".equals(str3))) {
                        int i8 = jVar2.position;
                        String a3 = a(jVar2, stringBuilder);
                        if (!";".equals(a3)) {
                            if ("}".equals(a3)) {
                                jVar2.setPosition(i8);
                            }
                        }
                        if ("color".equals(b)) {
                            dVar.ayT = d.as(str3);
                            dVar.ayU = true;
                        } else if ("background-color".equals(b)) {
                            dVar.backgroundColor = d.as(str3);
                            dVar.ayV = true;
                        } else if ("text-decoration".equals(b)) {
                            if ("underline".equals(str3)) {
                                dVar.ayX = 1;
                            }
                        } else if ("font-family".equals(b)) {
                            dVar.ayS = t.aC(str3);
                        } else if ("font-weight".equals(b)) {
                            if ("bold".equals(str3)) {
                                dVar.ayY = 1;
                            }
                        } else if ("font-style".equals(b) && "italic".equals(str3)) {
                            dVar.ayZ = 1;
                        }
                    }
                }
            }
        }
        if ("}".equals(obj)) {
            return dVar;
        }
        return null;
    }

    private static void h(j jVar) {
        int i = 1;
        while (jVar.me() > 0 && i != 0) {
            switch ((char) jVar.data[jVar.position]) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    jVar.da(1);
                    i = 1;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (i == 0) {
                int i2 = jVar.position;
                i = jVar.limit;
                byte[] bArr = jVar.data;
                if (i2 + 2 <= i) {
                    int i3 = i2 + 1;
                    if (bArr[i2] == (byte) 47) {
                        int i4 = i3 + 1;
                        if (bArr[i3] == (byte) 42) {
                            while (i4 + 1 < i) {
                                i2 = i4 + 1;
                                if (((char) bArr[i4]) == '*' && ((char) bArr[i2]) == '/') {
                                    i2++;
                                    i = i2;
                                    i4 = i2;
                                } else {
                                    i4 = i2;
                                }
                            }
                            jVar.da(i - jVar.position);
                            i = 1;
                            if (i == 0) {
                                i = 0;
                            }
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                    i = 0;
                }
            }
            i = 1;
        }
    }

    private static String a(j jVar, StringBuilder stringBuilder) {
        h(jVar);
        if (jVar.me() == 0) {
            return null;
        }
        String b = b(jVar, stringBuilder);
        return "".equals(b) ? ((char) jVar.readUnsignedByte()) : b;
    }

    private static String b(j jVar, StringBuilder stringBuilder) {
        int i = 0;
        stringBuilder.setLength(0);
        int i2 = jVar.position;
        int i3 = jVar.limit;
        while (i2 < i3 && i == 0) {
            char c = (char) jVar.data[i2];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                i = 1;
            } else {
                i2++;
                stringBuilder.append(c);
            }
        }
        jVar.da(i2 - jVar.position);
        return stringBuilder.toString();
    }
}
