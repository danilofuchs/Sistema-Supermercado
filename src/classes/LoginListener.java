package classes;

import java.util.EventListener;

public interface LoginListener extends EventListener {
    public void handleLoginEvent(LoginEvent evt);
}
