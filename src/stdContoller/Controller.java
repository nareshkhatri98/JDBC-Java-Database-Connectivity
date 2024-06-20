package stdContoller;

import stdEcp.Encp;
import stdUntil.Util;

public class Controller {

    private Util util;
    private Encp user;

    public Controller() {
        util = new Util();
    }

    public void addUser(int id, String username, String password) {

            user = new Encp(id, username, password);
            util.addUsertoDB(user);


        
    }
}
