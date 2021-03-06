package com.tencent.mm.plugin.appbrand.s.f;

import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public final class b {
    public static CodingErrorAction gEd = CodingErrorAction.REPORT;

    public static byte[] wc(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            return new byte[0];
        }
    }

    public static byte[] wd(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            return new byte[0];
        }
    }

    public static String G(byte[] bArr, int i) {
        try {
            return new String(bArr, 0, i, "ASCII");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            return "";
        }
    }

    public static String w(ByteBuffer byteBuffer) {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(gEd);
        newDecoder.onUnmappableCharacter(gEd);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (Throwable e) {
            throw new com.tencent.mm.plugin.appbrand.s.c.b(1007, e);
        }
    }
}
