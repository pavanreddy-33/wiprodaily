package ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
    private Display display;

    @Autowired
    public Mobile(Display display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Mobile [display=" + display + "]";
    }
}
