import View.LoginView;

import java.awt.*;

public class Main {
    public static void main(String args[]) throws Exception {
        LoginView loginView = new LoginView();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Exit");
                final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
                if (runnable != null)
                    runnable.run();
            }
        });
    }
}
