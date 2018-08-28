package c.t.m.g;

public enum dg$b {
    Normal,
    Daemon,
    Single,
    Stop;

    static {
        Normal = new dg$b("Normal", 0);
        Daemon = new dg$b("Daemon", 1);
        Single = new dg$b("Single", 2);
        Stop = new dg$b("Stop", 3);
        dg$b[] dg_bArr = new dg$b[]{Normal, Daemon, Single, Stop};
    }
}
