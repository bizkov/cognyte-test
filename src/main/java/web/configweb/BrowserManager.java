package web.configweb;

public class BrowserManager {
    private BrowserDriver browserDriver;

    public BrowserDriver browserDriver() {
        return (browserDriver == null) ? new BrowserDriver() : browserDriver;
    }
}
