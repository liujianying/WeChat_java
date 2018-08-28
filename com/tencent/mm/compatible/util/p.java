package com.tencent.mm.compatible.util;

import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.BitSet;

public final class p {
    static BitSet dgI = new BitSet(256);
    static String dgJ;

    static {
        int i;
        dgJ = null;
        for (i = 97; i <= TbsListener$ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR; i++) {
            dgI.set(i);
        }
        for (i = 65; i <= 90; i++) {
            dgI.set(i);
        }
        for (i = 48; i <= 57; i++) {
            dgI.set(i);
        }
        dgI.set(45);
        dgI.set(95);
        dgI.set(46);
        dgI.set(42);
        dgJ = (String) AccessController.doPrivileged(new i("file.encoding"));
    }

    @Deprecated
    public static String encode(String str) {
        String str2 = null;
        try {
            return encode(str, dgJ);
        } catch (UnsupportedEncodingException e) {
            return str2;
        }
    }

    public static String encode(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        if (str2 == null) {
            throw new NullPointerException("charsetName");
        }
        try {
            Charset forName = Charset.forName(str2);
            Object obj = null;
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (dgI.get(charAt)) {
                    if (charAt == ' ') {
                        obj = 1;
                    }
                    stringBuffer.append((char) charAt);
                    i++;
                } else {
                    int i2 = charAt;
                    BitSet bitSet;
                    do {
                        charArrayWriter.write(i2);
                        if (i2 >= 55296 && i2 <= 56319 && i + 1 < str.length()) {
                            char charAt2 = str.charAt(i + 1);
                            if (charAt2 >= 56320 && charAt2 <= 57343) {
                                charArrayWriter.write(charAt2);
                                i++;
                            }
                        }
                        i++;
                        if (i >= str.length()) {
                            break;
                        }
                        bitSet = dgI;
                        i2 = str.charAt(i);
                    } while (!bitSet.get(i2));
                    charArrayWriter.flush();
                    String str3 = new String(charArrayWriter.toCharArray());
                    o oVar = new o();
                    byte[] bytes = str3.getBytes(forName);
                    if (bytes == null) {
                        bytes = str3.getBytes();
                    }
                    for (int i3 = 0; i3 < bytes.length; i3++) {
                        stringBuffer.append('%');
                        charAt = Character.forDigit((bytes[i3] >> 4) & 15, 16);
                        if (Character.isLetter(charAt)) {
                            charAt = (char) (charAt - 32);
                        }
                        stringBuffer.append(charAt);
                        charAt = Character.forDigit(bytes[i3] & 15, 16);
                        if (Character.isLetter(charAt)) {
                            charAt = (char) (charAt - 32);
                        }
                        stringBuffer.append(charAt);
                    }
                    charArrayWriter.reset();
                    obj = 1;
                }
            }
            return obj != null ? stringBuffer.toString() : str;
        } catch (IllegalCharsetNameException e) {
            throw new UnsupportedEncodingException(str2);
        } catch (UnsupportedCharsetException e2) {
            throw new UnsupportedEncodingException(str2);
        }
    }
}
