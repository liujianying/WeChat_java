package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.i.t;

abstract class a {
    public static final int ajA = t.aE("sowt");
    public static final int ajB = t.aE("ac-3");
    public static final int ajC = t.aE("dac3");
    public static final int ajD = t.aE("ec-3");
    public static final int ajE = t.aE("dec3");
    public static final int ajF = t.aE("dtsc");
    public static final int ajG = t.aE("dtsh");
    public static final int ajH = t.aE("dtsl");
    public static final int ajI = t.aE("dtse");
    public static final int ajJ = t.aE("ddts");
    public static final int ajK = t.aE("tfdt");
    public static final int ajL = t.aE("tfhd");
    public static final int ajM = t.aE("trex");
    public static final int ajN = t.aE("trun");
    public static final int ajO = t.aE("sidx");
    public static final int ajP = t.aE("moov");
    public static final int ajQ = t.aE("mvhd");
    public static final int ajR = t.aE("trak");
    public static final int ajS = t.aE("mdia");
    public static final int ajT = t.aE("minf");
    public static final int ajU = t.aE("stbl");
    public static final int ajV = t.aE("avcC");
    public static final int ajW = t.aE("hvcC");
    public static final int ajX = t.aE("esds");
    public static final int ajY = t.aE("moof");
    public static final int ajZ = t.aE("traf");
    public static final int ajo = t.aE("ftyp");
    public static final int ajp = t.aE("avc1");
    public static final int ajq = t.aE("avc3");
    public static final int ajr = t.aE("hvc1");
    public static final int ajs = t.aE("hev1");
    public static final int ajt = t.aE("s263");
    public static final int aju = t.aE("d263");
    public static final int ajv = t.aE("mdat");
    public static final int ajw = t.aE("mp4a");
    public static final int ajx = t.aE(".mp3");
    public static final int ajy = t.aE("wave");
    public static final int ajz = t.aE("lpcm");
    public static final int akA = t.aE("stts");
    public static final int akB = t.aE("stss");
    public static final int akC = t.aE("ctts");
    public static final int akD = t.aE("stsc");
    public static final int akE = t.aE("stsz");
    public static final int akF = t.aE("stz2");
    public static final int akG = t.aE("stco");
    public static final int akH = t.aE("co64");
    public static final int akI = t.aE("tx3g");
    public static final int akJ = t.aE("wvtt");
    public static final int akK = t.aE("stpp");
    public static final int akL = t.aE("c608");
    public static final int akM = t.aE("samr");
    public static final int akN = t.aE("sawb");
    public static final int akO = t.aE("udta");
    public static final int akP = t.aE("meta");
    public static final int akQ = t.aE("ilst");
    public static final int akR = t.aE("mean");
    public static final int akS = t.aE("name");
    public static final int akT = t.aE("data");
    public static final int akU = t.aE("emsg");
    public static final int akV = t.aE("st3d");
    public static final int akW = t.aE("sv3d");
    public static final int akX = t.aE("proj");
    public static final int akY = t.aE("vp08");
    public static final int akZ = t.aE("vp09");
    public static final int aka = t.aE("mvex");
    public static final int akb = t.aE("mehd");
    public static final int akc = t.aE("tkhd");
    public static final int akd = t.aE("edts");
    public static final int ake = t.aE("elst");
    public static final int akf = t.aE("mdhd");
    public static final int akg = t.aE("hdlr");
    public static final int akh = t.aE("stsd");
    public static final int aki = t.aE("pssh");
    public static final int akj = t.aE("sinf");
    public static final int akk = t.aE("schm");
    public static final int akl = t.aE("schi");
    public static final int akm = t.aE("tenc");
    public static final int akn = t.aE("encv");
    public static final int ako = t.aE("enca");
    public static final int akp = t.aE("frma");
    public static final int akq = t.aE("saiz");
    public static final int akr = t.aE("saio");
    public static final int aks = t.aE("sbgp");
    public static final int akt = t.aE("sgpd");
    public static final int aku = t.aE("uuid");
    public static final int akv = t.aE("senc");
    public static final int akw = t.aE("pasp");
    public static final int akx = t.aE("TTML");
    public static final int aky = t.aE("vmhd");
    public static final int akz = t.aE("mp4v");
    public static final int ala = t.aE("vpcC");
    public static final int alb = t.aE("camm");
    public static final int alc = t.aE("alac");
    public final int type;

    public a(int i) {
        this.type = i;
    }

    public String toString() {
        return cu(this.type);
    }

    public static int cs(int i) {
        return (i >> 24) & 255;
    }

    public static int ct(int i) {
        return 16777215 & i;
    }

    public static String cu(int i) {
        return ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
