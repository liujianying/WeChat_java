package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class f {
    public int oJe = 0;

    public static byte[] v(InputStream inputStream) {
        int i = 0;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        h hVar = new h(inputStream, byteArrayOutputStream);
        hVar.yq(8);
        hVar.yq(8);
        hVar.yq(8);
        hVar.yq(8);
        hVar.yq(8);
        int bJC = (int) hVar.bJC();
        hVar.yq(8);
        hVar.bJC();
        hVar.bJF();
        if (bJC == 100 || bJC == 110 || bJC == TbsListener$ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR || bJC == e.CTRL_INDEX) {
            if (hVar.bJE() == 3) {
                hVar.yq(1);
            }
            hVar.bJF();
            hVar.bJF();
            hVar.yq(1);
            if (hVar.iL(true)) {
                for (bJC = 0; bJC < 8; bJC++) {
                    if (hVar.iL(true)) {
                        if (bJC < 6) {
                            hVar.yr(16);
                        } else {
                            hVar.yr(64);
                        }
                    }
                }
            }
        }
        hVar.bJF();
        bJC = hVar.bJE();
        if (bJC == 0) {
            hVar.bJF();
        } else if (bJC == 1) {
            hVar.yq(1);
            hVar.bJF();
            hVar.bJF();
            int bJE = hVar.bJE();
            for (bJC = 0; bJC < bJE; bJC++) {
                new StringBuilder("SPS: offsetForRefFrame [").append(bJC).append("]");
                hVar.bJF();
            }
        }
        hVar.bJF();
        hVar.yq(1);
        hVar.bJF();
        hVar.bJF();
        if (!hVar.iL(true)) {
            hVar.yq(1);
        }
        hVar.yq(1);
        if (hVar.iL(true)) {
            hVar.bJF();
            hVar.bJF();
            hVar.bJF();
            hVar.bJF();
        }
        if (hVar.iL(false)) {
            x.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
            hVar.iN(true);
            if (hVar.iL(true) && ((int) hVar.bJC()) == 255) {
                hVar.yq(16);
                hVar.yq(16);
            }
            if (hVar.iL(true)) {
                hVar.yq(1);
            }
            if (hVar.iL(true)) {
                hVar.yq(3);
                hVar.yq(1);
                if (hVar.iL(true)) {
                    hVar.yq(8);
                    hVar.yq(8);
                    hVar.yq(8);
                }
            }
            if (hVar.iL(true)) {
                hVar.bJF();
                hVar.bJF();
            }
            if (hVar.iL(true)) {
                hVar.yq(32);
                hVar.yq(32);
                hVar.yq(1);
            }
            boolean iL = hVar.iL(true);
            if (iL) {
                a(hVar);
            }
            boolean iL2 = hVar.iL(true);
            if (iL2) {
                a(hVar);
            }
            if (iL || iL2) {
                hVar.yq(1);
            }
            hVar.yq(1);
            if (hVar.iL(false)) {
                x.d("TAG", "steve:VUI has bs restriction!!");
                hVar.iN(true);
                hVar.iL(true);
                hVar.bJF();
                hVar.bJF();
                hVar.bJF();
                hVar.bJF();
                hVar.bJF();
                hVar.yt(1);
            } else {
                x.d("TAG", "steve:VUI has NO bs restriction!!");
                hVar.iN(true);
                hVar.iN(true);
                hVar.yt(0);
                hVar.yt(0);
                hVar.yt(10);
                hVar.yt(10);
                hVar.yt(0);
                hVar.yt(1);
            }
        } else {
            x.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
            hVar.iN(true);
            hVar.iN(false);
            hVar.iN(false);
            hVar.iN(false);
            hVar.iN(false);
            hVar.iN(false);
            hVar.iN(false);
            hVar.iN(false);
            hVar.iN(false);
            hVar.iN(true);
            hVar.iN(true);
            hVar.yt(0);
            hVar.yt(0);
            hVar.yt(10);
            hVar.yt(10);
            hVar.yt(0);
            hVar.yt(1);
        }
        hVar.ys(1);
        hVar.A(0, 8 - hVar.oJn);
        hVar.flush();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        String str = "";
        while (i < toByteArray.length) {
            String toHexString = Integer.toHexString(toByteArray[i] & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            str = str + " " + toHexString;
            i++;
        }
        x.d("TAG", "new SPS:" + str);
        return toByteArray;
    }

    public final boolean w(InputStream inputStream) {
        h hVar = new h(inputStream);
        hVar.yp(8);
        hVar.yp(8);
        hVar.yp(8);
        hVar.yp(8);
        hVar.yp(8);
        int bJC = (int) hVar.bJC();
        if (bJC == 66) {
            this.oJe |= 1;
            return false;
        }
        hVar.yp(8);
        hVar.bJC();
        hVar.bJF();
        if (bJC == 100 || bJC == 110 || bJC == TbsListener$ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR || bJC == e.CTRL_INDEX) {
            if (hVar.bJE() == 3) {
                hVar.yp(1);
            }
            hVar.bJF();
            hVar.bJF();
            hVar.yp(1);
            if (hVar.iL(true)) {
                for (bJC = 0; bJC < 8; bJC++) {
                    if (hVar.iL(true)) {
                        if (bJC < 6) {
                            hVar.yr(16);
                        } else {
                            hVar.yr(64);
                        }
                    }
                }
            }
        }
        hVar.bJF();
        bJC = hVar.bJE();
        if (bJC == 0) {
            hVar.bJF();
        } else if (bJC == 1) {
            hVar.yp(1);
            hVar.bJF();
            hVar.bJF();
            int bJE = hVar.bJE();
            for (bJC = 0; bJC < bJE; bJC++) {
                new StringBuilder("SPS: offsetForRefFrame [").append(bJC).append("]");
                hVar.bJF();
            }
        }
        if (hVar.bJE() >= 2) {
            this.oJe |= 2;
        }
        hVar.yq(1);
        hVar.bJF();
        hVar.bJF();
        if (!hVar.iL(true)) {
            hVar.yq(1);
        }
        hVar.yq(1);
        if (hVar.iL(true)) {
            hVar.bJF();
            hVar.bJF();
            hVar.bJF();
            hVar.bJF();
        }
        if (!hVar.iL(true)) {
            return false;
        }
        x.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
        if (hVar.iL(true) && ((int) hVar.bJC()) == 255) {
            hVar.yq(16);
            hVar.yq(16);
        }
        if (hVar.iL(true)) {
            hVar.yq(1);
        }
        if (hVar.iL(true)) {
            hVar.yq(3);
            hVar.yq(1);
            if (hVar.iL(true)) {
                hVar.yq(8);
                hVar.yq(8);
                hVar.yq(8);
            }
        }
        if (hVar.iL(true)) {
            hVar.bJF();
            hVar.bJF();
        }
        if (hVar.iL(true)) {
            hVar.yq(32);
            hVar.yq(32);
            hVar.yq(1);
        }
        boolean iL = hVar.iL(true);
        if (iL) {
            a(hVar);
        }
        boolean iL2 = hVar.iL(true);
        if (iL2) {
            a(hVar);
        }
        if (iL || iL2) {
            hVar.yq(1);
        }
        hVar.yq(1);
        if (!hVar.iL(true)) {
            return false;
        }
        hVar.iL(true);
        hVar.bJF();
        hVar.bJF();
        hVar.bJF();
        hVar.bJF();
        bJC = hVar.bJE();
        int bJE2 = hVar.bJE();
        if (bJC == 0) {
            return false;
        }
        x.d("[H264SPSModifier]", "steve: reorder_frame =" + bJC + ", mac_dec_buffering=" + bJE2);
        this.oJe |= 4;
        return true;
    }

    private static void a(h hVar) {
        int bJE = hVar.bJE();
        hVar.yp(4);
        hVar.yp(4);
        for (int i = 0; i <= bJE; i++) {
            hVar.bJF();
            hVar.bJF();
            hVar.yp(1);
        }
        hVar.yp(5);
        hVar.yp(5);
        hVar.yp(5);
        hVar.yp(5);
    }
}
