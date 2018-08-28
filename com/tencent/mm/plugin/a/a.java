package com.tencent.mm.plugin.a;

public class a {
    public static final int ajB = c.aE("ac-3");
    public static final int ajC = c.aE("dac3");
    public static final int ajD = c.aE("ec-3");
    public static final int ajE = c.aE("dec3");
    public static final int ajF = c.aE("dtsc");
    public static final int ajG = c.aE("dtsh");
    public static final int ajH = c.aE("dtsl");
    public static final int ajI = c.aE("dtse");
    public static final int ajJ = c.aE("ddts");
    public static final int ajK = c.aE("tfdt");
    public static final int ajL = c.aE("tfhd");
    public static final int ajM = c.aE("trex");
    public static final int ajN = c.aE("trun");
    public static final int ajO = c.aE("sidx");
    public static final int ajP = c.aE("moov");
    public static final int ajQ = c.aE("mvhd");
    public static final int ajR = c.aE("trak");
    public static final int ajS = c.aE("mdia");
    public static final int ajT = c.aE("minf");
    public static final int ajU = c.aE("stbl");
    public static final int ajV = c.aE("avcC");
    public static final int ajW = c.aE("hvcC");
    public static final int ajX = c.aE("esds");
    public static final int ajY = c.aE("moof");
    public static final int ajZ = c.aE("traf");
    public static final int ajo = c.aE("ftyp");
    public static final int ajp = c.aE("avc1");
    public static final int ajq = c.aE("avc3");
    public static final int ajr = c.aE("hvc1");
    public static final int ajs = c.aE("hev1");
    public static final int ajt = c.aE("s263");
    public static final int aju = c.aE("d263");
    public static final int ajv = c.aE("mdat");
    public static final int ajw = c.aE("mp4a");
    public static final int ajy = c.aE("wave");
    public static final int akA = c.aE("stts");
    public static final int akB = c.aE("stss");
    public static final int akC = c.aE("ctts");
    public static final int akD = c.aE("stsc");
    public static final int akE = c.aE("stsz");
    public static final int akG = c.aE("stco");
    public static final int akH = c.aE("co64");
    public static final int akI = c.aE("tx3g");
    public static final int akJ = c.aE("wvtt");
    public static final int akK = c.aE("stpp");
    public static final int akM = c.aE("samr");
    public static final int akN = c.aE("sawb");
    public static final int akO = c.aE("udta");
    public static final int akP = c.aE("meta");
    public static final int akQ = c.aE("ilst");
    public static final int akR = c.aE("mean");
    public static final int akS = c.aE("name");
    public static final int akT = c.aE("data");
    public static final int aka = c.aE("mvex");
    public static final int akc = c.aE("tkhd");
    public static final int akd = c.aE("edts");
    public static final int ake = c.aE("elst");
    public static final int akf = c.aE("mdhd");
    public static final int akg = c.aE("hdlr");
    public static final int akh = c.aE("stsd");
    public static final int aki = c.aE("pssh");
    public static final int akj = c.aE("sinf");
    public static final int akk = c.aE("schm");
    public static final int akl = c.aE("schi");
    public static final int akm = c.aE("tenc");
    public static final int akn = c.aE("encv");
    public static final int ako = c.aE("enca");
    public static final int akp = c.aE("frma");
    public static final int akq = c.aE("saiz");
    public static final int akr = c.aE("saio");
    public static final int aku = c.aE("uuid");
    public static final int akv = c.aE("senc");
    public static final int akw = c.aE("pasp");
    public static final int akx = c.aE("TTML");
    public static final int aky = c.aE("vmhd");
    public static final int akz = c.aE("mp4v");
    public static final int eyt = c.aE("----");
    private int eyu;
    private long eyv;
    public long eyw;
    private int type;

    public a(int i, long j, int i2, long j2) {
        this.eyu = i;
        this.eyw = j;
        this.type = i2;
        this.eyv = j2;
    }

    public final boolean VJ() {
        return this.type == ajP;
    }

    public final boolean VK() {
        return this.eyu == 0;
    }

    public final long VL() {
        return this.eyw + getSize();
    }

    public final long getSize() {
        if (this.eyv > 0) {
            return this.eyv;
        }
        return (long) this.eyu;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Atom{atomSize=").append(this.eyu).append(", atomLargeSize=").append(this.eyv).append(", type=");
        int i = this.type;
        return append.append(new String(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)})).append(", beginPos=").append(this.eyw).append('}').toString();
    }
}
