package cn.abelib.basic.noname;

/**
 * Created by huangjianjin on 2017/7/22.
 */
public class Controller {
    public void invoke(int flag) {
        User user = new User();
        try {
            switch (flag) {
                case 0:
                    user.use(TestTest.class.getMethod("a", null));
                    break;
                default:
                    user.use(TestTest.class.getMethod("b", null));
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}